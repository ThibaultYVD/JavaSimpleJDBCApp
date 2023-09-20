package jdbc;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
    	

    	Methodes CRUD = new Methodes();
    	Scanner userInput = new Scanner(System.in);
        System.out.println("S�lectionnez la commande que vous voulez ex�cuter :\n"
        		+ "1 - SELECT\n"
        		+ "2 - INSERT\n"
        		+ "3 - UPDATE\n"
        		+ "4 - DELETE");
        
        int userChoice = userInput.nextInt();
        
        switch(userChoice) {
        case 1:
        	CRUD.SELECT();
        	break;
        case 2:
        	CRUD.INSERT();
        	break;
        case 3:
        	System.out.println("Quelle entr�e voulez-vous mettre � jour ?");
        	Scanner updateInput = new Scanner(System.in);
        	int updateChoice = userInput.nextInt();
        	CRUD.UPDATE(updateChoice);
        	break;
        case 4:
        	System.out.println("Quelle entr�e voulez-vous supprimer ?");
        	Scanner deleteInput = new Scanner(System.in);
        	int deleteChoice = userInput.nextInt();   	
        	CRUD.DELETE(deleteChoice);
        	break;
        }

    }
}