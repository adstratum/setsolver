/**
 * 
 */
package chen.lawrence.junit.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import chen.lawrence.setcard.SetCard;
import chen.lawrence.setcard.SetCardSolver;

/**
 * Tests SetSolver.
 * 
 * @author lawrence
 *
 */
public class SetSolverTest {
	
	private static List<SetCard> deck = new LinkedList<SetCard>(); //contains all valid SetCards
	private static List<SetCard> hand = new LinkedList<SetCard>(); //contains chosen cards
	private static Random RNG = new Random();
	private static List<List<SetCard>> results;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// generate a deck of cards
		deck = generateDeck();
		
		hand = getRandomCards(12);
	}

	private static List<SetCard> getRandomCards(int cardNum) {
		// fill hand with cardNum cards
		List<SetCard> tempCards = new LinkedList<SetCard>();
		for (int i = 0; i < cardNum; i++) {
			int r = RNG.nextInt(deck.size());
			tempCards.add(deck.get(r));
			deck.remove(r);
		}
		return tempCards;
	}

	/**
	 * Display results in console
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println(results);
	}

	@Test //(timeout = 1000)
	public void test() {
		SetCardSolver solver = new SetCardSolver(hand);
		results = solver.findMatches();
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
