package edu.sru.thangiah.datastructures.tree.generaltree;

import edu.sru.thangiah.datastructures.TreeOpsInt;
import edu.sru.thangiah.datastructures.TreeSearchOps;
import edu.sru.thangiah.datastructures.TreeTraversalOps;

/*
 * General Tree data structure where each node can have 0
 * or many child nodes
 */

public abstract class AbstractGeneralTree implements TreeOpsInt, TreeTraversalOps, TreeSearchOps{

	
	/**
	 * Returns the height (total levels) in the tree
	 * @param treeNode - The node which we are trying to get the height from
	 * @return The count of total levels in the tree
	 */
	public abstract int height(GeneralTreeNode treeNode);
	
	/**
	 * Returns the count of nodes in the tree
	 * @return The total number of nodes in the tree
	 */
	@Override
	public abstract int nodeCount();
	
	/**
	 * Similar to nodeCount in returning the count of nodes in the tree
	 * @return The total number of nodes in the tree
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * returns the total number of children for a given node
	 * @param treeNode - the given node within the tree/subtree which we are trying to find the degree of
	 * @return the number of children for a given node
	 */
	public abstract int degree(GeneralTreeNode treeNode);
	/**
	 * Evaluates if the given node is the root node (no parent)
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is the root node (no parent)
	 */
	public abstract boolean isRoot(GeneralTreeNode treeNode);

	/**
	 * Evaluates if the given node is a parent node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isParent(GeneralTreeNode treeNode);

	/**
	 * Evaluates if the given node is a child node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a child node
	 */
	public abstract boolean isChild(GeneralTreeNode treeNode);

	/**
	 * Evaluates if the given node is a leaf node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isLeaf(GeneralTreeNode treeNode);
	
	/**
	 * returns the node which contains the largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the largest value in a tree
	 */
	public abstract GeneralTreeNode getLargest(GeneralTreeNode root);
	
	/**
	 * returns the node which contains the smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the smallest value in a tree
	 */
	public abstract GeneralTreeNode getSmallest(GeneralTreeNode root);
	
	/**
	 * returns the node which contains the second largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second largest value in a tree
	 */
	public abstract GeneralTreeNode getSecondLargest(GeneralTreeNode root);
	
	/**
	 * returns the node which contains the second smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second smallest value in a tree
	 */
	public abstract GeneralTreeNode getSecondSmallest(GeneralTreeNode root);
	
	/**
	 * Adds a value to a target node. The first parameter is the value to add,
	 * while the second is the target node which the new node should be added to.
	 * @param value - The item to insert into the tree as a new node
	 * @param target - The target node which will act as the parent for the new node.
	 * @return True upon successful completion of the method.
	 */
	public abstract boolean add(int value, int target);

	/**
	 * similar to add which inserts a node following the tree structure
	 * @param value - The item to insert into the tree
	 * @param target - The target node which will act as the parent for the new node.
	 * @return true upon successful completion of the method
 	 */
	public abstract int insert(int value, int target);

	/**
	 * locates a node to be removed given the value parameter and removes it
	 * @param value - The item to be removed from the tree
	 * @return the closest leaf which will replace the node to be removed. A return value of the value itself means the node was a leaf
	 */
	public abstract int remove(int value);
	
	/**
	 * similar to locateNode except does not take a BinaryTreeNode parameter
	 * @param value - The value to be searched
	 * @return The node which contains the value searched for
	 */
	public abstract GeneralTreeNode search(int value);
	
	/**
	 * Finds a given node based on the root node and value which we are searching for
	 * @param root - The root node of the tree
	 * @param data - The value which we are searching for
	 * @return The node if we have found it in the tree
	 */
	public abstract GeneralTreeNode locateNode(GeneralTreeNode root, int data);

	/**
	 * in-order traversal of tree
	 * @return The complete in-order traversal
	 */
	public abstract void inOrder(GeneralTreeNode treeNode);
	/**
	 * pre-Order traversal of tree
	 * @return The complete pre-order traversal
	 */
	public abstract void preOrder(GeneralTreeNode treeNode);
	/**
	 * post-order traversal of tree
	 * @return The complete post-order traversal
	 */
	public abstract void postOrder(GeneralTreeNode treeNode);
	/**
	 * level-order traversal of tree
	 * @return The complete level-order traversal
	 */
	public abstract void levelOrder(GeneralTreeNode treeNode);
	
	
	//Methods inherited but not used
	@Override
	public int findMax() {
		return 0;
	}

	@Override
	public int findMin() {
		return 0;
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
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIncomplete() {
		// TODO Auto-generated method stub
		return false;
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
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

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
	public boolean add(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean clear() {
		return false;
	}

	@Override
	public boolean contains(int value) {
		return false;
	}

}

