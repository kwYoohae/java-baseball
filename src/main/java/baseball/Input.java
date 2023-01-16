package baseball;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static List<Integer> input(){   //입력 받은 정수를 배열로 바꾸는 함수
        System.out.println("숫자를 입력해주세요 : ");
        int num = Integer.parseInt(readLine());
        List<Integer> Input = new ArrayList<>();

        Input.add(num/100);       //백의자리
        Input.add((num%100)/10);  //십의자리
        Input.add((num%100)%10);  //일의자리
        return Input;
    }
}
