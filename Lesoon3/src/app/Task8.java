package app;

public class Task8 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        printOddNumbers(arr);
    }

    public static void printOddNumbers(int[] arr) {
        for (int i : arr)
            if (i % -2 != 0)
                System.out.print(i + ", ");
    }
}
