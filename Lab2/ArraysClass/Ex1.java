import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        char[] source = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        char[] dest = new char[5];

        System.arraycopy(source, 3, dest, 0, 4);
        System.out.println(String.valueOf(dest)); // defg

        char[] anotherCopy = Arrays.copyOf(source, 4);
        System.out.println(Arrays.toString(anotherCopy)); //[a, b, c, d]

        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // pay attention that 'to' index specified as 3rd argument is exclusive: [from, to-1 ] or [from, to)
        System.out.println(Arrays.toString(Arrays.copyOfRange(ints, 0, 10)));//[1, 2, .., 10]
        System.out.println(Arrays.toString(Arrays.copyOfRange(ints, 4, 4))); //empty
        // next line will throw an exception since 'from' index must be <= 'to' index
        System.out.println(Arrays.toString(Arrays.copyOfRange(ints, 4, 3)));

    }
}