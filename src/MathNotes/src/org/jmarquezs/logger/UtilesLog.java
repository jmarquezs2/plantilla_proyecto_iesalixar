package org.jmarquezs.logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;
public class UtilesLog {

	private static Logger log = Logger.getLogger(UtilesLog.class);

	@SuppressWarnings("rawtypes")
	public static void registrarInfo(Class clase, TipoLog tipo, String mensaje)
	{
	 log = LogManager.getLogger(clase);
	 
	 switch (tipo) 
	 {
	  case DEBUG:
	   log.debug(mensaje);
	   break;
	  case ERROR:
	   log.error(mensaje);
	   break;
	  case FATAL:
	   log.fatal(mensaje);
	   break;
	  case INFO:
		  System.out.println("log hecho");
	   log.info(mensaje);
	   break;
	  case WARNING:
	   log.warn(mensaje);
	 }
	}
	public static String loginMensaje(User user) {
		String mensaje = "El usuario con nombre: "+user.getName()+", con rol "+user.getRol()+" ha iniciado sesíon. \r\n";
		return mensaje;
	}
	public static String logModer(Note note, String vote) {
		String mensaje = "El apunte con título: "+note.getTitle()+", ha sido supervisado por el moderador con un '"+vote+". \r\n";
		return mensaje;
	}
}
