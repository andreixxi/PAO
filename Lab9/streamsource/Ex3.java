package streamsource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex3 {

    public static void main(String[] args) {

        IntStream streamOfChars =  "minzy song on may".chars();
        streamOfChars.forEach(c -> System.out.println((char)c));

        Stream<String> streamOfStrings = Pattern.compile(",").splitAsStream("a,b, c ,   d, e, r, y");

        Path path = Paths.get("src\\streamsource\\Ex3.java");
        Stream<String> streamOfLines = Stream.empty();
        try {
            streamOfLines = Files.lines(path);
        } catch(IOException e) {
            System.out.println(e);
        }
        streamOfLines.forEach(System.out::println);
    }
}
