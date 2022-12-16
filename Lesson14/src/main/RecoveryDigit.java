package main;

import java.util.ArrayList;
import java.util.List;

public class RecoveryDigit {
    private DigitString digit = new DigitString();

    public List<String> getDigit(int dig) {
        switch (dig) {
            case 0:
                return digit.zero();
            case 1:
                return digit.one();
            case 2:
                return digit.two();
            case 3:
                return digit.three();
            case 4:
                return digit.four();
            case 5:
                return digit.five();
            case 6:
                return digit.six();
            case 7:
                return digit.seven();
            case 8:
                return digit.eight();
            case 9:
                return digit.nine();
            default:
                return new ArrayList<>();
        }
    }
}
