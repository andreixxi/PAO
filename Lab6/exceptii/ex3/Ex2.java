package exceptii.ex3;

public class Ex2 {

    public static void main(String[] args) {

        //try with resources
        try (R1 r1 = new R1();
             R1 r2 = new R1()){
            //some logic here
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
