import java.util.List;
import java.util.Random;

public class DiceRoll {

    private String[] rolls;
    private int diceSum;

    private static DiceRoll diceRollInstance = new DiceRoll();

    public static DiceRoll getInstance() {
        return diceRollInstance;
    }

    private DiceRoll() {
    }

    public DiceRoll rollDice(int plus) {
        Random random = new Random();
        rolls = new String[4];
        diceSum = 0;

        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(3);

            if (number == 0) {
                rolls[i] = "[ ]";
                diceSum += 0;
            } else if (number == 1) {
                rolls[i] = "[+]";
                diceSum += 1;
            } else if (number == 2) {
                rolls[i] = "[-]";
                diceSum += -1;
            }
        }

        diceSum += plus;
        return this;
    }

    public String[] getRolls() {
        return rolls;
    }

    public int getDiceSum() {
        return diceSum;
    }

    @Override
    public String toString() {
        String rolledDices = String.join(" ", rolls[0], rolls[1], rolls[2], rolls[3]);
        return rolledDices;
    }
}
