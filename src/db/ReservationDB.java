package db;

import Model.Car;
import Model.Client;
import Model.Reservation;
import gui.ClientMenu;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDB {

    public static List<Reservation> getAllReservation(){
        List<Reservation> reservationsList = new ArrayList<>();
        String sql = "SELECT * FROM `treservations`";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            System.out.println(String.format("%10s %20s %10s %20s %10s %20s %10s", "ReservationID", "|", "CarID", "|", "ReservationStartDate", "|", "ReservationEndDate"));

            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setReservationID(resultSet.getInt("ReservationID"));
                reservation.setCarID(resultSet.getInt("CarID"));
                reservation.setReservationStartDate(resultSet.getString("ReservationStartDate"));
                reservation.setReservationEndDate(resultSet.getString("ReservationEndDate"));
                reservation.setPesel(resultSet.getString("Pesel"));
                System.out.println(String.format("%10s %20s %10s %20s %10s %20s %10s",
                        reservation.getReservationID(), "|", reservation.getCarID(), "|",reservation.getReservationStartDate(), "|",reservation.getReservationEndDate()));
                reservationsList.add(reservation);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reservationsList;
    }

    public static List<Reservation> getReservationByPesel(Reservation reservation){
        List<Reservation> reservationsList = new ArrayList<>();
        String sql = "SELECT * FROM `treservations` WHERE pesel=?";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql);
            ps.setString(1,reservation.getPesel());
            ResultSet resultSet = ps.executeQuery();
            System.out.println(String.format("%10s %20s %10s %20s %10s %20s %10s", "CarID", "|", "StartDate", "|", "EndDate", "|", "Pesel"));
            while (resultSet.next()){
                String pesel = resultSet.getString("Pesel");
                String carId = resultSet.getString("CarID");
                String startDate = resultSet.getString("ReservationStartDate");
                String endDate = resultSet.getString("ReservationEndDate");
                System.out.println(String.format("%10s %20s %10s %20s %10s %20s %10s",
                        carId, "|", startDate, "|",endDate, "|",pesel));
            }
            System.out.println("\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reservationsList;
    }

    public static void makeReservation(Reservation reservation){
        /*
        String sql= "INSERT INTO treservations (CarID, ReservationStartDate, ReservationEndDate, Login) VALUES (?, ?, ?, ?)";
         */
        String sql= "INSERT INTO treservations (CarID, ReservationStartDate, ReservationEndDate, Pesel) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql);
            ps.setInt(1,reservation.getCarID());
            ps.setString(2,reservation.getReservationStartDate());
            ps.setString(3,reservation.getReservationEndDate());
            ps.setString(4,reservation.getPesel());
            /*
            ps.setString(4,reservation.getLogin());
             */
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Reservation> checkDatesForReservation(Reservation reservation){
        List<Reservation> reservationList = new ArrayList<>();
        String sql2= "SELECT *" +
                "FROM treservations " +
                "WHERE ReservationStartDate>=? AND ReservationEndDate<= ?";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql2);
            ps.setString(1,reservation.getReservationStartDate());
            ps.setString(2,reservation.getReservationEndDate());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                reservationList.add(reservation);
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return reservationList;
    }
}
