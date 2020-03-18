import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // A simple text scanner which can parse primitive types and strings (using regular expressions)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:\n");

        //here we actually read the keyboard input
        String myName = scanner.nextLine();

        //close the resource
        scanner.close();

        //display input to console
        System.out.println("My name is: " + myName);
    }
}