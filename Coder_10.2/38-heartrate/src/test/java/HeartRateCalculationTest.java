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

public class HeartRateCalculationTest {

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
		check(65, 22, Arrays.asList(138, 145, 151, 158, 165, 171, 178, 185, 191));
	}

	@Test
	public void test2() {
		check(45, 66, Arrays.asList(105, 110, 116, 121, 127, 132, 138, 143, 149));
	}

	@Test
	public void test3() {
		check(25, 45, Arrays.asList(108, 115, 123, 130, 138, 145, 153, 160, 168));
	}

	@Test
	public void test4() {
		check(32, 43, Arrays.asList(112, 119, 126, 134, 141, 148, 155, 163, 170));
	}

	@Test
	public void test5() {
		// 已修正
		check(15, 35, Arrays.asList(109, 117, 126, 134, 143, 151, 160, 168, 177));
	}

	@Test
	public void test6() {
		check(31, 42, Arrays.asList(112, 119, 127, 134, 141, 149, 156, 163, 171));
	}

	@Test
	public void test7() {
		check(65, 29, Arrays.asList(134, 141, 147, 153, 160, 166, 172, 178, 185));
	}

	@Test
	public void test8() {
		check(55, 28, Arrays.asList(130, 137, 144, 151, 158, 165, 171, 178, 185));
	}

	@Test
	public void test9() {
		check(33, 66, Arrays.asList(100, 106, 112, 118, 124, 130, 136, 142, 148));
	}

	@Test
	public void test10() {
		check(75, 72, Arrays.asList(115, 119, 122, 126, 130, 133, 137, 141, 144));
	}

	private void check(int restingHR, int age, List<Integer> expected) {
		String input = restingHR + System.lineSeparator() + age;
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		HeartRateCalculation.main(null);
		Pattern pattern = Pattern.compile("(\\d+)bpm", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(outputStream.toString());

		List<Integer> actual = new ArrayList<Integer>();

		while (matcher.find()) {
			actual.add(Integer.parseInt(matcher.group(1)));
		}

		assertEquals(expected.toString(), actual.toString());

	}

}
