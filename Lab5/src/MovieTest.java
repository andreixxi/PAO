import java.lang.reflect.Array;
import java.util.Arrays;

public class MovieTest {

    public static void main(String[] args) {

        Movie[] movies = {new Movie("Breaking bad", 2014, 9.4),
                new Movie("Star wars", 1987, 8.8),
                new Movie("Die hard", 1990, 8),
                new Movie("Parasite", 2019, 10)};

        System.out.println(Arrays.toString(movies));
        Arrays.sort(movies);
        System.out.println(Arrays.toString(movies));

        //comparator ca parametru
        Arrays.sort(movies, new MovieRatingComparator());
        System.out.println(Arrays.toString(movies));

        Arrays.sort(movies, new MovieNameComparator());
        System.out.println(Arrays.toString(movies));
    }
}
