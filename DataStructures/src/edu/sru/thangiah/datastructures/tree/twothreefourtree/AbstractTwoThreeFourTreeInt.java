package edu.sru.thangiah.datastructures.tree.twothreefourtree;

import edu.sru.thangiah.datastructures.TreeOpsInt;

public abstract class AbstractTwoThreeFourTreeInt implements TreeOpsInt {

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Method used to check if the tree is empty
	 * from the root
	 */
	public abstract boolean isEmpty();

	/**
	 * Method used to check if the tree is full
	 */
	public abstract boolean isFull();

	/**
	 * Method used to clear the tree of values
	 */
	public abstract boolean clear();

	/**
	 * Method used to check if the tree contains a value
	 */
	public abstract boolean contains(TwoThreeFourTreeNode root, int value);
	
	/**
	 * Method used to add a node to the tree
	 */
	public abstract boolean add(int value);

	/**
	 * Method used to check the height of the tree
	 */
	public abstract int height(TwoThreeFourTreeNode node);

	/**
	 * Method used to display the nodeCount of the tree
	 */
	public abstract int nodeCount();

	/**
	 * Method used to insert a value into the tree, similarly to add
	 */
	public abstract int insert();

	public abstract Object remove();
	
	/**
	 * Method used to split a node in the tree
	 */
	public abstract boolean split(TwoThreeFourTreeNode node); //used to split up a node from a larger to a smaller

	/**
	 * Method used to find a node in the tree
	 */
	public abstract TwoThreeFourTreeNode locateNode(TwoThreeFourTreeNode root, int value);
	
	/**
	 * Method used to search for an int value in the tree that
	 * utilizes locateNode as a helper
	 */
	public abstract TwoThreeFourTreeNode search(int value);

	
	public abstract int findMax();
	
	public abstract int findMin();

	public abstract int rotateLeft();
	
	public abstract int rotateRight();
	
	public abstract int degree(TwoThreeFourTreeNode node);

	public abstract boolean isComplete();

	public abstract boolean isIncomplete();

	/**
	 * Method used to check if a node is the root val
	 */
	public abstract boolean isRoot(TwoThreeFourTreeNode node);

	/**
	 * Method used to check if a node is a Parent
	 */
	public abstract boolean isParent(TwoThreeFourTreeNode node);

	/**
	 * Method used to check if a node is a child
	 */
	public abstract boolean isChild(TwoThreeFourTreeNode node);

	/**
	 * Method used to check if a node is a leaf
	 */
	public abstract boolean isLeaf(TwoThreeFourTreeNode node);
	
	public void inOrder() {
		// TODO Auto-generated method stub
		
	}

	public void preOrder() {
		// TODO Auto-generated method stub
		
	}
	
	public void postOrder() {
		// TODO Auto-generated method stub
		
	}

	public void levelOrder() {
		// TODO Auto-generated method stub
		
	}
	
}
