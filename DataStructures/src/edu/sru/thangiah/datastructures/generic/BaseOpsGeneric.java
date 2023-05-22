package edu.sru.thangiah.datastructures.generic;
/**
 * <p>Title: BaseOpsGeneric</p>
 *
 * <p>Description: </p>
 * BaseOps interface class
 * 
 * We use interface classes to lay a framework for other classes
 * which intend to inherit the base traits of this class. Since
 * each instance will have different methods based on the data structure
 * we do not write the body of the function, instead when the class inherits
 * baseopsint it is required to write the core functions.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public interface BaseOpsGeneric<T> {
	
	/**
	 * return a value denoting the length of the container
	 * @return The size of the container
	 */
	public int size();
	
	/**
	 * returns a boolean true or false value based on whether there are contents in the container
	 * @return True based on if the container is unintialized
	 */
	public boolean isEmpty();
	
	/**returns a boolean true or false value based on whether the contents of a container has
	 *reached the max size.
	 *@return True based on if the container is fully initialized
	 */
	public boolean isFull();
	
	/**
	 * removes all the contents within the container
	 * @return True upon successful completion of the method
	 */
	public boolean clear();
	
	/**returns a boolean value based on whether a parameter value passed to the method is found
	 * in the container
	 * @param value The value to search for in the container
	 * @return True based on if the value is in the container
	 */
	public boolean contains(T value);
	
	/**
	 * Take the parameter value passed to the method and append it to the end of the container
	 * @param value The object to be added to the container
	 * @return True upon successful add
	 */
	public boolean add(T value);
	
	/**
	 * Take the parameter value passed to the method, search for the index of the value, and 
	 * remove it from the container, making sure to retain the structure of the array.
	 * @return True upon successful method call
	 */
	public T remove();
	
	//index of first occurrence of value
	public int indexOf(T value);
	
}
