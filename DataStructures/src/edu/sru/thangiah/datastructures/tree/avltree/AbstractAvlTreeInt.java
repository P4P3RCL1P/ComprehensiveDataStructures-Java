package edu.sru.thangiah.datastructures.tree.avltree;

import edu.sru.thangiah.datastructures.TreeOpsInt;
/**
 * Template for the structure of a generic AVL tree implementation
 */


import edu.sru.thangiah.datastructures.TreeSearchOps;
import edu.sru.thangiah.datastructures.TreeTraversalOps;


/**
 * <p>Title: AbstractAvlTreeInt</p>
 *
 * <p>Description: </p>
 * Template for the structure of a generic AVL tree implementation
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractAvlTreeInt implements TreeOpsInt, TreeTraversalOps, TreeSearchOps {
	
	//returns the size of the tree
	public int size(){
			return -1;
	}
	//returns true based on if the tree is uninitialized
	abstract public boolean isEmpty();

	//returns true based on if the tree is completely initialized
	public boolean isFull() {
		return false;
	}

	
	/**
	 * returns the total number of children for a given node
	 * @param treeNode - The node which we are testing for the number of children
	 * @return A count of the number of children for a given node
	 */
	public abstract int degree(AvlTreeNode treeNode);

	//returns true if all the levels in the tree are completely filled except the lowest one, which is filled from the left
	public abstract boolean isComplete();

	//returns true if all the levels in the tree are not completely filled from left to right
	public abstract boolean isIncomplete();

	//returns true if the given node is the root node (no parent)
	public abstract boolean isRoot();

	//returns true if the given node is a parent and has children
	public abstract boolean isParent();

	//returns true if the given node has a parent
	public abstract boolean isChild();

	//return true if the given node has no left or right children
	public abstract boolean isLeaf();
	
	//removes all the nodes from the tree
	abstract public boolean clear();

	//returns true if the value passed as a parameter is found in the tree
	abstract public boolean contains(int value);

	//adds a node to the tree
	abstract public boolean add(int value);

	//returns the index of where the value is found in the structure
	public int indexOf(int value) 
	{
		return -1;
	}
	//Returns the height (total levels) in the tree
	abstract public int height();
	
	//Returns the count of nodes in the tree
	public abstract int nodeCount();
	
	//similar to add which inserts a node following the tree structure
	public abstract boolean insert(int value);
	
	//removes a node from the tree
	abstract public int remove(int removeValue);
	
	//similar to locateNode except does not take a BinaryTreeNode parameter
	abstract public int search(int searchValue);
	
	//finds the maximum value in the tree
	@Override
	public int findMax()
	{
		return -1;
	}
	//finds the minimum value in the tree
	@Override
	public int findMin()
	{
		return -1;
	}
	/**
	 * this method takes in the top node of a left left rotate
	 * and turns it into the right node for the middle node
	 * and the middle node's right children become the top
	 * node's left children to maintain the height consistency
	 * of the tree
	 * @param node - The pivot node for the rotation
	 * @return True upon successful completion of the method
	 */
	abstract public boolean leftLeft(AvlTreeNode node);
	/**
	 * this method takes in the top node of a left right rotate
	 * and it moves the bottom node to the top node, and the top
	 * node becomes the right node of that node, and the children
	 * get split, right children to the left of the top node
	 * and left children to the right of the middle node
	 * @param node - The pivot node for the rotation
	 * @return True upon successful completion of the method
	 */
	abstract public boolean leftRight(AvlTreeNode node);
	/**
	 * This works like right left, but inverted
	 * this method takes in the top node of a right left rotate
	 * and it moves the bottom node to the top node, and the top
	 * node becomes the left node of that node, and the children
	 * get split, left children to the right of the top node
	 * and right children to the left of the middle node
	 * @param node - The pivot node for the rotation
	 * @return True upon successful completion of the method
	 */
	abstract public boolean rightLeft(AvlTreeNode node);
	/**
	 * This works like left left, but inverted
	 * this method takes in the top node of a right right rotate
	 * and turns it into the left node for the middle node
	 * and the middle node's left children become the top
	 * node's right children to maintain the height consistency
	 * of the tree
	 * @param node - The pivot node for the rotation
	 * @return True upon successful completion of the method
	 */
	abstract public boolean rightRight(AvlTreeNode node);
	/**
	 * Traverses up the tree
	 * @param node - The starting point for the traversal
	 * @return True upon successful completion of the method
	 */
	abstract public boolean ascendTree(AvlTreeNode node);

	/**
	 * rotates a tree left based on a pivot
	 * @param node - The pivot by which we perform the rotation
	 * @return True based on successful completion of the rotation
	 */
	public abstract boolean rotateLeft(AvlTreeNode node);
		
	/**
	 * rotates a tree right based on a pivot
	 * @param node - The pivot by which we perform the rotation
	 * @return True based on successful completion of the roation
	 */
	public abstract boolean rotateRight(AvlTreeNode node);

	
	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

}
