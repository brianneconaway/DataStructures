package MyStringBuilderHW;

import java.util.Arrays;

/**
 * CS-256 Way to Review Java
 * Trying to create an immutable Java String like objects
 *
 * @author CS-256 Section 1
 */
public class MyString {
    // instance variables
    protected char[] chars;

    // constructors

    /**
     * Create a new MyStringBuilderHW.MyString object using the characters in the given Java String object.
     *
     * @param str The Java String object to base for the new MyStringBuilderHW.MyString object.
     */
    public MyString(String str) {
        // create an array of the capacity based on the given string
        chars = new char[str.length()];
        // copy each character into the corresponding indices in the array
        for (int index = 0; index < str.length(); index++) {
            chars[index] = str.charAt(index);
        }
    }

    private MyString(char[] chars) {
        this.chars = chars;
    }

    // instance methods
    @Override
    public String toString() {
        String result = "";
        for (int index = 0; index < this.length(); index++) {
            result += this.charAt(index);
        }
        return result;
    }

    /**
     * Computes the number of characters in this MyStringBuilderHW.MyString object.
     *
     * @return The length of the string (# of characters in this MyStringBuilderHW.MyString object).
     */
    public int length() {
        return chars.length;
    }

    private boolean indexValid(int index) {
        if (index < 0 || index >= chars.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return true;
    }

    /**
     * Computes the character at the given index in this MyStringBuilderHW.MyString object.
     *
     * @param index the index at which to compute the character
     * @return the character at the given index
     * @throws IndexOutOfBoundsException index must be 0 to length - 1.
     */
    public char charAt(int index) {
        if (indexValid(index)) {
            return chars[index];
        }
        return ' '; // should never happen
    }

    /**
     * Computes a new MyStringBuilderHW.MyString object as a result of concatenating this MyStringBuilderHW.MyString object and the given MyStringBuilderHW.MyString object.
     *
     * @param str the MyStringBuilderHW.MyString object to concatenate to this MyStringBuilderHW.MyString object.
     * @return A new MyStringBuilderHW.MyString object that results from concatenating this MyStringBuilderHW.MyString object and the given MyStringBuilderHW.MyString object.
     */
    public MyString concat(MyString str) {
        // create a char array of an appropriate capacity based on
        // the lengths of this MyStringBuilderHW.MyString object and the parameter str
        char[] conchars = new char[this.length() + str.length()];

        // copy the characters from this MyStringBuilderHW.MyString object first
        int currentIndex = 0;

        for (int index = 0; index < this.length(); index++) {
            conchars[currentIndex] = this.charAt(index);
            currentIndex++;
        }

        // copy the characters from str object
        for (int index = 0; index < str.length(); index++) {
            conchars[currentIndex] = str.charAt(index);
            currentIndex++;
        }

        return new MyString(conchars);
    }


    /**
     * Computes the equality between this MyStringBuilderHW.MyString object and the given MyStringBuilderHW.MyString object.
     *
     * @param str the MyStringBuilderHW.MyString object to compare this MyStringBuilderHW.MyString object against
     * @return true if they are equal. false otherwise.
     */
    public boolean equals(MyString str) {
        return this.length() == str.length() && this.contains(str);
    }

    /**
     * Computes the index of the first occurrence of the given char value.
     *
     * @param ch the char value to find in this MyStringBuilderHW.MyString object.
     * @return the index of the first occurrence of the given char value. -1 if not found.
     */
    public int indexOf(char ch) {
        return this.indexOf(ch, 0);
    }

    /**
     * Computes the index of the first occurrence of the given char value at or beyond the given index.
     *
     * @param ch the char value to find in this MyStringBuilderHW.MyString object.
     * @param fromIndex the index at which to start the search.
     * @return the index of the first occurrence of the given char value. -1 if not found.
     * @throws IndexOutOfBoundsException fromIndex must be between 0 (inclusive) and length (exclusive).
     */
    public int indexOf(char ch, int fromIndex) {
        // create a MyStringBuilderHW.MyString object with the given char value
        char[] givenCh = {ch};
        MyString chString = new MyString(givenCh);

        // rely on the indexOf that takes a MyStringBuilderHW.MyString object
        return this.indexOf(chString, fromIndex);
    }

    /**
     * Computes if the given MyStringBuilderHW.MyString object appears in this MyStringBuilderHW.MyString object.
     *
     * @param str the MyStringBuilderHW.MyString object to look for.
     * @return true if the given MyStringBuilderHW.MyString object appears in this MyStringBuilderHW.MyString object. false otherwise.
     */
    public boolean contains(MyString str) {
        return this.indexOf(str) >= 0;
    }

    /**
     * Computes the index of the first occurrence of the given MyStringBuilderHW.MyString object.
     *
     * @param str the MyStringBuilderHW.MyString object to find in this MyStringBuilderHW.MyString object.
     * @return the index of the first occurrence of the given MyStringBuilderHW.MyString object. -1 if not found.
     */
    public int indexOf(MyString str) {
        return this.indexOf(str, 0);
    }

    /**
     * Computes the index of the first occurrence of the given MyStringBuilderHW.MyString object at or beyond the given index.
     *
     * @param str the MyStringBuilderHW.MyString object to find in this MyStringBuilderHW.MyString object.
     * @param fromIndex the index at which to start the search.
     * @return the index of the first occurrence of the given MyStringBuilderHW.MyString object. -1 if not found.
     * @throws IndexOutOfBoundsException fromIndex must be between 0 (inclusive) and length (exclusive).
     */
    public int indexOf(MyString str, int fromIndex) {
        // check if the index is valid
        boolean check = indexValid(fromIndex);

        // if the pattern is longer than this MyStringBuilderHW.MyString object, it cannot be found
        if (str.length() > this.length()) {
            return -1;
        }
        // start search from the first character of this MyStringBuilderHW.MyString object
        for (int index = fromIndex; index <= this.length() - str.length(); index++){
            // check if the sequence of characters from index matches the pattern
            boolean match = true;
            for (int patternIndex = 0; patternIndex < str.length(); patternIndex++) {
                if (this.charAt(index + patternIndex) != str.charAt(patternIndex)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return index;
            }
        }
        // not found
        return -1;
    }

    /**
     * Computes the substring of this MyStringBuilderHW.MyString object starting at beginIndex (inclusive) and ending at endIndex (exclusive).
     *
     * @param beginIndex the index to the first char of the text range.
     * @param endIndex the index after the last char of the text range.
     * @return a new MyStringBuilderHW.MyString object that contains characters between beginIndex (inclusive) and endIndex (exclusive).
     * @throws IndexOutOfBoundsException Indices must be between 0 and length, both inclusive. endIndex must be greater than or equal to beginIndex.
     */
    public MyString substring(int beginIndex, int endIndex) {
        // check for valid indices
        if ((beginIndex == this.length() ||  indexValid(beginIndex)) && (endIndex == this.length() || indexValid(endIndex)) && endIndex >= beginIndex) {
            return new MyString(Arrays.copyOfRange(this.chars, beginIndex, endIndex));
        } else {
            throw new IndexOutOfBoundsException("Indices must be between 0 and length, both inclusive. endIndex must be greater than or equal to beginIndex.");
        }
    }

    /**
     * Computes the substring of this MyStringBuilderHW.MyString object starting at beginIndex (inclusive) until the end.
     *
     * @param beginIndex the index to the first char of the text range.
     * @return a new MyStringBuilderHW.MyString object that contains characters starting from beginIndex (inclusive).
     * @throws IndexOutOfBoundsException Indices must be between 0 and length, both inclusive.
     */
    public MyString substring(int beginIndex) {
        return this.substring(beginIndex, this.length());
    }
}














