public class Milka extends CandyBox {
    protected float h;
    protected float r;

    public Milka() {
        this.h = 0;
        this.r = 0;
    }

    public Milka(String flavour, String origin, float h, float r) {
        super(flavour, origin);
        this.h = h;
        this.r = r;
    }

    @Override
    public float getVolume() {
        float pi = (float) Math.PI;
        return pi * r * r * h;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void printMilkaDim() {
        System.out.println("inaltime= " + h + ", raza= " + r);
    }
}
