package edu.nju;

import java.util.Scanner;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		int lines = A.length;
		int cols = A[0].length;
		int [][] add = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				add[i][j] = A[i][j] + B[i][j];
			}
		}
 		return add;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		int I = A.length;
		int P = A[0].length;
		int J = B[0].length;
		int [][] mul = new int[I][J];
		for(int i = 0; i < I; i++){
			for(int j = 0; j < J; j++){
				for(int k = 0; k < P; k++){
					mul[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return mul;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
		Scanner in = new Scanner(System.in);
		int lines = in.nextInt();
		int cols = in.nextInt();
		int [][] a = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				a[i][j] = in.nextInt();
			}
		}
		lines = in.nextInt();
		cols = in.nextInt();
		int [][] b = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				b[i][j] = in.nextInt();
			}
		}
		int [][] add = new int[lines][cols];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				add[i][j] = a[i][j] + b[i][j];
			}
		}
		return add;
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		int P = in.nextInt();
		int [][] a = new int[I][P];
		for(int i = 0; i < I; i++){
			for(int j = 0; j < P; j++){
				a[i][j] = in.nextInt();
			}
		}
		P = in.nextInt();
		int J = in.nextInt();
		int [][] b = new int[P][J];
		for(int i = 0; i < P; i++){
			for(int j = 0; j < J; j++){
				b[i][j] = in.nextInt();
			}
		}
		int [][] mul = new int[I][J];
		for(int i = 0; i < I; i++){
			for(int j = 0; j < J; j++){
				for(int k = 0; k < P; k++){
					mul[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return mul;
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
	public void print(int[][] A){
		int lines = A.length;
		int cols = A[0].length;
		System.out.println();
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(A[i][j]);
				if(j != cols - 1){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
