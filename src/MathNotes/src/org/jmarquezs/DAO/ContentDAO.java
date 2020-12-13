package org.jmarquezs.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Part;

import org.jmarquezs.model.Content;

public interface ContentDAO {
	public static Content createContent(String essence,String type){
	return null;
	}
	
	
	public static Content writeImage(String context, Part archivo) throws IOException {
		return null;
		
	}
	public static List<Content> contentsToId(int id) {
		return null;
	}
}
