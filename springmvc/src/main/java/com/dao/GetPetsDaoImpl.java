package com.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Pets;


@Repository
public class GetPetsDaoImpl implements GetPetsDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetPetsDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Pets> getPetsFromDb() {
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = "from Pets";
		List<Pets> pets = session.createQuery(SQL_QUERY).list();
		System.out.println(pets);
		if ((pets != null)) {
			LOGGER.info("return pets");
			return pets;
		}
	
		return null;
	}

}
