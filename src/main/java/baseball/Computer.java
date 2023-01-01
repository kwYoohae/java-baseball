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

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        makeRandomNum();
        inputNum();
        exception.userNumberException(userNumList);
    }

    public void makeRandomNum(){ // make 3 random number

        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }

    public void inputNum(){
        System.out.println("숫자를 입력해주세요 : ");
        userNumList=user.getUserNumList();
    }
}
