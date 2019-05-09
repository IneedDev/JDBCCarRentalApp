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
            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setReservationID(resultSet.getInt("ReservationID"));
                reservation.setCarID(resultSet.getInt("CarID"));
                reservation.setReservationStartDate(resultSet.getString("ReservationStartDate"));
                reservation.setReservationEndDate(resultSet.getString("ReservationEndDate"));
                reservation.setPesel(resultSet.getString("Pesel"));
                reservationsList.add(reservation);
            }
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
        String sql2= "SELECT ReservationStartDate, ReservationEndDate FROM treservations WHERE ReservationStartDate< ? AND ReservationEndDate> ?";

        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql2);
            ps.setString(1,reservation.getReservationStartDate());
            ps.setString(2,reservation.getReservationEndDate());
            ps.execute();

        }catch (SQLException e){
            e.getStackTrace();
        }
        return reservationList;
    }
}
