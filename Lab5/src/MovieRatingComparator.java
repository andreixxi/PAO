import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie, Movie t1) {
        //dupa rating
        return Double.compare(movie.getRating(), t1.getRating());
    }
}
