package hr.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hr.game.Circuit;
import hr.game.Race;
import hr.game.RaceException;
import hr.game.Toss;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RaceTest {
	@Test
	public void initTest() {
		Circuit dummyCircuit = createFixtureCircuit();
		Race race = new Race(dummyCircuit);

		assertEquals(dummyCircuit, race.getCircuit());
		assertFalse(race.isRaceFinished());
	}
	
	@Test(expected=RaceException.class)
	public void aTossWithANotPreparedLane_WillThrowAnRaceException() {
		Circuit circuitWithOneLane = createFixtureCircuitWithOneLane();
		int notPreparedLaneNumber = 2;
		int dummyYardsToMove = 10;
		Toss rossWithNoPreparedLane = new Toss(notPreparedLaneNumber, dummyYardsToMove);
		Race race = new Race(circuitWithOneLane);
		
		race.play(rossWithNoPreparedLane);
	}
	
	@Test(expected=RaceException.class)
	public void aTossWithANotValidHole_WillThrowAnRaceException() {
		Circuit circuitWithOneLane = createFixtureCircuitWithOneLane();
		int laneNumber = 1;
		int notValidYardsToMove = 12;
		Toss tossWithNotValidHole = new Toss(laneNumber, notValidYardsToMove);
		Race race = new Race(circuitWithOneLane);
		
		race.play(tossWithNotValidHole);
	}
	
	public void whileNoneHorseReachTheGoal_RaceIsNotFinished() {
		Circuit circuitWithOneLane = createFixtureCircuitWithOneLane();
		Race race = new Race(circuitWithOneLane);
		int laneNumber = 1;
		int yardsToMove = 60;
		Toss toss = new Toss(laneNumber, yardsToMove);
		
		race.play(toss);
		race.play(toss);
		race.play(toss);
		race.play(toss);
		
		assertFalse(race.isRaceFinished());
		
	}
	
	public void whenAHorseReachTheGoal_RaceIsFinished() {
		Circuit circuitWithOneLane = createFixtureCircuitWithOneLane();
		int laneNumber = 1;
		Race race = new Race(circuitWithOneLane);
		
		throwTossesUntilTheHorseReachTheGoal(race, laneNumber);
		
		assertTrue(race.isRaceFinished());
		
	}
	
	@Test(expected=RaceException.class)
	public void whenRaceIsFinished_IfOneNewTossIsTry_WillBeThrowAnException() {
		Circuit circuitWithOneLane = createFixtureCircuitWithOneLane();
		Race race = new Race(circuitWithOneLane);
		int laneNumber = 1;
		int yardsToMove = 5;
		
		throwTossesUntilTheHorseReachTheGoal(race, laneNumber);
		
		//Race was already finish with the previous tosses
		race.play(new Toss(laneNumber, yardsToMove));
	}
	
	private Circuit createFixtureCircuit(){
		List<String> horseNames = new ArrayList<String>();
		horseNames.add("horseName1");
		horseNames.add("horseName2");
		horseNames.add("horseName3");
		return new Circuit(horseNames);
	}

	
	private Circuit createFixtureCircuitWithOneLane(){
		List<String> horseNames = new ArrayList<String>();
		horseNames.add("horseName1");
		
		return new Circuit(horseNames);
	}
	
	private void throwTossesUntilTheHorseReachTheGoal(Race race, int laneNumber){
		int yardsToMove = 60;
		Toss toss = new Toss(laneNumber, yardsToMove);
		// 60 * 4 = 240 > 220 (yards per Furlong) 
		race.play(toss);
		race.play(toss);
		race.play(toss);
		race.play(toss);
	}
}