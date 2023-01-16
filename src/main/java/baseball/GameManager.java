package baseball;

import java.util.ArrayList;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    private final static int GAME_RESTART = 1;
    private final static int GAME_END = 2;
    private final static int ALL_STRIKE = 30;
    private final static int NOTHING_CORRECT = 0;

    private final static int NUMBER_LENGTH = 3;

    private final static int startRange = 1;
    private final static int endRange = 9;

    private ArrayList<Integer> computerNumbers;
    private ArrayList<Integer> userNumbers;

    public void run() {
        int gameStatus = GAME_END;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            executeGame();

            String state = readLine();
            MyException.gameStateException(state);

            gameStatus = state.charAt(0);

        } while(gameStatus == GAME_RESTART);

        System.out.println("게임 종료");
    }

    private void executeGame(){
        Number manageNumber = new Number(1, 9);
        computerNumbers = manageNumber.getComputerNumbers();
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            userNumbers = manageNumber.getUserNumbers();

            int result = compareNumbers();
            userNumbers.clear();
            printResult(result);
            if(result == ALL_STRIKE) {
                computerNumbers.clear();
                break;
            }
        }
    }

    private void printResult(int result){
        if(result == ALL_STRIKE){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        }
        else if(result == NOTHING_CORRECT){
            System.out.println("낫싱");
        }
        else{
            System.out.println(result%10+"볼 "+result/10+"스트라이크");
        }
    }

    int compareNumbers(){
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
