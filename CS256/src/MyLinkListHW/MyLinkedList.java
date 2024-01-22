package MyLinkListHW;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * Our implementation of Linked List
 *
 * @author CS-256 Section 1 Fall 2023
 */
public class MyLinkedList<T> implements List<T> {
    // instance variables
// head of the list
    private Node<T> head;
    // size of the list
    private int size;

    private Node<T> middle;
    /**
     * Node class definition
     * We use a Node object for each element in our list.
     *
     * @param <E>
     */
    private static class Node<E> {
        // instance variables
        private E data;
        private Node<E> next;
        // constructors
        public Node(E someData, Node<E> someNextNode) {
            this.data = someData;
            this.next = someNextNode;
        }
        public Node(E someData) {

            this(someData, null);
        }
    }
    // constructor
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
        this.middle = getNode(this.size/2);
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    /**
     * A helper method that returns the appropriate Node object
     * that corresponds to the given index.
     *
     * @param index the index at which the node of interest is
     * @return the Node object at the given index
     */
    private Node<T> getNode(int index) {
// start at the head node
        Node<T> currentNode = head;
// keep jumping to the next node
// until we reach the node of interest
        for (int count = 0; count < index; count++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    @Override
    public T get(int index) {
        return this.getNode(index).data;
    }


    public String toString() {
        StringBuilder listStr = new StringBuilder();
        listStr.append("[");
        Node<T> currentNode = this.head;
// keep jumping to the next node
// until we reach the node of interest
        for (int count = 0; count < this.size(); count++) {
            listStr.append(currentNode.data);
            if (count < this.size() - 1) {
                listStr.append(", ");
            }
            if (count != size-1)
                currentNode = currentNode.next;

        } // O(n) time complexity


/* time complexity is O(n^2)
for (int index = 0; index < this.size(); index++) {
listStr.append(this.get(index).toString());
if (index < this.size() - 1) {
listStr.append(", ");
}
}
*/
        listStr.append("]");
        return listStr.toString();
    }

    /**
     *
     * @param element element whose presence in this collection is to be ensured
     * @return
     */

    @Override
    public boolean add(T element) {
// adding at the end is equivalent to
// adding at the current size as the index
        this.add(this.size(), element);
        return true;
    }

    /**
     *
     * @param targetIndex index at which the specified element is to be inserted
     * @param element element to be inserted
     *    I wasn't sure where the newNode would go in an odd list, so I did before
     *                so that it replaces where the old middle was before.
     *        Then I alternate where the middle node is every other middle add
     */
    @Override
    public void add(int targetIndex, T element) {
        //assigning middle to middle index
        //if odd
        if (this.size % 2 == 1 && (targetIndex == this.size/2) && this.size >= 2) {
            Node<T> newNode = new Node<>(element, middle.next);
            middle.next = newNode;
        }
        //if even
        else if(this.size % 2 == 0 && targetIndex == this.size/2 && this.size >= 2){
            Node<T> newNode = new Node<>(element, middle.next);
            middle.next = newNode;
            middle = newNode;
        }
        else if (targetIndex == 0) {
            // adding to the front
            Node<T> newNode = new Node<T>(element, this.head);
            // update the current head to the new node
            this.head = newNode;
            if (size == 0)
                middle = newNode;
        }
        //Adding anywhere else
        else {
            Node<T> prevNode = getNode(targetIndex - 1);
            Node<T> newNode = new Node<T>(element, prevNode.next);
            prevNode.next = newNode;
        }
        // increment the size
        this.size++;
    }




    @Override
    public boolean remove(Object o) {
        return false;
    }
    public T remove(int index) {
        return null;
    }


    @Override
    public boolean contains(Object o) {
        return false;
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
    @Override
    public void clear() {
    }
    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
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
}