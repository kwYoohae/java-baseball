package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Random.COMPUTER_SIZE;

public class Check {
    private final int ZERO = 0;
    private Input input = new Input();
    private Random random = new Random();
    private List<Integer> inputArray = new ArrayList<>();

    public void Check() {          //볼 스트라이크 구분
        List<Integer> computer = random.Random();
        while (true) {
            SetInput();
            int strike = Strike(computer, inputArray);  //스트라이크인 경우
            int ball = Ball(computer, inputArray);      //볼인 경우
            Print(strike, ball);
            if (strike == COMPUTER_SIZE) {              //다 맞춘 경우 while문 끝내기
                break;
            }
        }
    }

    public void SetInput() {   //입력에 대한 배열 구하는 함수
        input.Input();
        int num = input.GetNum();
        input.InputException(input.InputCount(num));
        inputArray = input.InputSplit(num);
    }

    public int Strike(List<Integer> computer, List<Integer> input) {  //스트라이크인 경우 세기
        int sum = 0;
        for (int i = 0; i < COMPUTER_SIZE; i++) {
            if (computer.get(i) == input.get(i)) {  //같은 위치에 같은 값이 있는가
                sum++;
            }
        }
        return sum;
    }

    public int Ball(List<Integer> computer, List<Integer> input) {  //볼인 경우 세기
        int sum = 0;
        for (int i = 0; i < COMPUTER_SIZE; i++) {
            if (computer.contains(input.get(i)) && computer.get(i) != input.get(i)) {   //스트라이크가 아니고 볼인 경우
                sum++;
            }
        }
        return sum;
    }

    public void Print(int strike, int ball) {   //결과 출력
        if (strike > ZERO && ball > ZERO) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > ZERO) {
            System.out.println(strike + "스트라이크");
        } else if (ball > ZERO) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }
}
