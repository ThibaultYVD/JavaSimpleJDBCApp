package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT {

	public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
        
        // Les données à insérer
        String nom =  "Benoit";
        String prenom = "David";
        String birthday =  "1982-12-10";
        String email = "benoitdavid@gmail.com";
        String matricule = "e240";
        
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
        	String sql = "INSERT INTO etudiants (nom,prenom,date_naissance,email,matricule) "
        			+ "VALUES (?,?,?,?,?)";
        	
        	PreparedStatement prepState = conn.prepareStatement(sql);
        	
        	prepState.setString(1,nom);
        	prepState.setString(2,prenom);
        	prepState.setString(3,birthday);
        	prepState.setString(4,email);
        	prepState.setString(5,matricule);
        	
        	// Excécuter
        	int lignesAffectees = prepState.executeUpdate();
        	
        	if(lignesAffectees > 0) {
        		System.out.println("L'insertion a réussi");
        	}else {
        		System.out.println("L'insertion a échoué");
        		prepState.close();
        		conn.close();
        	}
        	
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
	}
}
