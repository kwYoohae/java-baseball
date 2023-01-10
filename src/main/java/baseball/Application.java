package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public final static int GAME_RESTART = 1;
    public final static int GAME_END = 2;

    public static void main(String[] args) { //main
        int game = GAME_END;
        Manager m = new Manager();

        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            m.run(); //Start the entire game
            String state = readLine();

            MyException.gameStateException(state);
            game = (state.charAt(0) - '0'); //change the format (char to int)

        } while(game == GAME_RESTART); //if game is 1, continue the game

        System.out.println("게임 종료");
    }
}
