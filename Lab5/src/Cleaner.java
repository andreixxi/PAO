public class Cleaner {

    public static void cleanObj(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            car.wash();
        } else if (obj instanceof Window) {
            Window window = (Window) obj;
            window.wash();
        } else if (obj instanceof Cup) {
            Cup cup = (Cup) obj;
            cup.wash();
        } else if (obj instanceof Cat) {
            Cat cat = (Cat) obj;
            cat.wash();
        } else {
            throw new RuntimeException("unsupported object type");
        }
    }

    public static void clean(WashableObject washableObject) {
        washableObject.wash();
    }

    public static void main(String[] args) {

        Cat cat = new Cat();
        cleanObj(cat);
//        clean(cat);

        Window window = new Window();
        cleanObj(window);
//        clean(window);

        Car car = new Car();
        cleanObj(car);
//        clean(car);

        Cup cup = new CoffeeCup();
        cleanObj(cup);
//        clean(cup);

        String unknown = "unknown type";
        cleanObj(unknown);
//        clean(unknown); //does not compile, not a washable object
    }
}
