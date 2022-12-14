package app.discriminant;

public class FormattedDisk {
    private Disc formatted;

    public Disc getItem(String s) {
        formatted = new Disc();
        String format = s.substring(1);
        boolean firstPlus = isFirstPlus(format);
        boolean lastPlus = isLastPlus(format);


        int firstChar = firstPlus ? format.indexOf("+") + 1 : format.indexOf("-") + 1;
        int lastChar = lastPlus ? format.lastIndexOf("+") : format.lastIndexOf("-");
        lastChar = (lastChar + 1 == s.length()) ? lastChar : lastChar + 1;

        formatted.setI(Double.parseDouble(s.substring(0, firstChar)));
        if (firstPlus) {
            formatted.setJ(Double.parseDouble(s.substring(firstChar + 1, lastChar)));
        } else {
            formatted.setJ(Double.parseDouble(s.substring(firstChar, lastChar)));
        }

        if (lastPlus) {
            formatted.setF(Double.parseDouble(s.substring(lastChar + 1)));
        } else {
            formatted.setF(Double.parseDouble(s.substring(lastChar)));
        }

        return formatted;
    }

    private boolean isFirstPlus(String s) {
        if (!s.contains("-") && s.contains("+")) {
            return true;
        } else if (!s.contains("+")) {
            return false;
        }
        return s.indexOf("+") < s.indexOf("-");
    }

    private boolean isLastPlus(String s) {
        if (!s.contains("-") && s.contains("+")) {
            return true;
        } else if (!s.contains("+")) {
            return false;
        }
        return s.lastIndexOf("+") > s.lastIndexOf("-");
    }
}

