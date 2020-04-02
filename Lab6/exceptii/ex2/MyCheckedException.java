package exceptii.ex2;
/*
* custom checked exception*/
public class MyCheckedException extends Exception {

    public MyCheckedException(String s) {
        super(s);
    }
}
