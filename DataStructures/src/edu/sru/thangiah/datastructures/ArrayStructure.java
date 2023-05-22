package edu.sru.thangiah.datastructures;

import java.util.Iterator;

/*
 * A generic array structure with a determined MAXSIZE constant
 * 
 */

/**
 * <p>Title: ArrayStructure</p>
 *
 * <p>Description: </p>
 * A generic array structure with a determined MAXSIZE constant
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class ArrayStructure implements BaseOpsInt{
	
	private final int MAXSIZE=100;
	private Object arrayVal[];
	private int count;
	
	ArrayStructure()
	{
		arrayVal = new Object[MAXSIZE];
		count = 0; 
	}
	
	/**
	 * return a value denoting the length of the container
	 * @return The size of the container
	 */
	@Override
	public int size() {
		return count;
	}
	/**
	 * returns a boolean true or false value based on whether there are contents in the container
	 * @return True based on if the container is unintialized
	 */
	@Override
	public boolean isEmpty() {
		if (count ==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**returns a boolean true or false value based on whether the contents of a container has
	 *reached the max size.
	 *@return True based on if the container is fully initialized
	 */
	@Override
	public boolean isFull() {
		if (count == MAXSIZE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * removes all the contents within the container
	 * @return True upon successful completion of the method
	 */
	@Override
	public boolean clear() {
		count = 0;
		return true;
	}
	/**returns a boolean value based on whether a parameter value passed to the method is found
	 * in the container
	 * @param value The value to search for in the container
	 * @return True based on if the value is in the container
	 */
	//@Override
	public boolean contains(Object value) {
		
		for (int i=0; i < MAXSIZE; i++)
		{
			if (value == arrayVal[i])
			{
				return true;
			}
			
		}
		return false;
	}
	/**
	 * Take the parameter value passed to the method and append it to the end of the container
	 * @param value The object to be added to the container
	 * @return True upon successful add
	 */
	//@Override
	public boolean add(Object value) {
		arrayVal[count] = value;
		count++;
		return true;
	}
	/**
	 * Take the parameter value passed to the method, search for the index of the value, and 
	 * remove it from the container, making sure to retain the structure of the array.
	 * @param value The object to be removed
	 * @return True upon successful method call
	 */
	//@Override
	public boolean remove(Object value) {
		count--;
		return true;
	}
	/**
	 * Returns the index value of the parameter value found in the container. If it is not
	 * found a zero value is returned.
	 * @param value The object to search for
	 * @return The index of where the value is found in the container
	 */
	//@Override
	public int indexOf(Object value) {
		for (int i=0; i < MAXSIZE; i++)
		{
			if (value == arrayVal[i])
			{
				return i;
			}
		}
		return -1;
	}
	/**
	 * Allows us to print the container in standard output
	 * @return The contents of the container
	 */
	public String toString()
	{
		String temp;
		temp="Vector is: ";
		for (int i=0; i < count; i++)
		{
			temp = temp + " " + arrayVal[i];
		}
		return temp;
	}
	
	public static void main(String args[])
	{
		ArrayStructure arrayVal = new ArrayStructure();
		
		System.out.println("Is the vector empty: "+ arrayVal.isEmpty());
		arrayVal.add(10);
		System.out.println("Vector contains 10: "+ arrayVal.contains(10));
		System.out.println("Index of 10 in Vector: "+ arrayVal.indexOf(10));
		System.out.println("Is vector full: "+ arrayVal.isEmpty());
		arrayVal.add(10);
		System.out.println("Vector size: "+ arrayVal.size());
		//arrayVal.remove();
		System.out.println("Vector size: "+ arrayVal.size());
		
		
	}

	@Override
	public boolean contains(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Similar to add, where we add to the end of the structure
	 * @param value The value to add to the container
	 * @return True based on successful method call
	 */
	public boolean addLast(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * removes the last index in the container
	 * @return the value of the element removed
	 */
	public int removeLast() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * returns the index where the parameter value is found in the container
	 * @param value
	 * @return The index of the value searched for in the container
	 */
	public int indexOf(int value) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * similar to add() except takes an int value instead of an object
	 * @param value Value to add to the container
	 * @return True based on successful method call
	 */
	@Override
	public boolean add(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * removes the last value in the container.
	 * @return The last element in the container
	 */
	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

}
