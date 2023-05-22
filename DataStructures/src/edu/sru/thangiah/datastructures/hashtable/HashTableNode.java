package edu.sru.thangiah.datastructures.hashtable;

/**
 * Helper program for establishing the links between data items in a hash table. The hash table
 * implementation includes a list of HashTableNodes, so that each element in the list represents a
 * linked list structure where there can be more than one value to a given key.
 * @author Sam R. Thangiah
 *
 */
public class HashTableNode {
	private Object key;
	private Object value;
	private HashTableNode next;
	
	HashTableNode()
	{
		setKey(null);
		setValue(-1);
		setNext(null);
	}
	HashTableNode(Object key, Object value , HashTableNode next)
	{
		setKey(key);
		setValue(value);
		setNext(next);
	}

	/**
	 * Getter method for key attribute for any given data item in the table
	 * @return - The key for a given data item in the table
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * Setter method for key attribute for any given data item in the table
	 * @param key - The key value to attribute with the data item in the table
	 */
	public void setKey(Object key) {
		this.key = key;
	}

	/**
	 * Getter method for the value attribute for any given data item in the table
	 * @return The value for a given data item in the table
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * Setter method for the value attribute for any given data item in the table
	 * @param value - The value attributed with the data item
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Getter method for the next pointer
	 * @return The next data item in the table
	 */
	public HashTableNode getNext() {
		return next;
	}

	/**
	 * Sets the next pointer for a given data item in the table
	 * @param next - The next hash table node to 
	 */
	public void setNext(HashTableNode next) {
		this.next = next;
	}
}
