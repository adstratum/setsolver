package chen.lawrence.setcard;

import java.util.Random;

/**
 * Representation of a card used in the card game Set.
 * 
 * @author Lawrence
 *
 */


public class SetCard {
	//TODO comparison function with other cards
	
	//Defining properties of actual Set cards
	public enum SetColor {RED, GREEN, PURPLE};
	public enum SetNumber {ONE, TWO, THREE};
	public enum SetShading {OPEN, SHADED, FILLED};
	public enum SetShape {SQUIGGLE, DIAMOND, CAPSULE};

	//Instance variables
	private SetColor color;
	private SetNumber number;
	private SetShading shading;
	private SetShape shape;
	
	//Random properties
	private static final RandomEnum<SetColor> RandomColor = new RandomEnum<SetColor>(SetColor.class);
	private static final RandomEnum<SetNumber> RandomNumber = new RandomEnum<SetNumber>(SetNumber.class);
	private static final RandomEnum<SetShading> RandomShading = new RandomEnum<SetShading>(SetShading.class);
	private static final RandomEnum<SetShape> RandomShape = new RandomEnum<SetShape>(SetShape.class);

	/**
	 * Creates a card with randomly-generated properties.
	 * 
	 */
	public SetCard() {
		color = RandomColor.getRandom();
		number = RandomNumber.getRandom();
		shading = RandomShading.getRandom();
		shape = RandomShape.getRandom();
	}

	/**
	 * Creates a SetCard with the provided parameters.
	 * 
	 * @param color
	 * @param number
	 * @param shading
	 * @param shape
	 */
	public SetCard(SetColor color, SetNumber number, SetShading shading, SetShape shape) {
		this.setColor(color);
		this.setNumber(number);
		this.setShading(shading);
		this.setShape(shape);
	}
	
	/**
	 * Picks a random value from an enum.
	 * Used to provide random properties for SetCard().
	 * 
	 * @author Lawrence
	 *
	 * @param <E> an enumerated type
	 */
	private static class RandomEnum<E extends Enum<?>> {
		private static final Random RNG = new Random();
		private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E getRandom() {
            return values[RNG.nextInt(values.length)];
        }
	}
	
	public String toString() {
		return number.toString() + " " + color.toString() + " " + shape.toString() + " " + shading.toString();
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