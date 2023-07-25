public class Referee {
    public Result Ruling(String s){
        Board board = new Board();
        String[][] gameBoard = board.getFinalBoard(s);
        //判断行
        for(int i = 1; i < 4; i++){
            if(gameBoard[i][2].equals("X")
                    && gameBoard[i][4].equals("X")
                    && gameBoard[i][6].equals("X")){
                return Result.X_WIN;
            }else if(gameBoard[i][2].equals("O")
                    && gameBoard[i][4].equals("O")
                    && gameBoard[i][6].equals("O")){
                return Result.O_WIN;
            }
        }
        //判断列
        for(int j = 2; j <= 6; j += 2){
            if(gameBoard[1][j].equals("X")
                    && gameBoard[2][j].equals("X")
                    && gameBoard[3][j].equals("X")){
                return Result.X_WIN;
            }else if(gameBoard[1][j].equals("O")
                    && gameBoard[2][j].equals("O")
                    && gameBoard[3][j].equals("O")){
                return Result.O_WIN;
            }
        }
        //判断斜线
        if((gameBoard[1][2].equals("X")
                && gameBoard[2][4].equals("X")
                && gameBoard[3][6].equals("X"))
            || (gameBoard[3][2].equals("X")
                && gameBoard[2][4].equals("X")
                && gameBoard[1][6].equals("X"))) {
            return Result.X_WIN;
        }else if((gameBoard[1][2].equals("O")
                && gameBoard[2][4].equals("O")
                && gameBoard[3][6].equals("O"))
                || (gameBoard[3][2].equals("O")
                && gameBoard[2][4].equals("O")
                && gameBoard[1][6].equals("O"))){
            return Result.O_WIN;
        }
        //判断平局还是游戏中
        int isDraw = 1;
        for(int i = 1; i < 4; i++){
            for(int j = 2; j <= 6; j += 2){
                if(gameBoard[i][j] == "_"){
                    isDraw = 0;
                    break;
                }
            }
            if(isDraw == 0){
                break;
            }
        }
        if(isDraw == 1){
            return Result.DRAW;
        }else {
            return Result.GAMING;
        }
    }
}
