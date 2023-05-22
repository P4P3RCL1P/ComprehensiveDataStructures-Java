package edu.sru.thangiah.datastructures.generic.tree.binarytree;

import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.*;
import edu.sru.thangiah.datastructures.generic.tree.heaptree.HeapTreeNodeGeneric;

import java.util.NoSuchElementException;
/*
 * Generic Binary Tree implementation. Users can instantiate with any data type and perform various BST actions (traversals, add, remove, search, etc.)
 */
/**
 * <p>Title: BinarySearchTReeGeneric</p>
 *
 * <p>Description: </p>
 * Generic Binary Tree implementation. Users can instantiate with any data type and perform various BST actions (traversals, add, remove, search, etc.)
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class BinarySearchTreeGeneric <T extends Comparable<T>> extends AbstractBinaryTreeGeneric <T> {
	/**
	 * root of the tree
	 */
	private BinaryTreeNodeGeneric<T> root;
	/**
	 * no. of nodes in the tree
	 */
	private int count;
	/**
	 * count for search number for end of depth first
	 */
	private int searchCount;
	/**
	 * empty binary search tree which is used for testing if a tree is completely empty
	 */
	private static final BinaryTreeNodeGeneric EMPTY = new BinaryTreeNodeGeneric(null);
	/**
	 * Stack used for in/pre/post order traversal
	 */
	private StackArrayGeneric<BinaryTreeNodeGeneric<T>> treeStack;
	/**
	 * Stack used specifically for post order traversal
	 */
	private StackArrayGeneric<BinaryTreeNodeGeneric<T>> treeStackPostOrder;
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<BinaryTreeNodeGeneric<T>> treeQueue;
	
	
	public BinarySearchTreeGeneric()
	{
		//uninitialized root node (we point to the EMPTY node)
		root = EMPTY;
		count = 0;
		treeStack = new StackArrayGeneric<BinaryTreeNodeGeneric<T>>();
		treeQueue = new QueueArrayGeneric<BinaryTreeNodeGeneric<T>>();
		treeStackPostOrder = new StackArrayGeneric<BinaryTreeNodeGeneric<T>>();
	}
	/**
	 * Getter method for root pointer variable
	 * @return The root node in a tree
	 */
	public BinaryTreeNodeGeneric<T> getRoot()
	{
		return root;
	}
	/**
	 * Checks to see if the data for a given node has been uninitialized
	 * @return True if the node doesn't have any initialized data in it
	 */
	public boolean isEmpty()
	{
		if(root.getData() == null)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int height(BinaryTreeNodeGeneric<T> treeNode) {
		
		if(treeNode.isEmpty())
		{
			return 0;
		}
		
		//we can use recursion to find the maximum depth
		//of a binary tree. We use the Math.max method
		//which parses the leftmost/rightmost nodes
		//src: Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
		
		return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
	}
	@Override
	public int nodeCount() {
		return count;
	}
	@Override
	public int degree(BinaryTreeNodeGeneric<T> treeNode) {
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
		else if(!treeNode.getLeft().isEmpty())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	@Override
	public boolean isFull(BinaryTreeNodeGeneric<T> treeNode) {
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
			return (isFull(treeNode.getLeft()) && isFull(treeNode.getRight()));
		}
		return false;
	}

	@Override
	public boolean isComplete() {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		BinaryTreeNodeGeneric<T> treeNode;
		
		boolean isComplete = true;
		
		treeQueue.add(root);
		while(!treeQueue.isEmpty())
		{
			treeNode = treeQueue.deQueue();
			
			//navigate the tree to the left node
			//but ensure that while there is a
			//right node that it is printed next
			if(!treeNode.getLeft().isEmpty())
			{
				if(isComplete == false)
				{
					return false;
				}
				
				treeQueue.enQueue(treeNode.getLeft());
			}
			//we assume that the left node not being initialized indicates a not complete tree 
			else
			{
				isComplete = false;
			}
			
			if(!treeNode.getRight().isEmpty())
			{
				if(isComplete == false)
				{
					return false;
				}
				treeQueue.enQueue(treeNode.getRight());
			}
			else
			{
				isComplete = false;
			}
		}
		treeQueue.clear();
		//we've reached the end of the tree without any non-empty nodes 
		return true;
	}
	@Override
	public boolean isIncomplete() {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(isComplete() == false)
		{
			return true;
		}
		return false;
	}
	@Override
	public boolean isRoot(BinaryTreeNodeGeneric<T> treeNode) {
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
	public boolean isParent(BinaryTreeNodeGeneric<T> treeNode) {
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
	public boolean isChild(BinaryTreeNodeGeneric<T> treeNode) {
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
	public boolean isLeaf(BinaryTreeNodeGeneric<T> treeNode) {
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
	public boolean clear() {
		root.clearNode();
		count = 0;
		return true;
	}
	public BinaryTreeNodeGeneric<T> locateNode(BinaryTreeNodeGeneric<T> root, T data)
	{
		T rootValue;
		BinaryTreeNodeGeneric<T> child = root;
		rootValue = (T) root.getData();

		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		//the value we are searching for is the root node
		if(rootValue.compareTo(data) == 0)
		{
			
			return root;
		}
		
		//check for the left and right nodes
		//look left if less-than, right if greater-than
		if(rootValue.compareTo(data) < 0)
		{
			child = root.getRight();
		}
		else
		{

			child = root.getLeft();
		}
		
		//no child there: not in tree, return this node, else keep searching
		if(child.isEmpty())
		{
			return root;
		}
		
		else
		{
			//recursively navigate through the tree until the node is found
			return locateNode(child,data);
		}
	}
	//Similar to locateNode, except only a value parameter is specified
	@Override
	public BinaryTreeNodeGeneric<T> search(T value) {
		BinaryTreeNodeGeneric<T> nodeLoc;
		nodeLoc = locateNode(this.root, value);
		
		//we have found the node to search for
		if(nodeLoc.getData().compareTo(value) == 0)
		{
			return nodeLoc;
		}
		return null;
	}
	
	
	
	public BinaryTreeNodeGeneric<T> predecessor(BinaryTreeNodeGeneric<T> root, T data)
	{
		BinaryTreeNodeGeneric<T> findLocation = locateNode(root, data);
		//Node passed is not in bst (return error)
		if(findLocation.isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		BinaryTreeNodeGeneric<T> predecessorNode = findLocation;
		if(!predecessorNode.getLeft().isEmpty())
		{
			//navigate once to the left, and then
			//navigate as far right as we can
			predecessorNode = predecessorNode.getLeft();
			
			while(!predecessorNode.getRight().isEmpty())
			{
				predecessorNode = predecessorNode.getRight();
			}
		  return predecessorNode.getParent();
		}
		//case for when we are dealing with left-most leaf node
		if(predecessorNode.getData() == data)
		{
			return null;
		}
		
	    return null;
	}
	
	
	public BinaryTreeNodeGeneric<T> successor(BinaryTreeNodeGeneric<T> root)
	{
		//case for when we are dealing with uninitialized bst
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		if(root.getRight().isEmpty())
		{
			return null;
		}
		//navigate right once, and then traverse as far left as we can
		BinaryTreeNodeGeneric<T> result = root.getRight();
		while(!result.getLeft().isEmpty())
		{
			result = result.getLeft();
		}
		return result;
	}

	@Override
	public boolean insert(T value) {
		BinaryTreeNodeGeneric<T> newNode = new BinaryTreeNodeGeneric<T>(value);
		if(this.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		} 
		
		BinaryTreeNodeGeneric<T> nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(!this.isEmpty())
			{
				BinaryTreeNodeGeneric<T> insertLocation = locateNode(root,value);
				T nodeData = insertLocation.getData();
				//The location returned is the successor or predecessor
				//of the to-be-inserted value
				if(nodeData.compareTo(value) < 0)
				{
					insertLocation.setRight(newNode);
				}
				else
				{
					insertLocation.setLeft(newNode);
				}
				newNode.setParent(insertLocation);
			}
			count++;
			return true;
		}
		return false;
	}
	

	@Override
	public boolean add(T value) {
		BinaryTreeNodeGeneric<T> newNode = new BinaryTreeNodeGeneric<T>(value);
		if(this.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		} 
		
		BinaryTreeNodeGeneric<T> nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(!this.isEmpty())
			{
				BinaryTreeNodeGeneric<T> insertLocation = locateNode(root,value);
				T nodeData = insertLocation.getData();
				//The location returned is the successor or predecessor
				//of the to-be-inserted value
				if(nodeData.compareTo(value) < 0)
				{
					insertLocation.setRight(newNode);
				}
				else
				{
					insertLocation.setLeft(newNode);
				}
				newNode.setParent(insertLocation);
			}
			count++;
			return true;
		}
		return false;
	}
	public T remove(T value) 
	{
		//base condition for uninitialized bst
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		//find the root to use with the locateNode method (could swap to using just root)
		BinaryTreeNodeGeneric<T> deleteNode = locateNode(root, value);
		
		//ensure the value we are searching for is in the bst
		if(deleteNode.getData().compareTo(value) == 0)
		{
			if(!deleteNode.getLeft().isEmpty() || !deleteNode.getRight().isEmpty())
			{
				if(!deleteNode.getLeft().isEmpty() && !deleteNode.getRight().isEmpty())
				{
					value = deleteTwoChildren(deleteNode);
					deleteNode.clearNode();
					count--;
					return value;
				}
				//case 2: There is one child
				value = deleteOneChild(deleteNode);
				deleteNode.clearNode();
				count--;
				return value;
				
			}
			//Case 3: there is one child
			else
			{
				value = deleteLeaf(deleteNode);
				deleteNode.clearNode();
				count--;
				return value;
			}
		}	
		return null;
	}
	/**
	 * Helper function for remove method which removes a leaf from the tree
	 * @param deleteNode - Node to be deleted
	 * @return The data value of the node which is deleted
	 */
	public T deleteLeaf(BinaryTreeNodeGeneric<T> deleteNode)
	{
		T value;
		BinaryTreeNodeGeneric<T> leaf;
		
		leaf = deleteNode;
		value = leaf.getData();
		
		//case 1: leaf is root
		if(root == leaf)
		{
			root = EMPTY;
			leaf = EMPTY;
			return value;
		}
		//case 2: leaf is to the right or left of parent node
		if(leaf.getParent().getLeft() == leaf)
		{
			leaf.getParent().setLeft(EMPTY);
			leaf = EMPTY;
			return value;
		}
		//leaf is on right of tree
		else
		{
			leaf.getParent().setRight(EMPTY);
			leaf = EMPTY;
			return value;
		}
	}
	/**
	 * Helper function for remove method which deletes a node with only one child
	 * @param deleteNode - Node to be deleted
	 * @return The data value of the node deleted
	 */
	public T deleteOneChild(BinaryTreeNodeGeneric<T> deleteNode)
	{
		T value;
		BinaryTreeNodeGeneric<T> parent;
		parent = deleteNode;
		value = parent.getData();
		
		//check for which side child is on
		if(!parent.getLeft().isEmpty())
		{
			//case: node to be deleted is root
			if(parent == root)
			{
				root = root.getLeft();
				root.setParent(EMPTY);
				return value;
			}
			//node is not root
			else
			{
				parent.getLeft().setParent(parent.getParent());
				//checks for if parent node is to the right or left
				if(parent.getParent().getLeft() == parent)
				{
					parent.getParent().setLeft(parent.getLeft());
				}
				else
				{
					parent.getParent().setRight(parent.getLeft());
				}
				return value;
			}
		}
		//child to be linked is on the right subtree
		else
		{
			//case where root is node to be deleted
			if(parent == root)
			{
				root = root.getRight();
				root.setParent(EMPTY);
				return value;
			}
			//root is not node to be deleted
			else
			{
				parent.getRight().setParent(parent.getParent());
				//checks for if the parent node is to the right or left
				if(parent.getParent().getLeft() == parent)
				{
					parent.getParent().setLeft(parent.getRight());
					
				}
				else
				{
					parent.getParent().setRight(parent.getRight());
				}
				return value;
			}
		}
	}
	/**
	 * Helper function for remove method which deletes a node that has exactly two children
	 * @param deleteNode - node to be deleted
	 * @return The data value of the node which was deleted
	 */
	public T deleteTwoChildren(BinaryTreeNodeGeneric<T> deleteNode)
	{
		BinaryTreeNodeGeneric<T> successor;
		T value;
		value = deleteNode.getData();
		
		//node with two children is root
		if(deleteNode == root)
		{
			successor = successor(root);
			successor.setLeft(deleteNode.getLeft());
			deleteNode.getLeft().setParent(successor);
			
			//case when successor is not next to node to be deleted
			if(deleteNode.getRight().isEmpty())
			{
				//case for when successor has children that need to be linked
				if(!successor.getRight().isEmpty())
				{
					successor.getParent().setLeft(successor.getRight());
					successor.getRight().setParent(successor.getParent());
				}
				else
				{
					successor.getParent().setLeft(EMPTY);
				}
				successor.setRight(deleteNode.getRight());
				deleteNode.getRight().setParent(successor);
			}
			successor.setParent(null);
			root = successor;
			return value;
		}
		//we aren't deleting root node (still have 2 children)
		else
		{
			successor = successor(deleteNode);
			
			//replace deleteNode position with successor
			successor.setLeft(deleteNode.getLeft());
			deleteNode.getLeft().setParent(successor);
			
			//see which side the deleteNode lies on (in reference to parent node)
			if(deleteNode.getParent().getLeft() == deleteNode)
			{
				//replaces deleteNode w/ successor
				deleteNode.getParent().setLeft(successor);
			}
			else
			{
				//replaces deleteNode w/ success
				deleteNode.getParent().setRight(successor);
			}
			//case for when successor has children that need to be linked
			if(!successor.getRight().isEmpty())
			{
				successor.getParent().setLeft(successor.getRight());
				successor.getRight().setParent(successor.getParent());
			}
			else
			{
				successor.setRight(EMPTY);
			}
			successor.setParent(deleteNode.getParent());
			successor.getLeft().setParent(successor);
			//case when successor is not next to node to be deleted
			if(deleteNode.getRight() != successor)
			{
				successor.setRight(deleteNode.getRight());
			}
			successor.getRight().setParent(successor);
			return value;
		}
	}
	//recursive method for getting the largest node
	public BinaryTreeNodeGeneric<T> getLargest(BinaryTreeNodeGeneric<T> root)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(!root.getRight().isEMPTY())
		{
			return getLargest(root.getRight());
		}
		return root;
	}
	public BinaryTreeNodeGeneric<T> getSmallest(BinaryTreeNodeGeneric<T> root)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(!root.getLeft().isEMPTY())
		{
			return getSmallest(root.getLeft());
		}
		return root;
	}
	public BinaryTreeNodeGeneric<T> getSecondLargest(BinaryTreeNodeGeneric<T> root)
	{
        //we are only dealing with a binary tree w/ 1 node
		//do we call getLargest instead?
		if(this.root.isEmpty())
		{
			throw new NoSuchElementException();
		}
        if(root.getRight().isEmpty() && root.getLeft().isEmpty())
        {
        	return root;
        }
        //There is no further right node, there is no left child in the subtree, and we cannot get a right child
        if(!root.getRight().isEmpty() && root.getRight().getLeft().isEmpty() && root.getRight().getRight().isEmpty())
        {
        	return root;
        }

        //case for left-leaning bst
        if(root.getRight().isEmpty() && !root.getLeft().isEmpty())
        {
        	
        	if(root.getRight().isEmpty() && this.root != root)
        	{
        		return root;
        	}
        	return getSecondLargest(root.getLeft());
        }
        else
        {
        	//recursively iterate until we reach the desired subtree (where there are no further children)
        	return getSecondLargest(root.getRight());
        }
	}
	
	
	public BinaryTreeNodeGeneric<T> getSecondSmallest(BinaryTreeNodeGeneric<T> root)
	{
		//we are only dealing with a binary tree node w/ 1 node
		//do we call getSmallest instead?
		if(root.getRight().isEmpty() && root.getLeft().isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		//there is no further left node, there is no right child in the subtree, and there isn't another left child
		if(!root.getLeft().isEmpty() && root.getLeft().getRight().isEmpty() && root.getLeft().getLeft().isEmpty())
		{
			return root;
		}
		//case for right-leaning bst
        if(root.getLeft().isEmpty() && !root.getRight().isEmpty())
        {
        	if(root.getLeft().isEmpty() && this.root != root)
        	{
        		return root;
        	}
        	return getSecondSmallest(root.getRight());
        }
        else
        {
        	return getSecondSmallest (root.getLeft());
        }
	}

	//similar to getLargest except we return the data of the max node
	@Override
	public T findMax(BinaryTreeNodeGeneric<T> root) {
		BinaryTreeNodeGeneric <T> nodeLoc = getLargest(root);
		return nodeLoc.getData();
	}
	//similar to getSmallest except we return the data of the min node
	@Override
	public T findMin(BinaryTreeNodeGeneric<T> root) {
		BinaryTreeNodeGeneric <T> nodeLoc = getSmallest(root);
		return nodeLoc.getData();
	}
	
	public boolean rotateLeft(BinaryTreeNodeGeneric<T> treeNode)
	{
		BinaryTreeNodeGeneric <T> tempNode;
		if(treeNode.getRight().isEmpty())
		{
			return false;
		}
		//we initialize tempNode with the right child
		tempNode = treeNode.getRight();
		
		
		
		//case for when we are rotating the root node
		if(treeNode == this.root)
		{
			tempNode.setParent(null);
			treeNode.setParent(tempNode);
			treeNode.setRight(tempNode.getLeft());
			tempNode.setLeft(treeNode);
			this.root = tempNode;
			return true;
		}
		
		//after there are one or zero children
		if(treeNode.getParent().getLeft() == treeNode )
		{
			treeNode.getParent().setLeft(tempNode);
		}
		else
		{
			treeNode.getParent().setRight(tempNode);
		}
		tempNode.setParent(treeNode.getParent());
		treeNode.setRight(tempNode.getLeft());
		tempNode.setLeft(treeNode);
		return true;
		
	}
	public boolean rotateRight(BinaryTreeNodeGeneric<T> treeNode)
	{
		BinaryTreeNodeGeneric<T> tempNode;
		
		//tree is not fully initialized for rotation
		//requires at least one left child
		if(treeNode.getLeft().isEmpty())
		{
			return false;
		}
		tempNode = treeNode.getLeft();
		
		//case for basing rotation on root node
		if(treeNode == this.root)
		{
			tempNode.setParent(null);
			treeNode.setParent(tempNode);
			treeNode.setLeft(tempNode.getRight());
			tempNode.setRight(treeNode);
			this.root = tempNode;
			return true;
		}
		tempNode.setParent(treeNode.getParent());

		if(treeNode.getParent().getLeft() == treeNode)
		{
			treeNode.getParent().setLeft(tempNode);
		}
		else
		{
			treeNode.getParent().setRight(tempNode);
		}
		treeNode.setParent(tempNode);
		treeNode.setLeft(tempNode.getRight());
		tempNode.setRight(treeNode);
		return true;
	}
	
	
	//recursive inOrder traversal
	public void inOrder(BinaryTreeNodeGeneric<T> treeNode)
	{
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//Hitting the root node means we have 
		//reached the end of the traversal
		if(treeNode == root)
		{
			treeStack.clear();
		}
		//as long as we have not reached the root,
		//push the current node to the stack
		treeStack.push(treeNode);
		
		//check to see if we can go left
		if(!treeNode.getLeft().isEmpty())
		{
			inOrder(treeNode.getLeft());
		}
		
		//allows us to gain the benefit of recursion while
		//outputting to the same line
		System.out.print(treeStack.pop().getData() + " ");

		//condition for when there is no
		//left-most node (we go right)
		if(!treeNode.getRight().isEmpty())
		{
			inOrder(treeNode.getRight());
		}
		//reset the stack to be reused for additional methods calls
		//treeStack.clear();
	}
	//iterative preOrder traversal using a stack
	public void preOrder(BinaryTreeNodeGeneric<T> root)
	{
		//exception for uninitialized bst
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		
		treeStack.push(root);
		//beginning node
		BinaryTreeNodeGeneric<T> treeNode = root;
		
		while(!treeStack.isEmpty())
		{
			treeNode = treeStack.pop();
			
			System.out.print(treeNode.getData() + " ");
			//reach the right-most node before navigating left
			if(!treeNode.getRight().isEmpty())
			{
				treeStack.push(treeNode.getRight());
			}
			//after reaching the right-most node navigate left
			if(!treeNode.getLeft().isEmpty())
			{
				treeStack.push(treeNode.getLeft());
			}
		}
		treeStack.clear();
	}
	
	//recursive postOrder traversal using a stack
	public void postOrder(BinaryTreeNodeGeneric<T> root)
	{
		//uninitialized bst
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//we've reached the end of our traversal and we need to
		//uninitialize the stack to free up memory
		if(root == this.root)
		{
			treeStackPostOrder.clear();
		}
		
		//push the current node to the stack
		treeStackPostOrder.push(root);
		
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
		System.out.print(treeStackPostOrder.pop().getData() + " ");
	}
	
	
	//iterative method for level order traversal
	public void levelOrder(BinaryTreeNodeGeneric<T> root)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		BinaryTreeNodeGeneric<T> treeNode;
		
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
	public boolean breadthFirst(BinaryTreeNodeGeneric<T> root, T val)
	{
		//level order traversal to find a max value
		int nodeCount = 0;
		boolean valueFound = false;
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		BinaryTreeNodeGeneric treeNode;
		
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
	
	@Override
	public boolean depthFirst(BinaryTreeNodeGeneric<T> root, T value, boolean valueFound)
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
	
	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String args[])
	{
		BinarySearchTreeGeneric bst = new BinarySearchTreeGeneric();
		BinaryTreeNode tmp;
		System.out.println("Tree is empty:" + bst.isEmpty());
		bst.add(100);
		bst.add(80);
		bst.add(120);
		bst.add(90);
		bst.add(75);
		bst.add(110);
		System.out.println(bst.height(bst.getRoot()));
		System.out.println(bst.degree(bst.getRoot().getRight()));
		System.out.println(bst.isRoot(bst.getRoot()));
		System.out.println(bst.isRoot(bst.getRoot().getLeft()));
		System.out.println(bst.isComplete());
		System.out.println(bst.isIncomplete());
		System.out.println(bst.isFull(bst.getRoot()));
		//System.out.println(bst.isLeaf(bst.getRoot().getRight().getLeft()));
		bst.inOrder(bst.getRoot());
		System.out.println();
		bst.preOrder(bst.getRoot());
		System.out.println();
		bst.postOrder(bst.getRoot());
		System.out.println();
		bst.levelOrder(bst.getRoot());
	}
}
