package edu.sru.thangiah.datastructures.generic.queue;
import edu.sru.thangiah.datastructures.generic.linkedlist.*;

/**
 * <p>Title: QueueLinkedListGeneric</p>
 *
 * <p>Description: </p>
 * Demonstrates the fundamentals of a queue instead using a linked list instead of an array.
 * DeQueue and EnQueue operations require little complexity since the operations merely result in moving the internal pointers.
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class QueueLinkedListGeneric <T extends Comparable<T>> extends AbstractQueueGeneric {
	/**
	 * Instance of linked list that we use to represent the queue
	 */
	private SingleLinkedListGeneric singleLL;
	
	private int nodeCount;
	
	QueueLinkedListGeneric()
	{
		singleLL = new SingleLinkedListGeneric();
		nodeCount = 0;
	}
	
	public T getAtIndex(int i)
	{
	
		return (T) singleLL.getAtIndex(i);
	}
	
	public T setAtIndex(int i, Object value)
	{
		return (T) singleLL.setAtIndex(i, (Comparable) value);
	}
	public boolean clear()
	{
		singleLL = new SingleLinkedListGeneric();
		nodeCount = 0;
		return true;
	}
	
	public int size()
	{
		return nodeCount;
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
	public boolean enQueue(T value)
	{
		this.addLast(value);
		nodeCount++;
		return true;
	}
	@Override
	public boolean add(Object value) {
		return enQueue(value);
	}

	/**
	 * Removes an item from the queue using a FIFO strategy
	 * @return
	 */
	public T deQueue()
	{	T removeVal = null;
		removeVal = (T) this.getFirst();
		this.removeFirst();
		nodeCount--;
		return removeVal;
	}
	@Override
	public Object remove() {
		return deQueue();
	}

	@Override
	public boolean isEmpty() {
		return singleLL.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}
	@Override
	public Object removeFirst() {
		return (T) singleLL.removeFirst();
	}
	public boolean addLast(T value) {
		singleLL.addLast(value);
		return true;
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

		QueueLinkedListGeneric<Integer> queue = new QueueLinkedListGeneric<Integer>();
		System.out.println("Queue is empty-1:"+queue.isEmpty());
		System.out.println("Queue is full-1:"+queue.isFull());
		//System.out.println("DeQueue value is "+queue.deQueue());
		queue.enQueue(10);
		//for (int i=0; i < 3; i++)
		//{
		//	System.out.println("DeQueue value is "+queue.deQueue());
		//}
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.addLast(50);
		System.out.println(queue.toString());
		//System.out.println("Deque is " + queue.removeFirst());
		//System.out.println("Queue is"+queue);
		//System.out.println("Deque value is "+queue.deQueue());
		//System.out.println("Deque value is "+queue.deQueue());
		//System.out.println("Queue is"+queue);
		//System.out.println("Queue is empty-2:"+queue.isEmpty());
		//System.out.println("Queue is full-2:"+queue.isFull());
	}

	@Override
	public boolean addLast(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
