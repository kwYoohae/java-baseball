package baseball;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    private int strike;
    private int ball;

    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();

    Judgement(CreateNum create) {
        this.strike = 0;
        this.ball = 0;

        computer = create.getComputer();
        user = create.getUser();
    }



    public void countBall() {
        for(int i = 0; i < computer.size(); i++) {
            if(computer.contains(user.get(i))) {
                ++this.ball;
            }
        }
    }

    public void countStrike() {
        for(int i = 0; i < computer.size(); i++) {
            if(computer.get(i) == user.get(i)) {
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