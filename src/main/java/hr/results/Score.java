package hr.results;

import hr.game.Lane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Score {
	public List<ResultItem> resultItems;

	public Score(List<Lane> lanes) {
		resultItems = new ArrayList<ResultItem>();
		ArrayList<Lane> sortedLanes = new ArrayList<Lane>();
		sortedLanes.addAll(lanes);
		Collections.sort(sortedLanes, new ResultItemComparator());
		int position = 0;
		
		for(Lane lane: sortedLanes){
			resultItems.add(new ResultItem(++position, lane.getNumber(),lane.getHorse().getName()));
		}
		
	}
	
	class ResultItemComparator implements Comparator<Lane> {

		public int compare(Lane lane1, Lane lane2) {
			int runnedYardsForHorseInLane1 = lane1.getHorse().getRunned();
			int runnedYardsForHorseInLane2 = lane2.getHorse().getRunned();
			
			return runnedYardsForHorseInLane2 - runnedYardsForHorseInLane1;
		}
	   
	}



	public final List<ResultItem> getResultItems() {
		return resultItems;
	}
	
}
