package org.jmarquezs.DAO;

import java.util.List;

import org.jmarquezs.model.User;

public interface UsuarioDAO {
	public static boolean readUser(String email, String password) {
		return false;
	}
	public static String readRol(String usuario) {
		return null;
	}
	public static void changeRol(String rol, String email) {
		
	}
	public static void changeBanned(String email) {
		
	}
	public static void register(String email, String password, String name) {
	}
	
	public static boolean readUserIfExist(String email) {
		return false;
	}
	public static boolean changePassword(String email,String newPassword,String newPassword2) {
		return false;
	}
	public static User bringBackUser(String email) {
		return null;
	}
	public static List<User> userAll() {
		return null;
	}
}
