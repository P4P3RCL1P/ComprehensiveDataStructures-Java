package edu.sru.thangiah.datastructures.generic.tree.binarytree;

import edu.sru.thangiah.datastructures.generic.TreeOpsGeneric;
import edu.sru.thangiah.datastructures.generic.TreeTraversalOpsGeneric;
import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;
import edu.sru.thangiah.datastructures.generic.TreeSearchOpsGeneric;
/**
 * <p>Title: AbstractBinaryTreeGeneric</p>
 *
 * <p>Description: </p>
 * Template for the structure of a generic binary search tree implementation
 * Note that a binary search tree is not self balanced so we will have subtrees which are all right leaning or all left leaning.
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractBinaryTreeGeneric <T extends Comparable<T>> implements TreeOpsGeneric <T>, TreeTraversalOpsGeneric <T>, TreeSearchOpsGeneric<T>{
	/**
	 * Returns the height (total levels) in the tree
	 * @param node - The node which we are trying to get the height from
	 * @return The count of total levels in the tree
	 */
	public abstract int height(BinaryTreeNodeGeneric<T> node);
	
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
	public abstract int degree(BinaryTreeNodeGeneric<T> treeNode);
	
	/**
	 * returns true if each node has at most 2 children or no more than 0 children.
	 * @param treeNode - The tree or subtree we are evaluating
	 * @return Returns true if each node has at most 2 children or no more than 0 children
	 */
	public abstract boolean isFull(BinaryTreeNodeGeneric<T> treeNode);
	
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
	public abstract boolean isRoot(BinaryTreeNodeGeneric<T> treeNode);

	/**
	 * Evaluates if the given node is a parent node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isParent(BinaryTreeNodeGeneric<T> treeNode);

	/**
	 * Evaluates if the given node is a child node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a child node
	 */
	public abstract boolean isChild(BinaryTreeNodeGeneric<T> treeNode);

	/**
	 * Evaluates if the given node is a leaf node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isLeaf(BinaryTreeNodeGeneric<T> treeNode);


	/**
	 * similar to locateNode except does not take a BinaryTreeNode parameter
	 * @param value - The value to be searched
	 * @return The node which contains the value searched for
	 */
	public abstract BinaryTreeNodeGeneric <T> search(T value);
	
	/**
	 * similar to add which inserts a node following the tree structure
	 * @param value - The item to insert into the tree
	 * @return true upon successful completion of the method
 	 */
	public abstract boolean insert(T value);
	
	/**
	 * Finds a given node based on the root node and value which we are searching for
	 * @param root - The root node of the tree
	 * @param data - The value which we are searching for
	 * @return The node if we have found it in the tree
	 */
	public abstract BinaryTreeNodeGeneric <T> locateNode(BinaryTreeNodeGeneric<T> root, T data);
	
	/**
	 * returns the node which is the predecessor given the parameters passed
	 * @param root - The root node of the tree
	 * @param data - The value which we are searching for
	 * @return The predecessor for a given node
	 */
	public abstract BinaryTreeNodeGeneric <T> predecessor(BinaryTreeNodeGeneric<T> root, T data);
	
	/**
	 * returns the node which is the successor given the parameters passed
	 * @param root - The root node of the tree
	 * @return The success for a given node
	 */
	public abstract BinaryTreeNodeGeneric<T> successor(BinaryTreeNodeGeneric<T> root);
	
	/**
	 * returns the node which contains the largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the largest value in a tree
	 */
	public abstract BinaryTreeNodeGeneric<T> getLargest(BinaryTreeNodeGeneric<T> root);
	
	/**
	 * returns the node which contains the smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the smallest value in a tree
	 */
	public abstract BinaryTreeNodeGeneric<T> getSmallest(BinaryTreeNodeGeneric<T> root);
	
	/**
	 * returns the node which contains the second largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second largest value in a tree
	 */
	public abstract BinaryTreeNodeGeneric<T> getSecondLargest(BinaryTreeNodeGeneric<T> root);
	
	/**
	 * returns the node which contains the second smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second smallest value in a tree
	 */
	public abstract BinaryTreeNodeGeneric<T> getSecondSmallest(BinaryTreeNodeGeneric<T> root);
	
	/**
	 * locates a node to be removed given the value parameter and removes it
	 * @param value - The item to be removed from the tree
	 * @return the value of the node removed
	 */
	public abstract T remove(T value);
	
	/**
	 * rotates a tree left based on a pivot
	 * @param node - The tree node which acts as the pivot
	 * @return True upon successful rotation of the tree
	 */
	public abstract boolean rotateLeft(BinaryTreeNodeGeneric<T> node);
	
	/**
	 * rotates a tree right based on a pivot
	 * @param node - The tree node which acts as the pivot
	 * @return True upon successful rotation of the tree
	 */
	public abstract boolean rotateRight(BinaryTreeNodeGeneric<T> node);
	
	/**
	 * in-order traversal of tree
	 * @return The complete in-order traversal
	 */
	public abstract void inOrder(BinaryTreeNodeGeneric<T> treeNode);
	
	/**
	 * pre-Order traversal of tree
	 * @return The complete pre-order traversal
	 */
	public abstract void preOrder(BinaryTreeNodeGeneric<T> treeNode);
	
	/**
	 * post-order traversal of tree
	 * @return The complete post-order traversal
	 */
	public abstract void postOrder(BinaryTreeNodeGeneric<T> treeNode);
	
	/**
	 * level-order traversal of tree
	 * @return The complete level-order traversal
	 */
	public abstract void levelOrder(BinaryTreeNodeGeneric<T> treeNode);
	
	/**
	 * finds the maximum value in the tree
	 * @param root - The root node of a tree
	 * @return The value of the node with the maximum value
	 */
	public abstract T findMax(BinaryTreeNodeGeneric<T> root);

	/**
	 * finds the minimum value in the tree
	 * @param root - The root node of a tree
	 * @return The value of the node with the minimum value
	 */
	public abstract T findMin(BinaryTreeNodeGeneric<T> root);
	
	/**
	 * Traversal algorithm which visits every vertex and edge once at each level in the tree
	 * to search for a specific node
	 * @return The node which is searched for
	 */
	public abstract boolean breadthFirst (BinaryTreeNodeGeneric<T> root, T val);
	
	/**
	 * Traversal algorithm which starts at the root node and visits as far left/right in the tree before backtracking
	 * @return The node which is searched for
	 */
	public abstract boolean depthFirst (BinaryTreeNodeGeneric<T> root, T val, boolean valueFound);

	
	
	
	/*
	 * Inherited methods from TreeOpsIntGeneric which are not used
	 */
	
	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	public T rotateLeft() {
		// TODO Auto-generated method stub
		return null;
	}
	public T rotateRight() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void inOrder() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void preOrder() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void postOrder() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void levelOrder() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T rotateLeft(T data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T rotateRight(T data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		return 0;
	}
	
	@Override
	public boolean contains(T value) {
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
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
