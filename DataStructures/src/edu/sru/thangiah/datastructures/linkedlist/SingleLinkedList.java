package edu.sru.thangiah.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

/*
 * Generic SingleLinkedList 
 * Nodes remember the "next" node going down the list
 */
/**
 * <p>Title: SingleLinkedList</p>
 *
 * <p>Description: </p>
 * BaseOps interface class
 * 
 * Single linked list generic implementation. Users can call linked list specific methods (insert, add, remove, getAtIndex, etc.)
 * and also create instances of a linked list with only integers.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class SingleLinkedList extends AbstractSingleLinkedList {
	/**
	 * Initial node in the linked list that points to the first (head) node in the structure
	 */
	private NodeOneLink head; //points to first
	/**
	 * Last node in the linked list that points to the end node in the linked list
	 */
	private NodeOneLink tail; //points to last
	/**
	 * Points to the last node in the linked list that is intiailized with data (isn't tail)
	 */
	private NodeOneLink last;
	/**
	 * Points to the first node in the linked list that is initialized with data (isn't head)
	 */
	private NodeOneLink first;
	
	public SingleLinkedList()
	{
		head = new NodeOneLink("Head");
		tail = new NodeOneLink("Tail");
		last = head;
		first = head;
		head.setNext(tail);
	}
	
	/* Assume the pointer "first" in the SingleList class always points to the first node in the 
	 * linked list. Write code to create a SingleLinkedList and add two nodes. 
	 * At each insertion,the pointer  "first"  should point to the last node inserted on the
	 * linked list. The pointer "first" will always point to the node after the node pointed to by the head.
	*/
	
	//head and tail do not store any values, and shouldn't be counted in the size of the list
	public int size()
	{
		int count = 0;
		NodeOneLink ptr;
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
	
	public boolean isEmpty() {
		return head.getNext() == tail;	// evaluates to true if empty, false if not
	}
	
	public boolean isFull()
	{
		return false;
	}
	//Set the links for head & tail back to original
	public boolean clear()
	{
		if(!this.isEmpty())
		{
			head.setNext(tail);
			last = head;
			first = head;
			return true;
		}
		return false;
	}
	//Parse through list and return true if value is found in the container
	public boolean contains(int value)
	{
		NodeOneLink ptr;
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
	public int indexOf(int value)
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("The List Is Empty");
		}
		else 
		{	
			int index = 0;
			NodeOneLink ptr;
			ptr = head.getNext();
			
			while(ptr.getNext() != null)
			{
				index++;
				int data = Integer.parseInt(ptr.getData().toString());
				if(data == value)
				{
					return index;
				}
				ptr = ptr.getNext();
			}
		}
		
		return -1;
	}
	//Add at beginning of container
	public boolean addFirst(int value)
	{
		boolean returnVal = false;
		NodeOneLink temp;
		temp = new NodeOneLink(value);
		//list is empty
		if(head.getNext() == tail)
		{
			temp.setNext(first.getNext());
			first = temp;
			head.setNext(first);
			//ground the node
			temp = null;
			returnVal = true;
		}
		else // there is an existing first node
		{
			temp.setNext(first);
			first=temp;
			head.setNext(first);
			temp = null;
			returnVal = true;
		}

		
		
		return returnVal;
	}
	
	//Returns true upon successful addition of value
	public boolean add(Object data)
	{
		int pData = (int) data;
		return addFirst(pData);
	}
	
	//remove first element in container
	public int removeFirst()
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("List is empty");
		}
		NodeOneLink tmp = head;
		head = head.getNext();
		//int data = (int) tmp.getData();
		first = head.getNext();
		int data = (int) tmp.getNext().getData();
		return data;
	}
	/*
	 * Remove the first node from the linked list
	 * Returns node that is deleted
	 */
	public Object remove()
	{
		return removeLast();
	}
	
	/* Assume the pointer "last" in the SinglyList class always points to the
	last node on the linked list. Write code to create a SinglyLinkedList and
	add two nodes. At each insertion, the pointer "last" should point to the 
	lastnode inserted on the linked list. The pointer "last" will always be 
	the one before the node pointed to by the tail.
	*/
	
	//add to end of container
	public boolean addLast (int value)
	{
		boolean returnVal = false;
		NodeOneLink temp;
		temp = new NodeOneLink(value);
		
		if(head.getNext() == tail)
		{
			last = temp;
			head.next = temp;
			temp.next = tail;
			first = head.getNext();
			temp = null;
			returnVal = true;
		}
		else
		{
			temp.setNext(last.getNext());
			last.setNext(temp);
			last = temp;
			first = head.getNext();
			temp = null;
			returnVal = true;
		}
		
		return returnVal;
	}
	
	//iterate through the list to find the last node
	public int removeLast()
	{
		NodeOneLink ptr;
		Object data = -1;
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		//base condition to make sure list isn't empty
		else {
			//last holds the last element in list
			data = last.getData();
			//used to iterate through list
			ptr = head;
			
			//iterate until last element is reached
			while (ptr.getNext() != last)
			{
				ptr = ptr.getNext();
			}
			//set the next link to the tail (end of list)
			ptr.setNext(tail);
			//remove the last element and ground the ptr.
			last = ptr;
			ptr = null;
		}
		//returns the data of the element that was removed
		return (int) data;
	}
	/*
	 * Remove the last node from the linked list
	 */
	
	//return the first element in the container
	public Object getFirst()
	{
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		//first element in linkedList is the next value after the head
		else
		{
			return head.getNext().getData();
		}
	}
	//return the last element in the linked list
	public Object getLast()
	{
		//set a temp node to iterate through the linked list
		NodeOneLink temp;
		temp = head.getNext();
		//ensure list isn't empty
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		
		else
		{
			//iterate until we reach the last element
			while(temp.getNext()!= null)
			{
				if(temp.getNext() == tail)
				{
					break;
				}
				temp = temp.getNext();
			}
			return temp;
		}
	}
	public String toString()
	 {
		NodeOneLink temp;
		String tempStr;
		temp = head;
		tempStr="Linked list is:";
		
		while (temp!= null)
		{
			tempStr = tempStr + " "+temp.getData();
			temp = temp.getNext();
		}
		
		return tempStr;
		 
	 }
	
	/*
	 * Locate the node with the value val 
	 */
		public Object locate(Object val) {
			NodeOneLink tmp;
			NodeOneLink prevTmp; //trails temp one node behind
			Object tmpVal=-1;

			tmp = head.getNext();

			if (!this.isEmpty()) {
				//locate the node
				while (tmp != this.tail && tmp.getData() != val) {
					tmp = tmp.getNext();
				}
				//if val was not located or the previous node is pointing to the 
				//head buffer node, return null
				if (tmp == this.tail) {
					tmpVal=-1;
					return tmpVal;
				} 
				else {	
					return (Object)tmp.getData();
				}
			}
			return tmpVal;
		}
	
	
	/*
	 * Locate the node with the value val and delete the node previous to it.
	 */
		
		public Object delPrev(Object val)
		{
			NodeOneLink temp = head;
			NodeOneLink prevtemp = null;
			if(!this.isEmpty())
			{
				while(temp.getNext().getData() != val && temp.getNext() != null)
				{
					prevtemp= temp;
					temp =temp.getNext();
				}
				if(temp != head)
				{
					prevtemp.setNext(temp.getNext());
					return temp;
				}
			}
			return -1;
		}
		//Unlike Arrays, linkedlists are not 0 indexed, meaning that index 1 is always the first element in the list
		public Object getAtIndex(int i)
		{
			if(i < 0 || i > this.size())
			{
				throw new IndexOutOfBoundsException();
			}
			int count = 0;
			NodeOneLink ptr;
			ptr = head;
			if(!this.isEmpty())
			{
				while(ptr != null)
				{
					if(count == i)
					{
						return ptr;
					}
					count++;
					ptr = ptr.getNext();
				}
			}
			//function call points to a non-existent index in the list
			return -1;
		}
		//set the value of the given element to the value passed in the function call
		public int setAtIndex(int i, int value)
		{
			if(i < 0 || i > this.size())
			{
				throw new IndexOutOfBoundsException();
			}
			if(i<this.size() && !this.isEmpty()) // index is in the scope of the list and list isn't empty
			{
				int j = 0;
				NodeOneLink temp = head;
				while(j<i)//
				{
					j+=1;
					temp = temp.getNext();
				}
				temp.setData(value);
				return value;
			}
			return -1;
		}
		//remove the element at the specified index.
		public int removeAtIndex(int i)
		{
			if(i < 0 || i > this.size())
			{
				throw new IndexOutOfBoundsException("Out of the list bounds");
			}
			if(i<this.size() && !this.isEmpty()) // index is in the scope of the list and list isn't empty
			{
				int j = 0;
				NodeOneLink temp = head;
				while(j<i-1)//iterate until one before index to be removed
				{
					j+=1;
					temp = temp.getNext();
				}
				Object returnVal = temp.getNext().getData();
				temp.setNext(temp.getNext().getNext()); //next element before removed is set to element after removed
				return (int) returnVal; //value removed is returned
			}
			return -1;
		}
		
		public int addAtIndex(int i, int value)
		{
			if(i < 0 || i > this.size())
			{
				throw new IndexOutOfBoundsException();
			}
			if(i<this.size() && !this.isEmpty())
			{
				int j = 0;
				NodeOneLink temp = head;
				NodeOneLink prev = temp;
				NodeOneLink insertNode = new NodeOneLink(null);
				while(j<i)//
				{
					prev = temp;
					j+=1;
					temp = temp.getNext();
				}
				insertNode.setNext(temp);
				insertNode.setData(value);
				prev.setNext(insertNode);
				//temp.setNext(temp.getNext());
				//head.setNext(first);
				//temp = null;
				//temp.setData(value);
				return value;
			}
			return -1;
		}
	
	
	 public static void main(String args[])
	 {
		 /*
		 SingleLinkedList singleLL = new SingleLinkedList();
		 System.out.println(singleLL.getAtIndex(0));
		 singleLL.addLast(4);
		 System.out.println(singleLL);
		 singleLL.addLast(5);
		 System.out.println(singleLL);
		 System.out.println(singleLL.getAtIndex(0));
		 singleLL.addLast(6);
		 System.out.println(singleLL);
		 System.out.println(singleLL.size());
		 singleLL.delPrev(5);
		 System.out.println(singleLL);
		 System.out.println(singleLL.getFirst());
		 System.out.println(singleLL);
		 //singleLL.addNodeFirst("a");
		 //singleLL.addNodeFirst("b");
		 //System.out.println(singleLL);
		 //System.out.println(singleLL.getFirst());
		 //System.out.println(singleLL.getLast());
		 //singleLL.setAtIndex(1,1);
		 System.out.println(singleLL.clear());
		 System.out.println(singleLL.size());
		 */
		 SingleLinkedList testInitializedList = new SingleLinkedList();
		 
		 testInitializedList.addLast(50);
			testInitializedList.addLast(1000);
			testInitializedList.addLast(600);
			testInitializedList.addLast(8);
			testInitializedList.addLast(1111);
			testInitializedList.addLast(222);
			
			 System.out.println(testInitializedList);
			 
			 System.out.println(testInitializedList.contains(600));
			 
			 testInitializedList.delPrev(8);
			
			 System.out.println(testInitializedList);
			 
			 System.out.println(testInitializedList.getAtIndex(2));
			 
			 System.out.println(testInitializedList.getAtIndex(3));
			 
			 System.out.println(testInitializedList);
			
			
	 }	
}