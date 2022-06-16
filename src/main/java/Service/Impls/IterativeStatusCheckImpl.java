package Service.Impls;

import Service.GameStatusCheck;
import lombok.Data;
import modals.Board;
import modals.Move;
import modals.Player;

@Data
public class IterativeStatusCheckImpl implements GameStatusCheck {
    Board board;
    Player currPlayer;
    public IterativeStatusCheckImpl(Board board, Player currPlayer) {
        this.board = board;
        this.currPlayer = currPlayer;
    }

    private boolean isValid(int x, int y){
        if(x < 0 || x >= board.getRow() || y < 0 || y >= board.getCol()){
            return false;
        }
        return true;
    }

    public boolean checkHorizontal(Move move){
        int x = move.getX();
        int y = move.getY();
        int[][] board = getBoard().getBoard();
        boolean ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x, y+i) || board[x][y+i] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        if(ans == true) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x, y-i) || board[x][y-i] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkVertical(Move move){
        int x = move.getX();
        int y = move.getY();
        int[][] board = getBoard().getBoard();
        boolean ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x+i, i) || board[x+i][y] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        if(ans) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x-i, y) || board[x-i][y] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkDiagonal(Move move){
        int x = move.getX();
        int y = move.getY();
        int[][] board = getBoard().getBoard();
        boolean ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x+i, y+i) || board[x+i][y+i] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        if(ans == true) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x-i, y-i) || board[x-i][y-i] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkInvertedDiagonal(Move move){
        int x = move.getX();
        int y = move.getY();
        int[][] board = getBoard().getBoard();
        boolean ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x-i, y+i) || board[x-i][y+i] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        if(ans == true) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(!isValid(x+1, y-i) || board[x+1][y-i] != currPlayer.getPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkWinner(Move move){
        return checkHorizontal(move) || checkVertical(move) ||
                checkDiagonal(move) || checkInvertedDiagonal(move);
    }
}
