package polymorphism.Carnivor;

import polymorphism.Animal;

public class Pisica extends Carnivor  {
    public Pisica(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "miauna";
    }

    @Override
    public void scoateSunet() {
        System.out.println("Pisica " + this.sunetSpecific);
    }

    @Override
    public String toString() {
        return super.toString() + " Pisica{" + "sunetSpecific='" + sunetSpecific + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pisica) {
            Pisica pisica = (Pisica) obj;
            return pisica.getNume().equals(this.getNume());
        }
        return false;
    }
}
