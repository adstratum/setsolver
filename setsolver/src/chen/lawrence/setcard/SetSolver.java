package chen.lawrence.setcard;

import java.util.*;

/**
 * Searches a List of SetCards for valid solutions.
 * 
 * @author Lawrence
 *
 */
public class SetSolver {
	
	List<SetCard> cards;
	HashSet<Set<SetCard>> matches = new HashSet<Set<SetCard>>();
	
	/**
	 * Creates a new SetSolver that will work with
	 * the specified List of SetCards.
	 * 
	 * @param cards
	 */
	public SetSolver(List<SetCard> cards) {
		this.cards = cards;
	}
	
	//TODO javadoc
	//TODO actual logic
	/**
	 * 
	 * @return
	 */
	public void findMatches() {
		for (SetCard card1 : cards) { 
			for(SetCard card2 : cards) {
				for (SetCard card3 : cards) {
					LinkedHashSet<SetCard> tempSet = new LinkedHashSet<SetCard>();
					tempSet.add(card1);
					tempSet.add(card2);
					tempSet.add(card3);
					List<SetCard> tempList = new LinkedList<SetCard>(tempSet);
					if (isSet(tempList) && tempList.size() == 3) {
						matches.add(tempSet);
					}
				}
			}
		}
		for (Set<SetCard> set : matches) {
			System.out.println(set);
		}
	}
	

	/**
	 * Checks if the specified list of cards forms a valid Set.
	 * 
	 * @param cards
	 * @return
	 */
	private boolean isSet(List<SetCard> cards) {
		for (int i = 0; i < 3; i++) {
			if (!(isSame(cards, i) || isDifferent(cards,i))) {
				return false;
			}
		}
		return true;
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
	/**
	 * 
	 * @param cards
	 * @param propIndex
	 * @return
	 */
	private boolean isDifferent(List<SetCard> cards, int propIndex) {
		HashSet<Enum<?>> cardSet = new HashSet<Enum<?>>();
		for(SetCard card : cards) {
			List<Enum<?>> propList = card.getPropertyList();
			cardSet.add(propList.get(propIndex));
		}
		
		if(cardSet.size() == cards.size()) {
			return true;
		}
		return false;
	}

}
