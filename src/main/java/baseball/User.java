package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userNum;
    private List<Integer> userNumList = new ArrayList<>();
    Exception exception = new Exception();

    public void setUserNum(){
        userNum= Console.readLine();
        makeStringList(userNum);
    }

    public void makeStringList(String str){
        List<String> userNumStringList = new ArrayList<>();
        for(int i=0; i<str.length(); i++)
            userNumStringList.add(str.substring(i, i+1));
        convertStringToInteger(userNumStringList);
    }

    public void convertStringToInteger(List<String> stringList){
        for(int i=0; i<stringList.size(); i++){
            exception.judgeIsNumber(stringList);
            userNumList.add(Integer.parseInt(stringList.get(i)));
        }
    }

    public List<Integer> getUserNumList(){
        setUserNum();
        return userNumList;
    }
}
