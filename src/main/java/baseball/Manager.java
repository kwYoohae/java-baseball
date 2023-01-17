package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.ExceptionCase.USER_NUMBER_SIZE;

public class Manager {

    public final static int RESET = 1;
    public final static int ENDGAME = 2;
    public final static int CORRECT = 3;
    public final static int NONE = 0;

    public Manager() {
        startGame();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int selectNum = NONE;
        do {
            Computer computer = new Computer();
            Judgement judge = new Judgement(computer.getComputer());

            playGame(computer, judge);
            selectNum = endOrReset();

        } while(selectNum == RESET);
        System.out.print("숫자 야구 게임을 종료합니다.");
    }

    public void playGame(Computer computer, Judgement judge) {
        boolean isDone = false;
        while (!isDone) {
            User user = new User();
            judge.countUserInput(user.getUserNum());

            printCount(judge);
            isDone = (judge.getStrike() == CORRECT);
        }
    }

    public void printCount(Judgement judge) {
        if (judge.getBall() > NONE) {
            System.out.print(judge.getBall() + "볼 ");
        }
        if (judge.getStrike() > NONE) {
            System.out.print(judge.getStrike() + "스트라이크");
        }
        if (judge.getBall() == NONE && judge.getStrike() == NONE) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public int endOrReset() {
        System.out.println(USER_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " + RESET + ", 종료하려면 " + ENDGAME + "를 입력하세요.");

        String select = Console.readLine();
        int selectNum = Integer.parseInt(select);

        ExceptionCase.isSelectNumError(selectNum);

        return selectNum;
    }
}
