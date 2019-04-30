package gui;

import Model.Car;
import Model.Client;
import db.CarDB;
import db.UserDB;

import java.util.List;
import java.util.Scanner;

public class ClientMenu {

    public static int clientMenuInput(){
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

    public static int clientMenuAfterLoginInput(){
        do{
            System.out.println("1 Get cars");
            System.out.println("2 Reverse a car");

            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice==1 || choice==2){
                return choice;
            }
        }while (true);
    }

    public static void clientMenuAfterLogin(){
        while (true){
            int choice = clientMenuAfterLoginInput();
            switch (choice){
                case 1:
                    CarDB.getAllCars();
                    List<Car> carsFromDatabase = CarDB.getAllCars();
                    for (Car car : carsFromDatabase) {
                        System.out.println(car.getId()+" "+ car.getType()+" "+car.getName());
                    }
                    break;
                case 2:
                    System.out.println("Call to DB2");
                    break;
            }
        }
    }

    public static void clientLoginMenu(){
        while (true){
            int choice = clientMenuInput();
            switch (choice){
                case 1:
                    if(UserDB.authenticationClient(clientMenuLoginInput())){
                        clientMenuAfterLogin();
                    }else {
                        UserDB.authenticationClient(clientMenuLoginInput());
                        clientMenuLoginInput();
                    }
                    break;
                case 2:
                    UserDB.addClient(register());
                    break;
            }
        }
    }

//    public static void clientLoginSubMenu(){
//        while (true){
//            int choice = clientMenu();
//            switch (choice){
//                case 1:
//                    UserDB.authenticationClient(login());
//                    return;
//                case 2:
//                    UserDB.addClient(register());
//                    break;
//            }
//        }
//    }




    public static Client clientMenuLoginInput(){
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

//    public static void displayMenuLogin(){
//        while (true){
//            int choice = clientMenu();
//            switch (choice){
//                case 1:
//                    System.out.println("Logujemy sie");
//                    //UserDB.addClient();
//                case 2:
//                    System.out.println("Option 2 was choose");
//                    break;
//            }
//        }
//    }



}
