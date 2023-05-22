package edu.sru.thangiah.datastructures.generic.stack;

import edu.sru.thangiah.datastructures.generic.linkedlist.*;
import edu.sru.thangiah.datastructures.stack.StackLinkedList;

public class StackLinkedListGeneric<T extends Comparable<T>> extends AbstractStackGeneric{
	/**
	 * Instance of SingleLinkedListGeneric which is used to simulate the stack implementation
	 */
	private SingleLinkedListGeneric singleLL;
	private int nodeCount;
	
	public StackLinkedListGeneric()
	{
		singleLL = new SingleLinkedListGeneric();
		nodeCount = 0;
	}
	
	
	@Override
	public boolean isEmpty() {
		if(singleLL.isEmpty())
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(singleLL.isFull())
		{
			return true;
		}
		return false;
	}
	
	public boolean clear()
	{
		singleLL = new SingleLinkedListGeneric();
		nodeCount = 0;
		return true;
	}
	

	/**
	 * Adds an element to the front of the linked list in order to maintain the stack structure
	 * 
	 * @param value - The value to add to the stack.
	 */
	public boolean push(T number)
	{
		 this.addFirst(number);
		 nodeCount++;
		 return true;
	}
	public boolean addFirst(T value)
	{
		if(!this.isFull())
		{
			singleLL.addFirst(value);
			return true;
		}
		return false;
	}
	public Object removeFirst()
	{
		Object objectRemoved = null;
		if(!this.isEmpty())
		{
			objectRemoved = singleLL.getFirst();
			singleLL.removeFirst();
			nodeCount--;
			
		}
		return objectRemoved;
	}
	public Object pop()
	{
		Object result;
		result = removeFirst();
		return result;
	}
	public Object top()
	{
		return this.getFirst();
	}
	
	public Object getFirst()
	{
		Object topObject = null;
		
		if(!this.isEmpty())
		{
			topObject = singleLL.getFirst();
		}
		return topObject;
	}
	
	public T getLast()
	{
		if(!this.isEmpty())
		{
			return (T) singleLL.getLast();
		}
		return null;
	}
	public int size()
	{
		return nodeCount;
	}


	public T getAtIndex(int i)
	{
		return (T) singleLL.getAtIndex(i);
	}
	public T setAtIndex(int i, T value)
	{
		return (T) singleLL.setAtIndex(i, value);
	}
	public T remove()
	{
		return (T) pop();
	}
	public boolean add(T value)
	{
		return push(value);
	}
	
	
	
	public String toString()
	{
		//return string
		return singleLL.toString();
	}
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String args[])
	{
		StackLinkedListGeneric<Integer> stack = new StackLinkedListGeneric<Integer>();
		System.out.println("Stack is empty-1:"+stack.isEmpty());
		System.out.println("Stack is full-1:"+stack.isFull());
		System.out.println("Pop value is "+stack.pop());
		stack.push(10);
		//for (int i=0; i < 3; i++)
		//{
		//	System.out.println("Pop value is "+stack.pop());
		//}
		//System.out.println("Pop value is " +stack.pop());
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.addFirst(50);
		System.out.println(stack);
		System.out.println("Stack pop is " + stack.removeFirst());
		System.out.println("Stack is"+stack);
		System.out.println("Stack pop is " + stack.pop());
		System.out.println("stack is" + stack);
		System.out.println(stack.getAtIndex(1));
		System.out.println(stack.setAtIndex(1, 100));
		System.out.println("Stack is"+stack);
		/*for (int i=0; i < 14; i++)
		{
			stack.push(i*10);
		}
		System.out.println("Stack is"+stack);
		System.out.println("Stack pop value is "+stack.pop());
		System.out.println("Stack pop value is "+stack.pop());
		System.out.println("Stack is"+stack);
		System.out.println("Stack is empty-2:"+stack.isEmpty());
		System.out.println("Stack is full-2:"+stack.isFull());
		for (int i=0; i < 20; i++)
		{
			System.out.println("Stack pop value is "+stack.pop());
		}
		System.out.println("Stack is"+stack);
		System.out.println("Stack is empty-3:"+stack.isEmpty());
		System.out.println("Stack is full-3:"+stack.isFull());*/
	}

}
