package org.jmarquezs.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
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
		List<Content> contents= new ArrayList<Content>();
		List<Note> notes= new ArrayList<Note>();
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
			user=UsuarioDAOimpl.bringBackUser(email);
			notes=user.getNotes();
			notes.add(note);
			user.setNotes(notes);
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
	

	public static List<Note> notesOfUser(String email) {
		
		int id = UsuarioDAOimpl.bringBackUser(email).getId();
		List<Note> list = new ArrayList<Note>();

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			//"SELECT p FROM Note p where User_ID="+id+""
	
			list.addAll( session
					.createQuery("SELECT p FROM Note p where User_ID="+id+"",Note.class).list());
			
					
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
		System.out.println(list.toString());
		
		return list;
	}
	
public static Set<String> subjectOfUser(String email) {
		
	int id = UsuarioDAOimpl.bringBackUser(email).getId();

	 Set<String> list= new TreeSet<String>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			//"SELECT p FROM Note p where User_ID="+id+""
	
			list.addAll( session
					.createQuery("SELECT p.subject FROM Note p where User_ID="+id+"").list());
			
					
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
		System.out.println(list.toString());
		
		return list;
	}
	
}