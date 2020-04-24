package org.jmarquezs.model;

public class User {

	
	private String name;
	private String email;
	private String password;
	private String rol;
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, String rol) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
