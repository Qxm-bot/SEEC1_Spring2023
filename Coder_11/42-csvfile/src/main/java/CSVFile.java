import java.io.*;
import java.util.Scanner;

public class CSVFile {

	public static void main(String[] args){
		String filePath = CSVFile.class.getClassLoader().getResource("data.txt").getPath();
		printCSVFile(filePath);
	}

	public static void printCSVFile(String filePath){
		Scanner f = null;
		try {
			f = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Last    First    Salary");
		while(f.hasNextLine()){
			String s = f.nextLine();
			String[] split = s.split(",");
			System.out.println(split[0] + "    " + split[1] + "    " + split[2]);
		}
		f.close();
	}
}