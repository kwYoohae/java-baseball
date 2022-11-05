package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PrintAndRead {

    public static void firstStartPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> getBaseballNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String question = Console.readLine();

        return convertToIntegerList(question);
    }

    public static List<Integer> convertToIntegerList(String question) {
        String[] splitQuestion = question.split("");

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < question.length(); i++) {
            result.add(Integer.parseInt(splitQuestion[i]));
        }

        return result;
    }
}
