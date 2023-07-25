import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResponseTimeCalculationTest {

	InputStream in = null;
	PrintStream out = null;

	InputStream inputStream = null;
	OutputStream outputStream = null;

	@Before
	public void setUp() {
		in = System.in;
		out = System.out;

		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Test
	public void test1() {
		check(Arrays.asList(100, 200, 1000, 300), 400, 100, 1000, 353.55);
	}

	@Test
	public void test2() {
		check(Arrays.asList(100, 200), 150, 100, 200, 50);
	}

	@Test
	public void test3() {
		check(Arrays.asList(100), 100, 100, 100, 0);
	}

	@Test
	public void test4() {
		check(Arrays.asList(100, 100, 100), 100, 100, 100, 0);
	}

	@Test
	public void test5() {
		check(Arrays.asList(100, 300), 200, 100, 300, 100);
	}

	@Test
	public void test6() {
		check(Arrays.asList(1), 1, 1, 1, 0);
	}

	@Test
	public void test7() {
		check(Arrays.asList(900, 100), 500.0, 100, 900, 400);
	}

	@Test
	public void test8() {
		check(Arrays.asList(200, 400, 600), 400, 200, 600, 163.3);
	}

	@Test
	public void test9() {
		check(Arrays.asList(100, 200, 100), 133.33, 100, 200, 47.14);
	}

	@Test
	public void test10() {
		check(Arrays.asList(96, 37, 42), 58.33, 37, 96, 26.71);
	}

	private void check(List<Integer> list, double average, int min, int max,
			double standardDeviation){

		StringBuilder listStringBuilder = new StringBuilder();
		StringBuilder input = new StringBuilder();
		for (Integer number : list) {
			input.append(number);
			input.append(System.lineSeparator());
			listStringBuilder.append(number);
			listStringBuilder.append(",");
		}
	
		int end = listStringBuilder.toString().lastIndexOf(",");
		String listString = listStringBuilder.substring(0, end).toString();

		input.append("done");

		inputStream = new ByteArrayInputStream(input.toString().getBytes());
		System.setIn(inputStream);

		ResponseTimeCalculation.main(null);
		
		int startIndex = list.size() + 1;
		String[] outputs = outputStream.toString().split(System.lineSeparator());
		assertEquals("Numbers:"+listString, outputs[startIndex]);
		assertEquals(String.format("The average is %.2f.", average), outputs[startIndex+1]);
		assertEquals(String.format("The minimum is %d.",min), outputs[startIndex+2]);
		assertEquals(String.format("The maximum is %d.",max), outputs[startIndex+3]);
		assertEquals(String.format("The standard deviation is %.2f.", standardDeviation), outputs[startIndex+4]);
		
	}

}
