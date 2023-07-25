import java.util.Scanner;

public class ResponseTimeCalculation {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number:");
		String input = in.next();
		int[] record = new int[100];
		int total = 0;
		int square_total = 0;
		int max = Integer.parseInt(input);
		int min = Integer.parseInt(input);
		int count = 0;
		while(!(input.equals("done"))){
			int t = Integer.parseInt(input);
			if(t > max){
				max = t;
			}
			if(t < min){
				min = t;
			}
			record[count] = t;
			total += t;
			square_total += (int)Math.pow(t, 2);
			count++;
			System.out.println("Enter a number:");
			input = in.next();
		}
		double average = total * 1.0 / count;
		double standard_deviation = Math.sqrt(square_total * 1.0 / count - Math.pow(average, 2));
		System.out.print("Numbers:");
		for(int i = 0; i < count; i++){
			System.out.print(record[i]);
			if(i != count - 1){
				System.out.print(",");
			}else {
				System.out.println();
			}
		}
		System.out.printf("The average is %.2f." + System.lineSeparator(), average);
		System.out.println("The minimum is " + min + ".");
		System.out.println("The maximum is " + max + ".");
		System.out.printf("The standard deviation is %.2f.", standard_deviation);
	}
	
}
