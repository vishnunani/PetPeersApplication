package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.AddPetDao;
import com.model.Pets;

@Service
public class AddPetServiceImpl implements AddPetService{
	private static final Logger LOGGER = LoggerFactory.getLogger(AddPetServiceImpl.class);
	@Autowired
	AddPetDao addPetDao;
	public String registerNewPet(Pets pet,int userId) {
		LOGGER.info("gO TO REGISTER PET DAO.");
		return addPetDao.getNewPetDetails(pet,userId);
	}

}
