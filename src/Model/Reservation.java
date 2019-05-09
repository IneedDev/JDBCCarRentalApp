package Model;

import java.util.Objects;

public class Reservation {
    private int ReservationID;
    private String ReservationStartDate;
    private String ReservationEndDate;
    private int CarID;
    private String Login;
    private String pesel;


    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(ReservationStartDate, that.ReservationStartDate) &&
                Objects.equals(ReservationEndDate, that.ReservationEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ReservationStartDate, ReservationEndDate);
    }
}
