import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("Sorting and searching int[]: ");
        int[] ints = {2, 6, 1, 8, 3, 9, 0, -7, 4};

        System.out.println(Arrays.binarySearch(ints, 0)); //-1

        //sort()
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.binarySearch(ints, 0)); //1

        // when key not found, value returned is ((-insertionPoint) -1)
        System.out.println(Arrays.binarySearch(ints, 5)); //-7 (ar fi pe pozitia 6, -6-1=-7)

        System.out.println("Sorting and searching char[]: ");
        char[] chars = {'f', '3', 'z', '+', 'j', 'a', 'A', 'f', 'F'};
        // sort() from [index to index)
        Arrays.sort(chars, 5, 9);
        System.out.println(String.valueOf(chars));
        System.out.println(Arrays.binarySearch(chars, 'j')); //4
        System.out.println(Arrays.binarySearch(chars, '+')); //-1
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
        System.out.println(Arrays.binarySearch(chars, '+'));//0

        System.out.println("Sorting and searching String[]: ");
        String[] names = {"Jon", "Danielle", "Marie", "Paul", "Jo"};
        System.out.println(Arrays.binarySearch(names, "Jo")); //-1
        Arrays.sort(names);
        System.out.println(Arrays.deepToString(names)); //[Danielle, Jo, Jon, Marie, Paul]
        System.out.println(Arrays.binarySearch(names, "Jo")); //1

        // sort the array ascending by String elements length
        Arrays.sort(names, Comparator.comparingInt(String::length));
        System.out.println(Arrays.deepToString(names)); //[Jo, Jon, Paul, Marie, Danielle]
        System.out.println(Arrays.binarySearch(names, "Jo")); //0

    }
}