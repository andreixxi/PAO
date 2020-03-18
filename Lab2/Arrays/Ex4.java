import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        //only first dimension is required
        int[][] array = new int[4][];
        // each element holds a reference to another single-dimensional array (of different sizes)
        array[0] = new int[2];
        array[1] = new int[1];
        array[2] = new int[]{0, 1, 2};// inline initialization after instantiation
        array[3] = new int[5];

        // initialization of array[3]
        array[3][0] = 30;
        array[3][1] = 31;
        array[3][2] = 32;
        array[3][3] = 33;
        array[3][4] = 34;

        printMatrix(array);

        //TO DO: write a program to create a 2D-array, with both dimensions and elements input by user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input no of rows\n");
        int rows = scanner.nextInt();

        System.out.println("Input no of columns\n");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Input the matrix elements\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.println(i);
            }
            System.out.println();
        }
    }
}