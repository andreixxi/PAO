import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {

        try {
            List<String> array = new ArrayList<>();
            String fileName = "test.txt";
            Scanner in = new Scanner(new File(fileName));
            String str;
            while (in.hasNextLine()) {
                str = in.nextLine();
                array.add(str);
            }
            for (String s : array) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
