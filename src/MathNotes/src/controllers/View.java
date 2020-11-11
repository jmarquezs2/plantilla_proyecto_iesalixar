package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jmarquezs.DAO.ContentDAOimpl;
import org.jmarquezs.DAO.NoteDAOimpl;

public class View extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);

		int id = Integer.parseInt(request.getParameter("id"));
		
		
		session.setAttribute("note", NoteDAOimpl.bringBackNote(id));
		session.setAttribute("num", NoteDAOimpl.numberUser(id));
		session.setAttribute("listContent", ContentDAOimpl.contentsToId(id));
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/note.jsp");
		rd.forward(request, response);

	}
}
