package edu.sru.thangiah.datastructures.tree.heaptree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.sru.thangiah.datastructures.generic.tree.heaptree.HeapTreeNodeGeneric;
import edu.sru.thangiah.datastructures.tree.binarytree.BinarySearchTree;

/*
 * JUnit class for testing methods in MaxHeapTree implementation
 */


/**
 * <p>Title: MaxHeapTreeTest</p>
 *
 * <p>Description: </p>
* JUnit class for testing the methods contained in the max heap tree implementaiton
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class MaxHeapTreeTest {
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
	private MaxHeapTree testEmptyTree = new MaxHeapTree();
	/**
	 * Tree initialized with a few nodes to ensure proper functionality of a simple bst
	 */
	private MaxHeapTree testInitializedTree = new MaxHeapTree();
	/**
	 * Uninitialized tree which is used to test the add method
	 */
	private MaxHeapTree testAddTree = new MaxHeapTree();
	/**
	 * Single node bst
	 */
	private MaxHeapTree oneNodeTree = new MaxHeapTree();
	/**
	 * Tree which satisfies the rules of a complete binary tree
	 */
	private MaxHeapTree testCompleteTree = new MaxHeapTree();
	/**
	 * Tree which satisfies the rules of a full binary tree
	 */
	private MaxHeapTree testFullTree = new MaxHeapTree();
	
	
	/**
	 * Empty tree used to test for empty exceptions
	 */
	private MaxHeapTreeLinkedList testEmptyTreeLL = new MaxHeapTreeLinkedList();
	/**
	 * Tree initialized with a few nodes to ensure proper functionality of a simple bst
	 */
	private MaxHeapTreeLinkedList testInitializedTreeLL = new MaxHeapTreeLinkedList();
	/**
	 * Uninitialized tree which is used to test the add method
	 */
	private MaxHeapTreeLinkedList testAddTreeLL = new MaxHeapTreeLinkedList();
	/**
	 * Single node bst
	 */
	private MaxHeapTreeLinkedList oneNodeTreeLL = new MaxHeapTreeLinkedList();
	/**
	 * Tree which satisfies the rules of a complete binary tree
	 */
	private MaxHeapTreeLinkedList testCompleteTreeLL = new MaxHeapTreeLinkedList();
	/**
	 * Tree which satisfies the rules of a full binary tree
	 */
	private MaxHeapTreeLinkedList testFullTreeLL = new MaxHeapTreeLinkedList();
	
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to intialize standard output to our ByteArrayStream custom output stream
	 */
	@BeforeEach
	public void setUp()
	{
		System.setOut(new PrintStream(captureOutputStream));
		testInitializedTree.insert(100);
		testInitializedTree.insert(80);
		testInitializedTree.insert(120);
		testInitializedTree.insert(90);
		testInitializedTree.insert(75);
		
		
		oneNodeTree.insert(100);
		
		testCompleteTree.insert(100);
		testCompleteTree.insert(80);
		testCompleteTree.insert(120);
		testCompleteTree.insert(90);
		testCompleteTree.insert(75);
		testCompleteTree.insert(110);
		
		testFullTree.insert(100);
		testFullTree.insert(80);
		testFullTree.insert(120);
		testFullTree.insert(90);
		testFullTree.insert(75);
		testFullTree.insert(110);
		testFullTree.insert(130);
		
		
		testInitializedTreeLL.insert(100);
		testInitializedTreeLL.insert(80);
		testInitializedTreeLL.insert(120);
		testInitializedTreeLL.insert(90);
		testInitializedTreeLL.insert(75);
		
		
		oneNodeTreeLL.insert(100);
		
		testCompleteTreeLL.insert(100);
		testCompleteTreeLL.insert(80);
		testCompleteTreeLL.insert(120);
		testCompleteTreeLL.insert(90);
		testCompleteTreeLL.insert(75);
		testCompleteTreeLL.insert(110);
		
		testFullTreeLL.insert(100);
		testFullTreeLL.insert(80);
		testFullTreeLL.insert(120);
		testFullTreeLL.insert(90);
		testFullTreeLL.insert(75);
		testFullTreeLL.insert(110);
		testFullTreeLL.insert(130);
		
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
		testCompleteTree.clear();
		testFullTree.clear();
		
		testInitializedTreeLL.clear();
		oneNodeTreeLL.clear();
		testCompleteTreeLL.clear();
		testFullTreeLL.clear();
	}
	
	@Test
	void testHeight() {
		assertEquals(0, testEmptyTree.height());
		//we know the binary tree when initialized will have a height of 3
		assertEquals(1, oneNodeTree.height());
		assertEquals(3, testInitializedTree.height());
		assertEquals(3, testCompleteTree.height());
		assertEquals(3, testFullTree.height());
		
		assertEquals(0, testEmptyTreeLL.height(testEmptyTreeLL.getRoot()));
		//we know the binary tree when initialized will have a height of 3
		assertEquals(1, oneNodeTreeLL.height(oneNodeTreeLL.getRoot()));
		assertEquals(3, testInitializedTreeLL.height(testInitializedTreeLL.getRoot()));
		assertEquals(3, testCompleteTreeLL.height(testCompleteTreeLL.getRoot()));
		assertEquals(3, testFullTreeLL.height(testFullTreeLL.getRoot()));
	}

	@Test
	void testNodeCount() {
		assertEquals(0, testEmptyTree.nodeCount());
		assertEquals(1, oneNodeTree.nodeCount());
		assertEquals(5, testInitializedTree.nodeCount());
		assertEquals(6, testCompleteTree.nodeCount());
		assertEquals(7, testFullTree.nodeCount());
		
		assertEquals(0, testEmptyTreeLL.nodeCount());
		assertEquals(1, oneNodeTreeLL.nodeCount());
		assertEquals(5, testInitializedTreeLL.nodeCount());
		assertEquals(6, testCompleteTreeLL.nodeCount());
		assertEquals(7, testFullTreeLL.nodeCount());
	}

	@org.junit.jupiter.api.Test
	void testDegree()
	{
		Throwable e = null;
		try {
			testEmptyTree.degree(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		e = null;
		try {
			testEmptyTreeLL.degree(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(0, oneNodeTree.degree(oneNodeTree.getRoot()));
		assertEquals(2, testInitializedTree.degree(testInitializedTree.getRoot()));
		assertEquals(0, testInitializedTree.degree(testInitializedTree.getRoot().getRight()));
		assertEquals(2, testCompleteTree.degree(testCompleteTree.getRoot().getLeft()));
		assertEquals(1, testCompleteTree.degree(testCompleteTree.getRoot().getRight()));
		
		assertEquals(0, oneNodeTreeLL.degree(oneNodeTreeLL.getRoot()));
		assertEquals(2, testInitializedTreeLL.degree(testInitializedTreeLL.getRoot()));
		assertEquals(0, testInitializedTreeLL.degree(testInitializedTreeLL.getRoot().getRight()));
		assertEquals(2, testCompleteTreeLL.degree(testCompleteTreeLL.getRoot().getLeft()));
		assertEquals(1, testCompleteTreeLL.degree(testCompleteTreeLL.getRoot().getRight()));
	}
	
	
	@org.junit.jupiter.api.Test
	void testIsRoot()
	{
		Throwable e = null;
		try {
			testEmptyTree.isRoot(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		e = null;
		try {
			testEmptyTreeLL.isRoot(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertTrue(testInitializedTree.isRoot(testInitializedTree.getRoot()));
		assertFalse(testCompleteTree.isRoot(testCompleteTree.getRoot().getRight()));
		assertFalse(testFullTree.isRoot(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertTrue(oneNodeTree.isRoot(oneNodeTree.getRoot()));
		
		assertTrue(testInitializedTreeLL.isRoot(testInitializedTreeLL.getRoot()));
		assertFalse(testCompleteTreeLL.isRoot(testCompleteTreeLL.getRoot().getRight()));
		assertFalse(testFullTreeLL.isRoot(testFullTreeLL.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertTrue(oneNodeTreeLL.isRoot(oneNodeTreeLL.getRoot()));


	}
	
	@org.junit.jupiter.api.Test
	void testIsParent()
	{
		Throwable e = null;
		try {
			testEmptyTree.isParent(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		e = null;
		try {
			testEmptyTreeLL.isParent(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertTrue(testInitializedTree.isParent(testInitializedTree.getRoot()));
		assertTrue(testCompleteTree.isParent(testCompleteTree.getRoot().getRight()));
		assertFalse(testFullTree.isParent(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertFalse(oneNodeTree.isParent(oneNodeTree.getRoot()));
		
		assertTrue(testInitializedTreeLL.isParent(testInitializedTreeLL.getRoot()));
		assertTrue(testCompleteTreeLL.isParent(testCompleteTreeLL.getRoot().getRight()));
		assertFalse(testFullTreeLL.isParent(testFullTreeLL.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertFalse(oneNodeTreeLL.isParent(oneNodeTreeLL.getRoot()));
	}
	
	@org.junit.jupiter.api.Test
	void testIsChild()
	{
		Throwable e = null;
		try {
			testEmptyTree.isChild(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		e = null;
		try {
			testEmptyTreeLL.isChild(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertFalse(testInitializedTree.isChild(testInitializedTree.getRoot()));
		assertTrue(testCompleteTree.isChild(testCompleteTree.getRoot().getRight()));
		assertTrue(testFullTree.isChild(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertFalse(oneNodeTree.isChild(oneNodeTree.getRoot()));
		
		assertFalse(testInitializedTreeLL.isChild(testInitializedTreeLL.getRoot()));
		assertTrue(testCompleteTreeLL.isChild(testCompleteTreeLL.getRoot().getRight()));
		assertTrue(testFullTreeLL.isChild(testFullTreeLL.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertFalse(oneNodeTreeLL.isChild(oneNodeTreeLL.getRoot()));

	}
	
	@org.junit.jupiter.api.Test
	void testIsLeaf()
	{
		Throwable e = null;
		try {
			testEmptyTree.isLeaf(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		e = null;
		try {
			testEmptyTreeLL.isLeaf(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertFalse(testInitializedTree.isLeaf(testInitializedTree.getRoot()));
		assertFalse(testCompleteTree.isLeaf(testCompleteTree.getRoot().getLeft()));
		assertTrue(testFullTree.isLeaf(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertTrue(oneNodeTree.isLeaf(oneNodeTree.getRoot()));
		
		assertFalse(testInitializedTreeLL.isLeaf(testInitializedTreeLL.getRoot()));
		assertFalse(testCompleteTreeLL.isLeaf(testCompleteTreeLL.getRoot().getLeft()));
		assertTrue(testFullTreeLL.isLeaf(testFullTreeLL.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertTrue(oneNodeTreeLL.isLeaf(oneNodeTreeLL.getRoot()));

	}

	@Test
	void testFindLastLeaf() {
		assertNull(testEmptyTree.findLastLeaf());
		HeapTreeNode result = oneNodeTree.findLastLeaf();
		assertEquals(100, result.getData());
		result = testInitializedTree.findLastLeaf();
		assertEquals(75, result.getData());
		result = testCompleteTree.findLastLeaf();
		assertEquals(100, result.getData());
		result = testFullTree.findLastLeaf();
		assertEquals(110, result.getData());
		
		Throwable e = null;
		try {
			testEmptyTreeLL.findLastLeaf();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		result = oneNodeTreeLL.findLastLeaf();
		assertEquals(100, result.getData());
		result = testInitializedTreeLL.findLastLeaf();
		assertEquals(75, result.getData());
		result = testCompleteTreeLL.findLastLeaf();
		assertEquals(100, result.getData());
		result = testFullTreeLL.findLastLeaf();
		assertEquals(110, result.getData());
	}

	@Test
	void testInsertInt() {
		testAddTree.insert(100);
		Throwable e = null;
		try {
			testAddTree.insert(100);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof IllegalStateException);
		
		testAddTree.insert(80);
		testAddTree.insert(120);
		testAddTree.insert(90);
		testAddTree.insert(75);
		testAddTree.inOrder(testAddTree.getRoot());
		assertEquals("80 90 75 120 100 ", captureOutputStream.toString());
		
		captureOutputStream.reset();
		
		
		testAddTreeLL.insert(80);
		testAddTreeLL.insert(120);
		testAddTreeLL.insert(90);
		testAddTreeLL.insert(75);
		testAddTreeLL.inOrder(testAddTree.getRoot());
		assertEquals("80 90 75 120 100 ", captureOutputStream.toString());
		
	}

	@Test
	void testGetLargest() {
		Throwable e = null;
		try {
			testEmptyTree.getLargest();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		e = null;
		try {
			testEmptyTreeLL.getLargest();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(100, oneNodeTree.getLargest());
		assertEquals(120, testInitializedTree.getLargest());
		assertEquals(120, testCompleteTree.getLargest());
		assertEquals(130,testFullTree.getLargest());
		
		assertEquals(100, oneNodeTreeLL.getLargest());
		assertEquals(120, testInitializedTreeLL.getLargest());
		assertEquals(120, testCompleteTreeLL.getLargest());
		assertEquals(130,testFullTreeLL.getLargest());
	}
	@Test
	void testGetSecondLargest() 
	{
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
		e = null;
		try {
			testEmptyTreeLL.getSecondLargest(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		e = null;
		try {
			oneNodeTreeLL.getSecondLargest(oneNodeTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(100, testInitializedTree.getSecondLargest(testInitializedTree.getRoot()).getData());
		assertEquals(110, testCompleteTree.getSecondLargest(testCompleteTree.getRoot()).getData());
		assertEquals(120,testFullTree.getSecondLargest(testFullTree.getRoot()).getData());
		
		assertEquals(100, testInitializedTreeLL.getSecondLargest(testInitializedTreeLL.getRoot()).getData());
		assertEquals(110, testCompleteTreeLL.getSecondLargest(testCompleteTreeLL.getRoot()).getData());
		assertEquals(120,testFullTreeLL.getSecondLargest(testFullTreeLL.getRoot()).getData());
	}
	@Test
	void testGetSmallest() {
		Throwable e = null;
		try {
			testEmptyTree.getSmallest();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		e = null;
		try {
			testEmptyTreeLL.getSmallest();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(100, oneNodeTree.getSmallest());
		assertEquals(75, testInitializedTree.getSmallest());
		assertEquals(75, testCompleteTree.getSmallest());
		assertEquals(75,testFullTree.getSmallest());
		
		assertEquals(100, oneNodeTreeLL.getSmallest());
		assertEquals(75, testInitializedTreeLL.getSmallest());
		assertEquals(75, testCompleteTreeLL.getSmallest());
		assertEquals(75,testFullTreeLL.getSmallest());
	}
	@Test
	void testGetSecondSmallest() 
	{
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
		
		e = null;
		try {
			testEmptyTreeLL.getSecondSmallest(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		e = null;
		try {
			oneNodeTreeLL.getSecondSmallest(oneNodeTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		
		assertEquals(80, testInitializedTree.getSecondSmallest(testInitializedTree.getRoot()).getData());
		assertEquals(80, testCompleteTree.getSecondSmallest(testCompleteTree.getRoot()).getData());
		assertEquals(80, testFullTree.getSecondSmallest(testFullTree.getRoot()).getData());
		
		assertEquals(80, testInitializedTreeLL.getSecondSmallest(testInitializedTreeLL.getRoot()).getData());
		assertEquals(80, testCompleteTreeLL.getSecondSmallest(testCompleteTreeLL.getRoot()).getData());
		assertEquals(80, testFullTreeLL.getSecondSmallest(testFullTreeLL.getRoot()).getData());
	}

	@Test
	void testContains() {
		Throwable e = null;
		try {
			testEmptyTree.contains(100);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		e = null;
		try {
			testEmptyTreeLL.contains(100);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertTrue(oneNodeTree.contains(100));
		assertTrue(testInitializedTree.contains(75));
		assertTrue(testCompleteTree.contains(90));
		assertTrue(testFullTree.contains(80));
		assertFalse(testFullTree.contains(20));
		
		assertTrue(oneNodeTreeLL.contains(100));
		assertTrue(testInitializedTreeLL.contains(75));
		assertTrue(testCompleteTreeLL.contains(90));
		assertTrue(testFullTreeLL.contains(80));
		assertFalse(testFullTreeLL.contains(20));
	}

	@Test
	void testIsEmpty() {
		assertTrue(testEmptyTree.isEmpty());
		assertFalse(testInitializedTree.isEmpty());
		
		assertTrue(testEmptyTreeLL.isEmpty());
		assertFalse(testInitializedTreeLL.isEmpty());
	}

	@Test
	void testInOrder() {
		Throwable e = null;
		try {
			testEmptyTree.inOrder(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		testInitializedTree.inOrder(testInitializedTree.getRoot());	
		assertEquals("80 90 75 120 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.inOrder(testCompleteTree.getRoot());	
		assertEquals("80 90 75 120 100 110 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.inOrder(testFullTree.getRoot());
		assertEquals("80 90 75 130 100 120 110 ", captureOutputStream.toString());
		
		e = null;
		try {
			testEmptyTreeLL.inOrder(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		captureOutputStream.reset();
		testInitializedTreeLL.inOrder(testInitializedTreeLL.getRoot());	
		assertEquals("80 90 75 120 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTreeLL.inOrder(testCompleteTreeLL.getRoot());	
		assertEquals("80 90 75 120 100 110 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTreeLL.inOrder(testFullTreeLL.getRoot());
		assertEquals("80 90 75 130 100 120 110 ", captureOutputStream.toString());
		
	}

	@Test
	void testPreOrder() {
		Throwable e = null;
		try {
			testEmptyTree.preOrder(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		testInitializedTree.preOrder(testInitializedTree.getRoot());	
		assertEquals("120 90 80 75 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.preOrder(testCompleteTree.getRoot());	
		assertEquals("120 90 80 75 110 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.preOrder(testFullTree.getRoot());
		assertEquals("130 90 80 75 120 100 110 ", captureOutputStream.toString());
		
		e = null;
		try {
			testEmptyTreeLL.preOrder(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		captureOutputStream.reset();
		testInitializedTreeLL.preOrder(testInitializedTreeLL.getRoot());	
		assertEquals("120 90 80 75 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTreeLL.preOrder(testCompleteTreeLL.getRoot());	
		assertEquals("120 90 80 75 110 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTreeLL.preOrder(testFullTreeLL.getRoot());
		assertEquals("130 90 80 75 120 100 110 ", captureOutputStream.toString());
	}

	@Test
	void testPostOrder() {
		Throwable e = null;
		try {
			testEmptyTree.postOrder(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		testInitializedTree.postOrder(testInitializedTree.getRoot());	
		assertEquals("80 75 90 100 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.postOrder(testCompleteTree.getRoot());	
		assertEquals("80 75 90 100 110 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.postOrder(testFullTree.getRoot());
		assertEquals("80 75 90 100 110 120 130 ", captureOutputStream.toString());
		
		e = null;
		try {
			testEmptyTreeLL.postOrder(testEmptyTreeLL.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		captureOutputStream.reset();
		testInitializedTreeLL.postOrder(testInitializedTreeLL.getRoot());	
		assertEquals("80 75 90 100 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTreeLL.postOrder(testCompleteTreeLL.getRoot());	
		assertEquals("80 75 90 100 110 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTreeLL.postOrder(testFullTreeLL.getRoot());
		assertEquals("80 75 90 100 110 120 130 ", captureOutputStream.toString());
	}

	@Test
	void testLevelOrder() {
		Throwable e = null;
		try {
			testEmptyTree.levelOrder();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		testInitializedTree.levelOrder();	
		assertEquals("120 90 100 80 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.levelOrder();	
		assertEquals("120 90 110 80 75 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.levelOrder();
		assertEquals("130 90 120 80 75 100 110 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testInitializedTreeLL.levelOrder(testInitializedTreeLL.getRoot());	
		assertEquals("120 90 100 80 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTreeLL.levelOrder(testCompleteTreeLL.getRoot());	
		assertEquals("120 90 110 80 75 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTreeLL.levelOrder(testFullTreeLL.getRoot());
		assertEquals("130 90 120 80 75 100 110 ", captureOutputStream.toString());
	}
	
	@Test
	void testHeapSort() {
		Throwable e = null;
		try {
			testEmptyTree.heapSort();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		
		//printSortedArray calls HeapSort method and is easier to test since heapsort returns an array
		oneNodeTree.printSortedArray();
		assertEquals("Sorted Array: 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		//add node so TearDown method doesn't get angry
		oneNodeTree.add(100);
		
		testInitializedTree.printSortedArray();
		assertEquals("Sorted Array: 120 100 90 80 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		//add node so TearDown method doesn't get angry
		testInitializedTree.add(100);
		
		testCompleteTree.printSortedArray();
		assertEquals("Sorted Array: 120 110 100 90 80 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		//add node so TearDown method doesn't get angry
		testCompleteTree.add(100);
		
		testFullTree.printSortedArray();
		assertEquals("Sorted Array: 130 120 110 100 90 80 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		//add node so TearDown method doesn't get angry
		testFullTree.add(100);
	}

	
	@Test
	void testGetRoot() {
		assertEquals(-1, testEmptyTree.getRoot().getData());
		assertEquals(120, testInitializedTree.getRoot().getData());
		assertEquals(100, oneNodeTree.getRoot().getData());
		assertEquals(120, testCompleteTree.getRoot().getData());
		assertEquals(130, testFullTree.getRoot().getData());
		
		assertEquals(-1, testEmptyTreeLL.getRoot().getData());
		assertEquals(120, testInitializedTreeLL.getRoot().getData());
		assertEquals(100, oneNodeTreeLL.getRoot().getData());
		assertEquals(120, testCompleteTreeLL.getRoot().getData());
		assertEquals(130, testFullTreeLL.getRoot().getData());
	}

	@Test
	void testRemove() {
		Throwable e = null;
		try {
			testEmptyTree.remove(120);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		e = null;
		try {
			testInitializedTree.remove(20);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof IllegalStateException);
		testInitializedTree.remove(120);
		testInitializedTree.inOrder(testInitializedTree.getRoot());
		assertEquals("80 90 100 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.remove(90);
		testCompleteTree.inOrder(testCompleteTree.getRoot());
		assertEquals("80 100 75 120 110 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.remove(130);
		testFullTree.remove(120);
		testFullTree.remove(110);
		testFullTree.inOrder(testFullTree.getRoot());
		assertEquals("80 90 100 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		e = null;
		try {
			testEmptyTreeLL.remove(120);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		e = null;
		try {
			testInitializedTreeLL.remove(20);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof IllegalStateException);
		
		
		testInitializedTreeLL.remove(120);
		testInitializedTreeLL.inOrder(testInitializedTreeLL.getRoot());
		assertEquals("80 90 100 75 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTreeLL.remove(130);
		testFullTreeLL.remove(120);
		testFullTreeLL.remove(110);
		testFullTreeLL.inOrder(testFullTreeLL.getRoot());
		assertEquals("80 90 100 75 ", captureOutputStream.toString());
		
		
	}

	@Test
	void testSearch() {
		assertNull(testEmptyTree.search(testEmptyTree.getRoot(),120));
		//assertNull(testEmptyTree.search(testEmptyTree.getRoot(),120));
		assertNull(testInitializedTree.search(testInitializedTree.getRoot(), 20));
		assertEquals(120, testInitializedTree.search(testInitializedTree.getRoot(),120).getData());
		assertEquals(90, testCompleteTree.search(testCompleteTree.getRoot(),90).getData());
		assertEquals(110, testFullTree.search(testFullTree.getRoot(),110).getData());
	}
	@Test
	void testSize() {
		assertEquals(0, testEmptyTree.size());
		assertEquals(1, oneNodeTree.size());
		assertEquals(5, testInitializedTree.size());
		assertEquals(6, testCompleteTree.size());
		assertEquals(7, testFullTree.size());
		
		assertEquals(0, testEmptyTreeLL.size());
		assertEquals(1, oneNodeTreeLL.size());
		assertEquals(5, testInitializedTreeLL.size());
		assertEquals(6, testCompleteTreeLL.size());
		assertEquals(7, testFullTreeLL.size());
	}

	@Test
	void testClear() {
		Throwable e = null;
		try {
			testEmptyTree.clear();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertTrue(oneNodeTree.clear());
		assertTrue(testInitializedTree.clear());
		assertTrue(testCompleteTree.clear());
		assertTrue(testFullTree.clear());
		
		assertTrue(oneNodeTreeLL.clear());
		assertTrue(testInitializedTreeLL.clear());
		assertTrue(testCompleteTreeLL.clear());
		assertTrue(testFullTreeLL.clear());
		assertEquals(0, oneNodeTreeLL.size());
		assertEquals(0, testInitializedTreeLL.size());
		assertEquals(0, testCompleteTreeLL.size());
		assertEquals(0, testFullTreeLL.size());
	}

}
