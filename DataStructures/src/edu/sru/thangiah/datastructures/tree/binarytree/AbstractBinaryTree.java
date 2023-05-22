package edu.sru.thangiah.datastructures.tree.binarytree;

import edu.sru.thangiah.datastructures.TreeSearchOps;
import edu.sru.thangiah.datastructures.TreeOpsInt;
import edu.sru.thangiah.datastructures.TreeTraversalOps;
import edu.sru.thangiah.datastructures.generic.tree.binarytree.BinaryTreeNodeGeneric;
/**
 * <p>Title: AbstractBinaryTree</p>
 *
 * <p>Description: </p>
 * Template for the structure of a binary search tree implementation
 * Note that a binary search tree is not self balanced so we will have subtrees which are all right leaning or all left leaning.
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractBinaryTree implements TreeOpsInt, TreeTraversalOps, TreeSearchOps{

	/**
	 * Returns the height (total levels) in the tree
	 * @param treeNode - The node which we are trying to get the height from
	 * @return The count of total levels in the tree
	 */
	public abstract int height(BinaryTreeNode treeNode);
	
	/**
	 * Returns the count of nodes in the tree
	 * @return The total number of nodes in the tree
	 */
	public abstract int nodeCount();

	/**
	 * returns the total number of children for a given node
	 * @param treeNode - the given node within the tree/subtree which we are trying to find the degree of
	 * @return the number of children for a given node
	 */
	public abstract int degree(BinaryTreeNode treeNode);
	
	/**
	 * returns true if each node has at most 2 children or no more than 0 children.
	 * @param treeNode - The tree or subtree we are evaluating
	 * @return Returns true if each node has at most 2 children or no more than 0 children
	 */
	public abstract boolean isFull(BinaryTreeNode treeNode);
	
	/**
	 * Evaluates if all the levels in the tree are completely filled except the lowest one, which is filled from the left
	 * @return True if all the levels in the tree are completely filled except the lowest ones, which are filled from the left
	 */
	public abstract boolean isComplete();

	/**
	 * Evaluates if all the levels in the tree are not completely filled from left to right
	 * @return True if all the levels in the tree are not completely filled from left to right
	 */
	public abstract boolean isIncomplete();
	/**
	 * Evaluates if the given node is the root node (no parent)
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is the root node (no parent)
	 */
	public abstract boolean isRoot(BinaryTreeNode treeNode);

	/**
	 * Evaluates if the given node is a parent node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isParent(BinaryTreeNode treeNode);

	/**
	 * Evaluates if the given node is a child node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a child node
	 */
	public abstract boolean isChild(BinaryTreeNode treeNode);

	/**
	 * Evaluates if the given node is a leaf node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isLeaf(BinaryTreeNode treeNode);
	
	/**
	 * similar to add which inserts a node following the tree structure
	 * @param value - The item to insert into the tree
	 * @return true upon successful completion of the method
 	 */
	public abstract boolean insert(int value);

	/**
	 * similar to locateNode except does not take a BinaryTreeNode parameter
	 * @param value - The value to be searched
	 * @return The node which contains the value searched for
	 */
	public abstract BinaryTreeNode search(int value);
	
	/**
	 * Finds a given node based on the root node and value which we are searching for
	 * @param root - The root node of the tree
	 * @param data - The value which we are searching for
	 * @return The node if we have found it in the tree
	 */
	public abstract BinaryTreeNode locateNode(BinaryTreeNode root, int data);
	
	/**
	 * returns the node which is the predecessor given the parameters passed
	 * @param root - The root node of the tree
	 * @param data - The value which we are searching for
	 * @return The predecessor for a given node
	 */
	public abstract BinaryTreeNode predecessor(BinaryTreeNode root, int data);
	
	/**
	 * returns the node which is the successor given the parameters passed
	 * @param root - The root node of the tree
	 * @return The success for a given node
	 */
	public abstract BinaryTreeNode successor(BinaryTreeNode root);
	
	/**
	 * returns the node which contains the largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the largest value in a tree
	 */
	public abstract BinaryTreeNode getLargest(BinaryTreeNode root);
	
	/**
	 * returns the node which contains the smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the smallest value in a tree
	 */
	public abstract BinaryTreeNode getSmallest(BinaryTreeNode root);
	
	/**
	 * returns the node which contains the second largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second largest value in a tree
	 */
	public abstract BinaryTreeNode getSecondLargest(BinaryTreeNode root);
	
	/**
	 * returns the node which contains the second smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second smallest value in a tree
	 */
	public abstract BinaryTreeNode getSecondSmallest(BinaryTreeNode root);
	
	/**
	 * locates a node to be removed given the value parmater and removes it
	 * @param value - The item to be removed from the tree
	 * @return the value of the node removed
	 */
	public abstract int remove(int value);
	
	/**
	 * rotates a tree left based on a pivot
	 * @param node - The tree node which acts as the pivot
	 * @return True upon successful rotation of the tree
	 */
	public abstract boolean rotateLeft(BinaryTreeNode node);
	
	/**
	 * rotates a tree right based on a pivot
	 * @param node - The tree node which acts as the pivot
	 * @return True upon successful rotation of the tree
	 */
	public abstract boolean rotateRight(BinaryTreeNode node);
	
	/**
	 * in-order traversal of tree
	 * @param treeNode - The target node for our traversal
	 * @return The complete in-order traversal
	 */
	public abstract void inOrder(BinaryTreeNode treeNode);
	
	/**
	 * pre-Order traversal of tree
	 * @param treeNode - The target node for our traversal
	 * @return The complete pre-order traversal
	 */
	public abstract void preOrder(BinaryTreeNode treeNode);
	
	/**
	 * post-order traversal of tree
	 * @param treeNode - The target node for our traversal
	 */
	public abstract void postOrder(BinaryTreeNode treeNode);
	
	/**
	 * level-order traversal of tree
	 * @param treeNode - The target node for our traversal
	 * @return The complete level-order traversal
	 */
	public abstract void levelOrder(BinaryTreeNode treeNode);
	
	/**
	 * finds the maximum value in the tree
	 * @param root - The root node of a tree
	 * @return The value of the node with the maximum value
	 */
	public abstract int findMax(BinaryTreeNode root);

	/**
	 * finds the minimum value in the tree
	 * @param root - The root node of a tree
	 * @return The value of the node with the minimum value
	 */
	public abstract int findMin(BinaryTreeNode root);
	/**
	 * Traversal algorithm which visits every vertex and edge once at each level in the tree
	 * to search for a specific node
	 * @param root - The target node to start our search
	 * @param value - The value to search for
	 * @return The node which is searched for
	 */
	public abstract boolean breadthFirst (BinaryTreeNode root, int value);
	
	/**
	 * Traversal algorithm which starts at the root node and visits as far left/right in the tree before backtracking
	 * @param root - The target node to start our search
	 * @param value - The value to search for
	 * @return The node which is searched for
	 */
	public abstract boolean depthFirst (BinaryTreeNode root, int value, boolean valueFound);
	
	
	/*
	 * TreeOpsInt methods which are inherited but not used
	 */
	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int search() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rotateLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rotateRight() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public void inOrder() {

	}

	@Override
	public void preOrder() {
	}

	@Override
	public void postOrder() {

	}

	@Override
	public void levelOrder() {

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean breadthFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean depthFirst() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isParent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
