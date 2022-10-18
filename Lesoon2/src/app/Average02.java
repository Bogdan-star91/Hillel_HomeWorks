package app;

public class Average02 {
    public static void main(String[] args) {
        int limitRendom = 10;
        int rnd;
        do {
            rnd = (int) (Math.random() * limitRendom);
        } while (rnd == 0);
        int sum = 0;
        int counterNum = 0;
        System.out.println("Random sequence:");
        while (rnd != 0) {
            System.out.printf("%2d,", rnd);
            sum += rnd;
            counterNum++;
            rnd = (int) (Math.random() * limitRendom);
        }
        System.out.printf("%s Average value %.2f", "\n", (float) sum / counterNum);
    }
}
