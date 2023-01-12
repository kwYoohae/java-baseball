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

    public void printCount() {
        if(this.ball > 0) {
            System.out.print(this.ball + "볼 ");
        }
        if(this.strike > 0) {
            System.out.print(this.strike + "스트라이크");
        }
        if(this.ball == 0 && this.strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public boolean isRight() {
        if(this.strike == 3) {
            return true;
        }
        return false;
    }
}