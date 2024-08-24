package model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Dice {

    private int diceCount;
    private int minVal = 1;
    private int maxVal = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int roll() {

        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < diceCount) {
            totalSum += ThreadLocalRandom.current().nextInt(minVal, maxVal + 1);
            diceUsed++;
        }

        return totalSum;
    }
}
