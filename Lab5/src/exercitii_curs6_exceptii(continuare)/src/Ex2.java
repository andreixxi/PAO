import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Ex2 {

    public static void main(String[] args) {

        String path = "vectors.txt";

        try {
            createFile(path);

            Vector<Integer> ints = new Vector<>();
            Vector<Double> doubles = new Vector<>();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
                Scanner in = new Scanner(bufferedReader);

                while (in.hasNext()) {
                    if (in.hasNextInt()) {
                        int x = in.nextInt();
                        ints.add(x);
                    } else if (in.hasNextDouble()) {
                        double x = in.nextDouble();
                        doubles.add(x);
                    } else {
                        System.out.println("unknown value" + in.next());
                    }
                }
            }

            Collections.sort(ints);
            Collections.sort(doubles);

            System.out.println("ints: " + ints);
            System.out.println("doubles: " + doubles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String path) throws IOException {

        File file = new File(path);

        if (!file.createNewFile()) {
            System.out.println("file already exists");
        }

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            Scanner in = new Scanner(System.in);
            System.out.println("size=");
            int size = in.nextInt();

            for (int i = 0; i < size; i++) {
                System.out.println("introduceti un int sau double");
                double x = in.nextDouble();
                if (x == Math.floor(x)) {// este int
                    writer.write(Integer.toString((int) x));
                } else {
                    writer.write(Double.toString(x));
                }
                writer.write(" ");
            }
        }
    }
}
