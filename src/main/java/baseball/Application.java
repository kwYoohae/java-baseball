package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int game = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        Manager m = new Manager();
        do{
            m.run();
            String state = readLine();
            if(state.length()!=1)
                throw new IllegalArgumentException("잘못된 값 입력");
            if(state.charAt(0) != '1' && state.charAt(0) != '2')
                throw new IllegalArgumentException("잘못된 값 입력");
            game = (state.charAt(0) - '0');
        } while(game == 1);
        System.out.println("게임 종료");
    }
}
