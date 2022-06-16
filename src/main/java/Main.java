import TicTacToe.TicTacToeImpl;
import modals.Move;
import modals.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Name of first player");
        String p1Name = scn.next();
        Player p1 = new Player(p1Name, 1);
        System.out.println("Enter Name of second player");
        String p2Name = scn.next();
        Player p2 = new Player(p2Name, 2);
        int n, m;
        System.out.println("Enter Board Size");

        m = scn.nextInt();
        n = scn.nextInt();
        TicTacToeImpl game = new TicTacToeImpl(m,n, p1, p2);
        while(!game.isGameActive()){
            System.out.println("Enter next move of" + game.getCurrPlayer());
            int x = scn.nextInt();
            int y = scn.nextInt();
            if(x == -1 || y == -1){
                break;
            }
            game.markMove(new Move(x,y));
            game.printBoard();
        }
        if(game.getWinner() != null) {
            System.out.println("winner is " + game.getWinner());
        } else {
            System.out.println("the game is draw");
        }
    }
}
