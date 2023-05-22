package edu.sru.thangiah.datastructures;

//import edu.sru.thangiah.datastructures.graph.GraphNode;
import edu.sru.thangiah.datastructures.generic.linkedlist.SingleLinkedListGeneric;
public interface GraphSearchOps {
	/**
	 * Greedy algorithm for finding the minimum spanning tree for a given starting vertex.
	 * The algorithm maintains a list of vertices included in the tree, and those that are not
	 * Prim's algorithm then considers all the edges that connect the two sets, and picks the 
	 * minimum weight edge from these edges. After picking the edge, it moves the other 
	 * endpoint of the edge to the set containing nodes included in the minimum spanning tree
	 * 
	 * @param start - The start vertex to begin the search
	 */
	public void lazyPrim(String start);
	
	/**
	 * Shortest path algorithm that starts and a beginning vertex, considering all the
	 * adjacent vertices, and chooses the path that contains the smallest weight. This
	 * process is then continued until the destination vertex is reached, at which point
	 * the output should be the shortest path from source to destination. Our implementation
	 * outputs the shortest path from the start to all other nodes in the graph.
	 * 
	 * @param start - The start vertex to begin the search
	 */
	public void dijkstra(String start);
	
	/**
	 * Another shortest path algorithm that constructs a minimum spanning forest
	 * and finds the minimum spanning tree. 
	 */
	public void kruskal();
	/**
	 * Constructs a steiner tree used for calculating the shortest path between two vertices.
	 * Starting with a subtree consisting of one terminal vertex, the algorithm loops through
	 * the subtree checking if the vertex does not spann all the terminal vertices. If it doesn't
	 * then we select a terminal vertex not in the subtree which is closest to the terminal vertex,
	 * and add it to the shortest path subtree.
	 */
	public void steiner(SingleLinkedListGeneric<String> terminals);
	
	/**
	 * Shortest path algorithm which finds the shortest path for every pair of vertices in a given
	 * edge weighted directed Graph.
	 */
	public void floydWarshall();
	
	/**
	 * Best path algorithm that takes a set number of potential paths into consideration before deciding
	 * on a single path to take by using 2 lists. Has a starting node and an ending or goal node
	 */
	
	 public void beamSearch(String startNode, String goalNode, int width);
	

}
