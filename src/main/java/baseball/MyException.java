package baseball;

import java.util.ArrayList;

public class MyException {

    public final static String INVALID_LENGTH = "잘못된 길이의 수 입력";
    public final static String INVALID_VALUE = "지정된 범위 밖의 수 입력";
    static public void gameStateException(String state) {
        if (state.length() != 1) //enter invalid length of game state
            throw new IllegalArgumentException(INVALID_LENGTH);

        if (state.charAt(0) != '1' && state.charAt(0) != '2') //enter invalid value other than 1 or 2
            throw new IllegalArgumentException(INVALID_VALUE);
    }

    static public void userNumberGetException(String userNumbers) {
        if (userNumbers.length() != GameManager.NUMBER_LENGTH) //적게 또는 많이 입력했을 때
            throw new IllegalArgumentException(INVALID_LENGTH);

        for (int i = 0; i < GameManager.NUMBER_LENGTH; i++) {
            char c = userNumbers.charAt(i);
            if ('1' > c || '9' < c) //지정된 범위의 숫자가 아닐 때
                throw new IllegalArgumentException(INVALID_VALUE);
        }
    }

    static public void userNumberContainException(char c, ArrayList<Integer> userNumbers) {
        if (userNumbers.contains(c - '0'))
            throw new IllegalArgumentException("중복된 수를 입력함");
    }
}
