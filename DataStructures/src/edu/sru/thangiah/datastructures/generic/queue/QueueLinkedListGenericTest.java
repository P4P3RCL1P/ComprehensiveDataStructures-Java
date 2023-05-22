package edu.sru.thangiah.datastructures.generic.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueLinkedListGenericTest {

	/**
	 * Fully initialized queue of integer values
	 */
	QueueLinkedListGeneric<Integer> queueIntegerFull = new QueueLinkedListGeneric<Integer>();
	
	/**
	 * Fully initialized queue of String values
	 */
	QueueLinkedListGeneric<String> queueStringFull = new QueueLinkedListGeneric<String>();
	
	/**
	 * Empty queue of integer values
	 */
	QueueLinkedListGeneric<Integer> queueIntegerEmpty = new QueueLinkedListGeneric<Integer>();

	
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
	void testAddLastT() {

		queueIntegerFull.addLast(10);
		
		assertEquals(queueIntegerFull.getAtIndex(7),10);
		
		queueStringFull.addLast("test string");
		
		assertEquals(queueStringFull.getAtIndex(6),"test string");
	
	}

	@Test
	void testGetAtIndex() {
		
		assertEquals(queueIntegerFull.getAtIndex(2),2);	
		
		assertEquals(queueIntegerFull.getAtIndex(3),3);	

		assertEquals(queueIntegerFull.getAtIndex(4),4);	
		
		assertEquals(queueIntegerFull.getAtIndex(5),5);	
		
	}

	@Test
	void testEnQueue() {
		
		queueIntegerFull.enQueue(20);
		
		assertEquals(queueIntegerFull.getAtIndex(7),20);	
		
		queueStringFull.enQueue("test string");
		
		assertEquals(queueStringFull.getAtIndex(6),"test string");

	}

	@Test
	void testDeQueue() {

		assertEquals(queueIntegerFull.getAtIndex(1),1);	

		queueIntegerFull.deQueue();
		
		assertEquals(queueIntegerFull.getAtIndex(1),2);	
		
		assertEquals(queueStringFull.getAtIndex(1),"string1");	

		queueStringFull.deQueue();
		
		assertEquals(queueStringFull.getAtIndex(1),"string2");	
		
	}

	@Test
	void testSetAtIndexIntObject() {
		
		assertEquals(queueIntegerFull.getAtIndex(1),1);	

		queueIntegerFull.setAtIndex(1,3);
		
		assertEquals(queueIntegerFull.getAtIndex(1),3);	
		
		assertEquals(queueStringFull.getAtIndex(1),"string1");	

		queueStringFull.setAtIndex(1,"test string");
		
		assertEquals(queueStringFull.getAtIndex(1),"test string");
		
	}

	@Test
	void testRemove() {
		
		assertEquals(queueIntegerFull.getAtIndex(1),1);	

		queueIntegerFull.remove();
		
		assertEquals(queueIntegerFull.getAtIndex(1),2);	
		
		assertEquals(queueStringFull.getAtIndex(1),"string1");	

		queueStringFull.remove();
		
		assertEquals(queueStringFull.getAtIndex(1),"string2");	
		
	}

	@Test
	void testRemoveFirst() {
		
		assertEquals(queueIntegerFull.getAtIndex(1),1);	

		queueIntegerFull.removeFirst();
		
		assertEquals(queueIntegerFull.getAtIndex(1),2);	
		
		assertEquals(queueStringFull.getAtIndex(1),"string1");	

		queueStringFull.removeFirst();
		
		assertEquals(queueStringFull.getAtIndex(1),"string2");	
		
	}

	@Test
	void testToString() {
		
		assertEquals(queueIntegerFull.toString(), " Head 1 2 3 4 5 6 Tail");
		
		assertEquals(queueStringFull.toString(), " Head string1 string2 string3 string4 string5 Tail");

		assertEquals(queueIntegerEmpty.toString(), " Head Tail");	
		
	}

	@Test
	void testAddLastObject() {
		
		queueIntegerFull.addLast(7);
		
		assertEquals(queueIntegerFull.getAtIndex(7),7);		
		
		queueStringFull.addLast("string6");
		
		assertEquals(queueStringFull.getAtIndex(6),"string6");	
		
	}

}
