package baseball;

import java.util.ArrayList;
import java.util.Random;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Number {

    private int startRange = 0;
    private int endRange = 0;

    Number(int startRange, int endRange){
        this.startRange = startRange;
        this.endRange = endRange;
    }

    ArrayList<Integer> getComputerNumbers(){
        ArrayList<Integer> computerNumbers = new ArrayList<>();

        while(computerNumbers.size() < 3){
            int num = pickNumberInRange(startRange, endRange); //extract random number between entered range
            if(!computerNumbers.contains(num)){ //Do not save duplicate numbers
                computerNumbers.add(num);
            }
        }

        return computerNumbers; //return ArrayList Non-duplicated, 3 digits in range
    }

    ArrayList<Integer> getUserNumbers(){ //사용자에게 1~9 사이의 서로 다른 수 입력받는 메서드
        ArrayList<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
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
