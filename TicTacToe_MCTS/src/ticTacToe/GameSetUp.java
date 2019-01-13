package ticTacToe;

import java.util.Scanner;

public class GameSetUp {

    public static TicTacToe getGameSetUp() {
        int size = 0;
        int winLineSize = 0;
        Scanner sc = new Scanner(System.in);
        while (size == 0) {
            try {
                System.out.println("Choose board size (<10)");
                sc = new Scanner(System.in);
                int input = sc.nextInt();
                if ((input > 0) && (input < 10)) {
                    size = input;
                }
            } catch (Exception e) {
            }
        }
        while (winLineSize == 0) {
            try {
                System.out.println("Choose win line size (<=" + size + ")");
                sc = new Scanner(System.in);
                int input = sc.nextInt();
                if ((input > 0) && (input <= size)) {
                    winLineSize = input;
                }
            } catch (Exception e) {
            }
        }
        TicTacToe ttt = new TicTacToe(size, winLineSize);
        sc.close();
        return ttt;
    }

    public static void printEndGame(TicTacToe ttt) {
        Board board = ttt.getBoard();
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
    }



}
