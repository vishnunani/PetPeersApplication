package com.dao;


import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class BuyPetDaoImpl implements BuyPetDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(BuyPetDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public String buyPetDb(int petId, int userId) {
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = "update Pets set userId=:userId where petId=:petId";
		int rows = session.createQuery(SQL_QUERY).setParameter("userId", userId).setParameter("petId", petId).executeUpdate();
		if ((rows != 0)) {
			LOGGER.info("success");
			return "success";
		}
		
		return "success";
	}

}
