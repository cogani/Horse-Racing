import hr.game.Circuit;
import hr.game.Race;
import hr.game.RaceException;
import hr.game.Toss;
import hr.results.ResultItem;
import hr.results.Score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameCase {
	private Race race;
	private List<Toss> tosses;

	public static void main(String[] args) {

		GameCase gameCase = new GameCase(args);
		gameCase.run();

		gameCase.showScores();
	}

	public GameCase(String[] args) {
		initRace(args);
		initTosses();
	}

	public void run() {
		for (Toss toss : tosses) {
			showMessage("Throwing toss: " + toss.toString());
			try {
				race.play(toss);
			} catch (RaceException raceException) {
				showMessage(raceException + " -> " + toss.toString());
			}
		}
	}

	private void showScores() {
		
		System.out.println(race.getCircuit().getLanes());
		
		showMessage("RESULTS:");
		Score score = new Score(race.getCircuit().getLanes());
		List<ResultItem> resultItems = score.getResultItems();
		showMessage("Position, Lane, Horse name");
		for (ResultItem resultItem : resultItems) {
			showMessage(resultItem.toString());
		}
	}

	private void initRace(String[] args) {
		ArrayList<String> horses = new ArrayList<String>();
		horses.addAll(Arrays.asList(args));
		Circuit circuit = new Circuit(horses);

		race = new Race(circuit);
	}

	private void initTosses() {
		tosses = new ArrayList<Toss>();
		tosses.add(new Toss(1, 60));
		tosses.add(new Toss(3, 5));
		tosses.add(new Toss(1, 60));
		tosses.add(new Toss(4, 5));
		tosses.add(new Toss(4, 10));
		tosses.add(new Toss(2, 5));
		tosses.add(new Toss(5, 10));
		tosses.add(new Toss(1, 60));
		tosses.add(new Toss(3, 20));
		tosses.add(new Toss(7, 10));
		tosses.add(new Toss(1, 40));
		tosses.add(new Toss(2, 60));
	}

	private void showMessage(String message) {
		System.out.println(message);
	}
}
