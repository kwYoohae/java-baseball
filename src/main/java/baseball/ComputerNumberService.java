package baseball;

import java.util.ArrayList;

import static baseball.GameManager.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerNumberService {

    public ArrayList<Integer> getComputerNumbers() {
        ArrayList<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < NUMBER_LENGTH) {
            int num = pickNumberInRange(startRange, endRange);
            if (!computerNumbers.contains(num)) {
                computerNumbers.add(num);
            }
        }

        return computerNumbers;
    }
}
