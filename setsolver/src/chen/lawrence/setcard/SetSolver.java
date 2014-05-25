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

		for (SetCard card1 : cards) {
			for(SetCard card2 : cards) {
				isSame(Arrays.asList(card1, card2), 0);
			}
		}
	}
	
	/**
	 * Checks if all SetCards in a list of SetCards have the
	 * same value for a single property in each SetCard's
	 * PropertyList.
	 * 
	 * Returns false if any of the cards differ for that property;
	 * otherwise, returns true.
	 * 
	 * @param cards - a list of SetCards to compare
	 * @param propIndex - index of the property to compare
	 * @return true if all cards have the same value for that property;
	 * false if the cards differ for that property
	 */
	private boolean isSame(List<SetCard> cards, int propIndex) {
		for (SetCard card : cards) {
			List<Enum<?>> propList0 = cards.get(0).getPropertyList(); //compare all subsequent cards to the first card
			List<Enum<?>> propList1 = card.getPropertyList();
			
			if (propList0.get(propIndex) != propList1.get(propIndex)) {
				return false;
			}
		}
		return true;
	}
	
	//TODO javadoc
	//TODO different comparison method
	private boolean isDifferent(List<SetCard> cards, int propIndex) {
		HashSet<Enum<?>> cardSet = new HashSet<Enum<?>>();
		for(SetCard card : cards) {
		}
		return false;
	}

}
