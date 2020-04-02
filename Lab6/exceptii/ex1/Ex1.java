package exceptii.ex1;

/*
 * java.lang -> Throwable
 *                  Error (nu pot fi anticipate, nu se obisnuieste sa fie tratate)
 *                          -OutOfMemoryException
 *                          -StackOverflowException etc
 *                  Exception - RunTimeException (java.lang) --> unchecked exceptions
 *                                          -NullPointerException, ArithmeticException, IllegalArgumentException (NumberFormatException),
 *                                           ClassCastException
 *                            - others           --> checked exceptions
 *                                  - IOException (java.io)
 *                                          -FileNotFoundException (java.io)
 *                                  - SQLException (java.sql)
 * */
public class Ex1 {

    public static void main(String[] args) throws Exception {

        try {
            m1();
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("in finally");
        }
    }

    static void m1() throws Exception {
        System.out.println("in m1");
        m2();
        throw new Exception();
    }

    static void m2() {
        System.out.println("in m2");
        throw new RuntimeException("exceptie in m2");
//        m3();
    }

    static void m3() {
        System.out.println("in m3");
        // throws null pointer exception
        Object o = null;
        o.toString();
    }
}
