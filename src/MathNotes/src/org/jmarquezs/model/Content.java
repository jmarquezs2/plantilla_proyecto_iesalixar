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
	
	@Column(name = "image")
	private int image;
	
	
	@ManyToOne
    @JoinColumn(name="note_id", nullable=false)
    private Note note;


	public Content(int id, String essence, int image, Note note) {
		super();
		this.id = id;
		this.essence = essence;
		this.image = image;
		this.note = note;
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

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}
	
	
	/*
	 * En construcción 
	 */

}
