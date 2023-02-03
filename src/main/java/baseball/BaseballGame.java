package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    public void assignComputerNumbers() {
        ComputerNumberService computerNumberService = new ComputerNumberService();
        Number number = new Number(computerNumberService.getComputerNumbers());
        computerNumbers = number.getNumbers();
    }

    public void assignUserNumbers() {
        UserNumberService userNumberService = new UserNumberService();
        Number number = new Number(userNumberService.getUserNumbers());
        userNumbers = number.getNumbers();
    }

    public int compareNumbers() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < GameManager.NUMBER_LENGTH; i++) {
            if (Objects.equals(computerNumbers.get(i), userNumbers.get(i)))
                strike++;
            else if (computerNumbers.contains(userNumbers.get(i)))
                ball++;
        }

        return strike * 10 + ball;
    }

}
