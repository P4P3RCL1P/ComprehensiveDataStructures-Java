package edu.sru.thangiah.datastructures.generic.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackArrayGenericTest {

	/**
	 * Fully initialized stack of integer values
	 */
	StackArrayGeneric<Integer> stackIntegerFull = new StackArrayGeneric();

	/**
	 * Fully initialized stack of String values
	 */
	StackArrayGeneric<String> stackStringFull = new StackArrayGeneric();

	
	/**
	 * Empty stack of integer values
	 */
	StackArrayGeneric<Integer> stackIntegerEmpty = new StackArrayGeneric();

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
	void testIndexOf() {

		assertEquals(stackIntegerFull.indexOf(6), 0);
		
		stackIntegerFull.pop();
		
		assertEquals(stackIntegerFull.indexOf(5), 0);
		
		assertEquals(stackStringFull.indexOf("string5"), 0);

		assertEquals(stackIntegerEmpty.indexOf(1), -1);

	}

	@Test
	void testContainsObject() {
		
		assertFalse(stackIntegerEmpty.contains(4));
		
		stackIntegerEmpty.push(4);
		
		assertTrue(stackIntegerEmpty.contains(4));
		
		assertTrue(stackStringFull.contains("string4"));
		
		assertTrue(stackIntegerFull.contains(3));
		
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
	void testIsFull() {
	
		assertFalse(stackIntegerFull.isFull());
				
		assertFalse(stackIntegerEmpty.isFull());
		
		final int MAXSIZE = 50;
		
		StackArrayGeneric fullStack=new StackArrayGeneric();
		
		for(int i=0;i<MAXSIZE;i++) {
			
			fullStack.push(i+" ");
			
		}
		
		assertTrue(fullStack.isFull()); 

	}

	@Test
	void testPushObject() {

		assertFalse(stackIntegerEmpty.contains(4));
		
		stackIntegerEmpty.push(4);
		
		assertTrue(stackIntegerEmpty.contains(4));
		
		stackIntegerFull.push(7);
		
		assertTrue(stackIntegerFull.contains(7));
		
	}

}
