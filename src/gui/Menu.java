package gui;

import Model.Client;
import db.UserDB;

import java.util.Scanner;

public class Menu {

    public static int startMenuInput(){
        do{
            System.out.println("1 Client dashboard");
            System.out.println("2 Administrator dashboard");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()){
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            int choice = scanner.nextInt();
            while (choice<0){
                System.out.printf("You have entered a positive number %d.\n", choice);
                break;
            }
            if (choice==1 || choice==2){
                return choice;
            }
        }while (true);
    }

    public static void displayMenu(){
        while (true){
            int choice = startMenuInput();
            switch (choice){
                case 1:
                    System.out.println("Client menu");

                    // Client login call login and menu after login
                    ClientMenu.clientLoginMenu();
                    //ClientMenu.clientMenuAfterLoginInput();
                    break;
                case 2:
                    System.out.println("Admin menu");
                    AdminMenu.adminLoginMenu();
                    break;
            }
        }
    }
}
