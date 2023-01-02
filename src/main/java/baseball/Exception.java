package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Exception { // class for exception handling

    public void rangeOfUserNumber(List<Integer> userNumList){ // exception for number compose
        for(int i = 0; i<userNumList.size(); i++){
            if(userNumList.get(i)>9 || userNumList.get(i)<1)
                throw new IllegalArgumentException("각 숫자는 1 이상 9 이하로 구성되어야 합니다.");
        }
    }

    public void userNumberLength(List<Integer> userNumList){ // exception for number of length
        if(userNumList.size()!=3)
            throw new IllegalArgumentException("숫자가 3개의 자리가 아닙니다.");
    }

    public void judgeIsNumber(List<String> stringList){ // exception for other letter
        for(int i = 0; i<3; i++){
            if(stringList.get(i).charAt(0)<'0' || stringList.get(i).charAt(0)>'9')
                throw new IllegalArgumentException("숫자 이외의 다른 문자가 입력되었습니다.");
        }
    }

    public void userNumberException(List<Integer> userNumList){ // fuction for exception
        userNumberLength(userNumList);
        rangeOfUserNumber(userNumList);
        eachUserNumberDifferent(userNumList);
    }

    public void eachUserNumberDifferent(List<Integer> userNumList){ // exception for compose same number
        if(userNumList.get(0) == userNumList.get(1) || userNumList.get(0) == userNumList.get(2) || userNumList.get(1) == userNumList.get(2))
            throw new IllegalArgumentException("서로 다른 3자리 수가 아닙니다.");
    }
}
