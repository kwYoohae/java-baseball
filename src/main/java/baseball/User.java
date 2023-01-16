package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> userNum = new ArrayList<>();

    public User() {
        inputNum();
        isException();
    }

    public List<Integer> getUserNum() {
        return userNum;
    }

    private void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String readNum = Console.readLine();

        String[] num = readNum.split("");

        for(int i = 0; i < readNum.length(); i++) {
            int number = Integer.parseInt(num[i]);
            this.userNum.add(number);
        }
    }

    private void isException() {
        ExceptionCase exception = new ExceptionCase();
        exception.wrongSize(userNum);
        exception.duplicatedNum(userNum);
        exception.zeroNum(userNum);
        exception.notNumber(userNum);
    }
}
