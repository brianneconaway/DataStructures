package BigOh;

public class InitArray2D implements InitArray {
	// instance variables
	private int[][] array;

	// constructor

	/**
	 * Creates the initial 2D (capacity x capacity) int arrays.
	 *
	 * @param capacity capacity of the array (must be 1 or larger)
	 * @throws IllegalArgumentException - invalid argument for parameters above
	 *
	 */
	public InitArray2D(int capacity) {
		this(capacity, capacity);
	}

	/**
     * Creates the initial 2D (width x height) int arrays.
	 *
	 * @param width capacity of the 1D array
	 * @param height number of columns of the 2D array
	 */
	public InitArray2D(int width, int height) {
		if (width < 1 || height < 1) {
			throw new IllegalArgumentException("w x h: " + width + " x " + height);
		}

		array = new int[width][height];
	}

	/**
     * Initializes all the cells in the 2D array to 1.
	 */
	public void initialize() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = 1;
			}
		}
	}


}
