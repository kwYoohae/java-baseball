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
        errorInput(this.user);
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
                System.out.print(randomNumber);
            }
        }
        System.out.println();
        return computer;
    }


    private List<Integer> inputNum() {
        String readNum = Console.readLine();
        String[] num = readNum.split("");

        List<Integer> user = new ArrayList<Integer>();
        for(int i = 0; i < num.length; i++) {
            int number = Integer.parseInt(num[i]);
            user.add(number);
        }
        return user;
    }

    private void errorInput(List<Integer> user) {
        errorLength(user);
        if(user.size() != user.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
        if(user.contains(0) == true) {
            throw new IllegalArgumentException("입력된 숫자 중 0이 존재합니다.");
        }
        for (int i = 0; i < user.size(); i++) {
            char ch = Integer.toString(user.get(i)).charAt(0);
            if (48 > ch && ch > 57) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }
        }
    }

    private void errorLength(List<Integer> user) {
        if(user.size() > 3) {
            throw new IllegalArgumentException("입력된 숫자가 3개보다 많습니다.");
        }
        if(user.size() < 3) {
            throw new IllegalArgumentException("입력된 숫자가 3개보다 적습니다.");
        }
    }
}
