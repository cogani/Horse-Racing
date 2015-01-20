package hr.game;

import static org.junit.Assert.*;
import hr.game.Toss;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TossTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void initProcess() {
		int aLaneNumber=1;
		int aYardsToMove = 50;
		Toss toss = new Toss(aLaneNumber, aYardsToMove );
		
		assertEquals(aLaneNumber, toss.getLaneNumber());
		assertEquals(aYardsToMove, toss.getYardsToMove());
	}
}
