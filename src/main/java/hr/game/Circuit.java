package hr.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Circuit {
	private List<Lane> lanes;
	private Collection<Integer> holeValues;
	public final static int YARDS_PER_FURLONG = 220;

	public Circuit(List<String> horseNames) throws CircuitException {
		initLanes(horseNames);
		initHoles();
	}

	private void initHoles() {
		holeValues = new HashSet<Integer>();
		holeValues.add(5);
		holeValues.add(10);
		holeValues.add(20);
		holeValues.add(40);
		holeValues.add(60);
	}

	private void initLanes(List<String> horseNames) {
		if (horseNames.size() == 0)
			throw new CircuitException(
					"Not allowed to init a circuit with no horses");
		
		if(isThereAnyDuplicatesHorseNames(horseNames)==true)
			throw new CircuitException("Duplicates horses are not allowed in circuit");

		lanes = new ArrayList<Lane>();
		int laneNumber = 1;

		for (String horseName : horseNames) {
			Horse horse = new Horse(horseName);
			Lane lane = new Lane(laneNumber, horse);
			lanes.add(lane);
			laneNumber++;
		}
	}

	public final List<Lane> getLanes() {
		return lanes;
	}

	public Lane getLane(int laneNumber) {
		int indexLaneNumber = convertLaneNumberToIndexLaneNumber(laneNumber);
		if (indexLaneNumber < 0 || indexLaneNumber >= lanes.size())
			throw new CircuitException("Lane '" + laneNumber + "' not valid");

		return lanes.get(laneNumber - 1);
	}

	public boolean isValidIndexLaneNumber(int laneNumber) {
		int indexLaneNumber = convertLaneNumberToIndexLaneNumber(laneNumber);
		return 0 <= indexLaneNumber && indexLaneNumber < lanes.size() ? true
				: false;
	}

	public boolean isValidHole(int yardHole) {
		return holeValues.contains(yardHole);
	}

	public int getDifferentHolesTypesNumber() {
		return holeValues.size();
	}

	private int convertLaneNumberToIndexLaneNumber(int laneNumber) {
		return laneNumber - 1;
	}

	private boolean isThereAnyDuplicatesHorseNames(List<String> horseNames) {
		Collection<String> setHorses = new HashSet<String>();
		setHorses.addAll(horseNames);

		return setHorses.size() == horseNames.size() ? false : true;
	}
}