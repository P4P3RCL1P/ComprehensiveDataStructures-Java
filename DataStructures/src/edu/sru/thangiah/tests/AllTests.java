package edu.sru.thangiah.tests;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


/**
 * All seperate JUnit classes imported here
 */
import edu.sru.thangiah.datastructures.generic.linkedlist.DoubleLinkedListGenericTest;
import edu.sru.thangiah.datastructures.generic.linkedlist.SingleLinkedListGenericTest;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGenericTest;
import edu.sru.thangiah.datastructures.generic.queue.QueueLinkedListGenericTest;
import edu.sru.thangiah.datastructures.generic.stack.StackArrayGenericTest;
import edu.sru.thangiah.datastructures.generic.stack.StackLinkedListGenericTest;
import edu.sru.thangiah.datastructures.generic.tree.avltree.AvlTreeGenericTest;
import edu.sru.thangiah.datastructures.generic.tree.binarytree.BinarySearchTreeGenericTest;
import edu.sru.thangiah.datastructures.generic.tree.heaptree.MaxHeapTreeGenericTest;
import edu.sru.thangiah.datastructures.generic.tree.redblacktree.RedBlackTreeGenericTest;
import edu.sru.thangiah.datastructures.graph.GraphClassTest;
import edu.sru.thangiah.datastructures.hashtable.HashTableTest;
import edu.sru.thangiah.datastructures.linkedlist.DoubleLinkedListTest;
import edu.sru.thangiah.datastructures.linkedlist.SingleLinkedListTest;
import edu.sru.thangiah.datastructures.queue.QueueArrayTest;
import edu.sru.thangiah.datastructures.queue.QueueLinkedListTest;
import edu.sru.thangiah.datastructures.stack.StackArray;
import edu.sru.thangiah.datastructures.stack.StackArrayTest;
import edu.sru.thangiah.datastructures.stack.StackLinkedList;
import edu.sru.thangiah.datastructures.stack.StackLinkedListTest;
import edu.sru.thangiah.datastructures.tree.binarytree.BinarySearchTree;
import edu.sru.thangiah.datastructures.tree.generaltree.GeneralTreeTest;
import edu.sru.thangiah.datastructures.tree.heaptree.MaxHeapTreeTest;
import edu.sru.thangiah.datastructures.tree.redblacktree.RedBlackTreeTest;



/**
 * <p>Title: AllTests</p>
 *
 * <p>Description: </p>
 * A comprehensive JUnit suite containing all the data structures tests. This is the one-stop overview of all the test classes written
 *so that users/developers can gain an overview of the status of certain JUnit tests for a specific data structure implementation.
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
@Suite
@SelectClasses({DoubleLinkedListGenericTest.class,
			   SingleLinkedListGenericTest.class,
			   QueueArrayGenericTest.class,
			   QueueLinkedListGenericTest.class,
			   StackArrayGenericTest.class,
			   StackLinkedListGenericTest.class,
			   AvlTreeGenericTest.class,
			   BinarySearchTreeGenericTest.class,
			   MaxHeapTreeGenericTest.class,
			   RedBlackTreeGenericTest.class,
			   GraphClassTest.class,
			   HashTableTest.class,
			   DoubleLinkedListTest.class,
			   SingleLinkedListTest.class,
			   QueueArrayTest.class,
			   QueueLinkedListTest.class,
			   StackArrayTest.class,
			   StackLinkedListTest.class,
			   BinarySearchTree.class,
			   GeneralTreeTest.class,
			   MaxHeapTreeTest.class,
			   RedBlackTreeTest.class
			   })
public class AllTests {
}
