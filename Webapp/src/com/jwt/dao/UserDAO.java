package com.jwt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

import com.jwt.bean.User;

public class UserDAO {


    Logger logger =Logger.getLogger(getClass().getName());
    
	public void addUserDetails(String name, String address, String phone, String email, String exp) {
		// TODO Auto-generated method stub

		// 1. configuring hibernate
		logger.info("Before factory");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		logger.info("After factory");
		// 3. Get Session object
		Session session = factory.getCurrentSession();

		try {
			// 4. Starting Transaction
			session.beginTransaction();
			User user = new User();
			user.setAddress(address);
			user.setEmail(email);
			user.setExp(exp);
			user.setName(name);
			user.setPhoneNo(phone);
			session.save(user);
			session.getTransaction().commit();
			System.out.println("\n\n Details Added \n");
			logger.info(">>>>>>>IN DAO");
			session.close();
		} catch (HibernateException e) {
			logger.info(">>>>>>>Exception in DAO");
		}
		finally {
			factory.close();
		}
	}

}
