package app;


public class Task11 {
    public static void main(String[] args) {
        int[] a = {4, -5, 0, 6, 8};
        int max = a[0];
        int imax = 0;
        int min = a[0];
        int imin = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                imax = i;
            }
            if (a[i] < min) {
                min = a[i];
                imin = i;
            }
        }
        a[imin] = max;
        a[imax] = min;
        for (int i = 0; i < a.length; i++) {
            System.out.println("i=" + i + " a[" + i + "]=" + a[i]);
        }
    }
}
