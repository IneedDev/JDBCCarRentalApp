package gui;

import Model.Client;
import db.UserDB;

import java.util.Scanner;

public class ClientMenu {

    public static int clientMenu(){
        do{
            System.out.println("1 Login");
            System.out.println("2 Register");

            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice==1 || choice==2){
                return choice;
            }
        }while (true);
    }

    public static void clientLoginMenu(){
        while (true){
            int choice = clientMenu();
            switch (choice){
                case 1:
                    UserDB.authenticationClient(login());
                    break;
                case 2:
                    UserDB.addClient(register());
                    break;
            }
        }
    }


    public static Client login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login login method");
        String login = scanner.nextLine();

        System.out.println("Password login method");
        String password = scanner.nextLine();

        Client client = new Client();
        client.setLogin(login);
        client.setPassword_not_encrypted(password);
        return client;
    }

    static Client register(){
        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Name ");
            String name = scanner.nextLine();

            System.out.println("Login");
            String login = scanner.nextLine();
            System.out.print("");
            System.out.println("Password");
            String password = scanner.nextLine();
            System.out.print("");

            System.out.println("Repeat password");
            String repartePassword = scanner.nextLine();
            if(password.equals(repartePassword)){
                Client client = new Client();
                client.setName(name);
                client.setLogin(login);
                client.setPassword_not_encrypted(password);
                return client;
            }else {
                System.out.println("Password does not match");
            }
        }

    }

    public static void displayMenuLogin(){
        while (true){
            int choice = clientMenu();
            switch (choice){
                case 1:
                    System.out.println("Logujemy sie");
                    //UserDB.addClient();
                case 2:
                    System.out.println("Option 2 was choose");
                    break;
            }
        }
    }



}
