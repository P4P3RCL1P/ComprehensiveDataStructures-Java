
package edu.sru.thangiah.datastructures.tree.generaltree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * <p>Title: GeneralTreeTest</p>
 *
 * <p>Description: </p>
 * JUnit class to test the methods and store the example data sets which are used for testing.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */


public class GeneralTreeTest {

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
	private GeneralTree testEmptyTree = new GeneralTree();
	/**
	 * Tree initialized with a few nodes to ensure proper functionality of a simple general tree
	 */
	private GeneralTree testInitializedTree = new GeneralTree();
	/**
	 * Uninitialized tree which is used to test the add method
	 */
	private GeneralTree testAddTree = new GeneralTree();
	/**
	 * Single node general tree
	 */
	private GeneralTree oneNodeTree = new GeneralTree();

	/**
	 * Binary tree which has all left children
	 */
	private GeneralTree testAllOneChildTree = new GeneralTree();
	@Test
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to intialize standard output to our ByteArrayStream custom output stream
	 */
	@BeforeEach
	public void setUp()
	{
		testInitializedTree.add(10,-1);
		testInitializedTree.add(100,10);
		testInitializedTree.add(200,10);
		testInitializedTree.add(300,10);
		testInitializedTree.add(400,200);
		testInitializedTree.add(500,200);
		testInitializedTree.add(700,500);
		testInitializedTree.add(800,500);
		testInitializedTree.add(900,700);
		testInitializedTree.add(600,200);


		
		
		oneNodeTree.add(100, -1);
		
		
		testAllOneChildTree.add(10,-1);
		testAllOneChildTree.add(100,10);
		testAllOneChildTree.add(200,100);
		testAllOneChildTree.add(300,200);
		testAllOneChildTree.add(400,300);
		testAllOneChildTree.add(500,400);
		System.setOut(new PrintStream(captureOutputStream));
	}
	/**
	 * Resets output to standard output and clears the linked list examples
	 */
	@AfterEach
	public void tearDown()
	{
		System.setOut(standardOut);
		testInitializedTree.clear();
		oneNodeTree.clear();
		testAllOneChildTree.clear();
	}

	@Test
	void testHeight() {
		assertEquals(0, testEmptyTree.height(testEmptyTree.getRoot()));
		assertEquals(1, oneNodeTree.height(oneNodeTree.getRoot()));
		assertEquals(5, testInitializedTree.height(testInitializedTree.getRoot()));
		assertEquals(6, testAllOneChildTree.height(testAllOneChildTree.getRoot()));
	}

	@Test
	void testNodeCount() {
		assertEquals(0, testEmptyTree.nodeCount());
		assertEquals(1, oneNodeTree.nodeCount());
		assertEquals(10, testInitializedTree.nodeCount());
		assertEquals(6, testAllOneChildTree.nodeCount());
	}

	@Test
	void testIsEmpty() {
		assertTrue(testEmptyTree.isEmpty());
		assertFalse(oneNodeTree.isEmpty());
		assertFalse(testInitializedTree.isEmpty());
		assertFalse(testAllOneChildTree.isEmpty());
	}

