package imutabilitate;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Adresa domiciliu = new Adresa("Timisoara", "4A");
        Persoana persoana = new Persoana(1, "Teo", domiciliu);

        String numePersoana = persoana.getNume().toLowerCase();
        System.out.println(persoana); //obiectul nu se modifica, stringul este imutabil
        System.out.println(numePersoana);

        String strada = domiciliu.getStrada().toUpperCase();
        domiciliu.setStrada(strada);
        System.out.println(persoana);

        Adresa adresaDomiciliu = persoana.getAdresa();
        String stradaDomiciliu = adresaDomiciliu.getStrada();
        adresaDomiciliu.setStrada(stradaDomiciliu.toUpperCase());

        System.out.println(persoana);
    }
}
