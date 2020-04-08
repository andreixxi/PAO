package task;

import java.util.Random;

public class RandomOutTask implements Task {

    private int randomValue;

    public RandomOutTask() {
        randomValue = new Random().nextInt();
    }

    @Override
    public void doAll() {
        System.out.println("Message from RandomOutTask. randomValue: " + randomValue);
    }
}
