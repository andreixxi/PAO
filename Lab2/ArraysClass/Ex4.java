import java.util.Arrays;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(4, 7, 8, 21);
        System.out.println(intList);

        List<Character> charList = Arrays.asList('j', 'a', 'v', 'a', '8');
        System.out.println(charList);

        // cannot modify the list because it is backed by the original array
        charList.add('A');
        System.out.println(charList);
    }
}