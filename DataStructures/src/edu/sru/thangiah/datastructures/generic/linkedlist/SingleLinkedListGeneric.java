package edu.sru.thangiah.datastructures.generic.linkedlist;
import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.*;
import edu.sru.thangiah.datastructures.generic.linkedlist.NodeOneLinkGeneric;
import edu.sru.thangiah.datastructures.linkedlist.NodeOneLink;
import edu.sru.thangiah.datastructures.linkedlist.SingleLinkedList;

/*
 * Single linked list generic implementation. Users can call linked list specific methods (insert, add, remove, getAtIndex, etc.)
 * and also create instances of a linked list with any data type.
 */

/**
 * <p>Title: SingleLinkedListGeneric</p>
 *
 * <p>Description: </p>
 * BaseOps interface class
 * 
 * Single linked list generic implementation. Users can call linked list specific methods (insert, add, remove, getAtIndex, etc.)
 * and also create instances of a linked list with any data type.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class SingleLinkedListGeneric <T extends Comparable<T>>  extends AbstractSingleLinkedListGeneric <T>{

	/**
	 * Initial node in the linked list that points to the first (head) node in the structure
	 */
	private NodeOneLinkGeneric head; //points to first
	/**
	 * Last node in the linked list that points to the end node in the linked list
	 */
	private NodeOneLinkGeneric tail; //points to last
	/**
	 * Points to the last node in the linked list that is intiailized with data (isn't tail)
	 */
	private NodeOneLinkGeneric last;
	/**
	 * Points to the first node in the linked list that is initialized with data (isn't head)
	 */
	private NodeOneLinkGeneric first;
	
	public SingleLinkedListGeneric()
	{
		head = new NodeOneLinkGeneric("Head");
		tail = new NodeOneLinkGeneric("Tail");
		last = head;
		first = head;
		head.setNext(tail);
	}
	
	@Override
	public int size() {
		NodeOneLinkGeneric p = new NodeOneLinkGeneric(head, head.getNext());
		int count=0; 
		while(p.getNext()!=tail) {
			count +=1;
			p=p.getNext();
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		if(head.getNext()==tail) {
			return true; //if the next node for head is tail then it is empty
		}
		return false;
	}
	
	@Override
	public boolean isFull() {
		
		return false;
	}
	

	@Override
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

	@Override
	public boolean contains(T value)
	{
		NodeOneLinkGeneric ptr;
		ptr = head.getNext();
		if(!this.isEmpty())
		{
			while(ptr.getNext() != null)
			{
				T data = (T)ptr.getData();
				if(data.compareTo(value) == 0)
				{
					return true;
				}
				ptr = ptr.getNext();
			}
		}
		return false;
	}

	@Override
	public boolean add(T value) {
		return false; 
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public int indexOf(T value)
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		else 
		{	
			int index = 0;
			NodeOneLinkGeneric ptr;
			ptr = head.getNext();
			
			while(ptr.getNext() != null)
			{
				index++;
				T data = (T)ptr.getData();
				if(data.compareTo(value) == 0)
				{
					return index;
				}
				ptr = ptr.getNext();
			}
		}
		
		return -1;
	}

	@Override
	public boolean addFirst(T value)
	{
		boolean returnVal = false;
		NodeOneLinkGeneric temp;
		temp = new NodeOneLinkGeneric(value);
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

	@Override
	public boolean addLast(T value) {
		NodeOneLinkGeneric temp;
		temp = new NodeOneLinkGeneric(value);
		//the list is empty
		if (head.getNext() == tail)
		{			
			//set the links
			last = temp;
			head.setNext(temp);
			temp.setNext(tail);
			temp = null;
			first = head.getNext();
			return true;
		}
		else //there is at least one node
		{
			temp.setNext(last.getNext());
			last.setNext(temp);
			last = temp;
			temp = null;
			first = head.getNext();
			return true;
		}
	}

	@Override
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

	@Override
	public Object getLast()
	{
		//set a temp node to iterate through the linked list
		NodeOneLinkGeneric temp;
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
			return temp.getData();
		}
	}

	@Override
	public T removeFirst() {
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		Object info = first.getData();
		head.setNext(first.getNext());
		first = head.getNext();
		return (T) info;
	}

	@Override
	public T removeLast()
	{
		NodeOneLinkGeneric ptr;
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
		return (T)data;
	}
	
	public T delPrev(T val)
	{
		NodeOneLinkGeneric temp = head;
		NodeOneLinkGeneric prevtemp = null;
		if(!this.isEmpty())
		{
			while(temp.getNext() != null)
			{
				T data = (T)temp.getNext().getData();
				if(data.compareTo(val) == 0)
				{
					break;
				}
				prevtemp= temp;
				temp = temp.getNext();
			}
			if(temp != head)
			{
				prevtemp.setNext(temp.getNext());
				return (T)temp.getData();
			}
		}
		return null;
	}

	@Override
	public T removeAtIndex(int i)
	{
		if(i < 0 || i > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(i<=this.size() && !this.isEmpty()) // index is in the scope of the list and list isn't empty
		{
			Object returnVal = null;
			int j = 0;
			NodeOneLinkGeneric temp = head;
			if(this.size() == 1)
			{
				returnVal = this.getAtIndex(1);
				this.clear();
				return (T)returnVal;
			
			}
			while(j<i-1)//iterate until one before index to be removed
			{
				j+=1;
				temp = temp.getNext();
			}
			returnVal = temp.getNext().getData();
			temp.setNext(temp.getNext().getNext()); //next element before removed is set to element after removed
			return (T)returnVal; //value removed is returned
		}
		return null;
	}

	public T getAtIndex(int i)
	{
		if(i < 0 || i > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		NodeOneLinkGeneric ptr;
		ptr = head;
		if(!this.isEmpty())
		{
			while(ptr != null)
			{
				if(count == i)
				{
					return (T)ptr.getData();
				}
				count++;
				ptr = ptr.getNext();
			}
		}
		//function call points to a non-existent index in the list
		return null;
	}

	@Override
	public T setAtIndex(int i, T value)
	{
		if(i < 0 || i > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(i<=this.size() && !this.isEmpty()) // index is in the scope of the list and list isn't empty
		{
			int j = 0;
			NodeOneLinkGeneric temp = head;
			while(j<i)//
			{
				j+=1;
				temp = temp.getNext();
			}
			temp.setData(value);
			return value;
		}
		return null;
	}

	public T addAtIndex(int i, T value)
	{
		if(i < 0 || i > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(i<this.size() && !this.isEmpty())
		{
			int j = 0;
			NodeOneLinkGeneric temp = head;
			NodeOneLinkGeneric prev = temp;
			NodeOneLinkGeneric insertNode = new NodeOneLinkGeneric(null);
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
		return null;
	}
	
	@Override
	public Object locate(Object val) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Getter method for getting the head node
	 * @return The head pointer
	 */
	public NodeOneLinkGeneric getHead() {
		return head;
	}

	/**
	 * Setter mehtod for the head pointer
	 * @param head
	 */
	public void setHead(NodeOneLinkGeneric head) {
		this.head = head;
	}

	/**
	 * Getter method for the tail pointer
	 * @return
	 */
	public NodeOneLinkGeneric getTail() {
		return tail;
	}

	/**
	 * Setter method for the tail pointer
	 * @param tail
	 */
	public void setTail(NodeOneLinkGeneric tail) {
		this.tail = tail;
	}

	/**
	 * Setter method for the "last" pointer
	 * @param last
	 */
	public void setLast(NodeOneLinkGeneric last) {
		this.last = last;
	}

	/**
	 * Setter method for the "first" pointer
	 * @param first
	 */
	public void setFirst(NodeOneLinkGeneric first) {
		this.first = first;
	}
	
	public String toString()
	 {
		NodeOneLinkGeneric temp;
		String tempStr;
		temp = head;
		tempStr="";
		
		while (temp!= null)
		{
			tempStr = tempStr + " "+temp.getData();
			temp = temp.getNext();
		}
		
		return tempStr;
		 
	 }
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	 public static void main(String args[])
	 {

		 SingleLinkedListGeneric <Integer> singleLL = new SingleLinkedListGeneric();
		 SingleLinkedListGeneric <String> testStringList = new SingleLinkedListGeneric<String>();
		 
		 testStringList.addLast("One");
			testStringList.addLast("Two");
			testStringList.addLast("Three");
			testStringList.addLast("Four");
			testStringList.addLast("Five");
			testStringList.addLast("Six");
			
			System.out.println(testStringList);
			
			System.out.println(testStringList.contains("Five"));
		 singleLL.addLast(50);
		 System.out.println(singleLL);
		 
		 singleLL.removeAtIndex(1);
		 System.out.println(singleLL);
		 singleLL.addFirst(1);
		 singleLL.addFirst(2);
		 singleLL.addFirst(3);
		 singleLL.addFirst(4);
		 singleLL.removeFirst();
		 System.out.println(singleLL.getFirst());
		 singleLL.removeFirst();
		 System.out.println(singleLL.getFirst());
		 singleLL.removeFirst();
		 System.out.println(singleLL.getFirst());
		 System.out.println(singleLL);
	 }
}
