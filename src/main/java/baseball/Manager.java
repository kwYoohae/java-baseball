package baseball;

import java.util.ArrayList;
import java.util.Objects;

public class Manager {

    ArrayList<Integer> computerNumbers;
    ArrayList<Integer> userNumbers;
    void run(){ //game run
        System.out.println("숫자 야구 게임을 시작합니다.");
        Number numberClass = new Number(1, 9);
        this.computerNumbers = numberClass.getComputerNumbers();
        while(true) {
            this.userNumbers = numberClass.getUserNumbers();
            int result = comparisonNumbers();
            userNumbers.clear();
            printResult(result);
            if(result == 30)
                break;
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

    void printResult(int result){
        if(result == 30){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        }
        else if(result == 0){
            System.out.println("낫싱");
        }
        else{
            System.out.println(result%10+"볼 "+result/10+"스트라이크");
        }
    }
}
