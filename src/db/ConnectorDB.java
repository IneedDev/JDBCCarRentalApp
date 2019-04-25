package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

    private static final String DB_NAME = "carrental";
    private static final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/"+DB_NAME+"?autoReconnect=true&useSSL=false";
    private static final String USER="root";
    private static final String PASSWORD="Sasanka01";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_PHONE="phone";
    private static final String COLUMN_EMAIL="email";

    String user = "root";
    String password = "Sasanka01";

    public static Connection connection = null;

    public static void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            ConnectorDB.connection = DriverManager.getConnection(CONNECTION_STRING,USER,PASSWORD);
            //CarRepository.connection = DriverManager.getConnection("jdbc:mysql://localhost/"+DB_NAME+"?autoReconnect=true&useSSL=false");
            System.out.println("Connection successful ");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Connection failed" + e.getMessage());
            System.exit(0);
        }
    }
}
