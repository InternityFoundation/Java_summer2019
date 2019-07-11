package com.jwt.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.jwt.hibernate.bean.User;

public class UserDAO {
	 

	public void addUserDetails(String name, String address, String phone,String email, String exp) {
		// TODO Auto-generated method stub
		try {
            // 1. configuring hibernate
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(User.class).buildSessionFactory();	
            Configuration configuration = new Configuration().configure();
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setAddress(address);
            user.setPhoneNo(phone);
            user.setEmail(email);
            user.setExp(exp);
            session.save(user);
            transaction.commit();
            System.out.println("\n\n Details Added \n");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
		
	}
	 

}
