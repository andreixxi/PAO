package polymorphism;

import polymorphism.Carnivor.Leu;
import polymorphism.Carnivor.Pisica;
import polymorphism.Ierbivor.Cal;
import polymorphism.Ierbivor.Elefant;
import polymorphism.Omnivor.Caine;
import polymorphism.Omnivor.Urs;

import java.util.Scanner;

public class ZooTest {
    public static void main(String[] args) {
        int nrAnimaleZoo = Integer.parseInt(args[0]);
        System.out.println(nrAnimaleZoo);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Precizat numarul de animale ce pot fi gazduite la zoo");
        int nrAnimale = scanner.nextInt();
        scanner.close();

        Zoo zooBuc = new Zoo(nrAnimale);
        adaugaAnimaleLaZoo(zooBuc);
        for (int i = 0; (i < zooBuc.animaleZoo.length) && (zooBuc.animaleZoo[i] != null); i++) {
            Animal animal = zooBuc.animaleZoo[i];
            animal.afiseazaDetalii();
            animal.seHraneste();
            animal.scoateSunet();
        }

        //folosire equals
        Pisica pisica = new Pisica("Tom", 2);
        Pisica pisicaaaaa = new Pisica("Tom", 2);
        System.out.println(pisica == pisicaaaaa); //false
        System.out.println(pisica.equals(pisicaaaaa)); //true
    }

    public static void adaugaAnimaleLaZoo(Zoo zoo) {
        Leu leu = new Leu("Simba", 5);
        zoo.adaugaAnimal(leu);
        Elefant elefant = new Elefant("Eli", 15);
        zoo.adaugaAnimal(elefant);
        Urs urs = new Urs("Fram", 7);
        zoo.adaugaAnimal(urs);
        Pisica pisica = new Pisica("Tom", 3);
        zoo.adaugaAnimal(pisica);
        Caine caine = new Caine("Tott", 5);
        zoo.adaugaAnimal(caine);
        Cal cal = new Cal("Thunder", 3);
        zoo.adaugaAnimal(cal);
    }
}
