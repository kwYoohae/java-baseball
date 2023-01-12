package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static int RANDOM_NUMBER_SIZE = 3;
    private List<Integer> computerNum = new ArrayList<>();

    Computer() {
        createRandomNum();
    }

    public List<Integer> getComputer() {
        return computerNum;
    }

    private void createRandomNum() {
        while (this.computerNum.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!this.computerNum.contains(randomNumber)) {
                this.computerNum.add(randomNumber);
                System.out.print(randomNumber);
            }
        }
        System.out.println();
    }
}
