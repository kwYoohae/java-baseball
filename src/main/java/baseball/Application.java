package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) { //main
        int game = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        Manager m = new Manager();
        do{
            m.run(); //Start the entire game
            String state = readLine();
            if(state.length()!=1) //enter invalid length of game state
                throw new IllegalArgumentException("잘못된 값 입력");
            if(state.charAt(0) != '1' && state.charAt(0) != '2') //enter invalid value other than 1 or 2
                throw new IllegalArgumentException("잘못된 값 입력");
            game = (state.charAt(0) - '0'); //change the format (char to int)
        } while(game == 1); //if game is 1, continue the game
        System.out.println("게임 종료");
    }
}
