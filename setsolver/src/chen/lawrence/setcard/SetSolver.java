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
		for (SetCard card1 : cards) {
			for(SetCard card2 : cards) {
				System.out.println(card1.compareTo(card2));
			}
		}
	}

}
