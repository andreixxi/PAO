package lambda.functionalnterfaces;

import java.time.LocalDate;
import java.util.function.*;

/** Consumer<T> - void accept(T t)
 * Supplier<T> - T get()
 * Function<T, R> - R apply(T t)
 * Predicate<T> - boolean test(T t)

 * BiPredicate<T, R> - boolean test(T t, R r)
 * BiConsumer<T, R> - void accept(T t, R r)
 * BiFunction<T, U, R> - R apply(T t, U u)
 * java.util.function pe oracle pt mai multe interfete functionale
* */
public class Ex1 {

    public static void main(String[] args) {

        Consumer<String> c1 = x -> System.out.println(x);
        c1.accept("abc");

        Supplier<LocalDate> ld1 = () -> LocalDate.now();
        System.out.println(ld1.get());

        Function<String, Integer> f1 = s -> s.length();
        System.out.println(f1.apply("hdkasdka"));

        Predicate<Integer> p1 = x -> x % 2 == 0;
        System.out.println(p1.test(5));
    }
}
