package baseball;

import static baseball.Check.check;
import static baseball.Exception.StartException;
import static baseball.Random.COMPUTER_SIZE;

public class Application {
    public static void main(String[] args) {
        boolean startStatus = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(startStatus == true){        //숫자 야구 게임
            check();           //볼 스크라이크 구분
            System.out.println(COMPUTER_SIZE+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
            startStatus = StartException();
        }
    }
}
