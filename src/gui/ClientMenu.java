package gui;

import Model.Car;
import Model.Client;
import Model.Validator;
import db.CarDB;
import db.UserDB;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientMenu {

    public static int clientMenuInput(){
        do{
            System.out.println("1 Login");
            System.out.println("2 Register");

            Scanner scanner = new Scanner(System.in);

            while (!scanner.hasNextInt()){
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            int choice = scanner.nextInt();
            while (choice<0){
                System.out.printf("You have entered a negative number %d.\n", choice);
                break;
            }

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

    public static int clientReservationMenuInput(){
        do{
            System.out.println("1 Give CarID");
            System.out.println("2 Reservation start date (YYYY-MM-DD) ");
            System.out.println("3 Reservation end date (YYYY-MM-DD) ");

            Scanner scanner = new Scanner(System.in);

            while (!scanner.hasNextInt()){
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            int choice = scanner.nextInt();
            while (choice<0){
                System.out.printf("You have entered a negative number %d.\n", choice);
                break;
            }

            if (choice==1 || choice==2 || choice==3){
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


    public static Client clientMenuLoginInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give login");
        String login = scanner.nextLine();

        System.out.println("Give password");
        String password = scanner.nextLine();

        Client client = new Client();
        client.setLogin(login);
        client.setPassword_not_encrypted(password);
        return client;
    }


    static Client register(){
        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Name");
            String name = scanner.next();

            String regEmail = "[a-zA-Z]*@[a-zA-Z]*\\.[a-zA-Z]*";
            String inputEmail;
            do {
                System.out.println("Email");

                inputEmail = scanner.next();
            }while (!inputEmail.matches(regEmail));

            System.out.println("Your email is: " + inputEmail);

            scanner.nextLine();

            System.out.println("Login");
            String login = scanner.next();
            scanner.nextLine();
            String regPassword = "(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";
            String inputPassword;
            do {
                System.out.println("Password");
                System.out.println("Be between 8 and 40 characters long\n" +
                        "Contain at least one digit.\n" +
                        "Contain at least one lower case character.\n" +
                        "Contain at least one upper case character.\n" +
                        "Contain at least on special character from [ @ # $ % ! . ].");
                inputPassword = scanner.next();
            }while (!inputPassword.matches(regPassword));
                System.out.println("Correct password ");
            scanner.nextLine();

            System.out.println("Repeat password");
            String repartePassword = scanner.nextLine();
            if(inputPassword.equals(repartePassword)){
                Client client = new Client();
                client.setName(name);
                client.setLogin(login);
                client.setPassword_not_encrypted(inputPassword);
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
