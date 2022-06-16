package modals;

import lombok.Data;

@Data
public class Board {
    int row;
    int col;
    int[][] board;
    public Board(int row, int col){
        this.row = row;
        this.col = col;
        board = new int[row][col];
    }

    public void printBoard(){
        for(int i = 0; i < getRow(); i++){
            for(int j = 0; j < getCol(); j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull(){
        for(int i = 0; i < getRow(); i++){
            for(int j = 0; j < getCol(); j++) {
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

}
