package edu.sru.thangiah.datastructures.tree.binarytree;

//used for assertFuzzyEquals so we can test the output of insertion
//src: https://web-cat.org/junit-quickstart/


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * <p>Title: BinarySearchTreeTest</p>
 *
 * <p>Description: </p>
 * JUnit class to test the methods and store the example data sets which are used for testing.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
class BinarySearchTreeTest {
	
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
	private BinarySearchTree testEmptyTree = new BinarySearchTree();
	/**
	 * Tree initialized with a few nodes to ensure proper functionality of a simple bst
	 */
	private BinarySearchTree testInitializedTree = new BinarySearchTree();
	/**
	 * Uninitialized tree which is used to test the add method
	 */
	private BinarySearchTree testAddTree = new BinarySearchTree();
	/**
	 * Single node bst
	 */
	private BinarySearchTree oneNodeTree = new BinarySearchTree();
	/**
	 * Simple tree used to test left and right rotation
	 */
	private BinarySearchTree testRotateTree = new BinarySearchTree();
	/**
	 * Tree which satisfies the rules of a complete binary tree
	 */
	private BinarySearchTree testCompleteTree = new BinarySearchTree();
	/**
	 * Tree which satisfies the rules of a full binary tree
	 */
	private BinarySearchTree testFullTree = new BinarySearchTree();
	/**
	 * Binary tree which has all right children
	 */
	private BinarySearchTree testRightLeaningTree = new BinarySearchTree();
	/**
	 * Binary tree which has all left children
	 */
	private BinarySearchTree testLeftLeaningTree = new BinarySearchTree();
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to intialize standard output to our ByteArrayStream custom output stream
	 */
	@BeforeEach
	public void setUp()
	{
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
		testRightLeaningTree.clear();
		testLeftLeaningTree.clear();
	}
	
	@Test
	void testHeight() {
		assertEquals(0, testEmptyTree.height(testEmptyTree.getRoot()));
		//we know the binary tree when initialized will have a height of 3
		assertEquals(1, oneNodeTree.height(oneNodeTree.getRoot()));
		assertEquals(3, testInitializedTree.height(testInitializedTree.getRoot()));
		assertEquals(3, testCompleteTree.height(testCompleteTree.getRoot()));
		assertEquals(3, testFullTree.height(testFullTree.getRoot()));
		assertEquals(4, testRightLeaningTree.height(testRightLeaningTree.getRoot()));
		assertEquals(4, testLeftLeaningTree.height(testLeftLeaningTree.getRoot()));
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
		
		assertEquals(0, oneNodeTree.degree(oneNodeTree.getRoot()));
		assertEquals(2, testInitializedTree.degree(testInitializedTree.getRoot()));
		assertEquals(0, testInitializedTree.degree(testInitializedTree.getRoot().getRight()));
		assertEquals(2, testCompleteTree.degree(testCompleteTree.getRoot().getLeft()));
		assertEquals(1, testCompleteTree.degree(testCompleteTree.getRoot().getRight()));
		assertEquals(1, testRightLeaningTree.degree(testRightLeaningTree.getRoot().getRight().getRight()));
		assertEquals(1, testLeftLeaningTree.degree(testLeftLeaningTree.getRoot().getLeft().getLeft()));
		
	}
	
