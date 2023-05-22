package edu.sru.thangiah.datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.sru.thangiah.datastructures.generic.stack.StackArrayGeneric;

public class StackArrayTest {
	
	StackArray fullStack = new StackArray();
	
	StackArray emptyStack = new StackArray();


	@BeforeEach
	void setUp() throws Exception {
		
		fullStack.push(1);
		fullStack.push(2);
		fullStack.push(3);
		fullStack.push(4);
		fullStack.push(5);
		fullStack.push(6);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		fullStack.clear();
		emptyStack.clear();
		
	}

	@Test
	void testPush() {
		
		emptyStack.push(4);
		
		assertEquals(emptyStack.getFirst(),4);
		
		fullStack.push(7);
		
		assertEquals(fullStack.getFirst(),7);	
		
	}

	@Test
	void testPop() {
		
		assertEquals(fullStack.pop(), 6);
		
		assertEquals(fullStack.pop(), 5);	
	
	}

	@Test
	void testTop() {
		
		assertEquals(fullStack.top(), 6);
		
		assertEquals(fullStack.top(), 5);
		
		assertEquals(emptyStack.top(), -1);
		
	}

	@Test
	void testIsEmpty() {
		
		assertTrue(emptyStack.isEmpty());
		
		assertFalse(fullStack.isEmpty());	
		
	}

	@Test
	void testIsFull() {

		assertFalse(fullStack.isFull());
				
		assertFalse(emptyStack.isFull());
		
		final int MAXSIZE = 100;
		
		for(int i=0;i<MAXSIZE;i++) {
			
			emptyStack.push(i);
			
		}
		
		assertTrue(emptyStack.isFull());
		
	}

	@Test
	void testGetFirst() {
		
		assertEquals(fullStack.getFirst(), 6);
		
		assertEquals(fullStack.getFirst(), 5);	
		
		assertEquals(emptyStack.getFirst(), -1);
		
	}

	@Test
	void testRemove() {

		assertEquals(fullStack.remove(),6);
		
		assertEquals(fullStack.remove(),5);
		
		assertEquals(emptyStack.remove(),-1);

	}

}
