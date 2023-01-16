package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Exception.MAX_NUM;
import static baseball.Exception.MIN_NUM;

public class Computer { // class for game management

    public final static Integer THREE_STRIKE = 3;
    public final static Integer ZERO = 0;
    public Integer numOfBall = ZERO, numOfStrike = ZERO; // judge number of Ball, number of Strike
    User user = new User();
    Exception exception = new Exception();
    List<Integer> userNum = new ArrayList<>(); // ArrayList for user's 3 numbers
    List<Integer> randomNum = new ArrayList<>(); // ArrayList for make 3 random numbers

    public void start() { // start game
        Print.startBaseBall();
        makeRandomNum();
        System.out.println(randomNum);
        judgeAnswer();
    }

    public void makeRandomNum() { // make 3 random number
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }

    public void judgeAnswer() { // judge answer logic
        while (!userNum.equals(randomNum)) { // if user input number is different with computer's random number
            initialize();
            inputNum();
            exception.userNumberException(userNum);
            countBall();
            judgeStrike();
            if(breakForNewGame())
                break;
            judgeNothing();
            printAnswerInformation();
        }
    }

    public boolean breakForNewGame(){
        if(userNum.equals(randomNum))
            return true;
        return false;
    }

    public void initialize() { // initialize exist information for restart game
        numOfStrike = ZERO;
        numOfBall = ZERO;
        userNum.clear();
    }

    public void inputNum() { // get user number
        Print.inputNumber();
        userNum = user.getUserNum();
    }

    public void countBall() { // judge Ball's number
        for (int i = 0; i < 3; i++) {
            if ((randomNum.get(0) == userNum.get(i)) && 0 != i)
                numOfBall++;
            if ((randomNum.get(1) == userNum.get(i)) && 1 != i)
                numOfBall++;
            if ((randomNum.get(2) == userNum.get(i)) && 2 != i)
                numOfBall++;
        }
    }

    public void judgeStrike() { // judge Strike's number
        countStrike();
        if (numOfStrike == THREE_STRIKE) {
            Print.strike(numOfStrike);
            Print.endGame();
            replayOrExit(); // if strike is 3, decide replay new game or exit game
        }
    }

    public void countStrike() {
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i))
                numOfStrike++;
        }
    }

    public void judgeNothing() { // judge nothing and print nothing
        if (numOfBall == ZERO && numOfStrike == ZERO)
            Print.nothing();
    }

    public void printAnswerInformation() { // print ball and strike information
        if (numOfBall != ZERO && numOfStrike == ZERO)
            Print.ballNewLine(numOfBall);
        if (numOfBall != ZERO && numOfStrike != ZERO)
            Print.ball((numOfBall));
        if (numOfStrike != ZERO)
            Print.strike(numOfStrike);
    }

    public void replayOrExit() { // replay new game or exit game
        if (user.getUserReplayOrExit().equals("1")) {
            initialize();
            initializeRandomNum();
            start();
        }
    }

    public void initializeRandomNum() { // initialize random number for new game
        randomNum.clear();
    }
}
