package baseball;

import java.util.ArrayList;
import java.util.List;

public class ExceptionCase {

    public final static int USER_NUMBER_SIZE = 3;
    private List<Integer> userNum = new ArrayList<>();

    ExceptionCase(List<Integer> userNum) {
        this.userNum = userNum;
        isInputError();
    }

    private void isInputError() {
        wrongSize();
        duplicatedNum();
        zeroNum();
        notNumber();
    }

    private void wrongSize() {
        if(userNum.size() != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException(USER_NUMBER_SIZE + "개의 숫자를 입력해야 합니다");
        }
    }

    private void duplicatedNum() {
        if(userNum.size() != userNum.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private void zeroNum() {
        if(userNum.contains(0) == true) {
            throw new IllegalArgumentException("입력된 숫자 중 0이 존재합니다.");
        }
    }

    private void notNumber() {
        for (int i = 0; i < userNum.size(); i++) {
            char input = Integer.toString(userNum.get(i)).charAt(0);
            if (48 > input && input > 57) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }
        }
    }
}
