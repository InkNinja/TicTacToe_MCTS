package ticTacToe;

public interface Player {

    public Move getMove(TicTacToe ttt);

    public Player getOpponent();

    public void setOpponent(Player player);
}
