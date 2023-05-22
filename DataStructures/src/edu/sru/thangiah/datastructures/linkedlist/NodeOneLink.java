package edu.sru.thangiah.datastructures.linkedlist;

/*
 * NodeOneLink data structure
 * A node element used in a singlelinkedlist that remembers the nextElement as "next"
 */
/**
 * <p>Title: NodeOneLink/p>
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
public class NodeOneLink {
	/**
	 * variable for storing the value of a particular node in the linked list
	 */
	protected Object data;
	/**
	 * Pointer which establishes the next node in the linked list
	 */
	protected NodeOneLink next;
	
	public NodeOneLink (Object data)
	{
		this.data = data;
		next = null;
	}
	
	public NodeOneLink (Object data, NodeOneLink nextElement)
	{
		this.data = data;
		next = nextElement;
	}
	/**
	 * Getter for obtaining the value of the next pointer
	 * @return The value of the next pointer
	 */
	public NodeOneLink getNext()
    {
        return next;
    }
	/**
	 * Setter method for intiailizing the next node in the linked list
	 * @param next
	 */
	public void setNext(NodeOneLink nextElement)
    {
        next = nextElement;
    }
	/**
	 * Getter for data variable
	 * @return The data variable
	 */
	public Object getData()
    {
        return data;
    }
	/**
	 * Setter for data variable
	 * @param data
	 */
	 public void setData(Object value)
	 {
	        data = value;
	 }
	 
	 public String toString()
	 {
	        return ""+this.getData()+"";
	 }
	 

}
