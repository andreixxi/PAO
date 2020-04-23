package lambda.ex2;

public class Ex1 {

    public static void main(String[] args) {

        I1 i1 = (int a, int b) -> a + b;
        System.out.println(i1.add(2, 7));

        I2 i2 = x -> 10 * x;
        System.out.println(i2.multiplyByTen(5));
    }
}
