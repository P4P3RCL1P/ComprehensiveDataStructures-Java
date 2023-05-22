package edu.sru.thangiah.datastructures.linkedlist;

/*
 * NodeTwoLink data structure
 * A node element used in a DoubleLinkedList that remembers the "next" and "prev" nodes of the same type
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
public class NodeTwoLinks {
	/**
	 * Variable for storing the value of the linked list node
	 */
	protected Object data;
	/**
	 * Pointer for setting the previous node in the linked list
	 */
	protected NodeTwoLinks prev;
	/**
	 * pointer for setting the next node in the linked list
	 */
	protected NodeTwoLinks next;
	
	public NodeTwoLinks (Object data)
	{
		this.data = data;
		prev = null;
		next = null;
	}
	
	public NodeTwoLinks (Object data,NodeTwoLinks prevElement, NodeTwoLinks nextElement)
	{
		this.data = data;
		prev = prevElement;
		next = nextElement;
	}
	/**
	 * Getter method for the prev variable
	 * @return The previous node in the linked list
	 */
	public NodeTwoLinks getPrev()
    {
        return prev;
    }
	/**
	 * Getter method for the next variable
	 * @return The next node in the linked list
	 */
	public NodeTwoLinks getNext()
    {
        return next;
    }
	/**
	 * Setter method for the previous variable
	 * @param prevElement
	 */
	public void setPrev(NodeTwoLinks prevElement)
    {
        prev = prevElement;
    }
	/**
	 * Setter method for the next variable
	 * @param prevElement
	 */
	public void setNext(NodeTwoLinks nextElement)
    {
        next = nextElement;
    }
	/**
	 * Getter method for data variable
	 * @return The value of the data variable
	 */
	public Object getData()
    {
        return data;
    }
	/**
	 * setter method for data variable
	 * @param value
	 */
	 public void setData(Object value)
	 {
	        data = value;
	 }
	 /**
	  * Method for concatenating output into a single line
	  * @return The contents of each node in the single linked list all strung in one single-line output 
	  */
	 public String toString()
	 {
	        return "<Node: "+this.getData()+">";
	 }
	 

}
