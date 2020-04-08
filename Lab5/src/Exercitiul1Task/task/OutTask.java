package task;

public class OutTask implements Task {


    @Override
    public void doAll() {
        System.out.println("Message from OutTask");
    }
}
