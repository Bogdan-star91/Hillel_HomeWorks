package app;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number \"from\":");
        int a = sc.nextInt();
        System.out.println("Now enter a number \"to\":");
        int b = sc.nextInt();

        for (int i = a; i < b; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
