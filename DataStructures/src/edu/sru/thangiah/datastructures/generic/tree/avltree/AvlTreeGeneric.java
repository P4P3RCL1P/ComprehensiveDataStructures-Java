package edu.sru.thangiah.datastructures.generic.tree.avltree;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.TreeOpsInt;
import edu.sru.thangiah.datastructures.generic.AbstractTreeGeneric;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.StackArrayGeneric;
import edu.sru.thangiah.datastructures.generic.tree.avltree.AvlTreeNodeGeneric;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.*;

/*
 * Generic implementation for an AVL tree which allows the user to create instances with any data type.
 * Note that an AVL tree is a self-balancing tree which checks the height of subtrees to ensure that the left and right subtrees don't have a height greater than one
 */

/**
 * <p>Title: AvlTreeGeneric</p>
 *
 * <p>Description: </p>
 * Generic implementation for an AVL tree which allows the user to create instances with any data type.
 * Note that an AVL tree is a self-balancing tree which checks the height of subtrees to ensure that the left and right subtrees don't have a height greater than one
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class AvlTreeGeneric<T extends Comparable<? super T>> extends AbstractTreeGeneric<T> {
	/**
	 * Pointer variable for the root node
	 */
	private AvlTreeNodeGeneric root;

	/**
	 * Variable to store the number of nodes in the tree
	 */
	private int count;
	/**
	 * Empty tree used to test for uninitialized AVL trees
	 */
	private static final AvlTreeNodeGeneric EMPTY = new AvlTreeNodeGeneric(null);
	/**
	 * Stack used for in/pre/post order traversal
	 */
	private StackArrayGeneric<AvlTreeNodeGeneric<T>> treeStack;
	/**
	 * Stack used specifically for post order traversal
	 */
	private StackArrayGeneric<AvlTreeNodeGeneric<T>> treeStackPostOrder;
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<AvlTreeNodeGeneric<T>> treeQueue;
	
	// rotator is necessary for rotations if using redundant data because the rotate
	// methods
	// have no way to locate these nodes

	public AvlTreeGeneric() {
		
		root = new AvlTreeNodeGeneric();
		count = 0;
		treeStack = new StackArrayGeneric<AvlTreeNodeGeneric<T>>();
		treeQueue = new QueueArrayGeneric<AvlTreeNodeGeneric<T>>();
	}

	public boolean isEmpty()
	{
		if(root.getData() == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean clear() {
		// Clears the tree
		root = EMPTY;
		return true;
	}

	public AvlTreeNodeGeneric getRoot() {
		return root;
	}

	/**
	 * the intention of this method is to check the balance of both of the sides of the tree 
	 * to see if the two sides need to be balanced
	 * @param x
	 * @return Recursively calls height until either the tree needs to be balanced or doesn't
	 */
	
	public int checkBalance(AvlTreeNodeGeneric<T> x) {
		
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
	
	@Override
	public boolean add(T value) {
		AvlTreeNodeGeneric<T> newNode = new AvlTreeNodeGeneric<T>(value);
		if(this.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		} 
		
		AvlTreeNodeGeneric<T> nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(!this.isEmpty())
			{
				AvlTreeNodeGeneric<T> insertLocation = locateNode(root,value);
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
				
				//launching ascend to check for inbalance
				this.ascendTree(newNode);
			}
			count++;
			return true;
		}
		
		return false;
	}
	
	/**
	 * this method takes in a node at the bottom of the tree
	 * and works from the bottom up checking for where a tree
	 * may become unbalanced, and depending on the path that 
	 * it took, it performs one of the functions to rotate
	 * the tree and retain AVL balance
	 * 
	 *@return True upon successful completion of the method
	 */
	
	public boolean ascendTree(AvlTreeNodeGeneric<T> node) {
		
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
				
				}else if(this.checkBalance(node)<=-2) {
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
	 * Similar to ascendTree except now we remove a node and then similarly ascend up the tree until the properties of an AVL tree are satisfied
	 * @param node - node to be removed
	 * @return True upon successful completion of the method
	 */
	public boolean ascendRemoveTree(AvlTreeNodeGeneric<T> node) {

		if(node==root) {
			if(this.checkBalance(root)>=2) {
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
		}else{
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
	
	public boolean leftLeft(AvlTreeNodeGeneric node) {
		
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
	
	public boolean leftRight(AvlTreeNodeGeneric node) {
		
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
	
	public boolean rightRight(AvlTreeNodeGeneric node) {
		
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
	
	public boolean rightLeft(AvlTreeNodeGeneric node) {
		
		rotateRight(node.getRight());
		rotateLeft(node);
		
		return true;
	}
	
	@Override
	public boolean contains(T data) {
		AvlTreeNodeGeneric newNode = new AvlTreeNodeGeneric(data);
		newNode = locateNode(root, data);
		if (newNode.getData() == null) {
			newNode = null;
			return false;
		}
		return true;
	}
	/**
	 * Helper function for remove method which removes a leaf from the tree
	 * @param deleteNode - Node to be deleted
	 * @return The data value of the node which is deleted
	 */
	public T deleteLeaf(AvlTreeNodeGeneric<T> deleteNode)
	{
		T value;
		AvlTreeNodeGeneric<T> leaf;
		
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
			AvlTreeNodeGeneric<T> x = leaf.getParent();
			leaf = EMPTY;
			ascendRemoveTree(x);
			return value;
		}
		//leaf is on right of tree
		else
		{
			leaf.getParent().setRight(EMPTY);
			AvlTreeNodeGeneric<T> x = leaf.getParent();
			leaf = EMPTY;
			ascendRemoveTree(x);
			return value;
		}
	}
	/**
	 * Helper function for remove method which deletes a node with only one child
	 * @param deleteNode - Node to be deleted
	 * @return The data value of the node deleted
	 */
	public T deleteOneChild(AvlTreeNodeGeneric<T> deleteNode)
	{
		T value;
		AvlTreeNodeGeneric<T> parent = deleteNode;
		value = parent.getData();
		
		//check for which side child is on
		if(parent.getLeft()!=null)
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
	 * Helper function for remove method which deletes a node that has exactly two children
	 * @param deleteNode - node to be deleted
	 * @return The data value of the node which was deleted
	 */
	public T deleteTwoChildren(AvlTreeNodeGeneric<T> deleteNode)
	{
		AvlTreeNodeGeneric<T> successor;
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
			ascendRemoveTree(successor);
			return value;
		}
	}
	
	/**
	 * Finds the successor (Next node in inorder traversal) for a given tree/subtree
	 * @param root - The specific node which we are finding the successor for
	 * @return The node which is the successor of the passed parameter node
	 */
	public AvlTreeNodeGeneric<T> successor(AvlTreeNodeGeneric<T> root)
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
		AvlTreeNodeGeneric<T> result = root.getRight();
		while(!result.getLeft().isEmpty())
		{
			result = result.getLeft();
		}
		return result;
	}
	
	/**
	 * recursive method for getting the largest node 
	 * @param root - The root node for a tree or subtree
	 * @return  The node which has the largest data value
	 */
	public AvlTreeNodeGeneric<T> getLargest(AvlTreeNodeGeneric<T> root)
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
	/**
	 * recursive method for getting the smallest node 
	 * @param root - The root node for a tree or subtree
	 * @return  The node which has the smallest data value
	 */
	public AvlTreeNodeGeneric<T> getSmallest(AvlTreeNodeGeneric<T> root)
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
	/**
	 * Method for getting the second largest node in a tree
	 * @param root - The root node for a tree or subtree
	 * @return The node which is the second largest in the tree/subtree
	 */
	public AvlTreeNodeGeneric<T> getSecondLargest(AvlTreeNodeGeneric<T> root)
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
	
	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return -1;
	}
	/**
	 * Returns the height of a given tree
	 * @param treeNode - The root of a tree/subtree
	 * @return The count of total height among the tree/subtree
	 */
	public int height(AvlTreeNodeGeneric<T> treeNode) {
		if(treeNode.isEmpty())
		{
			return 0;
		}
		
		//we can use recursion to find the maximum depth
		//of a binary tree. We use the Math.max method
		//which parses the leftmost/rightmost nodes
		//src: Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
		//int maxDepth = 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
		
		return 1+Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
	}
	
	/**
	 * Finds the number of nodes in a tree
	 * @return The number of nodes in a tree
	 */
	@Override
	public int nodeCount() {

		return count;
	}

	@Override
	public boolean insert(T value) {
		AvlTreeNodeGeneric<T> newNode = new AvlTreeNodeGeneric<T>(value);
		if(this.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		} 
		
		AvlTreeNodeGeneric<T> nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(!this.isEmpty())
			{
				AvlTreeNodeGeneric<T> insertLocation = locateNode(root,value);
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
				this.ascendTree(newNode);
			}
			count++;
			return true;
		}
		return false;
	}

	@Override
	public T remove(T value) 
	{
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		//find the root to use with the locateNode method (could swap to using just root)
		AvlTreeNodeGeneric<T> deleteNode = locateNode(root, value);
		System.out.println("delete node data" + deleteNode.getData());
		System.out.println("compared to " + value + " is " + (deleteNode.getData().compareTo(value) == 0));
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
	 * Finds a given node within an AVL tree
	 * @param root - The root node of the tree/subtree
	 * @param data - The value to be searched for in the tree/subtree
	 * @return The node which has been found in the tree/subtree
	 */
	public AvlTreeNodeGeneric<T> locateNode(AvlTreeNodeGeneric<T> root, T data)
	{
		T rootValue;
		AvlTreeNodeGeneric<T> child = root;
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
	/**
	 * Finds a given node within an AVL tree
	 * @param value - The value to be searched for in the tree/subtree
	 * @return The node which has been found in the tree/subtree
	 */
	public AvlTreeNodeGeneric<T> search(T value) {
		AvlTreeNodeGeneric<T> nodeLoc;
		nodeLoc = locateNode(root, value);
		
		//we have found the node to search for
		if(nodeLoc.getData().compareTo(value) == 0)
		{
			return nodeLoc;
		}
		return null;
	}

	@Override
	public T findMax() {
		T data = (T) root.getData();
		
		if (this.isEmpty()) {
			return null;
		}

		if (root.getRight() == null) {
			return data;
		}

		AvlTreeNodeGeneric temp = root;
		while (temp.getRight() != null) {
			temp = temp.getRight();
		}
		data = (T) temp.getData();
		return data;
	}

	@Override
	public T findMin() {
		T data = (T) root.getData();

		if (this.isEmpty()) {
			return null;
		}

		if (root.getLeft() == null) {
			return data;
		}

		AvlTreeNodeGeneric temp = root;
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		data = (T) temp.getData();
		return data;
	}
	
	/*
	 * Unused
	 */
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean rotateLeft(AvlTreeNodeGeneric<T> node) {
		AvlTreeNodeGeneric<T> tempNode;
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
	
	public boolean rotateRight(AvlTreeNodeGeneric<T> node) {
		AvlTreeNodeGeneric<T> tempNode;
		
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
	
	@Override
	public T rotateLeft(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T rotateRight(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	public int degree(AvlTreeNodeGeneric<T> treeNode) {
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
	public boolean isComplete() {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		AvlTreeNodeGeneric<T> treeNode;
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

	public boolean isRoot(AvlTreeNodeGeneric<T> treeNode) {
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

	public boolean isParent(AvlTreeNodeGeneric<T> treeNode) {
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

	public boolean isChild(AvlTreeNodeGeneric<T> treeNode) {
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

	public boolean isLeaf(AvlTreeNodeGeneric<T> treeNode) {
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

	/**
	  * Main method
	  * @param args The command line arguments.
	  */  	
	public static void main(String args[]) {
		AvlTreeGeneric<Integer> tree = new AvlTreeGeneric<Integer>();
		
		System.out.println(tree.isEmpty());
		tree.add(3);
		
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		tree.add(6);
		tree.add(23);
		System.out.println("//////////////////////");

		
		System.out.println("root"+tree.getRoot().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("left height:"+tree.height(tree.getRoot().getRight()));
		System.out.println("//////////////////////");
		
		tree.add(44);
		
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("left height:"+tree.height(tree.getRoot().getLeft()));
		System.out.println("right height:"+tree.height(tree.getRoot().getRight()));
		System.out.println("//////////////////////");
		
		tree.add(1);

		System.out.println("root data: " + tree.getRoot().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("left height:"+tree.height(tree.getRoot().getLeft()));
		System.out.println("right height:"+tree.height(tree.getRoot().getRight()));
		System.out.println("//////////////////////");

		tree.add(4);
		tree.add(5);
		tree.add(7);
		tree.add(7);
		tree.add(8);
		
		System.out.println("locatenode 9 ->" + tree.locateNode(tree.getRoot(), 9).getData()+" and parent -> " + tree.locateNode(tree.getRoot(), 8).getParent().getData());
		System.out.println("root data: " + tree.getRoot().getData());
		System.out.println("root left data: " + tree.getRoot().getLeft().getData());
		System.out.println("root right data: " + tree.getRoot().getRight().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		System.out.println("//////////////////////");

		
		tree.remove(7);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		System.out.println("//////////////////////");

		tree.remove(8);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		System.out.println("//////////////////////");

		tree.remove(44);
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		System.out.println("//////////////////////");
		
		tree.remove(4);
		tree.remove(5);
		
		System.out.println("check balance: "+tree.checkBalance(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		System.out.println("//////////////////////");
		
		System.gc();

	}
	
	/*
	 * Unimplemented methods from treeops interface
	 */
	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isParent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}