package edu.sru.thangiah.datastructures.queue;

import edu.sru.thangiah.datastructures.ListOpsInt;

/**
 * <p>Title: AbstractQueue</p>
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
public abstract class AbstractQueue implements ListOpsInt{

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	abstract public boolean isEmpty();

	abstract public boolean isFull();

	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int indexOf(int value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addFirst(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	abstract public boolean addLast(int value);
	
	@Override
	public int removeLast() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public Object getFirst()
	{
		return 0;
	}

	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	abstract public int removeFirst() ;
	
	@Override
	public Object getAtIndex(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setAtIndex(int i, int value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAtIndex(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int addAtIndex(int i, int value) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Finds the element at the front of the queue and returns its value
	 * @return The data value of the first element in the queue
	 */
	public int peek()
	{
		return 0;
	}

}
