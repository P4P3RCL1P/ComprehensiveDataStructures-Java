package edu.sru.thangiah.datastructures.hashtable;

import java.util.NoSuchElementException;

import java.util.Vector;

/**
 * <p>Title: HashTableArray</p>
 *
 * <p>Description: </p>
 * Implementation of hash table using an array. Each index can store a key/value pair
 * which also has a next pointer. This attribute is used to resolve the common issue
 * with hash tables in which two keys can be mapped to the same index. In this instance
 * we employ a separate chaining methodology in which each index in the table acts as a
 * separate linked list to store multiple key/value pairs. If there are two keys which are 
 * hashed into the same index both are stored in the same index, but now the next pointer
 * is used to point to the next key value pair. This ensures that if collisions do occur,
 * they at least won't cause unforeseen issues, and that keys can keep their original hash value.
 *
 * src for separate chaining : Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class HashTableVector extends AbstractHashTable{

	//constant for storing initial size of the hash table 
	//Note that table size is dynamic based on collisions.
	private final int INIT_TABLE_SIZE = 30;
	//Linked list vector for storing hash table key/value pairs
	private Vector<HashTableNode> hashTable;
	//Mutable size variable which is used in the hash function
	int hashTableSize;
	//Count variable for number of key,value pairs
	private int numElements;
	
	//public static final HashTableNode EMPTY = new HashTableNode();
	
	
	
	/**
	 * Default constructor for initializing hash table with default size
	 * and initializing each element as a HashTableNode which has our
	 * next pointer to be used in mapping key value pairs
	 */
	HashTableVector()
	{
		hashTable = new Vector<HashTableNode>(INIT_TABLE_SIZE);
		numElements = 0;
		hashTableSize = INIT_TABLE_SIZE;
		for(int i = 0; i < INIT_TABLE_SIZE; i++)
		{
			hashTable.add(null);
		}
		
	}
	/**
	 * Overloaded constructor for initializing hash table with custom size
	 * and initializing each element as a HashTableNode which has our next
	 * pointer to be used in mapping key value pairs
	 * @param CUSTOM_TABLE_SIZE - A custom value to initialize the size of the hash table
	 */
	HashTableVector(final int CUSTOM_TABLE_SIZE)
	{
		hashTable = new Vector<HashTableNode>(CUSTOM_TABLE_SIZE);
		numElements = 0;
		hashTableSize = CUSTOM_TABLE_SIZE;
		for(int i = 0; i < CUSTOM_TABLE_SIZE; i++)
		{
			hashTable.add(null);
		}
	}
	
	
	/**
	 * Method for hashing large key values
	 * which cannot be used to specify the
	 * index of an array into smaller values
	 * which can directly be used to map the key
	 * to a specific index.
	 * 
	 * Note that the original key is not modified,
	 * instead we use the value of the key to generate
	 * an index.
	 * @param key - The target key which needs to be mapped to an  index in the container.
	 * @return A fixed index which is within the bounds of the size of the array.
	 */
	public int hashFunction(Object key)
	{
		
		/**
		 * index stores the hashed value of the key with respect to the dynamic size of the array
		 * the hashCode() method allows us to hash strings/Objects into integers and then
		 * by using the modulo operator we ensure that we are mapping the result to an
		 * index within the bounds of the current size of the hash table.
		 * 
		 * src: Sedgewick, R., Wayne, K., 2011. Algorithms: Fourth Edition. New York: Addison-Wesley
		 */
		int index = (Math.abs(key.hashCode())) % hashTableSize;
		return index;
		
	}
	
	
	@Override
	public int size() {
		return numElements;
	}

	public int tableSize()
	{
		return hashTableSize;
	}
	
	@Override
	public boolean isEmpty() {
		if(numElements == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean clear() {
		if(!this.isEmpty())
		{
			numElements = 0;
			hashTableSize = INIT_TABLE_SIZE;
			hashTable = new Vector<HashTableNode>(INIT_TABLE_SIZE);
			for(int i=0; i< hashTableSize; i++)
			{
				hashTable.add(null);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object key, int value) {
		int index = hashFunction(key);
		HashTableNode values = hashTable.get(index);
		while(values != null)
		{
			if(values.getValue().equals(value))
			{
				return true;
			}
			values = values.getNext();
			//no more key value pairs for given index.
			if(values == null)
			{
				return false;
			}
			values = values.getNext();
		}
		return false;
	}
	/**
	 * Method for extending the size of the array once the number of 
	 * elements has reached a certain limit (3/4ths the size of the array).
	 * This allows for a more dynamic hash table and ensures that we are
	 * keeping the size of the array large enough to prevent additional
	 * collisions. 
	 */
	public void resizeHashTable()
	{
		hashTableSize = hashTable.size()*2;

		//double hash table for when we reach 3/4ths the size of our size
		Vector<HashTableNode> largerHashTable = new Vector<HashTableNode>(hashTableSize);
		for(int i=0; i<hashTableSize; i++)
		{
			largerHashTable.add(null);
		}
		//Traverse through current hash table
		for (int i= 0; i < hashTable.size(); i++)
		{
			HashTableNode current = hashTable.get(i);
			
			while(current != null)
			{
				//Generate a new index based on the new hash table size (simply doubled from previous size)
				int newIndex = hashFunction(hashTable.get(i).getKey());
				
				largerHashTable.set(newIndex, hashTable.get(i));
				
				current = current.getNext();
			}
		}
		hashTable = largerHashTable;
	}

	@Override
	public boolean add(Object key, int value) {
		int index = hashFunction(key);
		//if(!hashTable.isEmpty())
		HashTableNode current = hashTable.get(index);
		
		//For separate chaining where multiple keys can be chained to the same index
		while(current != null)
		{
			if(current.getKey() == null)
			{
				break;
			}
			//Condition for changing the value for a key
			else if(current.getKey().equals(key))
			{
				hashTable.get(index).setValue(value);
				return true;
			}
			//Collisions occur in hash table, so we add the key value pair as a chain to the current index
			else if(!current.getKey().equals(key))
			{
				HashTableNode insertNode = new HashTableNode();
				insertNode.setKey(key);
				insertNode.setValue(value);
				hashTable.get(index).setNext(insertNode);
				//hashTable[index].setValue(value);
				return true;
			}
			current = current.getNext();
		}
		//Resize the hash table when the number of elements is
		//3/4ths full. In this case we double the array to prevent
		//further collisions.
		if(numElements >= 0.75 * hashTableSize)
		{
			resizeHashTable();
		}
		
		//No collisions so we simply add to index
		HashTableNode insertNode = new HashTableNode();
		insertNode.setKey(key);
		insertNode.setValue(value);
		//insertNode.setNext(hashTable[index]);
		HashTableNode newElement = hashTable.get(index);
		
		hashTable.set(index, insertNode);
		
		
		
		numElements++;
		
		return true;
	}

	@Override
	public boolean put(Object key, int value) {
		int index = hashFunction(key);
		HashTableNode current = hashTable.get(index);
		
		//For separate chaining where multiple keys can be chained to the same index
		while(current != null)
		{
			if(current.getKey() == null)
			{
				break;
			}
			//Condition for changing the value for a key
			else if(current.getKey().equals(key))
			{
				hashTable.get(index).setValue(value);
				return true;
			}
			//Collisions occur in hash table, so we add the key value pair as a chain to the current index
			else if(!current.getKey().equals(key))
			{
				HashTableNode insertNode = new HashTableNode();
				insertNode.setKey(key);
				insertNode.setValue(value);
				hashTable.get(index).setNext(insertNode);
				//hashTable[index].setValue(value);
				return true;
			}
			current = current.getNext();
		}
		//Resize the hash table when the number of elements is
		//3/4ths full. In this case we double the array to prevent
		//further collisions.
		if(numElements >= 0.75 * hashTableSize)
		{
			resizeHashTable();
		}
		
		//No collisions so we simply add to index
		HashTableNode insertNode = new HashTableNode();
		insertNode.setKey(key);
		insertNode.setValue(value);
		//insertNode.setNext(hashTable[index]);
		
		hashTable.set(index, insertNode);
		numElements++;
		
		return true;
	}

	@Override
	public HashTableNode remove(Object key) {
		int deleteIndex = hashFunction(key);
		HashTableNode returnVal;
		//HashTableNode delNode;
		
		//removing an element that doesn't exist
		if(hashTable.get(deleteIndex) == null)
		{
			throw new NoSuchElementException();
		}
		//Find where the key is located:
		//Case 1: Key is first element in the chain
		//Case 2: Key is in the middle between two chains
		else
		{
			//first key in the index is the one to remove
			if(hashTable.get(deleteIndex).getKey() == key)
			{
				//check if there are chained elements
				if(hashTable.get(deleteIndex).getNext() != null)
				{
					returnVal = hashTable.get(deleteIndex);
					hashTable.set(deleteIndex, hashTable.get(deleteIndex).getNext());
					numElements--;
					return returnVal;
				}
				//there are no chains
				else	
				{
					returnVal = hashTable.get(deleteIndex);
					hashTable.set(deleteIndex, null);
					numElements--;
					return returnVal;
				}
			}
			//key is somewhere in the middle or end of the list for the index
			else
			{
				HashTableNode previous = hashTable.get(deleteIndex);
				//Since we've ruled out the first key/value pair initialize the next pointer
				//to the element after the first key/value pair so we can easily
				HashTableNode current = previous.getNext();
				while(current != null)
				{
					//we've found the chain in the given index which is to be removed
					if(current.getKey().equals(key))
					{
						returnVal = current;
						previous.setNext(current.getNext());
						current = null;
						numElements--;
						return returnVal;
						
					}
					current = current.getNext();
				}
			}
		}
		
		return null;
	}

	@Override
	public int get(Object key) {
		int index = hashFunction(key);
		HashTableNode current = hashTable.get(index);
		while(current != null)
		{
			if(current.getKey().equals(key))
			{
				return (int) current.getValue();
			}
			current = current.getNext();
			//no more key value pairs for given index.
			if(current == null)
			{
				return -1;
			}
			current = current.getNext();
		}
		return -1;
	}

	
	public static void main (String[] args)
	{
		HashTableVector table = new HashTableVector();
		System.out.println(table.isEmpty());
		for (int i = 0; i< 25; i++)
		{
			table.add(i,i);
		}
		
		System.out.println(table.contains("no", 70));
		System.out.println(table.get(0));
		
		//table.add(101, 1);
		
	}
}
