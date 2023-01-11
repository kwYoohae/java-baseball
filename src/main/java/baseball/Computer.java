package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private List<Integer> computer = new ArrayList<>();

    RandomNumber() {
        setComputer();
    }

    public void setComputer() {
        this.computer = randomNum();
    }

    public List<Integer> getComputer() {
        return computer;
    }

    private List<Integer> randomNum() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.print(randomNumber);
            }
        }
        System.out.println();
        return computer;
    }
}
