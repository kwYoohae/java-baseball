package baseball;

import java.util.ArrayList;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    private final static int GAME_RESTART = 1;
    private final static int GAME_END = 2;
    private final static int ALL_STRIKE = 30;
    private final static int NOTHING_CORRECT = 0;


    public final static int NUMBER_LENGTH = 3;
    public final static int startRange = 1;
    public final static int endRange = 9;

    public void run() {
        int gameStatus = GAME_END;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            executeGame();

            String state = readLine();
            MyException.gameStateException(state);

            gameStatus = state.charAt(0) - '0';

        } while(gameStatus == GAME_RESTART);

        System.out.println("게임 종료");
    }

    private void executeGame(){
        BaseballGame baseballGame = new BaseballGame();

        baseballGame.assignComputerNumbers();
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            baseballGame.assignUserNumbers();

            int result = baseballGame.compareNumbers();
            printResult(result);
            if(result == ALL_STRIKE) {
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
}
