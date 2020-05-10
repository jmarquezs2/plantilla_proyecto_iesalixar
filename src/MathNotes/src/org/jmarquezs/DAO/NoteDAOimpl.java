package org.jmarquezs.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.jmarquezs.helper.HibernateUtil;
import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;

public class NoteDAOimpl implements NoteDAO {

	
	public static Content createContent(String essence,String type){
		Session session = null;
		Transaction transaction = null;
		Content cont = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// Create
			cont = new Content(essence,type);
			session.save(cont);
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
		return cont;
		
	}
	
	public static void createNote(int visibility, String title, String subject, String temary, String description,
			Content cont, Content link, String email) {
		Session session = null;
		Transaction transaction = null;
		Note note = null;
		User user = null;
		List<Content> contents= new ArrayList();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// Create
			note = new Note( title, visibility, 1, description, subject, temary);
			if(cont!=null) {
				contents.add(cont);
			}
			if(link!=null) {
				contents.add(link);
			}
			note.setContents(contents);
			
			user = UsuarioDAOimpl.bringBackUser(email);
			user.getNotes().add(note);
			session.save(cont);
			session.update(user);
			
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
	
}
