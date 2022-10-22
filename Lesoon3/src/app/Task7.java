package app;

public class Task7 {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {

            for (int x = 2; x < 10; x++) {

                System.out.print(x + "*" + i + "=" + (i * x) + "\t\t");
            }
            System.out.println();
        }
    }
}
