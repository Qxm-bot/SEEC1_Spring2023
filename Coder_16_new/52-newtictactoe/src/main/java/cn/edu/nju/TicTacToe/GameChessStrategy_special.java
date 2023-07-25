package cn.edu.nju.TicTacToe;

public class GameChessStrategy_special implements ChessStrategy {
    int[][] order_of_X = new int[10][19];
    int[][] order_of_O = new int[10][19];
    int max_X = 0;
    int max_O = 0;

    /**
     * 落子方法，可根据需要自行调整传入参数
     *
     * @param cells         棋盘对应的char二维数组
     * @param currentPlayer 当前落子的玩家
     * @param chessPos      下棋位置的字符串表示
     */
    public int putChess(char[][] cells, Player currentPlayer, String chessPos) {
        int max = currentPlayer == Player.X ? max_X : max_O;
        if (max < 5) {
            int i = chessPos.charAt(1) - '0';
            int j = (chessPos.charAt(0) - 'A' + 1) * 2;
            if (cells[i][j] != '_') {
                return 0;
            }
            cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
            if (currentPlayer == Player.X) {
                max_X++;
                order_of_X[i][j] = max_X;
            } else {
                max_O++;
                order_of_O[i][j] = max_O;
            }
        } else {
            int k = chessPos.charAt(1) - '0';
            int l = (chessPos.charAt(0) - 'A' + 1) * 2;
            if (cells[k][l] != '_') {
                if (currentPlayer == Player.X) {
                    if (order_of_X[k][l] != 1) {
                        return 0;
                    }
                } else {
                    if (order_of_O[k][l] != 1) {
                        return 0;
                    }
                }
            }
            if (currentPlayer == Player.X) {
                int[][] copy = new int[cells.length][cells[0].length];
                for (int m = 0; m < cells.length; m++) {
                    for (int n = 0; n < cells[0].length; n++) {
                        copy[m][n] = order_of_X[m][n];
                    }
                }
                for (int i = 1; i < cells.length; i++) {
                    for (int j = 2; j < cells[0].length; j += 2) {
                        if (copy[i][j] == 2
                                || copy[i][j] == 3
                                || copy[i][j] == 4
                                || copy[i][j] == 5) {
                            order_of_X[i][j] -= 1;
                        } else if (copy[i][j] == 1) {
                            order_of_X[i][j] = 0;
                            cells[i][j] = '_';
                        }
                    }
                }
            } else {
                int[][] copy = new int[cells.length][cells[0].length];
                for (int m = 0; m < cells.length; m++) {
                    for (int n = 0; n < cells[0].length; n++) {
                        copy[m][n] = order_of_O[m][n];
                    }
                }
                for (int i = 1; i < cells.length; i++) {
                    for (int j = 2; j < cells[0].length; j += 2) {
                        if (copy[i][j] == 2
                                || copy[i][j] == 3
                                || copy[i][j] == 4
                                || copy[i][j] == 5) {
                            order_of_O[i][j] -= 1;
                        } else if (copy[i][j] == 1) {
                            order_of_O[i][j] = 0;
                            cells[i][j] = '_';
                        }
                    }
                }
            }
            cells[k][l] = currentPlayer == Player.X ? 'X' : 'O';
            if (currentPlayer == Player.X) {
                order_of_X[k][l] = 5;
            } else {
                order_of_O[k][l] = 5;
            }
        }
        return 1;
    }
}
