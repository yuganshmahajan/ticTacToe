import Service.TicTacToeService;

public class Main {

    public static void main(String[] args) {
//        // Inpit players
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter Name of first player");
//        String p1Name = scn.next();
//        Player p1 = new Player(p1Name, 1);
//        System.out.println("Enter Name of second player");
//        String p2Name = scn.next();
//        Player p2 = new Player(p2Name, 2);
//
//        //Initialise Board
//        BoardService boardService = new BoardService();
//        boardService.initBoard();
//
//        TicTacToeService game = new TicTacToeService(m,n, p1, p2);
//        while(!game.isGameActive()){
//            System.out.println("Enter next move of" + game.getCurrPlayer());
//            int x = scn.nextInt();
//            int y = scn.nextInt();
//            if(x == -1 || y == -1){
//                break;
//            }
//            game.markMove(new Move(x,y));
//            game.printBoard();
//        }
//        if(game.getWinner() != null) {
//            System.out.println("winner is " + game.getWinner());
//        } else {
//            System.out.println("the game is draw");
//        }

        TicTacToeService ticTacToeService = new TicTacToeService();
        ticTacToeService.play();
    }
}
