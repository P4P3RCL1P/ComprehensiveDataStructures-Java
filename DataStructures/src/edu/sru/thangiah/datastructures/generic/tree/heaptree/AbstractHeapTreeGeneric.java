package edu.sru.thangiah.datastructures.generic.tree.heaptree;

import edu.sru.thangiah.datastructures.generic.TreeOpsGeneric;
import edu.sru.thangiah.datastructures.generic.TreeTraversalOpsGeneric;
import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;
import edu.sru.thangiah.datastructures.generic.TreeSearchOpsGeneric;

/**
 * <p>Title: AbstractHeapTreeGeneric</p>
 *
 * <p>Description: </p>
 * Abstract class used as a template for implementation of a min/max heap tree
 *
 * Note that since heap trees are self-balancing any insertion/deletion causes the heap tree to
 * sift up or sift down the values in the tree. Because this structure works in a similar manner as
 * a sorting algorithm we allow the user to call the printSortedArray method which sorts the tree and
 * prints it out in a readible format.
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractHeapTreeGeneric <T extends Comparable <T>> implements TreeOpsGeneric <T>, TreeTraversalOpsGeneric <T>, TreeSearchOpsGeneric<T> {
	//Returns the height (total levels) in the tree
	public abstract int height();
	//Returns the count of nodes in the tree
	public abstract int nodeCount();
	
	/**
	 * returns the total number of children for a given node
	 * @param treeNode - the given node within the tree/subtree which we are trying to find the degree of
	 * @return the number of children for a given node
	 */
	public abstract int degree(HeapTreeNodeGeneric<T> treeNode);
	

	/**
	 * Evaluates if the given node is the root node (no parent)
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is the root node (no parent)
	 */
	public abstract boolean isRoot(HeapTreeNodeGeneric<T> treeNode);

	/**
	 * Evaluates if the given node is a parent node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isParent(HeapTreeNodeGeneric<T> treeNode);

	/**
	 * Evaluates if the given node is a child node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a child node
	 */
	public abstract boolean isChild(HeapTreeNodeGeneric<T> treeNode);
	
	/**
	 * Evaluates if the given node is a leaf node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isLeaf(HeapTreeNodeGeneric<T> treeNode);
	
	//Similar to insert method where we add a value to the tree structure
	public abstract boolean add(T value);
	
	//similar to add which inserts a node following the tree structure
	public abstract boolean insert(T value);
	
	/**
	 * Finds the node which is the last leaf in the tree structure
	 * @return The node which is the last leaf in the tree structure
	 */
	public abstract HeapTreeNodeGeneric<T> findLastLeaf();

	//locates a node to be removed given the value parmater and removes it
	//returns the value of the node removed
	public abstract T remove(T value);
	
	/**
	 * similar to locateNode except does not take a BinaryTreeNode parameter
	 * @param root - The root node in the heap tree
	 * @param value - The value to be searched
	 * @return The node which contains the value searched for
	 */
	public abstract HeapTreeNodeGeneric<T> search(HeapTreeNodeGeneric<T> root,T value);
	
	/**
	 * returns the node which contains the largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the largest value in a tree
	 */
	public abstract T getLargest();
	
	/**
	 * returns the node which contains the smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the smallest value in a tree
	 */
	public abstract T getSmallest();
	
	/**
	 * Evaluates if the value passed is found in the tree
	 * @param value - The item to be searched for in the tree
	 * @return True if the value passed into the parameter is found in the tree
	 */
	public abstract boolean contains(T value);
	
	//returns true if the Heap tree is uninitialized (empty)
	public abstract boolean isEmpty();
	
	/**
	 * returns the node which contains the second largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second largest value in a tree
	 */
	public abstract HeapTreeNodeGeneric<T> getSecondLargest(HeapTreeNodeGeneric<T> root);
	
	/**
	 * returns the node which contains the second smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second smallest value in a tree
	 */
	public abstract HeapTreeNodeGeneric<T> getSecondSmallest(HeapTreeNodeGeneric<T> root);
	
	/**
	 * in-order traversal of tree
	 * @return The complete in-order traversal
	 */
	public abstract void inOrder(HeapTreeNodeGeneric<T> root);
	
	/**
	 * pre-Order traversal of tree
	 * @return The complete pre-order traversal
	 */
	public abstract void preOrder(HeapTreeNodeGeneric<T> root);
	
	/**
	 * post-order traversal of tree
	 * @return The complete post-order traversal
	 */
	public abstract void postOrder(HeapTreeNodeGeneric<T> root);
	
	/**
	 * Traversal algorithm which visits every vertex and edge once at each level in the tree
	 * to search for a specific node
	 * @return The node which is searched for
	 */
	public abstract boolean breadthFirst (HeapTreeNodeGeneric<T> root, T value);
	
	/**
	 * Traversal algorithm which starts at the root node and visits as far left/right in the tree before backtracking
	 * @return The node which is searched for
	 */
	public abstract boolean depthFirst (HeapTreeNodeGeneric<T> root, T value, boolean valueFound);
	//Methods inherited but not used
	
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
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	public void levelOrder() {
		// TODO Auto-generated method stub
	

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
	
}
