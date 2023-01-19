package baseball;

import java.util.ArrayList;
import java.util.List;
import static baseball.Random.COMPUTER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private int num=0;

    public int getNum(){
        return num;
    }

    public void Input() {     //숫자 입력 받는 함수
        System.out.println("숫자를 입력해주세요 : ");
        try {
            num = Integer.parseInt(readLine());
        } catch (Exception e) {    //숫자를 입력받지 않을 때 예외처리
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public List<Integer> InputSplit(int num){   //입력 받은 정수를 배열로 바꾸는 함수
        List<Integer> Input = new ArrayList<>();
        Input.add(num/100);
        Input.add((num%100)/10);
        Input.add((num%100)%10);
        return Input;
    }

    public int InputCount(int num){     //입력 받은 정수가 몇자리인지 세는 함수
        int count = 0;
        while(num != 0){
            num = num / 10;
            ++count;
        }
        return count;
    }

    public void InputException(int count){     //입력 받은 정수의 자리수에 따른 예외처리
        if(count != COMPUTER_SIZE){
            throw new IllegalArgumentException("입력 값의 크기는 "+count+"입니다.");
        }
    }
}
