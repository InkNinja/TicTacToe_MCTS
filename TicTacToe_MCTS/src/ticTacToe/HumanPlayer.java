package ticTacToe;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Player opponent;

    public HumanPlayer() {}

    @Override
    public Move getMove(TicTacToe ttt) {
        Board board = ttt.board;
        Move move = null;
        Scanner sc = ttt.scanner;
        while (move == null) {
            int x;
            int y;
            System.out.println();
            System.out.println("-------------------------");
            System.out.println();
            board.drawBoard();
            System.out.println();
            System.out.println("X:");
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
            move = new Move(board.fields[x - 1][y - 1], ttt.currentSign);
        }
        return move;
    }

    @Override
    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player player) {
        opponent = player;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter:");
            int x = sc.nextInt();
            System.out.println(x);

        }
    }

}
