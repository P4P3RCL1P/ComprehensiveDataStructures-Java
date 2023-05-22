package edu.sru.thangiah.datastructures.vector;
import java.util.Vector;

import edu.sru.thangiah.datastructures.BaseOpsInt;

/*
 * Vector structure expands on BaseOps and builds vector
 * tool for effective use with arrays
 */
/**
 * <p>Title: VectorStructure</p>
 * 
 * <p>Description: </p>
 * Vector structure used to store elements in ascending order from front to back
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class VectorStructure implements BaseOpsInt{
	
	/**
	 * max size of the array
	 */
	private final int MAXSIZE = 100;
	
	/**
	 * arrayVal holds the values being added to the vector
	 */
	private int arrayVal[];
	
	/**
	 * count holds the farthest-back index in the array, and is implemented
	 * in the add and remove functions. 
	 */
	private int count;

	
	VectorStructure() {
		arrayVal = new int[MAXSIZE];
		count = 0;
	}
	
	/*
	 * VectorStructure() {
		arrayVal = new int[MAXSIZE];
		count = MAXSIZE-1;
	}
	 */

	@Override
	public int size() {

		return count;
	}

	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (count == MAXSIZE) {
			return true;
		}
		return false;
	}
	
	/*
	 * public boolean isFull() {
		if (count == -1) {
			return true;
		}
		return false;
	 */

	@Override
	public boolean clear() {
		count = 0;
		return true;
	}

	@Override
	public boolean contains(int value) {
		for (int i = 0; i < count; i++) {
			if (value == arrayVal[i]) {
				return true;
			}
		}
		return false;

	}

	/**
	 * adds the value to the end of the values of the vector granted it is not full
	 * @param value being added to the vector
	 * @return true if successful addition
	 */
	public boolean addLast(int value) {
		if (!this.isFull()) {
			arrayVal[count] = value;
			count++;
			return true;
		}
		return false;
	}
	
	/*
	 * public boolean add(int value) {
		if (!this.isFull()) {
			arrayVal[count] = value;
			count--;
			return true;
		}
		return false;
	}
	 */

	/**
	 * removes the value last in the vector at index count if the array is not empty
	 * @return the value being removed
	 */
	public int removeLast() {
		if (!this.isEmpty()) {
			count--;
			return arrayVal[count];
		}
		return 0;
	}
	
	/*
	 * public boolean remove() {
		if (!this.isEmpty()) {
			count++;
			return true;
		}
		return false;
	}
	 */

	
	/**
	 * given a value check the index in the location and return the index
	 * @param value- the value being searched for
	 * @return index of the value
	 */
	public int indexOf(int value) {
		for (int i = 0; i < count; i++) {
			if (value == arrayVal[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public String toString()
	{
		String temp;
		temp = "Values in array: ";
		for (int i = 0; i < count; i++) {
			temp = temp + " "+ arrayVal[i];
		}
		return temp;
	}
	

	public static void main(String args[]) {
		VectorStructure myVect = new VectorStructure();
		myVect.addLast(10);
		System.out.println("Size of vector " + myVect.size());
		myVect.addLast(20);
		System.out.println("Size of vector " + myVect.size());
		//myVect.remove();
		//System.out.println("Size of vector " + myVect.size());
		System.out.println(myVect);
	}

	@Override
	public boolean add(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

}