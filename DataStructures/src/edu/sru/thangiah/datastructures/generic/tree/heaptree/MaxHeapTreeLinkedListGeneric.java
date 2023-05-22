package edu.sru.thangiah.datastructures.generic.tree.heaptree;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.StackArrayGeneric;
import edu.sru.thangiah.datastructures.tree.heaptree.HeapTreeNode;
import edu.sru.thangiah.datastructures.tree.heaptree.MaxHeapTreeLinkedList;

public class MaxHeapTreeLinkedListGeneric<T extends Comparable<T>> extends AbstractHeapTreeGeneric<T> {
	private HeapTreeNodeGeneric<T> root;
	private int count;
	private int searchCount;
	private static final HeapTreeNodeGeneric EMPTY  = new HeapTreeNodeGeneric(null);
	private StackArrayGeneric<HeapTreeNodeGeneric<T>> treeStack;
	private QueueArrayGeneric<HeapTreeNodeGeneric<T>> treeQueue;
	
	MaxHeapTreeLinkedListGeneric()
	{
		root = EMPTY;
		
		count = 0;
		treeStack = new StackArrayGeneric<HeapTreeNodeGeneric<T>>();
		treeQueue = new QueueArrayGeneric<HeapTreeNodeGeneric<T>>();
	}
	/**
	 * Getter method for root pointer variable
	 * @return - The root node in a heap tree
	 */
	public HeapTreeNodeGeneric<T> getRoot()
	{
		return root;
	}
	@Override
	public boolean isEmpty()
	{
		if(root.getData() == null)
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
	public boolean isFull(HeapTreeNodeGeneric<T> treeNode)
	{
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
	@Override
	public int size() {
		return count;
	}
	@Override
	public int nodeCount() {
		return count;
	}
	@Override
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
	public int height(HeapTreeNodeGeneric<T> treeNode)
	{
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
	@Override
	public int degree(HeapTreeNodeGeneric<T> treeNode) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(!treeNode.getLeft().isEmpty() && !treeNode.getRight().isEmpty())
		{
			return 2;
		}
		else if(!treeNode.getRight().isEmpty())
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
	@Override
	public boolean isRoot(HeapTreeNodeGeneric<T> treeNode) {
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
	@Override
	public boolean isParent(HeapTreeNodeGeneric<T> treeNode) {
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
	@Override
	public boolean isChild(HeapTreeNodeGeneric<T> treeNode) {
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
	@Override
	public boolean isLeaf(HeapTreeNodeGeneric<T> treeNode) {
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
	@Override
	public HeapTreeNodeGeneric<T> findLastLeaf() {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode = null;
		
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
	@Override
	public T getLargest() {
		if(!root.equals(EMPTY))
		{
			return root.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	@Override
	public T getSmallest() {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		HeapTreeNodeGeneric<T> min = root;
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData().compareTo(min.getData()) < 0)
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
	@Override
	public HeapTreeNodeGeneric<T> getSecondLargest(HeapTreeNodeGeneric<T> root) {
		if(root.equals(EMPTY) || (root.getLeft().isEmpty() && root.getRight().isEmpty()))
		{
			throw new NoSuchElementException();
		}
		T max = getLargest();
		HeapTreeNodeGeneric<T> secondMax = root.getLeft();
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData().compareTo(secondMax.getData())  > 0 && treeNode.getData() != max)
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
	@Override
	public HeapTreeNodeGeneric<T> getSecondSmallest(HeapTreeNodeGeneric<T> root) {
		if(root.equals(EMPTY) || (root.getLeft().isEmpty() && root.getRight().isEmpty()))
		{
			throw new NoSuchElementException();
		}
		T min = getSmallest();
		HeapTreeNodeGeneric<T> secondMin = root;
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData().compareTo(secondMin.getData()) < 0 && treeNode.getData() != min)
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
	 * Percolates a given node up the heap tree if its value is greater than the parent node
	 * @param treeNode - The node which needs to be heapified into the tree
	 */
	public void heapify(HeapTreeNodeGeneric<T> treeNode)
	{
		T swapNode;
		//keep checking if the parent node is larger than the recently inserted treenode and perform a swap 
		//if the value of the inserted node is larger than the parent.
		while(!isRoot(treeNode) && treeNode.getData().compareTo(treeNode.getParent().getData())> 0)
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
	public void heapifyDown(HeapTreeNodeGeneric<T> treeNode)
	{
		T temp = treeNode.getData();
		HeapTreeNodeGeneric<T> leftNode = treeNode.getLeft();
		HeapTreeNodeGeneric<T> rightNode = treeNode.getRight();
		
		//two children
		if(!leftNode.isEmpty() && !rightNode.isEmpty())
		{
			//right child is larger than left child
			if(rightNode.getData().compareTo(leftNode.getData()) > 0)
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
						if(treeNode.getRight().getData().compareTo(treeNode.getLeft().getData()) > 0 )
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
					else if(!treeNode.getLeft().isEmpty() && treeNode.getLeft().getData().compareTo(treeNode.getData()) > 0)
					{
						//swap the treenode with the left child
						temp = treeNode.getData();
						treeNode.setData(treeNode.getLeft().getData());
						treeNode.getLeft().setData(temp);
						treeNode = treeNode.getLeft();
					}
					//only one right-child which is bigger than the treenode 
					else if(!treeNode.getRight().isEmpty() && treeNode.getRight().getData().compareTo(treeNode.getData()) > 0)
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
			else if(leftNode.getData().compareTo(rightNode.getData()) > 0)
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
						if(treeNode.getRight().getData().compareTo(treeNode.getLeft().getData()) > 0)
						{
							//swap treenode with right child
							temp  = treeNode.getData();
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
					else if(!treeNode.getLeft().isEmpty() && treeNode.getLeft().getData().compareTo(treeNode.getData()) > 0)
					{
						//swap treenode with left child
						temp = treeNode.getData();
						treeNode.setData(treeNode.getLeft().getData());
						treeNode.getLeft().setData(temp);
						treeNode = treeNode.getLeft();
					}
					//one right-child which is larger than the tree node
					else if(!treeNode.getRight().isEmpty() && treeNode.getRight().getData().compareTo(treeNode.getData()) > 0)
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
		else if(treeNode.getLeft().getData().compareTo(treeNode.getData()) > 0)
		{
			temp = treeNode.getData();
			treeNode.setData(treeNode.getLeft().getData());
			treeNode.getLeft().setData(temp);
		}
		//one right child
		else if(treeNode.getRight().getData().compareTo(treeNode.getData()) > 0)
		{
			temp = treeNode.getData();
			treeNode.setData(treeNode.getRight().getData());
			treeNode.getRight().setData(temp);
		}
	}
	@Override
	public boolean add(T value) {
		HeapTreeNodeGeneric<T> newNode = new HeapTreeNodeGeneric<T>(value);
		//uninitialized heap tree, so add node as root
		if(root.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		}
		HeapTreeNodeGeneric<T> nodeExists = search(getRoot(), value);
		//inserting value that already exists
		
			
		if(nodeExists.getData() != value)
		{
			//node is not the root
			HeapTreeNodeGeneric<T> insertLocation = search(root, value);
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
	@Override
	public boolean insert(T value) {
		HeapTreeNodeGeneric<T> newNode = new HeapTreeNodeGeneric<T>(value);
		//uninitialized heap tree, so add node as root
		if(root.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		}
		HeapTreeNodeGeneric<T> nodeExists = search(getRoot(), value);
		//inserting value that already exists
		
			
		if(nodeExists.getData() != value)
		{
			//node is not the root
			HeapTreeNodeGeneric<T> insertLocation = search(root, value);
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
	@Override
	public T remove(T value) {
		if(root.equals(EMPTY)) 
		{
			throw new NoSuchElementException();
		}
		if(!getRoot().isEmpty())
		{
			HeapTreeNodeGeneric<T> nodeExists = locateNode(getRoot(), value);
			if(nodeExists == null)
			{
				throw new IllegalStateException();
			}
		}
		HeapTreeNodeGeneric<T> deleteNode = locateNode(getRoot(), value);
		HeapTreeNodeGeneric<T> lastLeaf = findLastLeaf();
		T returnVal = deleteNode.getData();
		if(deleteNode.getData().compareTo(lastLeaf.getData()) == 0)
		{
			deleteNode.clearNode();
			count--;
			return returnVal;
		}
		if(isLeaf(deleteNode))
		{
			deleteNode.setData(lastLeaf.getData());
			lastLeaf.clearNode();
			count--;
			heapify(deleteNode);
			return returnVal;
		}
		deleteNode.setData(lastLeaf.getData());
		lastLeaf.clearNode();
		count--;
		heapifyDown(deleteNode);
		
		return returnVal;
	}
	@Override
	public HeapTreeNodeGeneric<T> search(HeapTreeNodeGeneric<T> root, T value) {
		
		T rootValue;
		HeapTreeNodeGeneric<T> child = EMPTY;
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
	public HeapTreeNodeGeneric<T> locateNode(HeapTreeNodeGeneric<T> root, T value)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData().compareTo(value) == 0)
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

	@Override
	public boolean contains(T value) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode = null;
		
		while(!treeQueue.isEmpty())
		{
			
			treeNode = treeQueue.deQueue();
			if(treeNode.getData().compareTo(value) == 0)
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

	@Override
	public void inOrder(HeapTreeNodeGeneric<T> root) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//Hitting the root node means we have
		//reached the end of the traversal
		if(root == this.root)
		{
			treeStack.clear();
		}
		//as long as we have not reached the root,
		//push the current node to the stack
		treeStack.push(root.getData());
		
		//check to see if we can go left
		if(!root.getLeft().isEmpty())
		{
			inOrder(root.getLeft());
		}
		
		//allows us to gain the benefit of recursion while
		//outputting to the same line
		System.out.print(treeStack.pop() + " ");
		
		//condition for when there is no
		//left-most node (we go right)
		if(!root.getRight().isEmpty())
		{
			inOrder(root.getRight());
		}
		//reset the stack to be reused for additional method calls
		//treeStack.clear();
		
		
	}
	@Override
	public void preOrder(HeapTreeNodeGeneric<T> root) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeStack.push(root);
		//beginning node to traverse through
		HeapTreeNodeGeneric<T> treeNode = root;
		
		while(!treeStack.isEmpty())
		{
			treeNode = (HeapTreeNodeGeneric<T>) treeStack.pop();
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
	@Override
	public void postOrder(HeapTreeNodeGeneric<T> root) {
		//unitialized bst
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
		
		//visit the leftmost node until traversing right
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
		//treeStack.clear();
		
		
	}
	
	/**
	 * Level order traversal using a queue to store the individual heap tree nodes
	 * Goes level by level until there are no more nodes left.
	 * @param root - The root node of the heap tree
	 */
	public void levelOrder(HeapTreeNodeGeneric<T> root)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode;
		
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
	@Override
	public boolean breadthFirst(HeapTreeNodeGeneric<T> root, T value) {
		//level order traversal to find a max value
		int nodeCount = 0;
		boolean valueFound = false;
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNodeGeneric<T> treeNode;
		
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
			if(value == treeNode.getData())
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
	@Override
	public boolean depthFirst(HeapTreeNodeGeneric<T> root, T value, boolean valueFound) {
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
		T temp = (T)treeStack.pop();
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
	
	public static void main(String[] args)
	{
		MaxHeapTreeLinkedListGeneric<Integer> example = new MaxHeapTreeLinkedListGeneric<Integer>();
		System.out.println(example.isEmpty());
		System.out.println(example.height());
		System.out.println(example.nodeCount());
		example.add(100);
		HeapTreeNodeGeneric<Integer> output = example.search(example.getRoot(), 100);
		System.out.println(output.getData());
		example.add(80);
		example.add(120);
		example.add(90);
		example.add(75);
		example.add(110);
		example.add(130);
		output = example.findLastLeaf();
		System.out.println(output.getData());
		example.inOrder(example.getRoot());
		System.out.println();
		example.preOrder(example.getRoot());
		System.out.println();
		example.postOrder(example.getRoot());
		System.out.println();
		example.levelOrder(example.getRoot());
		System.out.println(example.contains(75));
		example.remove(130);
		example.remove(120);
		example.remove(75);
		example.remove(100);
		example.remove(110);
		example.levelOrder(example.getRoot());
		/*output = example.locateNode(example.getRoot(), 75);
		System.out.println(output.getData());
		System.out.println(example.getSmallest());
		output = example.getSecondLargest(example.getRoot());
		System.out.println(output.getData());
		output = example.getSecondSmallest(example.getRoot());
		System.out.println(output.getData());
		*/
	}
	
	//methods inherited but not used 
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

}
