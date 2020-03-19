package arrays;

import java.util.Random;

public class MyArrayListTest {

    public static void main(String[] args) {

        MyArrayList array = new MyArrayList(6);

        array.add(21.f);
        array.add(156.18f);
        array.add(-9f);

        System.out.println(array);
        System.out.println(array.get(0) == 21.f);
        System.out.println(array.get(1) == 156.18f);
        System.out.println(array.get(2) == -9f);

        MyArrayList anotherArr = new MyArrayList(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            float value = random.nextFloat();
            anotherArr.add(value);
        }
        System.out.println(anotherArr);

        for (int i = 0; i < 10; i++) {
            float value = random.nextFloat();
            anotherArr.add(value);
        }
        System.out.println(anotherArr);

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(10);
            float value = anotherArr.get(index);
            assert anotherArr.contains(value);
            /*assert is a Java keyword used to define an assert statement.
            An assert statement is used to declare an expected boolean condition in a program.
            If the program is running with assertions enabled, then the condition is checked at runtime.
            If the condition is false, the Java runtime system throws an AssertionError .*/
        }

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(10);
            System.out.println("Am eliminat de pe pozitia " + index + " valoarea " + anotherArr.get(index));
            anotherArr.remove(index);
        }
        System.out.println(anotherArr);
    }
}
