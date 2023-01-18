package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Exception {
    private final static int COMMAND_RESTART = 1;
    private final static int COMMAND_END = 2;

    public static boolean StartException(){      //새로 시작할 때의 예외처리
        System.out.println("게임을 새로 시작하려면 "+COMMAND_RESTART+", 종료하려면 "+COMMAND_END+"를 입력하세요.");
        int selectStart = Integer.parseInt(readLine());   //재시작, 종료 입력
        if(selectStart == COMMAND_RESTART){
            return true;
        }
        else if(selectStart == COMMAND_END){
            return false;
        }
        else{
            throw new IllegalArgumentException("게임을 새로 시작하려면 "+COMMAND_RESTART+", 종료하려면 "+COMMAND_END+"를 입력하세요.");
        }
    }
}
