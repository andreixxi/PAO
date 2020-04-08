package task;

public class Test {

    public static void main(String[] args) {

        OutTask outTask = new OutTask();
        outTask.doAll();

        RandomOutTask randomOutTask = new RandomOutTask();
        randomOutTask.doAll();

        CounterOutTask counterOutTask = new CounterOutTask();
        counterOutTask.doAll();
        counterOutTask.doAll();
        counterOutTask.doAll();
        counterOutTask.doAll();

    }
}

