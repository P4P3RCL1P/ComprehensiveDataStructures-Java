package edu.sru.thangiah.datastructures.generic.stack;

/*
 * Stack generic class
 * Implements pop and push in first in last out order
 * Generic implementation for use in any data type
 * !!! Limited by MAXSIZE in size, 
 */

/**
 * <p>Title: StackGeneric</p>
 *
 * <p>Description: </p>
 * Stack generic class
 * Implements pop and push in first in last out order
 * Generic implementation for use in any data type
 * !!! Limited by MAXSIZE in size, 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class StackArrayGeneric <T> extends AbstractStackGeneric <T>{
	/**
	 * Holds the maximum size of the stack
	 */
	private final int MAXSIZE=50;
	/**
	 * stores the values in the stack
	 */
	private Object[] arrayVal;
	/**
	 * Count of the items in the stack
	 */
	private int count;
	
	public StackArrayGeneric()
	{
		arrayVal =  new Object[MAXSIZE];
		count = 0;
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean clear()
	{
		while(count > 0)
		{
			pop();
		}
		return isEmpty();
	}
	
	public boolean contains(Object value)
	{
		//find int value in stack
		for(int i = 0; i < count; i++)
		{
			if(arrayVal[i] == value);
			{
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(Object value)
	{
		for(int i = 0; i < count; i++)
		{
			if(arrayVal[i] == value);
			{
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		if (count == 0)
		{
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (count == MAXSIZE-1)
		{
			return true;
		}
		return false;
	}

	//push
	public void push(Object number) {
		if (!this.isFull())
		{
			arrayVal[count] = number;
			count++;
		}	
	}

	//pop
	public T pop() {
		T val;
		val= null;
		
		if (!this.isEmpty())
		{
			val = (T)arrayVal[--count];
			arrayVal[count] = null;
			return val;
		}
		return val;
	}

	public T top() {
		T val;
		val= null;
		if (!this.isEmpty())
		{
			return (T)arrayVal[count-1];
		}
		return val;
	}
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String args[])
	{
		/*StackGeneric<String> stackString = new StackGeneric();
		System.out.println("Generic stack string is empty "+stackString.isEmpty());
		System.out.println("Generic stack string is full "+stackString.isFull());
		stackString.push("10");
		stackString.push("20");
		stackString.push("30");
		System.out.println("Generic stack pop value is "+stackString.pop());
		*/
		
		StackArrayGeneric<Integer> stackInteger = new StackArrayGeneric();
		System.out.println("Generic stack integer is empty "+stackInteger.isEmpty());
		System.out.println("Generic stack integer is full "+stackInteger.isFull());
		stackInteger.push(10);
		stackInteger.push(20);
		stackInteger.push(30);
		System.out.println("Generic stack pop value is "+stackInteger.pop());
		stackInteger.clear();
	}

}
