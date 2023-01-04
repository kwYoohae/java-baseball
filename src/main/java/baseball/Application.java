package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int game = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(game==1){        //숫자 야구 게임
            check();           //볼 스크라이크 구분
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

    public static void check(){  //볼 스트라이크 구분
        List<Integer> computer = random();
        System.out.println(computer);
        while(true){
            List<Integer> Input = input();
            int strike = strike(computer, Input);  //스트라이크인 경우
            int ball = ball(computer, Input);      //볼인 경우
            print(strike, ball);
            if(strike==3){         //다 맞춘 경우 while문 끝내기
                break;
            }
        }
    }

    public static List<Integer> input(){   //입력 받은 정수를 배열로 바꾸는 함수
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요 : ");
        int num = scanner.nextInt();
        List<Integer> Input = new ArrayList<>();

        Input.add(num/100);       //백의자리
        Input.add((num%100)/10);  //십의자리
        Input.add((num%100)%10);  //일의자리
        return Input;
    }

    public static int strike(List<Integer> computer, List<Integer> input){  //스트라이크인 경우 세기
        int sum = 0;
        for(int i=0; i<3; i++){
            if(computer.get(i)==input.get(i)){  //같은 위치에 같은 값이 있는가
                sum++;
            }
        }
        return sum;
    }

    public static int ball(List<Integer> computer, List<Integer> input){  //볼인 경우 세기
        int sum = 0;
        for(int i=0; i<3; i++){
            if(computer.contains(input.get(i)) && computer.get(i)!=input.get(i)){   //스트라이크가 아니고 볼인 경우
                sum++;
            }
        }
        return sum;
    }

    public static void print(int strike, int ball){   //결과 출력
        if(strike > 0 && ball > 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if(strike > 0){
            System.out.println(strike+"스트라이크");
        }
        else if(ball > 0){
            System.out.println(ball+"볼");
        }
        else{
            System.out.println("낫싱");
        }
    }

}
