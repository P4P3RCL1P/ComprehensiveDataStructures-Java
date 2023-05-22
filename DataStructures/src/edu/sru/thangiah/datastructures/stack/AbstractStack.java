package edu.sru.thangiah.datastructures.stack;

import edu.sru.thangiah.datastructures.ListOpsInt;


/**
 * <p>Title: AbstractStack</p>
 *
 * <p>Description: </p>
 * 
 * Abstract stack class
 * Sets the methods to be implemented in Stack.java
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public abstract class AbstractStack implements ListOpsInt {

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Pushes an item to the stack
	 * @param value - The value to be pushed to the stack
	 */
	public boolean push(Object value) {return false;}
	/**
	 * Removes an element from the stack employing a lifo strategy
	 * @return The data of the element which is popped from the stack
	 */
	public Object pop() {return 0;}
	/**
	 * Returns the topmost element in a stack
	 * @return The data value of the topmost element in a stack
	 */
	public Object top() {return 0;}

	abstract public boolean isEmpty();

	abstract public boolean isFull();

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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
	public boolean addLast(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	abstract public Object getFirst();

	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFirst() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int removeLast() {
		// TODO Auto-generated method stub
		return 0;
	}
	

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


}
