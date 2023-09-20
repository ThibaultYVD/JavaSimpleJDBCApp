package jdbc;

import java.util.Scanner;

public class Menu {

	public void Menu() {
		Methodes CRUD = new Methodes();
    	Scanner userInput = new Scanner(System.in);
        System.out.println("Sélectionnez la commande que vous voulez exécuter :\n"
        		+ "1 - SELECT\n"
        		+ "2 - INSERT\n"
        		+ "3 - UPDATE\n"
        		+ "4 - DELETE\n"
        		+ "5 - Quitter");
        
        int userChoice = userInput.nextInt();
        
        switch(userChoice) {
        case 1:
        	CRUD.SELECT();
        	Menu newMenu1 = new Menu();
        	newMenu1.Menu();
        	break;
        case 2:
        	CRUD.INSERT();
        	break;
        case 3:
        	System.out.println("Quelle entrée voulez-vous mettre à jour ?");
        	Scanner updateInput = new Scanner(System.in);
        	int updateChoice = userInput.nextInt();
        	CRUD.UPDATE(updateChoice);
        	Menu newMenu = new Menu();
        	newMenu.Menu();
        	break;
        case 4:
        	System.out.println("Quelle entrée voulez-vous supprimer ?");
        	Scanner deleteInput = new Scanner(System.in);
        	int deleteChoice = userInput.nextInt();   	
        	CRUD.DELETE(deleteChoice);
        	Menu newMenu2 = new Menu();
        	newMenu2.Menu();
        	break;
        	
        case 5:
        	System.out.println("Vous quittez le programme.");
        	break;
        	
        default:
        	System.out.println("Commande inconnue.");
        	Menu newMenu3 = new Menu();
        	newMenu3.Menu();
        	break;
        }
	}
}
