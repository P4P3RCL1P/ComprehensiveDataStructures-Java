package edu.sru.thangiah.datastructures.tree.redblacktree;

//used for assertFuzzyEquals so we can test the output of insertion
//src: https://web-cat.org/junit-quickstart/


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class RedBlackTreeTest {
	
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream captureOutputStream = new ByteArrayOutputStream();
	
	
	private RedBlackTree testEmptyTree = new RedBlackTree();
	private RedBlackTree testInitializedTree = new RedBlackTree();
	private RedBlackTree testInitializedTree2 = new RedBlackTree();
	private RedBlackTree testInitializedTree3 = new RedBlackTree();
	private RedBlackTree testInitializedTree4 = new RedBlackTree();
	private RedBlackTree testAddTree = new RedBlackTree();
	
	@BeforeEach
	public void setUp()
	{
		System.setOut(new PrintStream(captureOutputStream));
		testInitializedTree.add(75);
		testInitializedTree.add(80);
		testInitializedTree.add(90);
		testInitializedTree.add(100);
		testInitializedTree.add(120);
		
		testInitializedTree2.add(120);
		testInitializedTree2.add(100);
		testInitializedTree2.add(90);
		testInitializedTree2.add(80);
		testInitializedTree2.add(75);
		
		testInitializedTree3.add(75);
		testInitializedTree3.add(80);
		testInitializedTree3.add(76);
		testInitializedTree3.add(60);
		testInitializedTree3.add(90);
		
		testInitializedTree4.add(80);
		testInitializedTree4.add(75);
		testInitializedTree4.add(76);
		testInitializedTree4.add(60);
		testInitializedTree4.add(90);
		
	}
	@AfterEach
	public void tearDown()
	{
		System.setOut(standardOut);
		testInitializedTree.clear();
		testInitializedTree2.clear();
		testInitializedTree3.clear();
		testInitializedTree4.clear();
	}
	
	@Test
	void testHeight() {
		assertEquals(testEmptyTree.height(testEmptyTree.getRoot()),0);
		assertEquals(testInitializedTree.height(testInitializedTree.getRoot()),3);
		assertEquals(testInitializedTree2.height(testInitializedTree2.getRoot()),3);
		assertEquals(testInitializedTree3.height(testInitializedTree3.getRoot()),3);
		assertEquals(testInitializedTree4.height(testInitializedTree4.getRoot()),3);
	}

	@Test
	void testNodeCount() {
		assertEquals(testEmptyTree.nodeCount(),0);
		assertEquals(testInitializedTree.nodeCount(),5);
	}

	@Test
	void testInsertInt() {
		
		testAddTree.insert(100);
		testAddTree.insert(80);
		testAddTree.insert(120);
		testAddTree.insert(90);
		testAddTree.insert(75);
		
		assertEquals(testAddTree.nodeCount(),5);
		testInitializedTree.inOrder(testAddTree.getRoot());
		assertEquals("75 80 90 100 120 ", captureOutputStream.toString());
	
		
		
	}

	@Test
	void testLocateNode() {
		assertEquals(testInitializedTree.locateNode(testInitializedTree.getRoot(), 75).getData(),75);
	}

	@Test
	void testGetLargest() {
		assertEquals(testInitializedTree.findMax(testInitializedTree.getRoot()),120);
	}

	@Test
	void testGetSmallest() {
		assertEquals(testInitializedTree.findMin(testInitializedTree.getRoot()),75);
	}
	
	@Test
	void testFindMaxRedBlackTreeNode() {
		assertEquals(testInitializedTree.findMax(testInitializedTree.getRoot()),120);
	}

	@Test
	void testFindMinRedBlackTreeNode() {
		assertEquals(testInitializedTree.findMin(testInitializedTree.getRoot()),75);
	}

	@Test
	void testAdd() {
		testAddTree.add(100);
		testAddTree.add(80);
		testAddTree.add(120);
		testAddTree.add(90);
		testAddTree.add(75);
		
		assertEquals(testAddTree.nodeCount(),5);
		testInitializedTree.inOrder(testAddTree.getRoot());
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

}