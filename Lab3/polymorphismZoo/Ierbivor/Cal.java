package polymorphism.Ierbivor;

import polymorphism.Animal;

public class Cal extends Ierbivor {
    public Cal(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "necheaza";
    }

    @Override
    public void scoateSunet() {
        System.out.println("Calul " + this.sunetSpecific);
    }
}
