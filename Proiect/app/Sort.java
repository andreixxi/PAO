package app;

import java.util.Comparator;

public class Sort implements Comparator<Artist> {
    @Override
    public int compare(Artist artist, Artist t1) {
        String s1 = artist.getName();
        String s2 = t1.getName();
        return s1.compareToIgnoreCase(s2);
    }
}

