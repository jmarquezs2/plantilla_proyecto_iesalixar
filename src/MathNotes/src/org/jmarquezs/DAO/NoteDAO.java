package org.jmarquezs.DAO;

import java.util.List;
import java.util.Set;

import org.jmarquezs.model.Content;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;

public interface NoteDAO {

	
	public static Content createContent(String essence){
		return null;
		}
	
	public static void createNote(int visibility, String title, String subject, String temary, String description,
			Content cont, Content link, Content images[], String email) {
	}
	public static List<Note> notesOfUser(String email) {
		return null;
	}
	
	public static Set<String> subjectOfUser(String email) {
		return null;
	}
}
