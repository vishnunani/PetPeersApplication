package com.dao;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class RegisterDaoImpl implements RegisterDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public String getNewUserDetails(User user) {
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = " from User where userName =:userName";
		User userdb = (User) session.createQuery(SQL_QUERY).setParameter("userName", user.getUserName()).uniqueResult();
		if ((userdb == null)) {
			session.save(user);
			LOGGER.info("success");
			return "success";
		}
		
		return "failed";
	}

}
