//import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Scanner;

public class HeartRateCalculation {

	public  static long calculate(double Age, double RestingHR, double Intensity){
		return  Math.round((((220 - Age) - RestingHR) * Intensity) + RestingHR);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("RestingHR:");
		double RestingHR = in.nextDouble();
		System.out.println("Age:");
		double Age = in.nextDouble();
		System.out.println("Intensity|TargetHeartRate");
		System.out.println("---------|---------------");
		for(int i = 55; i <= 95; i += 5){
			System.out.println(i + "% |" + calculate(Age, RestingHR, i / 100.0) + "bpm");
		}
	}

}
