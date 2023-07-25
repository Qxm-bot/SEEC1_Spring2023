

import java.util.Arrays;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法
 * 1.传入一个int[][]进行2个矩阵的操作
 * 2.返回一个int[][]
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Qin Liu
 *
 */
public class BadMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public BadMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
    public int[][] plus(int[][] b){
    	int lines = b.length;
		int cols = b[0].length;
		int[][] a = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				a[i][j] = b[i][j] + data[i][j];
			}
		}
		return a;
	}
        
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] b){
		int m = data.length;
		int n = data[0].length;
		int p = b[0].length;
		int[][] a = new int[m][p];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < p; j++){
				for(int k = 0; k < n; k++){
					a[i][j] += (data[i][k] * b[k][j]);
				}
			}
		}
		return a;
	}

	//不要修改下面print方法
	/**
	 * 打印出该矩阵的数据
	 * 
	 */
	public void print(){
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 *
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 *
	 */
	public String toString(){
		String ans = "";
		ans += System.getProperty("line.separator");
		int lines = data.length;
		int cols = data[0].length;
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				ans += String.valueOf(data[i][j]);
				if(j == cols - 1){
					ans += System.getProperty("line.separator");
				}else {
					ans += " ";
				}
			}
		}
		return ans;
	}

	//不要修改下面equals方法
	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}
}
