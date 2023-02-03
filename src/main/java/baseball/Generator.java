package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private List<Integer> ballCount;        //게임의 랜덤 볼카운트
    
    public List<Integer> getBallCount()     //getter
    {
        return this.ballCount;
    }
    
    public void setBallCount(List<Integer> n)   //setter
    {
        this.ballCount = n;
    }

    public Generator()
    {
        ballCount = new ArrayList<>();
        makeNumber();
    }

    public void makeNumber()       //create number
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //제공된 랜덤숫자
        ballCount = computer;       //랜덤숫자를 ballCount로
    }
    //게임 재시작시 다시 호출해야함으로 public으로 했습니다
    //c++과 다르게 메모리 소멸 후 재할당을 통해 생성자를 재호출하는 방법을 아직 모르겠습니다
}
