import java.util.Scanner;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		int lines = B.data.length;
		int cols = B.data[0].length;
		int[][] a = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				a[i][j] = B.data[i][j] + data[i][j];
			}
		}
		return new MyMatrix(a);
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		int m = data.length;
		int n = data[0].length;
		int p = B.data[0].length;
		int[][] a = new int[m][p];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < p; j++){
				for(int k = 0; k < n; k++){
					a[i][j] += (data[i][k] * B.data[k][j]);
				}
			}
		}
		return new MyMatrix(a);
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		int lines = data.length;
		int cols = data[0].length;
		int[][] a = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				a[i][j] = b * data[i][j];
			}
		}
		return new MyMatrix(a);
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int lines = data.length;
		int cols = data[0].length;
		int[][] a = new int[cols][lines];
		for(int i = 0; i < cols; i++){
			for(int j = 0; j < lines; j++){
				a[i][j] = data[j][i];
			}
		}
		return new MyMatrix(a);
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		Scanner in = new Scanner(System.in);
		int lines = in.nextInt();
		int cols = in.nextInt();
		int [][] a = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				a[i][j] = in.nextInt();
			}
		}
		int [][] add = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				add[i][j] = a[i][j] + data[i][j];
			}
		}
		return new MyMatrix(add);
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		int P = in.nextInt();
		int [][] a = new int[I][P];
		for(int i = 0; i < I; i++){
			for(int j = 0; j < P; j++){
				a[i][j] = in.nextInt();
			}
		}
		int J = data[0].length;
		int [][] mul = new int[I][J];
		for(int i = 0; i < I; i++){
			for(int j = 0; j < J; j++){
				for(int k = 0; k < P; k++){
					mul[i][j] += a[i][k] * data[k][j];
				}
			}
		}
		return new MyMatrix(mul);
	}
	
	/**
	 * 打印出该矩阵的数据
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
	public void print(){
		int lines = data.length;
		int cols = data[0].length;
		System.out.println();
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(data[i][j]);
				if(j != cols - 1){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
