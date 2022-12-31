package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    Print print = new Print();
    User user = new User();
    List<Integer> userNumList = new ArrayList<>();

    public void start(){
        print.printStartGame();
        makeRandomNum();
        inputNum();
    }

    public void makeRandomNum(){
        List<Integer> randomNum = new ArrayList<>(); // ArrayList for make 3 random numbers
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }

    public void inputNum(){
        print.printInputNum();
        userNumList=user.getUserNumList();
        for(int i=0; i<3; i++)
            System.out.println(userNumList.get(i));
    }
}
