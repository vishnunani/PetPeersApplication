package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.model.User;

@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	LoginDao loginDao = new LoginDaoImpl();
	public User loginValidate(User user) {
		
		User dbUser = loginDao.getUserDetails(user);
		if(dbUser!=null) {
			LOGGER.info("user verified");
			return dbUser;
			
		}
		LOGGER.info("wrong user");
		return null;
	}

}
