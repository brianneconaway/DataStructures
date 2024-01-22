package Tree;

/**
 * Implementation of 2-3 tree
 * 
 * @author CS256 Fall 2023
 * @param <T> type of objects to store in this 2-3 tree.
 * 
 */
public class TwoThreeTree<T extends Comparable<T>> {
	// instance variable
	private Node<T> root;
	
	// private static Node class definition
	/**
	 * A node class to represent either a 2-node or a 3-node
	 * 
	 * @param <E> type of objects to store in this node
	 */
	private static class Node<E extends Comparable<E>> {
		// instance variables
		private E leftData, rightData;
		private Node<E> left, middle, right;
		
		/**
		 * Constructs a 2-node with the given data
		 * 
		 * @param data object to store in this 2-node.
		 */
		public Node(E data) {
			this.leftData = data;
		}
		
		/**
		 * Constructs a 3 node with the given data
		 * 
		 * @param leftStuff object for the left data
		 * @param rightStuff object for the right data
		 */
		public Node(E leftStuff, E rightStuff) {
			this.leftData = leftStuff;
			this.rightData = rightStuff;
		}
		
		/**
		 * Checks if this node is a 2-node
		 * 
		 * @return true if it is a 2 node. false otherwise.
		 */
		public boolean isTwoNode() {
			return this.rightData == null;
		}
		
		/**
		 * Checks if this node is a 3-node
		 * 
		 * @return true if it is a 3 node. false otherwise.
		 */
		public boolean isThreeNode() {
			return !this.isTwoNode();
		}
		
		/**
		 * Checks if this node is a leaf node
		 * 
		 * @return true if it is a leaf node. false otherwise.
		 */
		public boolean isLeaf() {
			return this.left == null;
		}
	}
	
	// constructors
	/**
	 * Constructs an empty 2-3 tree
	 */
	public TwoThreeTree() {
		this.root = null;
	}
	
	/**
	 *  Private constructor that takes a root node
	 *  
	 *  @param rootNode the root node for this 2-3 tree
	 */
	private TwoThreeTree(Node<T> rootNode) {
		this.root = rootNode;
	}
	
	/**
	 * Get the left subtree
	 * 
	 * @return the left 2-3 subtree
	 */
	public TwoThreeTree<T> getLeftSubTree() {
		return (this.root == null ? null : new TwoThreeTree<T>(this.root.left));
	}
	
	/**
	 * Get the middle subtree
	 * 
	 * @return the middle 2-3 subtree
	 */
	public TwoThreeTree<T> getMiddleSubTree() {
		return (this.root == null ? null : new TwoThreeTree<T>(this.root.middle));
	}
	
	/**
	 * Get the right subtree
	 * 
	 * @return the right 2-3 subtree
	 */
	public TwoThreeTree<T> getRightSubTree() {
		return (this.root == null ? null : new TwoThreeTree<T>(this.root.right));
	}
	
	// private instance variables to help the insert method
	// facilitate the communication between levels of recursion
	private T newParent;
	private Node<T> newChild;
	
	/**
	 * Insert the given data into this 2-3 tree
	 * 
	 * @param data the object to insert into this tree.
	 * @return true if inserted. false otherwise.
	 */
	public boolean add(T data) {
		// is this an empty tree?
		if (this.root == null) {
			this.root = new Node<T>(data);
			return true;
		} else {
			// call the private recursive method
			boolean returnValue = this.add(this.root, data);
			// is there anything that got promoted all the way to the root level (level 1)?
			if (newParent != null) {
				// split the root node
				Node<T> oldRoot = root;
				this.root = new Node<T>(newParent);
				this.root.left = oldRoot;
				this.root.right = newChild;
				// reinitialize the instance variables newParent and newChild
				this.newParent = null;
				this.newChild = null;
			}
			return returnValue;
		}
		
	}
	
