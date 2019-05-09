package gui;

import Model.Car;
import Model.Client;
import Model.Reservation;
import db.CarDB;
import db.ReservationDB;
import db.UserDB;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static int clientMenuAfterLoginInput(){
        do{
            System.out.println("1 Get cars");
            System.out.println("2 Reserve a car");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice==1 || choice==2){
                return choice;
            }
        }while (true);
    }

    public static Reservation clientReservationMenuInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 Give CarID");
        int CarID = scanner.nextInt();

        String regData = "\\d{4}-\\d{2}-\\d{2}";
        System.out.println("2 Reservation start date (YYYY-MM-DD) ");
        String ReservationStartDate;

        while (!(ReservationStartDate=scanner.next()).matches(regData)){
            System.out.printf("Date format not correct, Please try once again\n");
        }
        System.out.println("3 Reservation end date (YYYY-MM-DD) ");
        String ReservationEndDate;
        while (!(ReservationEndDate=scanner.next()).matches(regData)){
            System.out.printf("Date format not correct, Please try once again\n");
        }

        System.out.println("4 Give your PESEL number");
        String Pesel = scanner.next();
        Reservation reservation = new Reservation();
        reservation.setReservationStartDate(ReservationStartDate);
        reservation.setReservationEndDate(ReservationEndDate);
        reservation.setCarID(CarID);
        reservation.setPesel(Pesel);

        //clarify how to pass reservation object to another method without repeating
//        System.out.println(ReservationDB.checkDatesForReservation(reservation));
//
//        if (!ReservationDB.checkDatesForReservation(reservation).isEmpty()){
//            System.out.printf("you can make reservation");
//            ReservationDB.makeReservation(reservation);
//
//        }else {
//            System.out.printf("Change dates");
//        }

        /* this cause second login menu
        reservation.setLogin(clientCurrentLogin());
         */
        return reservation;
    }
    public static void clientMenuAfterLogin(){
        while (true){
            int choice = clientMenuAfterLoginInput();
            switch (choice){
                case 1:
                    CarDB.getAllCars();

                    List<Car> carsFromDatabase = CarDB.getAllCars();
                    System.out.println("************************");
                    for (Car car : carsFromDatabase) {
                        System.out.println(car.getId()+" | "+ car.getType()+" | "+car.getName());
                    }
                    System.out.println("************************");
                    break;
                case 2:
                    clientReservationMenuInput();
                    System.out.println("Reservation done!!!");
                    break;
            }
        }
    }

    public static void clientMenuReservationProcess(){
        ReservationDB.makeReservation(clientReservationMenuInput());
    }

    private static List<Reservation> checkReservetionAvailability(){
        List<Reservation> reservationList = new ArrayList<>();
        Reservation reservation = new Reservation();
        reservation.setReservationStartDate(clientReservationMenuInput().getReservationStartDate());
        reservation.setReservationEndDate(clientReservationMenuInput().getReservationEndDate());
        reservation.setCarID(clientReservationMenuInput().getCarID());
        reservationList.add(reservation);

        return reservationList;
    }
    private static void checkReservetionIsPOssible(Reservation reservation){
        ReservationDB.getAllReservation();
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
    // try to catch current login from Client
    public static String clientCurrentLogin(){

        return ClientMenu.clientMenuLoginInput().getLogin();
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

}
