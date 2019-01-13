package ticTacToe;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Player opponent;

    public HumanPlayer() {}

    @Override
    public Move getMove(TicTacToe ttt) {
        Board board = ttt.getBoard();
        Move move = null;
        Scanner sc = new Scanner(System.in);
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
                if ((input > 0) && (input <= board.size)) {
                    x = input;
                } else {
                    continue;
                }

                System.out.println("Y:");

                input = sc.nextInt();
                if ((input > 0) && (input <= board.size)) {
                    y = input;
                } else {
                    continue;
                }
                move = new Move(board.fields[x - 1][y - 1], board.currentPlayer);
            } catch (Exception e) {
            }
        }
        sc.close();
        return move;
    }

    @Override
    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player player) {
        opponent = player;
    }

}
