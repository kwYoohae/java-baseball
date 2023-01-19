package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Random {
    public final static int COMPUTER_SIZE = 3;
    public List<Integer> random() {    //random 숫자 구하기
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


}
