//public class Cup extends WashableObject {
public class Cup implements BubbleBathable {

    double volume;
    String colour;

    public int getLevelOfFragility() {
        return Washable.fragile; //constanta din interfata washable
    }

    @Override
    public boolean needsWashing() {
        return false;
    }

    @Override
    public void wash() {
        needsWashing();
        System.out.println("washing a cup");
    }


    @Override
    public void takeBubbleBath() {
        System.out.println("doesn't need bubble bathing");
    }

    @Override
    public void scrub() {

    }

    @Override
    public void soak() {

    }
}
