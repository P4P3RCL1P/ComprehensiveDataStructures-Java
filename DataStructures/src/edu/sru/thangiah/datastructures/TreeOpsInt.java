package edu.sru.thangiah.datastructures;
import edu.sru.thangiah.datastructures.tree.heaptree.HeapTreeNode;
/**
 * <p>Title: TreeOpsInt</p>
 *
 * <p>Description: </p>
 * TreeOpsInt Interface class
 * All subsequent tree data structures use this interface class as a framework for what methods should be included
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public interface TreeOpsInt extends  BaseOpsInt{
	
	/**
	 * height of the tree
	 * @return The height of the tree
	 */
	//public int height ();
	
	/**
	 * number of nodes in the tree
	 * @return The int count of nodes in the tree
	 */
	public int nodeCount ();
	
	/**
	 * Calculates the number of children for a given node
	 * @return The number of children for a given node
	 */
	public int degree();

	/**
	 * Method for assessing if the tree is full
	 * @return Returns true if tree is a full tree
	 */
	public boolean isFull();
	
	/**
	 * Method for assessing if the tree is complete
	 * @return Returns true if binary tree is a complete tree
	 */
	public boolean isComplete();
	
	/**
	 * Method for assessing if the tree is incomplete
	 * @return Returns true if binary tree is an incomplete tree
	 */
	public boolean isIncomplete();
	
	/**
	 * Boolean method for assessing if a given node is the root node
	 * @return Returns true if node is root node
	 */
	public boolean isRoot();
	
	/**
	 * Boolean method for assessing if a given node is a parent node
	 * @return Returns true if node is parent node
	 */
	public boolean isParent();
	
	/**
	 * Boolean method for assessing if a given node is a child node
	 * @return Returns true if node is child node
	 */
	public boolean isChild();
	
	/**
	 * Boolean method for assessing if a given node is a leaf node
	 * @return Returns true if node is leaf node
	 */
	public boolean isLeaf();
	
	/**
	 * Insert a node into the tree
	 * @return The value which was passed to the insert method
	 */
	public int insert ();
	
	/**
	 * Remove a node from the tree
	 * @return The node which was removed
	 */
	public Object remove ();
	
	/**
	 * Search for a node in the tree
	 * @return The value of the node which was searched for
	 */
	public int search ();
	
	/**
	 * Find the maximum value in the tree
	 * @return The maximum value in the tree
	 */
	public int findMax ();
	
	/**
	 * Find the minimum value in the tree
	 * @return The minimum value in the tree
	 */
	public int findMin ();
	
	/**
	 * Rotate tree/subtree to the left
	 * @return True based on successful rotation
	 */
	public int rotateLeft ();
	
	/**
	 * Rotate tree/subtree to the right
	 * @return True based on successful rotation
	 */
	public int rotateRight ();
}
