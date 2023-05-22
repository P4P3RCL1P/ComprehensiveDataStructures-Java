package edu.sru.thangiah.datastructures.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueVectorTest {

	QueueVector fullQueue = new QueueVector();
	
	QueueVector emptyQueue = new QueueVector();
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		fullQueue.enQueue(1);
		fullQueue.enQueue(2);
		fullQueue.enQueue(3);
		fullQueue.enQueue(4);
		fullQueue.enQueue(5);
		fullQueue.enQueue(6);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		fullQueue.clear();
		
		emptyQueue.clear();
		
	}

	@Test
	void testIsEmpty() {

		assertTrue(emptyQueue.isEmpty());
		
		assertFalse(fullQueue.isEmpty());
	
	}

	@Test
	void testAddLast() {

		fullQueue.addLast(7);
	
		assertEquals(fullQueue.deQueue(),1);
		assertEquals(fullQueue.deQueue(),2);
		assertEquals(fullQueue.deQueue(),3);
		assertEquals(fullQueue.deQueue(),4);
		assertEquals(fullQueue.deQueue(),5);
		assertEquals(fullQueue.deQueue(),6);
		assertEquals(fullQueue.deQueue(),7);
		assertEquals(fullQueue.deQueue(),-1);

		assertEquals(emptyQueue.deQueue(),-1);
		
	}

	@Test
	void testRemoveFirst() {
		
		assertTrue(emptyQueue.enQueue(1));
		assertTrue(emptyQueue.enQueue(2));
		assertTrue(emptyQueue.enQueue(3));
		assertTrue(emptyQueue.enQueue(4));
		assertTrue(emptyQueue.enQueue(5));
		assertTrue(emptyQueue.enQueue(6));	
		
		assertEquals(emptyQueue.removeFirst(),1);
		assertEquals(emptyQueue.removeFirst(),2);
		assertEquals(emptyQueue.removeFirst(),3);
		assertEquals(emptyQueue.removeFirst(),4);
		assertEquals(emptyQueue.removeFirst(),5);
		assertEquals(emptyQueue.removeFirst(),6);

		
	}

	@Test
	void testEnQueue() {
		
		assertTrue(emptyQueue.enQueue(1));
		assertTrue(emptyQueue.enQueue(2));
		assertTrue(emptyQueue.enQueue(3));
		assertTrue(emptyQueue.enQueue(4));
		assertTrue(emptyQueue.enQueue(5));
		assertTrue(emptyQueue.enQueue(6));
		
		assertEquals(emptyQueue.deQueue(),1);
		assertEquals(emptyQueue.deQueue(),2);
		assertEquals(emptyQueue.deQueue(),3);
		assertEquals(emptyQueue.deQueue(),4);
		assertEquals(emptyQueue.deQueue(),5);
		assertEquals(emptyQueue.deQueue(),6);

		assertEquals(emptyQueue.deQueue(),-1);	
		
	}

	@Test
	void testDeQueue() {
		
		assertEquals(fullQueue.deQueue(),1);
		assertEquals(fullQueue.deQueue(),2);
		assertEquals(fullQueue.deQueue(),3);
		assertEquals(fullQueue.deQueue(),4);
		assertEquals(fullQueue.deQueue(),5);
		assertEquals(fullQueue.deQueue(),6);
		
		assertEquals(fullQueue.deQueue(),-1);

		assertEquals(emptyQueue.deQueue(),-1);
		
	}

	@Test
	void testToString() {
		
		assertEquals(fullQueue.toString(), " 1 2 3 4 5 6");
		
	}

	@Test
	void testAdd() {

		assertTrue(emptyQueue.add(1));
		assertTrue(emptyQueue.add(2));
		assertTrue(emptyQueue.add(3));
		assertTrue(emptyQueue.add(4));
		assertTrue(emptyQueue.add(5));
		assertTrue(emptyQueue.add(6));
		
		assertEquals(emptyQueue.deQueue(),1);
		assertEquals(emptyQueue.deQueue(),2);
		assertEquals(emptyQueue.deQueue(),3);
		assertEquals(emptyQueue.deQueue(),4);
		assertEquals(emptyQueue.deQueue(),5);
		assertEquals(emptyQueue.deQueue(),6);

		assertEquals(emptyQueue.deQueue(),-1);		
		
	}

	@Test
	void testRemove() {

		assertTrue(emptyQueue.add(1));
		assertTrue(emptyQueue.add(2));
		assertTrue(emptyQueue.add(3));
		assertTrue(emptyQueue.add(4));
		assertTrue(emptyQueue.add(5));
		assertTrue(emptyQueue.add(6));
		
		assertEquals(emptyQueue.remove(),1);
		assertEquals(emptyQueue.remove(),2);
		assertEquals(emptyQueue.remove(),3);
		assertEquals(emptyQueue.remove(),4);
		assertEquals(emptyQueue.remove(),5);
		assertEquals(emptyQueue.remove(),6);

		assertEquals(emptyQueue.remove(),-1);		
		
	}

}
