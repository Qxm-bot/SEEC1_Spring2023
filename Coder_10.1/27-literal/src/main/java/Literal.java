import java.util.Scanner;

public class Literal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if(s.equals("true") || s.equals("false")){
            System.out.print("boolean");
        }else if(s.charAt(0) == s.charAt(s.length() - 1)
                && s.charAt(0) == '\''){
            System.out.print("char");
        }else {
            int isInteger = 1;
            int count_point = 0;
            int count_f = 0;
            int count_L = 0;
            for(int i = 1; i < s.length(); i++){
                if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                    isInteger = 0;
                }
                if(s.charAt(i) == '.'){
                    count_point++;
                }
                if(s.charAt(i) == 'f'){
                    count_f++;
                }
                if(s.charAt(i) == 'L'){
                    count_L++;
                }
            }
            if(isInteger == 1){
                System.out.print("integer");
            }else if(count_point == 1 && count_f == 0){
                System.out.print("double");
            }else if(count_point == 1){
                System.out.print("float");
            }else if(count_L == 1){
                System.out.print("long");
            }
        }
    }
}
