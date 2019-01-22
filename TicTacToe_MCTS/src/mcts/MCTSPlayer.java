package mcts;

import ticTacToe.Move;
import ticTacToe.Player;
import ticTacToe.TicTacToe;

import java.util.ArrayList;
import java.util.Collections;

public class MCTSPlayer implements Player {

    Player opponent;

    public MCTSPlayer (){
        //Add graph
    }


    @Override
    public Move getMove(TicTacToe ttt) {
        ArrayList<Move> moves =  ttt.getAllPossibleMoves();
        Collections.shuffle(moves);
        return moves.get(0);
    }

    @Override
    public Player getOpponent() {
        return opponent;
    }

    @Override
    public void setOpponent(Player player) {
        this.opponent = player;
    }
}
