package ticTacToe;

public class Move {

    Sign sign;
    Field field;

    public Move(Field field, Sign sign) {
        this.field = field;
        this.sign = sign;
    }

    public boolean equals(Move move) {
        if (move.sign == sign && move.field == field) {
            return true;
        } else {
            return false;
        }
    }


}
