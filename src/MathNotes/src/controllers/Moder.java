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
import org.jmarquezs.model.User;

public class Moder extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		if ( session.getAttribute("Rol").equals("user")) {
			response.sendRedirect("/MathNotes/Notes");
		}else {
			String id = request.getParameter("id");
			String vote = request.getParameter("vote");
			String owner = (String) session.getAttribute("Email");
			if(id != null && vote !=null) {
				Note note= NoteDAOimpl.bringBackNote(Integer.parseInt(id));
				NoteDAOimpl.voteNote(note, vote);//metodo para validar
			}
		
			Set<Note> userList = UsuarioDAOimpl.bringBackUser(owner).getNotes();
			List<Note> list = NoteDAOimpl.notesModer();
			Set<String> subjects = NoteDAOimpl.subjectAllModer();
			System.out.println(userList.toString());
			session.setAttribute("userList", userList);
			 session.setAttribute("allNotes", list);
			 session.setAttribute("allSubjects", subjects);
			 
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/moderacion.jsp");
			rd.forward(request, response);

		}
		
	}
}
