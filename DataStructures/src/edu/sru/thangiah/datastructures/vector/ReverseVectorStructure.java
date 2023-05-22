package edu.sru.thangiah.datastructures.vector;

/*
 * Vector structure constructed to fill backwards, starting at MAXSIZE-1 and
 * filling from back to front
 * Allows shifting when values are inserted, good first step for queues and stacks
 */

/**
 * <p>Title: ReverseVectorStructure</p>
 *
 * <p>Description: </p>
 * Reverse vector class used to store elements in a descending order from back to front. 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class ReverseVectorStructure {

	/**
	 * max size of the array
	 */
	private final int MAXSIZE = 100;
	
	/**
	 * arrayVal holds the values being added to the vector
	 */
	private int arrayVal[];
	
	/**
	 * count holds the closest forward index in the array, and is implemented
	 * in the add and remove functions. 
	 */
	private int count;
	
	ReverseVectorStructure()
	{
		arrayVal = new int[MAXSIZE];
		count = MAXSIZE-1;     
	}
	
	
	public boolean isEmpty() {//checks if vector is empty
		if (count == (MAXSIZE-1)) {
			return true;
		}
		return false;
	}

	public boolean isFull() {//checks if vector is full
		if (count == -1) {
			return true;
		}
		return false;
	}

	/**
	 * If the vector is not full it adds a value to the array 
	 * at index count, which decreases and gets closer to zero
	 * as you progress
	 * @param value - The data to be added to the vector
	 * @return True on successful addition
	 */
	
	public boolean add(int value) { 
		if (!this.isFull()) {
			arrayVal[count] = value;
			count--;
			return true;
		}
		return false;
	}

	/**
	 * If the vector is not empty it removes the front elem
	 * @return True on successful removal
	 */
	
	public boolean remove() { //removes value if vector is not empty
		if (!this.isEmpty()) {
			count++;
			return true;
		}
		return false;
	}
	
	/**
	 * Adds the value at a specified index to the vector
	 * @param i - index 
	 * @param value - int information to be added
	 * @return index if successful, -1 if failed
	 */
	int setAtIndex(int i, int value) { //sets a value at a specific index
		if (i >= 0 && i < this.MAXSIZE) {
			if (this.isEmpty()) // vector is empty
			{
				if (i == this.count)
				{
					this.add(value);
					return i;
				}
				else 
				{
					return -1;
				}
			} 
			else if (this.isFull()) // vector is full
			{
				return -1;
			} 
			else // vector is neither empty nor full
			{
				//shift everything from i onwards to the left by one
				for (int j=count; j < i; j++)
				{
					arrayVal[j]=arrayVal[j+1];
				}
				arrayVal[i]=value;
				count--;
				return i;
			}
		} 
		else { //outside the bounds of the array
			return -1;
		}
	}
	
	/**
	 * removes the value at the given index
	 * @param i - index 
	 * @return the integer value at index i
	 */
	int removeAtIndex(int i) {
		int returnVal;
		if (i >= 0 && i < this.MAXSIZE) {
			if (this.isEmpty()) // vector is empty
			{
					return -1;
			} 
			else if (this.count+1 == i) // last one added
			{
				count++;
				returnVal = arrayVal[i];
				return returnVal;
			} 
			else // vector is neither empty nor full
			{
				returnVal = arrayVal[i];
				// shift everything down from top to i
				for (int j = i; j > count; j--) {
					arrayVal[j] = arrayVal[j-1];
				}
				count++;
				return returnVal;
			}
		} else { // outside the bounds of the array
			return -1;
		}
	}
	public static void main(String args[])
	{
		
		ReverseVectorStructure reverseVect = new ReverseVectorStructure();
		reverseVect.setAtIndex(58,100);
		reverseVect.setAtIndex(99,100);
		reverseVect.add(10);
		reverseVect.add(15);
		reverseVect.add(23);
		reverseVect.add(56);
		reverseVect.setAtIndex(96,101);
		reverseVect.setAtIndex(99,101);
		reverseVect.removeAtIndex(96);
		
		
		
	}
}
