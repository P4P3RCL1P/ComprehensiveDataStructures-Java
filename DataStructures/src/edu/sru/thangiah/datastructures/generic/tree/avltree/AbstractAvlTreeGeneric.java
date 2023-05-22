package edu.sru.thangiah.datastructures.generic.tree.avltree;

import edu.sru.thangiah.datastructures.generic.TreeOpsGeneric;
/*
 * Template for the structure of a generic AVL tree implementation
 */
/**
 * <p>Title: AbstractAvlTreeGeneric</p>
 *
 * <p>Description: </p>
 * Template for the structure of a generic AVL tree implementation
 * Note that an AVL tree is a self-balancing tree which checks the height of subtrees to ensure that the left and right subtrees don't have a height greater than one
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public abstract class AbstractAvlTreeGeneric <T> implements TreeOpsGeneric <T> {
	
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
	 * Gets the total number of children for a given node
	 * @param treeNode - The specific node which we are evaluating the degree of
	 * @return The total number of children for a given node
	 */
	abstract public int degree(AvlTreeNodeGeneric<T> treeNode);

	/**
	 * returns true if all the levels in the tree are completely filled except the lowest one, which is filled from the left
	 */
	abstract public boolean isComplete();


	abstract public boolean isIncomplete();

	/**
	 * returns true if the given node is the root node (no parent)
	 * @param treeNode - The node to test for the condition
	 * @return True if the node has no parent
	 */
	abstract public boolean isRoot(AvlTreeNodeGeneric<T> treeNode);

	/**
	 * returns true if the given node is a parent and has children
	 * @param treeNode - The node to test for the condition
	 * @return True if the node has children
	 */
	abstract public boolean isParent(AvlTreeNodeGeneric<T> treeNode);

	/**
	 * returns true if the given node has a parent
	 * @param treeNode - The node to test for the condition
	 * @return True if the node has a parent
	 */
	abstract public boolean isChild(AvlTreeNodeGeneric<T> treeNode);

	/**
	 * return true if the given node has no left or right children
	 * @param treeNode - The node to test for the condition
	 * @return True if the node has no children
	 */
	abstract public boolean isLeaf(AvlTreeNodeGeneric<T> treeNode);
	
	//removes all the nodes from the tree
	abstract public boolean clear();

	//returns true if the value passed as a parameter is found in the tree
	abstract public boolean contains(T value);

	//adds a node to the tree
	abstract public boolean add(T value);

	//removes a node from the tree
	abstract public T remove();

	//returns the index of where the value is found in the structure
	public T indexOf(int value) 
	{
		return null;
	}
	//Returns the height (total levels) in the tree
	abstract public int height();
	//Returns the count of nodes in the tree
	public int nodeCount()
	{
		return -1;
	}
	//similar to add which inserts a node following the tree structure
	public abstract boolean insert(T value);
	//removes a node from the tree
	abstract public T remove(T removeValue);
	//similar to locateNode except does not take a BinaryTreeNode parameter
	abstract public T search(T searchValue);
	
	//finds the maximum value in the tree
	@Override
	public T findMax()
	{
		return null;
	}
	//finds the minimum value in the tree
	@Override
	public T findMin()
	{
		return null;
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
	abstract public boolean leftLeft(AvlTreeNodeGeneric node);
	
	/**
	 * this method takes in the top node of a left right rotate
	 * and it moves the bottom node to the top node, and the top
	 * node becomes the right node of that node, and the children
	 * get split, right children to the left of the top node
	 * and left children to the right of the middle node
	 * @param node - The pivot node for the rotation
	 * @return True upon successful completion of the method
	 */
	
	abstract public boolean leftRight(AvlTreeNodeGeneric node);
	
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
	abstract public boolean rightLeft(AvlTreeNodeGeneric node);
	
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
	abstract public boolean rightRight(AvlTreeNodeGeneric node);
	
	/**
	 * Traverses up the tree
	 * @param node - The starting point for the traversal
	 * @return True upon successful completion of the method
	 */
	abstract public boolean ascendTree(AvlTreeNodeGeneric node);

	/**
	 * rotates a tree left based on a pivot
	 * @param node - The pivot by which we perform the rotation
	 * @return True based on successful completion of the rotation
	 */
	public abstract boolean rotateLeft(AvlTreeNodeGeneric<T> node);
		
	/**
	 * rotates a tree right based on a pivot
	 * @param node - The pivot by which we perform the rotation
	 * @return True based on successful completion of the roation
	 */
	public abstract boolean rotateRight(AvlTreeNodeGeneric<T> node);

	
	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

}
