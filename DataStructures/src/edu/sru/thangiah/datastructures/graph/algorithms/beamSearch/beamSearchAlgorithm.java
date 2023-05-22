package edu.sru.thangiah.datastructures.graph.algorithms.beamSearch;

import edu.sru.thangiah.datastructures.generic.linkedlist.SingleLinkedListGeneric;
import edu.sru.thangiah.datastructures.graph.GraphClass;
import edu.sru.thangiah.datastructures.graph.GraphEdge;
import edu.sru.thangiah.datastructures.graph.GraphNode;

/**
* <p>Title: beamSearchAlgorithm</p>
*
* <p>Description: </p>
* 
* Creates a list of edges for multiple paths from a starting point to a goal point
* Number of paths is determined by the "width" creating a limited discrepancy
*
*
* @author Sam R. Thangiah
*
* @version 1.0
*/

public class beamSearchAlgorithm {
	public static void beamSearch(String startNode, String goalNode, int width, GraphClass graph) {
		//lets start with sorted list of edges
		//pulling from that will work well to find shortest paths
		SingleLinkedListGeneric<GraphEdge> finalEdges = new SingleLinkedListGeneric<GraphEdge>();
		SingleLinkedListGeneric<GraphEdge> sortedEdges = new SingleLinkedListGeneric<GraphEdge>();
		SingleLinkedListGeneric<GraphEdge> recentEdges = new SingleLinkedListGeneric<GraphEdge>();
		SingleLinkedListGeneric<GraphNode> visitedNodes = new SingleLinkedListGeneric<GraphNode>();
		SingleLinkedListGeneric<GraphNode> optionNodes = new SingleLinkedListGeneric<GraphNode>();
		GraphEdge initialEdges[] = new GraphEdge[graph.getEdgeList().size()];
		GraphNode start = new GraphNode(startNode);
		boolean isOpen = true;
		boolean isDuplicate = false;
		boolean isVisited = false;
		int grabbedEdges = 0;
		
		for(int i = 0; i < initialEdges.length; i++)
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
        
        for(int i = 0; i < initialEdges.length; i++)
		{
			//System.out.println(initialEdges[i].getDist());
			sortedEdges.addLast(initialEdges[i]);
		}
        
        initialEdges = null; //get rid of stinky array, use linked lists only!
        
        //we will use Kruskal's bubble sorting of edges to get sortedEdges linked list
        
        //in order to traverse nodes, have additional set of nodes for the options
        visitedNodes.addLast(start);
        optionNodes.addLast(start);
        
        //now we look at the edges from each of those option nodes
        //cycle through our sorted edges, and if they match, grab them until we grab WIDTH amount of edges
        //if a 
        System.out.println("Starting beam search with width of " + width);
        while(width >= 0)
        {
        	for(int i = 1; i <= sortedEdges.size(); i++)
        	{
        		for(int j = 1; j <= optionNodes.size(); j++)
            	{
        			//System.out.println(sortedEdges.getAtIndex(i).getSource().getName()+ ":"+optionNodes.getAtIndex(j).getName());
            		if(sortedEdges.getAtIndex(i).getSource().getName().compareTo(optionNodes.getAtIndex(j).getName()) == 0) //if the current edges' source comes from an option node
            		{
            			for(int k = 1; k <= visitedNodes.size(); k++) //check if the destination is already visited
            			{
            				//System.out.println("CHECKING EDGE: " + sortedEdges.getAtIndex(i).getSource().getName() + " to "+ sortedEdges.getAtIndex(i).getDest().getName());
            				if((visitedNodes.getAtIndex(k).getName().compareTo(sortedEdges.getAtIndex(i).getDest().getName()) == 0)) //if the node is visited, then it isn't open
            				{
            					isOpen = false;
            				}
            			}
            			
            			if(isOpen == true) //if it stays open, add it
            			{
            				//System.out.println("Adding edge: " + sortedEdges.getAtIndex(i).getSource().getName() + " to "+ sortedEdges.getAtIndex(i).getDest().getName());
            				finalEdges.addLast(sortedEdges.getAtIndex(i));
                			recentEdges.addLast(sortedEdges.getAtIndex(i));
                			grabbedEdges++;
                			isOpen = false;
            			}
            			else //reset boolean trigger
            			{
            				isOpen = true;
            			}
            			
            			if(grabbedEdges >= width) //once we reach the width treshhold, stop grabbing paths
            			{
            				break;
            			}
            		}
            	}
        		if(grabbedEdges >= width)
    			{
    				break;
    			}
        	}
        	//System.out.println("Exiting grab loop");
        	grabbedEdges = 0; //reset loop variables
        	optionNodes.clear();
        	
        	
        	for(int i = 1; i <= recentEdges.size(); i++) //checking for duplicates
        	{
        		for(int j = 1; j <= optionNodes.size(); j++)
        		{
        			if((optionNodes.getAtIndex(j).getName().compareTo(recentEdges.getAtIndex(i).getDest().getName()) == 0))
        			{
        				isDuplicate = true; //mark duplicate if found
        			}
        		}
        		
        		if(isDuplicate == false)
        		{
        			//System.out.println("Adding node to options Nodes: " + recentEdges.getAtIndex(i).getDest().getName());
    				optionNodes.addLast(recentEdges.getAtIndex(i).getDest()); //if not found, add it to option nodes
        		}
        		else
        		{
        			isDuplicate = false;
        		}
        	}
        	
        	
        	
        	for(int i = 1; i <= finalEdges.size(); i++)
        	{
        		if(finalEdges.getAtIndex(i).getDest().getName().compareTo(goalNode) == 0)
        		{
        			width--; //if a goal node is found, cut down the width
        		}
        		
        		for(int j = 1; j <= visitedNodes.size(); j++)
        		{
        			if((visitedNodes.getAtIndex(j).getName().compareTo(finalEdges.getAtIndex(i).getDest().getName()) == 0))
        	        {
        				isVisited = true; //if the node is already marked, break loop
        				break;
        	        }
        		}
        		
        		if(isVisited == false && finalEdges.getAtIndex(i).getDest().getName().compareTo(goalNode) != 0) //if it isn't marked as visited, add it to list
        		{
        			//System.out.println("Adding node to visited list: " + finalEdges.getAtIndex(i).getDest().getName());
    	        	visitedNodes.addLast(finalEdges.getAtIndex(i).getDest());
        		}
        		else
        		{
        			isVisited = false;
        		}
        	}
        	
        }
        
		System.out.println();
		System.out.println("Beam Search Results: ");
		System.out.println("---------------------");
        
		for(int i = 1; i <= finalEdges.size(); i++) //cycle through all current nodes
		{
			System.out.print(finalEdges.getAtIndex(i).getSource().getName() + " -- " + finalEdges.getAtIndex(i).getDest().getName() + " : " + finalEdges.getAtIndex(i).getWeight());
			System.out.println();
		}
		
		System.out.println();
        
	}
	
	public static void main(String[] args)
	{
		GraphClass beamGraph = new GraphClass();
		beamGraph.addNode("1");
		beamGraph.addNode("2");
		beamGraph.addNode("3");
	    beamGraph.addNode("4");
	    beamGraph.addNode("5");
	       
	    beamGraph.addEdge("1","2", 2);
	    beamGraph.addEdge("1","3", 3);
	    beamGraph.addEdge("2","3", 2);
	    beamGraph.addEdge("2","5", 5);
	    beamGraph.addEdge("3","4", 1);
	    beamGraph.addEdge("3","5", 1);
	    beamGraph.addEdge("2","1", 2);
	    beamGraph.addEdge("3","1", 3);
	    beamGraph.addEdge("3","2", 2);
	    beamGraph.addEdge("5","2", 5);
	    beamGraph.addEdge("4","3", 1);
	    beamGraph.addEdge("5","3", 1);
	       
	    beamSearch("1", "5", 2, beamGraph);
	}
}
