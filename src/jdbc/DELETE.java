package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DELETE {

	public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
        
               
        try {
        	// Charger le pilote
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	// Etablir la connexion à la DB
        	Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        	
        	// Requête d'insertion
        	int id = 0;
        	String sql = "DELETE FROM etudiants WHERE `id`="+id;
        	
        	PreparedStatement prepState = conn.prepareStatement(sql);
        	
        	// Excécuter
        	int lignesAffectees = prepState.executeUpdate();
        	
        	if(lignesAffectees > 0) {
        		System.out.println("La suppression a réussi");
        	}else {
        		System.out.println("La suppression a échoué");
        		prepState.close();
        		conn.close();
        	}
        	
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
	}
}
