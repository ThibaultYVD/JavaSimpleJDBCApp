package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Methodes implements CRUD{

	@Override
	public void SELECT() {
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

	@Override
	public void INSERT() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
        
        // Les données à insérer
        System.out.println("Entrer le nom");
    	Scanner nomInput = new Scanner(System.in);
    	String nom = nomInput.nextLine();

    	System.out.println("Entrer le prénom");
    	Scanner prenomInput = new Scanner(System.in);
    	String prenom = prenomInput.nextLine();
    	
    	System.out.println("Entrer la date de naissance sous la forme yyyy-mm-dd");
    	Scanner birthdayInput = new Scanner(System.in);
    	String birthday = nomInput.nextLine();
    	
    	System.out.println("Entrer l'email");
    	Scanner emailInput = new Scanner(System.in);
    	String email = emailInput.nextLine();
    	
    	System.out.println("Entrer le matricule");
    	Scanner matriculeInput = new Scanner(System.in);
    	String matricule = emailInput.nextLine();
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

	@Override
	public void UPDATE(int id) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
        
        // Les données à modifier
        
        System.out.println("Entrer le nom");
    	Scanner nomInput = new Scanner(System.in);
    	String nom = nomInput.nextLine();

    	System.out.println("Entrer le prénom");
    	Scanner prenomInput = new Scanner(System.in);
    	String prenom = prenomInput.nextLine();
    	
    	System.out.println("Entrer la date de naissance sous la forme yyyy-mm-dd");
    	Scanner birthdayInput = new Scanner(System.in);
    	String birthday = nomInput.nextLine();
    	
    	System.out.println("Entrer l'email");
    	Scanner emailInput = new Scanner(System.in);
    	String email = emailInput.nextLine();
    	
    	System.out.println("Entrer le matricule");
    	Scanner matriculeInput = new Scanner(System.in);
    	String matricule = emailInput.nextLine();

        
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
        	String sql = "UPDATE etudiants SET nom=?, prenom=?, date_naissance=?, email=?, matricule=? WHERE id=" + id;
        	
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

	@Override
	public void DELETE(int id) {
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
        	String sql = "DELETE FROM etudiants WHERE `id`="+ id;
        	
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
