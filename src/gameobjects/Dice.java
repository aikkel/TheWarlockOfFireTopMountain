package gameobjects;
import java.util.Random;

public class Dice {
    private int diceCount;
    Random rand = new Random();

    public int Dice(int resultAddition) {
        int totalResult = 0;

        for(int i = 0; i < diceCount; i++) {
            int diceRollResult = rand.nextInt(6) + 1;
            totalResult += diceRollResult;
            System.out.println("Roll #" + (i+1) + ": " + diceRollResult);
        }

        totalResult = totalResult + resultAddition;
        return totalResult;
    }

    public int getDiceCount() {
        return diceCount;
    }
    public void setDiceCount(int roll) {
        this.diceCount = roll;
    }


}