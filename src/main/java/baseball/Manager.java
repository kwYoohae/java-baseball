package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    //private int []number;     //random number array 랜덤 숫자
    private List<Integer> nnumber;
    private int []userNumber;   //user's input  유저 입력 숫자
    private List<Integer> uuserNumber;
    private boolean missionComplete;        //is game done? 게임이 끝나는가
    private Scanner scanner;        //user input scanner 유저 입력 scanner

    Manager()       //constructor
    {
        System.out.println("숫자 야구 게임을 시작합니다.");     //opening message
        //number = new int[3];        //create number array   배열생성
        userNumber = new int[3];    //create userNumber     배열생성
        nnumber = new ArrayList<>();
        uuserNumber = new ArrayList<>();
        missionComplete = false;    //now playing
        scanner = new Scanner(System.in);   //user input    스캐너생성
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
        //제공된 랜덤숫자
        setNumber(computer);        //setNumber     랜덤숫자 멤버변수 set
        System.out.println(nnumber);
    }
    private void setNumber(List<Integer> computer)      //setNumber
    {
        /*for (int i=0;i<3;i++)
        {
            int n = Integer.parseInt(computer.get(i).toString());   // Integer to int
            this.number[i] = n;     //set number
        }*/
       nnumber = computer;
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
            if(missionComplete)     //게임 종료시
            {
                complete();
            }
            else
            {
                empty();
            }
        }
    }

    public void setUserNumber(int num)
    {
        this.userNumber[0] = num / 100;
        this.userNumber[1] = num % 100 / 10;
        this.userNumber[2] = num % 10;
        for(int i=0;i<3;i++)
        {
            uuserNumber.add(userNumber[i]);
        }
        System.out.println(uuserNumber);
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
        for(int i=0;i<3;i++)        //숫자와 자리가 같은경우
        {
            if(uuserNumber.get(i) == nnumber.get(i))
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
        for(int i=0;i<3;i++)
        {
            ballds = inCount(userNumber[i]);
            if(userNumber[i] != nnumber.get(i) && ballds)        //숫자는 같으나 자리는 다른경우
            {
                result++;
            }
        }
        return result;
    }

    private boolean inCount(int n)       //is that index in number?
    {
        for(int i=0;i<3;i++)        //다른자리에 값이 있는경우
        {
            if(nnumber.get(i) == n)
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
           uuserNumber.remove(i);
       }
    }

}
