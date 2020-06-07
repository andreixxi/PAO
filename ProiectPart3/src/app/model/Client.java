package app.model;

public class Client extends Person {

    private String email;
    private int age;

    public Client(String name,String email, int age) {
        super(name);
        this.email = email;
        this.age = age;
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
        return super.toString() + ", email='" + email + '\'';
    }
}
