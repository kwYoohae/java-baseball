package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User { // class for user

    private String userNum;
    private List<Integer> userNumList = new ArrayList<>();
    Exception exception = new Exception();

    public void setUserNum() { // set user number
        userNum = Console.readLine();
        makeStringList(userNum);
    }

    public void makeStringList(String str) { // make user number list(String)
        List<String> userNumStringList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++)
            userNumStringList.add(str.substring(i, i + 1));
        convertStringToInteger(userNumStringList);
    }

    public void convertStringToInteger(List<String> stringList) { // convert user number list String to Integer
        for (int i = 0; i < stringList.size(); i++) {
            exception.judgeIsNumberException(stringList);
            userNumList.add(Integer.parseInt(stringList.get(i)));
        }
    }

    public List<Integer> getUserNumList() { // get user number(Integer) list
        setUserNum();
        return userNumList;
    }
}
