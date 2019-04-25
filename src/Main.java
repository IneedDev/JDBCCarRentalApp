import db.ConnectorDB;
import gui.Menu;

public class Main {

    public static void main(String[] args) {
        System.out.println("test");
        ConnectorDB.connect();
        Menu.displayMenu();
    }
}
