package baseball;

import static baseball.Check.check;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static int COMMAND_RESTART = 1;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(COMMAND_RESTART==1){        //숫자 야구 게임
            check();           //볼 스크라이크 구분
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            COMMAND_RESTART = Integer.parseInt(readLine());   //재시작, 종료 입력
        }
    }

}
