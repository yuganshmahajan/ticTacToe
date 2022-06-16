package Service;

import modals.Player;

import java.util.Scanner;

public class PlayerService {
    Player p1;
    Player p2;
    Player winner;
    Player currPlayer;

    void initPlayers(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Name of first player");
        String p1Name = scn.next();
        Player p1 = new Player(p1Name, 1);
        System.out.println("Enter Name of second player");
        String p2Name = scn.next();
        Player p2 = new Player(p2Name, 2);
        this.currPlayer = p1;
        this.winner = null;
    }

    public Player getCurrPlayer(){
        return currPlayer;
    }

    public int getCurrPlayerId(){
        return currPlayer.getPlayerId();
    }

    public Player getWinner(){
        if(winner == null){
            return null;
        }
        return winner;
    }

    public void setCurrentPlayerWinner(){
        winner = currPlayer;
    }

    public void invertPlayer(){
        if(currPlayer == p1){
            currPlayer = p2;
        } else {
            currPlayer = p1;
        }
    }
}
