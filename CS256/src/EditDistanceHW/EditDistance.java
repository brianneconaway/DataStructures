package EditDistanceHW;

import java.util.Random;

public class EditDistance {
	/**
	 * Computes the edit distance between two strings using recursion and dynamic programming
	 * 
	 * @author Choong-Soo Lee
	 * 
	 */
	private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	// instance variables
	private String firstString, secondString;
	private Random randomizer;
	
	private String randomString(int length) {
		StringBuilder finalString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			finalString.append(ALPHABETS.charAt(randomizer.nextInt(ALPHABETS.length())));
		}
		
		return finalString.toString();
	}
	
	// constructor
	/**
	 * Create an EditDistance object with two given strings
	 * 
	 * @param firstStringLength the length of the first random string for comparison
	 * @param secondStringLength the length of the second random string for comparison
	 */
	public EditDistance(int firstStringLength, int secondStringLength) {
		randomizer = new Random();
		firstString = randomString(firstStringLength);
		secondString = randomString(secondStringLength);
	}
	
	/**
	 * Computes the edit distance recursively
	 * 
	 * @return the edit distance between two strings
	 */
	public int computeRecursion() {
		return computeRecursion(firstString, secondString);
	}

	private int computeRecursion(String stringA, String stringB) {
		if (stringA.length() == 0) {
			return stringB.length();
		}
		if (stringB.length() == 0) {
			return stringA.length();
		}
		
		return Math.min(computeRecursion(stringA.substring(0, stringA.length() - 1), stringB) + 2,
				Math.min(computeRecursion(stringA, stringB.substring(0, stringB.length() - 1)) + 2,
						computeRecursion(stringA.substring(0, stringA.length() - 1),stringB.substring(0, stringB.length() - 1)) + 
						(stringA.charAt(stringA.length() - 1) == stringB.charAt(stringB.length() - 1) ? 0 : 1)));
	}
	
	/**
	 * Computes the edit distance using dynamic programming
	 * 
	 * @return the edit distance between two strings
	 */
	public int computeDynamicProgramming() {
		int[][] distances = new int[firstString.length() + 1][secondString.length() + 1];
		
		for (int index = 0; index <= firstString.length(); index++) {
			distances[index][0] = 2 * index;
		}

		for (int index = 0; index <= secondString.length(); index++) {
			distances[0][index] = 2 * index;
		}

		for (int outerIndex = 1; outerIndex <= firstString.length(); outerIndex++) {
			for (int innerIndex = 1; innerIndex <= secondString.length(); innerIndex++) {
				int firstValue = distances[outerIndex - 1][innerIndex] + 2;
				int secondValue = distances[outerIndex][innerIndex - 1] + 2;
				int thirdValue = distances[outerIndex - 1][innerIndex - 1] + (firstString.charAt(outerIndex - 1) == secondString.charAt(innerIndex - 1) ? 0 : 1);

				distances[outerIndex][innerIndex] = Math.min(firstValue, Math.min(secondValue, thirdValue));
			}
		}
		
		return distances[firstString.length()][secondString.length()];
	}
}
