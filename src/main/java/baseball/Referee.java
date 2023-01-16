package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int strike;
    private int ball;
    private List<Integer> userCount;        //유저의 입력 카운트

    Referee()
    {
        strike = 0;
        ball = 0;
        userCount = new ArrayList<>();
    }

    private void setUserCount(int num)
    {
        int []userNumber = new int[3];
        userNumber[0] = num / 100;
        userNumber[1] = num % 100 / 10;
        userNumber[2] = num % 10;
        for(int i=0;i<3;i++)
        {
            userCount.add(userNumber[i]);
        }
    }

    private void setStrike(List<Integer> ballCount)     //is it strike?
    {
        //this.strike = 0;
        int result = 0;
        for(int i=0;i<3;i++)        //숫자와 자리가 같은경우
        {
            if(userCount.get(i) == ballCount.get(i))
            {
                result+=1;
            }
        }
        this.strike =  result;
    }

    private void setBall(List<Integer> ballCount)     //is it ball?
    {
        //this.ball = 0;
        int result = 0;
        //boolean ballds;
        for(int i=0;i<3;i++)
        {
            //ballds = inCount(userCount.get(i),ballCount);
            if(userCount.get(i) != ballCount.get(i) && inCount(userCount.get(i),ballCount))        //숫자는 같으나 자리는 다른경우
            {
                result++;
            }
        }
        this.ball =  result;
    }

    private boolean inCount(int n,List<Integer> ballCount)       //is that index in number?
    {
        for(int i=0;i<3;i++)        //다른자리에 값이 있는경우
        {
            if(ballCount.get(i) == n)
            {
                return true;
            }
        }
        return false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void judgement(int n,List<Integer> ballCount)
    {
        this.strike = 0;
        this.ball = 0;
        setUserCount(n);
        setStrike(ballCount);
        setBall(ballCount);
    }

    public void empty()
    {
        for (int i=2;i>=0;i--)
        {
            userCount.remove(i);
        }
    }
}
