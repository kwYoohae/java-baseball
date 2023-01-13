package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User { // class for user

    private String inputUserNum;
    private List<String> convertBeforeUserNum = new ArrayList<>();
    private List<Integer> userNum = new ArrayList<>();
    Exception exception = new Exception();
    String replayOrExit;

    public void convertUserNum() { // set user number
        initialize();
        inputUserNum = Console.readLine();
        makeStringList(inputUserNum);
    }

    public void initialize() { // initialize value for new game
        userNum.clear();
        convertBeforeUserNum.clear();
    }

    public void makeStringList(String str) { // make user number list(String)
        for (int i = 0; i < str.length(); i++)
            convertBeforeUserNum.add(str.substring(i, i + 1));
        convertStringToInteger(convertBeforeUserNum);
    }

    public void convertStringToInteger(List<String> stringList) { // convert user number list String to Integer
        for (int i = 0; i < stringList.size(); i++) {
            exception.judgeIsNumberException(stringList);
            userNum.add(Integer.parseInt(stringList.get(i)));
        }
    }

    public List<Integer> getUserNum() { // get user number(Integer) list
        convertUserNum();
        return userNum;
    }

    public String getUserReplayOrExit() { // return replay or exit
        replayOrExit = Console.readLine();
        exception.replayOrExitNumberException(replayOrExit);
        return replayOrExit;
    }
}
