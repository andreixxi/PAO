import java.util.Scanner;

import static java.lang.Math.pow;

public class ForLoop {
    /*
     * @author cvoinea *
     * program to reverse an input number using for loop
     * TO DO: rewrite the program using recursion
     *
     * for (initialization; termination; increment) {
     *     statement(s)
     * }
     *
     * infinite loop
     * for ( ; ; ) { *
     *     // your code goes here
     * }
     *
     * can use enhanced-for statements
     */

    void reverseFunc(int number, int res) {
        if (number != 0) {
            res = res * 10 + number % 10;
            number = number / 10;
            reverseFunc(number, res);
        } else {
            System.out.println("reversed value is " + res);

        }
    }

    public static void main(String[] args) {
        int inputNo;
        int reverseNo = 0;
        System.out.println("Input an int\n");
        Scanner scanner = new Scanner(System.in);
        inputNo = scanner.nextInt();
        scanner.close();

        /* for loop: No initialization part as inputNo is already
         * initialized and no increment/decrement part as logic
         * inputNo = inputNo/10 already decrements the value of inputNo
         */
       /* for(; inputNo != 0; ) {
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10;
        }
        System.out.println("Reversed value of the input is: " + reverseNo);
*/
        int aux = inputNo;
        int length = 0;
        while (aux != 0) {
            length++;
            aux = aux / 10;
        }

        /*ForLoop obj = new ForLoop(); //instanta a clasei
        int reversed = obj.reverse(inputNo, length);
        System.out.println("Reversed value of the input is: " + reversed);*/

        ForLoop obj = new ForLoop();
        int res = 0;
        obj.reverseFunc(inputNo, res);
        //System.out.println("Reversed value of the input is: ");
        // reverseFunc(inputNo);
    }
}