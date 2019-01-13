package ticTacToe;

import java.util.ArrayList;

public class Board implements IBoard {

    public Field[][] fields;
    public int size;
    public Sign currentPlayer;

    public Board() {
        this(5);
    }

    public Board(int size) {
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
        Board afterMove = copyBoard();
        return afterMove.applyMove(move);
    }

    private Board copyBoard() {
        Board copy = new Board(size);
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

    public Sign checkBoardForWinner(int winLineSize) {
        for (int i = 0; i < size; i++) {
            if (checkRow(i, winLineSize) != null) {
                return checkRow(i, winLineSize);
            }
            if (checkColumn(i, winLineSize) != null) {
                return checkColumn(i, winLineSize);
            }
        }
        if (checkLdiagonal(winLineSize) != null) {
            return checkLdiagonal(winLineSize);
        } else {
            return checkRdiagonal(winLineSize);
        }
    }

    public Sign checkRow(int y, int winLineSize) {
        ArrayList<Field> line = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            line.add(fields[x][y]);
        }
        return checkLineForWinner(line, winLineSize);
    }

    public Sign checkColumn(int x, int winLineSize) {
        ArrayList<Field> line = new ArrayList<>();
        for (int y = 0; y < size; y++) {
            line.add(fields[x][y]);
        }
        return checkLineForWinner(line, winLineSize);
    }

    public Sign checkLdiagonal(int winLineSize) {
        ArrayList<Field> line = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            line.add(fields[size - 1 - i][i]);
        }
        return checkLineForWinner(line, winLineSize);
    }

    public Sign checkRdiagonal(int winLineSize) {
        ArrayList<Field> line = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            line.add(fields[i][i]);
        }
        return checkLineForWinner(line, winLineSize);
    }

    public Sign checkLineForWinner(ArrayList<Field> line, int winLineSize) {
        Sign sign = null;
        int count = 0;
        for (Field field : line) {
            if (field.sign == sign) {
                count++;
            } else {
                sign = field.sign;
                count = 1;
            }
            if ((count == winLineSize) && (sign != null)) {
                return sign;
            }
        }
        return null;
    }

}
