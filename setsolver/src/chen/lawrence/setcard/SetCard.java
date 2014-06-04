package chen.lawrence.setcard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
	
	//Holds instance variables
	private List<Enum<?>> propertyList = new LinkedList<Enum<?>>();
	
	//Random property generators
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
		propertyList.addAll(Arrays.asList(color, number, shading, shape));
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
		propertyList.addAll(Arrays.asList(color, number, shading, shape));
	}
	
	/**
	 * Compares this SetCard to another SetCard object.
	 * Returns a List with the difference in ordinal between
	 * each of the SetCard enumerated properties.
	 * 
	 * @param other the card to compare
	 * @return List<Integer> difference in enum ordinal
	 */
	public List<Integer> compareTo(SetCard other) {
		List<Integer> res = new LinkedList<Integer>();
		res.add(this.color.ordinal() - other.color.ordinal());
		res.add(this.number.ordinal() - other.color.ordinal());
		res.add(this.shading.ordinal() - other.shading.ordinal());
		res.add(this.shape.ordinal() - other.shape.ordinal());
		return res;
	}
	
	/**
	 * Picks a random value from an enumerated type.
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
	 * @return the propertyList
	 */
	public List<Enum<?>> getPropertyList() {
		return propertyList;
	}

	/**
	 * @param propertyList the propertyList to set
	 */
	public void setPropertyList(List<Enum<?>> propertyList) {
		this.propertyList = propertyList;
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