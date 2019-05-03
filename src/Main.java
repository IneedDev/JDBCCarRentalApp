import Model.Car;
import Model.Reservation;
import db.CarDB;
import db.ConnectorDB;
import db.ReservationDB;
import gui.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConnectorDB.connect();

        Menu.displayMenu();

        // TODO - general input validation regex

        // TODO - make reservation method + check between condition
    }
}