	@Test
	void testDegree() {
		Throwable e = null;
		try {
			testEmptyTree.degree(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(3, testInitializedTree.degree(testInitializedTree.getRoot()));
		assertEquals(2, testInitializedTree.degree(testInitializedTree.search(500)));
		assertEquals(0, testInitializedTree.degree(testInitializedTree.search(900)));
		assertEquals(0, oneNodeTree.degree(oneNodeTree.getRoot()));
		assertEquals(1, testAllOneChildTree.degree(testAllOneChildTree.getRoot()));
	}

	@Test
	void testIsRoot() {
		Throwable e = null;
		try {
			testEmptyTree.isRoot(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertTrue(testInitializedTree.isRoot(testInitializedTree.getRoot()));
		assertFalse(testInitializedTree.isRoot(testInitializedTree.search(500)));
		assertTrue(oneNodeTree.isRoot(testInitializedTree.getRoot()));
		assertTrue(testAllOneChildTree.isRoot(testAllOneChildTree.getRoot()));
		assertFalse(testAllOneChildTree.isRoot(testAllOneChildTree.search(100)));
	}

	@Test
	void testIsParent() {
		Throwable e = null;
		try {
			testEmptyTree.isParent(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertTrue(testInitializedTree.isParent(testInitializedTree.getRoot()));
		assertFalse(testInitializedTree.isParent(testInitializedTree.search(900)));
		assertFalse(oneNodeTree.isParent(oneNodeTree.getRoot()));
		assertTrue(testAllOneChildTree.isParent(testAllOneChildTree.getRoot()));
		assertFalse(testAllOneChildTree.isRoot(testAllOneChildTree.search(500)));
	}

	@Test
	void testIsChildGeneralTreeNode() {
		Throwable e = null;
		try {
			testEmptyTree.isChild(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertFalse(testInitializedTree.isChild(testInitializedTree.getRoot()));
		assertTrue(testInitializedTree.isChild(testInitializedTree.search(900)));
		assertFalse(oneNodeTree.isChild(oneNodeTree.getRoot()));
		assertFalse(testAllOneChildTree.isChild(testAllOneChildTree.getRoot()));
		assertTrue(testAllOneChildTree.isChild(testAllOneChildTree.search(500)));
	}

	@Test
	void testIsLeafGeneralTreeNode() {
		Throwable e = null;
		try {
			testEmptyTree.isLeaf(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertFalse(testInitializedTree.isLeaf(testInitializedTree.getRoot()));
		assertTrue(testInitializedTree.isLeaf(testInitializedTree.search(900)));
		assertTrue(oneNodeTree.isLeaf(oneNodeTree.getRoot()));
		assertFalse(testAllOneChildTree.isLeaf(testAllOneChildTree.getRoot()));
		assertTrue(testAllOneChildTree.isLeaf(testAllOneChildTree.search(500)));
	}

	@Test
	void testGetLargest() {
		Throwable e = null;
		try {
			testEmptyTree.getLargest(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(900, testInitializedTree.getLargest(testInitializedTree.getRoot()).getData());
		assertEquals(100, oneNodeTree.getLargest(oneNodeTree.getRoot()).getData());
		assertEquals(500, testAllOneChildTree.getLargest(testAllOneChildTree.getRoot()).getData());
		
	}

	@Test
	void testGetSmallest() {
		Throwable e = null;
		try {
			testEmptyTree.getSmallest(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(10, testInitializedTree.getSmallest(testInitializedTree.getRoot()).getData());
		assertEquals(100, oneNodeTree.getSmallest(oneNodeTree.getRoot()).getData());
		assertEquals(10, testAllOneChildTree.getSmallest(testAllOneChildTree.getRoot()).getData());
	}

	@Test
	void testGetSecondLargest() {
		Throwable e = null;
		try {
			testEmptyTree.getSecondLargest(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		 e = null;
			try {
				oneNodeTree.getSecondLargest(oneNodeTree.getRoot());
			}catch(Throwable ex) {
				e = ex;
			}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(800, testInitializedTree.getSecondLargest(testInitializedTree.getRoot()).getData());
		assertEquals(400, testAllOneChildTree.getSecondLargest(testAllOneChildTree.getRoot()).getData());
	}

	@Test
	void testGetSecondSmallest() {
		Throwable e = null;
		try {
			testEmptyTree.getSecondSmallest(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		 e = null;
			try {
				oneNodeTree.getSecondSmallest(oneNodeTree.getRoot());
			}catch(Throwable ex) {
				e = ex;
			}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(100, testInitializedTree.getSecondSmallest(testInitializedTree.getRoot()).getData());
		assertEquals(100, testAllOneChildTree.getSecondSmallest(testAllOneChildTree.getRoot()).getData());
	}

	@Test
	void testAddIntInt() {
		assertTrue(testAddTree.add(10,-1));
		//Adding a node that already exists
		assertFalse(testAddTree.add(10,-1));
		//adding a node at a target that doesn't exist
		assertFalse(testAddTree.add(100, 100));
		//Trying to add a node to already initialized root
		assertFalse(testAddTree.add(11,-1));
		
		testAddTree.add(10,-1);
		testAddTree.add(100,10);
		testAddTree.add(200,10);
		testAddTree.add(300,10);
		testAddTree.add(400,200);
		testAddTree.add(500,200);
		testAddTree.add(700,500);
		testAddTree.add(800,500);
		testAddTree.add(900,700);
		testAddTree.add(600,200);
		
		assertEquals(10, testAddTree.nodeCount());
		assertEquals(5, testAddTree.height(testAddTree.getRoot()));
		
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("100 10 400 200 900 700 500 800 600 300 ", captureOutputStream.toString());
		
		
	}

	@Test
	void testInsertIntInt() {
		assertEquals(10, testAddTree.insert(10,-1));
		//Adding a node that already exists
		Throwable e = null;
		try {
			testAddTree.insert(10,-1);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof IllegalArgumentException);
		
		//adding a node at a target that doesn't exist
		
		e = null;
		try {
			testAddTree.insert(100, 100);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof IllegalArgumentException);
		//assertFalse(testAddTree.insert(100, 100));
		//Trying to add a node to already initialized root
		e = null;
		try {
			testAddTree.insert(11, -1);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof IllegalArgumentException);
		testAddTree.clear();
		
		testAddTree.insert(10,-1);
		testAddTree.insert(100,10);
		testAddTree.insert(200,10);
		testAddTree.insert(300,10);
		testAddTree.insert(400,200);
		testAddTree.insert(500,200);
		testAddTree.insert(700,500);
		testAddTree.insert(800,500);
		testAddTree.insert(900,700);
		testAddTree.insert(600,200);
		
		assertEquals(10, testAddTree.nodeCount());
		assertEquals(5, testAddTree.height(testAddTree.getRoot()));
		
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("100 10 400 200 900 700 500 800 600 300 ", captureOutputStream.toString());
	}

	@Test
	void testRemoveInt() {
		Throwable e = null;
		try {
			testEmptyTree.remove(100);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(800, testInitializedTree.remove(500));
		testInitializedTree.inOrder(testInitializedTree.getRoot());
		assertEquals("100 10 400 200 900 700 800 600 300 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		//removing root
		assertEquals(100, testInitializedTree.remove(10));
		testInitializedTree.levelOrder(testInitializedTree.getRoot());
		assertEquals("100 200 300 400 800 600 700 900 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		//removing leaf
		assertEquals(900, testInitializedTree.remove(900));
		testInitializedTree.inOrder(testInitializedTree.getRoot());
		assertEquals("400 200 700 800 600 100 300 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		assertEquals(100, oneNodeTree.remove(100));
		assertEquals(0, oneNodeTree.nodeCount());
		assertEquals(0, oneNodeTree.height(oneNodeTree.getRoot()));
		
	}

	@Test
	void testSearchInt() {
		Throwable e = null;
		try {
			testEmptyTree.search(100);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		

		assertNull(testInitializedTree.search(10110));
		assertEquals(100, testInitializedTree.search(100).getData());
		assertEquals(900, testInitializedTree.search(900).getData());
		assertEquals(500, testInitializedTree.search(500).getData());
		assertEquals(100, oneNodeTree.search(100).getData());
		assertEquals(200, testAllOneChildTree.search(200).getData());
		assertEquals(500, testAllOneChildTree.search(500).getData());

	}

	@Test
	void testLocateNode() {
		Throwable e = null;
		try {
			testEmptyTree.locateNode(testEmptyTree.getRoot(),100);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		

		assertNull(testInitializedTree.locateNode(testInitializedTree.getRoot(), 10110));
		assertEquals(100, testInitializedTree.locateNode(testInitializedTree.getRoot(), 100).getData());
		assertEquals(900, testInitializedTree.locateNode(testInitializedTree.getRoot(),900).getData());
		assertEquals(500, testInitializedTree.locateNode(testInitializedTree.getRoot(),500).getData());
		assertEquals(100, oneNodeTree.locateNode(oneNodeTree.getRoot(),100).getData());
		assertEquals(200, testAllOneChildTree.locateNode(testAllOneChildTree.getRoot(),200).getData());
		assertEquals(500, testAllOneChildTree.locateNode(testAllOneChildTree.getRoot(),500).getData());
	}
	@Test
	void testEmptyInOrder()
	{
		//initialize empty Throwable instance
		Throwable e = null;
		try {
			testEmptyTree.inOrder(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
	}
	@Test
	void testInOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.inOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("100 10 400 200 900 700 500 800 600 300 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testAllOneChildTree.inOrder(testAllOneChildTree.getRoot());
		assertEquals("500 400 300 200 100 10 ", captureOutputStream.toString());

	}
	
	@Test
	void testEmptyPreOrder()
	{
		Throwable e = null;
		try {
			testEmptyTree.preOrder(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
	}
	
	@Test
	void testPreOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.preOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("10 100 200 400 500 700 900 800 600 300 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testAllOneChildTree.preOrder(testAllOneChildTree.getRoot());
		assertEquals("10 100 200 300 400 500 ", captureOutputStream.toString());

		
	}
	

	@Test
	void testEmptyPostOrder()
	{
		Throwable e = null;
		try {
			testEmptyTree.postOrder(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
	}
	
	@Test
	void testPostOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.postOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("100 400 900 700 800 500 600 200 300 10 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testAllOneChildTree.postOrder(testAllOneChildTree.getRoot());
		assertEquals("500 400 300 200 100 10 ", captureOutputStream.toString());

	}
	
	@Test
	void testEmptyLevelOrder()
	{
		Throwable e = null;
		try {
			testEmptyTree.levelOrder(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
	}
	
	@Test
	void testLevelOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.levelOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("10 100 200 300 400 500 600 700 800 900 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testAllOneChildTree.levelOrder(testAllOneChildTree.getRoot());
		assertEquals("10 100 200 300 400 500 ", captureOutputStream.toString());
		
	}


	@Test
	void testGetRoot() {
		assertEquals(-1, testEmptyTree.getRoot().getData());
		assertEquals(10, testInitializedTree.getRoot().getData());
		assertEquals(100, oneNodeTree.getRoot().getData());
		assertEquals(10, testAllOneChildTree.getRoot().getData());
	}

}
