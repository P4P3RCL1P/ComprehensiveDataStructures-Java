package edu.sru.thangiah.datastructures.graph.algorithms.kruskal;

import edu.sru.thangiah.datastructures.generic.linkedlist.SingleLinkedListGeneric;
import edu.sru.thangiah.datastructures.graph.GraphClass;
import edu.sru.thangiah.datastructures.graph.GraphEdge;
import edu.sru.thangiah.datastructures.graph.GraphNode;

/**
* <p>Title: kruskalTree</p>
*
* <p>Description: </p>
* 
* Creates a list of edges used for a minimum spanning tree of a graph, using Kruskal's algorithm
*
*
* @author Sam R. Thangiah
*
* @version 1.0
*/

public class kruskalTree {
	public static void kruskal(GraphClass graph) {
		//Kruskal literally just sorts the edges by distance
		//after sorting by distance, iterate through the list of sorted edges
		//if it doesn't create a cycle, add it to the final edges
		
		SingleLinkedListGeneric<GraphEdge> finalEdges = new SingleLinkedListGeneric<GraphEdge>();
		SingleLinkedListGeneric<GraphEdge> sortedEdges = new SingleLinkedListGeneric<GraphEdge>();
		SingleLinkedListGeneric<GraphNode> visitedNodes = new SingleLinkedListGeneric<GraphNode>();
		double cost = 0;
		GraphEdge initialEdges[] = new GraphEdge[graph.getEdgeList().size()];
		boolean isVisited = false;
		boolean isLoop = false;
		
		for(int i = 0; i < initialEdges.length; i++) //creates a sortable array of edges
		{
			initialEdges[i] = graph.getEdgeList().getAtIndex(i+1);
		}
		
		int numSorted = 0; // number of values in order
        int index; // general index
        while (numSorted < initialEdges.length) {
            // bubble a large element to higher array index
            for (index = 1; index < initialEdges.length - numSorted; index++) {
                if (initialEdges[index - 1].getWeight() > initialEdges[index].getWeight()) {
                	GraphEdge temp;
                    temp = initialEdges[index-1];
                    initialEdges[index-1] = initialEdges[index];
                    initialEdges[index] = temp;
                }
            }
            // at least one more value in place
            numSorted++;
        }
        
        for(int i = 0; i < initialEdges.length; i++) //puts our stinky array back into linked list
		{
			//System.out.println(initialEdges[i].getDist());
			sortedEdges.addLast(initialEdges[i]);
		}
        
        initialEdges = null; //get rid of stinky array, use linked lists only!
        
        for(int i = 1; i <= sortedEdges.size(); i++) //loops through the sorted edges
        {
        	//current edge is the minimum
        	//check to see if adding this will create a cycle by adding it, and if so remove it
        	for(int j = 1; j <= visitedNodes.size(); j++)
        	{
        		if((sortedEdges.getAtIndex(i).getDest().getName().compareTo(visitedNodes.getAtIndex(j).getName()) == 0)) //if the node is visited
        		{
        			isVisited = true; //if the node is visited, mark that it shouldn't be added
        		}
        	}
        	
        	for(int j = 1; j <= finalEdges.size(); j++)
        	{
        		if((sortedEdges.getAtIndex(i).getSource().getName().compareTo(finalEdges.getAtIndex(j).getDest().getName()) == 0) && (sortedEdges.getAtIndex(i).getDest().getName().compareTo(finalEdges.getAtIndex(j).getSource().getName()) == 0)) //if the node is visited
        		{
        			isLoop = true; //if the node is visited, mark that it shouldn't be added
        		}
        	}
        	
        	if(isVisited == false && isLoop == false) //if it isn't visited, add it and make sure it is marked as visited
        	{
        		
        		finalEdges.addLast(sortedEdges.getAtIndex(i));
        		visitedNodes.addLast(sortedEdges.getAtIndex(i).getDest());
        		cost += sortedEdges.getAtIndex(i).getWeight();
        	}
        	else //reset boolean trigger
			{
				isVisited = false;
				isLoop = false;
			}
        }
        
        //print statements for final output
        System.out.println();
		System.out.println("Kruskal's Algorithm Results: ");
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
		GraphClass kruskalGraph = new GraphClass();
		kruskalGraph.addNode("1");
		kruskalGraph.addNode("2");
		kruskalGraph.addNode("3");
		kruskalGraph.addNode("4");
		kruskalGraph.addNode("5");
	       
		kruskalGraph.addEdge("1","2", 2);
		kruskalGraph.addEdge("1","3", 3);
		kruskalGraph.addEdge("2","3", 2);
		kruskalGraph.addEdge("2","5", 5);
		kruskalGraph.addEdge("3","4", 1);
		kruskalGraph.addEdge("3","5", 1);
		kruskalGraph.addEdge("2","1", 2);
		kruskalGraph.addEdge("3","1", 3);
	    kruskalGraph.addEdge("3","2", 2);
	    kruskalGraph.addEdge("5","2", 5);
	    kruskalGraph.addEdge("4","3", 1);
	    kruskalGraph.addEdge("5","3", 1);
	       
	    kruskal(kruskalGraph);
	}
}
