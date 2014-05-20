package chen.lawrence.setcard;

import java.util.*;

/**
 * Searches a List of SetCards for valid solutions.
 * 
 * @author Lawrence
 *
 */
public class SetSolver {
	
	//TODO actual logic
	public SetSolver(List<SetCard> cards) {
		for (SetCard card : cards) {
			for(SetCard card2 : cards) {
				if (card.equals(card2) ) {
					System.out.println(card + " " + card2);
				}
			}
		}
	}

}
