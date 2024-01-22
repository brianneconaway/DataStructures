package Tree;

/**
 * Binary search tree implementation.
 *
 * @author CS-256 Section 2 Fall 2023
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    // instance variables
    // no additional instance variable is necessary

    // constructors
    public BinarySearchTree() {
    }

    public BinarySearchTree(T data,
                            BinarySearchTree<T> leftSubtree,
                            BinarySearchTree<T> rightSubtree) {
        this.root = new Node<T>(
                data,
                leftSubtree.root,
                rightSubtree.root
        );
        // check if the largest in the left subtree is less than the root data
        if (leftSubtree.largest() != null && leftSubtree.largest().compareTo(data) > 0) {
            throw new RuntimeException("All the values in the left subtree must be smaller than the root data.");
        }

        // check if the smallest in the right subtree is greater than the root data
        if (rightSubtree.smallest() != null && rightSubtree.smallest().compareTo(data) < 0) {
            throw new RuntimeException("All the values in the right subtree must be greater than the root data.");
        }
    }

    // instance methods
    // height does not need to be overriden
    public BinarySearchTree<T> getLeftSubtree() {
        if (this.isEmpty()) {
            return null;
        }
        BinarySearchTree<T> leftSubtree = new BinarySearchTree<T>();
        leftSubtree.root = this.root.left;
        return leftSubtree;
    }

    public BinarySearchTree<T> getRightSubtree() {
        if (this.isEmpty()) {
            return null;
        }
        BinarySearchTree<T> rightSubtree = new BinarySearchTree<T>();
        rightSubtree.root = this.root.right;
        return rightSubtree;
    }

    // largest and smallest needs to be overriden to exploit the ordered nature of BST
    public T largest() {
        // base case
        if (this.isEmpty()) {
            return null;
        }
        if (this.root.right == null) {
            // the root has the largest data in this tree
            return this.root.data;
        }
        // general case
        return this.getRightSubtree().largest();
    }

    public T smallest() {
        // base case
        if (this.isEmpty()) {
            return null;
        }
        if (this.root.left == null) {
            // the root has the smallest data in this tree
            return this.root.data;
        }
        // general case
        return this.getLeftSubtree().smallest();
    }

    /**
     * Adds a new piece of data to this binary search tree.
     *
     * @param data a new piece of data to add
     * @return true if the addition is successful. false if a duplicate data is found.
     */

    /**
    protected boolean add(T data, Node<T> localRoot) {
        //this section allows for duplicates to be added to the left child
        if (data.equals(root.data)) {
            Node<T> temp = localRoot.left;

            localRoot.left = new Node<T>(data);
            localRoot = localRoot.left;
            localRoot.left = temp;
            return true;
        }

        // base case
        if (this.isEmpty()) {
            this.root = new Node<T>(data);
            return true;
        }
        if (this.root.data.compareTo(data) == 0) {
            // duplicate data is found
            return false;
        }
        // general case
        if (this.root.data.compareTo(data) > 0) {
            // go left
            if (this.root.left == null) {
                // no left child detected
                this.root.left = new Node<T>(data);
                return true;
            }
            return this.getLeftSubtree().add(data, localRoot.left);
        } else {
            // right
            if (this.root.right == null) {
                this.root.right = new Node<T>(data);
                return true;
            }
            return this.getRightSubtree().add(data, localRoot.right);
        }
    }
     **/

    public boolean add(T data) {
// base case
        if (this.isEmpty()) {
            this.root = new Node<T>(data);
            return true;
        }
        if (this.root.data.compareTo(data) == 0) {
// duplicate data is found
            return false;
        }
// general case
        if (this.root.data.compareTo(data) > 0) {
// go left
            if (this.root.left == null) {
// no left child detected
                this.root.left = new Node<T>(data);
                return true;
            }
            return this.getLeftSubtree().add(data);
        } else {
// right
            if (this.root.right == null) {
                this.root.right = new Node<T>(data);
                return true;
            }
            return this.getRightSubtree().add(data);
        }
    }


    public int level(T data) {
        if (this.isEmpty())
            return -1;

        if (this.root.data.equals(data))
            return 1;

        // -1, -1 --> -1
        // -1, >0 --> >0 + 1
        // >0, -1 --> >0 + 1
        // >0, >0 --> 1 + if min -> level closer to root
        //            1 + if max -> level further from root

        if (this.root.data.compareTo(data) > 0) {
            int leftLevel = this.getLeftSubtree().level(data);
            if (leftLevel < 0)
                return leftLevel;
            else {
                return leftLevel + 1;
            }

        } else {
            int rightLevel = this.getRightSubtree().level(data);
            if (rightLevel < 0)
                return rightLevel;

            else {
                return rightLevel + 1;
            }
        }
    }


    private BinarySearchTree<T> search(BinarySearchTree tree, T dataToFind) {
        // Base
        if (tree.root == null || tree.root.data == dataToFind)
            return tree;

        // larger than root
        if (dataToFind.compareTo(this.root.data) > 0)
            return search(tree.getRightSubtree(), dataToFind);

        //smaller than root
        return search(tree.getLeftSubtree(), dataToFind);

    }

    private BinarySearchTree<T> search(T data) {
        return search(this, data);
    }

    /**
     * Count the number of occurrences of nodes with the given data in this binary tree
     *
     * @param data The data in the node of interest
     * @return the number of nodes that contains the given data.
     */

    public int count(T data) {
        //base case
        BinarySearchTree<T> found = search(data);

        if (found.root == null)
            return 0;

        //gen case
        return 1 + found.getLeftSubtree().count(data);

    }
}