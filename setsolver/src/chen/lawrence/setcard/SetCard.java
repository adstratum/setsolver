package chen.lawrence.setcard;

import java.util.Random;

/**
 * Representation of a card used in the card game Set.
 * 
 * @author Lawrence
 *
 */


public class SetCard {
	
	//Defining properties of actual Set cards
	public enum SetShape {SQUIGGLE, DIAMOND, CAPSULE};
	public enum SetNumber {ONE, TWO, THREE};
	public enum SetShading {OPEN, SHADED, FILLED};
	public enum SetColor {RED, GREEN, PURPLE};
	
	//Instance variables
	private SetShape shape;
	private SetNumber number;
	private SetShading shading;
	private SetColor color;
	
	private static final RandomEnum<SetShape> RandomShape = new RandomEnum<SetShape>(SetShape.class);
	private static final RandomEnum<SetNumber> RandomNumber = new RandomEnum<SetNumber>(SetNumber.class);
	private static final RandomEnum<SetShading> RandomShading = new RandomEnum<SetShading>(SetShading.class);
	private static final RandomEnum<SetColor> RandomColor = new RandomEnum<SetColor>(SetColor.class);

	/**
	 * Creates a card with randomly-generated properties.
	 * 
	 */
	public SetCard() {
		shape = RandomShape.getRandom();
		number = RandomNumber.getRandom();
		shading = RandomShading.getRandom();
		color = RandomColor.getRandom();
	}
	
	/**
	 * Creates a card with the specified parameters.
	 * 
	 * @param shape
	 * @param number
	 * @param shade
	 * @param color
	 */
	public SetCard(SetShape shape, SetNumber number, SetShading shading, SetColor color){
		this.setShape(shape);
		this.setNumber(number);
		this.setShading(shading);
		this.setColor(color);
	}
	
	/**
	 * Picks a random value from an enum.
	 * Used to randomize for SetCard().
	 * 
	 * @author Lawrence
	 *
	 * @param <E> an enumberated type
	 */
	private static class RandomEnum<E extends Enum> {
		private static final Random RNG = new Random();
		private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E getRandom() {
            return values[RNG.nextInt(values.length)];
        }
	}

	/**
	 * @return the shape
	 */
	public SetShape getShape() {
		return shape;
	}

	/**
	 * @param shape the shape to set
	 */
	public void setShape(SetShape shape) {
		this.shape = shape;
	}

	/**
	 * @return the number
	 */
	public SetNumber getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(SetNumber number) {
		this.number = number;
	}

	/**
	 * @return the shading
	 */
	public SetShading getShading() {
		return shading;
	}

	/**
	 * @param shading the shading to set
	 */
	public void setShading(SetShading shading) {
		this.shading = shading;
	}

	/**
	 * @return the color
	 */
	public SetColor getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(SetColor color) {
		this.color = color;
	}

}