package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer { // class for game management

    User user = new User();
    Exception exception = new Exception();
    List<Integer> userNumList = new ArrayList<>(); // ArrayList for user's 3 numbers
    List<Integer> randomNum = new ArrayList<>(); // ArrayList for make 3 random numbers
    Integer numOfBall = 0, numOfStrike = 0; // judge number of Ball, number of Strike

    public void start(){ // start game
        makeRandomNum();
        judgeAnswer();
    }

    public void makeRandomNum(){ // make 3 random number
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }

    public void inputNum(){ // get user number
        System.out.print("숫자를 입력해주세요 : ");
        userNumList=user.getUserNumList();
    }

    public void judgeBall(){ // judge Ball's number
        for(int i=0; i<3; i++) {
            if((randomNum.get(0) == userNumList.get(i)) && 0 != i)
                numOfBall++;
            if((randomNum.get(1) == userNumList.get(i)) && 1 != i)
                numOfBall++;
            if((randomNum.get(2) == userNumList.get(i)) && 2 != i)
                numOfBall++;
        }
    }

    public void judgeStrike(){ // judge Strike's number
        for(int i = 0; i<3; i++){
            if(randomNum.get(i) == userNumList.get(i))
                numOfStrike++;
        }
        if(numOfStrike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replayOrExit(); // if strike is 3, decide regame or exit game
        }
    }

    public void printAnswerInformation(){ // print ball and strike information
        if(numOfBall!=0 && numOfStrike==0)
            System.out.println(numOfBall+"볼 ");
        if(numOfBall!=0 && numOfStrike!=0)
            System.out.print(numOfBall+"볼 ");
        if(numOfStrike!=0)
            System.out.println(numOfStrike+"스트라이크 ");
    }

    public void replayOrExit(){ // replay game or exit game
        String renewOrExit;
        renewOrExit= Console.readLine();
        if(renewOrExit.equals("1")){
            initialForNew();
            randomNum.clear();
            start();
        }
    }

    public void judgeNothing(){ // judge nothing and print nothing
        if(numOfBall==0 && numOfStrike==0)
            System.out.println("낫싱");
    }

    public void initialForNew(){ // initialize exist information for regame
        numOfStrike=0;
        numOfBall=0;
        userNumList.clear();
    }

    public void judgeAnswer(){ // judge answer logic
        while(userNumList.equals(randomNum)!=true) { // if user input number is diffrent with computer's random number
            initialForNew();
            inputNum();
            exception.userNumberException(userNumList);
            judgeBall();
            judgeStrike();
            judgeNothing();
            printAnswerInformation();
        }
    }
}
