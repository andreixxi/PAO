import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        char[] chars = {'j', 'a', 'v', 'a'};

        //prints each element
        for (char c : chars) {
            System.out.println(c);
        }

        //prints whole array
        System.out.println(new String(chars));

        byte[] bytes = new byte[] {0, 4, 6, -128};
        System.out.println(bytes);// will print something like [B@hash_code since arrays don't implement toString()
        System.out.println(Arrays.toString(bytes)); // utility class Arrays contains various methods for manipulating arrays

        //array length = 0 (can't be changed)
        int[] intArray = {};

        //exception at runtime
        intArray[0] = 7;
        System.out.println(intArray[0]);
    }
}