package app;

public class Task12 {
    public static void main(String[] args) {
        double[] num = {4, -5, 0, 6, 8};
        double sum = 0;
        for (double x : num) {
            sum += x;
        }
        System.out.print("Arithmetic mean of an array: " + sum / num.length);
    }
}
