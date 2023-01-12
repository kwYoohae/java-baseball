package baseball;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

    private int strike;
    private int ball;

    private List<Integer> computerNum = new ArrayList<>();
    private List<Integer> userNum = new ArrayList<>();

    Judgement(List<Integer> computerNum, List<Integer> userNum) {
        this.computerNum = computerNum;
        this.userNum = userNum;

        countBall();
        countStrike();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void countBall() {
        for(int i = 0; i < computerNum.size(); i++) {
            if(computerNum.contains(userNum.get(i))) {
                ++this.ball;
            }
        }
    }

    private void countStrike() {
        for(int i = 0; i < computerNum.size(); i++) {
            if(computerNum.get(i) == userNum.get(i)) {
                ++this.strike;
                --this.ball;
            }
        }
    }
}