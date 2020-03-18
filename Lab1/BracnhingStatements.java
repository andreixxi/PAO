import java.util.Scanner;

// * TO DO: implement a program to read int values from keyboard until a pre-set value in encountered
public class BracnhingStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an int\n");
        int x = scanner.nextInt();
        int y = 28;
        while (x != y) {
            System.out.println("x= " + x + "\nInput another int\n");
            x = scanner.nextInt();
        }
    }
}