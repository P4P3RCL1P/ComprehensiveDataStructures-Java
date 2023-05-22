package edu.sru.thangiah.datastructures.generic.tree.binarytree;

/*
 * Class to create individual binary tree nodes. 
 * Note the parent, left, and right attributes which are used to link the individual nodes to the larger tree structure
 */
/**
 * <p>Title: BinaryTreeNodeGeneric </p>
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
public class BinaryTreeNodeGeneric <T extends Comparable<T>>{
	/**
	 * Variable to hold the data for a binary tree node
	 */
	private T data;
	/**
	 * Pointer variable which points to the parent of a given node
	 */
	private BinaryTreeNodeGeneric<T> parent;
	/**
	 * Pointer variable which points to the left child of a given node
	 */
	private BinaryTreeNodeGeneric<T> left;
	/**
	 * Pointer variable which points to the right child of a given node
	 */
	private BinaryTreeNodeGeneric<T> right;
	
	/**
	 * Uninitialized node which is used to test for empty conditions
	 */
	private static final BinaryTreeNodeGeneric  EMPTY = new BinaryTreeNodeGeneric(null);
	
	BinaryTreeNodeGeneric()
	{
		this.data = null;
		setParent(null);
		setLeft(this);
		setRight(this);
	}
	BinaryTreeNodeGeneric(T data)
	{
		this.data = data;
		setParent(EMPTY);
		setLeft(EMPTY);
		setRight(EMPTY);
	}
	/**
	 * Completely clears all the parameters for a given node
	 * @return True upon successful completion of the method
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
	 * Determines if the data parameter is uninitialized
	 * @return True if there is no data value for a given node
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
	 * Determines if a given node is completely uninitialized
	 * @return True if there are no attributes for a given node
	 */
	public boolean isEMPTY()
	{
		if(this == EMPTY)
		{
			return true;
		}
		return false;
	}
	/**
	 * Getter method for data variable
	 * @return The data for a given node
	 */
	public T getData()
	{
		return data;
	}
	/**
	 * Setter method for data variable
	 * @param data - The value to set the private data variable to
	 * @return True upon successful completion of method
	 */
	public void setData(T data)
	{
		this.data = data;
	}
	/**
	 * Getter method for parent pointer
	 * @return The parent for a given node
	 */
	public BinaryTreeNodeGeneric getParent() {
		return parent;
	}
	/**
	 * Setter method for the parent pointer variable
	 * @param parent - The new value for the parent variable
	 */
	public void setParent(BinaryTreeNodeGeneric parent) {
		this.parent = parent;
	}
	/**
	 * Getter method for the left pointer variable
	 * @return The left child for a given node
	 */
	public BinaryTreeNodeGeneric getLeft() {
		return left;
	}
	/**
	 * Setter method for the left pointer variable
	 * @param left - The new value for the left variable
	 */
	public void setLeft(BinaryTreeNodeGeneric left) {
		this.left = left;
	}
	/**
	 * Getter method for the right pointer variable
	 * @return The right child for a given node
	 */
	public BinaryTreeNodeGeneric getRight() {
		return right;
	}
	/**
	 * Setter method for the right pointer variable
	 * @param right - The new value for the right variable
	 */
	public void setRight(BinaryTreeNodeGeneric right) {
		this.right = right;
	}
}
