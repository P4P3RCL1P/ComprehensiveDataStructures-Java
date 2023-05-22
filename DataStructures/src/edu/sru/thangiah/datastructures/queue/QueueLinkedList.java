package edu.sru.thangiah.datastructures.queue;
import edu.sru.thangiah.datastructures.linkedlist.*;
/**
 * <p>Title: QueueLinkedList</p>
 *
 * <p>Description: </p>
 * Demonstrates the fundamentals of a queue instead using a linked list instead of an array.
 * DeQueue and EnQueue operations require little complexity since the operations merely result in moving the internal pointers.
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */


public class QueueLinkedList extends AbstractQueue{

	/**
	 * Instance of linked list that we use to represent the queue
	 */
	private SingleLinkedList singleLL;
	
	QueueLinkedList(){	// initialize the singleLL to an actual location in memory
		singleLL = new SingleLinkedList();
	}
	
	@Override
	public boolean isEmpty() {
		return singleLL.isEmpty();
	}

	@Override
	public boolean isFull() {	// always returning false, since linked lists are only
		return false;			// limited by amount of memory in the system
	}
	
	/*
	 * All methods in the QueueLinkedList class point to methods in the SingleLinkedList
	 * class-- the logic is contained there
	 */
	/**
	 * Add an item to a queue
	 * @param value - The data to be added to the queue
	 * @return True upon successful completion of the method
	 */
	public boolean enQueue(int value) {		// adds value to the end of the list
		this.addLast(value);
		return true;
	}

	@Override
	public boolean addLast(int value) {
		singleLL.addLast(value);
		return true;
	}
	/**
	 * Removes an item from the queue using a FIFO strategy
	 * @return
	 */
	public int deQueue() {		// removes the first value in the queue
		return this.removeFirst();
	}
	@Override
	public int removeFirst() {
		return (int) singleLL.removeFirst();
	}
	
	@Override
	public String toString()
	{
		return singleLL.toString();
	}
	/**
	 * Main method
	 * @param args The command line arguments.
	 */  
	public static void main(String args[])
	{

		QueueLinkedList queue = new QueueLinkedList();
		System.out.println("Queue is empty-1:"+queue.isEmpty());
		System.out.println("Queue is full-1:"+queue.isFull());
		System.out.println("DeQueue value is "+queue.deQueue());
		queue.enQueue(10);
		for (int i=0; i < 3; i++)
		{
			System.out.println("DeQueue value is "+queue.deQueue());
		}
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.addLast(50);
		System.out.println("Deque is " + queue.removeFirst());
		for (int i=0; i < 14; i++)
		{
			queue.enQueue(i*10);
		}
		System.out.println("Queue is"+queue);
		System.out.println("Deque value is "+queue.deQueue());
		System.out.println("Deque value is "+queue.deQueue());
		System.out.println("Queue is"+queue);
		System.out.println("Queue is empty-2:"+queue.isEmpty());
		System.out.println("Queue is full-2:"+queue.isFull());
		for (int i=0; i < 20; i++)
		{
			System.out.println("DeQueue value is "+queue.deQueue());
		}
		System.out.println("Queue is"+queue);
		System.out.println("Queue is empty-3:"+queue.isEmpty());
		System.out.println("Queue is full-3:"+queue.isFull());
	}

	@Override
	public boolean add(int value) {
		return enQueue(value);
	}

	@Override
	public Object remove() {
		return deQueue();
	}

}