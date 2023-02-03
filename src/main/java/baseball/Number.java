package baseball;

import java.security.spec.ECField;
import java.util.*;

public class Number {
    private final List<Integer> Numbers;

    public Number(List<Integer> Numbers){
        verifySize(Numbers);
        verifyDuplicate(Numbers);
        this.Numbers = Numbers;
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(Numbers);
    }

    private void verifySize(List<Integer> Numbers){
        if(Numbers.size() != GameManager.NUMBER_LENGTH){
            throw new IllegalArgumentException(MyException.INVALID_LENGTH);
        }
    }

    private void verifyDuplicate(List<Integer> Numbers){
        Set<Integer> nonDupleNumbers = new HashSet<>(Numbers);
        if(nonDupleNumbers.size() != GameManager.NUMBER_LENGTH){
            throw new IllegalArgumentException(MyException.INVALID_VALUE);
        }
    }

}
