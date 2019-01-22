package mcts;

import ticTacToe.Board;
import ticTacToe.Move;
import ticTacToe.Sign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MCTSGraph {

    Move move;
    MCTSGraph parent;
    ArrayList<MCTSGraph> children;
    int win;
    int all;
    boolean won;

    public MCTSGraph(Move move, MCTSGraph parent){
        this.move = move;
        this.parent = parent;
        all=0;
        win=0;
        children = new ArrayList<>();
        won = false;
    }

    public void doSomeRandomSimulations(Board board, Sign sign, int winLineSize, int simNumber){
        for(int i = 0; i < simNumber; i ++){
            doRandomSimulation(board, sign, winLineSize);
        }
    }

    private void propagateSimulationResult(boolean ifWon){
        if(ifWon){
            win++;
        }
        all++;
        if(parent!=null){
            parent.propagateSimulationResult(!ifWon);
        }
    }

    private void doRandomSimulation(Board board, Sign sign, int winLineSize){
        ArrayList<Move> moves = board.getAllPossibleMoves(sign);
        Collections.shuffle(moves);
        Random r = new Random();
        int index = r.nextInt(moves.size());
        Move move = moves.get(index);
        MCTSGraph child = getChild(move);
        Board after = board.getBoardAfterMove(move);
        if(after.checkBoardForWinner(winLineSize) == sign){
            child.propagateSimulationResult(true);
        }
        else{
            child.doRandomSimulation(after, sign.next(), winLineSize);
        }
    }

    private MCTSGraph getChild(Move move){
        for(MCTSGraph situation : children){
            if(situation.move.equals(move)){
                return situation;
            }
        }
        MCTSGraph newSituation = new MCTSGraph(move, this);
        children.add(newSituation);
        return  newSituation;
    }



}
