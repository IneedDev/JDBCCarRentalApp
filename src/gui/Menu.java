package gui;

import Model.Client;
import db.UserDB;

import java.util.Scanner;

public class Menu {

    public static int startMenu(){
        do{
            System.out.println("1 Client dashboard");
            System.out.println("2 Administrator dashboard");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice==1 || choice==2){
                return choice;
            }
        }while (true);
    }

    public static void displayMenu(){
        while (true){
            int choice = startMenu();
            switch (choice){
                case 1:
                    System.out.println("Client menu");

                    ClientMenu.clientLoginMenu();
                    break;
                case 2:
                    System.out.println("Admin menu");

                    break;
            }
        }
    }
}
