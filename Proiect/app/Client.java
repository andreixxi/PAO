package app;

public class Client extends Person {

    private String surname, forename, email;
    private int age;

    public Client(String name, String surname, String forename, String email, int age) {
        super(name);
        this.surname = surname;
        this.forename = forename;
        this.email = email;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + " surname='" + surname + '\'' +
                ", forename='" + forename + '\'' +
                ", email='" + email + '\'';
    }
}
