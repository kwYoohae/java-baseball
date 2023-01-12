package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    public final static int RESET = 1;
    public final static int ENDGAME = 2;
    public final int CORRECT = 3;
    public final int NONE = 0;

    Manager() {
        startGame();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isAgain = true;
        while(isAgain) {
            Computer computer = new Computer();
            playGame(computer);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isAgain = endOrReset();
        }
    }

    public void playGame(Computer computer) {
        boolean isDone = false;
        while (!isDone) {
            User user = new User();
            Judgement judge = new Judgement(computer.getComputer(), user.getUserNum());

            printCount(judge);
            isDone = (judge.getStrike() == CORRECT);
        }
    }

    public void printCount(Judgement judge) {
        if(judge.getBall() > NONE) {
            System.out.print(judge.getBall() + "볼 ");
        }
        if(judge.getStrike() > NONE) {
            System.out.print(judge.getStrike() + "스트라이크");
        }
        if(judge.getBall() == NONE && judge.getStrike() == NONE) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public boolean endOrReset() {
        String select = Console.readLine();
        int selectNum = Integer.parseInt(select);

        ExceptionCase.isSelectNumError(selectNum);

        if(selectNum == RESET) {
            return true;
        }
        return false;

    }
}
