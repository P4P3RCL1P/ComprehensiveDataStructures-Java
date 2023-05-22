package edu.sru.thangiah.datastructures.graph;

/*
 * Class to create individual binary tree nodes. 
 * Note the parent, left, and right attributes which are used to link the individual nodes to the larger tree structure
 */
/**
 * <p>Title: GraphNode </p>
 *
 * <p>Description: </p>
 * Class to create individual graph nodes
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class GraphNode implements Comparable<GraphNode> {
	/**
	 * Variable to hold the data for a binary tree node
	 */
	private int data;
	
	private String name;

	private static final GraphNode EMPTY = new GraphNode(-1, "");

	public GraphNode()
	{
		this.data = -1;
		this.setName("");
	}
	
	public GraphNode(String name)
	{
		this.data = -1;
		this.setName(name);
	}
	
	public GraphNode(int data, String name)
	{
		this.data = data;
		this.setName(name);
	}
	/**
	 * Completely clears all the parameters for a given node
	 * @return True upon successful completion of the method
	 */
	public boolean clearNode()
	{
		this.data = -1;
		
		return true;
	}
	/**
	 * Determines if the data parameter is uninitialized
	 * @return True if there is no data value for a given node
	 */
	public boolean isEmpty() {
		if (this.getData() == -1)
		{
			return true;
		}
		return false;
	}
	/**
	 * Determines if a given node is completely uninitialized
	 * @return True if there are no attributes for a given node
	 */
	public boolean isEMPTY() {
		if (this == EMPTY)
		{
			return true;
		}
		return false;
	}
	/**
	 * Getter method for data variable
	 * @return The data for a given node
	 */
	public int getData() {
		return data;
	}

	/**
	 * Setter method for data variable
	 * @param data - The value to set the private data variable to
	 * @return True upon successful completion of method
	 */
	public void setData(int data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * generic comparison method for checking nodes
	 */
	@Override
	public int compareTo(GraphNode o) {
		if(this.data < o.data)
		{
			return -1;
		}
		else if(this.data > o.data) 
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}
	
}
