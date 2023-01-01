package baseball;

import java.util.ArrayList;
import java.util.Random;

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
}
