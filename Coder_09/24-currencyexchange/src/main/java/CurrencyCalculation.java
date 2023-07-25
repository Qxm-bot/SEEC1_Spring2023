import java.util.Scanner;

public class CurrencyCalculation {

	public static void main(String[] args) {
		System.out.println("How many euros are you exchanging?");
		Scanner in = new Scanner(System.in);
		double euros = in.nextDouble();
		System.out.println("What is the exchange rate?");
		double rate = in.nextDouble();
		double dollars = euros * rate / 100;
		System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.", euros, rate, dollars);
	}

}
