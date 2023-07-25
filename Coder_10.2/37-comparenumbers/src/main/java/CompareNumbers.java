import java.util.Scanner;

public class CompareNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first number:");
		int first_number = in.nextInt();
		System.out.println("Enter the second number:");
		int second_number = in.nextInt();
		System.out.println("Enter the third number:");
		int third_number = in.nextInt();
		if (first_number == second_number || first_number == third_number || second_number == third_number){
			System.out.println("There are same numbers.");
		}else {
			int max = first_number;
			if(first_number < second_number){
				max = second_number;
			}
			if(max < third_number){
				max = third_number;
			}
			System.out.println("The largest number is " + max + ".");
		}
	}

}
