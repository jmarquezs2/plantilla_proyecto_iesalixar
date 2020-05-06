package org.jmarquezs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Note")
public class Note implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "visibility")
	private int visibility;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "temary")
	private String temary;
	
	/*
	 * En construcción 
	 */
}
