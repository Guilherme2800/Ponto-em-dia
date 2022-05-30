package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Guilherme2800
 *
 */
public class ConnectionFactory {

	private final static String USER = "root";
	private final static String PASSWORD = "BHU*nji9";
	private final static String URL = "jdbc:mysql://localhost:3306/PontoEmDia";
	
	private static Connection con;
	
	public static Connection conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return con;
		
	}
	
	public static void desconectar() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
