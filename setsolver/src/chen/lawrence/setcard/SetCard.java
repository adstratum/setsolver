package chen.lawrence.setcard;

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
	
	/*
	 * Using an int[] array 
	 */
	private int[] sCardProperties = new int[4];
	
	private static final Random rng = new Random();

	/**
	 * Creates a card with randomly-generated properties.
	 * 
	 */
	public SetCard() {
		for (int i = 0; i < 4; i++) {
			sCardProperties[i] = rng.nextInt(3);
		}
	}

	/**
	 * Creates a SetCard with the specified properties.
	 * 
	 * @param setColor
	 * @param setNumber
	 * @param setShading
	 * @param setShape
	 */
	public SetCard(int setColor, int setNumber, int setShading, int setShape) {
		sCardProperties[0] = setColor;
		sCardProperties[1] = setNumber;
		sCardProperties[2] = setShading;
		sCardProperties[3] = setShape;
	}
	
	/**
	 * Compares this SetCard to another SetCard object.
	 * Returns an array with the difference in each element.
	 * 
	 * @param other - a SetCard card to compare
	 * @return int[] results of the comparison :
	 * 
	 * int[0] = color
	 * int[1] = number
	 * int[2] = shading
	 * int[3] = shape
	 */
	public int[] compareTo(SetCard other) {
		int[] output = new int[4];
		for (int i = 0; i < 4; i++) {
			output[i] = other.sCardProperties[i] - this.sCardProperties[i] ;
		}
		return output;
	}
	
	/**
	 * Returns false if any of the elements provided by compareTo() are
	 * not zero; otherwise, returns true.
	 * 
	 * @param other - a SetCard to compare to
	 * @return result of comparison
	 */
	public boolean same(SetCard other) {
		for (int i : compareTo(other)) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns false if any of the elements provided by compareTo() are
	 * <i>not</i> different; otherwise, returns true.
	 * 
	 * @param other
	 * @return
	 */
	public boolean different(SetCard other) {
		for (int i : compareTo(other)) {
			if (i == 0) {
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings(value = { "", "unused" })
	public boolean isSet(List<SetCard> others) {
		for (int i = 0; i < 4; i++) {
			for (SetCard other : others) {
				//TODO comparison
			}
		}
	}
	
	/**
	 * Compares an element in the given SetCard at the specified index.
	 * 
	 * @param other
	 * @param index
	 * @return int difference at the specified index in sCardProperties
	 */
	public int compareElement(SetCard other, int index) {
		return other.sCardProperties[index] - this.sCardProperties[index];
	}

}