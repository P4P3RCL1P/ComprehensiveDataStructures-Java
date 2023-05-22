package edu.sru.thangiah.datastructures.linkedlist;

import edu.sru.thangiah.datastructures.ListOpsInt;

/**
 * <p>Title: AbstractDoubleLinkedList</p>
 *
 * <p>Description: </p>
 * Abstract class used as a framework for implementing a doubly linked list. Note methods are inherited from ListOpsGeneric which is the main framework for all list datastructures 
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractDoubleLinkedList implements ListOpsInt{

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
	public abstract boolean contains(int value);

	//Adds a value to the linked list
	@Override
	public abstract boolean add(int value);

	//removes a value from the linked list
	@Override
	public abstract Object remove();

	//returns the index of the value searched for in the linked list
	@Override
	public abstract int indexOf(int value);

	//adds the value to the beginning of the linked list
	@Override
	public abstract boolean addFirst(int value);

	//add the value to the end of the linked list
	@Override
	public abstract boolean addLast(int value);

	//gets the first element in the linked list
	public abstract Object getFirst();

	//gets the last element in the linked list
	public abstract Object getLast();

	//removes the first element in the linked list
	@Override
	public abstract int removeFirst();

	//removes the last element in the linked list
	@Override
	public abstract int removeLast();

	//gets the value of the element searched for at a given index in the linked list
	@Override
	public abstract Object getAtIndex(int i);

	//sets the value for an element searched for at a given index in the linked list
	@Override
	public abstract int setAtIndex(int i, int value);

	//removes the value for an element searched for at a given index in the linked list
	@Override
	public abstract int removeAtIndex(int i);

	//adds the value for an element searched for at a given index in the linked list
	@Override
	public abstract int addAtIndex(int i, int value);
	
	/**
	 * Inserts the value to be added into the linked list in ascending order
	 * @param data
	 * @return True upon successful method call
	 */
	public abstract boolean insertAscend(Object data);
	
	/**
	 * removes the data from an element in the linked list 
	 * @param data
	 * @return The value of the data that was removed from the linked list
	 */
	public abstract Object removeData(Object data);
	
	/**
	 * Adds two nodes to the linked list
	 * @param data
	 * @return The two nodes which are added to the linked list.
	 */
	public abstract Object addTwoNodes(Object data);
	
	
	
	//inherited methods from ListOpsInt that aren't used 
}
