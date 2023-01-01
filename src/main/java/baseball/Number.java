package baseball;

import java.util.ArrayList;
import java.util.Random;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Number {

    int startRange = 0;
    int endRange = 0;

    Number(int startRange, int endRange){
        this.startRange = startRange;
        this.endRange = endRange;
    }

    ArrayList<Integer> getComputerNumbers(){
        ArrayList<Integer> computerNumbers = new ArrayList<>();

        while(computerNumbers.size() < 3){
            int num = pickNumberInRange(startRange, endRange);
            if(!computerNumbers.contains(num)){
                computerNumbers.add(num);
            }
        }

        return computerNumbers;
    }

    ArrayList<Integer> getUserNumbers(){ //사용자에게 1~9 사이의 서로 다른 수 입력받는 메서드
        ArrayList<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = readLine(); //get string without separator

        if(numbers.length() != 3) //적게 또는 많이 입력했을 때
            throw new IllegalArgumentException("입력받은 문자열이 3보다 길거나 짧음");
        for(int i=0; i<3; i++){
            char c = numbers.charAt(i);
            if('0' > c || '9' < c) //숫자가 아닐 때
                throw new IllegalArgumentException("1~9 사이의 숫자가 아닌 값이 입력됨");
            if(userNumbers.contains(c-'0'))
                throw new IllegalArgumentException("중복된 수를 입력함");
            userNumbers.add(c - '0');
        }
        return userNumbers;
    }
}
