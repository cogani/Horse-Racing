package hr.game;

public class Toss {
	private final int laneNumber;
	private final int yardsToMove;

	public Toss(int aLaneNumber, int aYardsToMove) {
		laneNumber = aLaneNumber;
		yardsToMove = aYardsToMove;
	}

	public int getLaneNumber() {
		return laneNumber;
	}

	public int getYardsToMove() {
		return yardsToMove;
	}

	@Override
	public String toString() {
		return "laneNumber=" + laneNumber + ", yardsToMove=" + yardsToMove;
	}
}