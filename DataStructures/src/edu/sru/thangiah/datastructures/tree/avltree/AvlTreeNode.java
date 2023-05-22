package edu.sru.thangiah.datastructures.tree.avltree;

/*
 * Class for creating individual nodes in the AVL tree.
 * Note that there are parent, left, and right attributes which are used to set the structure of the tree.
 */

/**
 * <p>Title: AvlTreeNode</p>
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

public class AvlTreeNode {
	
	/**
	 * Variable for setting the data of a given node
	 */
	private int data;
	/**
	 * Pointer variable for easily finding the parent of a given node
	 */
	private AvlTreeNode parent;
	/**
	 * Pointer variable for easily finding the left child of a given node
	 */
	private AvlTreeNode left;
	/**
	 * Pointer variable for easily finding the right child of a given node
	 */
	private AvlTreeNode right;
	/**
	 * Uninitialized AvlTree which is used to test for an empty tree
	 */
	private static final AvlTreeNode  EMPTY = new AvlTreeNode(-1);


	AvlTreeNode() {
		this.data = -1;
		parent = EMPTY;
		left= EMPTY;
		right= EMPTY;
	}

	AvlTreeNode(int data) {
		this.data = data;
		parent = EMPTY;
		left = EMPTY;
		right = EMPTY;
	}

	/**
	 * method that clears the values for the node
	 * @return true upon completion
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
	 * get method for the data 
	 * @return int value (data) in the node
	 */
	public int getData() {
		return data;
	}

	/**
	 * sets the data of the node
	 * @param data (int)
	 * @return true upon completion
	 */
	public boolean setData(int data) {
		this.data = data;
		return true;
	}

	/**
	 * get method for the parent of the node
	 * @return node of parent
	 */
	public AvlTreeNode getParent() {

		return parent;
	}

	/**
	 * set method for the parent of the node
	 * @param parent node
	 */
	public void setParent(AvlTreeNode parent) {
		this.parent = parent;
	}

	/**
	 * get method for the left child node of the node
	 * @return node (left)
	 */
	public AvlTreeNode getLeft() {

		return left;
	}

	/**
	 * set method for the left node of the node
	 * @param left (node)
	 */
	public void setLeft(AvlTreeNode left) {
		this.left = left;
	}

	/**
	 * get method for the right node of the node
	 * @return node (right)
	 */
	public AvlTreeNode getRight() {

		return right;
	}

	/**
	 * set method for the left node of the node
	 * @param left (node)
	 */
	public void setRight(AvlTreeNode right) {
		this.right = right;
	}

	/**
	 * method to check if the node is leaf meaning it has no children
	 * @return true if the node has no left or right
	 */
	public boolean isLeaf() {

		if (!left.isEmpty()||!right.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * method to check if the node has a value
	 * @return true if the node has a value not -1
	 */
	public boolean isFull() {

		if (data != -1) {
			return true;
		}
		return false;
	}

	/**
	 * method to check if the node is empty and has no inputted value
	 * @return false unless the value is -1
	 */
	public boolean isEmpty() {
		if (this.getData() == -1)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * method to check if the node is equal to the EMPTY constant node
	 * @return true if it is equivalent
	 */
	public boolean isEMPTY() {
		if (this == EMPTY)
		{
			return true;
		}
		return false;
	}
}