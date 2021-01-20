package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Pets;
import com.model.User;
import com.service.AddPetService;
import com.service.BuyPetService;
import com.service.GetPetsService;
import com.service.LoginService;
import com.service.MyPetsService;
import com.service.RegisterService;

@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;
	@Autowired
	RegisterService registerService;
	@Autowired
	AddPetService addPetService;
	@Autowired
	GetPetsService getPetsService;
	@Autowired
	BuyPetService buyPetService;
	@Autowired
	MyPetsService myPetsService;
	
	@RequestMapping(value={"Login"})
	public String loginPageLoad(@ModelAttribute("user") User user) {
		LOGGER.info("login started.");
		return "LoginPage";
	}
	@RequestMapping(value={"RegisterPage"})
	public String registerPageLoad(@ModelAttribute("user") User user) {
		LOGGER.info("REgistering started.");
		return "Register";
	}
	@RequestMapping(value={"AddPetPage"})
	public String addPetPageLoad(@ModelAttribute("pet") Pets pet) {
		LOGGER.info("In Add Pet Page.");
		return "AddPet";
	}
	@RequestMapping(value= {"MyPets"})
	public String myPetPage(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("validUser");
		int userId = user.getUserId();
		List<Pets> pets = myPetsService.getMyPets(userId);
		model.addAttribute("pets",pets);
		return "MyPet";
	}
	@RequestMapping(value={"LoginValidate"},method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request,Model model) {
		User validUser = loginService.loginValidate(user);
		
		if((result.hasErrors()==false) &&  validUser!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("validUser",  validUser);
			model.addAttribute(session.getAttribute("validUser"));
						return "redirect:Profile";
		}
		model.addAttribute("message","invalid credentials");
		return "LoginPage";
	}
	
	@RequestMapping(value={"/Register"},method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user,BindingResult result,Model model,RedirectAttributes redirectAttributes) {
		
		String registerResult = registerService.registerNewUser(user);
		if(user.getPassword().equals(user.getRepeatPassword())) {
		if(registerResult.equals("success")) {
			redirectAttributes.addFlashAttribute("message","successfully registered");
			LOGGER.info("Added user in register Page.");
			return "redirect:home";
		}
		else {
		model.addAttribute("message","user already exists");
		}
		}
		else {
			model.addAttribute("message","password and confirm password should be same");
		}
		return "Register";
	}
	
	@RequestMapping(value = {"AddPet"})
	public String addPet(@ModelAttribute("pet") Pets pet,BindingResult result,Model model,RedirectAttributes redirectAttributes,HttpServletRequest request) {
		
		
		HttpSession session = request.getSession(false);
		
		User user = (User) session.getAttribute("validUser");
		int userId = user.getUserId();
		
		String addResult = addPetService.registerNewPet(pet,userId);
		
		if(addResult.equals("success")) {
			redirectAttributes.addFlashAttribute("message","added successfully");
			return "redirect:Profile";
		}
		return "Profile";
	}
	
	@RequestMapping(value={"Logout"})
	public String logout(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		redirectAttributes.addFlashAttribute("message","you are successfully logged out");
		LOGGER.info("Logged out.");
		return "redirect:home";
	}
	@RequestMapping(value = "/Buy/{petId}")
	public String buy(@PathVariable("petId") int petId,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("validUser");
		int userId = user.getUserId();
		buyPetService.buyPet(petId, userId);
		redirectAttributes.addFlashAttribute("message","successfully bought a pet");
		return  "redirect:/Profile";
	}
	@RequestMapping(value = "/Profile")
	public String profile(Model model) {
		List<Pets> pets = getPetsService.getPetDetails();
		model.addAttribute("pets",pets);
		return "Profile";
	}
	@RequestMapping(value={"home"})
	public String home() {
		return "index";
	}

}
