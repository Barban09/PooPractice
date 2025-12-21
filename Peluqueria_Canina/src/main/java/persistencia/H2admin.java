package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.tools.Server;

public class H2admin {

	public static void connect() throws SQLException {
        System.out.println("Iniciando consola H2...");
        try {
        	Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            Connection conn = DriverManager.getConnection(
                    "jdbc:h2:~/peluqueriacanina",
                    "sa",
                    ""
            );

        	System.out.println("Consola lista en: http://localhost:8082");
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
	}

}
