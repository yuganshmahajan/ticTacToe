package Service;

import Service.Impls.IterativeStatusCheckImpl;
import lombok.Data;

import java.util.Scanner;

@Data
public class TicTacToeService {
    boolean gameActive;
    BoardService boardService;
    PlayerService playerService;
    GameStatusCheck statusCheck;
    Scanner scn;


    public TicTacToeService(){
        PlayerService playerService = new PlayerService();
        BoardService boardService = new BoardService();
        statusCheck  = new IterativeStatusCheckImpl();
        gameActive = true;
        scn = new Scanner(System.in);
    }

    public void play(){
        boardService.initBoard();
        playerService.initPlayers();
        while(isGameActive()){
            System.out.println("Enter next move of " + playerService.getCurrPlayer());
            int x = scn.nextInt();
            int y = scn.nextInt();
            if(x == -1 || y == -1){
                break;
            }
            if(!boardService.markMove(x,y)){
                System.out.println("Invalid Move");
                continue;
            }
            boardService.printBoard();
            if(statusCheck.checkWinner(x, y)){
                gameActive = false;
                playerService.setCurrentPlayerWinner();
                System.out.println(playerService.getCurrPlayer() + " wins!");
            }
            if(boardService.isFull()){
                gameActive = false;
                System.out.println("Match is draw!");
            }
            playerService.invertPlayer();
        }
    }

//    public void makeMove(Move move){
//        int x = move.getX();
//        int y = move.getY();
//        int[][] board = getBoard().getBoard();
//        if(x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] != 0){
//            System.out.println("Invalid Move");
//            return;
//        }
//        board[x][y] = currPlayer.getPlayerId();
//        gameActive = statusCheck.checkWinner(move);
//        if(gameActive){
//            winner = currPlayer;
//        }
//        gameActive = this.board.isFull();
//        invertPlayer();
//    }



//    public void printBoard(){
//        board.printBoard();
//    }

}
