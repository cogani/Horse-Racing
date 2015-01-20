package hr.results;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ResultItemTest {
	@Test
	public void test() {
		
		int aPosition = 1;
		int aLaneNumber = 2;
		String aHorseName = "horse name";
		
		ResultItem resultItem = new ResultItem(aPosition, aLaneNumber, aHorseName);
		assertEquals(aPosition, resultItem.getPosition());
		assertEquals(aLaneNumber, resultItem.getLaneNumber());
		assertEquals(aHorseName, resultItem.getHorseName());
	}
}