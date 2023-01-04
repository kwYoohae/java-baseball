package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = random();
        int game = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(game==1){        //숫자 야구 게임
            check(computer);   //볼 스크라이크 구분
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game = scanner.nextInt();   //재시작, 종료 입력
        }
        scanner.close();
    }

    public static List<Integer> random() {    //random 숫자 구하기
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void check(List<Integer> computer){  //볼 스트라이크 구분
        while(true){
            List<Integer> Input = input();

        }
    }

    public static List<Integer> input(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> Input = new ArrayList<>();

        Input.add(num/100);
        Input.add((num%100)/10);
        Input.add((num%100)%10);
        scanner.close();
        return Input;
    }

}
