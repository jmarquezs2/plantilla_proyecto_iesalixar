package org.jmarquezs.main;

import org.jmarquezs.DAO.NoteDAOimpl;
import org.jmarquezs.DAO.UsuarioDAOimpl;
import org.jmarquezs.model.Content;

public class Main {

	public static void main(String[] args) {


		UsuarioDAOimpl.register("pepito@gmail.com", "pepito", "Pepe");
		UsuarioDAOimpl.register("root@gmail.com", "root", "root");
		UsuarioDAOimpl.register("juan@gmail.com", "juan12", "Juan");
		UsuarioDAOimpl.changePassword("juan@gmail.com", "juan123",  "juan123");
		System.out.println(UsuarioDAOimpl.readRol("pepito@gmail.com"));
		Content cont = NoteDAOimpl.createContent("x=2*3", "formula");
		Content cont2 = NoteDAOimpl.createContent("https://www.filmaffinity.com/es/main.html", "link");
		NoteDAOimpl.createNote(1, "Prueba", "Fisica", "Leyes", "hola hola", cont, cont2, "pepito@gmail.com");
		Content cont3 = NoteDAOimpl.createContent("V=ab*h", "formula");
		NoteDAOimpl.createNote(1, "Volumen", "Matematicas", "Volumenes", "hola hola", cont3, null, "pepito@gmail.com");
		Content cont4 = NoteDAOimpl.createContent("g=9,8", "formula");
		NoteDAOimpl.createNote(1, "Gravedad", "Fisica", "Fuerzas", "hola hola", cont4, null, "pepito@gmail.com");
		
		//Content cont5 = NoteDAOimpl.createContent("v=e/t", "formula");
		//NoteDAOimpl.createNote(1, "Velocidad", "Fisica", "Movimiento", "La velocidad", cont5, null, "juan@gmail.com");
	}

}
