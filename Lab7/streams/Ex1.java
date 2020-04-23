package streams;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// java.io.File
public class Ex1 {

    private static final String BASE_PATH = "./src/streams"; //. pt folder curent

    public static void main(String[] args) throws IOException {

        // get file separator
        System.out.println(System.getProperty("file.separator"));

        // create director
        File dir = new File(BASE_PATH, "/dir"); // BASE_PATH + /dir
        System.out.println(dir.mkdir());

        File dir2 = new File(BASE_PATH, "/a/b/c/dir2");
        System.out.println(dir2.mkdirs());

        // create new file
        File file1 = new File(BASE_PATH, "file1.txt");
        try {
            if (file1.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println(file1.exists());
                System.out.println(file1 + " already exists.");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(file1.getName());
        System.out.println(file1.length());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getCanonicalPath());

        File file2 = new File("./src/streams");
        System.out.println(Arrays.toString(file2.listFiles()));
    }
}
