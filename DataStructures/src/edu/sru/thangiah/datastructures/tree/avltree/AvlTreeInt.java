package edu.sru.thangiah.datastructures.tree.avltree;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.AbstractTreeGeneric;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.StackArrayGeneric;
import edu.sru.thangiah.datastructures.generic.tree.avltree.AvlTreeNodeGeneric;
import edu.sru.thangiah.datastructures.stack.StackArray;
import edu.sru.thangiah.datastructures.tree.avltree.AvlTreeNode;
import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.*;

/*
 * Integer implementation for an AVL tree
 * Note that an AVL tree is a self-balancing tree which checks the height of subtrees to ensure that the left and right subtrees don't have a height greater than one
 */
/**
 * <p>Title: AvlTreeInt</p>
 *
 * <p>Description: </p>
 * Class for creating an integer AVL tree that balances on adding and removing nodes.
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class AvlTreeInt {

	private AvlTreeNode root;
	private int count;
	private static final AvlTreeNode EMPTY = new AvlTreeNode(-1);
	private StackArray treeStack;
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<AvlTreeNode> treeQueue;

	
	// rotator is necessary for rotations if using redundant data because the rotate
	// methods
	// have no way to locate these nodes

	public AvlTreeInt() {
		
		root = new AvlTreeNode();
		count = 0;
		treeStack = new StackArray();
		treeQueue = new QueueArrayGeneric<AvlTreeNode>();
	}

	public boolean isEmpty() {
		if (root.getData() == -1) {
			return true;
		}
		return false;
	}

	public boolean clear() {
		// Clears the tree
		root.clearNode();
		count = 0;
		return true;
	}

	public AvlTreeNode getRoot() {
		return root;
	}

	//the intention of this method is to check the balance of both of the sides of the tree 
	//to see if the two sides need to be balanced
	
	public int checkBalance(AvlTreeNode x) {
		
		if(x.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		
		if(x.getLeft()==null) {
			if(x.getRight()==null) {
				return 0;
			}else {
				return (0 - height(x.getRight()));
			}
		}else if(x.getRight()==null) {
			return height(x.getLeft());
		}else {
			return (height(x.getLeft())-height(x.getRight()));

		}
	}
	
	public boolean add(int value) {
		AvlTreeNode newNode = new AvlTreeNode(value);
		AvlTreeNode nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(this.isEmpty())
			{
				root = newNode;
				count++;
				return true;
			} else {
				AvlTreeNode insertLocation = locateNode(root,value);
				int nodeData = insertLocation.getData();
				
				//The location returned is the successor or predecessor
				//of the to-be-inserted value
				if(nodeData < value)
				{
					insertLocation.setRight(newNode);
				}else{
					insertLocation.setLeft(newNode);
				}
				newNode.setParent(insertLocation);
				
				//launching ascend to check for an imbalance
				this.ascendTree(newNode);
			}
			count++;
			return true;
		}
		return false;
	}
	
	/**
	 * This method takes in a node at the bottom of the tree
	 * and works from the bottom up checking for where a tree
	 * may become unbalanced, and depending on the path that 
	 * it took, it performs one of the functions to rotate
	 * the tree and retain AVL balance
	 * @param node value
	 * @return true upon completion
	 */
	
	public boolean ascendTree(AvlTreeNode node) {
		
		if(node==root) {
			if(this.checkBalance(node)>=2||this.checkBalance(node)<=-2) {
					
					if(this.checkBalance(node)>=2) {
						if(this.checkBalance(node.getLeft())>=1) {
							this.leftLeft(node);
						}else {
							this.leftRight(node);
						}
					}else {
						if(this.checkBalance(node.getRight())<=-1) {
							this.rightRight(node);
						}else {
							this.rightLeft(node);
						}
					}
			
					return true;

			}
			
		}else{
			
			if(this.checkBalance(this.getRoot())>=-1&&this.checkBalance(root)<=1) {
				return true;
			}
			
			if(this.checkBalance(node)>=2||this.checkBalance(node)<=-2) { //if node is unbalanced...
				
				if(this.checkBalance(node)>=2) { //if node is unbalanced...
					if(!node.getLeft().isEmpty()) {
						if(this.checkBalance(node.getLeft())>0) {
							this.leftLeft(node);
						}else {
							this.leftRight(node);
						}
					}
				
				} else if(this.checkBalance(node)<=-2) {
					if(this.checkBalance(node.getRight())<0) {
						this.rightRight(node);
					}else {
						this.rightLeft(node);
					}
				}
				
			}
			
		}
		
		node=node.getParent();
		ascendTree(node); //recurses through until it reaches the top of the tree
		return false;
		
	}
	
	/**
	 * This method takes in a node at the bottom of the tree
	 * and works from the bottom up checking for where a tree
	 * may become unbalanced, and depending on the path that 
	 * it took, it performs one of the functions to rotate
	 * the tree and retain AVL balance
	 * @param node
	 * @return
	 */
	public boolean ascendRemoveTree(AvlTreeNode node) {
		
		if(node==root) { //if the node is the root
			if(this.checkBalance(root)>=2) { //if node is unbalanced...
				if(this.checkBalance(root.getLeft())>0) {
					this.leftLeft(root);
				}else {
					this.leftRight(root);
				}
			}else if(this.checkBalance(root)<=-2) {
				if(this.checkBalance(root.getRight())<0) {
					this.rightRight(root);
				}else {
					this.rightLeft(root);
				}
			}
		}else{ //if the node is not the root
			if(this.checkBalance(node)>=2) { //if node is unbalanced...
				if(!node.getLeft().isEmpty()) {
					if(this.checkBalance(node.getLeft())>0) {
						this.leftLeft(node);
					}else {
						this.leftRight(node);
					}
				}
			
			}else if(this.checkBalance(node)<=-2) {
				if(this.checkBalance(node.getRight())<0) {
					this.rightRight(node);
				}else {
					this.rightLeft(node);
				}
			}
			ascendRemoveTree(node.getParent());
		}
		
		return false;
	}
		
	/*
	 * this method takes in the top node of a left left rotate
	 * and turns it into the right node for the middle node
	 * and the middle node's right children become the top
	 * node's left children to maintain the height consistency
	 * of the tree
	 */
	public boolean leftLeft(AvlTreeNode node) {
		
		rotateRight(node);
		
		return true;
	}
	
	/*
	 * this method takes in the top node of a left right rotate
	 * and it moves the bottom node to the top node, and the top
	 * node becomes the right node of that node, and the children
	 * get split, right children to the left of the top node
	 * and left children to the right of the middle node
	 */
	public boolean leftRight(AvlTreeNode node) {
		
		rotateLeft(node.getLeft());
		rotateRight(node);
		return true;
		
	}
	
	/*
	 * This works like left left, but inverted
	 * this method takes in the top node of a right right rotate
	 * and turns it into the left node for the middle node
	 * and the middle node's left children become the top
	 * node's right children to maintain the height consistency
	 * of the tree
	 */
	public boolean rightRight(AvlTreeNode node) {
		
		rotateLeft(node);
		
		return true;
	}
	
	/*
	 * This works like right left, but inverted
	 * this method takes in the top node of a right left rotate
	 * and it moves the bottom node to the top node, and the top
	 * node becomes the left node of that node, and the children
	 * get split, left children to the right of the top node
	 * and right children to the left of the middle node
	 */
	
	public boolean rightLeft(AvlTreeNode node) {
		
		rotateRight(node.getRight());
		rotateLeft(node);
		
		return true;
	}
	
	/**
	 * method that checks if the tree contains the given value
	 * by performing locateNode and checking if that value is equivalent
	 * @param data (int)
	 * @return true if the value is equal and the tree contains the value
	 */
	public boolean contains(int data) {
		AvlTreeNode newNode = new AvlTreeNode(data);
		newNode = locateNode(root, data);
		if (newNode.getData() == -1) {
			newNode = null;
			return false;
		}
		return true;
	}

	/**
	 * helper method for delete used to delete a node given that the node
	 * has no children. it also recursively traverses up the tree for rebalancing. 
	 * @param deleteNode (the node being deleted)
	 * @return value, the value of the node being deleted
	 */
	public int deleteLeaf(AvlTreeNode deleteNode)
	{
		int value;
		AvlTreeNode leaf;
		
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
			AvlTreeNode x = leaf.getParent();
			leaf = EMPTY;
			ascendRemoveTree(x);
			return value;
		}
		//leaf is on right of tree
		else
		{
			leaf.getParent().setRight(EMPTY);
			AvlTreeNode x = leaf.getParent();
			leaf = EMPTY;
			ascendRemoveTree(x);
			return value;
		}
	}
	
	/**
	 * helper method for delete used to delete a node given that the node
	 * has 1 child. it also recursively traverses up the tree for rebalancing. 
	 * @param deleteNode (the node being deleted)
	 * @return value, the value of the node being deleted
	 */
	public int deleteOneChild(AvlTreeNode deleteNode)
	{
		int value;
		AvlTreeNode parent = deleteNode;
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
					ascendRemoveTree(parent.getLeft());
				}
				else
				{
					parent.getParent().setRight(parent.getLeft());
					ascendRemoveTree(parent.getRight());
				}
				return value;
			}
		}else{ //right tree
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
					ascendRemoveTree(parent.getRight());
					
				}
				else
				{
					
					parent.getParent().setRight(parent.getRight());
					ascendRemoveTree(parent);

				}
				return value;
			}
		}
	}
	
	/**
	 * helper method for delete used to delete a node given that the node
	 * has 2 children. it also recursively traverses up the tree for rebalancing. 
	 * @param deleteNode (the node being deleted)
	 * @return value, the value of the node being deleted
	 */
	public int deleteTwoChildren(AvlTreeNode deleteNode)
	{
		AvlTreeNode successor;
		int value;
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
			successor.setParent(EMPTY);
			root = successor;
			ascendRemoveTree(root);
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
			System.out.println("successor is "+successor.getData());
			ascendRemoveTree(successor);
			return value;
		}
	}
	
	/**
	 * returns the predecessor to the node
	 * @param root, the root node of the tree
	 * @param data, the value we are looking for of the node we want to find the predecessor for
	 * @return the predecessor of the node, or null if there is none
	 */
	public AvlTreeNode predecessor(AvlTreeNode root, int data)
    {
		AvlTreeNode findLocation = locateNode(root, data);
        if(findLocation.getData() == -1)
        {
        	throw new NoSuchElementException();
        }
        AvlTreeNode predecessorNode = findLocation;
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
	
	/**
	 * returns the successor to the root
	 * @param root, the root node of the tree
	 * @return the successor of the node, or null if there is none
	 */
	public AvlTreeNode successor(AvlTreeNode root)
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
		AvlTreeNode result = root.getRight();
		while(!result.getLeft().isEmpty())
		{
			result = result.getLeft();
		}
		return result;
	}
	
	//recursive method for getting the largest node
	public AvlTreeNode getLargest(AvlTreeNode root)
	{
		if(root.equals(null))
		{
			throw new NoSuchElementException();
		}
		if(root.getRight()!=null)
		{
			return getLargest(root.getRight());
		}
		return root;
	}
	
	public AvlTreeNode getSmallest(AvlTreeNode root)
	{
		if(root.equals(null))
		{
			throw new NoSuchElementException();
		}
        if (root.getLeft()!=null) {
            return getSmallest(root.getLeft());
        }
        return root;
	}
	
	public AvlTreeNode getSecondLargest(AvlTreeNode root)
	{
        //we are only dealing with a binary tree w/ 1 node
		//do we call getLargest instead?
        if(root.getRight()==null && root.getLeft()==null)
        {
        	throw new NoSuchElementException();
        }
        //There is no further right node, there is no left child in the subtree, and we cannot get a right child
        if(root.getRight()!=null && root.getRight().getLeft()==null && root.getRight().getRight()==null)
        {
        	return root;
        }
        //recursively iterate until we reach the desired subtree (where there are no further children)
        return getSecondLargest(root.getRight());
	}
	
	public int height(AvlTreeNode treeNode) {
		if(treeNode==null)
		{
			return 0;
		}
		
		if(treeNode.getData()==-1) {
			return 0;
		}
		
		//we can use recursion to find the maximum depth
		//of a binary tree. We use the Math.max method
		//which parses the leftmost/rightmost nodes
		//src: Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
		//int maxDepth = 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
		
		return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
	}
	
	public int nodeCount() {
		return count;
	}

	public boolean insert(int value) {
		AvlTreeNode newNode = new AvlTreeNode(value);
		if(this.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		} 
		
		AvlTreeNode nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(!this.isEmpty())
			{
				AvlTreeNode insertLocation = locateNode(root,value);
				int nodeData = insertLocation.getData();
				//The location returned is the successor or predecessor
				//of the to-be-inserted value
				if(nodeData < 0)
				{
					insertLocation.setRight(newNode);
				}
				else
				{
					insertLocation.setLeft(newNode);
				}
				newNode.setParent(insertLocation);
				this.ascendTree(newNode);
			}
			count++;
			return true;
		}
		return false;
	}

	/*
	 * method intended to remove the value from the int AVL Tree
	 */
	public int remove(int value) 
	{
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		//find the root to use with the locateNode method (could swap to using just root)
		AvlTreeNode deleteNode = locateNode(root, value);
		//ensure the value we are searching for is in the bst

		if(deleteNode.getData() == value)
		{
			if(!deleteNode.getLeft().isEmpty() || !deleteNode.getRight().isEmpty())
			{
				//case 1: Two children node
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
		
		return -1;
	}
	
	public AvlTreeNode locateNode(AvlTreeNode temproot, int data)
	{
		int rootValue;
		AvlTreeNode child = temproot;
		rootValue = temproot.getData();
		// value found at root
				if (rootValue == data) {
					return temproot;
				}

				// look left if less-than, right if greater-than
				if (rootValue < data) {
					child = temproot.getRight();
				} 
				else {
					child = temproot.getLeft();
				}
				// no child there: not in tree, return this node,
				// else keep searching
				if(child==null) {
					return temproot;
				}
				if (child.isEmpty()) {
					return temproot;
				} else {
					return locateNode(child, data);
				}
	}
	
	
	//Similar to locateNode, except only a value parameter is specified

	public AvlTreeNode search(int value) {
		AvlTreeNode nodeLoc;
		nodeLoc = locateNode(this.root, value);
		//we have found the node to search for
		if(nodeLoc.getData() == value)
		{
			return nodeLoc;
		}
		return null;
	}

	public int findMax() {
		int data = root.getData();
		
		if (this.isEmpty()) {
			return -1;
		}

		if (root.getRight() == null) {
			return data;
		}

		AvlTreeNode temp = root;
		while (temp.getRight() != null) {
			temp = temp.getRight();
		}
		data = temp.getData();
		return data;
	}

	public int findMin() {
		int data = root.getData();

		if (this.isEmpty()) {
			return -1;
		}

		if (root.getLeft() == null) {
			return data;
		}

		AvlTreeNode temp = root;
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		data = temp.getData();
		return data;
	}
	
	/*
	 * Unused
	 */
	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isFull(AvlTreeNode treeNode) {
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
	
	public boolean rotateLeft(AvlTreeNode node) {
		AvlTreeNode tempNode;
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
	
	public boolean rotateRight(AvlTreeNode node) {
		AvlTreeNode tempNode;
		
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
		public void inOrder(AvlTreeNode root) 
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
			

		public int degree(AvlTreeNode treeNode) {
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

		public boolean isComplete() {
			if(root.equals(EMPTY))
			{
				throw new NoSuchElementException();
			}
			treeQueue.enQueue(root);
			AvlTreeNode treeNode;
			
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

		public boolean isRoot(AvlTreeNode treeNode) {
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

		public boolean isParent(AvlTreeNode treeNode) {
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

		public boolean isChild(AvlTreeNode treeNode) {
			if(root.equals(EMPTY))
			{
				throw new NoSuchElementException();
			}
			System.out.println("This is the parent"+treeNode.getParent().getData());
			if(!treeNode.getParent().isEMPTY())
			{
				return true;
			}
			return false;
		}

		public boolean isLeaf(AvlTreeNode treeNode) {
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
	
	public static void main(String args[]) {
		AvlTreeInt tree = new AvlTreeInt();
		
		if(tree.isEmpty()==true) {
			System.out.println("tree is empty");
		}
		tree.add(3);
		System.out.println(tree.isRoot(tree.getRoot()));
		
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		tree.add(6);
		System.out.println(tree.isChild(tree.getRoot()));
		System.out.println(tree.isRoot(tree.locateNode(tree.getRoot(), 6)));
		System.out.println(tree.isChild(tree.getRoot().getRight()));
		tree.add(23);
		System.out.println("//////////////////////");

		System.out.println("root"+tree.getRoot().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("left height:"+tree.height(tree.getRoot().getRight()));
		System.out.println("//////////////////////");
		
		tree.add(44);
		System.out.println("added 44");
		System.out.println("check balance:"+ tree.checkBalance(tree.getRoot()));
		
		System.out.println(tree.getRoot().getData());
		System.out.println("/\\");
		System.out.println(tree.getRoot().getLeft().getData()+" "+tree.getRoot().getRight().getData());
		System.out.println("/\\/\\\\");
		System.out.println("X X X"+tree.getRoot().getRight().getRight().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("left height:"+tree.height(tree.getRoot().getLeft()));
		System.out.println("right height:"+tree.height(tree.getRoot().getRight()));
		System.out.println("//////////////////////");
		
		tree.add(1);
		System.out.println("check balance:"+ tree.checkBalance(tree.getRoot()));

		System.out.println("root data: " + tree.getRoot().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("left height:"+tree.height(tree.getRoot().getLeft()));
		System.out.println("right height:"+tree.height(tree.getRoot().getRight()));
		System.out.println("//////////////////////");

		tree.add(4);
		
		System.out.println(tree.getRoot().getData());
		System.out.println("/\\");
		System.out.println(tree.getRoot().getLeft().getData()+" "+tree.getRoot().getRight().getData());
		System.out.println("/\\/\\");
		System.out.println(tree.getRoot().getLeft().getLeft().getData()+ " " + tree.getRoot().getLeft().getRight().getData() + " X"+tree.getRoot().getRight().getRight().getData());
		
		tree.add(5);
		
		System.out.println(tree.checkBalance(tree.getRoot()));
		
		
		tree.add(7);
		tree.add(8);
		tree.add(9);
		
		System.out.println("locatenode 9 ->" + tree.locateNode(tree.getRoot(), 9).getData()+" and parent -> " + tree.locateNode(tree.getRoot(), 8).getParent().getData());
		System.out.println("root data: " + tree.getRoot().getData());
		System.out.println("root left data: " + tree.getRoot().getLeft().getData());
		System.out.println("root right data: " + tree.getRoot().getRight().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		System.out.println("//////////////////////");
		
		tree.remove(8);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());

		tree.remove(9);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());

		tree.remove(7);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());

		tree.remove(5);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		
		tree.remove(4);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		
		tree.remove(6);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		
		System.gc();

	}
	
	

	
}