package Service;

import modals.Board;

import java.util.Scanner;

public class BoardService {
    Board board;
    PlayerService playerService;

    public boolean markMove(int x, int y){
        if(!isValidMove(x,y)){
            return false;
        }
        board.setVal(x, y, playerService.getCurrPlayerId());
        return true;
    }

    public boolean inBoardLimits(int x, int y){
        int[][] bd = board.getBoard();
        if(x < 0 || x >= board.getRow() || y < 0 || y >= board.getCol()){
            return false;
        }
        return true;
    }

    public boolean isValidMove(int x, int y){
        int[][] bd = board.getBoard();
        if(x < 0 || x >= board.getRow() || y < 0 || y >= board.getCol() || bd[x][y] != 0){
            return false;
        }
        return true;
    }

    public void printBoard(){
        int[][] bd = board.getBoard();
        for(int i = 0; i < board.getRow(); i++){
            for(int j = 0; j < board.getCol(); j++) {
                System.out.print(bd[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull(){
        int[][] bd = board.getBoard();
        for(int i = 0; i < board.getRow(); i++){
            for(int j = 0; j < board.getCol(); j++) {
                if(bd[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void initBoard(){
        System.out.println("Enter board size");
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        Board board = new Board(row, col);
    }

    public Board getBoard(){
        return board;
    }

    public int getVal(int x, int y){
        if(!inBoardLimits(x, y)){
            return -1;
        }
        return board.getVal(x,y);
    }

}
