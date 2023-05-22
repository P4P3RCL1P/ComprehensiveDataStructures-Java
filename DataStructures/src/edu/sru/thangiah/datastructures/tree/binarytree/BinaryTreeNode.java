package edu.sru.thangiah.datastructures.tree.binarytree;

/*
 * Class to create individual binary tree nodes. 
 * Note the parent, left, and right attributes which are used to link the individual nodes to the larger tree structure
 */
/**
 * <p>Title: BinaryTreeNode </p>
 *
 * <p>Description: </p>
 * Class to create individual binary tree nodes. 
 * Note the parent, left, and right attributes which are used to link the individual nodes to the larger tree structure
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class BinaryTreeNode {
	/**
	 * Variable to hold the data for a binary tree node
	 */
	private int data;
	/**
	 * Pointer variable which points to the parent of a given node
	 */
	private BinaryTreeNode parent;
	/**
	 * Pointer variable which points to the left child of a given node
	 */
	private BinaryTreeNode left;
	/**
	 * Pointer variable which points to the right child of a given node
	 */
	private BinaryTreeNode right;
	
	private boolean explored;
	
	/**
	 * Uninitialized node which is used to test for empty conditions
	 */
	private static final BinaryTreeNode EMPTY = new BinaryTreeNode(-1);

	BinaryTreeNode()
	{
		this.data = -1;
		parent = null;
		left = this;
		right = this;
		explored = false;
	}
	
	BinaryTreeNode(int data)
	{
		this.data = data;
		parent = EMPTY;
		left = EMPTY;
		right = EMPTY;
		explored = false;
	}
	/**
	 * Completely clears all the parameters for a given node
	 * @return True upon successful completion of the method
	 */
	public boolean clearNode()
	{
		this.data = -1;
		parent = null;
		left = this;
		right = this;
		
		return true;
	}
	/**
	 * Determines if the data parameter is uninitialized
	 * @return True if there is no data value for a given node
	 */
	public boolean isEmpty() {
		if (this.getData() == -1)
		{
			return true;
		}
		return false;
	}
	/**
	 * Determines if a given node is completely uninitialized
	 * @return True if there are no attributes for a given node
	 */
	public boolean isEMPTY() {
		if (this == EMPTY)
		{
			return true;
		}
		return false;
	}
	/**
	 * Getter method for data variable
	 * @return The data for a given node
	 */
	public int getData() {
		return data;
	}

	/**
	 * Setter method for data variable
	 * @param data - The value to set the private data variable to
	 * @return True upon successful completion of method
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Getter method for parent pointer
	 * @return The parent for a given node
	 */
	public BinaryTreeNode getParent() {
		return parent;
	}

	/**
	 * Setter method for the parent pointer variable
	 * @param parent - The new value for the parent variable
	 */
	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}

	/**
	 * Getter method for the left pointer variable
	 * @return The left child for a given node
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * Setter method for the left pointer variable
	 * @param left - The new value for the left variable
	 */
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	/**
	 * Getter method for the right pointer variable
	 * @return The right child for a given node
	 */
	public BinaryTreeNode getRight() {
		return right;
	}

	/**
	 * Setter method for the right pointer variable
	 * @param right - The new value for the right variable
	 */
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public void setExplored(boolean explored)
	{
		this.explored = explored;
	}
	
	public boolean getExplored()
	{
		return explored;
	}
	
}
