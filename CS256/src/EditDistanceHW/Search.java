package EditDistanceHW;

/**
 * Supports linear and binary search of an array of int values
 * 
 * @author Choong-Soo Lee
 *
 */
public class Search {
	// instance variables
	private int[] data;
	
	// constructors
	/**
	 * Creates a Search object with a sorted array of int values of capacity length
	 * 
	 * @param length capacity of the array (must be 1 or larger)
	 * 
	 * @throws IllegalArgumentException - length must be 1 or larger
	 */
	public Search(int length) {
		if (length < 1) {
			throw new IllegalArgumentException("Length: " + length);
		}
		
		data = new int[length];
		
		for (int index = 0; index < length; index++) {
			data[index] = index;
		}	
	}
	
	/**
	 * Searches the sorted array for the given target value (linear search)
	 * 
	 * @param target value to search for
	 * @return true if found, false otherwise
	 */
	public boolean linearSearch(int target) {
		for (int value: data) {
			if (value == target) {
				return true;
			}
			if (value > target) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Searches the sorted array for the given target value (binary search)
	 * 
	 * @param target value to search for
	 * @return true if found, false otherwise
	 */
	public boolean binarySearch(int target) {
		return binarySearch(target, 0, data.length - 1);
	}
	
	/**
	 * Recursively search the data array between beginIndex (inclusive) and endIndex (inclusive)
	 * 
	 * @param target value to search for
	 * @param beginIndex the beginning of the range to search (inclusive)
	 * @param endIndex the end of the range to search (inclusive)
	 * @return true if found, false otherwise
	 */
	public boolean binarySearch(int target, int beginIndex, int endIndex) {
		if (beginIndex > endIndex) {
			return false;
		}
		
		int middleIndex = (beginIndex + endIndex) / 2;
		
		return (data[middleIndex] == target ? true :
			data[middleIndex] < target ? binarySearch(target, middleIndex + 1, endIndex) :
				binarySearch(target, beginIndex, middleIndex - 1));
	}

}
