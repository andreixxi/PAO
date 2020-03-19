package imutabilitate;
//este imutabila
public final class Persoana {

    private final int id;
    private final String nume;
    private final Adresa adresa;

    public Persoana(int id, String nume, Adresa adresa) {
        this.id = id;
        this.nume = nume;
//        String strada = adresa.getStrada();
//        String numar = adresa.getNumar();
//        Adresa copieAdresa = new Adresa(strada, numar); //asa clasa ramane imutabila chiar daca Adresa este mutabila
//        this.adresa = copieAdresa;
        this.adresa = new Adresa(adresa);
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public Adresa getAdresa() {
//        String strada = adresa.getStrada();
//        String numar = adresa.getNumar();
//        Adresa copieAdresa = new Adresa(strada, numar);
//        return copieAdresa;
        return new Adresa(adresa);
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa=" + adresa +
                '}';
    }
}
