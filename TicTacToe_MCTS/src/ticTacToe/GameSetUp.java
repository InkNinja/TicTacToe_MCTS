package ticTacToe;

import java.util.Scanner;

public class GameSetUp {

    public static TicTacToe getGameSetUp() {
        int size = 0;
        int winLineSize = 0;
        Scanner sc = new Scanner(System.in);
        while (size == 0) {
            System.out.println("Choose board size (<10)");
            int input = sc.nextInt();
            if ((input > 0) && (input < 10)) {
                size = input;
            }
        }
        while (winLineSize == 0) {
            System.out.println("Choose win line size (<=" + size + ")");
            int input = sc.nextInt();
            if ((input > 0) && (input <= size)) {
                winLineSize = input;
            }
        }
        TicTacToe ttt = new TicTacToe(size, winLineSize, sc);
        return ttt;
    }

    public static void printEndGame(TicTacToe ttt) {
        Board board = ttt.board;
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        board.drawBoard();
        System.out.println();

        if (ttt.getWinner() == null) {
            System.out.println("TIE");
        } else {
            System.out.println(ttt.getWinner() + " WINS");
        }
        ttt.scanner.close();
    }



}
