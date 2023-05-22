package edu.sru.thangiah.datastructures.tree.generaltree;

import java.util.Vector;

/**
 * <p>Title: GeneralTreeNode</p>
 *
 * <p>Description: </p>
 * Helper class to establish the nodes in a binary tree. Given that a node
 * can have zero or more children we can make use of a vector or array to store
 * the number of children for a given node.
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class GeneralTreeNode {
	/**
	 * Variable to hold the data for a given node in the general tree
	 */
	private int data;
	
	/**
	 * Pointer variable which points to the parent of a given node
	 */
	private GeneralTreeNode parent;
	
	private GeneralTreeNode leftmostChild;
	
	

	
	//edu.sru.thangiah.datastructures.vector is only for int.
	//once we develop a generic vector we may switch from using
	//Java's Vector data structure. Both will accomplish the same
	//thing.
	/**
	 * Variable to store all the children for a given node
	 * Note again that a general tree can have 0 or more children.
	 */
	private Vector<GeneralTreeNode> children;
	//private Vector<GeneralTreeNode> siblings;
	
	/**
	 * Uninitialized node which is used to test for empty conditions
	 */
	private static final GeneralTreeNode EMPTY  = new GeneralTreeNode(-1);
	
	
	GeneralTreeNode()
	{
		children = new Vector<GeneralTreeNode>();
		//siblings = new Vector<GeneralTreeNode>();
		
		this.setData(-1);
		setParent(null);
		setLeftmostChild(null);
	}
	GeneralTreeNode(int data)
	{
		children = new Vector<GeneralTreeNode>();
		//siblings = new Vector<GeneralTreeNode>();
		
		this.setData(data);
		setParent(null);
		setLeftmostChild(null);
	}
	/**
	 * Completely clears all the parameters for a given node
	 * @return True upon successful completion of the method
	 */
	public boolean clearNode()
	{
		this.setData(-1);
		this.setParent(null);
		this.setChildren(null);
		this.setLeftmostChild(null);
		return true;
	}
	/**
	 * Determines if a given node is completely uninitialized
	 * @return True if there are no attributes for a given node
	 */
	public boolean isEmpty()
	{
		if(this.getData() == -1)
		{
			return true;
		}
		return false;
	}
	/**
	 * Determines if a given node is completely uninitialized
	 * @return True if there are no attributes for a given node
	 */
	public boolean isEMPTY()
	{
		if(this == EMPTY)
		{
			return true;
		}
		return false;
	}

	/**
	 * Getter method for data variable
	 * @return The data value for a given node
	 */
	public int getData() {
		return data;
	}

	/**
	 * Setter method for a given node's data attribute
	 * @param data - The value to set the data attribute for a given node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Getter method for parent variable
	 * @return The parent value for a given node
	 */
	public GeneralTreeNode getParent() {
		return parent;
	}

	/**
	 * Setter method for parent variable 
	 * @param parent - The value to set the node's parent to
	 */
	public void setParent(GeneralTreeNode parent) {
		this.parent = parent;
	}


	/**
	 * Getter method for a node's leftmost child
	 * @return The leftmost child for a given node
	 */
	public GeneralTreeNode getLeftmostChild() {
		Vector<GeneralTreeNode> nodeChildren = new Vector<GeneralTreeNode>();
		
		nodeChildren = getChildren();
		if(nodeChildren.isEmpty())
		{
			return null;
		}
		return nodeChildren.get(0);
	}

	/**
	 * Setter method for the leftmost child variable
	 * @param leftmostChild - The value to set a node's leftmost child to
	 */
	public void setLeftmostChild(GeneralTreeNode leftmostChild) {
		this.leftmostChild = leftmostChild;
	}


	/**
	 * Getter method for the children variable 
	 * @return The children for a given node
	 */
	public Vector<GeneralTreeNode> getChildren() {
		return children;
	}


	/**
	 * Setter method for the children variable
	 * @param children - A collection of nodes which are to be set for a given node
	 */
	public void setChildren(Vector<GeneralTreeNode> children)
	{
		this.children = children;
	}
	/**
	 * Setter method for adding a child to a given node
	 * @param child - The value to set a node's next child to 
	 */
	public void addChild(GeneralTreeNode child) {
		children.add(child);
	}
	/**
	 * Deletes a given child from a node
	 * @param child - Child to be removed
	 */
	public void deleteChild(GeneralTreeNode child)
	{
		children.remove(child);
	}
	
}
