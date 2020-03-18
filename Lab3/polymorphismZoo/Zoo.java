package polymorphism;

public class Zoo {
    private final int nrMaxAnimale;
    Animal[] animaleZoo;
    private int indexCurr;

    public Zoo(int nrMaxAnimale) {
        if (nrMaxAnimale > 0) {
            this.nrMaxAnimale = nrMaxAnimale;
            this.animaleZoo = new Animal[nrMaxAnimale];
        } else {
            throw new RuntimeException("Nu ati introdus un numar intreg pozitiv");
        }
    }

    public void adaugaAnimal(Animal animal) {
        if (indexCurr < animaleZoo.length) {
            animaleZoo[indexCurr] = animal;
            System.out.println("Adaugat animal " + animal.getClass().getSimpleName() + " la pozitia " + indexCurr++);
        }
    }
}
