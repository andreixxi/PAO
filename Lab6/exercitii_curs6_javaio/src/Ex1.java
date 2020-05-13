import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        new Ex1().findString();
    }

    public String findString() {
        String answer = "";
        String current;
        try {
            Scanner in = new Scanner(new File("test.txt."));
            while (in.hasNext()) {
                current = in.next();
                current = current.replaceAll(",$", "");
                if(current.length() > answer.length()) {
                    answer = current;
                }
            }
            System.out.println("cel mai lung cuvant " + answer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
