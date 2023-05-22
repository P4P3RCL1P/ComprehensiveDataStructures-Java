package edu.sru.thangiah.datastructures.generic;

import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;

/**
 * <p>Title: TreeSearchOpsGeneric</p>
 *
 * <p>Description: </p>
 * TreeSearchOps interface class.
 * We use this interface class to store all the search algorithms which can be utilized in a tree structure
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public interface TreeSearchOpsGeneric <T> extends TreeOpsGeneric<T> {
	/**
	 * Traversal algorithm which visits every vertex and edge once at each level in the tree
	 * to search for a specific node
	 * @return The node which is searched for
	 */
	public boolean breadthFirst ();
	
	/**
	 * Traversal algorithm which starts at the root node and visits as far left/right in the tree before backtracking
	 * @return The node which is searched for
	 */
	public boolean depthFirst ();
}
