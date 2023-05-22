package edu.sru.thangiah.sorting;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.stack.StackArray;
import edu.sru.thangiah.datastructures.tree.heaptree.HeapTreeNode;
import edu.sru.thangiah.datastructures.tree.heaptree.MaxHeapTreeLinkedList;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Heap Sort implementation using heap trees
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class HeapSortLinkedList {

	private HeapTreeNode root;
	
	private int count;
	
	private int searchCount;
	
	private static final HeapTreeNode EMPTY = new HeapTreeNode(-1);
	
	private StackArray treeStack;
	
	private QueueArrayGeneric<HeapTreeNode> treeQueue;
	
	public HeapSortLinkedList()
	{
		root = EMPTY;
		
		count = 0; 
		treeStack = new StackArray();
		treeQueue = new QueueArrayGeneric<HeapTreeNode>();
	}
	
	/**
	 * Getter method for root pointer variable
	 * @return The root node in a tree
	 */
	public HeapTreeNode getRoot()
	{
		return root;
	}

	public boolean isEmpty() {
		if(root.getData() == -1)
		{
			return true;
		}
		return false;
	}
	/**
	 * Returns true if the tree is full (all nodes other than leaves have two children)
	 * @param treeNode - The node to be tested for the condition
	 * @return True if all the nodes other than leaf nodes have two children
	 */
	public boolean isFull(HeapTreeNode treeNode) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(treeNode.getLeft().isEmpty() && treeNode.getRight().isEmpty())
		{
			return true;
		}
		if(!treeNode.getLeft().isEmpty() && !treeNode.getRight().isEmpty())
		{
			return(isFull(treeNode.getLeft()) && isFull(treeNode.getRight()));
		}
		return false;
	}


	public int size() {
		return count;
	}
	

	public int nodeCount() {
		return count;
	}


	public boolean clear() {
		root.clearNode();
		count = 0; 
		return true;
	}


	/**
	 * Returns the height of the heap tree as an integer
	 * @param treeNode - The starting node for counting the height
	 * @return - An integer count of the height of the tree
	 */
	public int height(HeapTreeNode treeNode) {
		if(treeNode.isEmpty())
		{
			return 0;
		}
		//we can use recursion to find the maximum depth
		//of a binary tree. We use the Math.max method
		//which parses the leftmost/rightmost nodes
		//src: Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
		//int maxDepth = 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
				
		return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
	}


	public int degree(HeapTreeNode treeNode) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(!treeNode.getLeft().isEmpty() && !treeNode.getRight().isEmpty())
		{
			return 2;
		}
		else if (!treeNode.getRight().isEmpty())
		{
			return 1;
		}
		else if (!treeNode.getLeft().isEmpty())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public boolean isRoot(HeapTreeNode treeNode) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(treeNode.getParent().isEmpty())
		{
			return true;
		}
		return false;
	}

	public boolean isParent(HeapTreeNode treeNode) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(!treeNode.getLeft().isEmpty() || !treeNode.getRight().isEmpty())
		{
			return true;
		}
		return false;
	}


	public boolean isChild(HeapTreeNode treeNode) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(!treeNode.getParent().isEMPTY())
		{
			return true;
		}
		return false;
	}


	public boolean isLeaf(HeapTreeNode treeNode) {
		if(root.equals(EMPTY) || treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(treeNode.getRight().isEmpty() && treeNode.getLeft().isEmpty())
		{
			return true;
		}
		return false;
	}


	public HeapTreeNode findLastLeaf() {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNode treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
		}
		treeQueue.clear();
		return treeNode;
	}

	/**
	 * Percolates a given node up the heap tree if it's value is greater than the parent node
	 * @param treeNode - The node which needs to be heapified into the tree
	 */
	public void heapify(HeapTreeNode treeNode)
	{
		int swapNode;
		//keep checking if the parent node is larger than the recently inserted treenode and perform a swap 
		//if the value of the inserted node is larger than the parent.
		while(!isRoot(treeNode) && treeNode.getData() > treeNode.getParent().getData())
		{
			swapNode = treeNode.getParent().getData();
			treeNode.getParent().setData(treeNode.getData());
			treeNode.setData(swapNode);
			
			treeNode = treeNode.getParent();
		}
	}
	/**
	 * Takes a node as input and percolates the node down the heap tree if the value of the left/right child is greater than the given node
	 * Note this is mostly used when calling the remove(int value) method.
	 * @param treeNode - The node to be re-heapified into the heap tree.
	 */
	public void heapifyDown(HeapTreeNode treeNode)
	{
		int temp = treeNode.getData(); //placeholder variable
		HeapTreeNode leftNode = treeNode.getLeft(); //for readability we set leftNode and rightNode to the left and right attributes of deleteNode
		HeapTreeNode rightNode = treeNode.getRight();
		
		//two children
		if(!leftNode.isEmpty() && !rightNode.isEmpty())
		{
			//right child is larger than left child
			if(rightNode.getData() > leftNode.getData())
			{
				//swap the treenode with the right child
				treeNode.setData(rightNode.getData());
				rightNode.setData(temp);
				treeNode = treeNode.getRight();
				//keep navigating through the heap tree until there are no further nodes left
				while(!treeNode.isEmpty())
				{
					//two children
					if(!treeNode.getRight().isEmpty() && !treeNode.getLeft().isEmpty())
					{
						//right child is larger than left child
						if(treeNode.getRight().getData() > treeNode.getLeft().getData())
						{
							//swap the treenode with the right child
							temp = treeNode.getData();
							treeNode.setData(treeNode.getRight().getData());
							treeNode.getRight().setData(temp);
							treeNode = treeNode.getRight();
						}
						else
						{
							//swap the treenode with the left child
							temp = treeNode.getData();
							treeNode.setData(treeNode.getLeft().getData());
							treeNode.getLeft().setData(temp);
							treeNode = treeNode.getLeft();
						}
					}
					//only one left-child which is bigger than the treenode
					else if(!treeNode.getLeft().isEmpty() && treeNode.getLeft().getData() > treeNode.getData())
					{
						//swap the treenode with the left child
						temp = treeNode.getData();
						treeNode.setData(treeNode.getLeft().getData());
						treeNode.getLeft().setData(temp);
						treeNode = treeNode.getLeft();
					}
					//only one right-child which is bigger than the treenode 
					else if(!treeNode.getRight().isEmpty() && treeNode.getRight().getData() > treeNode.getData())
					{
						//swap the treenode with the right child
						temp = treeNode.getData();
						treeNode.setData(treeNode.getRight().getData());
						treeNode.getRight().setData(temp);
						treeNode = treeNode.getRight();
					}
					//no children left, so we exit the loop
					else
					{
						break;
					}
				}
			}
			//left child is larger than right child
			else if(leftNode.getData() > rightNode.getData())
			{
				//swap the tree node with the left child
				treeNode.setData(leftNode.getData());
				leftNode.setData(temp);
				treeNode = treeNode.getLeft();
				//keep navigating through the tree until there are no nodes left
				while(!treeNode.isEmpty())
				{
					//two children
					if(!treeNode.getRight().isEmpty() && !treeNode.getLeft().isEmpty())
					{
						//right node is larger than left node
						if(treeNode.getRight().getData() > treeNode.getLeft().getData())
						{
							//swap treenode with right child
							temp = treeNode.getData();
							treeNode.setData(treeNode.getRight().getData());
							treeNode.getRight().setData(temp);
							treeNode = treeNode.getRight();
						}
						else
						{
							//swap treenode with left child
							temp = treeNode.getData();
							treeNode.setData(treeNode.getLeft().getData());
							treeNode.getLeft().setData(temp);
							treeNode = treeNode.getLeft();
						}
					}
					//one left-child which is larger than the tree node
					else if(!treeNode.getLeft().isEmpty() && treeNode.getLeft().getData() > treeNode.getData())
					{
						//swap treenode with left child
						temp = treeNode.getData();
						treeNode.setData(treeNode.getLeft().getData());
						treeNode.getLeft().setData(temp);
						treeNode = treeNode.getLeft();
					}
					//one right-child which is larger than the tree node
					else if(!treeNode.getRight().isEmpty() && treeNode.getRight().getData() > treeNode.getData() )
					{
						//swap treenode with right child
						temp = treeNode.getData();
						treeNode.setData(treeNode.getRight().getData());
						treeNode.getRight().setData(temp);
						treeNode = treeNode.getRight();
					}
					else
					{
						return;
					}
				}
			}
			//no more children, so break the loop
			else
			{
				return;
			}
		}
		//one left child
		else if(treeNode.getLeft().getData() > treeNode.getData())
		{
			temp = treeNode.getData();
			treeNode.setData(treeNode.getLeft().getData());
			treeNode.getLeft().setData(temp);
		}
		//one right child
		else if(treeNode.getRight().getData() > treeNode.getData())
		{
			temp = treeNode.getData();
			treeNode.setData(treeNode.getRight().getData());
			treeNode.getRight().setData(temp);
			
		}
	}

	public boolean add(int value) {
		HeapTreeNode newNode = new HeapTreeNode(value);
		//uninitialized heap tree, so add node as root
		if(root.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		}
		HeapTreeNode nodeExists = search(getRoot(), value);
		//inserting value that already exists
		
			
		if(nodeExists.getData() != value)
		{
			//node is not the root
			HeapTreeNode insertLocation = search(root, value);
			if(insertLocation.getLeft().isEmpty())
			{
				insertLocation.setLeft(newNode);
			}
			else if(insertLocation.getRight().isEmpty())
			{
				insertLocation.setRight(newNode);
			}
			else
			{
				insertLocation.setRight(newNode);
			}
				
			newNode.setParent(insertLocation);
			heapify(newNode);
			count++;
			
			return true;
		}
		return false;
	}
	
	public void insert(int value) {
		HeapTreeNode newNode = new HeapTreeNode(value);
		//uninitialized heap tree, so add node as root
		if(root.isEmpty())
		{
			root = newNode;
			count++;
		}
		HeapTreeNode nodeExists = search(getRoot(), value);
		//inserting value that already exists
		
			
		if(nodeExists.getData() != value)
		{
			//node is not the root
			HeapTreeNode insertLocation = search(root, value);
			if(insertLocation.getLeft().isEmpty())
			{
				insertLocation.setLeft(newNode);
			}
			else if(insertLocation.getRight().isEmpty())
			{
				insertLocation.setRight(newNode);
			}
			else
			{
				insertLocation.setRight(newNode);
			}
				
			newNode.setParent(insertLocation);
			heapify(newNode);
			count++;
			
		}
	}


	public int getLargest() {
		if(!root.equals(EMPTY))
		{
			return root.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}


	public int getSmallest() {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		HeapTreeNode min = root;
		treeQueue.enQueue(root);
		HeapTreeNode treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData() < min.getData())
			{
				min = treeNode;
			}
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
		}
		treeQueue.clear();
		return min.getData();
	}
	

	public HeapTreeNode getSecondLargest(HeapTreeNode root) {
		if(root.equals(EMPTY) || (root.getLeft().isEmpty() && root.getRight().isEmpty()))
		{
			throw new NoSuchElementException();
		}
		int max = getLargest();
		HeapTreeNode secondMax = root.getLeft();
		treeQueue.enQueue(root);
		HeapTreeNode treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData() > secondMax.getData() && treeNode.getData() != max)
			{
				secondMax = treeNode;
			}
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
		}
		treeQueue.clear();
		return secondMax;
	}


	public HeapTreeNode getSecondSmallest(HeapTreeNode root) {
		if(root.equals(EMPTY) || (root.getLeft().isEmpty() && root.getRight().isEmpty()))
		{
			throw new NoSuchElementException();
		}
		int min = getSmallest();
		HeapTreeNode secondMin = root;
		treeQueue.enQueue(root);
		HeapTreeNode treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData() < secondMin.getData() && treeNode.getData() != min)
			{
				secondMin = treeNode;
			}
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
		}
		treeQueue.clear();
		return secondMin;
	}
	
	/**
	 * Remove a node from the heap tree w/ the specified value.
	 * Maintains the rules of a max heap tree after removing the node by re-heapifying all the nodes as necessary
	 * @param value - The node with the specified value to be removed
	 * @return The value of the node removed (upon successful completion of the method)
	 */

	public int remove(int value) {
		//removing from an empty/uninitialized tree
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//Check to see if the value exists in the tree
		if(!getRoot().isEmpty())
		{
			HeapTreeNode nodeExists = locateNode(getRoot(), value);
			if(nodeExists == null)
			{
				throw new IllegalStateException();
			}
		}
		//node to be deleted
		HeapTreeNode deleteNode = locateNode(getRoot(), value);
		//last leaf in the tree (will act as our replacement for the deleted node)
		HeapTreeNode lastLeaf = findLastLeaf();
		//for returning the value of the node deleted
		int returnVal = deleteNode.getData();
		//case for when the node to be deleted is the last leaf
		if(deleteNode == lastLeaf)
		{
			deleteNode.clearNode();
			count--;
			return returnVal;
		}
		
		//case for when the node deleted is a leaf node
		if(isLeaf(deleteNode))
		{
			deleteNode.setData(lastLeaf.getData());
			lastLeaf.clearNode();
			count--;
			heapify(deleteNode);
			return returnVal;
		}
		//base case for one deleteNode being a child in the tree (not a leaf node)
		deleteNode.setData(lastLeaf.getData());
		lastLeaf.clearNode();
		count--;
		heapifyDown(deleteNode);
		
		return returnVal;
	}


	public HeapTreeNode search(HeapTreeNode root, int value) {
		int rootValue;
		HeapTreeNode child = EMPTY;
		rootValue = root.getData();
		
		//value found at root
		if(rootValue == value)
		{
			return root;
		}
	
		
		//both children are initialized
		if(!root.getLeft().isEmpty() && !root.getRight().isEmpty())
		{
			//left sub-tree is full
			if(degree(root.getLeft()) == 2 && degree(root.getRight()) != 2)
			{
				child = root.getRight();
			}
			else
			{
				child = root.getLeft();
			}
		}
		else
		{
			child = root.getRight();
		}

		
		//no child there: not in tree, return this node,
		//else keep searching
		if(child.isEmpty())
		{
			//after looking through right subtree & value is still in tree look through left-subtree
			if(contains(value) == true && !this.root.equals(EMPTY))
			{
				if(!this.root.getLeft().isEmpty())
				{
					return search(this.root.getLeft(), value);
				}
			}
			return root;
		}
		else
		{
			return search(child, value);
		}
	}


	/**
	 * Searches for a specifed value within the heap tree, and returns the heap tree node if it is found
	 * @param root - The root node of the heap tree
	 * @param value - The value to search for
	 * @return The heap tree node if it is found
	 */
	public HeapTreeNode locateNode(HeapTreeNode root, int value)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNode treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			//value found
			if(treeNode.getData() == value)
			{
				treeQueue.clear();
				return treeNode;
			}
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
		}
		treeQueue.clear();
		return null;
	}

	public boolean contains(int value) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNode treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData() == value)
			{
				return true;
			}
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
		}
		treeQueue.clear();
		return false;
	}


	public void inOrder(HeapTreeNode root) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//Hitting the root node means we have
		//reached the end of the traversal
		if(this.root == root)
		{
			treeStack.clear();
		}
		//as long as we have not reached the root,
		//push the current node to the stack
		treeStack.push(root.getData());
		if(!root.getLeft().isEmpty())
		{
			inOrder(root.getLeft());
		}
		//single-line output using print
		System.out.print(treeStack.pop() + " ");
		
		//condition for when there is no left-most node (we go right)
		if(!root.getRight().isEmpty())
		{
			inOrder(root.getRight());
		}
		treeStack.clear();
	}


	public void preOrder(HeapTreeNode root) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeStack.push(root);
		//beginning node to traverse through
		HeapTreeNode treeNode = root;
		
		while(!treeStack.isEmpty())
		{
			treeNode = (HeapTreeNode) treeStack.pop();
			System.out.print(treeNode.getData() + " ");
			
			//reach the right-most node before navigating left
			if(!treeNode.getRight().isEmpty())
			{
				treeStack.push(treeNode.getRight());
			}
			if(!treeNode.getLeft().isEmpty())
			{
				treeStack.push(treeNode.getLeft());
			}
		}
		treeStack.clear();
	}


	public void postOrder(HeapTreeNode root) {
		//uninitaizlied bst
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//we've reached the end of our traversal and we need to
		//uninitialize the stack to free up memory
		if(root == this.root)
		{
			treeStack.clear();
		}
		//push the current node to the stack
		treeStack.push(root.getData());
		
		//visit the leftmostNode until traversing right
		if(!root.getLeft().isEmpty())
		{
			postOrder(root.getLeft());
		}
		//traverse right after visiting leftmost node
		if(!root.getRight().isEmpty())
		{
			postOrder(root.getRight());
		}
		System.out.print(treeStack.pop() + " ");
		treeStack.clear();
		
	}
	
	/**
	 * Level order traversal using a queue to store the individual heap tree nodes
	 * Goes level by level until there are no more nodes left.
	 * @param root - The root node of the heap tree
	 */
	public void levelOrder(HeapTreeNode root)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNode treeNode;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
			System.out.print(treeNode.getData() + " ");
		}

		treeQueue.clear();
	}


	public boolean breadthFirst(HeapTreeNode root, int val)
	{
		//level order traversal to find a max value
		int nodeCount = 0;
		boolean valueFound = false;
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNode treeNode;
		
		while(!treeQueue.isEmpty())
		{
			nodeCount++;
			treeNode = treeQueue.deQueue();
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				treeQueue.enQueue(treeNode.getLeft());
			}
			if(!treeNode.getRight().isEmpty())
			{
				treeQueue.enQueue(treeNode.getRight());
			}
			if(val == treeNode.getData())
			{
				valueFound = true;
				System.out.print(treeNode.getData() + " ");
				System.out.println("Value Found, Nodes Searched = " + nodeCount);
				return valueFound;
			}
			System.out.print(treeNode.getData() + " ");
		}

		treeQueue.clear();
		System.out.print("\n");
		System.out.println("Value not found");
		return valueFound;
	}
	

	public boolean depthFirst(HeapTreeNode root, int value, boolean valueFound)
	{
		//in-order traversal to find a max value
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//Hitting the root node means we have
		//reached the end of the traversal
		if(this.root == root)
		{
			treeStack.clear();
		}
		
		//as long as we have not reached the root,
		//push the current node to the stack
		treeStack.push(root.getData());
		if(!root.getLeft().isEmpty() && valueFound == false)
		{
			//if the recursion layer returns true, relay to initial call
			if(depthFirst(root.getLeft(), value, valueFound) == true)
			{
				return true;
			}
		}
		int temp = (int)treeStack.pop();
		searchCount++;
		//checks to see if node value matches search value
		if(temp == value)
		{
			valueFound = true;
			System.out.println("Value Found, Nodes Searched = " + searchCount);
			treeStack.clear();
			return valueFound;
		} //if not found, and end of tree, then return false
		else if(valueFound == false && searchCount == count)
		{
			System.out.println("Value Not Found");
			return valueFound;
		}
		
		//condition for when there is no
		//left-most node (we go right)
		if(!root.getRight().isEmpty() && valueFound == false)
		{
			//if the recursion layer returns true, relay to initial call
			if(depthFirst(root.getRight(), value, valueFound) == true)
			{
				return true;
			}
		}
		treeStack.clear();
		return valueFound;
	}
	
	public void printHeapSort(HeapSortLinkedList heapTree)
	{
		if(this.root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		HeapSortLinkedList temp = heapTree;
		HeapTreeNode root = temp.getRoot();

		while(temp.size() != 0)
		{
		   System.out.print(temp.remove(root.getData()) + " ");
			root = temp.getRoot();
			
		}
		
	}
	public static void main (String[] args)
	{
		//compute time to execute
		long before, after, total;
		System.out.println("Executing Bubble Sort");
		HeapSortLinkedList example = new HeapSortLinkedList();
		
		example.insert(80);
		example.insert(120);
		example.insert(90);
		example.insert(75);
		example.insert(110);
		example.insert(130);
		System.out.println("Array before sorting: ");
		example.levelOrder(example.getRoot());
		System.out.println();
		before = System.currentTimeMillis();
		System.out.println("Array after sorting: ");
		example.printHeapSort(example);
		System.out.println();
		after = System.currentTimeMillis();
		total = after - before;
        System.out.println("Before time: " + before + " milliseconds");
        System.out.println("After time: " + after + " milliseconds");
        System.out.println("Total time to execute: " + total + " milliseconds");
		
	
		
	}
}
