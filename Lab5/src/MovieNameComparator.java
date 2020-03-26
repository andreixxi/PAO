import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie, Movie t1) {
        //cresc dupa lungimea numelui
        return movie.getName().length() - t1.getName().length();
    }
}
