import java.io.*;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        try {
            String fileName = "src/Ex2.java";
            String output = "test.txt";
            Scanner in = new Scanner(new File(fileName));
            String line;
            BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
            while (in.hasNext()) {
                line = in.next();
                writer.append('\n');
                writer.append(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
