package edu.sru.thangiah.datastructures.tree.avltree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.sru.thangiah.datastructures.tree.avltree.AvlTreeInt;

public class AvlTreeIntTest {
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
	 * Empty tree used to test for empty exceptions
	 */
	private AvlTreeInt testEmptyTree = new AvlTreeInt();
	/**
	 * Tree initialized with a few nodes to ensure proper functionality of a simple bst
	 */
	private AvlTreeInt testInitializedTree = new AvlTreeInt();
	/**
	 * Uninitialized tree which is used to test the add method
	 */
	private AvlTreeInt testAddTree = new AvlTreeInt();
	/**
	 * Single node bst
	 */
	private AvlTreeInt oneNodeTree = new AvlTreeInt();
	/**
	 * Simple tree used to test left and right rotation
	 */
	private AvlTreeInt testRotateTree = new AvlTreeInt();
	/**
	 * Tree which satisfies the rules of a complete binary tree
	 */
	private AvlTreeInt testCompleteTree = new AvlTreeInt();
	/**
	 * Tree which satisfies the rules of a full binary tree
	 */
	private AvlTreeInt testFullTree = new AvlTreeInt();
	/**
	 * Binary tree which has all right children
	 */
	private AvlTreeInt testRightLeaningTree = new AvlTreeInt();
	/**
	 * Binary tree which has all left children
	 */
	private AvlTreeInt testLeftLeaningTree = new AvlTreeInt();
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to initialize standard output to our ByteArrayStream custom output stream
	 */
	
	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(captureOutputStream));
		testInitializedTree.add(100);
		testInitializedTree.add(80);
		testInitializedTree.add(120);
		testInitializedTree.add(90);
		testInitializedTree.add(75);
		
		oneNodeTree.add(100);
		
		testCompleteTree.add(100);
		testCompleteTree.add(80);
		testCompleteTree.add(120);
		testCompleteTree.add(90);
		testCompleteTree.add(75);
		testCompleteTree.add(110);
		
		testFullTree.add(100);
		testFullTree.add(80);
		testFullTree.add(120);
		testFullTree.add(90);
		testFullTree.add(75);
		testFullTree.add(110);
		testFullTree.add(130);
		
		testRightLeaningTree.add(100);
		testRightLeaningTree.add(110);
		testRightLeaningTree.add(120);
		testRightLeaningTree.add(130);

		testLeftLeaningTree.add(100);
		testLeftLeaningTree.add(90);
		testLeftLeaningTree.add(80);
		testLeftLeaningTree.add(70);
	}

	@AfterEach
	public void tearDown()
	{
		System.setOut(standardOut);
		testInitializedTree.clear();
		oneNodeTree.clear();
		testCompleteTree.clear();
		testFullTree.clear();
		testRightLeaningTree.clear();
		testLeftLeaningTree.clear();
	}
	
	@Test
	void testNodeCount() {
		assertEquals(0, testEmptyTree.nodeCount());
		assertEquals(1, oneNodeTree.nodeCount());
		assertEquals(5, testInitializedTree.nodeCount());
		assertEquals(6, testCompleteTree.nodeCount());
		assertEquals(7, testFullTree.nodeCount());
		assertEquals(4, testRightLeaningTree.nodeCount());
		assertEquals(4, testLeftLeaningTree.nodeCount());
	}
	
	@Test
	void testCheckBalance() {
		assertEquals(0, oneNodeTree.checkBalance(oneNodeTree.getRoot()));
		assertEquals(1, testInitializedTree.checkBalance(testInitializedTree.getRoot()));
		assertEquals(0, testCompleteTree.checkBalance(testCompleteTree.getRoot()));
		assertEquals(0, testFullTree.checkBalance(testFullTree.getRoot()));
		assertEquals(-1, testRightLeaningTree.checkBalance(testRightLeaningTree.getRoot()));
		assertEquals(1, testLeftLeaningTree.checkBalance(testLeftLeaningTree.getRoot()));
	}
	
	@Test
	void testCheckHeight() {
		assertEquals(1, oneNodeTree.height(oneNodeTree.getRoot()));
		assertEquals(3, testInitializedTree.height(testInitializedTree.getRoot()));
		assertEquals(3, testCompleteTree.height(testCompleteTree.getRoot()));
		assertEquals(3, testFullTree.height(testFullTree.getRoot()));
		assertEquals(3, testRightLeaningTree.height(testRightLeaningTree.getRoot()));
		assertEquals(3, testLeftLeaningTree.height(testLeftLeaningTree.getRoot()));
		
	}
	

}
