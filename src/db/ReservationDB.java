package db;

import Model.Car;
import Model.Reservation;

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
                reservation.setLogin(resultSet.getString("Login"));
                reservation.setReservationStartDate(resultSet.getString("ReservationStartDate"));
                reservation.setReservationEndDate(resultSet.getString("ReservationEndDate"));
                reservationsList.add(reservation);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reservationsList;
    }


}
