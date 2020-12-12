package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jmarquezs.DAO.UsuarioDAOimpl;
import org.jmarquezs.logger.TipoLog;
import org.jmarquezs.logger.UtilesLog;


public class Login extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Cookie loginCookie = null;
		if (UsuarioDAOimpl.readUser(email, password)) {
			HttpSession session = request.getSession();
			loginCookie = new Cookie("email", email);
			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);

			session.setAttribute("Rol", UsuarioDAOimpl.readRol(email));
			session.setAttribute("Email", email);
			//String context = request.getServletContext().getRealPath("logs");
			String mensaje = UtilesLog.loginMensaje(UsuarioDAOimpl.bringBackUser(email));
			UtilesLog.registrarInfo(this.getClass(), TipoLog.INFO, mensaje);
			System.out.println(UsuarioDAOimpl.readRol(email));
				if ( UsuarioDAOimpl.readRol(email).equals("user")) {
					response.sendRedirect("/MathNotes/Notes");
				}else {
					response.sendRedirect("/MathNotes/Moderacion");
				}
			
			// RequestDispatcher rd=request.getRequestDispatcher("templates/start.jsp");
			// rd.forward(request,response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/MathNotes/Login");
			rd.include(request, response);
		}
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("jsp/index.jsp");
		rd.forward(request, response);

	}
}
