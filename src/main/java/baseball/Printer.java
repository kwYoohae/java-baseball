package baseball;

import static baseball.numberBaseball.BIT;

public class Printer {

    public void openning()
    {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void call(int ball, int strike)       //볼카운트 출력
    {
        if(ball != 0)  System.out.print(ball+"볼 ");
        if(strike != 0) System.out.print(strike+"스트라이크");
        if(strike == 0 && ball == 0) System.out.print("낫싱");
        if(strike == BIT)  strikeout();
        System.out.println();
    }

    private void strikeout()
    {
        System.out.println(BIT + "스트라이크");
        System.out.print(BIT + "개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
}