	@org.junit.jupiter.api.Test
	void testIsFull()
	{
		Throwable e = null;
		try {
			testEmptyTree.isFull(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertTrue(testInitializedTree.isFull(testInitializedTree.getRoot()));
		assertFalse(testCompleteTree.isFull(testCompleteTree.getRoot()));
		assertTrue(testFullTree.isFull(testFullTree.getRoot()));
		//true since a full tree either has 0 or 2 children
		assertTrue(oneNodeTree.isFull(oneNodeTree.getRoot()));
		assertFalse(testRightLeaningTree.isFull(testRightLeaningTree.getRoot()));
		assertFalse(testLeftLeaningTree.isFull(testLeftLeaningTree.getRoot()));
		
		
	}
	
	@org.junit.jupiter.api.Test
	void testIsComplete()
	{
		Throwable e = null;
		try {
			testEmptyTree.isComplete();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertTrue(testInitializedTree.isComplete());
		assertTrue(testCompleteTree.isComplete());
		assertTrue(testFullTree.isComplete());
		//true since a complete tree is either a leaf or has exactly two children
		assertTrue(oneNodeTree.isComplete());
		assertFalse(testRightLeaningTree.isComplete());
		assertFalse(testLeftLeaningTree.isComplete());
	}
	
	@org.junit.jupiter.api.Test
	void testIsIncomplete()
	{
		Throwable e = null;
		try {
			testEmptyTree.isIncomplete();
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertFalse(testInitializedTree.isIncomplete());
		assertFalse(testCompleteTree.isIncomplete());
		assertFalse(testFullTree.isIncomplete());
		//true since a complete tree is either a leaf or has exactly two children
		assertFalse(oneNodeTree.isIncomplete());
		assertTrue(testRightLeaningTree.isIncomplete());
		assertTrue(testLeftLeaningTree.isIncomplete());
		
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
		
		assertTrue(testInitializedTree.isRoot(testInitializedTree.getRoot()));
		assertFalse(testCompleteTree.isRoot(testCompleteTree.getRoot().getRight()));
		assertFalse(testFullTree.isRoot(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertTrue(oneNodeTree.isRoot(oneNodeTree.getRoot()));
		assertTrue(testRightLeaningTree.isRoot(testRightLeaningTree.getRoot()));
		assertFalse(testLeftLeaningTree.isRoot(testLeftLeaningTree.getRoot().getLeft().getLeft()));
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
		
		assertTrue(testInitializedTree.isParent(testInitializedTree.getRoot()));
		assertTrue(testCompleteTree.isParent(testCompleteTree.getRoot().getRight()));
		assertFalse(testFullTree.isParent(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertFalse(oneNodeTree.isParent(oneNodeTree.getRoot()));
		assertTrue(testRightLeaningTree.isParent(testRightLeaningTree.getRoot()));
		assertTrue(testLeftLeaningTree.isParent(testLeftLeaningTree.getRoot().getLeft()));
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
		
		assertFalse(testInitializedTree.isChild(testInitializedTree.getRoot()));
		assertTrue(testCompleteTree.isChild(testCompleteTree.getRoot().getRight()));
		assertTrue(testFullTree.isChild(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertFalse(oneNodeTree.isChild(oneNodeTree.getRoot()));
		assertFalse(testRightLeaningTree.isChild(testRightLeaningTree.getRoot()));
		assertTrue(testLeftLeaningTree.isChild(testLeftLeaningTree.getRoot().getLeft()));
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
		
		assertFalse(testInitializedTree.isLeaf(testInitializedTree.getRoot()));
		assertFalse(testCompleteTree.isLeaf(testCompleteTree.getRoot().getLeft()));
		assertTrue(testFullTree.isLeaf(testFullTree.getRoot().getLeft().getLeft()));
		//true since a complete tree is either a leaf or has exactly two children
		assertTrue(oneNodeTree.isLeaf(oneNodeTree.getRoot()));
		assertFalse(testRightLeaningTree.isLeaf(testRightLeaningTree.getRoot()));
		assertTrue(testLeftLeaningTree.isLeaf(testLeftLeaningTree.getRoot().getLeft().getLeft().getLeft()));
	}
	
	
	
	@Test
	void testInsertInt() {
		
		//we intialize the bst and test for various conditions (nodecount, height, traversal)
		//to ensure bst nodes are being inserted correctly
		testAddTree.insert(100);
		testAddTree.insert(80);
		testAddTree.insert(120);
		testAddTree.insert(90);
		testAddTree.insert(75);
		
		//we know the binary tree when initialized will have a height of 3
		assertEquals(3, testAddTree.height(testAddTree.getRoot()));
		
		//we are inserting a node that already exists (method should return false)
		assertFalse(testAddTree.insert(75));
		
		assertEquals(5, testAddTree.nodeCount());
		//ensure nodes are all initialized properly
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("75 80 90 100 120 ", captureOutputStream.toString());
	
		
		
	}

	@Test
	void testSearchInt() {
		BinaryTreeNode output = testInitializedTree.search(75);
		assertNull(testEmptyTree.search(10));
		assertEquals(75,output.getData());
		assertNull(testInitializedTree.search(20));
	}

	@Test
	void testLocateNode() {
		BinaryTreeNode output = testEmptyTree.locateNode(testEmptyTree.getRoot(), 75);
		assertEquals(-1, output.getData());
		output = testInitializedTree.locateNode(testInitializedTree.getRoot(), 75);
		assertEquals(75,output.getData());
	}

	@Test
	void testPredecessor() {
		Throwable e = null;
		try {
			testEmptyTree.predecessor(testEmptyTree.getRoot(), 0);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		//testing left leaf node
		BinaryTreeNode output = testInitializedTree.predecessor(testInitializedTree.getRoot(), 75);
		assertNull(output);
		
		output = testInitializedTree.predecessor(testInitializedTree.getRoot(), 80);
		assertEquals(75,output.getData());
	}

	@Test
	void testSuccessor() {
		Throwable e = null;
		try {
			testEmptyTree.successor(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		BinaryTreeNode output = testInitializedTree.successor(testInitializedTree.getRoot().getRight());
		assertNull(output);
	}

	@Test
	void testGetLargest() {
		Throwable e = null;
		try {
			testEmptyTree.findMax(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(120, testInitializedTree.findMax(testInitializedTree.getRoot()));
	}

	@Test
	void testGetSmallest() {
		Throwable e = null;
		try {
			oneNodeTree.getSecondSmallest(oneNodeTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(75, testInitializedTree.findMin(testInitializedTree.getRoot()));
	}

	@Test
	void testGetSecondLargest() {
		Throwable e = null;
		try {
			oneNodeTree.getSecondLargest(oneNodeTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(100, testInitializedTree.getSecondLargest(testInitializedTree.getRoot()).getData());
		assertEquals(120, testRightLeaningTree.getSecondLargest(testRightLeaningTree.getRoot()).getData());
		assertEquals(90, testLeftLeaningTree.getSecondLargest(testLeftLeaningTree.getRoot()).getData());
	}

	@Test
	void testGetSecondSmallest() {
		Throwable e = null;
		try {
			oneNodeTree.getSecondSmallest(oneNodeTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(80, testInitializedTree.getSecondSmallest(testInitializedTree.getRoot()).getData());
		assertEquals(110, testRightLeaningTree.getSecondSmallest(testRightLeaningTree.getRoot()).getData());
		assertEquals(80, testLeftLeaningTree.getSecondSmallest(testLeftLeaningTree.getRoot()).getData());
	}

	@Test
	void testRemoveInt() {
		Throwable e = null;
		Throwable f = null;
		try {
			//removing from empty binary tree
			testEmptyTree.remove(12);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(-1, testInitializedTree.remove(12));
		
		//removing root
		assertEquals(100, testInitializedTree.remove(100));
		testInitializedTree.remove(100);
		
		testInitializedTree.inOrder(testInitializedTree.getRoot());
		assertEquals("75 80 90 120 ", captureOutputStream.toString());
		
		
	}

	@Test
	void testRotateLeftBinaryTreeNode() {
		testRotateTree.add(100);
		testRotateTree.add(80);
		testRotateTree.add(75);
		
		testRotateTree.rotateLeft(testRotateTree.getRoot());
		
		testRotateTree.inOrder(testRotateTree.getRoot());
		assertEquals("75 80 100 ", captureOutputStream.toString());
		
		
	}

	@Test
	void testRotateRightBinaryTreeNode() {
		testRotateTree.add(100);
		testRotateTree.add(80);
		testRotateTree.add(75);
		
		testRotateTree.rotateRight(testRotateTree.getRoot());
		
		testRotateTree.inOrder(testRotateTree.getRoot());
		assertEquals("75 80 100 ", captureOutputStream.toString());
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
	void testInOrderBinaryTreeNode() {
		//ensure nodes are all initialized properly
		testInitializedTree.inOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("75 80 90 100 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.inOrder(testCompleteTree.getRoot());
		assertEquals("75 80 90 100 110 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.inOrder(testFullTree.getRoot());
		assertEquals("75 80 90 100 110 120 130 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testRightLeaningTree.inOrder(testRightLeaningTree.getRoot());
		assertEquals("100 110 120 130 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testLeftLeaningTree.inOrder(testLeftLeaningTree.getRoot());
		assertEquals("70 80 90 100 ", captureOutputStream.toString());
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
	void testPreOrderBinaryTreeNode() {
		//ensure nodes are all initialized properly
		testInitializedTree.preOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("100 80 75 90 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.preOrder(testCompleteTree.getRoot());
		assertEquals("100 80 75 90 120 110 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.preOrder(testFullTree.getRoot());
		assertEquals("100 80 75 90 120 110 130 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testRightLeaningTree.preOrder(testRightLeaningTree.getRoot());
		assertEquals("100 110 120 130 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testLeftLeaningTree.preOrder(testLeftLeaningTree.getRoot());
		assertEquals("100 90 80 70 ", captureOutputStream.toString());
		
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
	void testPostOrderBinaryTreeNode() {
		//ensure nodes are all initialized properly
		testInitializedTree.postOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("75 90 80 120 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.postOrder(testCompleteTree.getRoot());
		assertEquals("75 90 80 110 120 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.postOrder(testFullTree.getRoot());
		assertEquals("75 90 80 110 130 120 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testRightLeaningTree.postOrder(testRightLeaningTree.getRoot());
		assertEquals("130 120 110 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testLeftLeaningTree.postOrder(testLeftLeaningTree.getRoot());
		assertEquals("70 80 90 100 ", captureOutputStream.toString());
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
	void testLevelOrderBinaryTreeNode() {
		//ensure nodes are all initialized properly
		testInitializedTree.levelOrder(testInitializedTree.getRoot());	
		//adding the student.TestCase library allows us to test against console output
		//fuzzy equals allows us to now have to worry about whitespace differences
		assertEquals("100 80 120 75 90 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testCompleteTree.levelOrder(testCompleteTree.getRoot());
		assertEquals("100 80 120 75 90 110 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testFullTree.levelOrder(testFullTree.getRoot());
		assertEquals("100 80 120 75 90 110 130 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testRightLeaningTree.levelOrder(testRightLeaningTree.getRoot());
		assertEquals("100 110 120 130 ", captureOutputStream.toString());
		captureOutputStream.reset();
		testLeftLeaningTree.levelOrder(testLeftLeaningTree.getRoot());
		assertEquals("100 90 80 70 ", captureOutputStream.toString());
	}

	@Test
	void testFindMaxBinaryTreeNode() {
		Throwable e = null;
		try {
			testEmptyTree.findMax(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(120, testInitializedTree.findMax(testInitializedTree.getRoot()));
	}

	@Test
	void testFindMinBinaryTreeNode() {
		Throwable e = null;
		try {
			testEmptyTree.findMin(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(75, testInitializedTree.findMin(testInitializedTree.getRoot()));
	}

	@Test
	void testAdd() {
		//we intialize the bst and test for various conditions (nodecount, height, traversal)
		//to ensure bst nodes are being inserted correctly
		testAddTree.add(100);
		testAddTree.add(80);
		testAddTree.add(120);
		testAddTree.add(90);
		testAddTree.add(75);
		
		//we know the binary tree when initialized will have a height of 3
		assertEquals(3, testInitializedTree.height(testInitializedTree.getRoot()));
		
		//we are inserting a node that already exists (method should return false)
		assertFalse(testAddTree.add(75));
		
		assertEquals(5, testAddTree.nodeCount());
		//ensure nodes are all initialized properly
		testInitializedTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("75 80 90 100 120 ", captureOutputStream.toString());
	}

	@Test
	void testGetRoot() {
		assertNotNull(testInitializedTree.getRoot());
		assertEquals(-1,testEmptyTree.getRoot().getData());
	}

	@Test
	void testIsEmpty() {
		assertTrue(testEmptyTree.isEmpty());
		assertFalse(testInitializedTree.isEmpty());
	}

	@Test
	void testClear() {
		//clear all nodes in bst
		testInitializedTree.clear();
		//bst should equal 0 after clear
		assertEquals(0, testInitializedTree.nodeCount());
		//ensure isEmpty returns true
		assertTrue(testInitializedTree.isEmpty());
		//make sure users cannot find node which doesn't exist
		assertNull(testInitializedTree.search(100));
	}

}
