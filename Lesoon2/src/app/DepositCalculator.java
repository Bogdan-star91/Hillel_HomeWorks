package app;

public class DepositCalculator {

    public static void main(String... args) {
        DepositCalculator deposit = new DepositCalculator();
        deposit.examDeposit();
    }
    public void examDeposit() {
        float sum = 500;
        double percent = 5.5;
        int years = 5;
        System.out.println("Deposit in the amount " + sum + " UAH " + percent + "% per annum for " + years + " years:\n");
        for (int i = 1; i < years + 1; i++) {
            sum += (sum * percent) / 100;
            System.out.format("Year - " + i + ". Sum: " + "%.2f UAH\n", sum);
        }
        System.out.format("\nFor 100 years yuo have received %.2f UAH\n", sum);
    }
}
