package MyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    // instance variables
    private int size;
    private T[] data;

    // constructor
    public MyArrayList() {
        // size = 0;
        // data = (T[])new Object[2];
        this(2);
    }

    public MyArrayList(int initialCapacity) {
        size = 0;
        data = (T[])new Object[initialCapacity];
    }

    // methods
    @Override
    public String toString() {
        StringBuilder listStr = new StringBuilder();
        listStr.append("[");

        for (int index = 0; index < this.size(); index++) {
            listStr.append(this.get(index).toString());
            if (index < this.size() - 1) {
                listStr.append(", ");
            }
        }

        listStr.append("]");
        return listStr.toString();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    private boolean validIndex(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Invalid index  " + index + " used on the size " + this.size());
        }
        return true;
    }

    @Override
    public boolean add(T element) {
        // adding at the end is equivalent to
        // adding at the current size as the index
        this.add(this.size(), element);
        return true;
    }

    private void doubleArrayCapacity() {
        // create a larger array of double the current capacity
        T[] largerArray = (T[])new Object[this.data.length * 2];

        // copy every element from the current data array
        // to the new, larger array
        for (int index = 0; index < this.size(); index++) {
            largerArray[index] = this.get(index);
        }

        // assign the new, larger array as our data array
        this.data = largerArray;
    }

    @Override
    public void add(int targetIndex, T element) {
        // You MUST check the validity of the given index
        // check for the valid index
        if (targetIndex == this.size() || validIndex(targetIndex)) {

            // if the array is full, we need to create
            // a larger array
            if (this.size() == this.data.length) {
                doubleArrayCapacity();
            }

            // shift all the elements at the target index and behind
            // by one position to the right
            for (int index = this.size() - 1; index >= targetIndex; index--) {
                this.data[index + 1] = this.data[index];
            }
            // place the new element at the target index
            this.data[targetIndex] = element;

            // increment the size
            this.size++;
        }
    }

    @Override
    public T get(int index) {
        // You MUST check the validity of the given index
        if (validIndex(index)) {
            return this.data[index];
        }
        // this should never happen
        return null;
    }


    @Override
    public boolean remove(Object obj) {
        int index = this.indexOf(obj);

        if (index >= 0) {
            this.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public T set(int index, T element) {
        if (validIndex(index)) {
            T replaced = this.get(index);
            this.data[index] = element;
            return replaced;
        }
        return null;
    }

    @Override
    public T remove(int targetIndex) {
        if (validIndex(targetIndex)) {
            T removed = this.get(targetIndex);
            for (int index = targetIndex + 1; index < this.size(); index++) {
                this.data[index - 1] = this.data[index];
            }
            this.size--;
            return removed;
        }
        return null;
    }

    @Override
    public int indexOf(Object obj) {
        for (int index = 0; index < this.size(); index++) {
            if (obj == null ? this.get(index) == null : obj.equals(this.get(index))) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
