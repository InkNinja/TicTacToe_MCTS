package ticTacToe;

import java.util.ArrayList;

public interface IBoard {

    ArrayList<Move> getAllPossibleMoves();

    IBoard applyMove(Move move);

    IBoard getBoardAfterMove(Move move);

    void drawBoard();

}
