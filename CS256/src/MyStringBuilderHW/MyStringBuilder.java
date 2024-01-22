package MyStringBuilderHW;

public interface MyStringBuilder {
	/**
	 * Returns the length (character count).
	 * 
	 * @return the length of the sequence of characters currently represented by this object.
	 */
	public int length();
	
	/**
	 * Returns the char value in this sequence at the specified index.
	 * 
	 * @param index the index of the desired char value.
	 * @return the char value at the specified index.
	 * @throws IndexOutOfBoundsException if index is negative or greater than or equal to length().
	 */
	public char charAt(int index);

	/**
	 * Appends the specified stringbuilder to this stringbuilder.
	 * 
	 * @param sb stringbuilder object to append.
	 * @return a reference to this object.
	 */
	public MyStringBuilder append(MyStringBuilder sb);

	/**
	 * Appends the specified string to this stringbuilder.
	 * 
	 * @param str string object to append.
	 * @return a reference to this object.
	 */
	public MyStringBuilder append(MyString str);

	/**
	 * Removes the characters in a substring of this sequence.
	 * The substring begins at the specified start and extends to the character
	 * at index end - 1 or to the end of the sequence if no such character exists.
	 * If start is equal to end, no changes are made.
	 * 
	 * @param start The beginning index, inclusive.
	 * @param end The ending index, exclusive.
	 * @return this object
	 * @throws IndexOutOfBoundsException if start is negative, greater than length(), or greater than end.
	 */
	public MyStringBuilder delete(int start, int end);

	/**
	 * Causes this character sequence to be replaced by the reverse of the sequence.
	 * 
	 * @return a reference to this object.
	 */
	public MyStringBuilder reverse();

	/**
	 * The character at the specified index is set to the specified character.
	 *
	 * @param index the index of the character to modify.
	 * @param ch the new character.
	 * @throws IndexOutOfBoundsException if index is negative or greater than or equal to length().
	 */
	public void setCharAt(int index, char ch);

}