import java.util.Scanner;

public class WhileStatement {
    public static void main(String[] args) {
        int inputNo;
        int reverseNo = 0;

        System.out.println("Input an int number");
        Scanner scanner = new Scanner(System.in);
        inputNo = scanner.nextInt();
        scanner.close();

        //begin while loop
        // program to reverse an input number using while loop
        /*while (inputNo != 0) {
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10;
        }
        */
        // TO DO: rewrite the program using do-while loop
        do {
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10;
        } while (inputNo > 0);

        System.out.println("Reverse of input no\n" + reverseNo);
    }
}