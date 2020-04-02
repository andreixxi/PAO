package exceptii.ex1;

public class Ex2 {

    public static void main(String[] args) {

        try {
            int x = m1();
            System.out.println(x);
        } catch (ArithmeticException e) {
            System.out.println("executam catch");
        } finally {
            System.out.println("finally");
        }
    }

    static int m1() {
        int i = 21 / 0;
        System.out.println(i);
        return i;
    }
}
