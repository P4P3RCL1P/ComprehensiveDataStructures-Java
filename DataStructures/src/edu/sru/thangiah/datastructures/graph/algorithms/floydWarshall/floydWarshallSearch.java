package edu.sru.thangiah.datastructures.graph.algorithms.floydWarshall;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.matrix.MatrixClassGeneric;
import edu.sru.thangiah.datastructures.graph.GraphClass;
import edu.sru.thangiah.datastructures.graph.GraphNode;

/**
* <p>Title: floydWarshallSearch</p>
*
* <p>Description: </p>
* 
* Shortest path algorithm which finds the shortest path for every 
* pair of vertices in a given edge weighted directed Graph.
*
*
* @author Sam R. Thangiah
*
* @version 1.0
*/

public class floydWarshallSearch {
	
	public static void floydWarshall(GraphClass graph) {
		//override for if method is called with empty graph
		if(graph.getNodeList().size() == 0)
		{
			throw new NoSuchElementException();
		}
		//used for intializing shortest path matrix
		final int TOTALVERTICES =  graph.getNodeList().size();
		//Stores the shortest path between all vertices and each other
		MatrixClassGeneric<Double> distances = new MatrixClassGeneric<Double>(TOTALVERTICES+1, TOTALVERTICES+1);
		
		//start by initializing the shortest path for the target nodes.
		//Each vertex is initialized at index distances[i][i] so we
		//should set their distance value to 0.0
		for (int i = 1; i<=TOTALVERTICES; i++ )
		{
			distances.setData(i, i, 0.0);
		}
		//loop through the total number of vertices
		for (int k =1; k<=graph.getEdgeList().size(); k++)
		{
			int sourceIndex = 0;
			int destIndex  = 0;
			//get the edge at the given index and set pointers to the source & destination
			GraphNode dest = graph.getEdgeList().getAtIndex(k).getDest();
			GraphNode source = graph.getEdgeList().getAtIndex(k).getSource();
			
			//set the indices for the source and destination, since they could be
			//letters instead of numbers
			for(int j = 1; j<=graph.getNodeList().size(); j++)
			{
				if(source == graph.getNodeList().getAtIndex(j))
				{
					sourceIndex = j;
				}
				if(dest == graph.getNodeList().getAtIndex(j))
				{
					destIndex = j;
				}
			}
			//set the distance between the two nodes in the distances matrix
			distances.setData(sourceIndex, destIndex, graph.getEdgeList().getAtIndex(k).getWeight());
		}
		

        
		//Have three loops for the row, column, and next column in order to perform the comparison
		for(int l = 1; l<=TOTALVERTICES; l++)
		{
			for(int o =1; o<=TOTALVERTICES; o++)
			{
				for(int u = 1; u<=TOTALVERTICES; u++)
				{
					//compare if the distances are all initialized, and if so see if the current distance is larger
					//than the calculated distance between the two new distances. If it is larger then swap the old value
					//with the new value, meaning that we now have a new shortest path.
					if(distances.getData(o, u) != null && distances.getData(o, l) != null && distances.getData(l, u) != null)
					{
						if(distances.getData(o, u) > distances.getData(o, l) + distances.getData(l, u))
						{
							distances.setData(o, u, distances.getData(o, l) + distances.getData(l, u));
						}
					}
					//if the current distance value at the given index is uninitialized, then any value we put in there
					//is going to be the shortest path, so initialize the index
					else if (distances.getData(o, u) == null && distances.getData(o, l) != null && distances.getData(l, u) != null)
					{
						distances.setData(o, u, distances.getData(o, l) + distances.getData(l, u));
					}
				}
			}
		}
		
		
		//print the shortest path matrix to console
		System.out.println("Floyd-Warshall Shortest Path Matrix:");
        for (int i = 1; i <= 5; i++)
        {
            // Loop through all elements of current row
            for (int j = 1; j <= 5; j++)
                System.out.print(distances.getData(i, j) + " ");
            System.out.println();
        }
        	 

		
	}
	
	public static void main(String[] args)
	{
		GraphClass floydGraph = new GraphClass();
		floydGraph.addNode("1");
		floydGraph.addNode("2");
		floydGraph.addNode("3");
		floydGraph.addNode("4");
		floydGraph.addNode("5");
	       
		floydGraph.addEdge("1","2", 2);
		floydGraph.addEdge("1","3", 3);
		floydGraph.addEdge("2","3", 2);
		floydGraph.addEdge("2","5", 5);
		floydGraph.addEdge("3","4", 1);
		floydGraph.addEdge("3","5", 1);
		floydGraph.addEdge("2","1", 2);
		floydGraph.addEdge("3","1", 3);
	    floydGraph.addEdge("3","2", 2);
	    floydGraph.addEdge("5","2", 5);
	    floydGraph.addEdge("4","3", 1);
	    floydGraph.addEdge("5","3", 1);
	       
	    floydWarshall(floydGraph);
	}
}
