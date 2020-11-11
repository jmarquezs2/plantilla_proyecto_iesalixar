package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.jmarquezs.DAO.ContentDAOimpl;
import org.jmarquezs.DAO.NoteDAOimpl;
import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;

public class Edit extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		int id = Integer.parseInt(request.getParameter("id"));
		Note noteOld = NoteDAOimpl.bringBackNote(id);
		
		String owner = (String) session.getAttribute("Email");
		
		
		int visibility = 1;
		Content cont = null;
		Content contentLink = null;
		Content contentImage = null;

		String vis2 = request.getParameter("visibility2");
		if (vis2 == null) {
			visibility = 2;
		}

		String title = request.getParameter("title");
		String subject = request.getParameter("subject");
		String temary = request.getParameter("temary");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		if (content != null) {
			cont = ContentDAOimpl.createContent(content, "formula");
		}

		String link = request.getParameter("link");
		if (link != null && !(link.equals(""))) {
			contentLink = ContentDAOimpl.createContent(link, "link");
		}

//		final PrintWriter writer = response.getWriter();
//		Part file = request.getPart("archivossubidos");
//		if(file != null) {
//			contentImage = ContentDAOimpl.writeImage(file, writer);
//		}
		

		NoteDAOimpl.updateNote(visibility, title, subject, temary, description, cont, contentLink, contentImage, noteOld);

		response.sendRedirect("/MathNotes/Notes");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		int id = Integer.parseInt(request.getParameter("id"));

		session.setAttribute("note", NoteDAOimpl.bringBackNote(id));
		session.setAttribute("listContent", ContentDAOimpl.contentsToId(id));

		RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/edit.jsp");
		rd.forward(request, response);

	}

}
