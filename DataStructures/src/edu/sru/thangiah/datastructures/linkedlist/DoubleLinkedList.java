package edu.sru.thangiah.datastructures.linkedlist;

import java.util.NoSuchElementException;


/**
 * <p>Title: DoubleLinkedList</p>
 *
 * <p>Description: </p>
 * Double linked list implementation where each node as a previous and next pointer.
 * This helps with traversing both backwards and forwards. Additionally deletions are faster compared to a single linked list
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class DoubleLinkedList extends AbstractDoubleLinkedList {
	/**
	 * Head variable points to the beginning of the linked list
	 */
	private NodeTwoLinks head;
	/**
	 * Tail variable poiunts ot the end of the linked list
	 */
	private NodeTwoLinks  tail;

	
	DoubleLinkedList()
	{
		head = new NodeTwoLinks("Head");
		tail = new NodeTwoLinks("Tail");
		head.setNext(tail);
		tail.setPrev(head);
	}

	
	//head and tail do not store any values, and shouldn't be counted in the size of the list
	public int size()
	{
		int count = 0;
		NodeTwoLinks ptr;
		ptr = head;
		if(!this.isEmpty())
		{
			while(ptr.getNext() != tail)
			{
				count++;
				ptr = ptr.getNext();
			}
		}
		return count;
	}
	
	public boolean isEmpty()
	{
		if (head.getNext() == tail)
		{
			return true;
		}
		return false;
	}
	//linked lists should not have isFull method
	public boolean isFull() {
		if (head.getNext() == tail)
		{
			return false;
		}
		return true;
	}
	
	//Set the links for head & tail back to original
	public boolean clear()
	{
		if(!this.isEmpty())
		{
			head.setNext(tail);
			tail.setPrev(head);
			return true;
		}
		return false;
	}
	//Parse through list and return true if value is found in the container
	public boolean contains(int value)
	{
		NodeTwoLinks ptr;
		ptr = head.getNext();
		if(!this.isEmpty())
		{
			while(ptr.getNext() != null)
			{
				if((int)ptr.getData() == value)
				{
					return true;
				}
				ptr = ptr.getNext();
			}
		}
		return false;
	}
	//Similar to contains, except return the index of the value that is found in the container
	
	
	//SUPPOSED TO HAVE ADD/REMOVE METHODS HERE?
	
	@Override
	public boolean add(int value) {
		return addLast(value);
	}


	@Override
	public Object remove() {
		return removeLast();
	}
	
	
	public int indexOf(int value)
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		else 
		{	
			int index = 0;
			NodeTwoLinks ptr;
			ptr = head.getNext();
			while(ptr.getNext() != null)
			{
				index++;
				if((int) ptr.getData() == value)
				{
					return index;
				}
				ptr = ptr.getNext();
			}
		}
		
		return -1;
	}

	
	//Add at beginning of container
	public boolean addFirst (int value)
	{
		boolean returnVal = false;
		NodeTwoLinks temp;
		temp = new NodeTwoLinks(value);
		//list is empty
		if(isEmpty())
		{
			temp.setPrev(head);
			temp.setNext(head.getNext());
			temp.getNext().setPrev(temp);
			head.setNext(temp);
			//ground instance
			temp = null;
			returnVal = true;
		}
		//There is already an element in the list
		else
		{
			temp = new NodeTwoLinks(value);
			temp.setPrev(head);
			temp.setNext(head.getNext());
			temp.getNext().setPrev(temp);
			head.setNext(temp);
			temp=null;
		}
		return returnVal;
	}
	
	public boolean addLast(int data)
	{
		boolean returnVal = false;
		NodeTwoLinks temp;
		temp = new NodeTwoLinks(data);
		
		if(isEmpty())
		{
			head.setNext(temp);
			temp.setNext(tail);
			tail.setPrev(temp);
			temp.setPrev(head);
			temp = null;
			returnVal = true;
		}
		else
		{
			tail.getPrev().setNext(temp);
			temp.setPrev(tail.getPrev());
			tail.setPrev(temp);
			temp.setNext(tail);
			temp = null;
			returnVal = true;
		}
		return returnVal;
	}
	
	//remove first element in container
	public int removeFirst()
	{
		int data;
		NodeTwoLinks temp;
		data = -1;
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		
		//point to first node to be removed
		temp = head.getNext();
		data = (int)temp.getData();
			
		temp.getNext().setPrev(head);
		head.setNext(temp.getNext());
			
		temp.setNext(null);
		temp.setPrev(null);
		temp=null;
		return data;
	}
	
	
	/*
	 * Remove the last node from the linked list
	 */
	public int removeLast()
	{
		int data;
		NodeTwoLinks temp;
		data = -1;
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}

		//point to last node to be removed
		temp = tail.getPrev();
		data = (int)temp.getData();
			
		temp.getPrev().setNext(tail);
		tail.setPrev(temp.getPrev());
			
		temp.setNext(null);
		temp.setPrev(null);
		temp=null;
		return data;
	}
	
	//Get the first value in the linked list without removing it 
	public Object getFirst()
	{
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		else
		{
			return head.getNext();
		}//??
	}
	
	//Get the last value in the linked list without removing it 
	public Object getLast()
	{
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		
		return tail.getPrev(); //? 
	}
	
	public boolean insertAscend(Object data)
	{
	   NodeTwoLinks newNode = new NodeTwoLinks(data);
	   NodeTwoLinks ptr = head.getNext();
	   //If data does not already exist
	   if(head.getNext() != tail)
	   {
	       //get to the correct location
	       while((int) ptr.getData() > (int)data && ptr != tail)
	       {
	           ptr = ptr.getNext();
	       }
	       //Insert the new node
	       ptr.getPrev().setNext(newNode);
	       newNode.setPrev(ptr.getPrev());
	       ptr.setPrev(newNode);
	       newNode.setNext(ptr);
	   }
	   //In the case a basic insert is needed
	   else
	   {
	       newNode.setNext(tail);
	       newNode.setPrev(head);
	       head.setNext(newNode);
	       tail.setPrev(newNode);
	   }
	   
	   return true;
	}
	
	/*
	 *     insert a node with data at the index i
	 */
	public Object getAtIndex(int i)
	{
		if(i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		NodeTwoLinks ptr;
		ptr = head;
		
		for (int index = 0; index < i; index++) //goes up to the index i
		{
			if(ptr.getNext() == tail)
			{
				return -1;
			}
			else
			{
				ptr = ptr.getNext();
			}
		}
		return ptr.getData();
	}
	//set the value of the given element to the value passed in the function call
	public int setAtIndex(int i, int value)
	{
		{
			if(i < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			NodeTwoLinks ptr;
			ptr = head;
			
			for (int index = 0; index < i; index++) //goes up to the index i
			{
				if(ptr.getNext() == tail)
				{
					return -1;
				}
				else
				{
					ptr = ptr.getNext();
				}
			}
			ptr.setData(value);
			return value;
		}
		
	}
	//remove the element at the specified index.
	public int removeAtIndex(int i) {
		if(i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		NodeTwoLinks ptr;
		int nodeData = -1;
		ptr = head;
		for (int index = 0; index < i-1; index++) { //go up to the node before i
			if (ptr.getNext() == tail) {
				return -1;
			} 
			else 
			{
				ptr = ptr.getNext();
			}
		}
		nodeData = (int) ptr.getNext().getData();
		//ptr.getNext().setPrev(ptr.getNext());
		//ptr.getNext().setPrev(ptr.getPrev());
		ptr.getNext().getNext().setPrev(ptr);
		ptr.setNext(ptr.getNext().getNext());
		ptr.setPrev(ptr.getPrev());
		//ptr.getNext().setPrev(null);
		//ptr.getNext().setNext(null);
		//ground next/prev and ptr object
		//ptr.setNext(null);
		//ptr.setPrev(null);
		//ptr = null;
		return nodeData;
	}
	public int addAtIndex(int i, int value) {
		if(i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		NodeTwoLinks tmp;
		NodeTwoLinks ptr;
		boolean isAdd = true;

		ptr = head;
		for (int index = 0; index < i-1; index++) { //go up to the node before i
			if (ptr.getNext() == tail) {
				System.out.println("ERROR: Index does not exist in the linked list.");
				isAdd = false;
				break;
			} else {
				ptr = ptr.getNext();
			}
		}
		if (isAdd) {
			tmp = new NodeTwoLinks(value);
			tmp.setNext(ptr.getNext());
			tmp.setPrev(ptr);
			ptr.getNext().setPrev(tmp);
			ptr.setNext(tmp);
			ptr = null;
			tmp = null;
			return value;
		} else {
			return -1;
		}
	}
	public Object removeData(Object data)
	{
		NodeTwoLinks tmp;
		NodeTwoLinks deleteNode = new NodeTwoLinks(data);
		NodeTwoLinks emptyNode;
		
		emptyNode = new NodeTwoLinks(-1);
		tmp = head.getNext();

		if (!this.isEmpty()) {
			//locate the node
			while (tmp != this.tail)
			{
				System.out.print(tmp.getData() + ":::" + deleteNode.getData() + "\n");
				if((int)tmp.getData() == (int)deleteNode.getData())
				{
					break;
				}
				tmp = tmp.getNext();
			}
			//if val was not located or the previous node is pointing to the 
			//head buffer node, return emptyNode
			if (tmp == this.tail || tmp.getPrev() == head.getNext()) {
				return emptyNode;
			} 
			else {
				deleteNode = tmp;
				tmp = tmp.getNext();
				tmp.setPrev(deleteNode.getPrev());
				deleteNode.getPrev().setNext(tmp);
				deleteNode.setNext(null);
				deleteNode.setPrev(null);
				return deleteNode;
			}
		}
		else //linked list is empty
		{
			return emptyNode;
		}
	}


	public  String toString()
	{
		NodeTwoLinks temp;
		String tempStr;
		temp = head;
		tempStr="Linked list is:";

		while (temp!= null)
		{
			tempStr = tempStr + " " + temp.getData();
			temp = temp.getNext();
		}

		return tempStr;

	}
	
	
	/*
	 * Locate data and add the data value and the value of the next node
	 */
	
	public Object addTwoNodes(Object data)
	{
		NodeTwoLinks tmp;
		int sum;
		
		tmp = head.getNext();
		
		//locate the node. 
		while (tmp != tail && tmp.getData() != data)
		{
			tmp = tmp.getNext();
		}
		
		//It should not be tail and the next node should not be tail.
		if (tmp == tail || tmp.getNext() == tail)
		{
			return -1;
		}
		else
		{
			sum = (int)tmp.getData() + (int)tmp.getNext().getData();
			return sum;
		}
		
	}
	
	/**
	 * Deletes the previous node. A value is passed which is searched for, and then the node before that located node is deleted
	 * @param val
	 * @return The deleted node
	 */
		public Object delPrev(Object val) {
			NodeTwoLinks tmp;
			NodeTwoLinks deleteNode = new NodeTwoLinks(val);
			NodeTwoLinks emptyNode;
			
			emptyNode = new NodeTwoLinks(-1);
			tmp = head.getNext();

			if (!this.isEmpty()) {
				//locate the node
				while (tmp != this.tail)
				{
					System.out.print(tmp.getData() + ":::" + deleteNode.getData() + "\n");
					if((int)tmp.getData() == (int)deleteNode.getData())
					{
						break;
					}
					tmp = tmp.getNext();
				}
				//if val was not located or the previous node is pointing to the 
				//head buffer node, return emptyNode
				if (tmp == this.tail || tmp.getPrev() == head.getNext()) {
					return emptyNode;
				} 
				else {	
					deleteNode = tmp.getPrev();
					tmp.setPrev(deleteNode.getPrev());
					deleteNode.getPrev().setNext(tmp);
					deleteNode.setNext(null);
					deleteNode.setPrev(null);
					return deleteNode;
				}
			}
			else //linked list is empty
			{
				return emptyNode;
			}
		}
	
	

	/*
	 * contains(data) remove(data) set(i,data) - set data at value in index i
	 * add(i,data) - add data at index i remove(i) getDatatIndex(i) - return data -
	 * return data value indexOf(data) - locate index of data in the list
	 * lastIndexOf(data) - locate last index of data in the list printForward()
	 * printBackward()
	 * 
	 * 
	 */
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	 public static void main(String args[])
	 {
		 
		 /*SingleLinkedList singleLL = new SingleLinkedList();		 
		 singleLL.addNodeLast("a");
		 singleLL.addNodeLast("b");
		 System.out.println(singleLL);
		 
		 
		 DoubleLinkedList doubleLL = new DoubleLinkedList();		 
		 doubleLL.addNodeFirst("a");
		 doubleLL.addNodeFirst("b");
		 doubleLL.addAtIndex(1,"c");
		 System.out.println(doubleLL);
		 System.out.println(doubleLL.removeData("d"));
		 System.out.println(doubleLL.removeData("b"));
		 System.out.println(doubleLL);
		 
		 
		 */
		 DoubleLinkedList doubleLL = new DoubleLinkedList();		 
		 doubleLL.addLast(50);
		 doubleLL.addLast(1000);
		 doubleLL.addLast(600);
		 doubleLL.addLast(8);
		 doubleLL.addLast(1111);
		 doubleLL.addLast(222);
		 System.out.println(doubleLL);
		 doubleLL.insertAscend(555);
		 doubleLL.removeData(1111);
		 System.out.println(doubleLL);
		 
		 
	 }	
}
