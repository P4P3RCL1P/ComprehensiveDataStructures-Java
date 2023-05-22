package edu.sru.thangiah.datastructures.generic.linkedlist;
import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.*;
import edu.sru.thangiah.datastructures.generic.linkedlist.NodeTwoLinksGeneric;
import edu.sru.thangiah.datastructures.linkedlist.DoubleLinkedList;
import edu.sru.thangiah.datastructures.linkedlist.NodeTwoLinks;


/*
 * Double linked list implementation where each node as a previous and next pointer.
 * This helps with traversing both backwards and forwards. Additionally deletions are faster compared to a single linked list
 */

/**
 * <p>Title: DoubleLinkedListGeneric</p>
 *
 * <p>Description: </p>
 *Double linked list implementation where each node as a previous and next pointer.
 * This helps with traversing both backwards and forwards. Additionally deletions are faster compared to a single linked list
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class DoubleLinkedListGeneric <T extends Comparable <T>> extends AbstractDoubleLinkedListGeneric <T>  {

	/**
	 * Head variable points to the beginning of the linked list
	 */
	private NodeTwoLinksGeneric head;
	/**
	 * Tail variable poiunts ot the end of the linked list
	 */
	private NodeTwoLinksGeneric  tail;

	
	DoubleLinkedListGeneric()
	{
		head = new NodeTwoLinksGeneric("Head");
		tail = new NodeTwoLinksGeneric("Tail");
		head.setNext(tail);
		tail.setPrev(head);
	}
	
	//head and tail do not store any values, and shouldn't be counted in the size of the list
	public int size()
	{
		int count = 0;
		NodeTwoLinksGeneric ptr;
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

	public boolean isFull() {
		if (head.getNext() == tail)
		{
			return false;
		}
		return true;
	}
	
	
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
	
	public boolean contains(T value)
	{
		NodeTwoLinksGeneric <T> ptr;
		ptr = head.getNext();
		if(!this.isEmpty())
		{
			while(ptr.getNext() != null)
			{
				if(ptr.getData().compareTo(value) == 0)
				{
					return true;
				}
				ptr = ptr.getNext();
			}
		}
		return false;
	}
	
	public int indexOf(T value)
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		else 
		{	
			int index = 0;
			NodeTwoLinksGeneric<T> ptr;
			ptr = head.getNext();
			while(ptr.getNext() != null)
			{
				index++;
				if(ptr.getData().compareTo(value) == 0)
				{
					return index;
				}
				ptr = ptr.getNext();
			}
		}
		
		return -1;
	}
	
	/*
	public void addNodeFirst(T data)
	{
		NodeTwoLinksGeneric tmp;
		tmp = new NodeTwoLinksGeneric(data);
		tmp.setPrev(head);
		tmp.setNext(head.getNext());
		tmp.getNext().setPrev(tmp);
		head.setNext(tmp);
		tmp=null;	
	}
	
	public Object addNodeLast(Object data)
	{
		NodeTwoLinksGeneric temp;
		temp = new NodeTwoLinksGeneric(data);
		
		//check if empty
		if (isEmpty())
		{
			
			head.setNext(temp);
			temp.setNext(tail);
			tail.setPrev(temp);
			temp.setPrev(head);
			temp=null;
		}
		else
		{
			//temp = new NodeTwoLinks(data, tail, tail.getPrev());	
			tail.getPrev().setNext(temp);
			temp.setPrev(tail.getPrev());
			tail.setPrev(temp);
			temp.setNext(tail);
			temp = null;			
		}
		
		return data;
	}*/
	
	public boolean insertAscend(T data)
	{
	   NodeTwoLinksGeneric newNode = new NodeTwoLinksGeneric(data);
	   NodeTwoLinksGeneric ptr = head.getNext();
	   //If data does not already exist
	   if(head.getNext() != tail)
	   {
	       //get to the correct location
		   T val = (T)ptr.getData();
	       while(val.compareTo(data) == 1 && ptr != tail)
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

	public boolean addFirst (T value)
	{
		boolean returnVal = false;
		NodeTwoLinksGeneric<T> temp;
		temp = new NodeTwoLinksGeneric(value);
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
			temp = new NodeTwoLinksGeneric(value);
			temp.setPrev(head);
			temp.setNext(head.getNext());
			temp.getNext().setPrev(temp);
			head.setNext(temp);
			temp=null;
		}
		return returnVal;
	}
	
	public boolean addLast(T data) //This was boolean, but in non generic we returned data?
	{
		NodeTwoLinksGeneric temp;
		temp = new NodeTwoLinksGeneric(data);
		
		//check if empty
		if (isEmpty())
		{
			
			head.setNext(temp);
			temp.setNext(tail);
			tail.setPrev(temp);
			temp.setPrev(head);
			temp=null;
		}
		else
		{
			//temp = new NodeTwoLinks(data, tail, tail.getPrev());	
			tail.getPrev().setNext(temp);
			temp.setPrev(tail.getPrev());
			tail.setPrev(temp);
			temp.setNext(tail);
			temp = null;			
		}
		
		return true;
	}
	
	public Object getFirst()
	{
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		
		return head.getNext(); //??
	}
	
	//Get the last value in the linked list without removing it 
	public Object getLast()
	{
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		//code needs to be written
		return tail.getPrev(); //? 
	}

	
	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public T removeFirst()
	{
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		
		T data;
		NodeTwoLinksGeneric temp;
		data =  null;
		
		//point to first node to be removed
		temp = head.getNext();
		data = (T) temp.getData();
			
		temp.getNext().setPrev(head);
		head.setNext(temp.getNext());
			
		temp.setNext(null);
		temp.setPrev(null);
		temp=null;
		return data;
	}
	
	public T removeLast()
	{
		if(this.isEmpty())
		{
			//list is empty (exception in java.util.NoSuchElementException)
			throw new NoSuchElementException();
		}
		T data;
		NodeTwoLinksGeneric temp;
		data = null;

		//point to last node to be removed
		temp = tail.getPrev();
		data = (T) temp.getData();			
		temp.getPrev().setNext(tail);
		tail.setPrev(temp.getPrev());
		
		temp.setNext(null);
		temp.setPrev(null);
		temp=null;
		return data;
	}
	
	public T removeData(T data)
	{
		NodeTwoLinksGeneric tmp;
		NodeTwoLinksGeneric deleteNode = new NodeTwoLinksGeneric(data);
		NodeTwoLinksGeneric emptyNode;
		
		emptyNode = new NodeTwoLinksGeneric(-1);
		tmp = head.getNext();

		if (!this.isEmpty()) {
			//locate the node
			while (tmp != this.tail)
			{
				System.out.print(tmp.getData() + ":::" + deleteNode.getData() + "\n");
				T val = (T)tmp.getData();
				if(val.compareTo(data) == 0)
				{
					break;
				}
				tmp = tmp.getNext();
			}
			//if val was not located or the previous node is pointing to the 
			//head buffer node, return emptyNode
			if (tmp == this.tail || tmp.getPrev() == head.getNext()) {
				return (T)emptyNode.getData();
			} 
			else {
				deleteNode = tmp;
				tmp = tmp.getNext();
				tmp.setPrev(deleteNode.getPrev());
				deleteNode.getPrev().setNext(tmp);
				deleteNode.setNext(null);
				deleteNode.setPrev(null);
				return (T)deleteNode.getData();
			}
		}
		else //linked list is empty
		{
			return (T)emptyNode.getData();
		}
	}

	@Override
	public T getAtIndex(int i) {
		if(i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		NodeTwoLinksGeneric<T> ptr;
		ptr = head;
		
		for (int index = 0; index < i; index++) //goes up to the index i
		{
			if(ptr.getNext() == tail)
			{
				throw new NoSuchElementException();
			}
			else
			{
				ptr = ptr.getNext();
			}
		}
		return ptr.getData();
	}

	@Override
	public T setAtIndex(int i, T value) {
		if(i<0)
		{
			throw new IndexOutOfBoundsException();
		}
		NodeTwoLinksGeneric <T> ptr;
		ptr = head;
		for (int index = 0; index < i; index++) //goes up to the index i
		{
			if(ptr.getNext() == tail)
			{
				throw new NoSuchElementException();
			}
			else
			{
				ptr = ptr.getNext();
			}
		}
		ptr.setData(value);
		return value;
	}

	@Override
	//remove the element at the specified index.
	public T removeAtIndex(int i) {
		if(i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		NodeTwoLinksGeneric ptr;
		T nodeData = null;
		ptr = head;
		for (int index = 0; index < i-1; index++) { //go up to the node before i
			if (ptr.getNext() == tail) {
				return null;
			} 
			else 
			{
				ptr = ptr.getNext();
			}
		}
		nodeData = (T)ptr.getNext().getData();
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

	public T addAtIndex(int i, T value) {
		if(i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		NodeTwoLinksGeneric tmp;
		NodeTwoLinksGeneric ptr;
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
			tmp = new NodeTwoLinksGeneric(value);
			tmp.setNext(ptr.getNext());
			tmp.setPrev(ptr);
			ptr.getNext().setPrev(tmp);
			ptr.setNext(tmp);
			ptr = null;
			tmp = null;
			return value;
		} else {
			return null;
		}
	}
	
	public String toString()
	{
		NodeTwoLinksGeneric temp;
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
	
	public Object addTwoNodes(T data)
	{
		NodeTwoLinksGeneric tmp;
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
	public Object delPrev(T val) {
		NodeTwoLinksGeneric tmp;
		NodeTwoLinksGeneric deleteNode = new NodeTwoLinksGeneric(val);
		NodeTwoLinksGeneric emptyNode;
		
		emptyNode = new NodeTwoLinksGeneric(-1);
		tmp = head.getNext();

		if (!this.isEmpty()) {
			//locate the node
			while (tmp != this.tail)
			{
				System.out.print(tmp.getData() + ":::" + deleteNode.getData() + "\n");
				T data = (T)tmp.getData();
				if(val.compareTo(data) == 0)
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
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String[] args) {
		
		DoubleLinkedListGeneric doubleLL = new DoubleLinkedListGeneric();		 
		 doubleLL.insertAscend(5);
		 doubleLL.insertAscend(10);
		 doubleLL.insertAscend(15);
		 System.out.println(doubleLL.getFirst());
		 System.out.println(doubleLL.getLast());
		 doubleLL.getFirst();
		 doubleLL.getLast();
		 doubleLL.addFirst(5);
		 doubleLL.addLast("string");
		 System.out.println(doubleLL.getFirst());
		 System.out.println(doubleLL.getLast());
		 doubleLL.getFirst();
		 doubleLL.getLast();
		 System.out.println(doubleLL);
		 doubleLL.removeLast();
		 doubleLL.removeFirst();
		 System.out.println(doubleLL);
		 
	}
}
