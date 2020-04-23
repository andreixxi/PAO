package singleton;

public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

//    cele 2 variante sunt echivalente, insa cea de jos nu este folosita in practica
//    static {
//        instance = new EagerSingleton();
//    }

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
