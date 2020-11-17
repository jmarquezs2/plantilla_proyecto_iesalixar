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

import org.jmarquezs.DAO.NoteDAOimpl;
import org.jmarquezs.DAO.UsuarioDAOimpl;
import org.jmarquezs.model.Note;

public class Notes extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
	String owner = (String) session.getAttribute("Email");
	
		Set<Note> list = NoteDAOimpl.notesOfUser(owner);
		Set<String> subjects = NoteDAOimpl.subjectOfUser(owner);
		int id = UsuarioDAOimpl.bringBackUser(owner).getId();
		session.setAttribute("owner", id);
		 session.setAttribute("list", list);
		 session.setAttribute("subjects", subjects);
		 
		RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/notes.jsp");
		rd.forward(request, response);

	}
}
