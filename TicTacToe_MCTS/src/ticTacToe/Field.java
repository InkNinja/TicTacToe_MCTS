package ticTacToe;

public class Field {

    Sign sign;

    public boolean setSign(Sign sign) {
        if (this.sign == null) {
            this.sign = sign;
            return true;
        } else {
            return false;
        }
    }

}
