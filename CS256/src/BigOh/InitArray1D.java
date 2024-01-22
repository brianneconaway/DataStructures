package BigOh;

import java.util.Arrays;

public class InitArray1D implements InitArray {
	// instance variables
	private int[] array;
	// constructor

	/**
	 * Creates the initial 1D (capacity) int arrays.
	 *
	 * @param capacity capacity of the array (must be 1 or larger)
	 * @throws IllegalArgumentException - invalid argument for parameters above
	 * 
	 */
	public InitArray1D(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("capacity: " + capacity);
		}

		array = new int[capacity];
	}

	/**
	 * Initializes all the cells in the 1D array to 1.
	 */
	public void initialize() {
		/*
		for (int index = 0; index < array.length; index++) {
			array[index] = 1;
		}

		 */
		Arrays.fill(array, 1);
	}
}
