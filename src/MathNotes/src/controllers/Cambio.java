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

public class Cambio extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");
		String newPassword2 = request.getParameter("newPassword2");
		System.out.println(newPassword);
		System.out.println(newPassword2);
		
		if(UsuarioDAOimpl.changePassword(email,newPassword,newPassword2)) {
			response.sendRedirect("/Mat_Notes/Notes");
		}else {
			response.sendRedirect("/Mat_Notes/NewPassword");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("jsp/registrados/cambio.jsp");
		rd.forward(request, response);

	}

}
