package edu.sru.thangiah.datastructures.queue;

import java.util.Vector;

/**
 * <p>Title: CircularQueue</p>
 *
 * <p>Description: </p>
 * A circular queue is a data structure in which the last position in the queue
 * is linked to the first position hence the circular nature. With a normal queue
 * we may run into issues of maximizing our queue's capacity since elements de-queued
 * are left uninitialized and still take up space in the queue.
 * The usefulness of a circular queue solves this issue since we always have a pointer
 * to the front and rear of the container.
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class CircularQueue extends AbstractQueue{
	/**
	 * Sets the maximum size for the queue
	 */
	private final int MAXSIZE = 5;
	/**
	 * Used for instantiating items into the queue
	 */
	private int arrayVal[];
	/**
	 * Specifies the front value in the queue
	 */
	private int front;
	/**
	 * Specifies the rear value in the queue
	 */
	private int rear;
	
	CircularQueue()
	{
		arrayVal = new int[MAXSIZE];
		front = 0;
		rear  = 0;
	}

	//isEmpty
	//public abstract boolean isEmpty();
	@Override
	public boolean isEmpty() {
		if (front == rear)
		{	
			return true;
		}
		return false;
	}

	//isFull
	//public abstract boolean isFull();
	@Override
	public boolean isFull() {
		if ((rear+1)%MAXSIZE == front)
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
		arrayVal[rear]=value;
		rear = (rear+1)%MAXSIZE;
		return true;
	}

	/**
	 * Removes an item from the queue using a FIFO strategy
	 * @return
	 */
	//deQueue
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
		int firstVal;
		firstVal = arrayVal[front];
		front = (front+1)%MAXSIZE;
		
		return firstVal;
	}
	
	
	public String toString()
	{
		String temp;
		int i;
		temp="";
		i=front;
		while (front == rear)
		{
			temp = temp+" "+arrayVal[i];
			i = (i+1)%MAXSIZE;
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

		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		System.out.println("DeQueue value is "+queue.deQueue());
		queue.enQueue(60);
		System.out.println("Queue is:"+queue);
		
	}

	@Override
	public int removeLast() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean add(int value) {
		return enQueue(value);
	}

	public Object remove() {
		return deQueue();
	}

	@Override
	public int addAtIndex(int i, int value) {
		// TODO Auto-generated method stub
		return 0;
	}
}


