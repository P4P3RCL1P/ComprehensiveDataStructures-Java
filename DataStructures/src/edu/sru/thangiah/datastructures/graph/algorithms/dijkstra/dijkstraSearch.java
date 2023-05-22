package edu.sru.thangiah.datastructures.graph.algorithms.dijkstra;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.linkedlist.SingleLinkedListGeneric;
import edu.sru.thangiah.datastructures.graph.GraphClass;
import edu.sru.thangiah.datastructures.graph.GraphNode;

/**
* <p>Title: dijkstraSearch</p>
*
* <p>Description: </p>
* 
* Shortest path algorithm that starts and a beginning vertex, considering all the adjacent vertices, 
* and chooses the path that contains the smallest weight. This process is then continued until the 
* destination vertex is reached, at which point the output should be the shortest path from source to 
* destination. Our implementation outputs the shortest path from the start to all other nodes in the graph.
*
*
* @author Sam R. Thangiah
*
* @version 1.0
*/

public class dijkstraSearch {
	
	public static void dijkstra(String start, GraphClass graph)
	{
		if(graph.getNode(start) == null || graph.getNodeList().size() == 0)
		{
			throw new NoSuchElementException();
		}
		final int TOTALVERTICES =  graph.getNodeList().size();
		SingleLinkedListGeneric<Double> minDistance  = new SingleLinkedListGeneric<Double>();
		SingleLinkedListGeneric <GraphNode> adjacencyList = graph.getAdjList();
		//our starting vertex is the first element in the linked list,
		//and as such the minimum distance is 0 for this vertex. All other
		//vertices are initialized with a large value since their weight
		//at the current time is unknown
		for (int i = 1; i<=TOTALVERTICES; i++)
		{
			//since graphNodes is identical to minDistance,
			//if the current index at graphnodes test equals
			//the start value, we add a weight of 0.
			if(graph.getNodeList().getAtIndex(i)== graph.getNode(start))
			{
				minDistance.addLast(0.0);
			}
			else
			{
				//initialize all other vertices
				//with a large number (largest int value)
				//(we could also use Doubles since Infinity
				//is expressed as NaN)
				minDistance.addLast(Double.POSITIVE_INFINITY);
			}
		}
		//Use a stack to quickly fetch adjacent nodes/vertices
		graph.getGraphStack().push(graph.getNode(start));
		//end the search when there are no more nodes to calculate distances for
		while(!graph.getGraphStack().isEmpty())
		{
			//initialize pointer for getting adjacent nodes
			GraphNode current = graph.getGraphStack().pop();
			
			//Fetch adjacent nodes for the current popped value
			adjacencyList = graph.getAdjacentNodes(current.getName());
			
			//iterate through the adjacency list, calculating the distance from
			//the current node and the element traversed through in the adjacencyList
			for(int j = 1; j<= adjacencyList.size(); j++)
			{
				int traversedIndex = 0;
				Double vertexWeight = 0.0;
				GraphNode source = null;
				int sourceIndex = 0;

				//Get the edge for the current node and the element traversed through
				//in the adjacencyList
				for(int m = 1; m<=graph.getEdgeList().size(); m++)
				{
					//Condition for finding the edge we're searching for
					if(graph.getEdgeList().getAtIndex(m).getSource() == current && graph.getEdgeList().getAtIndex(m).getDest() == adjacencyList.getAtIndex(j))
					{
						vertexWeight = graph.getEdgeList().getAtIndex(m).getWeight();
						
						//used later for getting the index of the source node
						source = graph.getEdgeList().getAtIndex(m).getSource();
					}	
				}
				//iterate through the graph nodes to be able to quickly
				//update and add to the minDistance linked list
				for(int l = 1; l<=graph.getNodeList().size(); l++)
				{
					//Test for if the current node equals the node in the adjacency list
					if(graph.getNodeList().getAtIndex(l) == adjacencyList.getAtIndex(j))
					{
						traversedIndex = l;
					}
					//Test for if the current node equals the source node set in
					//the previous loop
					if(graph.getNodeList().getAtIndex(l) == source)
					{
						sourceIndex = l;
					}
				}
				//Push all the adjancent nodes into the stack for future iteration
				graph.getGraphStack().push(adjacencyList.getAtIndex(j));
			
				//Now calculate the minDistance from the weight
				
				//condition for uninitialized minDistance
				if(minDistance.getAtIndex(traversedIndex) == Double.POSITIVE_INFINITY)
				{
					//condition for when the source node is the starting node
					if(minDistance.getAtIndex(sourceIndex) == 0.0)
					{
						minDistance.setAtIndex(traversedIndex, vertexWeight);
					}
					//calculate new weight by adding the previous weights plus
					//the weight for the new node
					else
					{
						Double newWeight = vertexWeight + minDistance.getAtIndex(sourceIndex);
						minDistance.setAtIndex(traversedIndex, newWeight);
					}
				}
				//minDistance has already been calculated for the given node,
				//so we must compare and see if the new calculated distance
				//is less than the initialized value in our minDistance list.
				else 
				{
					Double newWeight = vertexWeight + minDistance.getAtIndex(sourceIndex);
					if(newWeight < minDistance.getAtIndex(traversedIndex))
					{
						minDistance.setAtIndex(traversedIndex, newWeight);
					}
				}
			}
		}
		//Print out the minimum distances from the source to each node in
		//the graph. A value of infinity means that the graph is directed in
		//a manner where the starting vertex can't access that particular vertex
		System.out.println("Dijkstra's Shortest Path from " + start + " To all Other Vertices");
		for (int k = 1; k <= graph.getNodeList().size(); k++)
		{
			if(graph.getNodeList().getAtIndex(k) != graph.getNode(start))
			{
				System.out.println("Minimum Distance from " 
							   	+ start
							   	+ " to " + graph.getNodeList().getAtIndex(k).getName()
							   	+ ": " + minDistance.getAtIndex(k));
			}
		}
		graph.getGraphStack().clear();
	}
	
