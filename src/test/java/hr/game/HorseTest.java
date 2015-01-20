package hr.game;

import static org.junit.Assert.*;
import hr.game.Horse;

import org.junit.Before;
import org.junit.Test;

public class HorseTest {

	private String horseName;

	@Before
	public void setUp() throws Exception {
		horseName = "Horse Name";
	}

	@Test
	public void initHorse() {
		int initialYardsExpected = 0;

		Horse horse = new Horse(horseName);

		assertTrue(horseName.equals(horse.getName()));
		assertEquals(initialYardsExpected, horse.getRunned());
	}

	@Test(expected = IllegalArgumentException.class)
	public void initHorseWithBlankName_willThrowAnException() {
		String blankHorseName = "";

		Horse horse = new Horse(blankHorseName);

		assertTrue(blankHorseName.equals(horse.getName()));
	}

	@Test
	public void moveUp_IncreaseRunned_ByQuantitySupplied() {
		Horse horse = new Horse(horseName);
		int yardsBeforeMovement = horse.getRunned();
		int yardsToMove = 60;

		horse.moveUp(yardsToMove);
		int yardsLaterMovement = horse.getRunned();

		assertEquals(yardsBeforeMovement + yardsToMove, yardsLaterMovement);
	}
	
	
	@Test
	public void testEquality() {
		Horse horse1 = new Horse(horseName);
		Horse horse1bis = new Horse(horseName);
		Horse horse2 = new Horse("other horse name");

		assertEquals(horse1, horse1bis);
		assertFalse(horse1.equals(horse2));
	}
}