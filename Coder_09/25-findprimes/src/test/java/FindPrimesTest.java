import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindPrimesTest {

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
		check(3, Arrays.asList(4,8,20), Arrays.asList(2,2,3,5,3,17));
	}

	@Test
	public void test2() {
		check(3, Arrays.asList(8,10,12), Arrays.asList(3,5,3,7,5,7));
	}

	@Test
	public void test3() {
		check(3, Arrays.asList(14,16,18), Arrays.asList(3,11,3,13,5,13));
	}

	@Test
	public void test4() {
		check(3, Arrays.asList(20,22,26), Arrays.asList(3,17,3,19,3,23));
	}

	@Test
	public void test5()  {
		check(3, Arrays.asList(6,28,30), Arrays.asList(3,3,5,23,7,23));
	}

	@Test
	public void test6() {
		check(4, Arrays.asList(22,32,34,36), Arrays.asList(3,19,3,29,3,31,5,31));
	}

	@Test
	public void test7() {
		check(4, Arrays.asList(38,14,40,42), Arrays.asList(7,31,3,11,3,37,5,37));
	}

	@Test
	public void test8() {
		check(4, Arrays.asList(44,46,48,50), Arrays.asList(3,41,3,43,5,43,3,47));
	}

	@Test
	public void test9() {
		check(5, Arrays.asList(10,20,30,40,50), Arrays.asList(3,7,3,17,7,23,3,37,3,47));
	}

	@Test
	public void test10() {
		check(8, Arrays.asList(18,28,38,48,58,68,78,88), Arrays.asList(5,13,5,23,7,31,5,43,5,53,7,61,5,73,5,83));
	}

	private void check(int t, List<Integer> Evens, List<Integer> expected) {
		String input = String.valueOf(t);
		for (Integer oneEven:Evens){
			input =  input + System.lineSeparator() + String.valueOf(oneEven);
		}
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);


		FindPrimes.main(null);
		Pattern pattern = Pattern.compile("(\\d+)", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(outputStream.toString());
		List<Integer> actual = new ArrayList<Integer>();

		while (matcher.find()) {
			actual.add(Integer.parseInt(matcher.group(1)));
		}

		assertEquals(expected.toString(), actual.toString());

	}

}
