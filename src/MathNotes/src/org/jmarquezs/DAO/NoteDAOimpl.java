package org.jmarquezs.DAO;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import org.jmarquezs.helper.HibernateUtil;
import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;

public class NoteDAOimpl implements NoteDAO {

	public static void createNote(int visibility, String title, String subject, String temary, String description,
			Content cont, Content link, Content img, String email) {
		Session session = null;
		Transaction transaction = null;
		Note note = null;
		User user = null;
		user = UsuarioDAOimpl.bringBackUser(email);
		Set<Content> contents = new HashSet<Content>();
		Set<Note> notes = new HashSet<Note>();
		Set<User> users = new HashSet<User>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// Create
			note = new Note(title, visibility, 1, user.getId(), description, subject, temary);
			if (cont != null) {
				contents.add(cont);
			}
			if (link != null) {
				contents.add(link);
			}
			if (img != null) {
				contents.add(img);
			}
			note.setContents(contents);
			users = note.getUsers();
			users.add(user);
			note.setUsers(users);
			notes = user.getNotes();
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
	public static void updateNote(int visibility, String title, String subject, String temary, String description,
			Content cont, Content link, Content img, Note noteOld) {
		Session session = null;
		Transaction transaction = null;
		Note note = null;
		Set<Content> contents = new HashSet<Content>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// Create
			note = new Note(title, visibility, 1, 0, description, subject, temary);
				
			if (cont != null) {
				contents.add(cont);
			}
			if (link != null) {
				contents.add(link);
			}
			if (img != null) {
				contents.add(img);
			}
			noteOld.setContents(contents);
			noteOld.setDescription(note.getDescription());
			noteOld.setTitle(note.getTitle());
			noteOld.setVisibility(note.getVisibility());
			noteOld.setSubject(note.getSubject());
			noteOld.setTemary(note.getTemary());
			session.saveOrUpdate(noteOld);
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

	public static Set<Note> notesOfUser(String email) {

		
		Set<Note> list = new HashSet<>();
		list = UsuarioDAOimpl.bringBackUser(email).getNotes();
		Session session = null;
		Transaction transaction = null;
		try {
			/*session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// "SELECT p FROM Note p where User_ID="+id+""

			list.addAll(session.createQuery("SELECT p FROM Note p where User_ID=" + id + "", Note.class).list());*/
			
			

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
	
	public static List<Note> notesAll() {

		
		List<Note> list = new ArrayList<Note>();

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// "SELECT p FROM Note p where User_ID="+id+""

			list.addAll(session.createQuery("SELECT p FROM Note p ", Note.class).list());

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

		Set<Note> list = new HashSet<>();
		Set<String> subject = new TreeSet<String>();
		list = UsuarioDAOimpl.bringBackUser(email).getNotes();
		for (Note note : list) {
	        subject.add(note.getSubject());
	     }
		
		System.out.println(list.toString());

		return subject;
	}
	public static Set<String> subjectAll() {

		

		Set<String> list = new TreeSet<String>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// "SELECT p FROM Note p where User_ID="+id+""

			list.addAll(session.createQuery("SELECT p.subject FROM Note p").list());

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

	public static Note bringBackNote(int id) {

		Note note = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			note = (Note) session.createQuery("From Note u where u.id =:id").setParameter("id", id).uniqueResult();

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

		return note;
	}
	
	public static int numberUser(int id) {
		int num=0;
		Note note=null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			note=(Note) session.createQuery("From Note u where u.id =:id").setParameter("id", id).uniqueResult();
			num=note.getUsers().size();

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
		
		return num;
		
	}

}
