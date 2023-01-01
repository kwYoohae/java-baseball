package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateNum {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<Integer>();

    CreateNum() {
        setComputer();
    }

    public void setComputer() {
        this.computer = randomNum();
    }

    public void setUser() {
        this.user = inputNum();
    }

    public List<Integer> getComputer() {
        return computer;
    }

    public List<Integer> getUser() {
        return user;
    }

    private List<Integer> randomNum() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    private List<Integer> inputNum() {
        String readNum = Console.readLine();
        String[] num = readNum.split("");

        List<Integer> user = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++) {
            int number = Integer.parseInt(num[i]);
            user.add(number);
        }
        return user;
    }
}
