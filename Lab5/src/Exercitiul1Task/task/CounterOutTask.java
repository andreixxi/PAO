package task;

public class CounterOutTask implements Task {

    private int counter;

    @Override
    public void doAll() {
        counter++;
        System.out.println("Message from CounterOutTask. Counter after the incrementation: " + counter);
    }
}
