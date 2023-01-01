package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    Manager() {
        //manager();
    }

    public void manager() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isAgain = true;
        while(isAgain) {
            CreateNum create = new CreateNum();
            playGame(create);
            isAgain = endGame();
        }
    }

    public void playGame(CreateNum create) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("숫자를 입력해주세요 : ");
            create.setUser();
            Judgement judge = new Judgement(create);
            judge.countBall();
            judge.countStrike();
            judge.printCount();
            isDone = judge.isRight();
        }
    }

    public boolean endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String select = Console.readLine();
        String[] num = select.split("");
        int selectNum = Integer.parseInt(num[0]);

        if(selectNum == 1) {
            return true;
        }
        return false;
    }
}
