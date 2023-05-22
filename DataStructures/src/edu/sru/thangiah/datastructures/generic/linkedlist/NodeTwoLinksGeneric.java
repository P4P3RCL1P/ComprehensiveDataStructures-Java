package edu.sru.thangiah.datastructures.generic.linkedlist;

/*
 * Seperate class to maintain the structure for a linked list node that only has two links.
 * A next and previous pointer is initialzied so we can easily set the next link in the linked list.
 */

/**
 * <p>Title: NodeTwoLinksGeneric</p>
 *
 * <p>Description: </p>
 * BaseOps interface class
 * 
 * Separate class to maintain the structure for a linked list node that only has two links.
 * A next and previous pointer is initialized so we can easily set the next link in the linked list.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class NodeTwoLinksGeneric<T> {
	/**
	 * Variable for storing the value of the linked list node
	 */
	protected T data;
	/**
	 * Pointer for setting the previous node in the linked list
	 */
	protected NodeTwoLinksGeneric<T> prev;
	/**
	 * pointer for setting the next node in the linked list
	 */
	protected NodeTwoLinksGeneric<T> next;
	
	public NodeTwoLinksGeneric(T data)
	{
		this.data = data;
		prev = null;
		next = null;
	}
	public NodeTwoLinksGeneric (T data, NodeTwoLinksGeneric<T> prevElement, NodeTwoLinksGeneric<T> nextElement)
	{
		this.data = data;
		prev = prevElement;
		next = nextElement;
	}
	/**
	 * Getter method for the prev variable
	 * @return The previous node in the linked list
	 */
	public NodeTwoLinksGeneric<T> getPrev()
	{
		return prev;
	}
	/**
	 * Getter method for the next variable
	 * @return The next node in the linked list
	 */
	public NodeTwoLinksGeneric<T> getNext()
	{
		return next;
	}
	/**
	 * Setter method for the previous variable
	 * @param prevElement
	 */
	public void setPrev(NodeTwoLinksGeneric<T> prevElement)
	{
		prev = prevElement;
	}
	/**
	 * Setter method for the next variable
	 * @param prevElement
	 */
	public void setNext(NodeTwoLinksGeneric<T> nextElement)
	{
		next = nextElement;
	}
	/**
	 * Getter method for data variable
	 * @return The value of the data variable
	 */
	public T getData()
	{
		return data;
	}
	/**
	 * setter method for data variable
	 * @param value
	 */
	public void setData(T value)
	{
		data = value;
	}
	/**
	 * Method for concatenating output into a single line
	 * @return The contents of each node in the single linked list all strung in one single-line output 
	 */
	public String toString()
	{
		return "<Node: " +this.getData() + ">";
	}
}
