package edu.sru.thangiah.datastructures.generic.tree.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.sru.thangiah.datastructures.tree.binarytree.BinarySearchTree;
import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;

/*
 * JUnit class to test the methods and store the example data sets which are used for testing.
 */
/**
 * <p>Title: BinarySearchTreeGenericTest</p>
 *
 * <p>Description: </p>
 * JUnit class to test the methods and store the example data sets which are used for testing.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class BinarySearchTreeGenericTest {

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
	private BinarySearchTreeGeneric <Integer> testInitializedTree = new BinarySearchTreeGeneric<Integer>();
	/**
	 * Tree which satisfies the rules of a complete binary tree
	 */
	private BinarySearchTreeGeneric <Float> testCompleteTree = new BinarySearchTreeGeneric<Float>();
	/**
	 * Tree which satisfies the rules of a full binary tree
	 */
	private BinarySearchTreeGeneric <Double> testFullTree = new BinarySearchTreeGeneric<Double>();
	/**
	 * Uninitialized tree which is used to test the add method
	 */
	private BinarySearchTreeGeneric testAddTree = new BinarySearchTreeGeneric();
	/**
	 * Empty tree used to test for empty exceptions
	 */
	private BinarySearchTreeGeneric testEmptyTree = new BinarySearchTreeGeneric();
	/**
	 * Single node bst
	 */
	private BinarySearchTreeGeneric oneNodeTree = new BinarySearchTreeGeneric();
	/**
	 * Simple tree used to test left and right rotation
	 */
	private BinarySearchTreeGeneric testRotateTree = new BinarySearchTreeGeneric();
	/**
	 * Binary tree which has all right children
	 */
	private BinarySearchTreeGeneric <String> testRightLeaningTree = new BinarySearchTreeGeneric<String>();
	/**
	 * Binary tree which has all left children
	 */
	private BinarySearchTreeGeneric <Integer> testLeftLeaningTree = new BinarySearchTreeGeneric();
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to intialize standard output to our ByteArrayStream custom output stream
	 */
	@BeforeEach
	public void  setUp()
	{
		System.setOut(new PrintStream(captureOutputStream));
		//Integer bst
		testInitializedTree.add(100);
		testInitializedTree.add(80);
		testInitializedTree.add(120);
		testInitializedTree.add(90);
		testInitializedTree.add(75);
		
		//complete bst
		testCompleteTree.add(100.1f);
		testCompleteTree.add(80.1f);
		testCompleteTree.add(120.1f);
		testCompleteTree.add(90f);
		testCompleteTree.add(75.1f);
		testCompleteTree.add(110.2f);
		
		//Double bst
		testFullTree.add(100.1);
		testFullTree.add(80.1);
		testFullTree.add(120.1);
		testFullTree.add(90.1);
		testFullTree.add(75.1);
		testFullTree.add(110.1);
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
	/**
	 * Resets output to standard output and clears the linked list examples
	 */
	@AfterEach
	public void tearDown()
	{
		System.setOut(standardOut);
		testInitializedTree.clear();
		testCompleteTree.clear();
		testFullTree.clear();
		oneNodeTree.clear();
	}
	
	@org.junit.jupiter.api.Test
	void testHeight() {
		assertEquals(0, testEmptyTree.height(testEmptyTree.getRoot()));
		assertEquals(1, oneNodeTree.height(oneNodeTree.getRoot()));
		assertEquals(3, testInitializedTree.height(testInitializedTree.getRoot()));
		assertEquals(3, testCompleteTree.height(testCompleteTree.getRoot()));
		assertEquals(3, testFullTree.height(testFullTree.getRoot()));
		assertEquals(4, testRightLeaningTree.height(testRightLeaningTree.getRoot()));
		assertEquals(4, testLeftLeaningTree.height(testLeftLeaningTree.getRoot()));
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
	
	@org.junit.jupiter.api.Test
	void testSearch() {
		Throwable e = null;
		try {
			testEmptyTree.search(10);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertNull(testInitializedTree.search(20));
		assertNull(testCompleteTree.search(20.1f));
		assertNull(testFullTree.search(0.0));
	}

	@org.junit.jupiter.api.Test
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
		testAddTree.clear();
	}
	@org.junit.jupiter.api.Test
	void testInsertString() {
		//we intialize the bst and test for various conditions (nodecount, height, traversal)
		//to ensure bst nodes are being inserted correctly
		testAddTree.insert("a");
		testAddTree.insert("b");
		testAddTree.insert("c");
		testAddTree.insert("d");
		testAddTree.insert("e");
		
		//we know the binary tree when initialized will have a height of 3
		assertEquals(5, testAddTree.height(testAddTree.getRoot()));
		
		//we are inserting a node that already exists (method should return false)
		assertFalse(testAddTree.insert("d"));
		
		assertEquals(5, testAddTree.nodeCount());
		//ensure nodes are all initialized properly
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("a b c d e ", captureOutputStream.toString());
		testAddTree.clear();
	}
	
	@org.junit.jupiter.api.Test
	void testInsertDouble() {
		//we intialize the bst and test for various conditions (nodecount, height, traversal)
		//to ensure bst nodes are being inserted correctly
		testAddTree.insert(100.1);
		testAddTree.insert(80.1);
		testAddTree.insert(120.1);
		testAddTree.insert(95.1);
		testAddTree.insert(75.1);
		
		//we know the binary tree when initialized will have a height of 3
		assertEquals(3, testAddTree.height(testAddTree.getRoot()));
		
		//we are inserting a node that already exists (method should return false)
		assertFalse(testAddTree.insert(95.1));
		
		assertEquals(5, testAddTree.nodeCount());
		//ensure nodes are all initialized properly
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("75.1 80.1 95.1 100.1 120.1 ", captureOutputStream.toString());
		testAddTree.clear();
	}
	
	
	@org.junit.jupiter.api.Test
	void testAddInt() {
		testAddTree.add(100);
		testAddTree.add(80);
		testAddTree.add(120);
		testAddTree.add(90);
		testAddTree.add(75);
		//we know the binary tree when initialized will have a height of 3
		assertEquals(3, testAddTree.height(testAddTree.getRoot()));
		
		//we are inserting a node that already exists (method should return false)
		assertFalse(testAddTree.add(75));
		
		assertEquals(5, testAddTree.nodeCount());
		//ensure nodes are all initialized properly
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("75 80 90 100 120 ", captureOutputStream.toString());
		testAddTree.clear();
		
		
	}
	@org.junit.jupiter.api.Test
	void testAddString() {
		testAddTree.add("a");
		testAddTree.add("b");
		testAddTree.add("c");
		testAddTree.add("d");
		testAddTree.add("e");
		//we know the binary tree when initialized will have a height of 3
		assertEquals(5, testAddTree.height(testAddTree.getRoot()));
		
		//we are inserting a node that already exists (method should return false)
		assertFalse(testAddTree.add("e"));
		
		assertEquals(5, testAddTree.nodeCount());
		//ensure nodes are all initialized properly
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("a b c d e ", captureOutputStream.toString());
		testAddTree.clear();
		
		
	}
	@org.junit.jupiter.api.Test
	void testAddDouble() {
		testAddTree.add(100.1);
		testAddTree.add(80.1);
		testAddTree.add(120.1);
		testAddTree.add(90.1);
		testAddTree.add(75.1);
		//we know the binary tree when initialized will have a height of 3
		assertEquals(3, testAddTree.height(testAddTree.getRoot()));
		
		//we are inserting a node that already exists (method should return false)
		assertFalse(testAddTree.add(100.1));
		
		assertEquals(5, testAddTree.nodeCount());
		//ensure nodes are all initialized properly
		testAddTree.inOrder(testAddTree.getRoot());
		//fuzzy equals allows us to now have to worry about whitespace differences instead we can only consider the values that matter
		assertEquals("75.1 80.1 90.1 100.1 120.1 ", captureOutputStream.toString());
		testAddTree.clear();
		
		
	}
	

	@org.junit.jupiter.api.Test
	void testLocateNode() {
		Throwable e = null;
		try {
			testEmptyTree.locateNode(testEmptyTree.getRoot(), 10);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		BinaryTreeNodeGeneric output = testInitializedTree.locateNode(testInitializedTree.getRoot(), 75);
		assertEquals(75,output.getData());
		output = testCompleteTree.locateNode(testCompleteTree.getRoot(), 120.1f);
		assertEquals(120.1f, output.getData());
		output = testFullTree.locateNode(testFullTree.getRoot(), 100.1);
		assertEquals(100.1, output.getData());
		
		//node not found will return last leaf
		output = testInitializedTree.locateNode(testInitializedTree.getRoot(), 10);
		assertEquals(75, output.getData());
	}

	@org.junit.jupiter.api.Test
	void testPredecessor() {
		Throwable e = null;
		try {
			testEmptyTree.predecessor(testEmptyTree.getRoot(), 0);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		//testing left leaf node
		BinaryTreeNodeGeneric output = testInitializedTree.predecessor(testInitializedTree.getRoot(), 75);
		assertNull(output);
		
		output = testInitializedTree.predecessor(testInitializedTree.getRoot(), 100);
		assertEquals(80,output.getData());
	}

	@org.junit.jupiter.api.Test
	void testSuccessor() {
		Throwable e = null;
		try {
			testEmptyTree.successor(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		BinaryTreeNodeGeneric output = testInitializedTree.successor(testInitializedTree.getRoot().getRight());
		assertNull(output);
	}

	@org.junit.jupiter.api.Test
	void testGetLargest() {
		Throwable e = null;
		try {
			testEmptyTree.findMax(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(120, testInitializedTree.findMax(testInitializedTree.getRoot()));
		assertEquals(120.1f, testCompleteTree.findMax(testCompleteTree.getRoot()));
		assertEquals(130.1, testFullTree.findMax(testFullTree.getRoot()));
		assertEquals(100, testLeftLeaningTree.findMax(testLeftLeaningTree.getRoot()));
		assertEquals("d", testRightLeaningTree.findMax(testRightLeaningTree.getRoot()));
		
	}

	@org.junit.jupiter.api.Test
	void testGetSmallest() {
		Throwable e = null;
		try {
			testEmptyTree.findMin(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(75, testInitializedTree.findMin(testInitializedTree.getRoot()));
		assertEquals(70, testLeftLeaningTree.findMin(testLeftLeaningTree.getRoot()));
		assertEquals("a", testRightLeaningTree.findMin(testRightLeaningTree.getRoot()));
	}

	@org.junit.jupiter.api.Test
	void testGetSecondLargest() {
		Throwable e = null;
		try {
			oneNodeTree.getSecondLargest(oneNodeTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertEquals(100, testInitializedTree.getSecondLargest(testInitializedTree.getRoot()).getData());
		assertEquals("c",testRightLeaningTree.getSecondLargest(testRightLeaningTree.getRoot()).getData());
		assertEquals(90,testLeftLeaningTree.getSecondLargest(testLeftLeaningTree.getRoot()).getData());
	}

	@org.junit.jupiter.api.Test
	void testGetSecondSmallest() {
		Throwable e = null;
		try {
			oneNodeTree.getSecondSmallest(oneNodeTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertEquals(80, testInitializedTree.getSecondSmallest(testInitializedTree.getRoot()).getData());
		assertEquals(80.1f, testCompleteTree.getSecondSmallest(testCompleteTree.getRoot()).getData());
		assertEquals(80.1 , testFullTree.getSecondSmallest(testFullTree.getRoot()).getData());
		assertEquals("b",testRightLeaningTree.getSecondSmallest(testRightLeaningTree.getRoot()).getData());
		assertEquals(80,testLeftLeaningTree.getSecondSmallest(testLeftLeaningTree.getRoot()).getData());
		
	}

	@org.junit.jupiter.api.Test
	void testRemoveInt() {
		Throwable e = null;
		try {
			//removing from empty binary tree
			testEmptyTree.remove(12);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(null, testInitializedTree.remove(12));
		
		//removing root
		assertEquals(100, testInitializedTree.remove(100));
		testInitializedTree.remove(100);
		
		testInitializedTree.inOrder(testInitializedTree.getRoot());
		assertEquals("75 80 90 120 ", captureOutputStream.toString());
		
		
	}
	@org.junit.jupiter.api.Test
	void testRemoveString() {
		Throwable e = null;
		try {
			//removing from empty binary tree
			testEmptyTree.remove(12);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(null, testRightLeaningTree.remove("f"));
		
		//removing root
		assertEquals("a", testRightLeaningTree.remove("a"));
		testRightLeaningTree.remove("a");
		
		testRightLeaningTree.inOrder(testRightLeaningTree.getRoot());
		assertEquals("b c d ", captureOutputStream.toString());
		
		
	}
	@org.junit.jupiter.api.Test
	void testRemoveDouble() {
		Throwable e = null;
		try {
			//removing from empty binary tree
			testEmptyTree.remove(12);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		assertEquals(null, testFullTree.remove(12.1));
		
		//removing root
		assertEquals(120.1, testFullTree.remove(120.1));
		testFullTree.remove(120.1);
		
		testFullTree.inOrder(testFullTree.getRoot());
		assertEquals("75.1 80.1 90.1 100.1 110.1 130.1 ", captureOutputStream.toString());
		
		
	}

	@org.junit.jupiter.api.Test
	void testRotateLeft() {
		testRotateTree.add(100);
		testRotateTree.add(80);
		testRotateTree.add(75);
		
		testRotateTree.rotateLeft(testRotateTree.getRoot());
		
		testRotateTree.inOrder(testRotateTree.getRoot());
		assertEquals("75 80 100 ", captureOutputStream.toString());
	}

	@org.junit.jupiter.api.Test
	void testRotateRight() {
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
	@org.junit.jupiter.api.Test
	void testInOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.inOrder(testInitializedTree.getRoot());	
		assertEquals("75 80 90 100 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testCompleteTree.inOrder(testCompleteTree.getRoot());	
		assertEquals("75.1 80.1 90.0 100.1 110.2 120.1 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testFullTree.inOrder(testFullTree.getRoot());	
		assertEquals("75.1 80.1 90.1 100.1 110.1 120.1 130.1 ", captureOutputStream.toString());
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
	

	@org.junit.jupiter.api.Test
	void testPreOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.preOrder(testInitializedTree.getRoot());	
		assertEquals("100 80 75 90 120 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testCompleteTree.preOrder(testCompleteTree.getRoot());	
		assertEquals("100.1 80.1 75.1 90.0 120.1 110.2 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testFullTree.preOrder(testFullTree.getRoot());	
		assertEquals("100.1 80.1 75.1 90.1 120.1 110.1 130.1 ", captureOutputStream.toString());
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
	
	
	@org.junit.jupiter.api.Test
	void testPostOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.postOrder(testInitializedTree.getRoot());	
		assertEquals("75 90 80 120 100 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testCompleteTree.postOrder(testCompleteTree.getRoot());	
		assertEquals("75.1 90.0 80.1 110.2 120.1 100.1 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testFullTree.postOrder(testFullTree.getRoot());	
		assertEquals("75.1 90.1 80.1 110.1 130.1 120.1 100.1 ", captureOutputStream.toString());
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
	
	@org.junit.jupiter.api.Test
	void testLevelOrder() {
		//ensure nodes are all initialized properly
		testInitializedTree.levelOrder(testInitializedTree.getRoot());	
		assertEquals("100 80 120 75 90 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testCompleteTree.levelOrder(testCompleteTree.getRoot());	
		assertEquals("100.1 80.1 120.1 75.1 90.0 110.2 ", captureOutputStream.toString());
		captureOutputStream.reset();
		
		testFullTree.levelOrder(testFullTree.getRoot());	
		assertEquals("100.1 80.1 120.1 75.1 90.1 110.1 130.1 ", captureOutputStream.toString());
		captureOutputStream.reset();
	}


	@org.junit.jupiter.api.Test
	void testFindMax() {
		Throwable e = null;
		try {
			testEmptyTree.findMax(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(120, testInitializedTree.findMax(testInitializedTree.getRoot()));
		assertEquals(120.1f, testCompleteTree.findMax(testCompleteTree.getRoot()));
		assertEquals(130.1, testFullTree.findMax(testFullTree.getRoot()));
		assertEquals(100, testLeftLeaningTree.findMax(testLeftLeaningTree.getRoot()));
		assertEquals("d", testRightLeaningTree.findMax(testRightLeaningTree.getRoot()));
	}

	@org.junit.jupiter.api.Test
	void testFindMin() {
		Throwable e = null;
		try {
			testEmptyTree.findMin(testEmptyTree.getRoot());
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		assertEquals(75, testInitializedTree.findMin(testInitializedTree.getRoot()));
		assertEquals(75.1f, testCompleteTree.findMin(testCompleteTree.getRoot()));
		assertEquals(75.1, testFullTree.findMin(testFullTree.getRoot()));
		assertEquals(70, testLeftLeaningTree.findMin(testLeftLeaningTree.getRoot()));
		assertEquals("a", testRightLeaningTree.findMin(testRightLeaningTree.getRoot()));
	}

	@org.junit.jupiter.api.Test
	void testIsEmpty() {
		assertTrue(testEmptyTree.isEmpty());
		assertFalse(testInitializedTree.isEmpty());
		assertFalse(testCompleteTree.isEmpty());
		assertFalse(testFullTree.isEmpty());
	}

	@org.junit.jupiter.api.Test
	void testClear() {
		//clear all nodes in bst
		testInitializedTree.clear();
		//bst should equal 0 after clear
		assertEquals(0, testInitializedTree.nodeCount());
		//ensure isEmpty returns true
		assertTrue(testInitializedTree.isEmpty());
		Throwable e = null;
		try {
			//make sure users cannot find node which doesn't exist
			assertNull(testInitializedTree.search(100));
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);

	}

}
