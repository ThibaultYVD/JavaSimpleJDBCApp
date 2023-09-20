package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UPDATE {

	public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
        
        // Les données à modifier
        String nom = "J'ai";
        String prenom = "été";
        String birthday = "2000-09-01";
        String email = "modifié";
        String matricule = " !";
        
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
        	String sql = "UPDATE etudiants SET nom=?, prenom=?, date_naissance=?, email=?, matricule=? WHERE id=1";
        	
        	PreparedStatement prepState = conn.prepareStatement(sql);
        	
        	prepState.setString(1,nom);
        	prepState.setString(2,prenom);
        	prepState.setString(3,birthday);
        	prepState.setString(4,email);
        	prepState.setString(5,matricule);
        	
        	// Excécuter
        	int lignesAffectees = prepState.executeUpdate();
        	
        	if(lignesAffectees > 0) {
        		System.out.println("La mise à jour a réussi");
        	}else {
        		System.out.println("La mise à jour a échoué");
        		prepState.close();
        		conn.close();
        	}
        	
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
	}
}
