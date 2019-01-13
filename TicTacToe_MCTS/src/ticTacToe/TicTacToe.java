package ticTacToe;

import java.util.ArrayList;

public class TicTacToe {

    Board board;
    int winLineSize;
    Player player1;
    Player player2;


    public TicTacToe(int size, int winLineSize) {
        board = new Board(size);
        this.winLineSize = winLineSize;
    }

    public Sign getWinner() {
        return board.checkBoardForWinner(winLineSize);
    }

    public ArrayList<Move> getAllPossibleMoves() {
        return board.getAllPossibleMoves();
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String[] args) {
        TicTacToe ttt = GameSetUp.getGameSetUp();
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();
        player1.setOpponent(player2);
        player2.setOpponent(player1);
        Player active = player1;
        Board board = ttt.getBoard();
        while ((ttt.getWinner() == null) && (ttt.getAllPossibleMoves().size() != 0)) {
            ArrayList<Move> moves = ttt.getAllPossibleMoves();
            Move move = null;
            while (move == null) {
                Move test = active.getMove(ttt);
                for (Move test2 : moves) {
                    if (test.equals(test2)) {
                        move = test;
                        break;
                    }
                }
            }
            board.applyMove(move);
            active = active.getOpponent();
        }
        GameSetUp.printEndGame(ttt);
    }

}
