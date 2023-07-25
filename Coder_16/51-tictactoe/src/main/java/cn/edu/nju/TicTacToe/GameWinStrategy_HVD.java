package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HVD implements WinStrategy{
	/**
	 * 根据需要修改获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells)
	{
		//判断是否有三子成行/列/斜线
		for(int i = 1; i <= cells.length - 3; i++){
			for(int j = 2; j <= cells[0].length - 5; j += 2){
				//判断行
				for(int k = i; k < i + 3; k++){
					if(cells[k][j] == 'X'
							&& cells[k][j + 2] == 'X'
							&& cells[k][j + 4] == 'X'){
						return Result.X_WIN;
					}else if(cells[k][j] == 'O'
							&& cells[k][j + 2] == 'O'
							&& cells[k][j + 4] == 'O'){
						return Result.O_WIN;
					}
				}
				//判断列
				for(int k = j; k <= j + 4; k += 2){
					if(cells[i][k] == 'X'
							&& cells[i + 1][k] == 'X'
							&& cells[i + 2][k] == 'X'){
						return Result.X_WIN;
					}else if(cells[i][k] == 'O'
							&& cells[i + 1][k] == 'O'
							&& cells[i + 2][k] == 'O'){
						return Result.O_WIN;
					}
				}
				//判断斜线
				if((cells[i][j] == 'X'
						&& cells[i + 1][j + 2] == 'X'
						&& cells[i + 2][j + 4] == 'X')
						|| (cells[i + 2][j] == 'X'
						&& cells[i + 1][j + 2] == 'X'
						&& cells[i][j + 4] == 'X')) {
					return Result.X_WIN;
				}else if((cells[i][j] == 'O'
						&& cells[i + 1][j + 2] == 'O'
						&& cells[i + 2][j + 4] == 'O')
						|| (cells[i + 2][j] == 'O'
						&& cells[i + 1][j + 2] == 'O'
						&& cells[i][j + 4] == 'O')){
					return Result.O_WIN;
				}
			}
		}
		//判断平局还是游戏中
		int isDraw = 1;
		for(int i = 1; i < cells.length; i++){
			for(int j = 2; j < cells[0].length; j += 2){
				if(cells[i][j] == '_'){
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