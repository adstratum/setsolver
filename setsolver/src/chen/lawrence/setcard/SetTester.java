package chen.lawrence.setcard;

import java.util.*;

/**
 * Tests functionality of SetCard and SetSolver.
 * 
 * @author Lawrence
 *
 */
public class SetTester {

	public static void main(String[] args) {
		
		final Random RNG = new Random();
		
		List<SetCard> deck = new LinkedList<SetCard>(); //contains all valid SetCards
		List<SetCard> hand = new LinkedList<SetCard>(); //contains chosen cards
		
		//generate a deck of cards
		deck = SetTester.generateDeck();
		
		//fill hand with 12 cards
		for (int i = 0; i < 12; i++){
			int r = RNG.nextInt(deck.size());
			hand.add(deck.get(r));
			deck.remove(r);
		}
		
		//create a new SetSolver with the chosen cards
		SetSolver solver = new SetSolver(hand);
		
	}
	
	
	/**
	 * Returns a List containing the set of all valid SetCards.
	 * 
	 * @return
	 */
	private static List<SetCard> generateDeck() {
		List<SetCard> deck = new LinkedList<SetCard>();
		
		//iterate through all possible values and add a new SetCard for each possibility
		for (SetCard.SetColor col : SetCard.SetColor.values()) {
			for (SetCard.SetNumber num : SetCard.SetNumber.values()) {
				for (SetCard.SetShading shd : SetCard.SetShading.values()) {
					for (SetCard.SetShape shp : SetCard.SetShape.values()) {
						deck.add(new SetCard(col, num, shd, shp));
					}
				}
			}
		}
		
		return deck;
	}
}
