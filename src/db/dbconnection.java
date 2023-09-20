package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	private Connection conn;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc"; // URL de la base de données (changez-la en fonction de votre configuration)
    String user = "root"; // Nom d'utilisateur MySQL
    String password = ""; // Mot de passe MySQL
    
	public dbconnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
	
	public Connection getConnection() {
	     return conn;
	}
	
	   public void closeConnection() {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
