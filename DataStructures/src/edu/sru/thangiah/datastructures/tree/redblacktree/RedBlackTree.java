package edu.sru.thangiah.datastructures.tree.redblacktree;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.tree.binarytree.BinaryTreeNode;
import edu.sru.thangiah.datastructures.tree.redblacktree.RedBlackTreeNode;
import edu.sru.thangiah.datastructures.generic.tree.redblacktree.RedBlackTreeNodeGeneric;
import edu.sru.thangiah.datastructures.queue.QueueArray;
import edu.sru.thangiah.datastructures.stack.*;

/*
 * RedBlack tree made up of RedBlackTreeNode nodes
 * Left child is smaller than root node, right child is larger than root node
 */
/**
 * <p>Title: RedBlackTree</p>
 *
 * <p>Description: </p>
 * Int implementation for an Red Black tree.
 * Note that a Red Black Tree tree is a self-balancing tree which checks the colors of the nodes in the subtrees to ensure equal distancing of nodes and minimal search time
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class RedBlackTree extends AbstractRedBlackTree{
	// root of the tree
	/**
	 * Pointer variable for the root node
	 */
	private RedBlackTreeNode root;
	// no of nodes in the tree
	/**
	 * Variable used to store the number of nodes in a tree
	 */
	private int count;
	/**
	 * Empty node used to compare and check for null values
	 */
	private static final RedBlackTreeNode EMPTY = new RedBlackTreeNode(-1);
	/**
	 * stack used for tree traversals
	 */
	private StackArray treeStack;
	/**
	 * queue used for tree traversals
	 */
	private QueueArray treeQueue;

	public RedBlackTree() {
		// root points to the empty node
		root = EMPTY;
		count = 0;
		treeStack = new StackArray();
		treeQueue = new QueueArray();
	}

	public RedBlackTreeNode getRoot() {
		return root;
	}

	/*
	 * Check if RedBlack search tree is empty
	 */
	public boolean isEmpty() {
		if (root.getData() == -1) {
			return true;
		}
		return false;
	}

	/*
	 * Remove all the nodes from the RedBlack search tree
	 */
	public boolean clear() {
		root.clearNode();
		count = 0;
		return true;
	}

	public int height(RedBlackTreeNode treeNode) {
		if(treeNode.isEmpty())
		{
			return 0;
		}
		
		//we can use recursion to find the maximum depth
		//of a RedBlack tree. We use the Math.max method
		//which parses the leftmost/rightmost nodes
		//src: Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
		return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
		
	}
	
	@Override
	public int nodeCount() {
		return count;
	}
	

	//similar to locateNode, except only a value parameter is specified
	@Override
	public RedBlackTreeNode search(int value) {
		RedBlackTreeNode nodeLoc;
		nodeLoc = locateNode(this.root, value);
		
		while(nodeLoc.getData()!=value) {
			if(nodeLoc.getData() == value)
			{
				return nodeLoc;
			}
		}
		
		throw new NoSuchElementException();
	}

	/*
	 * method used to locate a node with a given value, or the insertion point
	 * for addition if the value is not in the tree
	 */
	public RedBlackTreeNode locateNode(RedBlackTreeNode root, int data) {
		int rootValue;
		RedBlackTreeNode child;

		//root = this.getRoot();
		rootValue = root.getData();

		// value found at root
		if (rootValue == data) {
			return root;
		}

		// look left if less-than, right if greater-than
		if (rootValue < data) {
			child = root.getRight();
		} else {
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
	 * Predecessor of a node in a RedBlack tree is the node
	 * with the next closest value on the left hand side of the tree 
	 */
	
	public RedBlackTreeNode predecessor(RedBlackTreeNode root, int data)
    {
		RedBlackTreeNode findLocation = locateNode(root, data);
        if(findLocation.getData() == -1)
        {
        	throw new NoSuchElementException();
        }
        RedBlackTreeNode predecessorNode = findLocation;
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
	 * Successor of a node in a RedBlack tree is the node
	 * with the next largest value on the right hand side of the tree 
	 */

	public RedBlackTreeNode successor(RedBlackTreeNode root) {
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		if(root.getRight().isEmpty())
		{
			return null;
		}
		RedBlackTreeNode result = root.getRight();
		while (!result.getLeft().isEmpty()) {
			result = result.getLeft();
		}
		return result;
	}
	
	@Override
	public boolean insert(int value) {
		return add(value);
	}

	/*
	 * Add node to the tree
	 */
	public boolean add(int data) {
		RedBlackTreeNode newNode = new RedBlackTreeNode(data);
		if (this.isEmpty()) { 
			
			root = newNode;
			newNode.setColor(true);
			count++;
			return true;
			
		} else {
			
			RedBlackTreeNode insertLocation = locateNode(root, data);
			int nodeData = insertLocation.getData();
			// The location returned is the successor or predecessor
			// of the to-be-inserted value
			if (nodeData < data) {
				insertLocation.setRight(newNode);
				newNode.setParent(insertLocation);
			} else {			
				insertLocation.setLeft(newNode);
				newNode.setParent(insertLocation);
			}
			
			this.adjustColor(newNode);
		}
		count++;
		return true;
	}
	
	/**
	 * checks if the node has an uncle in the tree 
	 * @param root root node of the tree
	 * @param node the node being tested if there is an uncle
	 * @return true if uncle exists
	 */
	public boolean checkUncle(RedBlackTreeNode root, RedBlackTreeNode node) {
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
	 * Different methods of recoloring based on what the situation is with the node (elaborated below)
	 * research credit to https://www.geeksforgeeks.org/red-black-tree-set-2-insert/
	 * This method adjust the color of the node upon addition in order to account for the different 
	 * colors and cases of the methods that are getting replaced
	 */
	/**
	 * this method is called from add to account for the different cases in the tree to retain balance and coloring
	 * @param node traversing up
	 * @return true if reaching root or the parent is the root, otherwise false if failing
	 */
	public boolean adjustColor(RedBlackTreeNode node) {
		
		if(node == root) {
			node.setColor(true);
			return true;
		}else if (node.getParent()==root) {
			getRoot().setColor(true);
			return true;
		}else if(node.getParent().getColor()!=true) {
			//if the node is red and the parent is red
			if(!this.checkUncle(root, node)) { //if the node does not have an uncle
				int data = node.getData();
				int dataParent = node.getParent().getData();
				int dataGrandparent = node.getParent().getParent().getData();
				if(data<dataParent&&dataParent<dataGrandparent) {
					//if data is less than parent and parent is less than grandparent left left case
					leftLeft(node.getParent().getParent());
					boolean color=node.getParent().getColor();
					node.getParent().setColor(node.getParent().getRight().getColor());
					node.getParent().getRight().setColor(color);
				}else if(data>dataParent&&dataParent<dataGrandparent){
					//data is greater than parent and parent is less than grandparent left right
					leftRight(node.getParent().getParent());
					boolean color=node.getLeft().getColor();
					node.getLeft().setColor(node.getColor());;
					node.getRight().setColor(node.getColor());
				}else if(data>dataParent&&dataParent>dataGrandparent) {
					//data is greater than parent and parent is greater than grandparent right right case
					rightRight(node.getParent().getParent());
					boolean color=node.getParent().getColor();
					node.getParent().setColor(node.getParent().getLeft().getColor());
					node.getParent().getLeft().setColor(color);							node.setColor(color);
				}else if(data<dataParent&&dataParent>dataGrandparent) {
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
						int data = node.getData();
						int dataParent = node.getParent().getData();
						int dataGrandparent = node.getParent().getParent().getData();
						if(data<dataParent&&dataParent<dataGrandparent) {
							//if data is less than parent and parent is less than grandparent left left case
							leftLeft(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getRight().getColor());
							node.getParent().getRight().setColor(color);
						}else if(data>dataParent&&dataParent<dataGrandparent){
							//data is greater than parent and parent is less than grandparent left right
							leftRight(node.getParent().getParent());
							boolean color=node.getLeft().getColor();
							node.getLeft().setColor(node.getColor());;
							node.getRight().setColor(node.getColor());
						}else if(data>dataParent&&dataParent>dataGrandparent) {
							//data is greater than parent and parent is greater than grandparent right right case
							rightRight(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getLeft().getColor());
							node.getParent().getLeft().setColor(color);							node.setColor(color);
						}else if(data<dataParent&&dataParent>dataGrandparent) {
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
						int data = node.getData();
						int dataParent = node.getParent().getData();
						int dataGrandparent = node.getParent().getParent().getData();
						if(data<dataParent&&dataParent<dataGrandparent) {
							//if data is less than parent and parent is less than grandparent left left case
							leftLeft(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getRight().getColor());
							node.getParent().getRight().setColor(color);
						}else if(data>dataParent&&dataParent<dataGrandparent){
							//data is greater than parent and parent is less than grandparent left right
							leftRight(node.getParent().getParent());
							boolean color=node.getLeft().getColor();
							node.getLeft().setColor(node.getColor());;
							node.getRight().setColor(node.getColor());
						}else if(data>dataParent&&dataParent>dataGrandparent) {
							//data is greater than parent and parent is greater than grandparent right right case
							rightRight(node.getParent().getParent());
							boolean color=node.getParent().getColor();
							node.getParent().setColor(node.getParent().getLeft().getColor());
							node.getParent().getLeft().setColor(color);							node.setColor(color);
						}else if(data<dataParent&&dataParent>dataGrandparent) {
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
	
	public boolean leftLeft(RedBlackTreeNode node) {

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
	
	public boolean leftRight(RedBlackTreeNode node) {
		
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
	
	public boolean rightRight(RedBlackTreeNode node) {
		
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
	
	public boolean rightLeft(RedBlackTreeNode node) {
		
		rotateRight(node.getRight());
		rotateLeft(node);
		
		return true;
		
	}
	
	
	@Override
	public int remove(int value) {
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		//find the root to use with the locate method (could swap to just using root)
		RedBlackTreeNode deleteNode = locateNode(root, value);
		
		if(deleteNode.getData() == value){
			//case 1: base condition for node w/ no children
			if(!deleteNode.getLeft().isEmpty() || !deleteNode.getRight().isEmpty()){
				
				if(!deleteNode.getLeft().isEmpty() && !deleteNode.getRight().isEmpty()){
					value = deleteTwoChildren(deleteNode);
					count--;
					return value;
				}
			
				value = deleteOneChild(deleteNode);
				deleteNode.clearNode();
				count--;
				return value;
			}
		
			//case 3: there is one child
			else {
				value = deleteLeaf(deleteNode);
				count--;
				return value;
			}
		}
		return -1;
	}
	
	public int deleteLeaf(RedBlackTreeNode deleteNode)
	{
		int value;
		RedBlackTreeNode leaf;
		
		leaf = root;
		value = leaf.getData();
		
		//case 1: leaf is root
		if(root == leaf)
		{
			root = EMPTY;
			leaf = EMPTY;
			return value;
		}
		
		//case 2: leaf is to the right or left of parent node
		if(leaf.getParent().getLeft() == leaf){
			leaf.getParent().setLeft(EMPTY);
			leaf = EMPTY;
			return value;
		}
		//leaf is on right of tree
		else{
			leaf.getParent().setRight(EMPTY);
			leaf = EMPTY;
			return value;
		}
			
	}
	
	
	public int deleteOneChild(RedBlackTreeNode deleteNode){
		
		int val;
		RedBlackTreeNode parent;
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
		else{
			//case where root is node to be deleted
			if(parent == root){
				root=root.getRight();
				root.setParent(EMPTY);
				return val;
			}
			//root is not node to be deleted
			else{
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
	public int deleteTwoChildren(RedBlackTreeNode deleteNode)
	{
		RedBlackTreeNode successor;
		int value;
		value = deleteNode.getData();
		
		//node with two children is root
		if(deleteNode == root){
			successor = successor(root);
			successor.setLeft(deleteNode.getLeft());
			deleteNode.getLeft().setParent(successor);
			
			//case when successor is not next to node to be deleted
			if(deleteNode.getRight() != successor){
				//case for when successor has children that need to be linked
				if(!successor.getRight().isEmpty()) {
					successor.getParent().setLeft(successor.getRight());
					successor.getRight().setParent(successor.getParent());
				}
				else{
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
		else{
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
	public RedBlackTreeNode getLargest(RedBlackTreeNode root) {
        if (!root.getRight().isEMPTY()) {
            return getLargest(root.getRight());
        }
        return root;
    }
	
	public RedBlackTreeNode getSmallest(RedBlackTreeNode root) {
        if (!root.getLeft().isEMPTY()) {
            return getSmallest(root.getLeft());
        }
        return root;
    }
	
	/*public int getSecondLargest(RedBlackTreeNode root) {
		 if (!this.isEmpty()) {
	            
	            RedBlackTreeNode secondLarge = getLargest(root);
	            secondLarge = predecessor(secondLarge, secondLarge.getData());
	            return secondLarge.getData();
	        }     
	        return -1;
	}
	
	*/
	
	public RedBlackTreeNode secondLargest1(RedBlackTreeNode root) {
		RedBlackTreeNode temp;
		RedBlackTreeNode ptr;
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
	
	public RedBlackTreeNode getSecondSmallest(RedBlackTreeNode root) {
        if (!this.isEmpty()) {
            
         //get the largest number in the tree
          RedBlackTreeNode tmp = getSmallest(root);
          //get the predecessor of the largest number
           tmp = successor(root);
            return tmp;
        }     
        return null;
 }

	public RedBlackTreeNode secondLargest(RedBlackTreeNode root) {
		RedBlackTreeNode temp;
		RedBlackTreeNode ptr;
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
	
	//similar to getLargest except we return the data of the max node
	@Override
	public int findMax(RedBlackTreeNode root) {
		RedBlackTreeNode nodeLoc = getLargest(root);
		return nodeLoc.getData();
	}
	//similar to getSmallest except we return the data of the min node
	@Override
	public int findMin(RedBlackTreeNode root) {
		RedBlackTreeNode nodeLoc = getSmallest(root);
		return nodeLoc.getData();
	}

	@Override
	public boolean rotateLeft(RedBlackTreeNode node) {
		RedBlackTreeNode tempNode;
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

	public boolean rotateRight(RedBlackTreeNode node) {
		RedBlackTreeNode tempNode;
		
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
	public void inOrder(RedBlackTreeNode root) 
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
		System.out.printf("%d ", treeStack.pop());
		
		//condition for when there is no
		//left-most node (we go right)
		if(!root.getRight().isEmpty())
		{
			inOrder(root.getRight());
		}
		treeStack.clear();
	}
	public void traverseInOrder(RedBlackTreeNode root)
	{
		//in future
	}
	//iterative preorder traversal using a stack
	public void preOrder(RedBlackTreeNode root)
	{
		//in future
	}
	public void postOrder(RedBlackTreeNode root)
	{
		//in future
	}
	
	public void levelOrder(RedBlackTreeNode root)
	{
		//in future
	}
	
	@Override
	public RedBlackTreeNode getSecondLargest(RedBlackTreeNode root) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String args[]) {

		RedBlackTree x = new RedBlackTree();
		RedBlackTreeNode tmp;
		System.out.println("Tree is empty:" + x.isEmpty());
		x.add(100);
		x.add(80);
		x.add(120);
		x.add(90);
		x.add(75);
		x.inOrder(x.getRoot());
		tmp = x.getLargest(x.getRoot());
		System.out.println("Largest is "+tmp.getData());
		tmp = x.secondLargest1(x.getRoot());
		System.out.println("Second largest is "+tmp.getData());
		
		System.out.println(x.getRoot().getLeft().getData());
		System.out.println(x.getRoot().getLeft().getColor());
		System.out.println(x.getRoot().getLeft().getData());
		System.out.println(x.getRoot().getLeft().getColor());
		
		System.out.println("rootcolor" + x.getRoot().getColor());
		System.out.println("rootLR colors " + x.getRoot().getLeft().getColor() + x.getRoot().getRight().getColor());
		
		System.out.println("rootLR colors " + x.getRoot().getLeft().getRight().getColor() + x.getRoot().getLeft().getLeft().getColor());

		
	}
}
