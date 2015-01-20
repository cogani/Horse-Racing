package hr.game;

public class Horse{

	private final String horseName;
	private int runned;

	public Horse(String aHorseName) {
		if (aHorseName.equals(""))
			throw new IllegalArgumentException("Blank horse name not allowed");
		
		horseName = aHorseName;
	}

	public String getName() {
		return horseName;
	}

	public void moveUp(int yards) {
		runned += yards;
	}
	public int getRunned() {
		return runned;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((horseName == null) ? 0 : horseName.hashCode());
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
		Horse other = (Horse) obj;
		if (horseName == null) {
			if (other.horseName != null)
				return false;
		} else if (!horseName.equals(other.horseName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Horse [horseName=" + horseName + ", runned=" + runned + "]";
	}
}