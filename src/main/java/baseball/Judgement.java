package baseball;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

    private int strike;
    private int ball;

    private List<Integer> computerNum = new ArrayList<>();

    public Judgement(List<Integer> computerNum) {
        this.computerNum = computerNum;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void countUserInput(List<Integer> userNum) {
        this.strike = 0;
        this.ball = 0;

        countBall(userNum);
        countStrike(userNum);
    }

    private void countBall(List<Integer> userNum) {
        for(int i = 0; i < computerNum.size(); i++) {
            if(computerNum.contains(userNum.get(i))) {
                ++this.ball;
            }
        }
    }

    private void countStrike(List<Integer> userNum) {
        for(int i = 0; i < computerNum.size(); i++) {
            if(computerNum.get(i) == userNum.get(i)) {
                ++this.strike;
                --this.ball;
            }
        }
    }
}