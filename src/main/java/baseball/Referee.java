package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int strike;
    private int ball;
    private List<Integer> userCount;        //유저의 입력 카운트
    private int BIT;

    public Referee(int b)
    {
        strike = 0;
        ball = 0;
        userCount = new ArrayList<>();
        BIT = b;
    }

    private void setUserCount(int num)
    {
        int []userNumber = new int[BIT];
        userNumber[0] = num / 100;
        userNumber[1] = num % 100 / 10;
        userNumber[2] = num % 10;
        for(int i=0;i<BIT;i++)
        {
            userCount.add(userNumber[i]);
        }
    }

    private void setStrike(List<Integer> ballCount)     //is it strike?
    {
        int result = 0;
        for(int i=0;i<BIT;i++)        //숫자와 자리가 같은경우
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
        int result = 0;
        for(int i=0;i<BIT;i++)
        {
            if(userCount.get(i) != ballCount.get(i) && inCount(userCount.get(i),ballCount))        //숫자는 같으나 자리는 다른경우
            {
                result++;
            }
        }
        this.ball =  result;
    }

    private boolean inCount(int n,List<Integer> ballCount)       //is that index in number?
    {
        for(int i=0;i<BIT;i++)        //다른자리에 값이 있는경우
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
        for (int i=BIT-1;i>=0;i--)
        {
            userCount.remove(i);
        }
    }
}
