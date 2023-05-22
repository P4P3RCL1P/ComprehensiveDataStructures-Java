package edu.sru.thangiah.datastructures.generic.linkedlist;

import edu.sru.thangiah.datastructures.generic.ListOpsGeneric;
/**
 * <p>Title: AbstractDoubleLinkedListGeneric</p>
 *
 * <p>Description: </p>
 * Abstract class used as a framework for implementing a doubly linked list. Note methods are inherited from ListOpsGeneric which is the main framework for all list datastructures 
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractDoubleLinkedListGeneric<T> implements ListOpsGeneric<T>{

	//returns the size of the linked list
	@Override
	public abstract int size();

	//returns true if the linked list is uninitialized (empty)
	@Override
	public abstract boolean isEmpty();

	//returns true if the linked list has reached the max container size
	@Override
	public abstract boolean isFull();

	//removes all elements from the linked list
	@Override
	public abstract boolean clear();

	//returns true if the value searched for is in the linked list
	@Override
	public abstract boolean contains(T value);

	//Adds a value to the linked list
	@Override
	public abstract boolean add(T value);

	//removes a value from the linked list
	@Override
	public abstract T remove();

	//adds the value to the beginning of the linked list
	@Override
	public abstract boolean addFirst(T value);

	//add the value to the end of the linked list
	@Override
	public abstract boolean addLast(T value);

	//gets the first element in the linked list
	@Override
	public abstract Object getFirst();

	//gets the last element in the linked list
	@Override
	public abstract Object getLast();

	//removes the first element in the linked list
	@Override
	public abstract T removeFirst();

	//removes the last element in the linked list
	@Override
	public abstract T removeLast();

	//returns the index of the value searched for in the linked list
	@Override
	public abstract int indexOf(T value);

	//gets the value of the element searched for at a given index in the linked list
	@Override
	public abstract T getAtIndex(int i);

	//sets the value for an element searched for at a given index in the linked list
	@Override
	public abstract T setAtIndex(int i, T value);

	//removes the value for an element searched for at a given index in the linked list
	@Override
	public abstract T removeAtIndex(int i);

	//adds the value for an element searched for at a given index in the linked list
	@Override
	public abstract T addAtIndex(int i, T value);
	
	/**
	 * Inserts the value to be added into the linked list in ascending order
	 * @param data
	 * @return True upon successful method call
	 */
	public abstract boolean insertAscend(T data);
	/**
	 * removes the data from an element in the linked list 
	 * @param data
	 * @return The value of the data that was removed from the linked list
	 */
	public abstract T removeData(T data);
	
	/**
	 * Adds two nodes to the linked list
	 * @param data
	 * @return The two nodes which are added to the linked list.
	 */
	public abstract Object addTwoNodes(T data);

}
