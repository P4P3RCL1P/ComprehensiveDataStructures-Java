package edu.sru.thangiah.datastructures.generic;

import edu.sru.thangiah.datastructures.generic.TreeOpsGeneric;

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
public abstract class AbstractTreeGeneric <T> implements TreeOpsGeneric <T> {
	/**
	 * returns the number of levels in the tree
	 * @return
	 */
	public int height()
	{

		return 0;
	}
	/**
	 * returns the number of nodes in the tree
	 */
	public int nodeCount()
	{
		return 0;
	}
	/**
	 * inserts a node into the tree structure
	 */
	public boolean insert(T value)
	{
		return false;
	}
	/**
	 * removes a node from the tree structure
	 */
	public T remove()
	{
		return null;
	}
	/**
	 * searches for a value in the tree structure
	 */
	public T search()
	{
		return null;
	}
	/**
	 * finds the maximum value in the tree structure
	 */
	public T findMax()
	{
		return null;
	}
	/**
	 * finds the minimum value in the tree structure
	 */
	public T findMin()
	{
		return null;
	}
	/**
	 * rotates the tree structure left based on a pivot
	 */
	public T rotateLeft()
	{
		return null;
	}
	/**
	 * rotates the tree structure right based on a pivot
	 */
	public T rotateRight()
	{
		return null;
	}
	/**
	 * searches for a value in the tree
	 */
	public boolean contains(T value)
	{
		return false;
	}
	/**
	 * adds a value to the tree structure
	 */
	public boolean add(T value)
	{
		return false;
	}
	//returns true if the tree is empty
	public boolean isEmpty(){
		return false;
	}

}

