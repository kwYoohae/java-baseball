package baseball;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserNumber {
    ArrayList<Integer> getUserNumbers(){ //사용자에게 1~9 사이의 서로 다른 수 입력받는 메서드
        ArrayList<Integer> userNumbers = new ArrayList<>();
        String numbers = readLine(); //get string without separator

        MyException.userNumberGetException(numbers);

        for(int i=0; i<3; i++){
            char c = numbers.charAt(i);
            MyException.userNumberContainException(c, userNumbers);
            userNumbers.add(c - '0');
        }

        return userNumbers;
    }
}
