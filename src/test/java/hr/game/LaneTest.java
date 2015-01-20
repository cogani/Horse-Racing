package hr.game;

import static org.junit.Assert.assertEquals;
import hr.game.Horse;
import hr.game.Lane;
import hr.game.LaneException;

import org.junit.Test;

public class LaneTest {
	@Test
	public void initProcess() {
		int laneNumber = 1;
		Horse horse = new Horse("dummyName");
		Lane lane = new Lane(laneNumber, horse);
		
		assertEquals(laneNumber, lane.getNumber());
		assertEquals(horse, lane.getHorse());
	}
	
	@Test(expected=LaneException.class)
	public void isLaneIsLessThan1_WillBeThrowAnException() {
		int laneNumber = 0;
		Horse horse = new Horse("dummyName");
		
		@SuppressWarnings("unused")
		Lane lane = new Lane(laneNumber, horse);
	}
	
	@Test(expected=LaneException.class)
	public void isNullHorseIsSupplied_WillBeThrowAnException() {
		int laneNumber = 1;
		Horse horse = null;

		@SuppressWarnings("unused")
		Lane lane = new Lane(laneNumber, horse);
	}
}