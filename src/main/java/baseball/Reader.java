package baseball;

import static baseball.baseballGame.goReGame;
import static baseball.baseballGame.noReGame;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Reader {

    private String user;       //유저의 입력
    private int userNumber;


    public void inputUserNumber()           //유저의 입력을 받는 메서드
    {
        System.out.print("숫자를 입력해주세요 :");
        user = readLine();
        userNumber = Integer.parseInt(user);
        checkBit();
    }

    public int inputReGame()
    {
        System.out.println("게임을 새로 시작하려면 " + goReGame + " , 종료하려면 " + noReGame + "를 입력하세요.");
        user = readLine();
        return Integer.parseInt(user);
    }
    
    public int returnUserNumber()            //유저가 입력한 숫자를 반환하는 메서드
    {
        return userNumber;
    }

    private void checkBit()     //자릿수 검증
    {
        if(this.userNumber / 1000 > 0 || this.userNumber < 100)
        {
            throw new IllegalArgumentException("Number length is too long");
        }
    }
}
