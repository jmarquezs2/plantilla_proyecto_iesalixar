package org.jmarquezs.DAO;

import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

	public static String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public static Content writeImage(Part file, PrintWriter wr) throws IOException {
		Content img = null;
		if (file.getSize() > 0) {

			if (file.getContentType().contains("image") == false || file.getSize() > 8388608) {
				// TIPO DE ARCHIVO NO VALIDO
				img = null;
			} else {
				// C:\\Users\\Usuario\\ProyectoEclipse2\\MathNotes\\WebContent\\img\\notesImage
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				String path = "\\img\\notesImage";
				// final String path="\\MathNotes\\WebContent\\img\\notesImage";
				final Part filePart = file;
				final String fileName = ContentDAOimpl.getFileName(filePart);

				OutputStream out = null;
				InputStream filecontent = null;
				final PrintWriter writer = wr;

				try {
					out = new FileOutputStream(new File(path + File.separator + fileName));
					filecontent = filePart.getInputStream();

					int read = 0;
					final byte[] bytes = new byte[1024];

					while ((read = filecontent.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
					System.out.println("New file " + fileName + " created at " + path);
					img = new Content(path + fileName, "img");
				} catch (FileNotFoundException fne) {
					System.out.println("You either did not specify a file to upload or are "
							+ "trying to upload a file to a protected or nonexistent " + "location.");
					System.out.println("<br/> ERROR: " + fne.getMessage());

				} finally {
					if (out != null) {
						out.close();
					}
					if (filecontent != null) {
						filecontent.close();
					}
					if (writer != null) {
						writer.close();
					}
				}

			}

		}
		return img;
	}
	
	public static List<Content> contentsToId(int id){
		
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
