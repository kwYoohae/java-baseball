package baseball;

public class Print { // class for print message

    public static void startBaseBall() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void ballNewLine(Integer numOfBall) {
        System.out.println(numOfBall + "볼 ");
    }

    public static void ball(Integer numOfBall) {
        System.out.print(numOfBall + "볼 ");
    }

    public static void strike(Integer numOfStrike) {
        System.out.println(numOfStrike + "스트라이크 ");
    }

    public static void nothing() {
        System.out.println("낫싱");
    }

    public static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
