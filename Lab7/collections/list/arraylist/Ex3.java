package collections.list.arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(2, 3, 21, 85, 4, 7, 6, 0, 10);
        System.out.println(ints);

//        Collections.sort(ints);
//        System.out.println("ints after sorting:\n" + ints);

        System.out.println(Collections.binarySearch(ints, 10));
        System.out.println(Collections.binarySearch(ints, -1)); // - insertionPoint - 1


        Object[] arrayOfInt = ints.toArray();

    }
}
