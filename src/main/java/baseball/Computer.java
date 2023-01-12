package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    final int RANDOM_NUMBER_SIZE = 3;
    private List<Integer> computerNum = new ArrayList<>();

    Computer() {
        setComputerNum();
    }

    public void setComputerNum() {
        this.computerNum = createRandomNum();
    }

    public List<Integer> getComputer() {
        return computerNum;
    }

    private List<Integer> createRandomNum() {
        List<Integer> computerNum = new ArrayList<>();

        while (computerNum.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
                System.out.print(randomNumber);
            }
        }
        System.out.println();
        return computerNum;
    }
}
