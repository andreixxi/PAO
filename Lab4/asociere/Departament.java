package asociere;

import java.util.Arrays;

public class Departament {//has-a
    //profesorii pot exista si fara departament
    private String nume;
    private Profesor[] profesori;

    public Departament(String nume) {
        this.nume = nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setProfesori(Profesor[] profesori) {
        this.profesori = profesori;
    }

    public String getNume() {
        return nume;
    }

    public Profesor[] getProfesori() {
        return profesori;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "nume='" + nume + '\'' +
                ", profesori=" + Arrays.toString(profesori) +
                '}';
    }
}
