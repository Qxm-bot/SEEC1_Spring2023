import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CSVFileTest {
	PrintStream out = null;

	OutputStream outputStream = null;

	@Before
	public void setUp() {
		out = System.out;

		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

	}

	@After
	public void tearDown() {
		System.setOut(out);
	}

	@Test
	public void test1() {
		check("data1.txt", "Last    First    Salary", "Ling    Mai    55900", "Johnson    Jim    56500",
				"Zarnecki    Sabrina    51500");
	}

	@Test
	public void test2() {
		check("data2.txt", "Last    First    Salary", "Ash    Ha    42342", "Gou    Li    54522",
				"Guo    Jia    67435");
	}

	@Test
	public void test3() {
		check("data3.txt", "Last    First    Salary", "Qiyin    Huo    12300", "Fubi    Quzhi    641",
				"Gou    Fugui    7843");
	}

	@Test
	public void test4() {
		check("data4.txt", "Last    First    Salary", "Wodang    Shi    5200", "Jiunian    Le    5400",
				"Liangju    Shi    2300");
	}

	@Test
	public void test5() {
		check("data5.txt", "Last    First    Salary", "Gaoge    Da    53250", "Xinwen    Ni    56542",
				"Menke    Fuze    22502");
	}

	private void check(String fileName, String... expectedOutputs) {
		String filePath = CSVFile.class.getClassLoader().getResource(fileName).getPath();
		CSVFile.printCSVFile(filePath);
		String actual = outputStream.toString();
		String expected = "";
		for (String output : expectedOutputs) {
			expected += output + System.lineSeparator();
		}
		assertEquals(expected, actual);
	}

}
