package edu.sru.thangiah.datastructures.stack;

import edu.sru.thangiah.datastructures.linkedlist.*;

/**
 * <p>Title: StackLinkedList</p>
 *
 * <p>Description: </p>
 * Stack implementation which employs the benefits of linked lists.
 * Using linked lists allows us to point to previous nodes in the stack for easier traversal/deletion
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class StackLinkedList extends AbstractStack{
	/**
	 * Instance of SingleLinkedList which is used to simulate the stack implementation
	 */
	private SingleLinkedList singleLL;
	
	public StackLinkedList()
	{
		singleLL = new SingleLinkedList();
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
		//call SinglyLinkedList method
		return false;
	}

	/**
	 * Adds an element to the front of the linked list in order to maintain the stack structure
	 * 
	 * @param value - The value to add to the stack.
	 */
	// push
	public boolean push(int value) {
		//call addFirst
		return this.addFirst(value);
	}

	@Override
	public boolean addFirst(int value) {
		//call SinglyLinkedList method
		if(!this.isFull())
		{
			singleLL.addFirst(value);
			return true;
		}
		return false;
	}


	//pop
	public Object pop() {
		Object result ;
		result =removeFirst();
		return result;
	}
	
	@Override
	public int removeFirst() {
		//call SinglyLinkedList method
		int objectRemoved = -1;
		if(!this.isEmpty())
		{
			objectRemoved = (int) singleLL.getFirst();
			
			singleLL.removeFirst();
		}
		return (int) objectRemoved;
	}
	
	//top
	public Object top() 
	{
		return (Object) this.getFirst();
	}

	@Override
	public Object getFirst() {
		//call SinglyLinkedList method
		int topObject = -1;
		//call getFirst()
		if(this.isEmpty())
		{
			
		}
		else
		{
			topObject = (int) singleLL.getFirst();
		}
		return topObject;
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
		StackLinkedList stack = new StackLinkedList();
		System.out.println("Stack is empty-1:"+stack.isEmpty());
		System.out.println("Stack is full-1:"+stack.isFull());
		System.out.println("Pop value is "+stack.pop());
		stack.push(10);
		for (int i=0; i < 3; i++)
		{
			System.out.println("Pop value is "+stack.pop());
		}
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.addFirst(50);
		System.out.println("Stack pop is " + stack.removeFirst());
		for (int i=0; i < 14; i++)
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
		System.out.println("Stack is full-3:"+stack.isFull());
	}

	@Override
	public boolean add(int value) {
		return push(value);
	}

	@Override
	public Object remove() {
		return pop();
	}
}
