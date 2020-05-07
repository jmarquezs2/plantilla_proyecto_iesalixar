package org.jmarquezs.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "Note")
@Data
public class Note implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "visibility")
	private int visibility;
	
	@Column(name = "validate")
	private int validate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "temary")
	private String temary;
	
	
	 @OneToMany(mappedBy="note")
	    private Set<Content> Contents;
	 
		@ManyToOne
	    @JoinColumn(name="user_id", nullable=false)
	    private User user;


	
	 
	 
	 public Note(int id, String title, int visibility, int validate, String description, String subject,
				String temary, Set<Content> contents, User user) {
			super();
			this.id = id;
			this.title = title;
			this.visibility = visibility;
			this.validate = validate;
			this.description = description;
			this.subject = subject;
			this.temary = temary;
			Contents = contents;
			this.user = user;
		}


	public Note() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getValidate() {
		return validate;
	}


	public void setValidate(int validate) {
		this.validate = validate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getVisibility() {
		return visibility;
	}


	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getTemary() {
		return temary;
	}


	public void setTemary(String temary) {
		this.temary = temary;
	}


	public Set<Content> getContents() {
		return Contents;
	}


	public void setContents(Set<Content> contents) {
		Contents = contents;
	}
	 
	 
	/*
	 * En construcción 
	 */
}
