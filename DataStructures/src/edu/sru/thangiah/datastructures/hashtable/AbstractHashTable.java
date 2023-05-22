package edu.sru.thangiah.datastructures.hashtable;
import edu.sru.thangiah.datastructures.ListOpsInt;

/**
 * Abstract class to layout the method framework for any hash table implementations. Users can call
 * size, isEmpty, clear, contains, add(similar to put), remove, and get all of which aid to the
 * demonstration of the data structure.
 * @author Sam R. Thangiah
 *
 */
public abstract class AbstractHashTable implements ListOpsInt {

	@Override
	public abstract int size();

	@Override
	public abstract boolean isEmpty();


	@Override
	public abstract boolean clear();
	
	/**
	 * Returns true if a given item is contained with the following key parameter in the hash table
	 * @param key - The key associated with the data item in the hash table
	 * @param value - The value associated with the key
	 * @return True if the value is found in the hash table
	 */
	public abstract boolean contains(Object key, int value);
	
	/**
	 * Adds an element to the hash table based the key parameter.
	 * @param key - The key associated with the item to add to the hash table
	 * @param value - The value to add to the hash table
	 * @return True upon successful completion of method
	 */
	public abstract boolean add(Object key, int value);
	
	/**
	 * Adds an element to the hash table based the key parameter.
	 * @param key - The key associated with the item to add to the hash table
	 * @param value - The value to add to the hash table
	 * @return True upon successful completion of method
	 */
	public abstract boolean put(Object key, int value);
	
	/**
	 * Removes data item specified under a given key.
	 * @param key - The key to search for and then remove
	 * @return The hash table node associated with
	 */
	public abstract HashTableNode remove(Object key);
	
	/**
	 * Get the value associated with the given key in the hash table.
	 * @param key - The key to search for in the hash table which we will then use to return the data contained in that key
	 * @return The value of the data associated with the key parameter.
	 */
	public abstract int get(Object key);

	

	
	
	
	
	//Methods inherited but not used
	@Override
	public boolean add(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addFirst(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLast(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(int value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeFirst() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeLast() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getAtIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setAtIndex(int i, int value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAtIndex(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addAtIndex(int i, int value) {
		// TODO Auto-generated method stub
		return 0;
	}
}
