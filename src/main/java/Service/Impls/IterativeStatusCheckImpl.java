package Service.Impls;

import Service.BoardService;
import Service.GameStatusCheck;
import Service.PlayerService;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IterativeStatusCheckImpl implements GameStatusCheck {
    BoardService boardService;
    PlayerService playerService;

    public boolean checkHorizontal(int x, int y){
        boolean ans = true;
        for(int i = 1; i < 5; i++){
            if(boardService.getVal(x,y+i) != playerService.getCurrPlayerId()){
                ans = false;
                break;
            }
        }
        if(ans == true) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(boardService.getVal(x,y-i) != playerService.getCurrPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkVertical(int x, int y){
        boolean ans = true;
        for (int i = 1; i < 5; i++) {
            if (boardService.getVal(x + 1, y) != playerService.getCurrPlayerId()) {
                ans = false;
                break;
            }
        }
        if(ans) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(boardService.getVal(x-i,y)!= playerService.getCurrPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkDiagonal(int x, int y){
        boolean ans = true;
        for(int i = 1; i < 5; i++){
            if(boardService.getVal(x+i, y+i) != playerService.getCurrPlayerId()){
                ans = false;
                break;
            }
        }
        if(ans == true) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(boardService.getVal(x-i, y-i) != playerService.getCurrPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkInvertedDiagonal(int x, int y){
        boolean ans = true;
        for(int i = 1; i < 5; i++){
            if(boardService.getVal(x-i,y+i) != playerService.getCurrPlayerId()){
                ans = false;
                break;
            }
        }
        if(ans == true) return ans;
        ans = true;
        for(int i = 1; i < 5; i++){
            if(boardService.getVal(x+1,y-i) != playerService.getCurrPlayerId()){
                ans = false;
                break;
            }
        }
        return ans;
    }

    public boolean checkWinner(int x, int y){
        return checkHorizontal(x,y) || checkVertical(x,y) ||
                checkDiagonal(x,y) || checkInvertedDiagonal(x,y);
    }
}
