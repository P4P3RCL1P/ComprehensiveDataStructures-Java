package edu.sru.thangiah.datastructures.generic.tree.avltree;

/*
 * Class for creating individual nodes in the AVL tree.
 * Note that there are parent, left, and right attributes which are used to set the structure of the tree.
 */

/**
 * <p>Title: AvlTreeNodeGeneric</p>
 *
 * <p>Description: </p>
 * Class for creating individual nodes in the AVL tree.
 * Note that there are parent, left, and right attributes which are used to set the structure of the tree.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class AvlTreeNodeGeneric<T> {
	/**
	 * Variable for setting the data of a given node
	 */
	private T data;
	/**
	 * Pointer variable for easily finding the parent of a given node
	 */
	private AvlTreeNodeGeneric<T> parent;
	/**
	 * Pointer variable for easily finding the left child of a given node
	 */
	private AvlTreeNodeGeneric<T> left;
	/**
	 * Pointer variable for easily finding the right child of a given node
	 */
	private AvlTreeNodeGeneric<T> right;
	/**
	 * Uninitialized AvlTree which is used to test for an empty tree
	 */
	private static final AvlTreeNodeGeneric  EMPTY = new AvlTreeNodeGeneric(null);


	AvlTreeNodeGeneric() {

		data = null;
		parent = EMPTY;
		left= EMPTY;
		right= EMPTY;

	}

	AvlTreeNodeGeneric(T data) {
		this.data = data;
		parent = EMPTY;
		left = EMPTY;
		right = EMPTY;
	}

	/**
	 * Removes the data and parent/left/right pointers for a given node
	 * @return True upon successful completion of method
	 */
	public boolean clearNode()
	{
		this.data = null;
		setParent(null);
		setLeft(this);
		setRight(this);
		
		return true;
	}
	/**
	 * Getter method for data variable
	 * @return The data for a given node
	 */
	public T getData() {
		return data;
	}
	/**
	 * Setter method for data variable
	 * @param data - The value to set the private data variable to
	 * @return True upon successful completion of method
	 */
	public boolean setData(T data) {
		this.data = data;
		return true;
	}
	/**
	 * Getter method for parent pointer
	 * @return The parent for a given node
	 */
	public AvlTreeNodeGeneric getParent() {

		return parent;
	}

	/**
	 * Setter method for the parent pointer variable
	 * @param parent - The new value for the parent variable
	 */
	public void setParent(AvlTreeNodeGeneric parent) {
		this.parent = parent;
	}
	
	/**
	 * Getter method for the left pointer variable
	 * @return The left child for a given node
	 */
	public AvlTreeNodeGeneric getLeft() {

		return left;
	}
	/**
	 * Setter method for the left pointer variable
	 * @param left - The new value for the left variable
	 */
	public void setLeft(AvlTreeNodeGeneric left) {
		this.left = left;
	}

	/**
	 * Getter method for the right pointer variable
	 * @return The right child for a given node
	 */
	public AvlTreeNodeGeneric getRight() {

		return right;
	}
	/**
	 * Setter method for the right pointer variable
	 * @param right - The new value for the right variable
	 */
	public void setRight(AvlTreeNodeGeneric right) {
		this.right = right;
	}

	/**
	 * Method for determining if given node is a leaf
	 * @return True if given node has no children
	 */
	public boolean isLeaf() {

		if (left != null) {
			return false;
		}
		return true;
	}

	/**
	 * Method for determining if the data value has been set for a node
	 * @return True if the data for a node is initialized
	 */
	public boolean isFull() {

		if (data != null) {
			return true;
		}
		return false;
	}
	/**
	 * Method for determining if the given node has been initialized with data
	 * @return True if the data for a node is missing
	 */
	public boolean isEmpty()
	{
		if(this.getData() == null)
		{
			return true;
		}
		return false;
	}
	/**
	 * Method for determining if a node has been completely uninitialized
	 * @return True if a node is completely empty
	 */
	public boolean isEMPTY()
	{
		if(this == EMPTY)
		{
			return true;
		}
		return false;
	}
}