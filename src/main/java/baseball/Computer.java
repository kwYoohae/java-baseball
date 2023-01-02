package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    User user = new User();
    Exception exception = new Exception();
    List<Integer> userNumList = new ArrayList<>(); // ArrayList for user's 3 numbers
    List<Integer> randomNum = new ArrayList<>(); // ArrayList for make 3 random numbers
    Integer numOfBall = 0, numOfStrike = 0;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
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
        System.out.println(randomNum);
    }

    public void inputNum(){
        System.out.print("숫자를 입력해주세요 : ");
        userNumList=user.getUserNumList();
    }

    public void judgeBall(){
        for(int i=0; i<3; i++) {
            if((randomNum.get(0) == userNumList.get(i)) && 0 != i)
                numOfBall++;
            if((randomNum.get(1) == userNumList.get(i)) && 1 != i)
                numOfBall++;
            if((randomNum.get(2) == userNumList.get(i)) && 2 != i)
                numOfBall++;
        }
        if(numOfBall!=0)
            System.out.print(numOfBall+"볼 ");
    }

    public void judgeStrike(){
        for(int i = 0; i<3; i++){
            if(randomNum.get(i) == userNumList.get(i))
                numOfStrike++;
        }
        if(numOfStrike!=0)
            System.out.println(numOfStrike+"스트라이크 ");
    }

    public void judgeNothing(){
        if(numOfBall==0 && numOfStrike==0)
            System.out.println("낫싱");
    }

    public void judgeAnswer(){
        while(userNumList != randomNum){
            userNumList.clear();
            inputNum();
            exception.userNumberException(userNumList);
            judgeBall();
            judgeStrike();
            judgeNothing();
        }
    }
}
