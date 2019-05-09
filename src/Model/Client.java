package Model;

public class Client {
    private int id;
    private String name;
    private String login;
    private String password_encrypted;
    private String password_not_encrypted;
    private String pesel;

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword_encrypted() {
        return password_encrypted;
    }

    public void setPassword_encrypted(String password_encrypted) {
        this.password_encrypted = password_encrypted;
    }

    public String getPassword_not_encrypted() {
        return password_not_encrypted;
    }

    public void setPassword_not_encrypted(String password_not_encrypted) {
        this.password_not_encrypted = password_not_encrypted;
    }
}
