package app;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1:");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Enter 2:");
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        int j = 1;
        for (int i = 0; i < n; i++) j *= x;
        System.out.println(j);
    }

}
