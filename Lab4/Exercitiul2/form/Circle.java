package form;

public class Circle extends Form {

    private float radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    public Circle(String colour, float radius) {
        super(colour);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float)Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Cerc: " + super.toString();
    }

    public void printCircleDimensions() {
        System.out.println("radius= " + radius);
    }

    @Override
    public void printDim() {
        printCircleDimensions();
    }
}
