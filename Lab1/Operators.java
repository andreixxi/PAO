public class Operators {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;

        boolean b3 = b1 || (b2 = 'A' == 65); //short-circuiting OR
        System.out.println(b3); //true
        System.out.println(b2); //nu il face A din cauza scurtcircuitului

        int number = b2 ? 1 : 0;
        System.out.println(number); //0

        b2 = args instanceof Object; //instanceof operator
        System.out.println(b2); //true

        b3 = null instanceof Object; //null literal is not an instance of anything
        System.out.println(b3); //false
    }
}