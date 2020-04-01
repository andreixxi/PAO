package form;

public class Triangle extends Form {

    private float height, base;

    public Triangle() {
        super();
        this.height = 0;
        this.base = 0;
    }

    public Triangle(String colour, float height, float base) {
        super(colour);
        this.height = height;
        this.base = base;
    }

    @Override
    public float getArea() {
        return base * height / 2;
    }

    @Override
    public String toString() {
        return "Triunghi: " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        //sa aiba inaltimea si baza egale(aprox)
        if (Float.compare(triangle.height, height) == 0 && Float.compare(triangle.base, base) == 0)
            return true;
        return false;
    }

    public void printTriangleDimensions() {
         System.out.println("base= " + base + " height= " + height);
    }

    @Override
    public void printDim() {
        printTriangleDimensions();
    }
}
