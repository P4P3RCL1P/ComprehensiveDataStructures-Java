package edu.sru.thangiah.datastructures.generic.queue;
/*
 * Generic implementation of a queue inheriting the AbstractQueueGeneric class
 * 
 * 
 */
/**
 * <p>Title: QueueArrayGeneric</p>
 *
 * <p>Description: </p>
 * 
 * Generic implementation of a queue inheriting the AbstractQueueGeneric class. Makes use of arrays to set the queue to a fixed size
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class QueueArrayGeneric<T> extends AbstractQueueGeneric<T> {
		private Object items[];
		private int count;
		final private int MAX_SIZE = 10;
		
		// Initializes an empty QueueArray
		public QueueArrayGeneric() {
			items = new Object[MAX_SIZE];
			count = 0;
		}
		
		// Returns the size of the queue
		public int size() {
			return count;
		}
		
		
		// Returns true if the queue is full, false otherwise
		public boolean isFull() {
			return count == MAX_SIZE;
		}
		
		// Returns true if the queue is empty, false otherwise
		public boolean isEmpty() {
			return count == 0;
		}
		
		// Adds an item to the front of the queue.
		// Returns true if successful, false otherwise
		public boolean enQueue(T value) {
			return addLast(value);
		}
		
		// Method used to implement the enQueue operation
		// Overwritten from AbstractQueue
		// Same results as enQueue
		public boolean addLast(T value) {
			if (isFull()) {
				return false;
			}
			items[count] = value;
			count++;
			return true;
		}

		// Removes an item from the front of the queue
		// Removes and returns the value of first item if not empty
		// Returns (T)Integer.valueOf(-1) if the Queue is empty
		public T deQueue() {
			return removeFirst();
		}
		
		// Implementation method for deQueue()
		// Removes and returns the value of first item if not empty
		// Returns (T)Integer.valueOf(-1) if the Queue is empty
		public T removeFirst() {
			if (isEmpty()) {
				return (T)Integer.valueOf(-1);
			}
			T temp = (T)items[0];
			// Shifts remaining items (if any) to the left
			for (int i = 0; i < count - 1; i++) {
				items[i] = items[i + 1];
				items[i+ 1] = null;
			}
			count--;
			return temp;
		}
		
		// Returns a String describing the QueueArray instance
		// The returned String lists the class and then all of its values
		public String toString() {
			String temp = "Queue Values: ";
			for (int i = 0; i < count; i++) {
				temp += items[i] + " ";
			}
			return temp;
		}
		@Override
		public T getAtIndex(int i) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object addAtIndex(int i, Object value) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean clear() {
			items = new Object[MAX_SIZE];
			count = 0;
			return true;
		}
		public boolean contains(Object value)
		{
			for(int i = 0; i< count; i++)
			{
				if((T)items[i] == value)
				{
					return true;
				}
			}
			return false;
		}
		 /**
		  * Main method
		  * @param args The command line arguments.
		  */  	
		public static void main(String[] args) {
			// Testing from provided "Data" file
			System.out.println("Provided Data File Testing");
			QueueArrayGeneric<Integer> queue = new QueueArrayGeneric<Integer>();
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
			
			// My own testing
			System.out.println();
			System.out.println("Personal Testing: ");
			QueueArrayGeneric <Integer> test = new QueueArrayGeneric<Integer>();
			System.out.println("Empty Queue");
			System.out.println("Is Full: " + test.isFull());
			System.out.println("Is Empty: " + test.isEmpty());
			System.out.println("Item Removed: " + test.deQueue());
			System.out.println(test);
			
			System.out.println("Adding some items");
			System.out.println("Item Added: " + test.enQueue(5));
			System.out.println("Item Added: " +test.enQueue(7));
			System.out.println(test);
			System.out.println("Is Full: " + test.isFull());
			System.out.println("Is Empty: " + test.isEmpty());
			System.out.println("Item Removed: " + test.deQueue());
			System.out.println("Item Removed: " + test.deQueue());
			
			System.out.println("Empty Queue Again");
			System.out.println("Is Full: " + test.isFull());
			System.out.println("Is Empty: " + test.isEmpty());
			System.out.println(test);
			
			// Use of 15 in following loop tests that attempts to
			// deQueue empty Queues and enQueue full Queues
			// will be rejected
			System.out.println("Filling/Filled Queue");
			for (int i = 0; i < 15; i++) {
				System.out.println("Item Added: " + test.enQueue(i));
			}
			System.out.println("Is Full: " + test.isFull());
			System.out.println("Is Empty: " + test.isEmpty());
			System.out.println(test);
			System.out.println("Excess Item Added: " + test.enQueue(52));
			
			System.out.println("Removing all Items in Queue");
			for (int i = 0; i < 15; i++) {
				System.out.println("Item Removed: " + test.deQueue());
			}
			System.out.println(test);
			
			System.out.println("Refilling the Queue");
			for (int i = 0; i < 15; i++) {
				System.out.println("Item Added: " + test.enQueue(i + 15));
			}
			System.out.println(test);
			while (test.size() != 0) {
				System.out.println("Item Removed: " + test.deQueue());
			}
			System.out.println(test);
		}

		@Override
		public boolean add(T value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T remove() {
			// TODO Auto-generated method stub
			return null;
		}

	}

