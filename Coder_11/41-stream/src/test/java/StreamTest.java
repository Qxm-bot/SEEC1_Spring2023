import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StreamTest {

	@Test
	public void test1() {
		assertEquals("Neal,Stu,Rich,Bob",
				Stream.getNamesStringImperatively(Arrays.asList("neal", "s", "stu", "j", "rich", "bob")));
	}

	@Test
	public void test2() {
		assertEquals("Stu,Neal,Rich,Bob",
				Stream.getNamesStringImperatively(Arrays.asList("stu", "s", "neal", "j", "rich", "bob")));
	}

	@Test
	public void test3() {
		assertEquals("Abc,Ca,Aa,Ba",
				Stream.getNamesStringImperatively(Arrays.asList("abc", "a", "ca", "d", "aa", "ba")));
	}

	@Test
	public void test4() {
		assertEquals("",
				Stream.getNamesStringImperatively(Arrays.asList("a", "b", "c", "d", "e")));
	}

	@Test
	public void test5() {
		assertEquals("Ab,Cd",
				Stream.getNamesStringImperatively(Arrays.asList("ab", "cd", "e", "f")));
	}
	
	
	@Test
	public void test6() {
		assertEquals("Neal,Stu,Rich,Bob",
				Stream.getNamesStringFunctionally(Arrays.asList("neal", "s", "stu", "j", "rich", "bob")));
	}

	@Test
	public void test7() {
		assertEquals("Stu,Neal,Rich,Bob",
				Stream.getNamesStringFunctionally(Arrays.asList("stu", "s", "neal", "j", "rich", "bob")));
	}

	@Test
	public void test8() {
		assertEquals("Abc,Ca,Aa,Ba",
				Stream.getNamesStringFunctionally(Arrays.asList("abc", "a", "ca", "d", "aa", "ba")));
	}

	@Test
	public void test9() {
		assertEquals("",
				Stream.getNamesStringFunctionally(Arrays.asList("a", "b", "c", "d", "e")));
	}

	@Test
	public void test10() {
		assertEquals("Ab,Cd",
				Stream.getNamesStringFunctionally(Arrays.asList("ab", "cd", "e", "f")));
	}

}
