import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        try {
            File file = new File("original.txt");
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                strings.add(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int offset = 5;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("textCodat.txt"));
            List<String> codedStrings = new ArrayList<>();
            for (String string : strings) {
                String codedString = caesarCipher(string, offset).toString(); //codez
                codedStrings.add(codedString);
                writer.write(codedString);
            }
            writer.close();

            //pentru decodare
            BufferedWriter writerD = new BufferedWriter(new FileWriter("textDecodat.txt"));
            for (String s : codedStrings) {
                String decodedString = caesarCipher(s, 31 - offset).toString(); // din numarul de litere al limbii scad offsetul
                writerD.write(decodedString);
            }
            writerD.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuffer caesarCipher(String str, int offset) {

        StringBuffer coded = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                char ch = (char) (((int) str.charAt(i) + offset - 65) % 31 + 65); //31 litere in romana
                coded.append(ch);
            } else if (Character.isLowerCase((str.charAt(i)))) {
                char ch = (char) (((int) str.charAt(i) + offset - 97) % 31 + 97);
                coded.append(ch);
            } else {
                coded.append(str.charAt(i)); //daca nu e litera nu o modific
            }
        }
        return coded;
    }
}
