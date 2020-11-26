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
			found = (User) session.createQuery("From User u where u.email =:email and u.password =:password")
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
			rol = ((User) session.createQuery("From User u where u.email =: email").setParameter("email", email)
					.uniqueResult()).getRol();

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
	public static void changeRol(String rol, String email) {
		Session session = null;
		Transaction transaction = null;
		User user = bringBackUser(email);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			user.setRol(rol);
			session.saveOrUpdate(user);
			transaction.commit();

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
		
	}

	public static void register(String email, String password, String name) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// Create
			User us = new User(name, email, password, "user");
			session.save(us);
			transaction.commit();

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
	}

	public static boolean readUserIfExist(String email) {

		User found = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			found = (User) session.createQuery("From User u where u.email =:email").setParameter("email", email)
					.uniqueResult();

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

	public static boolean changePassword(String email,String newPassword,String newPassword2) {
		
		boolean done=false;
		
			if(newPassword.equals(newPassword2)) {
				User found = null;
				Session session = null;
				Transaction transaction = null;
				try {
					session = HibernateUtil.getSessionFactory().openSession();
					transaction = session.beginTransaction();
					found = (User) session.createQuery("From User u where u.email =:email").setParameter("email", email)
							.uniqueResult();
					System.out.println(found.getPassword());
					found.setPassword(newPassword);
					session.saveOrUpdate(found);
					transaction.commit();
					System.out.println(found.getPassword());
					done= true;
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
				
			}
			
		
		
		return done;
		
	}
	
	public static User bringBackUser(String email) {
		User found = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			found = (User) session.createQuery("From User u where u.email =:email").setParameter("email", email)
					.uniqueResult();

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
		return found;
	}
}
