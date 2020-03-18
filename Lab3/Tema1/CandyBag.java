public class CandyBag {
    private int nrCutii;
    CandyBox[] cutii;
    private int idx;

    public CandyBag(int nrCutii) {
        if (nrCutii > 0) {
            this.nrCutii = nrCutii;
            this.cutii = new CandyBox[nrCutii];
        } else {
            throw new RuntimeException("Nu ati introdus un numar intreg pozitiv");
        }
    }

    public void adaugaCutie(CandyBox cutie) {
        if (idx < cutii.length) {
            cutii[idx] = cutie;
            System.out.println("Adaugat cutia " + cutie.getClass().getSimpleName() + " la pozitia " + idx++);
        }
    }
}