package MyStringBuilderHW;

import java.util.ArrayList;
import java.util.List;

public class MyStringBuilderList implements MyStringBuilder {
    /**
     * Create a new MyStringBuilderHW.MyString object using the characters in the given Java String object.
     *
     * @param str The Java String object to base for the new MyStringBuilderHW.MyString object.
     */

    private List<Character> data;
    private int size;

    // constructor

    /**
     * @param str - constructor
     */
    public MyStringBuilderList(MyString str) {
        this.data = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            this.data.add(str.charAt(i));
        }
        size = str.length();
    }

    /**
     * @return - returns a string
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.length(); i++) {
            result += this.charAt(i);
        }
        return result;
    }

    /**
     * @return - returns length of this
     */
    public int length() {
        return this.size;
    }

    /**
     * @param index the index of the desired char value.
     * @return
     */
    public char charAt(int index) {
        return this.data.get(index);
    }

    /**
     * @param sb stringbuilder object to append.
     * @return
     */
    @Override
    public MyStringBuilder append(MyStringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            this.data.add(sb.charAt(i));
            this.size++;
        }
        return this;
    }

    /**
     * @param str string object to append.
     * @return
     */
    @Override
    public MyStringBuilder append(MyString str) {
        for (int i = 0; i < str.length(); i++) {
            data.add(str.charAt(i));
        }
        return this;
    }

    /**
     * @param start The beginning index, inclusive.
     * @param end   The ending index, exclusive.
     * @return - deletes substring
     */
    @Override
    public MyStringBuilder delete(int start, int end) {
        if (start == end)
            return this;
        if (start > end || start > this.length() || start < 0)
            throw new IndexOutOfBoundsException("Index out of bounds: " + start);

        //lists automatically shifts characters deleted, unlike array, so I don't need ot shift them
        for (int i = start; i < end; i++) {
            data.remove(data.get(start));
            this.size--;
        }
        return this;
    }

    /**
     * @return - reverses the MyStringBuilderHW.MyStringBuilder object
     */
    @Override
    public MyStringBuilder reverse() {
        List<Character> s1 = new ArrayList<Character>();
        for (int i = 0; i < this.length(); i++) {
            s1.add(this.charAt(length() - 1 - i));
        }
        data = s1;
        return this;
    }

    /**
     * @param index the index of the character to modify.
     * @param ch    the new character.
     */
    @Override
    public void setCharAt(int index, char ch) {
        if (index < 0 || index >= this.length())
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        else {
            this.data.set(index, ch);
        }

    }
}