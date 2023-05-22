package edu.sru.thangiah.datastructures.linkedlist;

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
 * JUnit class for testing methods in single linked list class
 */
/**
 * <p>Title: SingleLinkedListTest</p>
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
public class SingleLinkedListTest {
	
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
	private SingleLinkedList testEmptyList = new SingleLinkedList();
	/**
	 * Initialized list with a few nodes to ensure proper functionality of a simple linked list
	 */
	private SingleLinkedList testInitializedList = new SingleLinkedList();
	private SingleLinkedList testSingleNodeList = new SingleLinkedList();
	
	/**
	 * Used to reinitialize the examples tested for in our JUnit test methods. We use this method to intialize standard output to our ByteArrayStream custom output stream
	 */
	@BeforeEach
	public void setUp()
	{
		System.setOut(new PrintStream(captureOutputStream));
		testInitializedList.addLast(50);
		testInitializedList.addLast(1000);
		testInitializedList.addLast(600);
		testInitializedList.addLast(8);
		testInitializedList.addLast(1111);
		testInitializedList.addLast(222);
		
		testSingleNodeList.addLast(50);
	}
	
	/**
	 * Resets output to standard output and clears the linked list examples
	 */
	@AfterEach
	public void tearDown()
	{
		testInitializedList.clear();
		testSingleNodeList.clear();
		testEmptyList.clear();
		System.setOut(standardOut);
	}
	
	@Test
	void testSize() {
		assertEquals(0, testEmptyList.size());
		assertEquals(6, testInitializedList.size());
	}

	@Test
	void testIsEmpty() {
		assertFalse(testInitializedList.isEmpty());
		assertTrue(testEmptyList.isEmpty());
	}

	@Test
	void testClear() {
		testInitializedList.clear();
		assertTrue(testInitializedList.isEmpty());
	}

	@Test
	void testContains() {
		assertTrue(testInitializedList.contains(50));
	}
	
	@Test
	void testIndexOf() {
		
		assertEquals(testInitializedList.indexOf(50), 1);
		assertEquals(testInitializedList.indexOf(222), 6);
		assertEquals(testInitializedList.indexOf(8), 4);
		
		assertThrows(NoSuchElementException.class, () -> testEmptyList.indexOf(5));
	}
	
	@Test
	void testAddFirst() {
		assertEquals(testInitializedList.indexOf(50), 1);
		testInitializedList.addFirst(100);
		assertEquals(testInitializedList.indexOf(100), 1);
		assertEquals(testInitializedList.indexOf(50), 2);
	}
	
	@Test
	void testRemoveFirst() {
		
		assertEquals(testInitializedList.indexOf(50), 1);
		assertEquals(testInitializedList.removeFirst(),50);
		assertEquals(testInitializedList.indexOf(1000), 1);
		
		assertThrows(NoSuchElementException.class, () -> testEmptyList.removeFirst());
	}
	
	@Test
	void testAddLast() {
		assertEquals(testInitializedList.indexOf(222), 6);
		testInitializedList.addLast(100);
		assertEquals(testInitializedList.indexOf(100), 7);
		assertEquals(testInitializedList.indexOf(222), 6);
	}
	
	@Test
	void testRemoveLast() {
		assertEquals(testInitializedList.indexOf(222), 6);
		assertEquals(testInitializedList.removeLast(),222);
		assertFalse(testInitializedList.contains(222));
		
		assertThrows(NoSuchElementException.class, () -> testEmptyList.removeLast());
	}
	
	@Test
	void testGetFirst() {
		
		assertEquals(testInitializedList.getFirst().toString(),"50");
		testInitializedList.addFirst(100);
		assertEquals(testInitializedList.getFirst().toString(),"100");
		assertEquals(testInitializedList.removeFirst(),100);
		assertEquals(testInitializedList.getFirst().toString(),"50");
		
		assertThrows(NoSuchElementException.class, () -> testEmptyList.getFirst());
	}
	
	@Test
	void testGetLast() {
		assertEquals(testInitializedList.getLast().toString(),"222");
		testInitializedList.addLast(555);
		assertEquals(testInitializedList.getLast().toString(),"555");
		assertEquals(testInitializedList.removeLast(),555);
		assertEquals(testInitializedList.getLast().toString(),"222");
		
		assertThrows(NoSuchElementException.class, () -> testEmptyList.getLast());
	}
	
	@Test
	void testDeletePrev() {
		assertEquals(testInitializedList.indexOf(600), 3);
		assertTrue(testInitializedList.contains(600));
		assertEquals(testInitializedList.delPrev(8).toString(), "600");
		assertFalse(testInitializedList.contains(600));
		assertEquals(testInitializedList.indexOf(8), 3);
	}
	
	@Test
	void testGetAtIndex() {
		assertEquals(testInitializedList.getAtIndex(1).toString(), "50");
		testInitializedList.addFirst(100);
		assertEquals(testInitializedList.getAtIndex(1).toString(), "100");
		
		assertThrows(IndexOutOfBoundsException.class, () -> testEmptyList.getAtIndex(5));
	}
	
	@Test
	void testSetAtIndex() {
		assertEquals(testInitializedList.getAtIndex(3).toString(), "600");
		assertEquals(testInitializedList.setAtIndex(3,5555), 5555);
		assertEquals(testInitializedList.getAtIndex(3).toString(), "5555");
		
		assertThrows(IndexOutOfBoundsException.class, () -> testEmptyList.setAtIndex(3,3));
	}
	
	@Test
	void testRemoveAtIndex() {
		assertEquals(testInitializedList.getAtIndex(3).toString(), "600");
		assertEquals(testInitializedList.removeAtIndex(3), 600);
		assertEquals(testInitializedList.getAtIndex(3).toString(), "8");
		assertEquals(testInitializedList.getAtIndex(4).toString(), "1111");
		//assertEquals(testEmptyList.removeAtIndex(5), -1);
		
		assertThrows(IndexOutOfBoundsException.class, () -> testEmptyList.removeAtIndex(-1));
	}
	
	@Test
	void testAddAtIndex() {
		assertEquals(testInitializedList.getAtIndex(3).toString(), "600");
		assertEquals(testInitializedList.addAtIndex(3,5555), 5555);
		assertEquals(testInitializedList.getAtIndex(3).toString(), "5555");
		assertEquals(testInitializedList.getAtIndex(4).toString(), "600");
		
		assertThrows(IndexOutOfBoundsException.class, () -> testEmptyList.addAtIndex(5,5));
	}
}