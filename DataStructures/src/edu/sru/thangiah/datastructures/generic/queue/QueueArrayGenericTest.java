package edu.sru.thangiah.datastructures.generic.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueArrayGenericTest {

	/**
	 * Fully initialized queue of integer values
	 */
	QueueArrayGeneric<Integer> queueIntegerFull = new QueueArrayGeneric<Integer>();
	
	/**
	 * Fully initialized queue of String values
	 */
	QueueArrayGeneric<String> queueStringFull = new QueueArrayGeneric<String>();
	
	/**
	 * Empty queue of integer values
	 */
	QueueArrayGeneric<Integer> queueIntegerEmpty = new QueueArrayGeneric<Integer>();

	
	@BeforeEach
	void setUp() throws Exception {

		queueIntegerFull.enQueue(1);
		queueIntegerFull.enQueue(2);
		queueIntegerFull.enQueue(3);
		queueIntegerFull.enQueue(4);
		queueIntegerFull.enQueue(5);
		queueIntegerFull.enQueue(6);

		queueStringFull.enQueue("string1");
		queueStringFull.enQueue("string2");
		queueStringFull.enQueue("string3");
		queueStringFull.enQueue("string4");
		queueStringFull.enQueue("string5");

	}

	@AfterEach
	void tearDown() throws Exception {

		queueIntegerFull.clear();
		
		queueIntegerEmpty.clear();
		
		queueStringFull.clear();
		
	}

	@Test
	void testSize() {

		assertEquals(queueIntegerFull.size(), 6);
		
		queueIntegerFull.deQueue();
		
		assertEquals(queueIntegerFull.size(), 5);
		
		assertEquals(queueStringFull.size(), 5);
		
		assertEquals(queueIntegerEmpty.size(), 0);
		
	}

	@Test
	void testIsEmpty() {

		assertTrue(queueIntegerEmpty.isEmpty());
		
		assertFalse(queueIntegerFull.isEmpty());
		
		queueIntegerFull.clear();
		
		assertFalse(queueStringFull.isEmpty());
		
		assertTrue(queueIntegerFull.isEmpty());
			
	}

	@Test
	void testClear() {

		assertEquals(queueIntegerFull.size(), 6);
		
		queueIntegerFull.clear();

		assertEquals(queueIntegerFull.getFirst(),-1);	
	
	}

	@Test
	void testAddLast() {
		
		assertEquals(queueIntegerFull.size(),6);
		
		queueIntegerFull.addLast(10);
				
		assertEquals(queueIntegerFull.size(),7);
		
		assertEquals(queueStringFull.size(),5);
		
		queueStringFull.addLast("test string");
				
		assertEquals(queueStringFull.size(),6);	
	}

	@Test
	void testRemoveFirst() {

		assertEquals(queueIntegerFull.removeFirst(),1);	
			
		
		assertEquals(queueStringFull.removeFirst(),"string1");	

		
		assertEquals(queueStringFull.removeFirst(),"string2");	
		
	}

	@Test
	void testEnQueue() {

		assertEquals(queueIntegerFull.size(),6);	
		
		queueIntegerFull.enQueue(20);
		
		assertEquals(queueIntegerFull.size(),7);	
		
		assertEquals(queueStringFull.size(),5);	
		
		queueStringFull.enQueue("test string");
		
		assertEquals(queueStringFull.size(),6);
		
	}

	@Test
	void testDeQueue() {

		assertEquals(queueIntegerFull.deQueue(),1);	
		
		assertEquals(queueIntegerFull.deQueue(),2);	
		
		assertEquals(queueStringFull.deQueue(),"string1");
		
		assertEquals(queueStringFull.deQueue(),"string2");	
		
	}

	@Test
	void testToString() {

		assertEquals(queueIntegerFull.toString(), "Queue Values: 1 2 3 4 5 6 ");
		
		assertEquals(queueStringFull.toString(), "Queue Values: string1 string2 string3 string4 string5 ");

		assertEquals(queueIntegerEmpty.toString(), "Queue Values: ");	
		
	}

	@Test
	void testContainsObject() {

		assertFalse(queueIntegerEmpty.contains(4));
		
		queueIntegerEmpty.enQueue(4);
		
		assertTrue(queueIntegerEmpty.contains(4));
		
		assertTrue(queueStringFull.contains("string4"));
		
		assertTrue(queueIntegerFull.contains(3));
		
		
	}

}
