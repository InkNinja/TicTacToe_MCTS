package game;

import java.util.ArrayList;
import java.util.Scanner;
import ticTacToe.Board_N;
import ticTacToe.Move;

public class TwoPlayers {

    public static void main(String[] args) {
        int size = 0;
        Scanner sc;
        while (size == 0) {
            try {
                System.out.println("Choose board size (<10)");
                sc = new Scanner(System.in);
                int input = sc.nextInt();
                if (input > 0 && input < 10) {
                    size = input;
                }
            } catch (Exception e) {
            }
        }
        Board_N board = new Board_N(size);
        while (board.getWinner() == null && board.getAllPossibleMoves().size() != 0) {
            ArrayList<Move> moves = board.getAllPossibleMoves();
            Move move = null;
            while (move == null) {
                int x;
                int y;
                System.out.println();
                System.out.println("-------------------------");
                System.out.println();
                board.drawBoard();
                System.out.println();
                try {
                    System.out.println("X:");
                    sc = new Scanner(System.in);
                    int input = sc.nextInt();
                    if (input > 0 && input <= size) {
                        x = input;
                    } else {
                        continue;
                    }

                    System.out.println("Y:");
                    sc = new Scanner(System.in);
                    input = sc.nextInt();
                    if (input > 0 && input <= size) {
                        y = input;
                    } else {
                        continue;
                    }
                    Move test = new Move(board.fields[x - 1][y - 1], board.currentPlayer);
                    for (Move test2 : moves) {
                        if (test2.equals(test)) {
                            move = test;
                            continue;
                        }
                    }
                } catch (Exception e) {
                }
            }
            board.applyMove(move);
        }

        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        board.drawBoard();
        System.out.println();

        if (board.getWinner() == null) {
            System.out.println("TIE");
        } else {
            System.out.println(board.getWinner() + " WINS");
        }
    }

}
