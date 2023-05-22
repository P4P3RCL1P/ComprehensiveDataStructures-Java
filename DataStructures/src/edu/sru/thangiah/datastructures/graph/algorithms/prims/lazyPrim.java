package edu.sru.thangiah.datastructures.graph.algorithms.prims;

import edu.sru.thangiah.datastructures.generic.linkedlist.*;
import edu.sru.thangiah.datastructures.graph.GraphClass;
import edu.sru.thangiah.datastructures.graph.GraphEdge;
import edu.sru.thangiah.datastructures.graph.GraphNode;


/**
* <p>Title: lazyPrim</p>
*
* <p>Description: </p>
* 
* Creates a list of edges used for a minimum spanning tree of a graph, using Prim's algorithm
*
*
* @author Sam R. Thangiah
*
* @version 1.0
*/

public class lazyPrim {
	
	public static void lazyPrimTree(String start, GraphClass graph)
	{
		//int numEdges = graphEdges.size();
		//int edgeCount = 0;
		double cost = 0;
		SingleLinkedListGeneric<GraphNode> visitedNodes = new SingleLinkedListGeneric<GraphNode>(); //keeps track of all nodes visited
		SingleLinkedListGeneric<GraphEdge> finalEdges = new SingleLinkedListGeneric<GraphEdge>(); //the final list of edges
		
		GraphEdge selectedEdge = new GraphEdge();
		GraphNode startNode = new GraphNode(start);
		boolean isVisited = false;
		visitedNodes.addLast(startNode);
		
		while(visitedNodes.size() != graph.getNodeList().size()) //loops until all nodes are visited
		{
			SingleLinkedListGeneric<GraphEdge> selectedEdges = new SingleLinkedListGeneric<GraphEdge>(); //edges that are potentially used
			SingleLinkedListGeneric<GraphEdge> finalSelectedEdges = new SingleLinkedListGeneric<GraphEdge>(); //edges that are picked based on size
			double minPath = 1000000;
			//keep adding nodes until all nodes visited
			//System.out.println(selectedEdges.size() +"FIRST");
			for(int i = 1; i <= visitedNodes.size(); i++) //cycle through all current nodes
			{
				//System.out.println(visitedNodes.getAtIndex(i).getName());
				for(int j = 1; j <= graph.getEdgeList().size(); j++)//cycle through all edges
				{
					//System.out.printf(visitedNodes.getAtIndex(i).getName());
					//System.out.printf(graphEdges.getAtIndex(j).getSource().getName());
					//System.out.println();
					
					if(visitedNodes.getAtIndex(i).getName().compareTo(graph.getEdgeList().getAtIndex(j).getSource().getName()) == 0) //if the source of the edge is the same as a visited node
					{
						//System.out.printf("Made");
						GraphEdge currentEdge = graph.getEdgeList().getAtIndex(j); //selects the current edge
						
						if(!selectedEdges.contains(currentEdge)) //checks to make sure the edge is not already picked
						{
							//System.out.println(currentEdge.getSource().getName() + ":" + currentEdge.getDest().getName());
							selectedEdges.addLast(graph.getEdgeList().getAtIndex(j)); //adds to the selected edges
						}
					}
				}
			}
			
			//System.out.println(selectedEdges.size() +"SECOND");
			
			for(int i = 1; i <= selectedEdges.size(); i++) //this just goes through to check the edge list and if the edge is in the list then remove it
			{
				for(int j = 1; j <= visitedNodes.size(); j++)
				{
					//if(selectedEdges.getAtIndex(i).getDest().getName() == visitedNodes.getAtIndex(j).getName())
					if((selectedEdges.getAtIndex(i).getDest().getName().compareTo(visitedNodes.getAtIndex(j).getName())) == 0) //compares the selected edges to the visited nodes
					{
						//selectedEdges.removeAtIndex(i); //remove the edge at the index i
						//j--;
						isVisited = true; //if it is already visited
					}
				}
				
				if(isVisited == true) //if visited, set to false and move on
				{
	                //System.out.println("Size: " + selectedEdges.size());
					//selectedEdges.removeAtIndex(i); //remove the edge at the index i\
					//System.out.println("New Size: " + selectedEdges.size());
					isVisited = false;
					//i--;
				}
				else //else add to the final selected edges
				{
					finalSelectedEdges.addLast(selectedEdges.getAtIndex(i));
				}
			}
			
			//System.out.println(selectedEdges.size() +"THIRD");
			
			//now we have edges that we can check through to find the smallest one, all going to non traversed nodes
			
			for(int i = 1; i <= finalSelectedEdges.size(); i++) //for every edge find the smallest edge distance
			{
				//System.out.println(selectedEdges.getAtIndex(i).getSource().getName());
				if(finalSelectedEdges.getAtIndex(i).getWeight() <= minPath) //take the minimum of all edges and select it
				{
					minPath = finalSelectedEdges.getAtIndex(i).getWeight();
					selectedEdge = finalSelectedEdges.getAtIndex(i);
				}
			}
			
			//now that we should have the selectedEdge equal to the minimum distance edge possible...
			
			finalEdges.addLast(selectedEdge); //add the edge
			visitedNodes.addLast(selectedEdge.getDest()); //mark that destination as visited
			cost += selectedEdge.getWeight(); //add to the cost
		}
		
		//print statements
		System.out.println();
		System.out.println();
		System.out.println("Prim's Algorithm Results: ");
		System.out.println("Cost: " + cost);
		System.out.println("---------------------");
		
		for(int i = 1; i <= finalEdges.size(); i++) //cycle through all current nodes
		{
			System.out.print(finalEdges.getAtIndex(i).getSource().getName() + " -- " + finalEdges.getAtIndex(i).getDest().getName() + " : " + finalEdges.getAtIndex(i).getWeight());
			System.out.println();
		}
	}
	
	
	public static void main(String[] args)
	{
		GraphClass primGraph = new GraphClass();
	    primGraph.addNode("1");
	    primGraph.addNode("2");
	    primGraph.addNode("3");
	    primGraph.addNode("4");
	    primGraph.addNode("5");
	       
	    primGraph.addEdge("1","2", 2);
	    primGraph.addEdge("1","3", 3);
	    primGraph.addEdge("2","3", 2);
	    primGraph.addEdge("2","5", 5);
	    primGraph.addEdge("3","4", 1);
	    primGraph.addEdge("3","5", 1);
	    primGraph.addEdge("2","1", 2);
	    primGraph.addEdge("3","1", 3);
	    primGraph.addEdge("3","2", 2);
	    primGraph.addEdge("5","2", 5);
	    primGraph.addEdge("4","3", 1);
	    primGraph.addEdge("5","3", 1);
	       
	    lazyPrimTree("2", primGraph);
	}
}
