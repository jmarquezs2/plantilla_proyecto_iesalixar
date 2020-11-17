package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.jmarquezs.DAO.ContentDAOimpl;
import org.jmarquezs.DAO.NoteDAOimpl;
import org.jmarquezs.DAO.UsuarioDAOimpl;
import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;

public class AllNotes extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
		
		
		
		response.sendRedirect("/MathNotes/AllNotes");

	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		//String id = Integer.parseInt(request.getParameter("id"));
		String id = request.getParameter("id");
		String owner = (String) session.getAttribute("Email");
		if(id != null) {
			Note note= NoteDAOimpl.bringBackNote(Integer.parseInt(id));
			User user = UsuarioDAOimpl.bringBackUser((String) session.getAttribute("Email"));
			NoteDAOimpl.saveNote(note, user);
		}
	
		Set<Note> userList = UsuarioDAOimpl.bringBackUser(owner).getNotes();
		List<Note> list = NoteDAOimpl.notesAll();
		Set<String> subjects = NoteDAOimpl.subjectAll();
		System.out.println(userList.toString());
		session.setAttribute("userList", userList);
		 session.setAttribute("allNotes", list);
		 session.setAttribute("allSubjects", subjects);
		 
		RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/allNotes.jsp");
		rd.forward(request, response);

	}
}