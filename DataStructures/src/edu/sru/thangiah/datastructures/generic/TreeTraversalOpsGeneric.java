package edu.sru.thangiah.datastructures.generic;
/**
 * <p>Title: TreeTraversalOpsGeneric</p>
 *
 * <p>Description: </p>
 * TreeTraversalOps interface class.
 * We use this interface class to store all the traversal strategies which can be utilized in a tree structure
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public interface TreeTraversalOpsGeneric <T> extends TreeOpsGeneric <T> {
	/**
	 * in-order traversal of tree
	 */
	public void inOrder ();
	
	/**
	 * pre-Order traversal of tree
	 */
	public void preOrder ();
	
	/**
	 * post-order traversal of tree
	 */
	public void postOrder ();
	
	/**
	 * level-order traversal of tree
	 */
	public void levelOrder ();
}
