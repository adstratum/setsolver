/**
 * 
 */
package chen.lawrence.junit.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import chen.lawrence.setcard.SetCard;
import chen.lawrence.setcard.SetSolver;

/**
 * Tests SetSolver.
 * 
 * @author lawrence
 *
 */
public class SetTest {
	
	private static List<SetCard> deck = new LinkedList<SetCard>(); //contains all valid SetCards
	private static List<SetCard> hand = new LinkedList<SetCard>(); //contains chosen cards
	private static Random RNG = new Random();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// generate a deck of cards
		deck = generateDeck();

		// fill hand with 12 cards
		for (int i = 0; i < 25; i++) {
			int r = RNG.nextInt(deck.size());
			hand.add(deck.get(r));
			deck.remove(r);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test(timeout = 1000)
	public void test() {
		SetSolver solver = new SetSolver(deck);
		solver.findMatches();
	}
	
	/**
	 * Returns a List containing the set of all valid SetCards.
	 * 
	 * @return List<SetCard>, a deck of valid SetCards
	 */
	private static List<SetCard> generateDeck() {
		List<SetCard> deck = new ArrayList<SetCard>();
		
		/*
		 * iterate through all possible values for each parameter; add a new
		 * SetCard for each possibility to the temporary deck
		 */
		for (int col = 0; col < 3; col++) {
			for (int num = 0; num < 3; num++) {
				for (int shad = 0; shad < 3; shad++) {
					for (int shap = 0; shap < 3; shap++) {
						deck.add(new SetCard(col, num, shad, shap));
					}
				}
			}
		}

		return deck;
	}

}
