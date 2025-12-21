package PracticaProyectoPeluqueriaCanina.Main;

import java.sql.SQLException;
import igu.Principal;
import persistencia.H2admin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        
        
	    try {	
	    	H2admin.connect();  	
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
    }
}
