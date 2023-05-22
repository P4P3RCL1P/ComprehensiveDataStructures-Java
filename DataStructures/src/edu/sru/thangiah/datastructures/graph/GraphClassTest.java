package edu.sru.thangiah.datastructures.graph;

//used for assertFuzzyEquals so we can test the output of insertion
//src: https://web-cat.org/junit-quickstart/


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/*
 * JUnit class for testing methods in graph class
 */
/**
 * <p>Title: GraphClassTest</p>
 *
 * <p>Description: </p>
 * 
 * JUnit test class which houses the example single linked list data sets as well as the tested methods
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class GraphClassTest {
	
	/**standardOut simply stores the default(or "standard") output stream
	 *since we need to record the output of certain void functions we
	 *initialize a ByteArrayOutputStream to store the contents of our
	 *output in a byte array, which can then be converted to a string
	 *for comparison. Before each test we set the PrintStream to our
	 *new output, and then after each test we reinitialize it back to
	 *our default(or "standard") output
	 */
	private final PrintStream standardOut = System.out;
	/**
	 * Stores the ByteArrayOutputStream of any function that prints to console
	 */
	private final ByteArrayOutputStream captureOutputStream = new ByteArrayOutputStream();
	
	/**
	 * Empty list used to test for empty exceptions
	 */
	private GraphClass emptyGraph = new GraphClass();
	/**
	 * Initialized list with a few nodes to ensure proper functionality of a simple linked list
	 */
	private GraphClass initializedGraph = new GraphClass();
	private GraphClass oneNodeGraph = new GraphClass();
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to intialize standard output to our ByteArrayStream custom output stream
	 */
	@BeforeEach
	public void setUp()
	{
		System.setOut(new PrintStream(captureOutputStream));
		
		initializedGraph.addNode("1");
		initializedGraph.addNode("2");
		initializedGraph.addNode("3");
		initializedGraph.addNode("4");
		initializedGraph.addNode("5");
	       
		initializedGraph.addEdge("1","2", 2);
		initializedGraph.addEdge("1","3", 3);
		initializedGraph.addEdge("2","3", 2);
		initializedGraph.addEdge("2","5", 5);
		initializedGraph.addEdge("3","4", 1);
		initializedGraph.addEdge("3","5", 1);
		initializedGraph.addEdge("2","1", 2);
		initializedGraph.addEdge("3","1", 3);
		initializedGraph.addEdge("3","2", 2);
		initializedGraph.addEdge("5","2", 5);
		initializedGraph.addEdge("4","3", 1);
		initializedGraph.addEdge("5","3", 1);
		
		oneNodeGraph.addNode("single");
	}
	
	/**
	 * Resets output to standard output and clears the linked list examples
	 */
	@AfterEach
	public void tearDown()
	{
		initializedGraph.clear();
		oneNodeGraph.clear();
		emptyGraph.clear();
		System.setOut(standardOut);
	}
	
	@Test
	void addNode() {
		assertTrue(initializedGraph.addNode("6"));
		assertTrue(emptyGraph.addNode("6"));
		assertTrue(oneNodeGraph.addNode("6"));
		
		assertFalse(initializedGraph.addNode("1"));
		assertFalse(emptyGraph.addNode("6"));
		assertFalse(oneNodeGraph.addNode("single"));
	}
	
	@Test
	void removeNode() {
		assertTrue(initializedGraph.removeNode("1"));
		assertTrue(oneNodeGraph.removeNode("single"));
		
		assertFalse(initializedGraph.removeNode("doesn'texist"));
		assertFalse(oneNodeGraph.removeNode("single"));
		assertFalse(emptyGraph.removeNode("none"));
	}
	
	@Test
	void addEdge() {
		assertTrue(initializedGraph.addEdge("1", "5", 5));
		assertFalse(initializedGraph.addEdge("1", "2", 2));
		assertFalse(emptyGraph.addEdge("1", "2", 2));
		assertFalse(oneNodeGraph.addEdge("1", "2", 2));
	}
	
	@Test
	void removeEdge() {
		assertTrue(initializedGraph.removeEdge("1", "2", 2));
		assertFalse(initializedGraph.removeEdge("1", "2", 2));
		assertFalse(emptyGraph.removeEdge("1", "2", 2));
		assertFalse(oneNodeGraph.removeEdge("1", "2", 2));
	}
	
	@Test
	void isEmptyNode() {
		assertTrue(emptyGraph.isEmptyNode());
		assertFalse(oneNodeGraph.isEmptyNode());
		assertFalse(initializedGraph.isEmptyNode());
	}
	
	@Test
	void isEmptyEdge() {
		assertTrue(emptyGraph.isEmptyEdge());
		assertTrue(oneNodeGraph.isEmptyEdge());
		assertFalse(initializedGraph.isEmptyEdge());
	}
	
	@Test
	void containsNode() {
		assertTrue(initializedGraph.containsNode("1"));
		assertTrue(oneNodeGraph.containsNode("single"));
		
		assertFalse(initializedGraph.containsNode("100"));
		assertFalse(emptyGraph.containsNode("anything"));
	}
	
	@Test
	void containsEdge() {
		assertTrue(initializedGraph.containsEdge("1","2",2));
		
		assertFalse(initializedGraph.containsEdge("100","50",12));
		assertFalse(emptyGraph.containsEdge("anything","nothing",10));
	}
	
	@Test
	void sizeNode() {
		assertEquals(0,emptyGraph.sizeNode());
		assertEquals(1,oneNodeGraph.sizeNode());
		assertEquals(5,initializedGraph.sizeNode());
	}
	
	@Test
	void sizeEdge() {
		assertEquals(0,emptyGraph.sizeEdge());
		assertEquals(0,oneNodeGraph.sizeEdge());
		assertEquals(12,initializedGraph.sizeEdge());
	}
}