package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer { // class for game management

    User user = new User();
    Exception exception = new Exception();
    List<Integer> userNum = new ArrayList<>(); // ArrayList for user's 3 numbers
    List<Integer> randomNum = new ArrayList<>(); // ArrayList for make 3 random numbers
    Integer numOfBall = 0, numOfStrike = 0; // judge number of Ball, number of Strike

    public void start() { // start game
        Print.startBaseBall();
        makeRandomNum();
        judgeAnswer();
    }

    public void makeRandomNum() { // make 3 random number
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }

    public void inputNum() { // get user number
        Print.inputNumber();
        userNum = user.getUserNumList();
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
        if (numOfStrike == 3) {
            Print.endGame();
            replayOrExit(); // if strike is 3, decide regame or exit game
        }
    }

    public void countStrike() {
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i))
                numOfStrike++;
        }
    }

    public void printAnswerInformation() { // print ball and strike information
        if (numOfBall != 0 && numOfStrike == 0)
            Print.ballLF(numOfBall);
        if (numOfBall != 0 && numOfStrike != 0)
            Print.ball((numOfBall));
        if (numOfStrike != 0)
            Print.strike(numOfStrike);
    }

    public void replayOrExit() { // replay game or exit game
        if (user.getUserReplayOrExit().equals("1")) {
            initialize();
            initializeRandomNum();
            start();
        }
    }

    public void initializeRandomNum() {
        randomNum.clear();
    }

    public void judgeNothing() { // judge nothing and print nothing
        if (numOfBall == 0 && numOfStrike == 0)
            Print.nothing();
    }

    public void initialize() { // initialize exist information for restart game
        numOfStrike = 0;
        numOfBall = 0;
        userNum.clear();
    }

    public void judgeAnswer() { // judge answer logic
        while (!userNum.equals(randomNum)) { // if user input number is different with computer's random number
            initialize();
            inputNum();
            exception.userNumberException(userNum);
            countBall();
            judgeStrike();
            judgeNothing();
            printAnswerInformation();
        }
    }
}
