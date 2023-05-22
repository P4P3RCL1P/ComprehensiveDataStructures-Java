package edu.sru.thangiah.datastructures.queue;

import java.util.Vector;


/**
 * <p>Title: QueueVector</p>
 *
 * <p>Description: </p>
 * Allows us to dynamically allocate the size of our queue, removing the size restriction
 * associated with arrays. Additionally since we make use of java.util.Vector we don't need
 * to build too many helper methods since they are already built into the Vector package.
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class QueueVector extends AbstractQueue{
	/**
	 * Specifies the max size of the queue
	 */
	private final int  MAXSIZE=100;
	/**
	 * Vector used to simulate the queue implementation 
	 */
	private Vector vector;
	
	QueueVector()
	{
		vector = new Vector();
	}

	//isEmpty
	//public abstract boolean isEmpty();
	@Override
	public boolean isEmpty() {
		if (vector.size() == 0)
		{	
			return true;
		}
		return false;
	}

	//isFull
	//public abstract boolean isFull();
	@Override
	public boolean isFull() {
		if (vector.size() == MAXSIZE)
		{
			return true;
		}
		return false;
	}

	/**
	 * Add an item to a queue
	 * @param value - The data to be added to the queue
	 * @return True upon successful completion of the method
	 */
	public boolean enQueue(int value) {
		if (!this.isFull())
		{
			addLast(value);
			return true;
		}
		return false;
	}
	//public abstract boolean addLast(int value);
	@Override
	public boolean addLast(int value) {
		vector.addElement(value);
		return true;
	}


	/**
	 * Removes an item from the queue using a FIFO strategy
	 * @return
	 */
	public int deQueue() {
		if (!this.isEmpty())
		{
			return removeFirst();
		}
		return -1;
	}
	
	//public abstract int removeFirst();
	@Override
	public int removeFirst() {
		Object firstInd =  vector.elementAt(0);
		Object firstVal = vector.firstElement();
		vector.remove(firstInd);
		//vector.remove( vector.elementAt(0));
		return (int)firstVal;
	}
	
	
	public String toString()
	{
		String temp;
		temp="";
		for (int i=0; i < vector.size();i++)
		{
			temp = temp+" "+vector.get(i);
		}
		return temp;
	}
	
	
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String args[])
	{
		//QueueVector queue = new QueueVector();
		QueueVector queue = new QueueVector();
		System.out.println("Queue is empty-1:"+queue.isEmpty());
		System.out.println("Queue is full-1:"+queue.isEmpty());
		System.out.println("DeQueue value is "+queue.deQueue());
		queue.enQueue(10);
		for (int i=0; i < 3; i++)
		{
			System.out.println("DeQueue value is "+queue.deQueue());
		}
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		for (int i=0; i < 14; i++)
		{
			queue.enQueue(i*10);
		}
		System.out.println("Queue is"+queue);
		System.out.println("Deque value is "+queue.deQueue());
		System.out.println("Deque value is "+queue.deQueue());
		System.out.println("Queue is"+queue);
		System.out.println("Queue is empty-2:"+queue.isEmpty());
		System.out.println("Queue is full-2:"+queue.isEmpty());
		for (int i=0; i < 20; i++)
		{
			System.out.println("DeQueue value is "+queue.deQueue());
		}
		System.out.println("Queue is"+queue);
		System.out.println("Queue is empty-3:"+queue.isEmpty());
		System.out.println("Queue is full-3:"+queue.isEmpty());
	}

	public boolean add(int value) {
		return enQueue(value);
	}

	public Object remove() {
		return deQueue();
	}
}
