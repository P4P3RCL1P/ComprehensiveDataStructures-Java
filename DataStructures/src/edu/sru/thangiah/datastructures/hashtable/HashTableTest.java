package edu.sru.thangiah.datastructures.hashtable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;


//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.NoSuchElementException;

//import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class HashTableTest {
	
	//Random rn = new Random();
	private static final int TABLE_SIZE = 30;
	
	
	HashTableArray emptyArHashTable = new HashTableArray();
	HashTableArray initArHashTable = new HashTableArray();
	HashTableArray collisionArHashTable = new HashTableArray();
	
	
	HashTableVector emptyVectHashTable = new HashTableVector();
	HashTableVector initVectHashTable = new HashTableVector();
	HashTableVector collisionVectHashTable = new HashTableVector();
	
	
	HashTableArrayList emptyALHashTable = new HashTableArrayList();
	HashTableArrayList initALHashTable = new HashTableArrayList();
	HashTableArrayList collisionALHashTable = new HashTableArrayList();
	
	/**
	 * Initializes all the hash table implementations
	 * (array, vector, arraylist) with 30 key/value pairs
	 * where the key is in the range of 0-29, and the values
	 * are int the range of 1-30.
	 */
	@BeforeEach
	public void  setUp()
	{
		for(int i = 0; i < TABLE_SIZE; i++)
		{
			//int rand = rn.nextInt();
			initArHashTable.add(i, i+1);
			initVectHashTable.add(i, i+1);
			initALHashTable.add(i, i+1);
		}
	}
	
	/**
	 * Clears all the hash table implementations
	 * to ensure that we are not saving changes from
	 * our tests
	 */
	@AfterEach
	public void tearDown()
	{
		initArHashTable.clear();
		initVectHashTable.clear();
		initALHashTable.clear();
	}
	
	/**
	 * Ensure that the number of key/value pairs
	 * is properly returned using the size method.
	 * 
	 * Tests for initialized hash tables, and empty hash tables
	 */
	@Test
	void testSize() {
		assertEquals(30, initArHashTable.size());
		assertEquals(30, initVectHashTable.size());
		assertEquals(30, initALHashTable.size());
		assertEquals(0, emptyArHashTable.size());
		assertEquals(0, emptyVectHashTable.size());
		assertEquals(0, emptyALHashTable.size());
	}

	/**
	 * Tests for whether isEmpty returns the proper boolean value.
	 * 
	 * Test for initialized hash table (returns false)
	 * Test for empty hash table (returns true)
	 */
	@Test
	void testIsEmpty() {
		assertTrue(emptyArHashTable.isEmpty());
		assertTrue(emptyVectHashTable.isEmpty());
		assertTrue(emptyALHashTable.isEmpty());
		
		assertFalse(initArHashTable.isEmpty());
		assertFalse(initVectHashTable.isEmpty());
		assertFalse(initALHashTable.isEmpty());
	}

	/**
	 * Tests for clear method to make sure size is reset to 0, and that the hash table is empty
	 * 
	 * Test for clearing initialized hash table (should be empty and have no key/value pairs)
	 * 
	 * Test for clearing empty hash table (still should be empty and have no key/value pairs)
	 */
	@Test
	void testClear() {
		initArHashTable.clear();
		assertTrue(initArHashTable.isEmpty());
		assertEquals(0, initArHashTable.size());
		
		initVectHashTable.clear();
		assertTrue(initVectHashTable.isEmpty());
		assertEquals(0, initVectHashTable.size());
		
		initALHashTable.clear();
		assertTrue(initALHashTable.isEmpty());
		assertEquals(0, initALHashTable.size());
		
		emptyArHashTable.clear();
		assertTrue(emptyArHashTable.isEmpty());
		assertEquals(0, emptyArHashTable.size());
	}

	/**
	 * Tests for whether a key/value pair is present in the hash table
	 * 
	 * Test for all initialized key/value pairs in hash tables (returns true)
	 * 
	 * Test for calling method for key/value pair that doesn't exist (returns false)
	 */
	@Test
	void testContains() {
		for(int i = 0; i < TABLE_SIZE; i++)
		{
			assertTrue(initArHashTable.contains(i,i+1));
			assertTrue(initVectHashTable.contains(i,i+1));
			assertTrue(initALHashTable.contains(i,i+1));
		}
		
		assertFalse(emptyArHashTable.contains(10, 12));
		assertFalse(emptyVectHashTable.contains(10, 12));
		assertFalse(emptyALHashTable.contains(10, 12));


	}

	/**
	 * Tests add method to ensure that we are able to properly add to the hash table
	 * 
	 * Test for adding 60 elements to hash table (shouldn't be empty, should have a size of 60,
	 * table size should be 120, and calling contains for all the key/value pairs should return true)
	 */
	@Test
	void testAdd() {
		int testAddSize = 60;
		
		for(int i = 0; i < testAddSize; i++)
		{
			emptyArHashTable.add(i,i+1);
			emptyVectHashTable.add(i,i+1);
			emptyALHashTable.add(i, i+1);
		}
		
		assertFalse(emptyArHashTable.isEmpty());
		assertFalse(emptyVectHashTable.isEmpty());
		assertFalse(emptyALHashTable.isEmpty());
		
		assertEquals(60, emptyArHashTable.size());
		assertEquals(60, emptyVectHashTable.size());
		assertEquals(60, emptyALHashTable.size());
		
		assertEquals(120, emptyArHashTable.tableSize());
		assertEquals(120, emptyVectHashTable.tableSize());
		assertEquals(120, emptyALHashTable.tableSize());
		
		for(int i = 0; i<testAddSize; i++ )
		{
			assertTrue(emptyArHashTable.contains(i,i+1));
			assertTrue(emptyVectHashTable.contains(i,i+1));
			assertTrue(emptyALHashTable.contains(i,i+1));
		}
		
		emptyArHashTable.clear();
		emptyVectHashTable.clear();
		emptyALHashTable.clear();
	}
	
	
	/**
	 * Tests put method to ensure that we are able to properly add to the hash table
	 * 
	 * Test for adding 60 elements to hash table (shouldn't be empty, should have a size of 60,
	 * table size should be 120, and calling contains for all the key/value pairs should return true)
	 */
	@Test
	void testPut() {
		int testAddSize = 60;
		
		for(int i = 0; i < testAddSize; i++)
		{
			emptyArHashTable.put(i,i+1);
			emptyVectHashTable.put(i,i+1);
			emptyALHashTable.put(i, i+1);
		}
		
		assertFalse(emptyArHashTable.isEmpty());
		assertFalse(emptyVectHashTable.isEmpty());
		assertFalse(emptyALHashTable.isEmpty());
		
		assertEquals(60, emptyArHashTable.size());
		assertEquals(60, emptyVectHashTable.size());
		assertEquals(60, emptyALHashTable.size());
		
		assertEquals(120, emptyArHashTable.tableSize());
		assertEquals(120, emptyVectHashTable.tableSize());
		assertEquals(120, emptyALHashTable.tableSize());
		
		for(int i = 0; i<testAddSize; i++ )
		{
			assertTrue(emptyArHashTable.contains(i,i+1));
			assertTrue(emptyVectHashTable.contains(i,i+1));
			assertTrue(emptyALHashTable.contains(i,i+1));
		}
		
		emptyArHashTable.clear();
		emptyVectHashTable.clear();
		emptyALHashTable.clear();
	}

	/**
	 * Tests remove method
	 * 
	 * Test removing from an empty hash table (throws nosuchelement exception)
	 * Test removing all key/value pairs from initialized hash table (should return removed node,
	 * and after all removals initialized hash table should be empty)
	 * Test removing a key/value pair that doesn't exist (throws nosuchelement exception)
	 */
	@Test
	void testRemove() {
		Throwable e = null;
		try {
			emptyArHashTable.remove(10);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		e = null;
		try {
			emptyVectHashTable.remove(10);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
		e = null;
		try {
			emptyALHashTable.remove(10);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);

		HashTableNode output = new HashTableNode();
		for(int i=0; i<TABLE_SIZE; i++)
		{
			output = initArHashTable.remove(i);
			assertEquals(i+1, output.getValue());
			
			output = initVectHashTable.remove(i);
			assertEquals(i+1, output.getValue());
			
			output = initALHashTable.remove(i);
			assertEquals(i+1, output.getValue());
		}
		assertTrue(initArHashTable.isEmpty());
		assertTrue(initVectHashTable.isEmpty());
		assertTrue(initALHashTable.isEmpty());
		
		e = null;
		try {
			initArHashTable.remove(10);
		}catch(Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof NoSuchElementException);
		
	}

	/**
	 * Tests get method
	 * 
	 * Test for getting key that exists (returns value associated with key)
	 * Test for getting key that doesn't exist (returns -1)
	 */
	@Test
	void testGet() {
		for(int i=0; i< TABLE_SIZE; i++)
		{
			assertEquals(i+1, initArHashTable.get(i));
			assertEquals(i+1, initVectHashTable.get(i));
			assertEquals(i+1, initALHashTable.get(i));
		}
		assertEquals(-1, initArHashTable.get("Doesn't exist"));
		assertEquals(-1, initVectHashTable.get("Doesn't exist"));
		assertEquals(-1, initALHashTable.get("Doesn't exist"));
	}

	/**
	 * Tests resize method
	 * 
	 * Test for adding 3/4ths the size of the hash table and then adding one more element
	 * (size should now be 60)
	 */
	@Test
	void testResizeHashTable() {
		initArHashTable.clear();
		initVectHashTable.clear();
		initALHashTable.clear();
		int tableSize = 23;
		for(int i=0; i<tableSize; i++)
		{
			initArHashTable.add(i,i+1);
			initVectHashTable.add(i, i+1);
			initALHashTable.add(i, i+1);
		}
		assertEquals(30, initArHashTable.tableSize());
		initArHashTable.add(24, 25);
		assertEquals(60, initArHashTable.tableSize());

		assertEquals(30, initVectHashTable.tableSize());
		initVectHashTable.add(24, 25);
		assertEquals(60, initVectHashTable.tableSize());
		
		assertEquals(30, initALHashTable.tableSize());
		initALHashTable.add(24, 25);
		assertEquals(60, initALHashTable.tableSize());
	}

}
