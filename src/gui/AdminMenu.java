package gui;

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



    public static int adminMenuAfterLoginInput(){
        do{
            System.out.println("1 Get all Clients");
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
                    for (Client client : clientsFromDatabase) {
                        System.out.println(client.getName()+" " + client.getLogin() + " " +client.getId());
                    }

                    break;
                case 2:
                    CarDB.getAllCars();
                    List<Car> carsFromDatabase = CarDB.getAllCars();

                    for (Car car : carsFromDatabase) {
                        System.out.println(car.getId()+" "+ car.getType()+" "+car.getName());
                    }
                    break;

                case 3:
                    ReservationDB.getAllReservation();
                    List<Reservation> reservationsFromDatabase = ReservationDB.getAllReservation();

                    for (Reservation reservation : reservationsFromDatabase) {
                        System.out.println(reservation.getReservationStartDate()+" "+ reservation.getReservationEndDate() + " "+ reservation.getCarID()+" "+reservation.getLogin());
                    }
                    break;
                case 4:

                    break;
                case 5:
                    break;

            }
        }
    }
}
