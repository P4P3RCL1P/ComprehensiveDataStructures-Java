package edu.sru.thangiah.datastructures;
/**
 * <p>Title: AbstractTree</p>
 *
 * <p>Description: </p>
 * Abstract template for any general tree structure. TreeOpsInt, TreeTraversalOps and TreeSearchOps
 * are inherited to layout the framework for the abstract class. This class can be inherited to allow
 * for easy and standardized implementation of a tree
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractTree implements TreeOpsInt, TreeTraversalOps, TreeSearchOps{
	
	/**
	 * returns the number of levels in the tree
	 * @return
	 */
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * returns the number of nodes in the tree
	 */
	@Override
	public int nodeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * inserts a node into the tree structure
	 */
	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * removes a node from the tree structure
	 */
	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * searches for a value in the tree structure
	 */
	@Override
	public int search() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * finds the maximum value in the tree structure
	 */
	@Override
	public int findMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * finds the minimum value in the tree structure
	 */
	@Override
	public int findMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * rotates the tree structure left based on a pivot
	 */
	@Override
	public int rotateLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * rotates the tree structure right based on a pivot
	 */
	@Override
	public int rotateRight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * performs in order traversal on the tree
	 */
	@Override
	public void inOrder() {

	}

	/**
	 * performs pre order traversal on the tree
	 */
	@Override
	public void preOrder() {
	}

	/**
	 * performs post order traversal on the tree
	 */
	@Override
	public void postOrder() {

	}

	/**
	 * performs level order traversal on the tree
	 */
	@Override
	public void levelOrder() {

	}

	/**
	 * returns the size of the tree (similar to node count)
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * returns true if the tree is full
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * searches for a value in the tree
	 */
	@Override
	public boolean contains(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * adds a value to the tree structure
	 */
	@Override
	public boolean add(int value) {
		// TODO Auto-generated method stub
		return false;
	}


}
