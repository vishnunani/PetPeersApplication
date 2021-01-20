package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RegisterDao;
import com.model.User;

@Service
public class RegisterServiceImpl implements RegisterService{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);
	@Autowired
	RegisterDao registerDao;
	
	public String registerNewUser(User user) {
		LOGGER.info("go to register pet dao");
		return registerDao.getNewUserDetails(user);
	}
	
	

}
