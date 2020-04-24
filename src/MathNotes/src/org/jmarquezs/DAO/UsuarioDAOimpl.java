package org.jmarquezs.DAO;

import org.jmarquezs.helper.HibernateUtil;
import org.jmarquezs.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

public class UsuarioDAOimpl implements UsuarioDAO {

	public static boolean readUser(String email, String password) {
		
		User found = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			found = (User) session
					.createQuery("From Usuer u where u.email =:email and u.password =:password")
					.setParameter("email", email).setParameter("password", password).uniqueResult();

		} catch (ConstraintViolationException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return (found == null) ? false : true;
	}
	
	public static String readRol(String email) {
		System.out.println(email);
		String rol = "";

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			rol = ((User) session.createQuery("From User u where u.email =: email")
					.setParameter("email", email).uniqueResult()).getRol();

		} catch (ConstraintViolationException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rol;
	}
	
}
