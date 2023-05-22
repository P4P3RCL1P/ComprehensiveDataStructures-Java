package edu.sru.thangiah.datastructures.generic.tree.redblacktree;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.AbstractTreeGeneric;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.StackArrayGeneric;
import edu.sru.thangiah.datastructures.generic.tree.avltree.AvlTreeNodeGeneric;
import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.*;


/*
 * Generic implementation for an RB tree which allows the user to create instances with any data type.
 */

/**
 * <p>Title: RedBlackTreeGeneric</p>
 *
 * <p>Description: </p>
 * Generic implementation for an Red Black tree which allows the user to create instances with any data type.
 * Note that a Red Black Tree tree is a self-balancing tree which checks the colors of the nodes in the subtrees to ensure equal distancing of nodes and minimal search time
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class RedBlackTreeGeneric<T extends Comparable<? super T>> extends AbstractTreeGeneric<T> {
	
	/**
	 * Pointer variable for the root node
	 */
	private RedBlackTreeNodeGeneric root;
	/**
	 * Variable used to store the number of nodes in a tree
	 */
	private int count;
	/**
	 * Empty node used to compare and check for null values
	 */
	private static final RedBlackTreeNodeGeneric EMPTY = new RedBlackTreeNodeGeneric(null);
	/**
	 * Stack used for in/pre/post order traversal
	 */
	private StackArrayGeneric<RedBlackTreeNodeGeneric<T>> treeStack;
	/**
	 * Stack used specifically for post order traversal
	 */
	private StackArrayGeneric<RedBlackTreeNodeGeneric<T>> treeStackPostOrder;
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<RedBlackTreeNodeGeneric<T>> treeQueue;

	public RedBlackTreeGeneric() {
		
		root = new RedBlackTreeNodeGeneric();
		count = 0;
		treeStack = new StackArrayGeneric<RedBlackTreeNodeGeneric<T>>();
		treeQueue = new QueueArrayGeneric<RedBlackTreeNodeGeneric<T>>();
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

	public RedBlackTreeNodeGeneric getRoot() {
		return root;
	}
	
	/**
	 * adds a value to the red black tree, and traverses up the tree from that value to account for the cases
	 * @param value generic value being added to the tree
	 * @return true if functional
	 */
	@Override
	public boolean add(T value) {
		RedBlackTreeNodeGeneric<T> newNode = new RedBlackTreeNodeGeneric<T>(value);
		if(this.isEmpty())
		{
			root = newNode;
			newNode.setColor(true);
			count++;
			return true;
		} 
		
		RedBlackTreeNodeGeneric<T> nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(!this.isEmpty())
			{
				RedBlackTreeNodeGeneric<T> insertLocation = locateNode(root,value);
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
				
				this.adjustColor(newNode);
			}
			count++; 
			return true;
		}
		return false;
	}
	
	/**
	 * checks if the node has an uncle in the tree 
	 * @param root root node of the tree
	 * @param node the node being tested if there is an uncle
	 * @return true if uncle exists
	 */
	public boolean checkUncle(RedBlackTreeNodeGeneric<T> root, RedBlackTreeNodeGeneric<T> node) {
		if(node==root) {
			return false;
		}else if(node.getParent()==root) {
			return false;
		}else {
			if(node.getParent().getParent().getLeft().isEmpty()) {
				return false;
			}else if(node.getParent().getParent().getRight().isEmpty()) {
				return false;
			}else {
				return true;
			}
		}
	}
	
	/*
	 * inspiration from https://www.geeksforgeeks.org/red-black-tree-set-2-insert/
	 * This method adjust the color of the node upon addition in order to account for the different 
	 * colors and cases of the methods that are getting replaced
	 */
	/**
	 * this method is called from add to account for the different cases in the tree to retain balance and coloring
	 * @param node traversing up
	 * @return true if reaching root or the parent is the root, otherwise false if failing
	 */
	public boolean adjustColor(RedBlackTreeNodeGeneric<T> node) {
		
		if(node == root) {
			node.setColor(true);
			return true;
		}else if (node.getParent()==root) {
			getRoot().setColor(true);
			return true;
		}else if(node.getParent().getColor()!=true) {
			//if the node is red and the parent is red
			if(!this.checkUncle(root, node)) { //if the node does not have an uncle
				T data = node.getData();
				T dataParent = (T) node.getParent().getData();
				T dataGrandparent = (T) node.getParent().getParent().getData();
				int[] values = {data.compareTo(dataParent),dataParent.compareTo(dataGrandparent)};
				if(values[0]<0&&values[1]<0) {
					//if data is less than parent and parent is less than grandparent left left case
					leftLeft(node.getParent().getParent());
					boolean color=node.getParent().getColor();
					node.getParent().setColor(node.getParent().getRight().getColor());
					node.getParent().getRight().setColor(color);
				}else if(values[0]>0&&values[1]<0){
					//data is greater than parent and parent is less than grandparent left right
					leftRight(node.getParent().getParent());
					boolean color=node.getLeft().getColor();
					node.getLeft().setColor(node.getColor());;
					node.getRight().setColor(node.getColor());
				}else if(values[0]>0&&values[1]>0) {
					//data is greater than parent and parent is greater than grandparent right right case
					rightRight(node.getParent().getParent());
					boolean color=node.getParent().getColor();
					node.getParent().setColor(node.getParent().getLeft().getColor());
					node.getParent().getLeft().setColor(color);	
				}else if(values[0]<0&&values[1]>0) {
					//data is less than parent and parent is greater than grandparent right left
					rightLeft(node.getParent().getParent());
					boolean color=node.getLeft().getColor();
					node.getLeft().setColor(node.getColor());
					node.getRight().setColor(node.getColor());
				} 
			} else { //the node has an uncle
				if(node.getParent().getParent().getLeft()==node.getParent()) {
					//if the node's uncle is the right
					if(node.getParent().getParent().getRight().getColor()==false) {
						node.getParent().setColor(true);
						node.getParent().getParent().getRight().setColor(true);
					}else {
						//right uncle is black = cases
						T data = node.getData();
						T dataParent = (T) node.getParent().getData();
						T dataGrandparent = (T) node.getParent().getParent().getData();
						int[] values = {data.compareTo(dataParent),dataParent.compareTo(dataGrandparent)};
						if(values[0]<0&&values[1]<0) {
							//if data is less than parent and parent is less than grandparent left left case
							leftLeft(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getRight().getColor());
							node.getParent().getRight().setColor(color);
						}else if(values[0]>0&&values[1]<0){
							//data is greater than parent and parent is less than grandparent left right
							leftRight(node.getParent().getParent());
							boolean color=node.getLeft().getColor();
							node.getLeft().setColor(node.getColor());
							node.getRight().setColor(node.getColor());
						}else if(values[0]>0&&values[1]>0) {
							//data is greater than parent and parent is greater than grandparent right right case
							rightRight(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getLeft().getColor());
							node.getParent().getLeft().setColor(color);
						}else if(values[0]<0&&values[1]>0) {
							//data is less than parent and parent is greater than grandparent right left
							rightLeft(node.getParent().getParent());
							boolean color=node.getLeft().getColor();
							node.getLeft().setColor(node.getColor());
							node.getRight().setColor(node.getColor());
						}
					}
				}else {
					//node's uncle is on the left
					if(node.getParent().getParent().getLeft().getColor()==false) {
						node.getParent().setColor(true);
						node.getParent().getParent().getLeft().setColor(true);
					}else {
						//right uncle is black = cases
						T data = node.getData();
						T dataParent = (T) node.getParent().getData();
						T dataGrandparent = (T) node.getParent().getParent().getData();
						int[] values = {data.compareTo(dataParent),dataParent.compareTo(dataGrandparent)};
						if(values[0]<0&&values[1]<0) {
							//if data is less than parent and parent is less than grandparent left left case
							leftLeft(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getRight().getColor());
							node.getParent().getRight().setColor(color);
						}else if(values[0]>0&&values[1]<0){
							//data is greater than parent and parent is less than grandparent left right
							leftRight(node.getParent().getParent());
							boolean color=node.getLeft().getColor();
							node.getLeft().setColor(node.getColor());;
							node.getRight().setColor(node.getColor());
						}else if(values[0]>0&&values[1]>0) {
							//data is greater than parent and parent is greater than grandparent right right case
							rightRight(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getLeft().getColor());
							node.getParent().getLeft().setColor(color);							node.setColor(color);
						}else if(values[0]<0&&values[1]>0) {
							//data is less than parent and parent is greater than grandparent right left
							rightLeft(node.getParent().getParent());
							boolean color=node.getLeft().getColor();
							node.getLeft().setColor(node.getColor());
							node.getRight().setColor(node.getColor());
						}
					}
				}
			}
		}
		getRoot().setColor(true);

		return true;
		
	}
	
	/*
	 * this method takes in the top node of a left left rotate
	 * and turns it into the right node for the middle node
	 * and the middle node's right children become the top
	 * node's left children to maintain the height consistency
	 * of the tree
	 */
	
	public boolean leftLeft(RedBlackTreeNodeGeneric node) {
		System.out.println("left left");

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
	
	public boolean leftRight(RedBlackTreeNodeGeneric node) {
		
		System.out.println("left right");
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
	
	public boolean rightRight(RedBlackTreeNodeGeneric node) {
		
		System.out.println("right right");
		
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
	
	public boolean rightLeft(RedBlackTreeNodeGeneric node) {
		
		System.out.println(" right left");

		
		rotateRight(node.getRight());
		rotateLeft(node);
		
		return true;
	}
	
	/*
	 * credit to: https://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/?ref=lbp
	 */
	/**
	 * this node words to perform a recoloring of nodes upon deletion, and recursively calls itself when needed
	 * in accordance with the cases to keep balances and colors
	 * @param node the red black node that is being called upon when traversing up the tree
	 */
	
	public void fixDelColor(RedBlackTreeNodeGeneric<T> node){
		System.out.println(node.getData()+" " + node.getParent().getData());
        while(node!=root && node.getColor() == true){ 
        	T nodeData = node.getData();
			T parentData = node.getData();
			if(nodeData.compareTo(parentData)<0) {
            	RedBlackTreeNodeGeneric<T> temp = node.getParent().getRight();
                if(temp.getColor() == false){
                    temp.setColor(true);
                    node.getParent().setColor(false);
                    rotateLeft(node.getParent());
                    temp = node.getParent().getRight();
                }
                if(temp.getLeft().getColor() == true && temp.getRight().getColor() == true){
                    temp.setColor(false);
                    node = node.getParent();
                    continue;
                }
                else if(temp.getRight().getColor() == true){
                    temp.getLeft().setColor(true);
                    temp.setColor(false);
                    rotateRight(temp);
                    temp = node.getParent().getRight();
                }
                if(temp.getRight().getColor() == false){
                	temp.setColor(node.getParent().getColor());
                    node.getParent().setColor(true); 
                    temp.getRight().setColor(true);
                    rotateLeft(node.getParent());
                    node = root;
                }
            }else{
            	RedBlackTreeNodeGeneric<T> temp = node.getParent().getLeft();
                if(temp.getColor() == false){
                	temp.setColor(true);
                    node.getParent().setColor(false);
                    rotateRight(node.getParent());
                    temp = node.getParent().getLeft();
                }
                if(temp.getRight().getColor() == true && temp.getLeft().getColor() == true){
                    temp.setColor(false);
                    node = node.getParent();
                    continue;
                }
                else if(temp.getLeft().getColor() == true){
                	temp.getRight().setColor(true);
                    temp.setColor(false);
                    rotateLeft(temp);
                    temp = node.getParent().getLeft();
                }
                if(temp.getParent().getColor() == false){
                    temp.setColor(node.getParent().getColor());;
                    node.getParent().setColor(true);
                    temp.getLeft().setColor(false);
                    rotateRight(node.getParent());
                    node = root;
                }
            }
        }
        node.setColor(true); 
    }
	
	/*
	 * this method takes in the top node of a left left rotate
	 * and turns it into the right node for the middle node
	 * and the middle node's right children become the top
	 * node's left children to maintain the height consistency
	 * of the tree
	 */
	
	@Override
	public boolean contains(T data) {
		RedBlackTreeNodeGeneric newNode = new RedBlackTreeNodeGeneric(data);
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
	public T deleteLeaf(RedBlackTreeNodeGeneric<T> deleteNode)
	{
		System.out.println("deleting leaf");
		T value;
		RedBlackTreeNodeGeneric<T> leaf;
		
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
			RedBlackTreeNodeGeneric<T> x = leaf.getParent();
			leaf = EMPTY;
			//recolor??!?
			return value;
		}
		//leaf is on right of tree
		else
		{
			leaf.getParent().setRight(EMPTY);
			RedBlackTreeNodeGeneric<T> x = leaf.getParent();
			leaf = EMPTY;
			//ascendRemoveTree(x);
			return value;
		}
	}
	
	/**
	 * Helper function for remove method which deletes a node with only one child
	 * @param deleteNode - Node to be deleted
	 * @return The data value of the node deleted
	 */
	public T deleteOneChild(RedBlackTreeNodeGeneric<T> deleteNode)
	{
		System.out.println("deleting one child");
		T value;
		RedBlackTreeNodeGeneric<T> parent;
		parent = deleteNode;
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
	public T deleteTwoChildren(RedBlackTreeNodeGeneric<T> deleteNode)
	{
		RedBlackTreeNodeGeneric<T> successor;
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
	
	/**
	 * Finds the successor (Next node in inorder traversal) for a given tree/subtree
	 * @param root - The specific node which we are finding the successor for
	 * @return The node which is the successor of the passed parameter node
	 */
	public RedBlackTreeNodeGeneric<T> successor(RedBlackTreeNodeGeneric<T> root)
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
		RedBlackTreeNodeGeneric<T> result = root.getRight();
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
	public RedBlackTreeNodeGeneric<T> getLargest(RedBlackTreeNodeGeneric<T> root)
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
	
	/**
	 * recursive method for getting the smallest node 
	 * @param root - The root node for a tree or subtree
	 * @return  The node which has the smallest data value
	 */
	public RedBlackTreeNodeGeneric<T> getSmallest(RedBlackTreeNodeGeneric<T> root)
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
	
	/**
	 * Method for getting the second largest node in a tree
	 * @param root - The root node for a tree or subtree
	 * @return The node which is the second largest in the tree/subtree
	 */
	public RedBlackTreeNodeGeneric<T> getSecondLargest(RedBlackTreeNodeGeneric<T> root)
	{
        //we are only dealing with a binary tree w/ 1 node
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
	public int height(RedBlackTreeNodeGeneric<T> treeNode) {
		
		if(treeNode.isEmpty())
		{
			return 0;
		}
		
		if(treeNode.isEMPTY()) {
			return 0;
		}
		
		//we can use recursion to find the maximum depth
		//of a binary tree. We use the Math.max method
		//which parses the leftmost/rightmost nodes
		//src: Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
		//int maxDepth = 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
		
		return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
	}
	
	/**
	 * Finds the number of nodes in a tree
	 * @return The number of nodes in a tree
	 */
	
	public int nodeCount() {
		return count;
	}

	@Override
	public boolean insert(T value) {
		RedBlackTreeNodeGeneric<T> newNode = new RedBlackTreeNodeGeneric<T>(value);
		if(this.isEmpty())
		{
			root = newNode;
			count++;
			return true;
		} 
		
		RedBlackTreeNodeGeneric<T> nodeExists = search(value);
		//Search for node and if doesn't exist then we insert the value
		if(nodeExists == null)
		{
			if(!this.isEmpty())
			{
				RedBlackTreeNodeGeneric<T> insertLocation = locateNode(root,value);
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
				this.adjustColor(newNode);
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
		RedBlackTreeNodeGeneric<T> deleteNode = locateNode(root, value);
		System.out.println("delete node data" + deleteNode.getData());
		System.out.println("compared to " + value + " is " + (deleteNode.getData().compareTo(value) == 0));
		//ensure the value we are searching for is in the bst
		if(deleteNode.getData().compareTo(value) == 0)
		{
			if(!deleteNode.getLeft().isEmpty() || !deleteNode.getRight().isEmpty())
			{
				if(!deleteNode.getLeft().isEmpty() && !deleteNode.getRight().isEmpty())
				{
					System.out.println("twochildren");
					value = deleteTwoChildren(deleteNode);
					deleteNode.clearNode();
					count--;
					return value;
				}
				//case 2: There is one child
				System.out.println("one child");
				RedBlackTreeNodeGeneric nodeToFix=this.successor(deleteNode);
				value = deleteOneChild(deleteNode);
				//fixDelColor(locateNode(root, value));
				if(!nodeToFix.isEmpty()) {
					fixDelColor(nodeToFix);
				}
				deleteNode.clearNode();
				count--;
				return value;
				
			}
			//Case 3: Leaf node
			else
			{
				boolean test = true;
				if(deleteNode.getColor()==false) {
					test=false;
				}
				value = deleteLeaf(deleteNode);
				if(test==false||locateNode(root, value).getColor()==false) {
					locateNode(root, value).setColor(true);
				}else {
					fixDelColor(locateNode(root, value));
				}
				
				deleteNode.clearNode();
				count--;
				return value;
			}
		}	
		return null;
	}
	
	/**
	 * Finds a given node within a red black tree
	 * @param root - The root node of the tree/subtree
	 * @param data - The value to be searched for in the tree/subtree
	 * @return The node which has been found in the tree/subtree
	 */
	public RedBlackTreeNodeGeneric<T> locateNode(RedBlackTreeNodeGeneric<T> root, T data){
		
		T rootValue;
		RedBlackTreeNodeGeneric<T> child = root;
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
	
	/**
	 * Finds a given node within an RB tree
	 * @param value - The value to be searched for in the tree/subtree
	 * @return The node which has been found in the tree/subtree
	 */

	public RedBlackTreeNodeGeneric<T> search(T value) {
		RedBlackTreeNodeGeneric<T> nodeLoc;
		nodeLoc = locateNode(this.root, value);
		
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

		RedBlackTreeNodeGeneric temp = root;
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

		RedBlackTreeNodeGeneric temp = root;
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
	
	public boolean rotateLeft(RedBlackTreeNodeGeneric<T> node) {
		RedBlackTreeNodeGeneric<T> tempNode;
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
	
	public boolean rotateRight(RedBlackTreeNodeGeneric<T> node) {
		RedBlackTreeNodeGeneric<T> tempNode;
		
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

	public int degree(RedBlackTreeNodeGeneric<T> treeNode) {
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
		RedBlackTreeNodeGeneric<T> treeNode;
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

	public boolean isRoot(RedBlackTreeNodeGeneric<T> treeNode) {
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

	public boolean isParent(RedBlackTreeNodeGeneric<T> treeNode) {
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

	public boolean isChild(RedBlackTreeNodeGeneric<T> treeNode) {
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

	public boolean isLeaf(RedBlackTreeNodeGeneric<T> treeNode) {
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
		RedBlackTreeGeneric<Integer> tree = new RedBlackTreeGeneric<Integer>();
		
		System.out.println(tree.isEmpty());
		tree.add(3);
		
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		tree.add(6);
		System.out.println("root color "+tree.getRoot().getColor());
		System.out.println("second node color" + tree.getRoot().getRight().getColor());
		tree.add(23);
		
		System.out.println("root color "+tree.getRoot().getColor());
		System.out.println("second node color" + tree.getRoot().getRight().getColor());
		System.out.println("other second color" + tree.getRoot().getLeft().getColor());
		
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
		tree.add(8);
		
		System.out.println("locatenode 9 ->" + tree.locateNode(tree.getRoot(), 9).getData()+" and parent -> " + tree.locateNode(tree.getRoot(), 8).getParent().getData());
		System.out.println("root data: " + tree.getRoot().getData());
		System.out.println("root left data: " + tree.getRoot().getLeft().getData());
		System.out.println("root right data: " + tree.getRoot().getRight().getData());
		System.out.println("tree height:" + tree.height(tree.getRoot()));
		System.out.println("node count" + tree.nodeCount());
		System.out.println("//////////////////////");
		
		System.out.println(tree.height(tree.getRoot()));
		System.out.println(tree.degree(tree.getRoot().getRight()));
		System.out.println(tree.isRoot(tree.getRoot().getLeft()));
		System.out.println(tree.isComplete());
		System.out.println(tree.isIncomplete());
		System.out.println("//////////////////////");

		System.out.println(tree.height(tree.getRoot()));
		System.out.println(tree.degree(tree.getRoot().getRight()));
		System.out.println(tree.isComplete());
		System.out.println(tree.isIncomplete());
		
		RedBlackTreeGeneric<Integer> tree2 = new RedBlackTreeGeneric();
		tree2.add(5);
		System.out.println("root should be true" + 	tree2.getRoot().getColor());
		tree2.add(6);
		System.out.println("root should be true" + 	tree2.getRoot().getColor());
		System.out.println("second should be false" + tree2.getRoot().getRight().getColor());
		tree2.add(7);
		System.out.println("root should be 6" + tree2.getRoot().getData());
		System.out.println("the color of 6 should be true" + tree2.getRoot().getColor());
		System.out.println("left and right should be false" + tree2.getRoot().getLeft().getColor() + tree2.getRoot().getRight().getColor());
		tree2.add(8);
		System.out.println("root should be 6" + tree2.getRoot().getData());
		System.out.println("the color of 6 should be true" + tree2.getRoot().getColor());
		System.out.println("left and right should be true" + tree2.getRoot().getLeft().getColor() + tree2.getRoot().getRight().getColor());
		
		System.gc();

	}


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