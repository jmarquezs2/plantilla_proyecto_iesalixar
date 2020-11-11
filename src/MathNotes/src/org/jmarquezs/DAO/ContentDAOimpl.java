package org.jmarquezs.DAO;

import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;

import controllers.Create;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.MapKeyClass;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.jmarquezs.helper.HibernateUtil;

public class ContentDAOimpl implements ContentDAO {

	public static Content createContent(String essence, String type) {
		Session session = null;
		Transaction transaction = null;
		Content cont = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// Create
			cont = new Content(essence, type);
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

	

	public static Content writeImage(String context, Part archivo) throws IOException {
		Content img = null;
		String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString(); 
		archivo.write(context + File.separator + foto);
		img = createContent(foto, "img");
		return img;
	}

	public static List<Content> contentsToId(int id) {

		List<Content> list = new ArrayList<Content>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			list.addAll(session.createQuery("SELECT p FROM Content p where note_id=" + id + "", Content.class).list());

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
		return list;
	}
}
