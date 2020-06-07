package app.model;

public class Sponsor extends Person {

    private float sum;

    public Sponsor(String name, float sum) {
        super(name);
        this.sum = sum;
    }

    public Sponsor() {
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return super.toString() + " sum=" + sum;
    }
}
