package controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

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

@WebServlet("/MathNotes/Create")
@MultipartConfig
public class Create extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		String owner = (String) session.getAttribute("Email");
		int visibility = 1;
		Content cont = null;
		Content contentLink = null;
		Content contentImage = null;
		
		
		String vis = request.getParameter("visibility");
		if (vis == "y") {
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
		
		
		Part archivo = request.getPart("archivossubidos");
		String context = request.getServletContext().getRealPath("img/notesImage");
		
		contentImage = ContentDAOimpl.writeImage(context,archivo);
//		final PrintWriter writer = response.getWriter();
//		contentImage = ContentDAOimpl.writeImage(request.getPart("archivossubidos"), writer);

		NoteDAOimpl.createNote(visibility, title, subject, temary, description, cont, contentLink, contentImage, owner);

		response.sendRedirect("/MathNotes/Notes");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/create.jsp");
		rd.forward(request, response);

	}
}
