package main;

import java.util.ArrayList;
import java.util.List;

public class DigitPrinter {
    private List<Integer> list;
    private int iterator = 0;
    private final RecoveryDigit recDigit = new RecoveryDigit();

    public DigitPrinter(String args) {
        list = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        for (char c : args.toCharArray()) {
            strList.add(String.valueOf(c));
        }
        strList.stream()
                .forEach(e -> {
                    try {
                        list.add(Integer.parseInt(e));
                    } catch (NumberFormatException exc) {
                    }
                });
    }

    public boolean add(Integer i) {
        return list.add(i);
    }

    public boolean add(String str) {
        try {
            return list.add(Integer.parseInt(str));
        } catch (NumberFormatException exc) {
        }
        return false;
    }

    public void print() {
        for (int i = 1; i <= recDigit.getDigit(0).size(); i++) {
            list.stream().map(recDigit::getDigit)
                    .map(e -> e.get(iterator))
                    .forEach(e -> System.out.print(e + " "));
            iterator = i;
            System.out.println();
        }
        iterator = 0;
    }
}
