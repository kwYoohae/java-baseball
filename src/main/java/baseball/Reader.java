package baseball;

import java.util.Scanner;

public class Reader {
    private Scanner scanner;        //user input scanner 유저 입력 scanner
    private int user;       //유저의 입력

    Reader()
    {
        scanner = new Scanner(System.in);   //user input    스캐너생성
    }

    public void inputUserNumber()           //유저의 입력을 받는 메서드
    {
        System.out.print("숫자를 입력해주세요 :");
        user = scanner.nextInt();
    }

    public int inputReGame()
    {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        user = scanner.nextInt();
        return user;
    }
    
    public int returnUserInput()            //유저가 입력한 숫자를 반환하는 메서드
    {
        return user;
    }
}
