public class Lindt extends CandyBox {
    protected float L;
    protected float l;
    protected float h;

    public Lindt() {
        this.L = 0;
        this.l = 0;
        this.h = 0;
    }

    public Lindt(String flavour, String origin, float l, float l1, float h) {
        super(flavour, origin);
        this.L = l;
        this.l = l1;
        this.h = h;
    }

    @Override
    public float getVolume() {
        return this.h * this.L * this.l;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void printLindtDim() {
        System.out.println("lungime= " + L + ", latime= " + l + ", inaltime=" + h);
    }
}
