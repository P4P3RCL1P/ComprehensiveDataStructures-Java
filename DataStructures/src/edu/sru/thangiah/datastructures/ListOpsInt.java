package edu.sru.thangiah.datastructures;

/*
 * ListOps interface class
 * 
 */
/**
 * <p>Title: ListOpsInt</p>
 *
 * <p>Description: </p>
 * ListOps interface class
 * This class provides the subsequent structure for all data structures which are modeled after lists
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public interface ListOpsInt extends BaseOpsInt {
	
	/**
	 * add it to the first location structure
	 * @param value - The data to be inserted at the start of the structure
	 * @return True based on successful method call
	 */
	public boolean addFirst(int value);	
	
	/**
	 *  add to end of structure
	 * @param value - The data to be inserted last in the structure
	 * @return True based on successful method call
	 */
	public boolean addLast(int value);
	
	/**
	 * index of the first value in the structure
	 * @param value - The value to search for
	 * @return The index of the value which is searched for
	 */
	public int indexOf(int value);
	
	/**
	 * get the first value of the structure
	 * @return The first element in the list
	 */
	public Object getFirst();
	
	/**
	 * get the last value of the structure
	 * @return The last element in the list
 	 */
	public Object getLast();
	
	/**
	 * remove the first value of the structure
	 * @return The value of the element which is removed 
	 */
	public int removeFirst();
	
	/**
	 * remove at the end of structure
	 * @return The value of the element which is removed
	 */
	public int removeLast();
	
	/**
	 * get the value at index i
	 * @param i
	 * @return Gets the Object of the element set at the given index
	 */
	public Object getAtIndex(int i);
	
	/**
	 * at index i, put the value in the structure
	 * @param i
	 * @param value
	 * @return Sets the value of the element originally set at the given index
	 */
	public int setAtIndex(int i, int value);
	
	/**
	 * remove the value at index i
	 * @param i
	 * @return The value of the element removed at the given index
	 */
	public int removeAtIndex(int i);
	
	/**
	 * insert node at specific index in list
	 * @param i
	 * @param value
	 * @return The value of the element added at the given index
	 */
	public int addAtIndex(int i, int value);
	
	
	
}