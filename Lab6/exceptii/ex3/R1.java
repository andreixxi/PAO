package exceptii.ex3;

//resursa
public class R1 implements AutoCloseable {

//    public R1() {
//        throw new RuntimeException();
//    }

    @Override
    public void close() throws Exception {
        throw new RuntimeException("in close method");
    }
}
