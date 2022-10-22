package app;

public class Task13 {

    public static void main(String[] args) {

        String[][] chessBoard = new String[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int a = 0; a < chessBoard[0].length; a++) {
                if ((i + a) % 2 == 0) chessBoard[i][a] = "B";
                else chessBoard[i][a] = "W";
            }
        }
        for (int i = chessBoard.length - 1; i >= 0; i--) {
            for (int a = 0; a < chessBoard[0].length; a++) {
                System.out.print(" " + chessBoard[i][a] + " ");
            }
            System.out.println();
        }
    }
}
