package edu.sru.thangiah.datastructures.generic.tree.redblacktree;

import edu.sru.thangiah.datastructures.generic.TreeOpsGeneric;

/**
 * <p>Title: AbstractRedBlackTreeGeneric </p>
 *
 * <p>Description: </p>
 * Template for the structure of a generic Red Black tree implementation
 * Note that a Red Black Tree tree is a self-balancing tree which checks the colors of the nodes in the subtrees to ensure equal distancing of nodes and minimal search time
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractRedBlackTreeGeneric <T> implements TreeOpsGeneric <T> {
	
	//unitilized
	public int size(){
			return -1;
	}
	
	/**
	 * method used to check if the tree is empty
	 */
	public abstract boolean isEmpty();

	//unitilized
	public boolean isFull() {
		return false;
	}

	/**
	 * method used to empty out the tree
	 */
	public abstract boolean clear();

	/**
	 * method used to check if the tree contains T value
	 */
	public abstract boolean contains(T value);

	/**
	 * method used to add T value to the tree
	 */
	abstract public boolean add(T value);

	//unutilized
	public T indexOf(int value) 
	{
		return null;
	}

	/**
	 * method used to check the height of the rb tree
	 */
	public abstract int height();

	/**
	 * method that returns an int value of the number of nodes in the tree
	 */
	public abstract int nodeCount();

	/**
	 * method that is used like add to insert the value into the tree
	 */
	public abstract boolean insert(T value);
	
	/**
	 * method used to remove a T removeValue from the tree
	 */
	public abstract T remove(T removeValue);

	/**
	 * method used to find T searchValue in the tree
	 */
	public abstract T search(T searchValue);
	
	/**
	 * method used to find the max of the tree
	 */
	public abstract T findMax();
	
	/**
	 * method used to find the min of the tree
	 */
	public abstract T findMin();
	
	/**
	 * method used to detect the degree of a specified node
	 * @param node
	 * @return int degree 
	 */
	public abstract int degree(RedBlackTreeNodeGeneric<T> node);
	
	/**
	 * returns true if all the levels in the tree are completely filled except the lowest one, which is filled from the left
	 */
	public abstract boolean isComplete();
	
	/**
	 * returns true if not all the levels in the tree are completely filled 
	 */
	public abstract boolean isIncomplete();
	
	/**
	 * checks if the given node is the root node of the tree
	 * @param node
	 * @return true if the value == root
	 */
	public abstract boolean isRoot(RedBlackTreeNodeGeneric<T> node);
	
	/**
	 * checks if the given node is a parent
	 * @param node
	 * @return true if the value has child nodes
	 */
	public abstract boolean isParent(RedBlackTreeNodeGeneric<T> node);
	
	/**
	 * checks if the given node is a child node
	 * @param node
	 * @return true if the node has a parent and is not the root
	 */
	public abstract boolean isChild(RedBlackTreeNodeGeneric<T> node);
	
	/**
	 * checks if the given node is a leaf node and has no children
	 * @param node
	 * @return true if the node has no children
	 */
	public abstract boolean isLeaf(RedBlackTreeNodeGeneric<T> node);

	/**
	 * used to rotate the node left, by taking the parent and making it the left child of the right child
	 * @param node (parent)
	 * @return true upon successful completion
	 */
	public abstract boolean rotateLeft(RedBlackTreeNodeGeneric<T> node);
		
	/**
	 * used to rotate the node right, by taking the parent and making it the right child of the left child
	 * @param node (parent)
	 * @return true upon successful completion
	 */
	public abstract boolean rotateRight(RedBlackTreeNodeGeneric<T> node);


}
