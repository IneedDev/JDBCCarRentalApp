package db;

import Model.Client;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {

    public static void addClient(Client client){
        String sql= "INSERT INTO tclients (Name, Login, Password_not_encrypted, Password_encrypted) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql);
            ps.setString(1,client.getName());
            ps.setString(2,client.getLogin());
            ps.setString(3,client.getPassword_not_encrypted());
            ps.setString(4,DigestUtils.md5Hex(client.getPassword_not_encrypted()));
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static boolean authenticationClient(Client client){
        String sql = "SELECT * FROM tclients WHERE login=?";
        try{
            PreparedStatement ps = ConnectorDB.connection.prepareStatement(sql);
            ps.setString(1,client.getLogin());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String passwordFromDatabase = resultSet.getString("password_not_encrypted");
                System.out.println("User is logged");
                return client.getPassword_not_encrypted().equals(passwordFromDatabase);
            }else {
                System.out.println("Password does not match login");
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}