package edu.sru.thangiah.datastructures.generic.tree.redblacktree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.sru.thangiah.datastructures.generic.tree.redblacktree.*;

public class RedBlackTreeGenericTest {

	
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
	 * Tree initialized with a few nodes to ensure proper functionality of a simple bst
	 */
	private RedBlackTreeGeneric <Integer> testInitializedTree = new RedBlackTreeGeneric<Integer>();
	/**
	 * Tree which satisfies the rules of a complete binary tree
	 */
	private RedBlackTreeGeneric <Float> testCompleteTree = new RedBlackTreeGeneric<Float>();
	/**
	 * Tree which satisfies the rules of a full binary tree
	 */
	private RedBlackTreeGeneric <Double> testFullTree = new RedBlackTreeGeneric<Double>();
	/**
	 * Uninitialized tree which is used to test the add method
	 */
	private RedBlackTreeGeneric testAddTree = new RedBlackTreeGeneric();
	/**
	 * Empty tree used to test for empty exceptions
	 */
	private RedBlackTreeGeneric testEmptyTree = new RedBlackTreeGeneric();
	/**
	 * Single node bst
	 */
	private RedBlackTreeGeneric oneNodeTree = new RedBlackTreeGeneric();
	/**
	 * Simple tree used to test left and right rotation
	 */
	private RedBlackTreeGeneric testRotateTree = new RedBlackTreeGeneric();
	/**
	 * Binary tree which has all right children
	 */
	private RedBlackTreeGeneric <String> testRightLeaningTree = new RedBlackTreeGeneric<String>();
	/**
	 * Binary tree which has all left children
	 */
	private RedBlackTreeGeneric <Integer> testLeftLeaningTree = new RedBlackTreeGeneric();
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to intialize standard output to our ByteArrayStream custom output stream
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(captureOutputStream));
		//Integer bst
		testInitializedTree.add(80);
		testInitializedTree.add(75);
		testInitializedTree.add(90);
		testInitializedTree.add(100);
		testInitializedTree.add(120);
		
		//complete bst
		testCompleteTree.add(120.1f);
		testCompleteTree.add(110.2f);
		testCompleteTree.add(100.1f);
		testCompleteTree.add(90f);
		testCompleteTree.add(80.1f);
		testCompleteTree.add(75.1f);
		
		//Double bst
		testFullTree.add(80.1);
		testFullTree.add(110.1);
		testFullTree.add(90.1);
		testFullTree.add(100.1);
		testFullTree.add(75.1);
		testFullTree.add(120.1);
		testFullTree.add(130.1);
		
		testRightLeaningTree.add("a");
		testRightLeaningTree.add("b");
		testRightLeaningTree.add("c");
		testRightLeaningTree.add("d");

		
		testLeftLeaningTree.add(100);
		testLeftLeaningTree.add(90);
		testLeftLeaningTree.add(80);
		testLeftLeaningTree.add(70);
		
		//one node bst
		oneNodeTree.add(100);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(standardOut);
		testInitializedTree.clear();
		testCompleteTree.clear();
		testFullTree.clear();
		testRightLeaningTree.clear();
		testLeftLeaningTree.clear();
		oneNodeTree.clear();
	}


	@org.junit.jupiter.api.Test
	void testNodeCount() {
		assertEquals(0, testEmptyTree.nodeCount());
		assertEquals(5, testInitializedTree.nodeCount());
		assertEquals(6, testCompleteTree.nodeCount());
		assertEquals(7, testFullTree.nodeCount());
		assertEquals(1, oneNodeTree.nodeCount());
		assertEquals(4, testRightLeaningTree.nodeCount());
		assertEquals(4, testLeftLeaningTree.nodeCount());
	}
	
	@org.junit.jupiter.api.Test
	void testHeight() {
		assertEquals(testInitializedTree.height(testInitializedTree.getRoot()),3);
		assertEquals(testCompleteTree.height(testCompleteTree.getRoot()),4);
		assertEquals(testFullTree.height(testFullTree.getRoot()),4);
		assertEquals(testLeftLeaningTree.height(testLeftLeaningTree.getRoot()),3);
		assertEquals(testRightLeaningTree.height(testRightLeaningTree.getRoot()),3);
		
	}
	
	@org.junit.jupiter.api.Test
	void testRoots() {
		assertEquals(testInitializedTree.getRoot().getData(),80);
		assertEquals(testFullTree.getRoot().getData(),90.1);
		assertEquals(testLeftLeaningTree.getRoot().getData(),90);
		assertEquals(testRightLeaningTree.getRoot().getData(),"b");
	}
	
	@org.junit.jupiter.api.Test
	void testRootColors() {
		assertTrue(testInitializedTree.getRoot().getColor());
		assertTrue(testFullTree.getRoot().getColor());
		assertTrue(testLeftLeaningTree.getRoot().getColor());
		assertTrue(testRightLeaningTree.getRoot().getColor());
	}
	

	
}
