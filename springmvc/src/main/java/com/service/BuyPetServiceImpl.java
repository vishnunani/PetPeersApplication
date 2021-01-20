package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.BuyPetDao;

@Service
public class BuyPetServiceImpl implements BuyPetService{
	private static final Logger LOGGER = LoggerFactory.getLogger(BuyPetServiceImpl.class);
	@Autowired
	BuyPetDao buyPetDao;

	public String buyPet(int petId, int userId) {
	LOGGER.info("gO to buy pet dao");
		return buyPetDao.buyPetDb(petId, userId);
	}
	
	
	
}
