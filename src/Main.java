import db.ConnectorDB;
import gui.Menu;

public class Main {

    public static void main(String[] args) {
        ConnectorDB.connect();
        Menu.displayMenu();
    }
}
