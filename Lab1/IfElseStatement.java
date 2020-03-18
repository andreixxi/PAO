import java.util.Scanner;

public class IfElseStatement {
    public static void main(String[] args) {
        // * Program to check whether the given number is positive or negative
       /* Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number\n");
        int number = scanner.nextInt();
        scanner.close();
        if (number > 0) {
            System.out.println(number + " is positive");
        }
        else if (number < 0) {
            System.out.println(number + " is negative");
        }
        else {
            System.out.println(number + " is neither positive nor negative");
        }
*/
        // * TO DO: write a program to check leap year

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year\n");
        int year = scanner.nextInt();
        scanner.close();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a leap year");
                } else {
                    System.out.println(year + " is not a leap year");
                }
            } else {
                System.out.println(year + " is a leap year");
            }
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}