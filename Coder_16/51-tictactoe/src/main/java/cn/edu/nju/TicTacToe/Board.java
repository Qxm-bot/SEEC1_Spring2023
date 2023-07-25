package cn.edu.nju.TicTacToe;
public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected ChessStrategy chessStrategy;
	protected WinStrategy winStrategy;
	protected Player player = Player.X;

	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */
	
	public Board(int boardSize, ChessStrategy chessStrategy, WinStrategy winStrategy){
		cells = new char[boardSize + 1][2 * boardSize + 1];
		for(int i = 0; i < boardSize + 1; i++){
			for(int j = 0; j < 2 * boardSize + 1; j++){
				cells[i][j] = ' ';
			}
		}
		for(int i = 1; i < boardSize + 1; i++){
			for(int j = 2; j < 2 * boardSize + 1; j += 2){
				cells[i][j] = '_';
			}
		}
		for(int i = 1; i <= boardSize; i++){
			cells[0][2 * i] = (char)('A' + i - 1);
		}
		for(int i = 1; i <= boardSize; i++){
			cells[i][0] = (char)('1' + i - 1);
		}
		this.chessStrategy = chessStrategy;
		this.winStrategy = winStrategy;
	}

	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String move) {
		if(chessStrategy.putChess(cells, nextPlay(), move) == 0){
			return Result.ERROR;
		}
		return winStrategy.check(cells);
	}
	
	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	
	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(){
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				System.out.print(cells[i][j]);
			}
			System.out.println();
		}
	}
}