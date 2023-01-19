package baseball;

import java.util.List;
import static baseball.Input.Input;
import static baseball.Random.COMPUTER_SIZE;
import static baseball.Random.random;

public class Check {
    private static final int ZERO=0;
    public static void check(){  //볼 스트라이크 구분
        List<Integer> computer = random();
        /*
        while(true){
            List<Integer> Input = Input();
            int strike = strike(computer, Input);  //스트라이크인 경우
            int ball = ball(computer, Input);      //볼인 경우
            print(strike, ball);
            if(strike==COMPUTER_SIZE){         //다 맞춘 경우 while문 끝내기
                break;
            }
        }
         */
    }

    public static int strike(List<Integer> computer, List<Integer> input){  //스트라이크인 경우 세기
        int sum = 0;
        for(int i=0; i<COMPUTER_SIZE; i++){
            if(computer.get(i)==input.get(i)){  //같은 위치에 같은 값이 있는가
                sum++;
            }
        }
        return sum;
    }

    public static int ball(List<Integer> computer, List<Integer> input){  //볼인 경우 세기
        int sum = 0;
        for(int i=0; i<COMPUTER_SIZE; i++){
            if(computer.contains(input.get(i)) && computer.get(i)!=input.get(i)){   //스트라이크가 아니고 볼인 경우
                sum++;
            }
        }
        return sum;
    }

    public static void print(int strike, int ball){   //결과 출력
        if(strike > ZERO && ball > ZERO){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if(strike > ZERO){
            System.out.println(strike+"스트라이크");
        }
        else if(ball > ZERO){
            System.out.println(ball+"볼");
        }
        else{
            System.out.println("낫싱");
        }
    }
}
