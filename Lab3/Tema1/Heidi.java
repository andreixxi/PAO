public class Heidi extends CandyBox {
    protected float l;

    public Heidi() {
        super();
        this.l = 0;
    }

    public Heidi(String flavour, String origin, float l) {
        super(flavour, origin);
        this.l = l;
    }

    @Override
    public float getVolume() {
        return l * l * l;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void printHeidiDim() {
        System.out.println("latura= " + l);
    }
}
