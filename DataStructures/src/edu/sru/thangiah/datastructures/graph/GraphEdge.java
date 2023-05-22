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

public class GraphEdge implements Comparable<GraphEdge>{
	/**
	 * Variable to hold the data for a binary tree node
	 */
	private double weight;
	
	private GraphNode sourceNode;
	
	private GraphNode destNode;

	public GraphEdge()
	{
		this.weight = -1;
		this.sourceNode = null;
		this.destNode = null;
	}
	
	public GraphEdge(GraphNode sourceNode, GraphNode destNode, double weight)
	{
		this.weight = weight;
		this.sourceNode = sourceNode;
		this.destNode = destNode;
	}

	public double getWeight()
	{
		return this.weight;
	}
	
	public boolean setWeight(double weight)
	{
		this.weight = weight;
		return true;
	}
	
	public GraphNode getSource()
	{
		return this.sourceNode;
	}
	
	public boolean setSource(GraphNode sourceNode)
	{
		this.sourceNode = sourceNode;
		return true;
	}
	
	public GraphNode getDest()
	{
		return this.destNode;
	}
	
	public boolean setDest(GraphNode destNode)
	{
		this.destNode = destNode;
		return true;
	}

	/**
	 * generic comparison method for checking edges
	 */
	@Override
	public int compareTo(GraphEdge o) {
		if(this.weight < o.weight)
		{
			return -1;
		}
		else if(this.weight > o.weight) 
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return String.format("%d-%d.2f", sourceNode, destNode, weight);
	}
	
}
