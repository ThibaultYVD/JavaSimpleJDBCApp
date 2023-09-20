package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner userInput = new Scanner(System.in);
        System.out.println("Sélectionnez la commande que vous voulez exécuter :\n"
        		+ "1 - SELECT\n"
        		+ "2 - INSERT\n"
        		+ "3 - UPDATE\n"
        		+ "4 - DELETE");
        
        int userChoice = userInput.nextInt();
        
        switch(userChoice) {
        case 1:
        	System.out.println("Commande SELECT");
        	break;
        case 2:
        	System.out.println("Commande INSERT");
        	break;
        case 3:
        	System.out.println("Commande UPDATE");
        	break;
        case 4:
        	System.out.println("Commande DELETE");
        	break;
        }

    }
}