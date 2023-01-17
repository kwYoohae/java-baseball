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
        String readInput = Console.readLine();

        String[] inputWord = readInput.split("");
        ExceptionCase.notNumber(inputWord);

        for(int i = 0; i < readInput.length(); i++) {
            int number = Integer.parseInt(inputWord[i]);
            this.userNum.add(number);
        }
    }

    private void isException() {
        ExceptionCase.wrongSize(this.userNum);
        ExceptionCase.duplicatedNum(this.userNum);
        ExceptionCase.zeroNum(this.userNum);
    }
}
