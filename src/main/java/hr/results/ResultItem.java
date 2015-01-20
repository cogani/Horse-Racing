package hr.results;

public class ResultItem {
	private final int position;
	private final int laneNumber;
	private final String horseName;

	public ResultItem(int aPosition, int aLaneNumber, String aHorseName) {
		position = aPosition;
		laneNumber = aLaneNumber;
		horseName = aHorseName;
	}

	public int getPosition() {
		return position;
	}

	public int getLaneNumber() {
		return laneNumber;
	}

	public String getHorseName() {
		return horseName;
	}

	@Override
	public String toString() {
		return position + ", " + laneNumber + ", " + horseName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((horseName == null) ? 0 : horseName.hashCode());
		result = prime * result + laneNumber;
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultItem other = (ResultItem) obj;
		if (horseName == null) {
			if (other.horseName != null)
				return false;
		} else if (!horseName.equals(other.horseName))
			return false;
		if (laneNumber != other.laneNumber)
			return false;
		if (position != other.position)
			return false;
		return true;
	}
	
	

}