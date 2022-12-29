package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Manager {

    private int []number;     //random number array
    private int []userNumber;   //user's input
    private boolean missionComplete;        //is game done?
    private Scanner scanner;        //user input

    Manager()       //constructor
    {
        System.out.println("숫자 야구 게임을 시작합니다.");     //opening message
        number = new int[3];        //create number array
        userNumber = new int[3];    //create userNumber
        missionComplete = false;    //now playing
        scanner = new Scanner(System.in);   //user input
    }

    private void makeNumber()       //create number
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        setNumber(computer);        //setNumber

        /*for(int i = 0;i<3;i++)
        {
            System.out.println(number[i]);
        }*/
    }
    private void setNumber(List<Integer> computer)      //setNumber
    {
        for (int i=0;i<3;i++)
        {
            int n = Integer.parseInt(computer.get(i).toString());   // Integer to int
            this.number[i] = n;     //set number
        }
    }

    public void gameStart()        //gameStart
    {
        makeNumber();
        int input;
        while (!missionComplete) {
            System.out.print("숫자를 입력해주세요 :");
            input = scanner.nextInt();
            setUserNumber(input);     //setUserNumber
            referee();          //Ball count discrimination
            System.out.println();
            if(missionComplete)
            {
                complete();
            }
        }
    }

    public void setUserNumber(int num)
    {
        this.userNumber[0] = num / 100;
        this.userNumber[1] = num % 100 / 10;
        this.userNumber[2] = num % 10;
    }

    public void referee()       //Ball count discrimination
    {
        int strike = 0,ball = 0;
        strike = inStrikeZone();
        ball = outStrikeZone();
        if(ball != 0) {
            System.out.print(ball+"볼 ");
        }
        if (strike != 0) {
            System.out.print(strike+"스트라이크");
        }if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if(strike == 3) {
            missionComplete = true;
        }
    }

    private int inStrikeZone()     //is it strike?
    {
        int result = 0;
        for(int i=0;i<3;i++)
        {
            if(userNumber[i] == number[i])
            {
                result++;
            }
        }
        return result;
    }

    private int outStrikeZone()     //is it ball?
    {
        int result = 0;
        boolean ballds;
        for(int i=0;i<3;i++)
        {
            ballds = inCount(userNumber[i]);
            if(userNumber[i] != number[i] && ballds)
            {
                result++;
            }
        }
        return result;
    }

    private boolean inCount(int n)       //is that index in number?
    {
        for(int i=0;i<3;i++)
        {
            if(number[i] == n)
            {
                return true;
            }
        }
        return false;
    }

    private void complete()             //game done
    {
        int restart = 0;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restart = scanner.nextInt();
        newGame(restart);
    }

    private void newGame(int n)          //user input 1 or 2
    {
        if(n == 1)
        {
            missionComplete = false;        //new game
            makeNumber();                   //new number
        }
        else if(n == 2)
        {
            missionComplete = true;         //program terminate
        }
    }

}
