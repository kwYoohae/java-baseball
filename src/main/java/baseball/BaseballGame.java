package baseball;

import java.util.ArrayList;
import java.util.Objects;

public class BaseballGame {
    private ArrayList<Integer> computerNumbers;
    private ArrayList<Integer> userNumbers;

    public void assignComputerNumbers() {
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumbers = computerNumber.getComputerNumbers();
    }

    public void assignUserNumbers() {
        UserNumber userNumber = new UserNumber();
        userNumbers = userNumber.getUserNumbers();
    }

    public int compareNumbers() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumbers.get(i), userNumbers.get(i)))
                strike++;
            else if (computerNumbers.contains(userNumbers.get(i)))
                ball++;
        }

        return strike * 10 + ball;
    }

}