	public static Double dijkstra(String start, String end, GraphClass graph)
	{
		if(graph.getNode(start) == null || graph.getNode(end) == null || graph.getNodeList().size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		final int TOTALVERTICES =  graph.getNodeList().size();
		SingleLinkedListGeneric<Double> minDistance  = new SingleLinkedListGeneric<Double>();
		SingleLinkedListGeneric<GraphNode> parents = new SingleLinkedListGeneric<GraphNode>();
		SingleLinkedListGeneric <GraphNode> adjacencyList = graph.getAdjList();
		//our starting vertex is the first element in the linked list,
		//and as such the minimum distance is 0 for this vertex. All other
		//vertices are initialized with a large value since their weight
		//at the current time is unknown
		for (int i = 1; i<=TOTALVERTICES; i++)
		{
			//since graphNodes is identical to minDistance,
			//if the current index at graphnodes test equals
			//the start value, we add a weight of 0.
			if(graph.getNodeList().getAtIndex(i)== graph.getNode(start))
			{
				minDistance.addLast(0.0);
				parents.addLast(null);
			}
			else
			{
				//initialize all other vertices
				//with a large number (largest int value)
				//(we could also use Doubles since Infinity
				//is expressed as NaN)
				minDistance.addLast(Double.POSITIVE_INFINITY);
				parents.addLast(null);
			}
		}
		//Use a stack to quickly fetch adjacent nodes/vertices
		graph.getGraphStack().push(graph.getNode(start));
		//end the search when there are no more nodes to calculate distances for
		while(!graph.getGraphStack().isEmpty())
		{
			//initialize pointer for getting adjacent nodes
			GraphNode current = graph.getGraphStack().pop();
			
			//Fetch adjacent nodes for the current popped value
			adjacencyList = graph.getAdjacentNodes(current.getName());
			
			//iterate through the adjacency list, calculating the distance from
			//the current node and the element traversed through in the adjacencyList
			for(int j = 1; j<= adjacencyList.size(); j++)
			{
				int traversedIndex = 0;
				Double vertexWeight = 0.0;
				GraphNode source = null;
				int sourceIndex = 0;

				//Get the edge for the current node and the element traversed through
				//in the adjacencyList
				for(int m = 1; m<=graph.getEdgeList().size(); m++)
				{
					//Condition for finding the edge we're searching for
					if(graph.getEdgeList().getAtIndex(m).getSource() == current && graph.getEdgeList().getAtIndex(m).getDest() == adjacencyList.getAtIndex(j))
					{
						vertexWeight = graph.getEdgeList().getAtIndex(m).getWeight();
						
						//used later for getting the index of the source node
						source = graph.getEdgeList().getAtIndex(m).getSource();
	
					}	
				}
				//iterate through the graph nodes to be able to quickly
				//update and add to the minDistance linked list
				for(int l = 1; l<=graph.getNodeList().size(); l++)
				{
					//Test for if the current node equals the node in the adjacency list
					if(graph.getNodeList().getAtIndex(l) == adjacencyList.getAtIndex(j))
					{
						traversedIndex = l;
					}
					//Test for if the current node equals the source node set in
					//the previous loop
					if(graph.getNodeList().getAtIndex(l) == source)
					{
						sourceIndex = l;
					}
				}
				//Push all the adjancent nodes into the stack for future iteration
				graph.getGraphStack().push(adjacencyList.getAtIndex(j));
			
				//Now calculate the minDistance from the weight
				
				//condition for uninitialized minDistance
				if(minDistance.getAtIndex(traversedIndex) == Double.POSITIVE_INFINITY)
				{
					//condition for when the source node is the starting node
					if(minDistance.getAtIndex(sourceIndex) == 0.0)
					{
						minDistance.setAtIndex(traversedIndex, vertexWeight);
					}
					//calculate new weight by adding the previous weights plus
					//the weight for the new node
					else
					{
						Double newWeight = vertexWeight + minDistance.getAtIndex(sourceIndex);
						minDistance.setAtIndex(traversedIndex, newWeight);
						//parents.addAtIndex(traversedIndex, graph.getNodeList().getAtIndex(traversedIndex));
					}
				}
				//minDistance has already been calculated for the given node,
				//so we must compare and see if the new calculated distance
				//is less than the initialized value in our minDistance list.
				else 
				{
					Double newWeight = vertexWeight + minDistance.getAtIndex(sourceIndex);
					if(newWeight < minDistance.getAtIndex(traversedIndex))
					{
						minDistance.setAtIndex(traversedIndex, newWeight);
						//parents.addAtIndex(traversedIndex, graph.getNodeList().getAtIndex(traversedIndex));
					}
				}
			}
		}
		for (int k = 1; k <= graph.getNodeList().size(); k++)
		{
			if(graph.getNodeList().getAtIndex(k) != graph.getNode(start) && graph.getNodeList().getAtIndex(k) == graph.getNode(end))
			{
				System.out.print("Minimum distance: " + minDistance.getAtIndex(k) + " Nodes: ");
				for(int l = 1; l<=k; l++)
				{
					System.out.print( graph.getNodeList().getAtIndex(l).getName() + " ");
				}
				System.out.println();
				graph.getGraphStack().clear();
				return minDistance.getAtIndex(k);
			}

		}
		graph.getGraphStack().clear();
		return Double.POSITIVE_INFINITY;
	}
	
	public static void main(String[] args)
	{
		GraphClass dijkstraGraph = new GraphClass();
		dijkstraGraph.addNode("1");
		dijkstraGraph.addNode("2");
		dijkstraGraph.addNode("3");
		dijkstraGraph.addNode("4");
		dijkstraGraph.addNode("5");
	       //graph.removeNode("1");
	       
		dijkstraGraph.addEdge("1","2", 5);
		dijkstraGraph.addEdge("1","3", 7);
		dijkstraGraph.addEdge("2","3", 1);
		dijkstraGraph.addEdge("3","4", 13);
		dijkstraGraph.addEdge("4","5", 6);
	       
	    System.out.println();

	    dijkstra("1", dijkstraGraph);
	       
	    System.out.println();
	       
	    System.out.println(dijkstra("1", "4", dijkstraGraph));
	    System.out.println();
	}
}
