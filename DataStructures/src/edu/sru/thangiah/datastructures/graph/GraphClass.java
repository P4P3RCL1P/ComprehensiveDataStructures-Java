package edu.sru.thangiah.datastructures.graph;

import java.util.*;

import edu.sru.thangiah.datastructures.generic.linkedlist.*;
import edu.sru.thangiah.datastructures.generic.queue.*;
import edu.sru.thangiah.datastructures.generic.stack.StackArrayGeneric;

/**
* <p>Title: GraphClass</p>
*
* <p>Description: </p>
* 
* Graph Class that allows addition of nodes for the graph, as well as edges
* Basic boolean methods and getters for lists that are used in graph algorithms
*
*
* @author Sam R. Thangiah
*
* @version 1.0
*/


public class GraphClass extends AbstractGraph {
	
	private SingleLinkedListGeneric <GraphNode> graphNodes;
	private SingleLinkedListGeneric <GraphEdge> graphEdges;
	private SingleLinkedListGeneric <GraphNode> adjacencyList;
	private SingleLinkedListGeneric <GraphNode> steinerAdjacencyList;
	private SingleLinkedListGeneric <GraphEdge> edgeList;
	
	private StackArrayGeneric <GraphNode> graphStack; 
	private QueueArrayGeneric <GraphNode> graphQueue;
	
	public GraphClass()
	{
		graphNodes = new SingleLinkedListGeneric<GraphNode>();
		graphEdges = new SingleLinkedListGeneric<GraphEdge>();
		graphStack = new StackArrayGeneric<GraphNode>();
		graphQueue = new QueueArrayGeneric<GraphNode>();
	}
	
