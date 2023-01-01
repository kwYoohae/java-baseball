package baseball;

import java.util.ArrayList;
import java.util.Objects;

public class Manager {

    ArrayList<Integer> computerNumbers;
    ArrayList<Integer> userNumbers;
    void run(){ //game run
        try {
            Number numberClass = new Number(1, 9);
            this.computerNumbers = numberClass.getComputerNumbers();
            while(true) {
                this.userNumbers = numberClass.getUserNumbers();
                int result = comparisonNumbers();
                userNumbers.clear();

                if(result == 30)
                    break;
            }
        } catch (Exception e) {
            //게임 종료, 게임종료시 ArrayList 초기화 필요
        }
    }

    int comparisonNumbers(){
        int strike = 0;
        int ball = 0;
        for(int i=0; i<3; i++){
            if(Objects.equals(computerNumbers.get(i), userNumbers.get(i)))
                strike++;
            else if(computerNumbers.contains(userNumbers.get(i)))
                ball++;
        }

        return strike*10 + ball;
    }
}
