package org.jmarquezs.main;

import java.io.File;

import org.jmarquezs.DAO.ContentDAOimpl;
import org.jmarquezs.DAO.NoteDAOimpl;
import org.jmarquezs.DAO.UsuarioDAOimpl;
import org.jmarquezs.model.Content;

public class Main {

	public static void main(String[] args) {


		UsuarioDAOimpl.register("pepito@gmail.com", "pepito", "Pepe");
		UsuarioDAOimpl.register("root@gmail.com", "root", "root");
		UsuarioDAOimpl.changeRol("root", "root@gmail.com");
		UsuarioDAOimpl.register("juan@gmail.com", "juan12", "Juan");
		UsuarioDAOimpl.changePassword("juan@gmail.com", "juan123",  "juan123");
		System.out.println(UsuarioDAOimpl.readRol("pepito@gmail.com"));
		
		//Visibility 1 --> Público
		Content cont = ContentDAOimpl.createContent("x=2*3", "formula");
		Content cont2 = ContentDAOimpl.createContent("https://www.filmaffinity.com/es/main.html", "link");
		NoteDAOimpl.createNote(1, "Prueba", "Física", "Leyes", "hola hola", cont, cont2,null, "root@gmail.com");
		
		Content cont3 = ContentDAOimpl.createContent("V=ab*h", "formula");
		NoteDAOimpl.createNote(1, "Volumen", "Matemáticas", "Volumenes", "hola hola", cont3, null,null, "root@gmail.com");
		
		Content cont4 = ContentDAOimpl.createContent("g=9,8", "formula");
		NoteDAOimpl.createNote(1, "Gravedad", "Física", "Fuerzas", "hola hola", cont4, null, null, "root@gmail.com");
		
		Content cont5 = ContentDAOimpl.createContent("v=e/t", "formula");
		NoteDAOimpl.createNote(1, "Velocidad", "Física", "Movimiento", "La velocidad", cont5, null,null, "root@gmail.com");
		
		Content cont6 = ContentDAOimpl.createContent("v=e/t", "formula");
		Content cont8 = ContentDAOimpl.createContent("madera.jpg", "img");
		NoteDAOimpl.createNote(1, "prueba2", "Física", "hola", "La velocidad 3", cont6, null,cont8, "root@gmail.com");
		
		Content cont7 = ContentDAOimpl.createContent("v=e/t", "formula");
		
//		NoteDAOimpl.createNote(1, "Imagen", "Química", "hola", "La velocidad 3", cont7, null,cont8, "root@gmail.com");
		Content cont9 = ContentDAOimpl.createContent("tablaPeriodica.png", "img");
		NoteDAOimpl.createNote(1, "Img", "Química", "hola", "La velocidad 4", cont7, null,cont9, "root@gmail.com");
		
		//System.out.println(NoteDAOimpl.subjectOfUser("pepito@gmail.com").toString());
		
	}

}
