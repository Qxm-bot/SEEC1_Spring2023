import java.util.Scanner;

public class ZTransformation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int N = in.nextInt();
        // case of N == 1
        if (N == 1){
            for(int i = 0; i < s.length(); i++){
                System.out.print(s.charAt(i));
                if(i != s.length() - 1){
                    System.out.print(" ");
                }
            }
        }else {
        // cases of N >= 2
            // calculate the number of columns
            int pairs = s.length() / (2 * N - 2);
            int num_left = s.length() - pairs * (2 * N - 2);
            int cols = 0;
            if(num_left != 0){
                if(num_left <= N){
                    cols = pairs * 2 * (N - 1) + 1;
                }else {
                    cols = pairs * 2 * (N - 1) + 2 * (num_left - N + 1) - 1;
                }
            }else {
                cols = pairs * 2 * (N - 1) - 1;
            }
            //initialize the array picture
            char[][] picture = new char[N][cols];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < cols; j++){
                    picture[i][j] = ' ';
                }
            }
            // draw the picture
            int count = 0;
            int row = 0;
            int col = 0;
            while(count != s.length()){
                picture[row][col] = s.charAt(count);
                count++;
                if(count % (2 * N - 2) < N
                        && count % (2 * N - 2) > 0){
                    row += 1;
                }else {
                    col += 2;
                    row -= 1;
                }
            }
            // print the picture
            if(s.length() < N){
                for(int i = 0; i < s.length(); i++){
                    int k = 0;
                    for(int j = cols - 1; j >= 0; j--){
                        if(picture[i][j] != ' '){
                            k = j;
                            break;
                        }
                    }
                    for(int j = 0; j <= k; j++){
                        System.out.print(picture[i][j]);
                    }
                    String ls = System.lineSeparator();
                    if(i != s.length() - 1){
                        System.out.print(ls);
                    }
                }
            }else {
                for(int i = 0; i < N; i++){
                    int k = 0;
                    for(int j = cols - 1; j >= 0; j--){
                        if(picture[i][j] != ' '){
                            k = j;
                            break;
                        }
                    }
                    for(int j = 0; j <= k; j++){
                        System.out.print(picture[i][j]);
                    }
                    String ls = System.lineSeparator();
                    if(i != N - 1){
                        System.out.print(ls);
                    }
                }
            }
        }
    }
}
