package edu.sru.thangiah.datastructures.generic.linkedlist;

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
 * JUnit test class which houses the example single linked list data sets as well as the tested methods
 */

/**
 * <p>Title: SingleLinkedListGenericTest</p>
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
public class SingleLinkedListGenericTest {
	
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
	private SingleLinkedListGeneric <Integer> testEmptyList = new SingleLinkedListGeneric<Integer>();
	/**
	 * Intialized list with a few nodes to ensure proper functionality of a simple linked list
	 */
	private SingleLinkedListGeneric <Integer> testInitializedList = new SingleLinkedListGeneric<Integer>();
	private SingleLinkedListGeneric <String> testStringList = new SingleLinkedListGeneric<String>();
	private SingleLinkedListGeneric <Double> testDoubleList = new SingleLinkedListGeneric<Double>();
	//private SingleLinkedListGeneric testAddList = new SingleLinkedListGeneric();
	//private SingleLinkedListGeneric testRemoveList = new SingleLinkedListGeneric();
	
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
		
		testStringList.addLast("One");
		testStringList.addLast("Two");
		testStringList.addLast("Three");
		testStringList.addLast("Four");
		testStringList.addLast("Five");
		testStringList.addLast("Six");
		
		testDoubleList.addLast(1.1);
		testDoubleList.addLast(2.2);
		testDoubleList.addLast(3.3);
		testDoubleList.addLast(4.4);
		testDoubleList.addLast(5.5);
		testDoubleList.addLast(6.6);
	}
	/**
	 * Resets output to standard output and clears the linked list examples
	 */
	@AfterEach
	public void tearDown()
	{
		testInitializedList.clear();
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
		assertTrue(testStringList.contains("Five"));
		assertTrue(testDoubleList.contains(2.2));
	}
	
	@Test
	void testIndexOf() {
		assertEquals(testInitializedList.indexOf(50), 1);
		assertEquals(testInitializedList.indexOf(222), 6);
		assertEquals(testInitializedList.indexOf(8), 4);
		
		assertEquals(testStringList.indexOf("One"), 1);
		
		assertEquals(testDoubleList.indexOf(3.3), 3);
	}
	
	@Test
	void testAddFirst() {
		assertEquals(testInitializedList.indexOf(50), 1);
		testInitializedList.addFirst(100);
		assertEquals(testInitializedList.indexOf(100), 1);
		assertEquals(testInitializedList.indexOf(50), 2);
		
		assertEquals(testStringList.indexOf("One"), 1);
		testStringList.addFirst("Zero");
		assertEquals(testStringList.indexOf("Zero"), 1);
		assertEquals(testStringList.indexOf("One"), 2);
		
		assertEquals(testDoubleList.indexOf(1.1), 1);
		testDoubleList.addFirst(9.9);
		assertEquals(testDoubleList.indexOf(9.9), 1);
		assertEquals(testDoubleList.indexOf(1.1), 2);
	}
	
	@Test
	void testRemoveFirst() {
		assertEquals(testInitializedList.indexOf(50), 1);
		assertEquals(testInitializedList.removeFirst(),50);
		assertEquals(testInitializedList.indexOf(1000), 1);
		
		assertEquals(testStringList.indexOf("One"), 1);
		assertEquals(testStringList.removeFirst(), "One");
		assertEquals(testStringList.indexOf("Two"), 1);
		
		assertEquals(testDoubleList.indexOf(1.1), 1);
		assertEquals(testDoubleList.removeFirst(),1.1);
		assertEquals(testDoubleList.indexOf(2.2), 1);
	}
	
	@Test
	void testAddLast() {
		assertEquals(testInitializedList.indexOf(222), 6);
		testInitializedList.addLast(100);
		assertEquals(testInitializedList.indexOf(100), 7);
		assertEquals(testInitializedList.indexOf(222), 6);
		
		assertEquals(testStringList.indexOf("Six"), 6);
		testStringList.addLast("Seven");
		assertEquals(testStringList.indexOf("Seven"), 7);
		assertEquals(testStringList.indexOf("Six"), 6);
		
		assertEquals(testDoubleList.indexOf(6.6), 6);
		testDoubleList.addLast(7.7);
		assertEquals(testDoubleList.indexOf(7.7), 7);
		assertEquals(testDoubleList.indexOf(6.6), 6);
	}
	
	@Test
	void testRemoveLast() {
		assertEquals(testInitializedList.indexOf(222), 6);
		assertEquals(testInitializedList.removeLast(),222);
		assertFalse(testInitializedList.contains(222));
		
		assertEquals(testStringList.indexOf("Six"), 6);
		assertEquals(testStringList.removeLast(),"Six");
		assertFalse(testStringList.contains("Six"));
		
		assertEquals(testDoubleList.indexOf(6.6), 6);
		assertEquals(testDoubleList.removeLast(),6.6);
		assertFalse(testDoubleList.contains(6.6));
	}
	
	@Test
	void testGetFirst() {
		assertEquals(testInitializedList.getFirst().toString(),"50");
		testInitializedList.addFirst(100);
		assertEquals(testInitializedList.getFirst().toString(),"100");
		assertEquals(testInitializedList.removeFirst(),100);
		assertEquals(testInitializedList.getFirst().toString(),"50");
		
		assertEquals(testStringList.getFirst().toString(),"One");
		testStringList.addFirst("Zero");
		assertEquals(testStringList.getFirst().toString(),"Zero");
		assertEquals(testStringList.removeFirst(),"Zero");
		assertEquals(testStringList.getFirst().toString(),"One");
		
		assertEquals(testDoubleList.getFirst().toString(),"1.1");
		testDoubleList.addFirst(9.9);
		assertEquals(testDoubleList.getFirst().toString(),"9.9");
		assertEquals(testDoubleList.removeFirst(),9.9);
		assertEquals(testDoubleList.getFirst().toString(),"1.1");
	}
	
	@Test
	void testGetLast() {
		assertEquals(testInitializedList.getLast().toString(),"222");
		testInitializedList.addLast(555);
		assertEquals(testInitializedList.getLast().toString(),"555");
		assertEquals(testInitializedList.removeLast(),555);
		assertEquals(testInitializedList.getLast().toString(),"222");
		
		assertEquals(testStringList.getLast().toString(),"Six");
		testStringList.addLast("Seven");
		assertEquals(testStringList.getLast().toString(),"Seven");
		assertEquals(testStringList.removeLast(),"Seven");
		assertEquals(testStringList.getLast().toString(),"Six");
		
		assertEquals(testDoubleList.getLast().toString(),"6.6");
		testDoubleList.addLast(7.7);
		assertEquals(testDoubleList.getLast().toString(),"7.7");
		assertEquals(testDoubleList.removeLast(),7.7);
		assertEquals(testDoubleList.getLast().toString(),"6.6");
	}
	
	@Test
	void testDeletePrev() {
		assertEquals(testInitializedList.indexOf(600), 3);
		assertEquals(testInitializedList.delPrev(8).toString(), "600");
		assertFalse(testInitializedList.contains(600));
		assertEquals(testInitializedList.indexOf(8), 3);
		
		assertEquals(testStringList.indexOf("Three"), 3);
		assertEquals(testStringList.delPrev("Four").toString(), "Three");
		assertFalse(testStringList.contains("Three"));
		assertEquals(testStringList.indexOf("Four"), 3);
		
		assertEquals(testDoubleList.indexOf(3.3), 3);
		assertEquals(testDoubleList.delPrev(4.4).toString(), "3.3");
		assertFalse(testDoubleList.contains(3.3));
		assertEquals(testDoubleList.indexOf(4.4), 3);
	}
	@Test
	void testGetAtIndex() {
		assertEquals(testInitializedList.getAtIndex(1).toString(), "50");
		testInitializedList.addFirst(100);
		assertEquals(testInitializedList.getAtIndex(1).toString(), "100");
		
		assertEquals(testStringList.getAtIndex(1).toString(), "One");
		testStringList.addFirst("Zero");
		assertEquals(testStringList.getAtIndex(1).toString(), "Zero");
		
		assertEquals(testDoubleList.getAtIndex(1).toString(), "1.1");
		testDoubleList.addFirst(9.9);
		assertEquals(testDoubleList.getAtIndex(1).toString(), "9.9");
	}
	
	@Test
	void testSetAtIndex() {
		assertEquals(testInitializedList.getAtIndex(3).toString(), "600");
		assertEquals(testInitializedList.setAtIndex(3,5555), 5555);
		assertEquals(testInitializedList.getAtIndex(3).toString(), "5555");
		
		assertEquals(testStringList.getAtIndex(3).toString(), "Three");
		assertEquals(testStringList.setAtIndex(3,"Ten"), "Ten");
		assertEquals(testStringList.getAtIndex(3).toString(), "Ten");
		
		assertEquals(testDoubleList.getAtIndex(3).toString(), "3.3");
		assertEquals(testDoubleList.setAtIndex(3,8.8), 8.8);
		assertEquals(testDoubleList.getAtIndex(3).toString(), "8.8");
	}
	
	@Test
	void testRemoveAtIndex() {
		assertEquals(testInitializedList.getAtIndex(3).toString(), "600");
		assertEquals(testInitializedList.removeAtIndex(3), 600);
		assertEquals(testInitializedList.getAtIndex(3).toString(), "8");
		assertEquals(testInitializedList.getAtIndex(4).toString(), "1111");
		
		assertEquals(testStringList.getAtIndex(3).toString(), "Three");
		assertEquals(testStringList.removeAtIndex(3), "Three");
		assertEquals(testStringList.getAtIndex(3).toString(), "Four");
		assertEquals(testStringList.getAtIndex(4).toString(), "Five");

		assertEquals(testDoubleList.getAtIndex(3).toString(), "3.3");
		assertEquals(testDoubleList.removeAtIndex(3), 3.3);
		assertEquals(testDoubleList.getAtIndex(3).toString(), "4.4");
		assertEquals(testDoubleList.getAtIndex(4).toString(), "5.5");
	}
	
	@Test
	void testAddAtIndex() {
		assertEquals(testInitializedList.getAtIndex(3).toString(), "600");
		assertEquals(testInitializedList.addAtIndex(3,5555), 5555);
		assertEquals(testInitializedList.getAtIndex(3).toString(), "5555");
		assertEquals(testInitializedList.getAtIndex(4).toString(), "600");
		
		assertEquals(testStringList.getAtIndex(3).toString(), "Three");
		assertEquals(testStringList.addAtIndex(3,"Ten"), "Ten");
		assertEquals(testStringList.getAtIndex(3).toString(), "Ten");
		assertEquals(testStringList.getAtIndex(4).toString(), "Three");
		
		assertEquals(testDoubleList.getAtIndex(3).toString(), "3.3");
		assertEquals(testDoubleList.addAtIndex(3,8.8), 8.8);
		assertEquals(testDoubleList.getAtIndex(3).toString(), "8.8");
		assertEquals(testDoubleList.getAtIndex(4).toString(), "3.3");
	}

}