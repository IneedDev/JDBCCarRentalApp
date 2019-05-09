package gui;

import Model.Admin;
import Model.Car;
import Model.Client;
import Model.Reservation;
import db.CarDB;
import db.ReservationDB;
import db.UserDB;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    public static int adminMenuInput(){
        do{
            System.out.println("1 Login");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice==1){
                return choice;
            }
        }while (true);
    }

    public static Admin adminMenuLoginInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give login");
        String login = scanner.nextLine();
        System.out.println("Give password");
        String password = scanner.nextLine();
        Admin admin = new Admin();
        admin.setLogin(login);
        admin.setPassword_not_encrypted(password);
        return admin;
    }

    public static void adminLoginMenu(){
        while (true){
            int choice = adminMenuInput();
            switch (choice){
                case 1:
                    if(UserDB.authenticationAdmin(adminMenuLoginInput())){
                        admintMenuAfterLogin();
                    }else {
                        UserDB.authenticationAdmin(adminMenuLoginInput());
                        adminMenuLoginInput();
                    }
                    break;
                case 2:
                    //UserDB.addClient(register());
                    break;
            }
        }
    }



    public static int adminMenuAfterLoginInput(){
        do{
            System.out.println("1 Get all clients");
            System.out.println("2 Get all cars");
            System.out.println("3 Get all reservations");

            System.out.println("4 Add car");
            System.out.println("5 Cancel reservation");

            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice==1 || choice==2|| choice==3|| choice==4|| choice==5){
                return choice;
            }
        }while (true);
    }

    public static void admintMenuAfterLogin(){
        while (true){
            int choice = adminMenuAfterLoginInput();
            switch (choice){
                case 1:
                    UserDB.getAllClients();
                    List<Client> clientsFromDatabase = UserDB.getAllClients();
                    System.out.println("************************");
                    for (Client client : clientsFromDatabase) {
                        System.out.println(client.getName()+" | "
                                + client.getLogin() +" | "
                                +client.getId());
                    }
                    System.out.println("************************");
                    break;
                case 2:
                    CarDB.getAllCars();
                    List<Car> carsFromDatabase = CarDB.getAllCars();
                    System.out.println("************************");
                    for (Car car : carsFromDatabase) {
                        System.out.println(car.getId()+" | "
                                + car.getType()+" | "
                                +car.getName());
                    }
                    System.out.println("************************");
                    break;
                case 3:
                    ReservationDB.getAllReservation();
                    List<Reservation> reservationsFromDatabase = ReservationDB.getAllReservation();
                    System.out.println("************************");
                    for (Reservation reservation : reservationsFromDatabase) {
                        System.out.println(reservation.getReservationID()+" | "
                        +reservation.getCarID()+" | "
                        +reservation.getReservationStartDate()+" | "
                        +reservation.getReservationEndDate()+" | "
                        +reservation.getPesel());
                    }
                    System.out.println("************************");
                    break;
                case 4:

                    break;
                case 5:
                    break;

            }
        }
    }
}
