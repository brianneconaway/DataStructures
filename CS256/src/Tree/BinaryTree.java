package Tree;

import java.util.List;

/**
 * An implementation of Binary Tree
 * @author Brianne
 */
public class BinaryTree<T extends Comparable<T>> {
    //Instance variables
    protected Node<T> root;

    protected static class Node<E> {
        //Instance variables
        protected E data;
        protected Node<E> left, right;

        //Constructor
        public Node(E someData, Node<E> someLeft, Node<E> someRight) {
            this.data = someData;
            this.left = someLeft;
            this.right = someRight;
        }

        public Node(E someData) {
            this(someData, null, null);
        }
    }

    //Constructors
    //Constructs an empty binary tree
    public BinaryTree() {
        this.root = null;
    }

    //Constructs a binary tree with data for root node and 2 subtrees left & right
    public BinaryTree(T rootData, BinaryTree<T> leftSubtree, BinaryTree<T> rightSubtree) {
        this.root = new Node<T>(rootData, leftSubtree.root, rightSubtree.root);
    }

    private BinaryTree(Node<T> someRoot) {
        this.root = someRoot;
    }

    // instance methods

    //return data at root node
    //return null if tree is empty
    public T getRoot() {
        if (this.root == null)
            return null;

        return this.root.data;
    }

    //same two methods just one is simpler
    public BinaryTree<T> getLeftSubtree() {
        if (this.isEmpty())
            return null;
        BinaryTree<T> leftSubtree = new BinaryTree<T>();
        leftSubtree.root = this.root.left;
        return leftSubtree;
    }

    public BinaryTree<T> getRightSubtree() {
        if (this.isEmpty())
            return null;
        return new BinaryTree<T>(this.root.right);
    }

    //if tree is empty return true
    public boolean isEmpty() {
        return this.root == null;
    }
/*
    public int height(){
       return this.height(this.root);
    }

    //will return height of any node on tree
    private int height(Node<T> localRoot){
        //base case
        if (localRoot == null) {
            return 0;
        }

        //gen case
        int leftHeight = this.getLeftSubtree().height();
        int rightHeight = this.getRightSubtree().height();

        return 1 + Math.max(leftHeight, rightHeight);
    }
*/

    public int height(Node<T> localRoot, int currentHeight) {
        //base case
        if (localRoot == null)
            return currentHeight;

        //gen
        int leftHeight = this.height(localRoot.left, currentHeight + 1);
        int rightHeight = this.height(localRoot.right, currentHeight + 1);

        return Math.max(leftHeight, rightHeight);
    }

    public int height() {
        return this.height(0);
    }

    private int height(int currentHeight) {
// base case
        if (this.isEmpty()) {
            return currentHeight;
        }
// general case
        int leftHeight = this.getLeftSubtree().height(currentHeight + 1);
        int rightHeight = this.getRightSubtree().height(currentHeight + 1);
        return Math.max(leftHeight, rightHeight);
    }

    /**
     * computes level of node in this tree
     *
     * @return the level of a node matching the given data. -1 if not found
     */

//    public int level(T data){
//        if (this.isEmpty())
//            return -1;
//
//        if(this.root.data.equals(data))
//            return 1;
//
//            //asks the left subtree to compute level of node
//        int leftlevel = this.getLeftSubtree().level(data);
//        int rightlevel = this.getRightSubtree().level(data);
//
//        // -1, -1 --> -1
//        // -1, >0 --> >0 + 1
//        // >0, -1 --> >0 + 1
//        // >0, >0 --> 1 + if min -> level closer to root
//        //            1 + if max -> level further from root
//
//        int largerLevel = Math.max(leftlevel, rightlevel);
//            return largerLevel + (largerLevel > 0 ? 1 : 0);
//
//
//    }
    public int level(T data) {
        return this.level(this.root, data, 1);

    }

    private int level(Node<T> localRoot, T data, int currentLevel) {
        //base case
        if (localRoot == null)
            return -1;

        if (localRoot.data.equals(data))
            return currentLevel;

        int leftLevel = this.level(localRoot.left, data, currentLevel + 1);
        int rightLevel = this.level(localRoot.right, data, currentLevel + 1);

        int largerLevel = Math.max(leftLevel, rightLevel);
        return largerLevel;
    }

    /**
     * return the largest element in the binary tree
     *
     * @return the largest element in this tree. Null if empty
     */

    public T largest() {
        if (this.isEmpty())
            return null;

        //gen case
        T rootData = this.root.data;
        T leftLargest = this.getLeftSubtree().largest();
        T rightLargest = this.getRightSubtree().largest();

        if (leftLargest == null && rightLargest == null)
            return rootData;

        if (leftLargest == null)
            return (rootData.compareTo(rightLargest) < 0 ? rightLargest : rootData);

        if (rightLargest == null)
            return (rootData.compareTo(leftLargest) < 0 ? leftLargest : rootData);

        // this could be just a bunch of if statements
        //(condition ? x : y)
        // if (condition) { x } else { y }
        return (rootData.compareTo(leftLargest) < 0 ?
                (leftLargest.compareTo(rightLargest) > 0 ?
                        leftLargest : rightLargest) :
                (rootData.compareTo(rightLargest) > 0 ? rootData : rightLargest));

    }

//    public String preOrderTraveral(){
//        if (this.isEmpty()){
//            return "";
//
//
//        if (this.getLeftSubtree().isEmpty())
//            return getLeftSubtree().root.data.toString();
//
//             else {
//                return getLeftSubtree().preOrderTraveral();
//        }
//
//        }
//
//    }

    /**
     * Count the number of occurrences of nodes with the given data in this binary tree
     *
     * @param data The data in the node of interest
     * @return the number of nodes that contains the given data.
     */

    public int count(T data) {
        //base case
        if (this.isEmpty())
            return 0;

        int leftCount = this.getLeftSubtree().count(data);
        int rightCount = this.getRightSubtree().count(data);

        if (this.root.data == data)
            return 1 + leftCount + rightCount;

        return leftCount + rightCount;


    }
}

