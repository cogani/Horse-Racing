package hr.results;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hr.game.Horse;
import hr.game.Lane;
import hr.results.ResultItem;
import hr.results.Score;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ScoreTest {

	private ResultItem resultItemPosition1;
	private ResultItem resultItemPosition2;
	private ResultItem resultItemPosition3;
	private ResultItem resultItemPosition4;
	private ResultItem resultItemPosition5;

	@Before
	public void setUp() throws Exception {
		initResultItems();
	}

	@Test
	public void test() {
		List<Lane> lanes = createFixtureLanes();
		Score score = new Score(lanes);

		List<ResultItem> resultItems = score.getResultItems();

		assertEquals(5, resultItems.size());
		assertTrue(resultItems.contains(resultItemPosition1));
		assertTrue(resultItems.contains(resultItemPosition2));
		assertTrue(resultItems.contains(resultItemPosition3));
		assertTrue(resultItems.contains(resultItemPosition4));
		assertTrue(resultItems.contains(resultItemPosition5));
	}

	private List<Lane> createFixtureLanes() {
		List<Lane> lanes = new ArrayList<Lane>();

		lanes.add(createLaneWithHorseInPosition(1, "Star", 220));
		lanes.add(createLaneWithHorseInPosition(2, "Dakota", 5));
		lanes.add(createLaneWithHorseInPosition(3, "Cheyenne", 25));
		lanes.add(createLaneWithHorseInPosition(4, "Misty", 15));
		lanes.add(createLaneWithHorseInPosition(5, "Spirit", 10));

		return lanes;
	}
	
	private Lane createLaneWithHorseInPosition(int laneNumer, String horseName, int horsePosition){
		Horse horse = new Horse(horseName);
		horse.moveUp(horsePosition);
		return new Lane(laneNumer, horse);
	}

	private void initResultItems() {
		resultItemPosition1 = new ResultItem(1, 1, "Star");
		resultItemPosition2 = new ResultItem(2, 3, "Cheyenne");
		resultItemPosition3 = new ResultItem(3, 4, "Misty");
		resultItemPosition4 = new ResultItem(4, 5, "Spirit");
		resultItemPosition5 = new ResultItem(5, 2, "Dakota");
	}
}