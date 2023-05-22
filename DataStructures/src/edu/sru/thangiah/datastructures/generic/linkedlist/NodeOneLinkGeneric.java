package edu.sru.thangiah.datastructures.generic.linkedlist;

/*
 * Seperate class to maintain the structure for a linked list node that only has one link.
 * A next pointer is initialzied so we can easily set the next link in the linked list.
 */

/**
 * <p>Title: NodeOneLinkGeneric</p>
 *
 * <p>Description: </p>
 * BaseOps interface class
 * 
 * Separate class to maintain the structure for a linked list node that only has one link.
 * A next pointer is initialized so we can easily set the next link in the linked list.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class NodeOneLinkGeneric <T> {
	/**
	 * variable for storing the value of a particular node in the linked list
	 */
	private T data;
	/**
	 * Pointer which establishes the next node in the linked list
	 */
	private NodeOneLinkGeneric<T> next;
	
	public NodeOneLinkGeneric(T data)
	{
		this.data = data;
		next = null;
	}
	public NodeOneLinkGeneric(T data, NodeOneLinkGeneric<T> nextElement)
	{
		this.data = data;
		next = nextElement;
	}
	/**
	 * Getter for data variable
	 * @return The data variable
	 */
	public T getData()
	{
		return data;
	}
	/**
	 * Setter for data variable
	 * @param data
	 */
	public void setData(T data){
		this.data = data;		
	}
	/**
	 * Getter for obtaining the value of the next pointer
	 * @return The value of the next pointer
	 */
	public NodeOneLinkGeneric<T> getNext() {
		return next;
	}
	/**
	 * Setter method for intiailizing the next node in the linked list
	 * @param next
	 */
	public void setNext(NodeOneLinkGeneric<T> next)
	{
		this.next = next;
	}
}
