package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager {

    private int []number;     //number array


    Manager()       //constructor
    {
        System.out.println("숫자 야구 게임을 시작합니다.");     //opening message
        number = new int[3];        //create number array
    }

    private void makeNumber()       //create number
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        setNumber(computer);        //setNumber
    }
    private void setNumber(List<Integer> computer)      //setNumber
    {
        for (int i=0;i<3;i++)
        {
            int n = Integer.parseInt(computer.get(i).toString());   // Integer to int
            this.number[i] = n;     //set number
        }
    }


}
