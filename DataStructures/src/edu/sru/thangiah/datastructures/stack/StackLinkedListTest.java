package edu.sru.thangiah.datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackLinkedListTest {

	StackLinkedList fullStack = new StackLinkedList();
	
	StackLinkedList emptyStack = new StackLinkedList();
	
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
	void testPop() {

		assertEquals(fullStack.pop(),6);
		
		assertEquals(fullStack.pop(),5);

		assertEquals(fullStack.pop(),4);
	
	}

	@Test
	void testTop() {

		assertEquals(fullStack.top(),6);
	
	}

	@Test
	void testIsEmpty() {
		
		assertTrue(emptyStack.isEmpty());
		
		assertFalse(fullStack.isEmpty());

	}

	@Test
	void testGetFirst() {

		assertEquals(fullStack.getFirst(),6);
		
		fullStack.remove();
		
		assertEquals(fullStack.getFirst(),5);
		
		fullStack.remove();
		
		assertEquals(fullStack.getFirst(),4);
		
		fullStack.remove();
		
		assertEquals(emptyStack.getFirst(),-1);
	
	}

	@Test
	void testPushInt() {

		assertTrue(emptyStack.isEmpty());
	
		assertTrue(emptyStack.push(1));
		
		assertEquals(emptyStack.pop(),1);
		
		assertTrue(fullStack.push(3));
		
		assertEquals(fullStack.pop(),3);
		
	}

	@Test
	void testRemove() {

		assertEquals(fullStack.remove(),6);
		
		assertEquals(fullStack.remove(),5);

		assertEquals(fullStack.remove(),4);
	
	}

}
