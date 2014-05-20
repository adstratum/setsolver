/**
 * 
 */
package chen.lawrence.setcard;

/**
 * Representation of a card used in the card game Set.
 * 
 * @author Lawrence
 *
 */


public class SetCard {
	
	//Defining properties of actual Set cards
	public enum Shape {SQUIGGLE, DIAMOND, CAPSULE};
	public enum Number {ONE, TWO, THREE};
	public enum Shading {OPEN, SHADED, FILLED};
	public enum Color {RED, GREEN, PURPLE};

	/**
	 * Creates a card with randomly-generated properties.
	 * 
	 */
	public SetCard() {
		// TODO Auto-generated constructor stub
		Math.random()
	}

}