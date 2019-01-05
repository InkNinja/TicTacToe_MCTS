package ticTacToe;

import java.util.ArrayList;

public class Board_N implements IBoard {

    public Field[][] fields;
    public int size;
    public Sign currentPlayer;

    public Board_N() {
        this(4);
    }

    public Board_N(int size) {
        this.size = size;
        fields = new Field[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                fields[x][y] = new Field();
            }
        }
        currentPlayer = Sign.CROSS;
    }


    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (fields[i][j].sign == null) {
                    possibleMoves.add(new Move(fields[i][j], currentPlayer));
                }
            }
        }
        return possibleMoves;
    }

    @Override
    public IBoard applyMove(Move move) {
        move.field.setSign(move.sign);
        currentPlayer = currentPlayer.next();
        return this;
    }

    @Override
    public IBoard getBoardAfterMove(Move move) {
        Board_N afterMove = copyBoard();
        return afterMove.applyMove(move);
    }

    @Override
    public Sign getWinner() {
        LineChecker checker = new LineChecker(this);
        return checker.checkBoardForWinner();
    }

    private Board_N copyBoard() {
        Board_N copy = new Board_N(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy.fields[i][j].setSign(fields[i][j].sign);
            }
        }
        return copy;
    }

    @Override
    public void drawBoard() {

        System.out.print("\n");
        for (int y = size - 1; y >= 0; y--) {
            System.out.print(y + 1);
            for (int x = 0; x < size; x++) {
                System.out.print(" ");
                if (fields[x][y].sign == null) {
                    System.out.print(" ");
                } else {
                    fields[x][y].sign.print();
                }
            }
            System.out.print("\n");
        }
        System.out.print(" ");
        for (int i = 1; i <= size; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n");
        System.out.print("\n");
    }



}
