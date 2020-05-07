package org.jmarquezs.main;

import org.jmarquezs.DAO.UsuarioDAOimpl;

public class Main {

	public static void main(String[] args) {


		UsuarioDAOimpl.register("pepito@gmail.com", "pepito", "Pepe");
		UsuarioDAOimpl.register("root@gmail.com", "root", "root");
		UsuarioDAOimpl.register("juan@gmail.com", "juan12", "Juan");
		UsuarioDAOimpl.changePassword("juan@gmail.com", "juan123",  "juan123");
		System.out.println(UsuarioDAOimpl.readRol("pepito@gmail.com"));
	
	}

}
