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
	public enum SetShape {SQUIGGLE, DIAMOND, CAPSULE};
	public enum SetNumber {ONE, TWO, THREE};
	public enum SetShading {OPEN, SHADED, FILLED};
	public enum SetColor {RED, GREEN, PURPLE};
	
	//Instance variables
	private SetShape shape;
	private SetNumber number;
	private SetShading shading;
	private SetColor color;

	/**
	 * Creates a card with randomly-generated properties.
	 * 
	 */
	public SetCard() {
		
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