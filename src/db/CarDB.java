package db;

import Model.Car;
import sql.Sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CarDB {


    public static List<Car> getAllCars(){

        List<Car> carList = new ArrayList<>();
        String sql = "SELECT * FROM `tcars`";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            System.out.println(String.format("%10s %20s %10s %20s %10s", "CarID", "|", "Name", "|", "Type"));


            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("CarID"));
                car.setName(resultSet.getString("Name"));
                car.setType(resultSet.getString("Type"));
                System.out.println(String.format("%10s %20s %10s %20s %10s ", car.getId(), "|", car.getName(), "|", car.getType()));

                carList.add(car);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return carList;

    }





}
