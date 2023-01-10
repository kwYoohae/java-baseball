package baseball;

import java.util.ArrayList;

public class MyException {
    static public void gameStateException(String state){
        if(state.length()!=1) //enter invalid length of game state
            throw new IllegalArgumentException("잘못된 값 입력");

        if(state.charAt(0) != '1' && state.charAt(0) != '2') //enter invalid value other than 1 or 2
            throw new IllegalArgumentException("잘못된 값 입력");
    }

    static public void userNumberGetException(String userNumbers){
        if(userNumbers.length() != 3) //적게 또는 많이 입력했을 때
            throw new IllegalArgumentException("입력받은 문자열이 3보다 길거나 짧음");

        for(int i=0; i<3; i++){
            char c = userNumbers.charAt(i);
            if('1' > c || '9' < c) //지정된 범위의 숫자가 아닐 때
                throw new IllegalArgumentException("1~9 사이의 숫자가 아닌 값이 입력됨");
        }
    }

    static public void userNumberContainException(char c, ArrayList<Integer> userNumbers){
        if(userNumbers.contains(c-'0'))
            throw new IllegalArgumentException("중복된 수를 입력함");
    }
}
