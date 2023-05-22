package edu.sru.thangiah.datastructures;
/**
 * <p>Title: TreeTraversalOps</p>
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

public interface TreeTraversalOps extends TreeOpsInt{
	/**
	 * in-order traversal of tree
	 * @return The complete in-order traversal
	 */
	public void inOrder ();
	
	/**
	 * pre-Order traversal of tree
	 * @return The complete pre-order traversal
	 */
	public void preOrder ();
	
	/**
	 * post-order traversal of tree
	 * @return The complete post-order traversal
	 */
	public void postOrder ();
	
	/**
	 * level-order traversal of tree
	 * @return The complete level-order traversal
	 */
	public void levelOrder ();


}
