import java.util.Scanner;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int [][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        int t = (in.nextInt()) % 360;
        switch (t){
            case 0:
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print(matrix[i][j]);
                        if(j != n - 1){
                            System.out.print(" ");
                        }
                    }
                    if(i != m - 1){
                        System.out.println();
                    }
                }
                break;
            case 90:
                for(int j = 0; j < n; j++){
                    for(int i = m - 1; i >= 0; i--){
                        System.out.print(matrix[i][j]);
                        if(i != 0){
                            System.out.print(" ");
                        }
                    }
                    if(j != n - 1){
                        System.out.println();
                    }
                }
                break;
            case 180:
                for(int i = m - 1; i >= 0; i--){
                    for(int j = n - 1; j >= 0; j--){
                        System.out.print(matrix[i][j]);
                        if(j != 0){
                            System.out.print(" ");
                        }
                    }
                    if(i != 0){
                        System.out.println();
                    }
                }
                break;
            case 270:
                for(int j = n - 1; j >= 0; j--){
                    for(int i = 0; i < m; i++){
                        System.out.print(matrix[i][j]);
                        if(i != m - 1){
                            System.out.print(" ");
                        }
                    }
                    if(j != 0){
                        System.out.println();
                    }
                }
                break;
        }
    }
}
