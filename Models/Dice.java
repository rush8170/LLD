package Models;

import java.util.Random;

public class Dice {
    int minValue;
    int maxValue;
    int currentValue;
    Random random;

    public Dice(int minValue, int maxValue, int currentValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = currentValue;
        random = new Random(123454321);
    }

    public int roll() {
        return random.nextInt(minValue,maxValue+1);
    }
}
