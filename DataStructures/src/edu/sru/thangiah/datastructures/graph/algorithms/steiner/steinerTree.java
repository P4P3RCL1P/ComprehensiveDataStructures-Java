package edu.sru.thangiah.datastructures.graph.algorithms.steiner;

import edu.sru.thangiah.datastructures.generic.linkedlist.SingleLinkedListGeneric;
import edu.sru.thangiah.datastructures.graph.GraphClass;
import edu.sru.thangiah.datastructures.graph.GraphNode;
import edu.sru.thangiah.datastructures.graph.algorithms.dijkstra.dijkstraSearch;

/**
* <p>Title: steinerTree</p>
*
* <p>Description: </p>
* 
* Constructs a Steiner tree used for calculating the shortest path between two vertices. 
* Starting with a subtree consisting of one terminal vertex, the algorithm loops through the 
* subtree checking if the vertex does not span all the terminal vertices. 
* If it doesn't then we select a terminal vertex not in the subtree which is closest to the terminal vertex and add it to the shortest path subtree.
*
*
* @author Sam R. Thangiah
*
* @version 1.0
*/

public class steinerTree {
	
	public static void steiner(SingleLinkedListGeneric<String> terminals, GraphClass graph) {
		if(terminals.size() <= 1)
		{
			throw new IllegalStateException();
		}
		
		dijkstraSearch dijkstra = new dijkstraSearch();
		GraphClass steinerTree = new GraphClass();
		GraphNode current = null;
		double totalDistance = 0.0;
		SingleLinkedListGeneric<GraphNode> steinerAdjacencyList = graph.getSteinerList();
		for (int i=1; i<=terminals.size(); i++)
		{

			steinerAdjacencyList = graph.getAdjacentNodes(terminals.getAtIndex(i));
			for(int j = 1; j<=graph.getNodeList().size(); j++)
			{
				if(terminals.isEmpty())
				{
					break;
				}
				if(graph.getNodeList().getAtIndex(j).getName() == terminals.getAtIndex(i))
				{
					steinerTree.addNode(graph.getNodeList().getAtIndex(j).getName());
					current = graph.getNodeList().getAtIndex(j);
					terminals.removeAtIndex(i);
				}
	
				double minPath = Double.POSITIVE_INFINITY;
				GraphNode nextGraphNode = null;
				for(int k = 1; k<=steinerAdjacencyList.size(); k++)
				{
					System.out.println("Steiner Tree is now:" );
					double distance = dijkstra.dijkstra(current.getName(), steinerAdjacencyList.getAtIndex(k).getName(), graph);
					/*if(k == terminals.size())
					{
						nextGraphNode = steinerAdjacencyList.getAtIndex(k);
						totalDistance += distance;
						terminals.removeAtIndex(i);
						break;
					}*/
					if(steinerAdjacencyList.contains(graph.getNode(terminals.getAtIndex(i))) && steinerAdjacencyList.size() > 1)
					{
						steinerAdjacencyList.removeAtIndex(k);
						distance = dijkstra.dijkstra(current.getName(), steinerAdjacencyList.getAtIndex(k).getName(), graph);
						totalDistance += distance;
						nextGraphNode = steinerAdjacencyList.getAtIndex(k);
						minPath = distance;
	
					}
					if(steinerAdjacencyList.getAtIndex(k).getName() == terminals.getAtIndex(i))
					{
						terminals.removeAtIndex(i);
					}
					if(minPath == Double.POSITIVE_INFINITY)
					{
						nextGraphNode = steinerAdjacencyList.getAtIndex(k);
						minPath = distance;
						totalDistance += distance;
						break;
					}
					else if(minPath > distance)
					{
						nextGraphNode = steinerAdjacencyList.getAtIndex(k);
						minPath = distance;
						totalDistance += distance;
						break;
					}
				}
				if(!steinerAdjacencyList.isEmpty())
				{
					steinerTree.addNode(nextGraphNode.getName());
					steinerTree.addEdge(current.getName(), nextGraphNode.getName(), minPath);
					current = nextGraphNode;
					steinerAdjacencyList = graph.getAdjacentNodes(current.getName());
				}
			}
		}
		System.out.println("Minimum Distance of Total Steiner Tree: " + totalDistance);
	}
	
	public static void main(String[] args)
	{
		GraphClass steinerGraph = new GraphClass();
		steinerGraph.addNode("1");
		steinerGraph.addNode("2");
		steinerGraph.addNode("3");
		steinerGraph.addNode("4");
		steinerGraph.addNode("5");
	       //graph.removeNode("1");
	       
		steinerGraph.addEdge("1","2", 5);
		steinerGraph.addEdge("1","3", 7);
		steinerGraph.addEdge("2","3", 1);
		steinerGraph.addEdge("3","4", 13);
		steinerGraph.addEdge("4","5", 6);
	    
	       SingleLinkedListGeneric<String> terminals = new SingleLinkedListGeneric<String>();
	       terminals.addLast("1");
	       terminals.addLast("2");
	       terminals.addLast("5");
	       
	    steiner(terminals, steinerGraph);
	}
}
