package baseball;

public class numberBaseball {
    private Generator generator;        //숫자 생성
    private Reader reader;              //사용자 입력
    private Referee referee;            //볼카운트 판별
    private Printer printer;            //출력
    private boolean regame;             //게임 재시작

    numberBaseball()
    {
        generator = new Generator();    //숫자 만들어짐
        reader = new Reader();
        referee = new Referee();
        printer = new Printer();
        regame = true;
        printer.openning();
    }

    public void playBall()
    {
        while (regame)
        {
            reader.inputUserNumber();       //유저 숫자 입력
            referee.judgement(reader.returnUserInput(), generator.getBallCount());      //볼카운트 판별
            printer.call(referee.getBall(), referee.getStrike());       //볼카운트 출력
            setRegame(referee.getStrike());     //재시작여부
            referee.empty();        //유저입력 초기화
        }
        System.out.println("게임 종료");
    }

    private void setRegame(int s)
    {
        if(s == 3)      //3스트라이크 일 경우
        {
            reGameUserInput(reader.inputReGame());  //다시할껀지 입력받음
        }
    }

    private void reGameUserInput(int n)
    {
        if(n == 1)
        {
            this.regame = true;
            generator.makeNumber();
        }
        else if(n==2) this.regame = false;
    }
}
