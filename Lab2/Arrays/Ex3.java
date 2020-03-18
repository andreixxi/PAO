import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3]; //3 rows 3 columns
        matrix[0][0] = 0;
        matrix[0][1] = 0;
        matrix[0][2] = 0;
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[2][0] = 2;
        matrix[2][1] = 2;
        matrix[2][2] = 2;

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.println(j);
            }
            System.out.println();
        }

        // declare and initialize a multidimensional array in a single step
        char[][] multidimensionalCharArray = {{'c', 'o', 'u', 'r', 's', 'e'}, {'2', '7'}, {'j', 'a', 'v', 'a'}, {'h'}};

        for (char[] row : multidimensionalCharArray) {
            for (char c : row) {
                System.out.println(c);
            }
            System.out.println();
        }

      /*  TO DO: write a program to compute and display the values of an array
         representing the length of arrays in a given multidimensional array*/

//        System.out.println(multidimensionalCharArray.length);
        int[] lengths = new int[multidimensionalCharArray.length];

        int i = 0;
        for (char[] row : multidimensionalCharArray) {
            lengths[i] = row.length;
            i++;
//          System.out.println(row.length);

        }

        System.out.println(Arrays.toString(lengths));
    }
}