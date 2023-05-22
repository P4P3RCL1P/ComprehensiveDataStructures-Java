package edu.sru.thangiah.datastructures.tree.heaptree;

import edu.sru.thangiah.datastructures.TreeOpsInt;
import edu.sru.thangiah.datastructures.TreeSearchOps;
import edu.sru.thangiah.datastructures.TreeTraversalOps;
import edu.sru.thangiah.datastructures.generic.tree.binarytree.BinaryTreeNodeGeneric;
import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;
/**
 * <p>Title: AbstractHeapTree</p>
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
public abstract class AbstractHeapTree implements TreeOpsInt, TreeTraversalOps, TreeSearchOps{
	//Returns the height (total levels) in the tree
	public abstract int height();
	//Returns the count of nodes in the tree
	public abstract int nodeCount();
	
	/**
	 * returns the total number of children for a given node
	 * @param treeNode - the given node within the tree/subtree which we are trying to find the degree of
	 * @return the number of children for a given node
	 */
	public abstract int degree(HeapTreeNode treeNode);
	
	
	//public abstract boolean isFull(HeapTreeNode treeNode);
	
	
	//public abstract boolean isComplete();

	
	//public abstract boolean isIncomplete();

	
	/**
	 * Evaluates if the given node is the root node (no parent)
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is the root node (no parent)
	 */
	public abstract boolean isRoot(HeapTreeNode treeNode);


	/**
	 * Evaluates if the given node is a parent node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isParent(HeapTreeNode treeNode);


	/**
	 * Evaluates if the given node is a child node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a child node
	 */
	public abstract boolean isChild(HeapTreeNode treeNode);

	/**
	 * Evaluates if the given node is a leaf node
	 * @param treeNode - The node in a tree or subtree which we are evaluating
	 * @return True if the given node is a parent node
	 */
	public abstract boolean isLeaf(HeapTreeNode treeNode);
	
	/**
	 * Finds the node which is the last leaf in the tree structure
	 * @return The node which is the last leaf in the tree structure
	 */
	public abstract HeapTreeNode findLastLeaf();
	
	//similar to add which inserts a node following the tree structure
	public abstract void insert(int value);
	
	//locates a node to be removed given the value parmater and removes it
	//returns the value of the node removed
	public abstract int remove(int value);
	
	/**
	 * similar to locateNode except does not take a BinaryTreeNode parameter
	 * @param root - The root node in the heap tree
	 * @param value - The value to be searched
	 * @return The node which contains the value searched for
	 */
	public abstract HeapTreeNode search(HeapTreeNode root,int value);
	
	/**
	 * returns the node which contains the largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the largest value in a tree
	 */
	public abstract int getLargest();
	
	/**
	 * returns the node which contains the smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the smallest value in a tree
	 */
	public abstract int getSmallest();
	
	/**
	 * Evaluates if the value passed is found in the tree
	 * @param value - The item to be searched for in the tree
	 * @return True if the value passed into the parameter is found in the tree
	 */
	public abstract boolean contains(int value);
	
	//Similar to insert method where we add a value to the tree structure
	public abstract boolean add(int value);
	
	//returns true if the Heap tree is uninitialized (empty)
	public abstract boolean isEmpty();
	
	/**
	 * in-order traversal of tree
	 * @return The complete in-order traversal
	 */
	public abstract void inOrder(HeapTreeNode root);
	
	/**
	 * pre-Order traversal of tree
	 * @return The complete pre-order traversal
	 */
	public abstract void preOrder(HeapTreeNode root);
	
	/**
	 * post-order traversal of tree
	 * @return The complete post-order traversal
	 */
	public abstract void postOrder(HeapTreeNode root);
	
	/**
	 * returns the node which contains the second largest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second largest value in a tree
	 */
	public abstract HeapTreeNode getSecondLargest(HeapTreeNode root);
	
	/**
	 * returns the node which contains the second smallest value
	 * @param root - The root node of a tree
	 * @return The node which contains the second smallest value in a tree
	 */
	public abstract HeapTreeNode getSecondSmallest(HeapTreeNode root);
	/**
	 * Traversal algorithm which visits every vertex and edge once at each level in the tree
	 * to search for a specific node
	 * @return The node which is searched for
	 */
	public abstract boolean breadthFirst (HeapTreeNode root, int val);
	
	/**
	 * Traversal algorithm which starts at the root node and visits as far left/right in the tree before backtracking
	 * @return The node which is searched for
	 */
	public abstract boolean depthFirst (HeapTreeNode root, int value, boolean valueFound);
	
	
	
	
	
	//methods inherited but not used
	
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
	public int insert() {
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
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIncomplete() {
		// TODO Auto-generated method stub
		return false;
	}
}
