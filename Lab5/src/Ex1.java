public class Ex1 {

    public static void main(String[] args) {

//        Washable washable;
//        washable = new Washable(); // cannot be directly instantiated

        Washable washable = new Car();
        washable.wash();

        Washable cat = new Cat();
        if (cat.needsWashing()) {
            cat.wash();
        }

        Washable car = new Car();
        car.wash();

    }
}
