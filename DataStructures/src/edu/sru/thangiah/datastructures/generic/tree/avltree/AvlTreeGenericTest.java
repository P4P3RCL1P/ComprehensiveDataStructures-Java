/**
 * JUnit class for testing all the methods in the AVL tree implementation
 */
package edu.sru.thangiah.datastructures.generic.tree.avltree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.sru.thangiah.datastructures.generic.tree.binarytree.BinaryTreeNodeGeneric;

/**
 * @author briso
 */

public class AvlTreeGenericTest {


	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream captureOutputStream = new ByteArrayOutputStream();
	
	
	private AvlTreeGeneric<Integer> testEmptyTree = new AvlTreeGeneric<Integer>();
	private AvlTreeGeneric<Integer> testInitializedTreeRight = new AvlTreeGeneric<Integer>();
	private AvlTreeGeneric<Integer> testInitializedTreeLeft = new AvlTreeGeneric<Integer>();
	private AvlTreeGeneric<Integer> testAddTree = new AvlTreeGeneric<Integer>();
	private AvlTreeGeneric<String> testStringTree = new AvlTreeGeneric<String>();
	private AvlTreeGeneric<Double> testDoubleTree = new AvlTreeGeneric<Double>();
	
	
	@BeforeEach
	public void setUp()
	{
		System.setOut(new PrintStream(captureOutputStream));
		
		testInitializedTreeRight.add(75);
		testInitializedTreeRight.add(80);
		testInitializedTreeRight.add(90);
		testInitializedTreeRight.add(100);
		testInitializedTreeRight.add(120);
		
		testInitializedTreeLeft.add(120);
		testInitializedTreeLeft.add(100);
		testInitializedTreeLeft.add(90);
		testInitializedTreeLeft.add(80);
		testInitializedTreeLeft.add(75);
		testInitializedTreeLeft.add(70);
		testInitializedTreeLeft.add(65);
		
		testStringTree.add("abcdefgh");
		testStringTree.add("bcdefghijkl");
		testStringTree.add("abdefh");
		
		testDoubleTree.add(75.0);
		testDoubleTree.add(70.0);
		testDoubleTree.add(72.5);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		testInitializedTreeRight.clear();
		testInitializedTreeLeft.clear();
		testEmptyTree.clear();
		testAddTree.clear();
	}

	@Test
	void testLocateNode() {
		assertEquals(testInitializedTreeRight.locateNode(testInitializedTreeRight.getRoot(), 75).getData(),75);
	}

	@Test
	void testRemove() {
		assertEquals(testInitializedTreeRight.locateNode(testInitializedTreeRight.getRoot(), 75).getData(),75);
		testInitializedTreeRight.remove(75);
	}
	
	@Test
	void testClear() {
		testInitializedTreeRight.clear();
		assertNull(testInitializedTreeRight.getRoot().getData());
	}

	@Test
	void testAdd() {
		testAddTree.add(100);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),0);
		testAddTree.add(80);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		testAddTree.add(120);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),0);
		testAddTree.add(90);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		testAddTree.add(75);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		testAddTree.add(75);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		assertEquals(testAddTree.getRoot().getData(),100); //root is 100 before rotate
		
		testAddTree.add(70); //causes a leftleft rotate
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),0); 
		
		
		assertEquals(testAddTree.nodeCount(),6);
		assertEquals(testAddTree.getRoot().getData(),80); //node rotates to 80
	}
	
	@Test
	void testInsert() {
		testAddTree.insert(100);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),0);
		testAddTree.insert(80);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		testAddTree.insert(120);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),0);
		testAddTree.insert(90);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		testAddTree.insert(75);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		testAddTree.insert(75);
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),1);
		assertEquals(testAddTree.getRoot().getData(),100); //root is 100 before rotate
		
		testAddTree.insert(70); //causes a leftleft rotate
		assertEquals(testAddTree.checkBalance(testAddTree.getRoot()),0); 
		
		
		assertEquals(testAddTree.nodeCount(),6);
		assertEquals(testAddTree.getRoot().getData(),80); //node rotates to 80
	}
	
	@Test
	void testCheckBalance() { //this does left height - right height, should never be above 2 or below -2
		assertEquals(testEmptyTree.checkBalance(testEmptyTree.getRoot()),0); //null node = 0
		assertEquals(testInitializedTreeRight.checkBalance(testInitializedTreeRight.getRoot()),-1);
		assertEquals(testInitializedTreeLeft.checkBalance(testInitializedTreeLeft.getRoot()),1);
		assertEquals(testStringTree.checkBalance(testStringTree.getRoot()),0);
		assertEquals(testDoubleTree.checkBalance(testDoubleTree.getRoot()),0);

	}
	
	@Test
	void testHeight() {
		assertEquals(testInitializedTreeRight.height(testInitializedTreeRight.getRoot()), 3);
		assertEquals(testInitializedTreeLeft.height(testInitializedTreeLeft.getRoot()), 4);
		assertEquals(testStringTree.height(testStringTree.getRoot()), 2);
		assertEquals(testDoubleTree.height(testDoubleTree.getRoot()), 2);
		assertEquals(testEmptyTree.height(testEmptyTree.getRoot()), 0);

	}
	
	@Test
	void testGetRoot() {
		assertNotNull(testInitializedTreeRight.getRoot());
		assertNull(testEmptyTree.getRoot().getData());
		assertEquals(testInitializedTreeRight.getRoot().getData(),80);
	}

	@Test
	void testIsEmpty() {
		assertTrue(testEmptyTree.isEmpty());
		assertFalse(testInitializedTreeRight.isEmpty());
	}
	
	

}
