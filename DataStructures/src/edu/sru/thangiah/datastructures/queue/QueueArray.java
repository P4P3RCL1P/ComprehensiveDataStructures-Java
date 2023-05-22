package edu.sru.thangiah.datastructures.queue;

/**
 * <p>Title: QueueArray</p>
 *
 * <p>Description: </p>
 * Queue implementation using an array. Elements are inserted and removed in a FIFO( first-in-first-out) manner
 * as elements enter in the container they are figuratively assigned a "priority" in which the first element to
 * enter will be the first to leave.
 * The fundamentals of an array require a size to be initialized during instantiation of the container, which we will later
 * overcome by using a dynamic data structure such as a vector.
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class QueueArray extends AbstractQueue {
	
	/**
	 * Max size of the queue container
	 */
	private final int MAXSIZE = 10;
	/**
	 * Records the number of items in the queue
	 */
	private int count;
	/**
	 * Records the number of items that have been removed
	 */
	private int removeCounter;
	/**
	 * Used for implementation of the queue
	 */
	private int[] myArray;
	
	public QueueArray() {
		myArray = new int[MAXSIZE];
		count = 0;
		removeCounter = 0;
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean clear()
	{
		while(count > 0)
		{
			deQueue();
		}
		return isEmpty();
	}
	
	public boolean contains(int value)
	{
		//find int value in stack
		for(int i = 0; i < count; i++)
		{
			if(myArray[i] == value);
			{
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(int value)
	{
		for(int i = 0; i < count; i++)
		{
			if(myArray[i] == value);
			{
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (count == MAXSIZE) {
			return true;
		}
		else {
			return false;
		}
	}

	
	/**
	 * Add an item to a queue
	 * @param value - The data to be added to the queue
	 * @return True upon successful completion of the method
	 */
	public boolean enQueue(int value) {
		return this.addLast(value);
	}
	
	
	// addLast adds a value to the back of the queue
	@Override
	public boolean addLast(int value) {
		if (!this.isFull()) {		// avoids adding a value if the array is full
			myArray[count] = value;
			count++;				// increment count to indicate how many elements in queue
			return true;
		}
		else {
			System.out.println("ERROR: Queue is full.");
			return false;			// returns false if value was not added
		}
		
	}
	
	/**
	 * Removes an item from the queue using a FIFO strategy
	 * @return
	 */
	public int deQueue() {
		return this.removeFirst();
	}

	// removeFirst removes the first value that was added in and returns it to the user
	@Override
	public int removeFirst() {
		if (!this.isEmpty()) {
			int tempVal = myArray[removeCounter];	
			// stores the value in a temporary variable to return later
			myArray[removeCounter] = 0;
			removeCounter++;	// points to the first location in the array
			count--; 			// Decrement count to reflect contents of the array
			
			if (count < removeCounter) {	
				// Triggers only when count goes below removeCounter to 
				this.shift();
				removeCounter = 0;
			}
			return tempVal;			// returns the value of the removed element
		}
		else {
			System.out.println("ERROR: Queue is empty.");
			return -1;	// returns if the array is empty
		}
	}
	
	
	/**
	 *  Shift puts all the elements back in the proper place for the queue
	 */
	public void shift() {
		for (int i = 0; i < count; i++) {
			this.myArray[i] = this.myArray[removeCounter + i];
			this.myArray[removeCounter + i] = 0;
		}
	}
	
	@Override
	public String toString() {
		String tempVal = " ";
		if (!this.isEmpty()) {
			for (int i = removeCounter; i < count; i++) {
				tempVal += " " +this.myArray[i];
			}
		}
		if (tempVal.equals(" ")) {
			return " empty";
		}		
		return tempVal;
	}
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String[] args) {
		QueueArray queue = new QueueArray();
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
		
	}

	public boolean add(int value) {
		return enQueue(value);
	}

	public Object remove() {
		return deQueue();
	}
}
