package baseball;

import java.util.Scanner;

import static baseball.numberBaseball.goReGame;
import static baseball.numberBaseball.noReGame;

public class Reader {
    private Scanner scanner;        //user input scanner 유저 입력 scanner
    private int user;       //유저의 입력

    public Reader()
    {
        scanner = new Scanner(System.in);   //user input    스캐너생성
    }

    public void inputUserNumber()           //유저의 입력을 받는 메서드
    {
        System.out.print("숫자를 입력해주세요 :");
        user = scanner.nextInt();
        checkBit();
    }

    public int inputReGame()
    {
        System.out.println("게임을 새로 시작하려면 " + goReGame + " , 종료하려면 " + noReGame + "를 입력하세요.");
        user = scanner.nextInt();
        return user;
    }
    
    public int returnUserInput()            //유저가 입력한 숫자를 반환하는 메서드
    {
        return user;
    }

    private void checkBit()     //자릿수 검증
    {
        if( (int)(Math.log10(this.user)+1) >= 4)
        {
            throw new IllegalArgumentException("Number length is too long");
        }
    }
}
