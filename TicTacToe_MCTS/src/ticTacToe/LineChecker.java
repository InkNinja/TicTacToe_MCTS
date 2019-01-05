package ticTacToe;

import java.util.ArrayList;

public class LineChecker {

    Field[][] fields;
    int size;

    LineChecker(Board_N board) {
        fields = board.fields;
        size = board.size;
    }

    public Sign checkBoardForWinner() {
        for (int i = 0; i < size; i++) {
            if (checkRow(i) != null) {
                return checkRow(i);
            }
            if (checkColumn(i) != null) {
                return checkColumn(i);
            }
        }
        if (checkLdiagonal() != null) {
            return checkLdiagonal();
        } else {
            return checkRdiagonal();
        }
    }

    public Sign checkRow(int y) {
        ArrayList<Field> line = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            line.add(fields[x][y]);
        }
        return checkLineForWinner(line);
    }

    public Sign checkColumn(int x) {
        ArrayList<Field> line = new ArrayList<>();
        for (int y = 0; y < size; y++) {
            line.add(fields[x][y]);
        }
        return checkLineForWinner(line);
    }

    public Sign checkLdiagonal() {
        ArrayList<Field> line = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            line.add(fields[size - 1 - i][i]);
        }
        return checkLineForWinner(line);
    }

    public Sign checkRdiagonal() {
        ArrayList<Field> line = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            line.add(fields[i][i]);
        }
        return checkLineForWinner(line);
    }


    public Sign checkLineForWinner(ArrayList<Field> line) {
        Sign sign = line.get(0).sign;
        for (Field field : line) {
            if (field.sign != sign) {
                return null;
            }
        }
        return sign;
    }

}
