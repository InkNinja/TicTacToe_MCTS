package ticTacToe;

public class Field {

    Sign sign;

    private int x;
    private int y;

    public Field(int x, int y){
        this.x = x;
        this.y = y;
    }


    public boolean setSign(Sign sign) {
        if (this.sign == null) {
            this.sign = sign;
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Field f){
        return x == f.x && y == f.y;
    }
}
