package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    final int RESET = 1;

    Manager() {
        startGame();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isAgain = true;
        while(isAgain) {
            Computer computer = new Computer();
            playGame(computer);
            isAgain = endOrReset();
        }
    }

    public void playGame(Computer computer) {
        boolean isDone = false;
        while (!isDone) {
            User user = new User();
            Judgement judge = new Judgement(computer.getComputer(), user.getUserNum());
            judge.printCount();
            isDone = judge.isRight();
        }
    }

    public boolean endOrReset() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String select = Console.readLine();
        String[] num = select.split("");
        int selectNum = Integer.parseInt(num[0]);

        if(selectNum == RESET) {
            return true;
        }
        return false;
    }
}
