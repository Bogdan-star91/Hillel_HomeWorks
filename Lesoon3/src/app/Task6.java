package app;

public class Task6 {
    public static void main(String[] args) {
        int[] mass = new int[10];

        for (int i : mass) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("------------");
        int[] mas = {0, -5, -10, -15};

        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }

        mass[0] = 1;
        mass[1] = 2;
        mass[2] = 3;
        mass[3] = 4;
        mass[4] = 5;
        mass[9] = 10;

        System.out.println();
        System.out.println("------------");

//        for (int i : mass) {
//            System.out.print(i + " ");
//        }

//        int[] mass1 = new int[10];
//
//        for (int i = 0; i < mass1.length; i++) {
//            mass1[i] = mass[i];
//        }
//
//        System.out.println();
//        for (int i : mass1) {
//            System.out.print(i + " ");
//        }
    }
}
