package hr.game;

import static org.junit.Assert.*;
import hr.game.Circuit;
import hr.game.CircuitException;
import hr.game.Horse;
import hr.game.Lane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class CircuitTest {

	@Test
	public void initTest() {
		int yardsPerFurlongExpected = 220;
		List<String> horseNames = new ArrayList<String>();
		horseNames.add("horseName1");
		horseNames.add("horseName2");
		horseNames.add("horseName3");
		int numberLineExpected = 3;

		Circuit circuit = new Circuit(horseNames);
		List<Lane> lanes = circuit.getLanes();

		assertEquals(yardsPerFurlongExpected, Circuit.YARDS_PER_FURLONG);
		assertEquals(numberLineExpected, lanes.size());
		checkHorsesAreInLanes(horseNames, lanes);
	}

	@Test(expected = CircuitException.class)
	public void initCircuitWithEmptyHorseNames_WillThrowAnException() {
		List<String> emptyHorseNames = new ArrayList<String>();


		@SuppressWarnings("unused")
		Circuit notValidCircuit = new Circuit(emptyHorseNames);
	}
	
	@Test(expected = CircuitException.class)
	public void initCircuitWithDuplicatedHorseNames_WillThrowAnException() {
		List<String> horseNamesWithDuplicates = new ArrayList<String>();
		horseNamesWithDuplicates.add("horseName1");
		horseNamesWithDuplicates.add("horseName1");


		@SuppressWarnings("unused")
		Circuit notValidCircuit = new Circuit(horseNamesWithDuplicates);
	}
	
	@Test(expected = CircuitException.class)
	public void tryingToGetNotValidLane_WillThrowAnException() {
		List<String> horseNames = new ArrayList<String>();
		horseNames.add("horseName1");

		Circuit circuit = new Circuit(horseNames);
		circuit.getLane(2);
	}
	
	@Test
	public void checkHolesInCircuit() {
		List<String> horseNames = new ArrayList<String>();
		horseNames.add("horseName1");
		Circuit circuit = new Circuit(horseNames);
		
		checkHolesValidity(circuit);
	}
	
	private void checkHolesValidity(Circuit circuit) {
		int totalHoleTypesExpected = 5;
		
		assertEquals(totalHoleTypesExpected, circuit.getDifferentHolesTypesNumber());
		assertTrue(circuit.isValidHole(5));
		assertTrue(circuit.isValidHole(10));
		assertTrue(circuit.isValidHole(20));
		assertTrue(circuit.isValidHole(40));
		assertTrue(circuit.isValidHole(60));
		
		assertFalse(circuit.isValidHole(50));
	}
	
	private void checkHorsesAreInLanes(List<String> horseNames, List<Lane> lanes) {
		Iterator<String> horseNamesIterator = horseNames.iterator();
		
		assertEquals("It must be as lanes as different horses", lanes.size(), horseNames.size());

		for(Lane lane: lanes) {
			Horse horse = new Horse(horseNamesIterator.next());
			assertEquals(lane.getHorse(), horse);
		}
	}
}