package form;

public class FormTest {
    public static void main(String[] args) {

        Form triangle = new Triangle("rosu", 7f, 3f);
        Form circle = new Circle("verde", 3f);

        System.out.println(triangle);
        System.out.println(circle);

        Form[] forms = new Form[20];
        //upcasting
        forms[0] = triangle;
        forms[1] = circle;
        forms[2] = new Circle("albastru", 5f);
        forms[3] = new Circle("mov", 10.8f);

        int numar = 4;
        //apel toString() -> afiseaza aria si culoarea
        for (int i = 0; i < numar; i++) {
            System.out.println(forms[i]);
        }

        //downcasting
        for (int i = 0; i < numar; i++) {
            if (forms[i] instanceof Triangle) {
                Triangle tr = (Triangle)forms[i];
                tr.printTriangleDimensions();
            } else if (forms[i] instanceof Circle) {
                Circle c = (Circle)forms[i];
                c.printCircleDimensions();
            }
        }

        for (int i = 0; i < numar; i++) {
            forms[i].printDim();
        }
    }
}
