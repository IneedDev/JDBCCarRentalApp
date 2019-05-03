package Model;

public class Reservation {
    private int ReservationID;
    private String ReservationStartDate;
    private String ReservationEndDate;
    private int CarID;
    private String Login;


    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int reservationID) {
        ReservationID = reservationID;
    }

    public String getReservationStartDate() {
        return ReservationStartDate;
    }

    public void setReservationStartDate(String reservationStartDate) {
        ReservationStartDate = reservationStartDate;
    }

    public String getReservationEndDate() {
        return ReservationEndDate;
    }

    public void setReservationEndDate(String reservationEndDate) {
        ReservationEndDate = reservationEndDate;
    }

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int carID) {
        CarID = carID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }
}
