import java.util.Scanner;

public class FindPrimes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 1; i <= t; i++){
			int n = in.nextInt();
			int prime1 = 0;
			int prime2 = 0;
			for(int j = 2; j <= n - 2; j++){
				boolean is_prime1 = true;
				boolean is_prime2 = true;
				for(int k = 2; k * k <= j; k++){
					if(j % k == 0){
						is_prime1 = false;
						break;
					}
				}
				for(int k = 2; k * k <= n - j; k++){
					if ((n - j) % k == 0){
						is_prime2 = false;
						break;
					}
				}
				if(is_prime1 && is_prime2){
					prime1 = j;
					prime2 = n - j;
					break;
				}
			}
			System.out.println(prime1 + " " + prime2);
		}
	}

}
