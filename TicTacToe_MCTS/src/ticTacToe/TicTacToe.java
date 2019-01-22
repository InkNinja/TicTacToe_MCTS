package ticTacToe;

import mcts.MCTSPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    public Board board;
    public int winLineSize;
    public Player player1;
    public Player player2;
    public Scanner scanner;
    public Sign currentSign;

    public TicTacToe(int size, int winLineSize) {
        board = new Board(size);
        this.winLineSize = winLineSize;
        scanner = new Scanner(System.in);
        currentSign = Sign.CROSS;
    }

    public TicTacToe(int size, int winLineSize, Scanner scanner){
        this(size, winLineSize);
        this.scanner = scanner;
    }

    public Sign getWinner() {
        return board.checkBoardForWinner(winLineSize);
    }

    public ArrayList<Move> getAllPossibleMoves() {
        return board.getAllPossibleMoves(currentSign);
    }

    public Board applyMove(Move move) {
        board.applyMove(move);
        currentSign = currentSign.next();
        return board;
    }

    public static void main(String[] args) {
        TicTacToe ttt = GameSetUp.getGameSetUp();
        ttt.player1 = new MCTSPlayer();
        ttt.player2 = new MCTSPlayer();
        ttt.player1.setOpponent(ttt.player2);
        ttt.player2.setOpponent(ttt.player1);
        Player active = ttt.player1;
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
            ttt.applyMove(move);
            active = active.getOpponent();
        }
        GameSetUp.printEndGame(ttt);
    }

}
