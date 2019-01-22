package ticTacToe;

import java.util.Random;

public class PlayerSet {

    Player player1;
    Player player2;


    public PlayerSet(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void changeOrder(){
        Player swap = player2;
        player2 = player1;
        player1 = swap;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

    public void shuffle(){
        Random r = new Random();
        if(r.nextDouble()>0.5){
            changeOrder();
        }
    }

}
