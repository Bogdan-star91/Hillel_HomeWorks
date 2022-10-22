package app;

import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        int[] N = {6, 8, 3, 5, 1, 9};

        Arrays.sort(N);

        System.out.println("Max element is: " + N[N.length - 1]);
    }
}

