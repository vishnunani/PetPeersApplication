package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.GetPetsDao;
import com.model.Pets;

@Service
public class GetPetsServiceImpl implements GetPetsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetPetsServiceImpl.class);
	@Autowired
	GetPetsDao getPetsDao;

	public List<Pets> getPetDetails() {
		LOGGER.info("go to get pet dao");
		return getPetsDao.getPetsFromDb();
	}
	

}
