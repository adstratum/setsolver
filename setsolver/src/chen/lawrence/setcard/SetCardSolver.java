package chen.lawrence.setcard;

import java.util.*;

/**
 * Searches a given List of SetCards for valid solutions.
 * 
 * @author Lawrence
 *
 */
public class SetCardSolver {
	
	List<SetCard> cards;
	List<List<SetCard>> matches = new LinkedList<List<SetCard>>();
	
	/**
	 * Creates a new SetSolver that will work on
	 * the specified List of SetCards.
	 * 
	 * @param cards
	 */
	public SetCardSolver(List<SetCard> cards) {
		this.cards = cards;
	}
	
	/**
	 * Brute-force solving for possible Sets.
	 * 
	 * @return a List of Lists of SetCards that are considered
	 * Sets; null if the number of cards is less than 3 (minimum for
	 * a valid Set)
	 */
	public List<List<SetCard>> findMatches() {
		
		//don't even bother if there aren't enough cards
		if (cards.size() < 3) {
			return null;
		}
		
		/*
		 * iterate through all of the cards, getting all possible permutations
		 * of SetCards...
		 */
		for (int i = 0; i < cards.size(); i++) {
			SetCard card1 = cards.get(i);
			for (int j = 1; j < cards.size(); j++) {
				SetCard card2 = cards.get(j);
				for (int k = 2; k < cards.size(); k++) {
					SetCard card3 = cards.get(k);
					
					//...and adding them to a temporary HashSet.
					LinkedHashSet<SetCard> tempCardSet = new LinkedHashSet<SetCard>();
					tempCardSet.add(card1);
					tempCardSet.add(card2);
					tempCardSet.add(card3);
					
					//check that there aren't any duplicates
					if (tempCardSet.size() == 3) {
						
						//convert back to List if check passes
						List<SetCard> tempList = new LinkedList<SetCard>(tempCardSet);
						
						/*
						 * if the cards are a set, add them to results 
						 * and remove them from the master list of cards, 
						 * so that they're not used again
						 */
						if (isSet(tempList)) {
							matches.add(tempList);
							cards.removeAll(tempList);
						}
					}
				}
			}
		}
		return matches;
	}
	
	

	/**
	 * Checks if the specified List of cards forms a valid Set.
	 * 
	 * @param cards
	 * @return
	 */
	private boolean isSet(List<SetCard> cards) {
		for (int i = 0; i < 4; i++) {
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
			
			if (!propList0.get(propIndex).equals(propList1.get(propIndex))) {
				return false;
			}
		}
		return true;
	}
	
	//TODO javadoc
	/**
	 * Checks if all SetCards in a list of SetCards have 
	 * unique values for a single property in each SetCard's
	 * PropertyList.
	 * 
	 * Returns false if the number of cards with unique values is less
	 * than the total number of cards input; otherwise, returns true.
	 * 
	 * @param cards - a list of SetCards to compare
	 * @param propIndex - index of the property to compare
	 * @return true if all cards have unique values for that property;
	 * false if any of the cards are the same for that property
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

	/**
	 * @return the cards
	 */
	public List<SetCard> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<SetCard> cards) {
		this.cards = cards;
	}

}
