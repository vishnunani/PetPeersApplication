package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MyPetsDao;
import com.model.Pets;

@Service
public class MyPetsServiceImpl implements MyPetsService{
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPetsServiceImpl.class);
	@Autowired
	MyPetsDao myPetsDao;
	public List<Pets> getMyPets(int userId) {
		LOGGER.info("go to my pets dao");
		return myPetsDao.getMyPetsDb(userId);
	}

}
