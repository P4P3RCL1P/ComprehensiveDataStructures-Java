package edu.sru.thangiah.datastructures.generic.stack;

import edu.sru.thangiah.datastructures.generic.ListOpsGeneric;

/*
 * Abstract stack generic class
 * Sets the methods to be implemented in StackGeneric
 */

/**
 * <p>Title: AbstractStackGeneric</p>
 *
 * <p>Description: </p>
 * 
 * Abstract stack generic class
 * Sets the methods to be implemented in StackGeneric
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractStackGeneric <T> implements ListOpsGeneric <T> {
	
	/**
	 * Pushes an item to the stack
	 * @param number - The value to be pushed to the stack
	 */
	public void push(T number)
	{
	}
	/**
	 * Removes an element from the stack employing a lifo strategy
	 * @return The data of the element which is popped from the stack
	 */
	public T pop()
	{
		return null;
	}
	/**
	 * Returns the topmost element in a stack
	 * @return The data value of the topmost element in a stack
	 */
	public T top()
	{
		return null;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
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
	public boolean add(T value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addFirst(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addLast(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object getAtIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object setAtIndex(int i, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T removeAtIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object addAtIndex(int i, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
}
