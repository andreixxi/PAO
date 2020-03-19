package asociere;

import java.util.Arrays;

public class Universitate { //has-to-has-a
    //este oblig sa existe univ pt ca ob de tip departament sa existe in continuare
    private String nume;
    private Departament[] departamente;

    public Universitate(String nume, Departament[] departamente) {
        //trebuie creata o copie
        this.nume = nume;
        this.departamente = Arrays.copyOf(departamente, departamente.length);
    }

    @Override
    public String toString() {
        return "Universitate {nume= " + nume + ", departamente= " + Arrays.toString(departamente) + "}";
    }
}
