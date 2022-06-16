package TicTacToe;

import Service.GameStatusCheck;
import Service.Impls.IterativeStatusCheckImpl;
import lombok.Data;
import modals.Board;
import modals.Move;
import modals.Player;

@Data
public class TicTacToeImpl {
    int rows;
    int cols;
    boolean gameActive;
    Board board;
    Player player1;
    Player player2;
    Player winner;
    Player currPlayer;
    GameStatusCheck statusCheck;

    public TicTacToeImpl(int m, int n, Player p1, Player p2){
        rows = m;
        cols = n;
        board = new Board(m,n);
        player1 = p1;
        player2 = p2;
        currPlayer = p1;
        statusCheck  = new IterativeStatusCheckImpl(board, currPlayer);
        winner = null;
        gameActive = false;
    }

    private void invertPlayer(){
        if(currPlayer == player1){
            currPlayer = player2;
        } else {
            currPlayer = player1;
        }
    }

    public void markMove(Move move){
        int x = move.getX();
        int y = move.getY();
        int[][] board = getBoard().getBoard();
        if(x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] != 0){
            System.out.println("Invalid Move");
            return;
        }
        board[x][y] = currPlayer.getPlayerId();
        gameActive = statusCheck.checkWinner(move);
        if(gameActive){
            winner = currPlayer;
        }
        gameActive = this.board.isFull();
        invertPlayer();
    }

    public void printBoard(){
        board.printBoard();
    }

}
