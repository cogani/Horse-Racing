package hr.game;


public class Race {
	private Circuit circuit;
	private boolean raceFinished;
	
	public Race(Circuit aCircuit) {
		circuit = aCircuit;
		raceFinished = false;
	}

	public void play(Toss toss) throws RaceException {
		if (isRaceFinished())
			throw new RaceException(
					"Can't play a new toss when race is already finished");

		checkTossValidity(toss);
		raceFinished = throwToss(toss);
	}

	public boolean isRaceFinished() {
		return raceFinished;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	private void checkTossValidity(Toss toos) throws RaceException {
		int yards = toos.getYardsToMove();
		if (circuit.isValidHole(yards) == false)
			throw new RaceException(yards + ": not valid hole");

		if (circuit.isValidIndexLaneNumber(toos.getLaneNumber()) == false)
			throw new RaceException(toos.getLaneNumber()
					+ ": not valid lane number");

	}

	private boolean throwToss(Toss toss) {
		Lane lane = circuit.getLane(toss.getLaneNumber());
		Horse horse = lane.getHorse();
		horse.moveUp(toss.getYardsToMove());

		return horseReachTheGoal(horse);
	}

	private boolean horseReachTheGoal(Horse horse) {
		return horse.getRunned() >= Circuit.YARDS_PER_FURLONG ? true : false;
	}

}
