import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {

        /*boolean isVowel = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a character\n");
        char inputChar = scanner.next().charAt(0);
        scanner.close();
        switch (inputChar) {
            // works only with single integer value, enum value or String
            // executed in sequence until break statement is encountered;
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U': {
                isVowel = true;
                break; // necessary because otherwise statements fall through
            }
            default: {
                System.out.println(inputChar + " is not vowel");
                break;
            }
        }
        if (isVowel) {
            System.out.println(inputChar + "is a vowel");
        }
        else {
            if ((inputChar >= 'a' && inputChar <= 'z') || (inputChar >= 'A' && inputChar <= 'Z')) {
                System.out.println(inputChar + "is a consonant");
            }
            else {
                System.out.println(inputChar + " is not a letter");
            }
        }
*/

        //TO DO: write a program that outputs the number of days of a particular month of an year (input from keyboard)
        // boolean isMonth = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a month\n");
        String inputMonth = scanner.nextLine();
        scanner.close();

        switch (inputMonth) {
            case "january": {
                //isMonth = true;
                System.out.println(inputMonth + " has 31 days");
                break;
            }
            case "february": {
                System.out.println(inputMonth + " has 28 or 29 days");
                break;
            }
            case "march": {
                System.out.println(inputMonth + " has 31 days");
                break;
            }
            case "april": {
                System.out.println(inputMonth + " has 30 days");
                break;
            }
            case "may": {
                System.out.println(inputMonth + " has 31 days");
                break;
            }
            case "june": {
                System.out.println(inputMonth + " has 30 days");
                break;
            }
            case "july": {
                System.out.println(inputMonth + " has 31 days");
                break;
            }
            case "august": {
                System.out.println(inputMonth + " has 31 days");
                break;
            }
            case "september": {
                System.out.println(inputMonth + " has 30 days");
                break;
            }
            case "october": {
                System.out.println(inputMonth + " has 31 days");
                break;
            }
            case "november": {
                System.out.println(inputMonth + " has 30 days");
                break;
            }
            case "december": {
                System.out.println(inputMonth + " has 30 days");
                break;
            }
            default: {
                System.out.println(inputMonth + " is not a month");
                break;
            }
        }
    }
}