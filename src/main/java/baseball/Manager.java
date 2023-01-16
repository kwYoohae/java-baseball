package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {


    private List<Integer> ballCount;        //게임의 랜덤 볼카운트
    private int []userNumber;   //user's input  유저 입력 숫자
    private List<Integer> userCount;        //유저의 입력 카운트
    private boolean missionComplete;        //is game done? 게임이 끝나는가
    private Scanner scanner;        //user input scanner 유저 입력 scanner
    final private int bits = 3;         //몇자리인가

    Manager()       //constructor
    {
        System.out.println("숫자 야구 게임을 시작합니다.");     //opening message
        userNumber = new int[bits];    //create userNumber     배열생성
        ballCount = new ArrayList<>();
        userCount = new ArrayList<>();
        missionComplete = false;    //now playing
        scanner = new Scanner(System.in);   //user input    스캐너생성
    }

    private void makeNumber()       //create number
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < bits) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //제공된 랜덤숫자
        ballCount = computer;       //랜덤숫자를 ballCount로
    }

    public void gameStart()        //gameStart
    {
        makeNumber();   //init number
        int input;      //user input number
        while (!missionComplete) {
            System.out.print("숫자를 입력해주세요 :");
            input = scanner.nextInt();
            setUserNumber(input);     //setUserNumber
            referee();          //Ball count discrimination     볼카운트 판별
            System.out.println();       //줄바꿈 형식
            inningDone();   //한차례 종료
        }
    }

    public void setUserNumber(int num)
    {
        this.userNumber[0] = num / 100;
        this.userNumber[1] = num % 100 / 10;
        this.userNumber[2] = num % 10;
        for(int i=0;i<bits;i++)
        {
            userCount.add(userNumber[i]);
        }
    }

    public void referee()       //볼카운트 판정
    {
        int strike = 0,ball = 0;
        strike = inStrikeZone();
        ball = outStrikeZone();
        call(ball,strike);      //스트라이크 콜
    }

    public void call(int ball, int strike)       //볼카운트 출력
    {
        if(ball != 0) {
            System.out.print(ball+"볼 ");
        }
        if (strike != 0) {
            System.out.print(strike+"스트라이크");
        }if(strike == 0 && ball == 0) {
        System.out.print("낫싱");
    }
        if(strike == bits) {
            missionComplete = true;
        }
    }

    private int inStrikeZone()     //is it strike?
    {
        int result = 0;
        for(int i=0;i<bits;i++)        //숫자와 자리가 같은경우
        {
            if(userCount.get(i) == ballCount.get(i))
            {
                result+=1;
            }
        }
        return result;
    }

    private int outStrikeZone()     //is it ball?
    {
        int result = 0;
        boolean ballds;
        for(int i=0;i<bits;i++)
        {
            ballds = inCount(userNumber[i]);
            if(userNumber[i] != ballCount.get(i) && ballds)        //숫자는 같으나 자리는 다른경우
            {
                result++;
            }
        }
        return result;
    }

    private boolean inCount(int n)       //is that index in number?
    {
        for(int i=0;i<bits;i++)        //다른자리에 값이 있는경우
        {
            if(ballCount.get(i) == n)
            {
                return true;
            }
        }
        return false;
    }

    private void complete()             //game done
    {
        int restart = 0;        //user input
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
            empty();
            makeNumber();                   //new number
        }
        else if(n == 2)
        {
            missionComplete = true;         //program terminate
        }
    }

    private void empty()             //볼카운트를 맞추지 못했을 때 유저의 볼카운트 초기화
    {
       for (int i=2;i>=0;i--)
       {
           userCount.remove(i);
       }
    }

    private void inningDone()             //횟수가 끝나고 다시 진행 및 재시작 및 종료
    {
        if(missionComplete)     //게임 종료시
        {
            complete();
        }
        else                    //게임이 안끝나고 유저의 카운트 초기화
        {
            empty();
        }
    }

}
