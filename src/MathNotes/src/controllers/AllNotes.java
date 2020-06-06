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
import org.jmarquezs.model.Note;

public class AllNotes extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
	
	
		List<Note> list = NoteDAOimpl.notesAll();
		Set<String> subjects = NoteDAOimpl.subjectAll();
		
		 session.setAttribute("allNotes", list);
		 session.setAttribute("allSubjects", subjects);
		 
		RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/allNotes.jsp");
		rd.forward(request, response);

	}
}