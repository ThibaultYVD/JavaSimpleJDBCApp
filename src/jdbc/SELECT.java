package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SELECT {

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
        	
        	// Requête
        	String sql = "SELECT * FROM etudiants";
        	
        	
        	Statement stmt = conn.createStatement();
        	ResultSet res = stmt.executeQuery(sql);
        	
        	// Afficher les résultats
        	while (res.next()) {
        		  String resNom = res.getString("nom");
        		  String resPrenom = res.getString("prenom");
        		  String resDateNaissance = res.getString("date_naissance");
        		  String resEmail = res.getString("email");
        		  String resMatricule = res.getString("matricule");
        		  
        		  System.out.println("Nom : " + resNom + "\nPrenom : " + resPrenom + "\nDateNaissance : " + resDateNaissance + "\nEmail : " + resEmail + "\nMatricule : " + resMatricule + "\n");
        	}
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
    	
    	

	}

}
