package edu.sru.thangiah.datastructures.generic.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackLinkedListGenericTest {

	/**
	 * Fully initialized stack of integer values
	 */
	StackLinkedListGeneric<Integer> stackIntegerFull = new StackLinkedListGeneric();

	/**
	 * Fully initialized stack of String values
	 */
	StackLinkedListGeneric<String> stackStringFull = new StackLinkedListGeneric();

	/**
	 * Empty stack of integer values
	 */
	StackLinkedListGeneric<Integer> stackIntegerEmpty = new StackLinkedListGeneric();
	
	@BeforeEach
	void setUp() throws Exception {
		
		stackIntegerFull.push(1);
		stackIntegerFull.push(2);
		stackIntegerFull.push(3);
		stackIntegerFull.push(4);
		stackIntegerFull.push(5);
		stackIntegerFull.push(6);
		
		stackStringFull.push("string1");
		stackStringFull.push("string2");
		stackStringFull.push("string3");
		stackStringFull.push("string4");
		stackStringFull.push("string5");
	
	}


	@AfterEach
	void tearDown() throws Exception {
		
		stackIntegerFull.clear();
		
		stackIntegerEmpty.clear();
		
		stackStringFull.clear();
		
	}

	@Test
	void testSize() {
		
		assertEquals(stackIntegerFull.size(), 6);
		
		stackIntegerFull.pop();
		
		assertEquals(stackIntegerFull.size(), 5);
		
		assertEquals(stackStringFull.size(), 5);
		
		assertEquals(stackIntegerEmpty.size(), 0);
	
	}

	@Test
	void testClear() {
		
		assertEquals(stackIntegerFull.size(), 6);
		
		stackIntegerFull.clear();

		assertNull(stackIntegerFull.top());
		
	}

	@Test
	void testAdd() {
		
		assertTrue(stackIntegerEmpty.isEmpty());
		
		stackIntegerEmpty.push(4);
		
		assertEquals(stackIntegerEmpty.pop(),4);
		
		stackIntegerFull.push(7);
		
		assertEquals(stackIntegerFull.pop(),7);		
		
	}

	@Test
	void testRemove() {

		assertEquals(stackIntegerFull.pop(), 6);
		
		assertEquals(stackIntegerFull.pop(), 5);
		
		assertEquals(stackStringFull.pop(), "string5");
		
		assertNull(stackIntegerEmpty.pop());
		
	}

	@Test
	void testGetFirst() {
		
		assertEquals(stackIntegerFull.getFirst(),stackIntegerFull.top());
		
		assertEquals(stackIntegerEmpty.getFirst(),stackIntegerEmpty.top());

		assertEquals(stackStringFull.getFirst(),stackStringFull.top());
		
	}

	@Test
	void testIsEmpty() {

		assertTrue(stackIntegerEmpty.isEmpty());
		
		assertFalse(stackIntegerFull.isEmpty());
		
		stackIntegerFull.clear();
		
		assertFalse(stackStringFull.isEmpty());
		
		assertTrue(stackIntegerFull.isEmpty());
		
	}

	@Test
	void testPushT() {

		assertTrue(stackIntegerEmpty.isEmpty());
		
		stackIntegerEmpty.push(4);
		
		assertEquals(stackIntegerEmpty.pop(),4);
		
		stackIntegerFull.push(7);
		
		assertEquals(stackIntegerFull.pop(),7);	
	}

	@Test
	void testAddFirstT() {
		
		assertTrue(stackIntegerEmpty.isEmpty());
		
		stackIntegerEmpty.addFirst(4);
		
		assertEquals(stackIntegerEmpty.pop(),4);
		
		stackIntegerFull.addFirst(7);
		
		assertEquals(stackIntegerFull.pop(),7);	
		
	}

	@Test
	void testRemoveFirst() {
		
		assertEquals(stackIntegerFull.getFirst(),6);
		
		stackIntegerFull.removeFirst();
		
		assertEquals(stackIntegerFull.getFirst(),5);

		stackIntegerFull.removeFirst();

		assertEquals(stackIntegerFull.getFirst(), 4);	}

	@Test
	void testPop() {
		
		assertEquals(stackIntegerFull.pop(), 6);
		
		assertEquals(stackIntegerFull.pop(), 5);
		
		assertEquals(stackStringFull.pop(), "string5");
		
		assertNull(stackIntegerEmpty.pop());
		
	}

	@Test
	void testTop() {
		
		assertEquals(stackIntegerFull.top(), 6);
		
		stackIntegerFull.pop();
		
		assertEquals(stackIntegerFull.top(), 5);
		
		assertEquals(stackStringFull.top(), "string5");
		
		assertNull(stackIntegerEmpty.top());
		
	}

	@Test
	void testGetLast() {
		
		assertEquals(stackIntegerFull.getLast(), 1);
		
		assertEquals(stackStringFull.getLast(), "string1");
		
		stackStringFull.setAtIndex(5, "new last string");
		
		assertEquals(stackStringFull.getLast(), "new last string");
		
	}

	@Test
	void testGetAtIndexInt() {

		assertEquals(stackIntegerFull.top(),stackIntegerFull.getAtIndex(1));
		
		stackIntegerFull.setAtIndex(1,9);
		
		assertEquals(stackIntegerFull.getAtIndex(1),9);

		stackIntegerFull.setAtIndex(3,9);

		assertEquals(stackIntegerFull.getAtIndex(3), 9);
		
		assertEquals(stackStringFull.getAtIndex(1), "string5");
		
	}

	@Test
	void testSetAtIndexIntT() {
		
		assertEquals(stackIntegerFull.top(),6);
		
		stackIntegerFull.setAtIndex(1,9);
		
		assertEquals(stackIntegerFull.top(),9);

		stackIntegerFull.setAtIndex(3,9);

		assertEquals(stackIntegerFull.getAtIndex(3), 9);

	}

	@Test
	void testToString() {

		assertEquals(stackIntegerFull.toString(), " Head 6 5 4 3 2 1 Tail");
	
		assertEquals(stackStringFull.toString(), " Head string5 string4 string3 string2 string1 Tail");

		assertEquals(stackIntegerEmpty.toString(), " Head Tail");

	}

}
