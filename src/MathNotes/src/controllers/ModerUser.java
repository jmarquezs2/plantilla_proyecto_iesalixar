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
import org.jmarquezs.logger.TipoLog;
import org.jmarquezs.logger.UtilesLog;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;

public class ModerUser extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		if ( session.getAttribute("Rol").equals("user")) {
			response.sendRedirect("/MathNotes/Notes");
		}else {
			
			String user =  request.getParameter("userEmail");
			if(user != null ) {
				UsuarioDAOimpl.changeBanned(user);
			}
		
			
			List<User> usuriolist = UsuarioDAOimpl.userAll();
	
		
			session.setAttribute("userioList", usuriolist);
			
						 
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/usuarios.jsp");
			rd.forward(request, response);

		}
		
	}
}
