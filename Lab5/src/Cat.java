//public class Cat extends WashableObject
public class Cat extends Animal implements BubbleBathable {

    @Override
    public void wash() {
        System.out.println("washing a cat");
    }


    @Override
    public void takeBubbleBath() {

    }

    @Override
    public void scrub() {

    }

    @Override
    public void soak() {
        System.out.println("do not apply");
    }
}
