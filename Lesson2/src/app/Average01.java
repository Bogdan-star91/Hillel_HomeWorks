package app;

public class Average01 {
    public static void main(String[] args) {
        double[] num = {15.5, 20.5};
        double result = 0;

        for (double d : num) {
            result += d;
        }
        System.out.println("Average value: " + result / num.length);
    }
}
    
