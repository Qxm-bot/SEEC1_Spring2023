public class Board {
    public void Drawing(String s){
        String[][] gameBoard = new String[4][7];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 7; j++){
                gameBoard[i][j] = " ";
            }
        }
        for(int i = 1; i < 4; i++){
            for(int j = 2; j <= 6; j += 2){
                gameBoard[i][j] = "_";
            }
        }
        gameBoard[0][2] = "A";
        gameBoard[0][4] = "B";
        gameBoard[0][6] = "C";
        gameBoard[1][0] = "1";
        gameBoard[2][0] = "2";
        gameBoard[3][0] = "3";
        String[] locations = s.split(",");
        for(int i = 0; i < locations.length; i++){
            switch (locations[i].charAt(0)){
                case 'A':
                    if(locations[i].charAt(1) == '1'){
                        if(i % 2 == 0){
                            gameBoard[1][2] = "X";
                        }else {
                            gameBoard[1][2] = "O";
                        }
                    }else if(locations[i].charAt(1) == '2'){
                        if(i % 2 == 0){
                            gameBoard[2][2] = "X";
                        }else {
                            gameBoard[2][2] = "O";
                        }
                    }else {
                        if(i % 2 == 0){
                            gameBoard[3][2] = "X";
                        }else {
                            gameBoard[3][2] = "O";
                        }
                    }
                    break;
                case 'B':
                    if(locations[i].charAt(1) == '1'){
                        if(i % 2 == 0){
                            gameBoard[1][4] = "X";
                        }else {
                            gameBoard[1][4] = "O";
                        }
                    }else if(locations[i].charAt(1) == '2'){
                        if(i % 2 == 0){
                            gameBoard[2][4] = "X";
                        }else {
                            gameBoard[2][4] = "O";
                        }
                    }else {
                        if(i % 2 == 0){
                            gameBoard[3][4] = "X";
                        }else {
                            gameBoard[3][4] = "O";
                        }
                    }
                    break;
                case 'C':
                    if(locations[i].charAt(1) == '1'){
                        if(i % 2 == 0){
                            gameBoard[1][6] = "X";
                        }else {
                            gameBoard[1][6] = "O";
                        }
                    }else if(locations[i].charAt(1) == '2'){
                        if(i % 2 == 0){
                            gameBoard[2][6] = "X";
                        }else {
                            gameBoard[2][6] = "O";
                        }
                    }else {
                        if(i % 2 == 0){
                            gameBoard[3][6] = "X";
                        }else {
                            gameBoard[3][6] = "O";
                        }
                    }
                    break;
            }
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 7; k++){
                    System.out.print(gameBoard[j][k]);
                }
                System.out.println();
            }
        }
    }
    public String[][] getFinalBoard(String s){
        String[][] gameBoard = new String[4][7];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 7; j++){
                gameBoard[i][j] = " ";
            }
        }
        for(int i = 1; i < 4; i++){
            for(int j = 2; j <= 6; j += 2){
                gameBoard[i][j] = "_";
            }
        }
        gameBoard[0][2] = "A";
        gameBoard[0][4] = "B";
        gameBoard[0][6] = "C";
        gameBoard[1][0] = "1";
        gameBoard[2][0] = "2";
        gameBoard[3][0] = "3";
        String[] locations = s.split(",");
        for(int i = 0; i < locations.length; i++){
            switch (locations[i].charAt(0)){
                case 'A':
                    if(locations[i].charAt(1) == '1'){
                        if(i % 2 == 0){
                            gameBoard[1][2] = "X";
                        }else {
                            gameBoard[1][2] = "O";
                        }
                    }else if(locations[i].charAt(1) == '2'){
                        if(i % 2 == 0){
                            gameBoard[2][2] = "X";
                        }else {
                            gameBoard[2][2] = "O";
                        }
                    }else {
                        if(i % 2 == 0){
                            gameBoard[3][2] = "X";
                        }else {
                            gameBoard[3][2] = "O";
                        }
                    }
                    break;
                case 'B':
                    if(locations[i].charAt(1) == '1'){
                        if(i % 2 == 0){
                            gameBoard[1][4] = "X";
                        }else {
                            gameBoard[1][4] = "O";
                        }
                    }else if(locations[i].charAt(1) == '2'){
                        if(i % 2 == 0){
                            gameBoard[2][4] = "X";
                        }else {
                            gameBoard[2][4] = "O";
                        }
                    }else {
                        if(i % 2 == 0){
                            gameBoard[3][4] = "X";
                        }else {
                            gameBoard[3][4] = "O";
                        }
                    }
                    break;
                case 'C':
                    if(locations[i].charAt(1) == '1'){
                        if(i % 2 == 0){
                            gameBoard[1][6] = "X";
                        }else {
                            gameBoard[1][6] = "O";
                        }
                    }else if(locations[i].charAt(1) == '2'){
                        if(i % 2 == 0){
                            gameBoard[2][6] = "X";
                        }else {
                            gameBoard[2][6] = "O";
                        }
                    }else {
                        if(i % 2 == 0){
                            gameBoard[3][6] = "X";
                        }else {
                            gameBoard[3][6] = "O";
                        }
                    }
                    break;
            }
        }
        return gameBoard;
    }
}
