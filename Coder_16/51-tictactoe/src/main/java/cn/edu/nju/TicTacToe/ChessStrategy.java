package cn.edu.nju.TicTacToe;

public interface ChessStrategy {
    public int putChess(char[][] cells, Player currentPlayer, String chessPos);
}