	/**
	 * private helper method for insertion
	 * 
	 * @param localRoot the local root node within this tree
	 * @param data the object to insert
	 * @return true if successful. false otherwise.
	 */
	private boolean add(Node<T> localRoot, T data) {
		// is this a duplicate?
		if (localRoot.leftData.equals(data) ||
				(localRoot.isThreeNode() && localRoot.rightData.equals(data))) {
			return false;
		}
		// if this a leaf node?
		if (localRoot.isLeaf()) {
			// this is a leaf node
			// if it's a 2-node, promote it to a 3-node
			if (localRoot.isTwoNode()) {
				// promote
				if (data.compareTo(localRoot.leftData) > 0) {
					localRoot.rightData = data;
				} else {
					localRoot.rightData = localRoot.leftData;
					localRoot.leftData = data;
				}
				return true;
			} else {
				// this is a 3-node
				splitNode(localRoot, data, null);
				return true;
			}
		} else {
			// this is not a leaf node
			boolean returnValue = false;
			// is it a 2-node?
			if (localRoot.isTwoNode()) {
				// this is a 2-node
				if (data.compareTo(localRoot.leftData) < 0) {
					// go left
					returnValue = this.add(localRoot.left, data);
				} else {
					// go right
					returnValue = this.add(localRoot.right, data);
				}
			} else {
				// this is a 3-node
				if (data.compareTo(localRoot.leftData) < 0) {
					// go left
					returnValue = this.add(localRoot.left, data);
				} else {
					if (data.compareTo(localRoot.rightData) > 0) {
						// go right
						returnValue = this.add(localRoot.right, data);
					} else {
						// go middle
						returnValue = this.add(localRoot.middle, data);
					}
				}
			}
			// is there a new parent to take care of?
			if (this.newParent != null) {
				// is this a 2-node?
				if (localRoot.isTwoNode()) {
					// this is a 2-node
					if (newParent.compareTo(localRoot.leftData) < 0) {
						// shift
						localRoot.rightData = localRoot.leftData;
						localRoot.leftData = this.newParent;
						localRoot.middle = this.newChild;
					} else {
						// no shift necessary
						localRoot.rightData = this.newParent;
						localRoot.middle = localRoot.right;
						localRoot.right = this.newChild;
					}
					// delete the new parent and child because
					// we took care of it at this level
					this.newParent = null;
					this.newChild = null;
				} else {
					// this is a 3-node
					this.splitNode(localRoot, this.newParent, this.newChild);
				}
			} 
			return returnValue;
			
		}
	}
	
	/**
	 * Takes a 3-node, an object to insert, and a potential child node to attach
	 * after splitting.
	 * 
	 * 1. Converts the given 3 node to a 2-node with the smallest object
	 * and attach the two smallest children to this node
	 * 
	 * 2. Create a new 2-node with the largest object
	 * and attach the other two childeren to this node
	 * 
	 * 3. Set the middle object to be inserted above (level above)
	 */
	private void splitNode(Node<T> node, T data, Node<T> child) {
		// create an array of T objects
		T[] objects = (T[])new Comparable[3];
		// create an array of Node objects
		Node<T>[] children = new Node[4];
		
		// pace the correct objects and nodes into the arrays above
		if (data.compareTo(node.rightData) > 0) {
			objects[0] = node.leftData;
			objects[1] = node.rightData;
			objects[2] = data;
			
			children[0] = node.left;
			children[1] = node.middle;
			children[2] = node.right;
			children[3] = child;
		} else {
			if (data.compareTo(node.leftData) < 0) {
				objects[0] = data;
				objects[1] = node.leftData;
				objects[2] = node.rightData;
				
				children[0] = node.left;
				children[1] = child;
				children[2] = node.middle;
				children[3] = node.right;
			} else {
				objects[0] = node.leftData;
				objects[1] = data;
				objects[2] = node.rightData;
				
				children[0] = node.left;
				children[1] = node.middle;
				children[2] = child;
				children[3] = node.right;
			}
		}
		
		// step #1
		node.leftData = objects[0];
		node.rightData = null;
		
		node.left = children[0];
		node.middle = null;
		node.right = children[1];
		
		// step #2
		this.newChild = new Node<T>(objects[2]);
		this.newChild.left = children[2];
		this.newChild.right = children[3];
		
		// step #3
		this.newParent = objects[1];
	}

	/**
	 * Counts the number of values in this 2-3 tree.
	 *
	 * @return the number of values in this 2-3 tree.
	 */
	public int count() {
		// base (empty)
		if (this.root == null)
			return 0;

		// general case
		//if leaf we don't need to recurse on subtrees
		int count = (this.root.isTwoNode() ? 1 : 2);

		// always count left and right regardless of if it's a 2 or 3 node
		if (!this.root.isLeaf())
			count += this.getLeftSubTree().count() + this.getRightSubTree().count()
					+ (this.root.isThreeNode() ? this.getMiddleSubTree().count() : 0);

		return count;
	}

	/**
	 * Computes the height of this 2-3 tree.
	 *
	 * STUDY SIMPLE METHODS FOR 2-3 TREE
	 * 
	 * @return the height of this 2-3 tree.
	 */
	public int height() {
		// base
		if (this.root == null){
			return 0;
		}

		return getLeftSubTree().height() + 1;

	}
	
	/**
	 * Computes the level for a value in this 2-3 tree.
	 * 
	 * @param target the object to check for membership
	 * @return true if the given object is found in this 2-3. false otherwise.
	 */
	public int level(T target) {
		// base
		if (this.root == null)
			return 0;

		// leaf node
		if (root.isLeaf())
			return 1;

		// if it is 2 node either less or greater than root
		if (target.compareTo(root.leftData) < 0)
			return getLeftSubTree().level(target);

		if (target.compareTo(root.rightData) < 0)
			return getRightSubTree().level(target);

		if (target.compareTo(root.rightData) < 0 && target.compareTo(root.rightData) > 0)
			return getMiddleSubTree().level(target);


			return -1;


	}
}