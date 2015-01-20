package hr.game;

public class Lane {
	private final int number;
	private final Horse horse;

	public Lane(int aNumber, Horse aHorse) throws LaneException{
		checkLaneNumber(aNumber);
		checkHorse(aHorse);

		number = aNumber;
		horse = aHorse;
	}

	public int getNumber() {
		return number;
	}

	public Horse getHorse() {
		return horse;
	}

	@Override
	public String toString() {
		return "Lane [number=" + number + ", horse=" + horse + "]";
	}

	private void checkLaneNumber(int aNumber) {
		if (aNumber < 1)
			throw new LaneException(aNumber + " not allowed as lane number");
	}
	
	private void checkHorse(Horse aHorse) {
		if (aHorse == null)
			throw new LaneException("Null values for horse is not allowed");
	}
}