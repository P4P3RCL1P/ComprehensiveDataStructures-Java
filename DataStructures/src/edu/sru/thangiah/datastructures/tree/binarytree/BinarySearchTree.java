package edu.sru.thangiah.datastructures.tree.binarytree;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.tree.binarytree.BinaryTreeNodeGeneric;
import edu.sru.thangiah.datastructures.stack.*;


/**
 * <p>Title: BinarySearchTree</p>
 *
 * <p>Description: </p>
 * Binary tree made up of BinaryTreeNode nodes
 * Left child is smaller than root node, right child is larger than root node
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class BinarySearchTree extends AbstractBinaryTree{
	/**
	 * root of the tree
	 */
	private BinaryTreeNode root;
	/**
	 * no. of nodes in the tree
	 */
	private int count;
	/**
	 * count for depth first to determine end of search
	 */
	private int searchCount;
	/**
	 * empty binary search tree which is used for testing if a tree is completely empty
	 */
	private static final BinaryTreeNode EMPTY = new BinaryTreeNode(-1);
	/**
	 * Stack used for in/pre/post order traversal
	 */
	private StackArray treeStack;
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<BinaryTreeNode> treeQueue;

	public BinarySearchTree() {
		// root points to the empty node
		root = EMPTY;
		count = 0;
		treeStack = new StackArray();
		treeQueue = new QueueArrayGeneric<BinaryTreeNode>();
	}
	/**
	 * Getter method for root pointer variable
	 * @return The root node in a tree
	 */
	public BinaryTreeNode getRoot() {
		return root;
	}

	/**
	 * Checks to see if the data for a given node has been uninitialized
	 * @return True if the node doesn't have any initialized data in it
	 */
	public boolean isEmpty() {
		if (root.getData() == -1) {
			return true;
		}
		return false;
	}

	/*
	 * Remove all the nodes from the binary search tree
	 */
	public boolean clear() {
		root.clearNode();
		count = 0;
		return true;
	}

	public int height(BinaryTreeNode treeNode) {
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
	public int nodeCount() {
		return count;
	}
	
	@Override
	public int degree(BinaryTreeNode treeNode) {
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
	public boolean isFull(BinaryTreeNode treeNode) {
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
		BinaryTreeNode treeNode;
		
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
	public boolean isRoot(BinaryTreeNode treeNode) {
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
	public boolean isParent(BinaryTreeNode treeNode) {
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
	public boolean isChild(BinaryTreeNode treeNode) {
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
	public boolean isLeaf(BinaryTreeNode treeNode) {
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
	

	//similar to locateNode, except only a value parameter is specified
	@Override
	public BinaryTreeNode search(int value) {
		BinaryTreeNode nodeLoc;
		nodeLoc = locateNode(this.root, value);
		
		//we have found the node to search for
		if(nodeLoc.getData() == value)
		{
			return nodeLoc;
		}
		return null;
	}

	/*
	 * 
	 */
	public BinaryTreeNode locateNode(BinaryTreeNode root, int data) {
		int rootValue;
		BinaryTreeNode child;
		//root = this.getRoot();
		rootValue = root.getData();

		// value found at root
		if (rootValue == data) {
			return root;
		}

		// look left if less-than, right if greater-than
		if (rootValue < data) {
			child = root.getRight();
		} 
		else {
			child = root.getLeft();
		}
		// no child there: not in tree, return this node,
		// else keep searching
		if (child.isEmpty()) {
			return root;
		} else {
			return locateNode(child, data);
		}
	}
	
	/*
	 * Predecessor of a node in a Binary tree is the node
	 * with the next closest value on the left hand side of the tree 
	 */

	public BinaryTreeNode predecessor(BinaryTreeNode root, int data)
    {
        BinaryTreeNode findLocation = locateNode(root, data);
        if(findLocation.getData() == -1)
        {
        	throw new NoSuchElementException();
        }
        BinaryTreeNode predecessorNode = findLocation;
        if (!predecessorNode.getLeft().isEMPTY())
        {
			//navigate once to the left, and then
			//navigate as far right as we can
            predecessorNode = predecessorNode.getLeft();
            
                while (!predecessorNode.getRight().isEMPTY())
                {
                    predecessorNode = predecessorNode.getRight();
                }
        }
        //we are dealing with the left-most leaf node.
        if(predecessorNode.getData() == data)
        {
        	return null;
        }
        return predecessorNode;     
    }
	
	/*
	 * Successor of a node in a Binary tree is the node
	 * with the next largest value on the right hand side of the tree 
	 */

	public BinaryTreeNode successor(BinaryTreeNode root) {
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		if(root.getRight().isEmpty())
		{
			return null;
		}
		BinaryTreeNode result = root.getRight();
		while (!result.getLeft().isEmpty()) {
			result = result.getLeft();
		}
		return result;
	}
	
	@Override
	public boolean insert(int value) {
		BinaryTreeNode nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			BinaryTreeNode newNode = new BinaryTreeNode(value);
			if (this.isEmpty()) {
				root = newNode;
			} else {
				BinaryTreeNode insertLocation = locateNode(root, value);
				int nodeData = insertLocation.getData();
				// The location returned is the successor or predecessor
				// of the to-be-inserted value
				if (nodeData < value) {
					insertLocation.setRight(newNode);
				} else 
				{			
					insertLocation.setLeft(newNode);
					/*if (!insertLocation.getLeft().isEmpty()) {
						// if value is in tree, we insert just before
						predecessor(insertLocation).setRight(newNode);
					} else {
						insertLocation.setLeft(newNode);
					}
					*/
				}
			}
			count++;
			
			return true;
		}
		return false;
	}

	/*
	 * Add node to the tree
	 */
	public boolean add(int data) {
		BinaryTreeNode nodeExists = search(data);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			BinaryTreeNode newNode = new BinaryTreeNode(data);
			if (this.isEmpty()) {
				root = newNode;
			} else {
				BinaryTreeNode insertLocation = locateNode(root, data);
				int nodeData = insertLocation.getData();
				// The location returned is the successor or predecessor
				// of the to-be-inserted value
				if (nodeData < data) {
					insertLocation.setRight(newNode);
				} else 
				{			
					insertLocation.setLeft(newNode);
					/*if (!insertLocation.getLeft().isEmpty()) {
						// if value is in tree, we insert just before
						predecessor(insertLocation).setRight(newNode);
					} else {
						insertLocation.setLeft(newNode);
					}
					*/
				}
			newNode.setParent(insertLocation);
			}
			count++;
			return true;
		}
		return false;
	}
	
	@Override
	public int remove(int value) {
		//base condition for uninitialized bst
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		//find the root to use with the locate method (could swap to just using root)
		BinaryTreeNode deleteNode = locateNode(root, value);
		
		//ensure the value we are searching for is in the bst
		if(deleteNode.getData() == value)
		{
			if(!deleteNode.getLeft().isEmpty() || !deleteNode.getRight().isEmpty())
			{
				//case 1: there are two children
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
		
			//case 3: node is a leaf
			else 
			{
				value = deleteLeaf(deleteNode);
				deleteNode.clearNode();
				count--;
				return value;
			}
		}
		return -1;
	}
	
	/**
	 * Helper function for remove method which removes a leaf from the tree
	 * @param deleteNode - Node to be deleted
	 * @return The data value of the node which is deleted
	 */
	public int deleteLeaf(BinaryTreeNode deleteNode)
	{
		int value;
		BinaryTreeNode leaf;
		
		leaf = deleteNode;
		value = leaf.getData();
		
		//case 1: leaf is root
		if(this.root == leaf)
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
	public int deleteOneChild(BinaryTreeNode deleteNode)
	{
		int val;
		BinaryTreeNode parent;
		parent = deleteNode;
		val = parent.getData();
		
		
		//Checks for which side child is on
		if(!parent.getLeft().isEmpty())
		{
			//case: node to be deleted is root
			if(parent == root)
			{
				root = root.getLeft();
				root.setParent(EMPTY);
				return val;
			}
			//node is not root
			else
			{
				parent.getLeft().setParent(parent.getParent());
				//Checks for if the parent node is to the right or left 
				if(parent.getParent().getLeft() == parent)
				{
					parent.getParent().setLeft(parent.getLeft());
				}
				else
				{
					parent.getParent().setRight(parent.getLeft());
				}
				return val;
			}
		}
		else
		{
			//case where root is node to be deleted
			if(parent == root)
			{
				root=root.getRight();
				root.setParent(EMPTY);
				return val;
			}
			//root is not node to be deleted
			else
			{
				parent.getRight().setParent(parent.getParent());
				//Checks for if the parent node is to the right or left 
				if(parent.getParent().getLeft() == parent)
				{
					parent.getParent().setLeft(parent.getRight());
				}
				else
				{
					parent.getParent().setRight(parent.getRight());
				}
				return val;
			}
		}
	}
	/**
	 * Helper function for remove method which deletes a node that has exactly two children
	 * @param deleteNode - node to be deleted
	 * @return The data value of the node which was deleted
	 */
	public int deleteTwoChildren(BinaryTreeNode deleteNode)
	{
		BinaryTreeNode successor;
		int value;
		value = deleteNode.getData();
		
		//node with two children is root
		if(deleteNode == root)
		{
			successor = successor(root);
			successor.setLeft(deleteNode.getLeft());
			deleteNode.getLeft().setParent(successor);
			
			//case when successor is not next to node to be deleted
			if(deleteNode.getRight() != successor)
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
		//we aren't deleting root node (still have 2 children
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
				//replaces deleteNode w/ successor
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
	
	public BinaryTreeNode getLargest(BinaryTreeNode root) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
        if (!root.getRight().isEMPTY()) {
            return getLargest(root.getRight());
        }
        return root;
    }
	
	public BinaryTreeNode getSmallest(BinaryTreeNode root) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
        if (!root.getLeft().isEMPTY()) {
            return getSmallest(root.getLeft());
        }
        return root;
    }
	
	/*public int getSecondLargest(BinaryTreeNode root) {
		 if (!this.isEmpty()) {
	            
	            BinaryTreeNode secondLarge = getLargest(root);
	            secondLarge = predecessor(secondLarge, secondLarge.getData());
	            return secondLarge.getData();
	        }     
	        return -1;
	}
	
	*/
	
	public BinaryTreeNode secondLargest1(BinaryTreeNode root) {
		BinaryTreeNode temp;
		BinaryTreeNode ptr;
		temp = root;
		ptr = root;

		while (ptr.getRight().getData() != -1)
		{
		ptr = ptr.getRight();
		}

		while (temp.getRight() != ptr)
		{
		temp = temp.getRight();
		}
		return temp;
		}
	
	public BinaryTreeNode getSecondSmallest(BinaryTreeNode root) {
        //we are only dealing with a binary tree w/ 1 node
		//do we call getSmallest instead?
		if(root.getRight().isEmpty() && root.getLeft().isEmpty())
        {
			throw new NoSuchElementException();
        }
		
		
		//There is no further left node, there is no right child in the subtree, and there isn't another left child
		if(!root.getLeft().isEmpty() && root.getLeft().getRight().isEmpty() && root.getLeft().getLeft().isEmpty())
		{
			return root;
		}
		
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
    		return getSecondSmallest(root.getLeft());	
        }
		
		//if (!this.isEmpty() || (root.getRight().isEmpty() && root.getLeft().isEmpty())){
         //get the largest number in the tree
          //BinaryTreeNode tmp = getSmallest(root);
          //get the prececessor of the largest number
           //tmp = successor(root);
            //return tmp;
        //}     
 }

	
	public BinaryTreeNode getSecondLargest(BinaryTreeNode root) {
        //we are only dealing with a binary tree w/ 1 node
		//do we call getLargest instead?
        if(root.getRight().isEmpty() && root.getLeft().isEmpty())
        {
        	throw new NoSuchElementException();
        }
        //There is no further right node, there is no left child in the subtree, and we cannot get a right child
        if(!root.getRight().isEmpty() && root.getRight().getLeft().isEmpty() && root.getRight().getRight().isEmpty())
        {
        	return root;
        }
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
	
	//similar to getLargest except we return the data of the max node
	@Override
	public int findMax(BinaryTreeNode root) {
		BinaryTreeNode nodeLoc = getLargest(root);
		return nodeLoc.getData();
	}
	//similar to getSmallest except we return the data of the min node
	@Override
	public int findMin(BinaryTreeNode root) {
		BinaryTreeNode nodeLoc = getSmallest(root);
		return nodeLoc.getData();
	}

	@Override
	public boolean rotateLeft(BinaryTreeNode node) {
		BinaryTreeNode tempNode;
		if(node.getRight().isEmpty())
		{
			return false;
		}
		//we initialize tempNode with the right child
		tempNode = node.getRight();
		
		
		
		//case for when we are rotating the root node
		if(node == this.root)
		{
			tempNode.setParent(null);
			node.setParent(tempNode);
			node.setRight(tempNode.getLeft());
			tempNode.setLeft(node);
			this.root = tempNode;
			return true;
		}
		
		//after there are one or zero children
		if(node.getParent().getLeft() == node )
		{
			node.getParent().setLeft(tempNode);
		}
		else
		{
			node.getParent().setRight(tempNode);
		}
		tempNode.setParent(node.getParent());
		node.setRight(tempNode.getLeft());
		tempNode.setLeft(node);
		return true;
	}

	@Override
	public boolean rotateRight(BinaryTreeNode node) {
		BinaryTreeNode tempNode;
		
		//tree is not fully initialized for rotation
		//requires at least one left child
		if(node.getLeft().isEmpty())
		{
			return false;
		}
		tempNode = node.getLeft();
		
		//case for basing rotation on root node
		if(node == this.root)
		{
			tempNode.setParent(null);
			node.setParent(tempNode);
			node.setLeft(tempNode.getRight());
			tempNode.setRight(node);
			this.root = tempNode;
			return true;
		}
		tempNode.setParent(node.getParent());

		if(node.getParent().getLeft() == node)
		{
			node.getParent().setLeft(tempNode);
		}
		else
		{
			node.getParent().setRight(tempNode);
		}
		node.setParent(tempNode);
		node.setLeft(tempNode.getRight());
		tempNode.setRight(node);
		return true;
	}
	
	
	//recursive inOrder traversal
	public void inOrder(BinaryTreeNode root) 
	{
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
		//single-line output using printf (we will only use int datatype)
		System.out.print(treeStack.pop() + " ");
		
		//condition for when there is no
		//left-most node (we go right)
		if(!root.getRight().isEmpty())
		{
			inOrder(root.getRight());
		}
		treeStack.clear();
	}
	//iterative preorder traversal using a stack
	public void preOrder(BinaryTreeNode root)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeStack.push(root);
		//beginning node to traverse through
		BinaryTreeNode treeNode = root;
		
		while(!treeStack.isEmpty())
		{
			treeNode =  (BinaryTreeNode) treeStack.pop();
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
	public void postOrder(BinaryTreeNode root)
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
		treeStack.clear();
	}
	
	public void levelOrder(BinaryTreeNode root)
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		BinaryTreeNode treeNode;
		
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
	
	public boolean depthFirst(BinaryTreeNode root, int value, boolean valueFound)
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
	
	public boolean breadthFirst(BinaryTreeNode root, int val)
	{
		//level order traversal to find a max value
		int nodeCount = 0;
		boolean valueFound = false;
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		BinaryTreeNode treeNode;
		
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
	
	/*
	public boolean limitedDiscSearch(BinaryTreeNode root, int value)
	{
		int wave = 0;
		BinaryTreeNode temp;
		boolean valueFound = false;
		int depth = height(root) - 2;
		System.out.println(depth);
		System.out.println(root.getData());
		
		do {
			
			int count = wave;
			temp = root;
			
			System.out.println(temp.getData());
			
			for(int i = 0; i < depth; i++)
			{
				if(temp.getData() == value)
				{
					valueFound = true;
					break;
				}
				else if(temp.getExplored() == true)
				{
					break;
				}
				for(int j = 0; j < count; j++)
				{
					if(temp.getRight() != null && temp.getRight().getExplored() == false)
					{
						temp = temp.getRight();
					}
					else if(temp.getRight() != null && temp.getRight().getExplored() == true && temp.getLeft() != null)
					{
						temp = temp.getLeft();
						j--;
					}
				}
				if(temp.getLeft() != null && temp.getLeft().getExplored() == false)
				{
					temp = temp.getLeft();
				}
				
				System.out.println(temp.getData());
			}
			
			temp.setExplored(true);
			if(temp.getParent() != null && temp.getParent().getLeft() != null && temp.getParent().getRight() != null)
			{
				if(temp.getParent().getLeft().getExplored() == true && temp.getParent().getRight().getExplored() == true)
				{
					temp.getParent().setExplored(true);
				}
			}
			
			wave++;
			
	}while(valueFound == false);
		
	//System.out.println("Value found, waves: " + wave);
	return true;
		
	}*/

	 /**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String args[]) {

		BinarySearchTree binarySrchTree = new BinarySearchTree();
		BinaryTreeNode tmp;
		System.out.println("Tree is empty:" + binarySrchTree.isEmpty());
		binarySrchTree.add(100);
		binarySrchTree.add(90);
		binarySrchTree.add(80);
		binarySrchTree.add(70);
		System.out.println(binarySrchTree.getSecondLargest(binarySrchTree.getRoot()).getData());
		//System.out.println("Tree is empty:" + binarySrchTree.isEmpty());
		//tmp = binarySrchTree.locateNode(binarySrchTree.getRoot(), 10);
		//System.out.println(tmp.getData());
		binarySrchTree.add(80);
		binarySrchTree.add(120);
		binarySrchTree.add(90);
		binarySrchTree.add(75);
		//binarySrchTree.search(75);
		//System.out.println(binarySrchTree.height(binarySrchTree.getRoot()));
		binarySrchTree.inOrder(binarySrchTree.getRoot());
		//System.out.println();
		//tmp = binarySrchTree.getLargest(binarySrchTree.getRoot());
		//System.out.println("Largest is "+tmp.getData());
		//tmp = binarySrchTree.secondLargest1(binarySrchTree.getRoot());
		//System.out.println("Second largest is "+tmp.getData());
		//binarySrchTree.preOrder(binarySrchTree.getRoot());
		//System.out.println();
		//binarySrchTree.postOrder(binarySrchTree.getRoot());
		System.out.println();
		
		//BinarySearchTree test = new BinarySearchTree();
		//System.out.println(test.height(test.getRoot()));
		//binarySrchTree.levelOrder(binarySrchTree.getRoot());
		//binarySrchTree.breadthFirst(binarySrchTree.getRoot(), 10000);
		//binarySrchTree.inOrder(binarySrchTree.getRoot());
		System.out.println(binarySrchTree.depthFirst(binarySrchTree.getRoot(), 1000, false));
		//binarySrchTree.limitedDiscSearch(binarySrchTree.getRoot(), 1000);
		//binarySrchTree.limitedDiscSearch(binarySrchTree.getRoot(), 90);
		//binarySrchTree.depthFirst(binarySrchTree.getRoot(), 70, 0);
		//binarySrchTree.depthFirst(binarySrchTree.getRoot(), 123, 0);
		//System.out.println();
		
		//tmp = binarySrchTree.getSecondLargest(binarySrchTree.getRoot());
		//System.out.println(tmp.getData());
		//tmp = binarySrchTree.getSecondSmallest(binarySrchTree.getRoot());
		//System.out.println(tmp.getData());
		//System.out.println(binarySrchTree.remove(75));
		//binarySrchTree.inOrder(binarySrchTree.getRoot());
		//System.out.println();
		//tmp = binarySrchTree.getSecondLargest(binarySrchTree.getRoot());
		//System.out.println(tmp.getData());
	}
}
