package org.jmarquezs.DAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Part;

import org.jmarquezs.model.Content;

public interface ContentDAO {
	public static Content createContent(String essence,String type){
	return null;
	}
	
	public static String getFileName(final Part part) {
		return null;
		
	}
	
	public static Content writeImage(Part file, PrintWriter wr) throws IOException {
		return null;
		
	}
	
}
