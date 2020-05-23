package org.jmarquezs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Content")
public class Content implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "essence")
	private String essence;
	
	@Column(name = "type")
	private String type;
	
	
	 @ManyToOne
		@JoinColumn(name = "Note_ID")
		private User note;



	public Content( String essence, String type) {
		super();
		
		this.essence = essence;
		this.type = type;
		
	}
	
	public Content() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEssence() {
		return essence;
	}

	public void setEssence(String essence) {
		this.essence = essence;
	}

	public String getType() {
		return type;
	}

	public void setImage(String type) {
		this.type = type;
	}

	public User getNote() {
		return note;
	}

	public void setNote(User note) {
		this.note = note;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	/*
	 * En construcción 
	 */

}
