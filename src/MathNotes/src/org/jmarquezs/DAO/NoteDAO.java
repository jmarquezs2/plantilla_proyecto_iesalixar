package org.jmarquezs.DAO;

import java.util.List;
import java.util.Set;

import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;

public interface NoteDAO {

	
	
	public static void createNote(int visibility, String title, String subject, String temary, String description,
			Content cont, Content link, Content img, String email) {
	}
	public static void saveNote(Note note, User user) {
	}
	
	public static void voteNote(Note note, String vote) {
		
	}
	public static void updateNote(int visibility, String title, String subject, String temary, String description,
			Content cont, Content link, Content img, Note noteOld) {
		
	}
	public static Set<Note> notesOfUser(String email) {
		return null;
	}
	public static List<Note> notesAll() {
		return null;
	}
	public static List<Note> notesModer() {
		return null;
	}
	public static Set<String> subjectOfUser(String email) {
		return null;
	}
	public static Set<String> subjectAll() {
		return null;
	}
	public static Set<String> subjectAllModer() {
		return null;
	}
	public static Note bringBackNote(int id) {
		return null;
	}
	public static int numberUser(int id) {
		return 0;
	}
}
