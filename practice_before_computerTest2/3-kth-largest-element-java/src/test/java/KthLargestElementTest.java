import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KthLargestElementTest {
	@Test
	public void testA() {
		assertEquals(5, KthLargestElement.findKthLargest(new int[]{1, 2, 3, 4, 5, 6}, 2));
	}

	@Test
	public void testB() {
		assertEquals(4, KthLargestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3));
	}

	@Test
	public void testC() {
		assertEquals(1, KthLargestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 6));
	}

	@Test
	public void testD() {
		assertEquals(3, KthLargestElement.findKthLargest(new int[]{1, 1, 2, 2, 3, 3}, 2));
	}

	@Test
	public void testE() {
		assertEquals(6, KthLargestElement.findKthLargest(new int[]{6, 5, 4, 3, 2, 1}, 1));
	}

}