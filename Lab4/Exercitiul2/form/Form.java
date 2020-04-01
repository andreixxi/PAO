package form;

public class Form {
    private String colour;

    public Form() {
        colour = "";
    }

    public Form(String colour) {
        this.colour = colour;
    }

    public float getArea() {
        return 0;
    }

    @Override
    public String toString() {
        return colour + ' ' + this.getArea();
    }

    public void printDim() {

    };
}
