package edu.sru.thangiah.datastructures.graph;

import edu.sru.thangiah.datastructures.GraphTraversalOps;

//import edu.sru.thangiah.datastructures.BaseOpsInt;
/**
 * <p>Title: AbstractGraph</p>
 *
 * <p>Description: </p>
 * Abstract template used for the creation of a graph datastructure. 
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractGraph implements GraphTraversalOps{
	
	
	abstract public boolean isEmptyNode();
	
	abstract public boolean isEmptyEdge();
	
	abstract public boolean containsNode(String node);
	
	abstract public boolean containsEdge(String srcNode, String destNode, double weight);
	
	abstract public int sizeNode();
	
	abstract public int sizeEdge();
	
	/**
	 * Takes a label for the node-to-be-added and inserts it into the graph
	 * @param name - The label for the new graph node
	 * @return True upon successful method call
	 */
	abstract public boolean addNode(String name);
	
	/**
	 * Takes a node label and removes it from the graph so long as it existed
	 * @param name - The label of the node to be removed
	 * @return True upon successful method call
	 */
	abstract public boolean removeNode(String name);
	
	/**
	 * Adds an edge between two nodes (source and destination) with a given weight for the edge
	 * @param sourceNode - The node which will point towards the destination
	 * @param destNode - The node which the source node is pointing towards
	 * @param dist - The weight for the edge
	 * @return - True upon successful method call
	 */
	abstract public boolean addEdge(String sourceNode, String destNode, double dist);
	
	/**
	 * Removes an edge from the graph so long as it existed
	 * @param nodeIndex - The index of the node which is to be removed
	 * @return True upon successful completion of the method call
	 */
	abstract public boolean removeEdge(String sourceNode, String destNode, double weight);
	
	//traversal methods
	abstract public void breadthFirst(String start);
	
	abstract public void depthFirst(String start);
	
	
	
	//Methods inherited but not used
	@Override
	public void breadthFirst() {
		// TODO Auto-generated method stub
	}

	@Override
	public void depthFirst() {
		// TODO Auto-generated method stub
	}


	
}
