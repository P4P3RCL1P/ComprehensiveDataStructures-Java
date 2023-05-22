package edu.sru.thangiah.datastructures.generic;
/**
 * <p>Title: ListOpsGeneric</p>
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
public interface ListOpsGeneric<T> extends BaseOpsGeneric<T> {
	
	/**
	 * add it to the first location structure
	 * @param value
	 * @return True based on successful method call
	 */
	public boolean addFirst(T value);
	
	/**
	 *  add to end of structure
	 * @param value
	 * @return True based on successful method call
	 */
	public boolean addLast(T value);
	
	
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
	public T removeFirst();
	
	/**
	 * remove at the end of structure
	 * @return The value of the element which is removed
	 */
	public T removeLast();
	
	/**
	 * index of the first value in the structure
	 * @param value
	 * @return The index of the value which is searched for
	 */
	public int indexOf (T value);
	
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
	public T setAtIndex(int i, T value);
	
	/**
	 * remove the value at index i
	 * @param i
	 * @return The value of the element removed at the given index
	 */
	public T removeAtIndex (int i);
	
	/**
	 * insert node at specific index in list
	 * @param i
	 * @param value
	 * @return The value of the element added at the given index
	 */
	public T addAtIndex (int i, T value);
	
	
}