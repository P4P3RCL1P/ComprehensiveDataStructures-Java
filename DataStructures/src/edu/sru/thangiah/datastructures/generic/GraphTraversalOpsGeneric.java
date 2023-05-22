package edu.sru.thangiah.datastructures.generic;

public interface GraphTraversalOpsGeneric <T> {

	/**
	 * Traversal algorithm which visits every vertex and edge once at each level in the tree
	 * to search for a specific node
	 * @return The node which is searched for
	 */
	public void breadthFirst ();
	
	/**
	 * Traversal algorithm which starts at the root node and visits as far left/right in the tree before backtracking
	 * @return The node which is searched for
	 */
	public void depthFirst ();
}
