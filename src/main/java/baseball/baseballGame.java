package baseball;

public class baseballGame {
    public static final int goReGame = 1;
    public static final int noReGame = 2;
    public static final int BIT = 3;
    private Generator generator;        //숫자 생성
    private Reader reader;              //사용자 입력
    private Referee referee;            //볼카운트 판별
    private Printer printer;            //출력
    private boolean regame;             //게임 재시작

    baseballGame()
    {
        generator = new Generator();    //숫자 만들어짐
        reader = new Reader();
        referee = new Referee(BIT);
        printer = new Printer();
        regame = true;
        printer.openning();
    }
    public void playBall()
    {
        while (regame)
        {
            reader.inputUserNumber();       //유저 숫자 입력
            checkBit(reader.getUserNumber());
            referee.judgement(reader.returnUserNumber(), generator.getBallCount());      //볼카운트 판별
            printer.call(referee.getBall(), referee.getStrike());       //볼카운트 출력
            setRegame(referee.getStrike());     //재시작여부
            referee.empty();        //유저입력 초기화
        }
       printer.end();
    }

    private void setRegame(int s)
    {
        if(s == BIT)      //3스트라이크 일 경우
        {
            reGameUserInput(reader.inputReGame());  //다시할껀지 입력받음
        }
    }

    private void reGameUserInput(int n)
    {
        if(n == goReGame)
        {
            this.regame = true;
            generator.makeNumber();
        }
        else if(n==noReGame) this.regame = false;
    }

    private void checkBit(int userNumber)     //자릿수 검증
    {
        if(userNumber / 1000 > 0 || userNumber < 100)
        {
            throw new IllegalArgumentException("Number length is too long");
        }
    }
}
