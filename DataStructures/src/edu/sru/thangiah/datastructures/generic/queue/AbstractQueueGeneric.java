package edu.sru.thangiah.datastructures.generic.queue;

import edu.sru.thangiah.datastructures.generic.ListOpsGeneric;

/*
 * Generic interface class used for a queue implementation. Note the <> after the class declaration, specifying the generic type variable
 * used throughout the method declaration. The use of an abstract class allows for the programmer to choose certain methods from the
 * inherited class to implement.
 */

/**
 * <p>Title: AbstractQueueGeneric</p>
 *
 * <p>Description: </p>
 * Generic interface class used for a queue implementation. Note the <> after the class declaration, specifying the generic type variable
 * used throughout the method declaration. The use of an abstract class allows for the programmer to choose certain methods from the
 * inherited class to implement.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public abstract class AbstractQueueGeneric<T> implements ListOpsGeneric<T> {

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public abstract boolean isEmpty();

	@Override
	public abstract boolean isFull();

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addFirst(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public abstract boolean addLast(T value);

	@Override
	public Object getFirst(){
		// TODO Auto-generated method stub
		return (T)Integer.valueOf(-1);
	}

	@Override
	public Object getLast(){
		// TODO Auto-generated method stub
		return (T)Integer.valueOf(-1);
	}

	@Override
	public abstract T removeFirst();

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return (T)Integer.valueOf(-1);
	}

	@Override
	public T setAtIndex(int i, T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getAtIndex(int i)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T removeAtIndex(int i) {
		// TODO Auto-generated method stub
		return (T)Integer.valueOf(-1);
	}
	@Override
	public Object addAtIndex(int i, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Add an item to a queue
	 * @param value - The data to be added to the queue
	 * @return True upon successful completion of the method
	 */
	public boolean enQueue(T value)
	{
		return false;
	}
	/**
	 * Removes an item from the queue using a FIFO strategy
	 * @return
	 */
	public T deQueue()
	{
		return null;
	}

	/**
	 * Finds the element at the front of the queue and returns its value
	 * @return The data value of the first element in the queue
	 */
	public T peek()
	{
		return null;
	}
}
