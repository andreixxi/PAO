package strings;

public class Main {

    static String membruClasa; //null by default

    public static void main(String[] args) {

        System.out.println(membruClasa);

        String s1 = ""; //empty string
        String s20 = " "; //blank, isBlank()

        String s2 = "abc"; //intern, string pool
        s2.toUpperCase(); //se creeaza un alt string, nu se aplica celui initial
        System.out.println(s2); //abc
//        s2 = s2.toUpperCase();
//        System.out.println(s2); //ABC

        String s3 = new String("abc"); //heap
        String s4 = "abc";
        System.out.println(s2 == s3); //false, == compara referintele care sunt catre obiecte diferite
        System.out.println(s2 == s4); //true, s2 si s4 pointeaza catre acelasi obiect "abc"
        System.out.println(s2.equals(s3)); //true, equals compara continutul/ valoarea, nu referinta/obiectul din memorie
        s3 = s3.intern(); //mutata in zona de memorie refolosibila(nu in heap)
        System.out.println(s2 == s3); //true
        String s5 ="a\bbc \n def \t f b";
        System.out.println(s5);

        String adresa = s1 + s2 + s3.toUpperCase() + s4.length(); //ineficient
        StringBuilder sb = new StringBuilder(adresa); //nu este imutabil (?)
        sb.append(1234);
        System.out.println(sb);

        StringBuffer sbf  = new StringBuffer(adresa);//thread safe, dar mai lent
        StringBuffer sbf1  = new StringBuffer(sb);
        StringBuilder sb1 = new StringBuilder(sbf);
        System.out.println(sbf);
    }
}
