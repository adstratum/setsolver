package chen.lawrence.setcard;

import java.util.*;

/**
 * Searches a List of SetCards for valid solutions.
 * 
 * @author Lawrence
 *
 */
public class SetSolver {
	
	ArrayList<SetCard> deck;
	
	//TODO actual logic
	public SetSolver(List<SetCard> cards) {
		this.deck = (ArrayList<SetCard>)cards;
	}
	
	/**
	 * 
	 */
	public void findMatches(){
		for (SetCard card1 : deck) {
			for(SetCard card2 : deck) {
				if (card1.same(card2)) {
					
				} else if (card1.different(card2)) {
					
				}
			}
		}
	}

}
