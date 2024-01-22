package MyStringBuilderHW;

public class MyStringBuilderArray extends MyString implements MyStringBuilder {
    /**
     * Create a new MyStringBuilderHW.MyString object using the characters in the given Java String object
     *
     * @param str The Java string object to base the new MyStringBuilderHW.MyString object
     */
    public MyStringBuilderArray(MyString str) {

        super(str.toString());
    }

    /**
     * @return - returns the length of this
     */
    public int length() {
        return this.chars.length;
    }

    /**
     * @param index the index of the desired char value.
     * @return
     */
    public char charAt(int index) {
        return this.chars[index];
    }

    /**
     * @param sb stringbuilder object to append.
     * @return - returns the MyStringBuilderHW.MyStringBuilder object appended with sb
     */
    @Override
    public MyStringBuilder append(MyStringBuilder sb) {
        MyString s1 = new MyString(this.toString());
        MyString s2 = new MyString(sb.toString());

        MyString s = s1.concat(s2);

        return new MyStringBuilderArray(s);
    }

    /**
     * @param str string object to append.
     * @return - returns a MyStringBuilderHW.MyString object to append
     */
    @Override
    public MyStringBuilder append(MyString str) {
        MyStringBuilder str2 = new MyStringBuilderArray(str);
        return this.append(str2);
    }

    /**
     * @param start The beginning index, inclusive.
     * @param end   The ending index, exclusive.
     * @return - deletes substring of characters
     */
    @Override
    public MyStringBuilder delete(int start, int end) {
        if (start == end)
            return this;
        if (start > end || start > this.length() || start < 0)
            throw new IndexOutOfBoundsException("Index out of bounds: " + start);

        char[] del = new char[this.length() - (end - start)];
        for (int i = 0; i < start; i++) {
            del[i] = this.charAt(i);
        }
        // shifts the characters so there are no empty spaces
        for (int j = end; j < this.length(); j++) {
            del[j - (end - start)] = this.charAt(j);
        }
        chars = del;

        return this;
    }

    /**
     * @return - returns the MyStringBuilderHW.MyStringBuilder object printed in reverse
     */
    @Override
    public MyStringBuilder reverse() {
        MyString s1 = new MyString(this.toString());
        MyStringBuilder arr = new MyStringBuilderArray(s1);
        for (int i = 0; i < arr.length() / 2; i++) {
            char temp = arr.charAt(i);
            arr.setCharAt(i, charAt(arr.length() - 1 - i));
            arr.setCharAt(arr.length() - 1 - i, temp);
        }
        return arr;
    }

    /**
     * @param index the index of the character to modify.
     * @param ch    the new character.
     */
    @Override
    public void setCharAt(int index, char ch) {
        if (index < 0 || index >= this.length()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        } else {
            this.chars[index] = ch;
        }
    }

}