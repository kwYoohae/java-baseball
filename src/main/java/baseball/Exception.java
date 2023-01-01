package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Exception {

    public void rangeOfUserNumber(List<Integer> userNumList){
        for(int i = 0; i<userNumList.size(); i++){
            if(userNumList.get(i)>9 || userNumList.get(i)<1)
                throw new IllegalArgumentException("각 숫자는 1 이상 9 이하로 구성되어야 합니다.");
        }
    }

    public void userNumberLength(List<Integer> userNumList){
        if(userNumList.size()!=3)
            throw new IllegalArgumentException("숫자가 3개의 자리가 아닙니다.");
    }

    public void judgeIsNumber(List<String> stringList){
        for(int i = 0; i<stringList.size(); i++){
            if(stringList.get(i).charAt(i)<'0' || stringList.get(i).charAt(i)>'9')
                throw new IllegalArgumentException("숫자 이외의 다른 문자가 입력되었습니다.");
        }
    }

    public void userNumberException(List<Integer> userNumList){
        userNumberLength(userNumList);
        rangeOfUserNumber(userNumList);
    }
}
