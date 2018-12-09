package com.niraj.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niraj.model.User;
import com.niraj.util.HibernateUtil;

public class LoginService {
	
	

    public boolean authenticateUser(String userId, String password) {
        User user = getUserByUserId(userId);         
        if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

	public User getUserByUserId(String userId) {
		
		Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where userId='"+userId+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
	}
    
    

}
