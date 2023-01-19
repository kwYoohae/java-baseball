package baseball;

import static baseball.Random.COMPUTER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private final static int COMMAND_RESTART = 1;
    private final static int COMMAND_END = 2;
    private static Check check = new Check();

    public static void main(String[] args) {
        boolean bstartStatus = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (bstartStatus == true) {        //숫자 야구 게임
            check.check();           //볼 스크라이크 구분
            System.out.println(COMPUTER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            bstartStatus = StartException();
        }
    }

    public static boolean StartException() {      //새로 시작할 때의 예외처리
        System.out.println("게임을 새로 시작하려면 " + COMMAND_RESTART + ", 종료하려면 " + COMMAND_END + "를 입력하세요.");
        int selectStart = Integer.parseInt(readLine());   //재시작, 종료 입력
        if (selectStart == COMMAND_RESTART) {
            return true;
        } else if (selectStart == COMMAND_END) {
            return false;
        } else {
            throw new IllegalArgumentException("게임을 새로 시작하려면 " + COMMAND_RESTART + ", 종료하려면 " + COMMAND_END + "를 입력하세요.");
        }
    }
}
