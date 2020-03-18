import java.util.Scanner;

public class CandyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de cutii");
        int nrCutii = scanner.nextInt();
        scanner.close();

        CandyBag candies = new CandyBag(nrCutii);
        adaugaCutie(candies);
        for (int i = 0; (i < candies.cutii.length) && (candies.cutii[i] != null); i++) {
            CandyBox c = candies.cutii[i];
        }

        for (CandyBox box : candies.cutii) {
            if (box != null) {
                System.out.println(box);
            }
            if (box instanceof Heidi) {
                ((Heidi) box).printHeidiDim();
            } else if (box instanceof Lindt) {
                ((Lindt) box).printLindtDim();
            } else if (box instanceof Milka) {
                ((Milka) box).printMilkaDim();
            }
        }
        //verifica doar flavour
        System.out.println(candies.cutii[1].equals(candies.cutii[3]));

    }

    public static void adaugaCutie(CandyBag c) {
        Milka milka = new Milka("milk", "UK", 8.5f, 12f);
        c.adaugaCutie(milka);

        Lindt lindt = new Lindt("hazelnut", "IT", 10f, 6.8f, 12f);
        c.adaugaCutie(lindt);

        Heidi heidi = new Heidi("caramel", "KR", 5f);
        c.adaugaCutie(heidi);

        Lindt anotherLindt = new Lindt("cacao", "CH", 10f, 6.8f, 12f);
        c.adaugaCutie(anotherLindt);
    }
}
