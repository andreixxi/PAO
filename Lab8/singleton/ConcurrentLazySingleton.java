package singleton;

public class ConcurrentLazySingleton {

    // volatile garanteaza ca variabila este vizibila intre diferite threaduri din aplicatie
    private static volatile ConcurrentLazySingleton instance;

    private ConcurrentLazySingleton() {
    }

    public static ConcurrentLazySingleton getInstance() {
        if (instance == null) {
            synchronized (ConcurrentLazySingleton.class) {
                //synchronized pt mediu multi-threading: vor intra threadurile pe rand, threadul blocheaza executia,
                //exceuta propriul bloc, cand termina intra urmatorul
                if (instance == null) {
                    instance = new ConcurrentLazySingleton();
                }
            }
        }
        return instance;
    }
}
