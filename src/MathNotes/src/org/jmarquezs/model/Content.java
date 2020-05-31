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
@Table(name = "content")
public class Content implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "essence")
	private String essence;

	@Column(name = "type")
	private String type;

	@ManyToOne
	@JoinColumn(name = "note_id")
	private Note note;

	public Content(String essence, String type) {
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

	public void setType(String type) {
		this.type = type;
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
