import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        for(int[] row : array) {
            Arrays.fill(row, 3);
            System.out.println(Arrays.toString(row));
        }

        int[][] array2 = array.clone();
        System.out.println(Arrays.equals(array, array2)); //true
        System.out.println(Arrays.deepEquals(array, array2));

        System.out.println(Arrays.toString(array2)); //adrese
        System.out.println(Arrays.deepToString(array2));

        // hashcode and deepHashCode
        System.out.println(Arrays.hashCode(array2));//-1854526130
        System.out.println(Arrays.deepHashCode(array2));//1178503169
    }
}