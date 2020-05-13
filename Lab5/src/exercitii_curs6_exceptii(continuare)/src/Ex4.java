public class Ex4 {

    public static void main(String[] args) {

        fin(10);
        fin(-3);
    }

    public static void fin(int x) {
        try {
            if (x > 0) {
                System.out.println(x + ">0");
            }
            System.out.println("x=" + x);
        } finally {
            System.out.println("finally");
        }
    }
}