	@Override
	public boolean isEmptyNode() //checks if node list is empty
	{
		if(graphNodes.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isEmptyEdge() //checks if edge list is empty
	{
		if(graphEdges.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean containsNode(String node) //check if a node exists
	{
		for(int i = 1; i <= graphNodes.size(); i++)
		{
			if(graphNodes.getAtIndex(i).getName().compareTo(node) == 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean containsEdge(String srcNode, String destNode, double weight) //checks if an edge exists
	{
		for(int i = 1; i <= graphNodes.size(); i++)
		{
			if(graphEdges.getAtIndex(i).getSource().getName().compareTo(srcNode) == 0 && graphEdges.getAtIndex(i).getDest().getName().compareTo(destNode) == 0 && graphEdges.getAtIndex(i).getWeight() == weight)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void clear() //clears both the node and edge list
	{
		graphNodes.clear();
		graphEdges.clear();
	}
	
	//getters for all lists
	public SingleLinkedListGeneric<GraphNode> getNodeList()
	{
		return graphNodes;
	}
	
	public SingleLinkedListGeneric<GraphEdge> getEdgeList()
	{
		return graphEdges;
	}
	
	public SingleLinkedListGeneric<GraphNode> getAdjList()
	{
		return adjacencyList;
	}
	
	public SingleLinkedListGeneric<GraphNode> getSteinerList()
	{
		return steinerAdjacencyList;
	}
	
	public StackArrayGeneric<GraphNode> getGraphStack()
	{
		return graphStack;
	}
	
	public QueueArrayGeneric<GraphNode> getGraphQueue()
	{
		return graphQueue;
	}
	
	@Override
	public int sizeNode()
	{
		return graphNodes.size();
	}
	
	@Override
	public int sizeEdge()
	{
		return graphEdges.size();
	}
	
	@Override
	public boolean addNode(String name) { //adds a node to the graph
		GraphNode temp;
		temp = new GraphNode(name);
		for(int i = 1; i <= graphNodes.size(); i++)
		{
			if(graphNodes.getAtIndex(i).getName().compareTo(name) == 0)
			{
				System.out.println("Node already exists for addition");
				return false;
			}
		}
		graphNodes.addLast(temp);
		return true;
	}

	@Override
	public boolean removeNode(String name) { //method to remove a node from the graph
		for(int i = 1; i <= graphNodes.size(); i++)
		{
			if(graphNodes.getAtIndex(i).getName() == name)
			{
				graphNodes.removeAtIndex(i);
				
				for(int j = 1; j <= graphEdges.size(); j++) //if the node is being removed, remove all associated edges as well
				{
					if(graphEdges.getAtIndex(i).getSource().getName().compareTo(name) == 0 || graphEdges.getAtIndex(i).getDest().getName().compareTo(name) == 0)
					{
						graphEdges.removeAtIndex(i);
					}
				}
				
				return true;
			}
		}
		System.out.println("Node does not exist for removal");
		return false;
	}

	public GraphNode getNode(String name)
	{
		for (int i=1; i<=graphNodes.size(); i++)
		{
			if(graphNodes.getAtIndex(i).getName() == name)
			{
				return graphNodes.getAtIndex(i);
			}
		}
		return null;
	}
	
	@Override
	public boolean addEdge(String sourceNode, String destNode, double weight) {
		
		GraphNode tempSource = null;
		GraphNode tempDest = null;
		GraphEdge temp;

		for(int i = 1; i <= graphNodes.size(); i++)
		{
			if(graphNodes.getAtIndex(i).getName() == sourceNode)
			{
				tempSource = graphNodes.getAtIndex(i);
			}
			
			if(graphNodes.getAtIndex(i).getName()  == destNode)
			{
				tempDest = graphNodes.getAtIndex(i);
			}
		}
		
		temp = new GraphEdge(tempSource, tempDest, weight);
		
		for(int i = 1; i <= graphEdges.size(); i++)
		{
			if(graphEdges.getAtIndex(i).getSource().getName() == sourceNode)
			{
				if(graphEdges.getAtIndex(i).getDest().getName() == destNode)
				{
					if(graphEdges.getAtIndex(i).getWeight() == weight)
					{
						System.out.println("Edge already exists for addition");
						return false;
					}
				}
			}
		}
		
		if(tempSource == null || tempDest == null)
		{
			System.out.println("Source or destination doesn't exist");
			return false;
		}
		
		graphEdges.addLast(temp);
		
		return true;
	}
	
	@Override
	public boolean removeEdge(String sourceNode, String destNode, double weight) {
		for(int i = 1; i <= graphEdges.size(); i++)
		{
			if(graphEdges.getAtIndex(i).getSource().getName() == sourceNode)
			{
				if(graphEdges.getAtIndex(i).getDest().getName() == destNode)
				{
					if(graphEdges.getAtIndex(i).getWeight() == weight)
					{
						graphEdges.removeAtIndex(i);
						return true;
					}
				}
			}
		}
		System.out.println("Node doesn't exist");
		return false;
	}
	
	public SingleLinkedListGeneric<GraphNode> getAdjacentNodes(String sourceNode)
	{
		adjacencyList = new SingleLinkedListGeneric<GraphNode>();

		for(int i = 1; i <= graphEdges.size(); i++)
		{
			if(graphEdges.getAtIndex(i).getSource().getName() == sourceNode)
			{
				adjacencyList.addLast(graphEdges.getAtIndex(i).getDest());
			}
		}
		return adjacencyList;
	}
	
	public void printAdjacentNodes(String sourceNode)
	{
		adjacencyList = new SingleLinkedListGeneric<GraphNode>();
		GraphNode source = getNode(sourceNode);
		
		for(int i = 1; i <= graphEdges.size(); i++)
		{
			if(graphEdges.getAtIndex(i).getSource().getName() == sourceNode)
			{
				adjacencyList.addLast(graphEdges.getAtIndex(i).getDest());
			}
		}
		System.out.println();
		System.out.print("Node " + source.getName() + " has adjacenct nodes ");
		for(int j = 1; j<=adjacencyList.size(); j++)
		{
			System.out.print(adjacencyList.getAtIndex(j).getName() + " ");
		}
	}
	
	/**
	 * Displays a gui representation of the graph
	 */
	public void printGraph()  {
        for(int i = 1; i <= graphEdges.size(); i++)
        {
        	System.out.println("Source: " + graphEdges.getAtIndex(i).getSource().getName() + " : Destination: " 
        + graphEdges.getAtIndex(i).getDest().getName() + " : Weight: " + graphEdges.getAtIndex(i).getWeight());
        }
    }
	
	@Override
	public void breadthFirst(String start) { //breadth first traversal
		if(getNode(start) == null || graphNodes.size() == 0)
		{
			throw new NoSuchElementException();
		}
		//Set a new boolean linked list to store whether we have traversed through the given node yet o
		SingleLinkedListGeneric<Integer> traversed  = new SingleLinkedListGeneric<Integer>();
		
		//initialize all elements in list storing traversed nodes as -1 (not visited)
		for(int i = 0; i< graphNodes.size(); i++)
		{
			traversed.addLast(-1);
		}
		//Add the first node to the queue
		graphQueue.enQueue(getNode(start));
		//An empty queue means no more nodes to traverse through :(
		while(!graphQueue.isEmpty())
		{
			//set variable to store dequeue'd value
			GraphNode current = graphQueue.deQueue();
			//print the value of the dequeue'd node
			System.out.print(current.getName() + " ");
			//get all the adjacent nodes for the current node
			adjacencyList = getAdjacentNodes(current.getName());
			
			//find the index of the node in the adjacency list
			for(int j = 1; j<=adjacencyList.size(); j++)
			{
				int traversedIndex = 0;
				//iterate through the graph nodes for comparison
				for(int l = 1; l<=graphNodes.size(); l++)
				{
					//Test for if the current node equals the node in the adjacency list
					if(graphNodes.getAtIndex(l) == adjacencyList.getAtIndex(j))
					{
						traversedIndex = l;
					}
				}
				//a value of -1 means we haven't visited the node yet.
				if(traversed.getAtIndex(traversedIndex) == -1 )
				{
					//A value of 0 means we have partially traversed through the given node
					traversed.setAtIndex(traversedIndex, 0);
					
					//make sure that the value hasn't already been searched for
					if(!graphQueue.contains(adjacencyList.getAtIndex(j)))
					{
						graphQueue.enQueue(adjacencyList.getAtIndex(j));
					}
				}
			}
			//set a value of -1  for nodes that we've completely visited (no more adjacent nodes)
			for(int k = 1; k<= graphNodes.size(); k++)
			{
				if(graphNodes.getAtIndex(k).getName() == current.getName())
				{
					//A value of 1 means we have completely visited this node
					traversed.setAtIndex(k, 1);
				}
			}
		}
		graphQueue.clear();
	}

	@Override
	public void depthFirst(String start) { //depth first traversal
		
		if(getNode(start) == null || graphNodes.size() == 0)
		{
			throw new NoSuchElementException();
		}
		//Set a new boolean linked list to store whether we have traversed through the given node yet o
		SingleLinkedListGeneric<Integer> traversed  = new SingleLinkedListGeneric<Integer>();

		//initialize all elements in list storing traversed nodes as -1 (not visited)
		for(int i = 0; i< graphNodes.size(); i++)
		{
			traversed.addLast(-1);
		}
		//Add the first node to the stack
		graphStack.push(getNode(start));
		//An empty stack means no more nodes to traverse through :(
		while(!graphStack.isEmpty())
		{
			//set variable to store dequeue'd value
			GraphNode current = graphStack.pop();
			//print the value of the dequeue'd node
			System.out.print(current.getName() + " ");
			//get all the adjacent nodes for the current node
			adjacencyList = getAdjacentNodes(current.getName());
			//find the index of the node in the adjacency list
			for(int j = 1; j<=adjacencyList.size(); j++)
			{
				int traversedIndex = 0;
				//iterate through the graph nodes for comparison
				for(int l = 1; l<=graphNodes.size(); l++)
				{
					//Test for if the current node equals the node in the adjacency list
					if(graphNodes.getAtIndex(l) == adjacencyList.getAtIndex(j))
					{
						traversedIndex = l;
					}
				}
				//a value of -1 means we haven't visited the node yet.
				if(traversed.getAtIndex(traversedIndex) == -1 )
				{
					//A value of 0 means we have partially traversed through the given node
					traversed.setAtIndex(traversedIndex, 0);
					//make sure that the value hasn't already been searched for

					graphStack.push(adjacencyList.getAtIndex(j));
				}
			}
			//set a value of -1  for nodes that we've completely visited (no more adjacent nodes)
			for(int k = 1; k<= graphNodes.size(); k++)
			{
				if(graphNodes.getAtIndex(k).getName() == current.getName())
				{
					//A value of 1 means we have completely visited this node
					traversed.setAtIndex(k, 1);
				}
			}
		}
		graphStack.clear();
	}
	
	public static void main(String[] args)
	{
		GraphClass graph = new GraphClass();
		
		graph.addNode("one");
		graph.addNode("one");
		graph.addNode("two");
		graph.addNode("three");
		graph.addNode("four");
		
		
		
		System.out.println(graph.containsNode("one"));
		graph.printGraph();
		
	}
}
