package edu.sru.thangiah.datastructures.tree.generaltree;

import java.util.NoSuchElementException;
import java.util.Vector;

import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.generic.stack.StackArrayGeneric;
import edu.sru.thangiah.datastructures.generic.tree.binarytree.BinaryTreeNodeGeneric;

/**
 * <p>Title: General Tree</p>
 *
 * <p>Description: </p>
 * A general tree is a tree structure that allows for an arbitrary
 * number of children for a given node. A node can have zero or more
 * children. In this case, when calling a method such as degree which
 * returns the number of children for a given node we can get a return value
 * of zero or more. This is not a balanced tree structure given the framework
 * of the tree structure.
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class GeneralTree extends AbstractGeneralTree {
	
	/**
	 * root of the tree
	 */
	private GeneralTreeNode root;
	
	/**
	 * Variable to store the largest value within the general tree.
	 */
	GeneralTreeNode largest;

	/**
	 * Variable to store the second largest value within the general tree.
	 */
	GeneralTreeNode secondLargest;

	
	/**
	 * Variable to store the smallest value within the general tree.
	 */
	GeneralTreeNode smallest;
	
	/**
	 * Variable to store the second smallest value within the general tree
	 */
	GeneralTreeNode secondSmallest;
	
	
	/**
	 * no. of nodes in the tree
	 */
	private int count;
	
	
	
	/**
	 * empty binary search tree which is used for testing if a tree is completely empty
	 */
	private static final GeneralTreeNode EMPTY = new GeneralTreeNode(-1);
	
	/**
	 * Stack used for in/pre/post order traversal
	 */
	private StackArrayGeneric<GeneralTreeNode> treeStack;
	
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<GeneralTreeNode> treeQueue;
	
	public GeneralTree()
	{
		//uninitialized root node (we point to the EMPTY node)
		root = EMPTY;
		count = 0;
		treeStack = new StackArrayGeneric<GeneralTreeNode>();
		treeQueue = new QueueArrayGeneric<GeneralTreeNode>();
		
	}
	/**
	 * Getter method for root pointer variable
	 * @return The root node in a tree
	 */
	public GeneralTreeNode getRoot()
	{
		return root;
	}
	public boolean clear()
	{
		root = EMPTY;
		count = 0;
		return true;
	}
	
	public boolean isEmpty()
	{
		if(root.getData() == -1)
		{
			return true;
		}
		return false;
	}
	@Override
	public int height(GeneralTreeNode treeNode) {
		int height = 0;
		if(root.equals(EMPTY))
		{
			height  = 0;
			return height;
		}
		for (GeneralTreeNode child : treeNode.getChildren())
		{
			//recursively call the height method at each level
			int levelHeight = height(child);
			height = Math.max(height, levelHeight);
		}
		height++;
		return height;
	}

	@Override
	public int nodeCount() {
		return count;
	}

	@Override
	public int degree(GeneralTreeNode treeNode) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		return treeNode.getChildren().size();
	}

	@Override
	public boolean isRoot(GeneralTreeNode treeNode) {
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(treeNode.getParent() == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isParent(GeneralTreeNode treeNode) {
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(treeNode.getChildren().size() != 0)
		{
			return true;
		}
 		return false;
	}

	@Override
	public boolean isChild(GeneralTreeNode treeNode) {
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(treeNode.getParent() != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isLeaf(GeneralTreeNode treeNode) {
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(treeNode.getChildren().size() == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public GeneralTreeNode getLargest(GeneralTreeNode root) {
		//we keep the largest variable outside of the method
		//to ensure the variable isn't reinitailized after each
		//recursive call
		Vector<GeneralTreeNode> children = new Vector<GeneralTreeNode>();
		children = root.getChildren();
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		if(largest == null)
		{
			largest = root;
		}
		//comparison after recursive method call
		if(root.getData() > largest.getData())
		{
			largest = root;
		}
		for(int i = 0; i< children.size(); i++)
		{
			getLargest(children.get(i));
		}
		
		return largest;
	}

	@Override
	public GeneralTreeNode getSmallest(GeneralTreeNode root) {
		Vector<GeneralTreeNode> children = new Vector<GeneralTreeNode>();
		children = root.getChildren();
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		if(smallest == null)
		{
			smallest = root;
		}
		//comparison after recursive method call
		if(root.getData() < smallest.getData())
		{
			smallest = root;
		}
		for(int i = 0; i< children.size(); i++)
		{
			getSmallest(children.get(i));
		}
		
		return smallest;
	}

	@Override
	public GeneralTreeNode getSecondLargest(GeneralTreeNode root) {
		//we keep the largest variable outside of the method
		//to ensure the variable isn't reinitailized after each
		//recursive call
		//Vector<GeneralTreeNode> children = new Vector<GeneralTreeNode>();
		//children = root.getChildren();
		if(root.isEmpty() || this.root.getChildren().size() == 0)
		{
			throw new NoSuchElementException();
		}
		//we rely on the getLargest method to find the second largest node
		//therefore, if it hasn't been called yet we should do so.
		if(largest == null)
		{
			largest = getLargest(root);
		}
		if(secondLargest == null)
		{
			secondLargest = root;
		}
		//comparison after recursive method call
		if(root.getData() > secondLargest.getData())
		{
			secondLargest = root;
		}
		//case for when second largest gets initialized to the largetst value
		if(secondLargest == largest)
		{
			secondLargest = root.getLeftmostChild();
			//root = root.getLeftmostChild();
		}
		for(int i = 0; i< root.getChildren().size(); i++)
		{	
			if(root.getChildren().get(i) != largest)
			{
				getSecondLargest(root.getChildren().get(i));
			}
			else
			{
				break;
			}
		}
		
		return secondLargest;
	}

	@Override
	public GeneralTreeNode getSecondSmallest(GeneralTreeNode root) {
		//Vector<GeneralTreeNode> children = new Vector<GeneralTreeNode>();
		//children = root.getChildren();
		if(root.isEmpty() || this.root.getChildren().size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		if(smallest == null)
		{
			smallest = getSmallest(root);
		}
		if(secondSmallest == null)
		{
			secondSmallest = root;
		}
		//comparison after recursive method call
		if(root.getData() < secondSmallest.getData())
		{
			secondSmallest = root;
		}
		if(secondSmallest == smallest)
		{
			secondSmallest = root.getLeftmostChild();
		}
		for(int i = 0; i< root.getChildren().size(); i++)
		{
			getSecondSmallest(root.getChildren().get(i));
		}
		
		return secondSmallest;
	}

	@Override
	public boolean add(int value, int target) {
		GeneralTreeNode newNode  = new GeneralTreeNode(value);
		if(root.equals(EMPTY) && target == -1)
		{
			root = newNode;
			count++;
			return true;
		}
		else
		{
			GeneralTreeNode nodeExists = locateNode(getRoot(), target);
			if(nodeExists != null)
			{
				if(nodeExists.getData() != value)
				{
				if(!this.isEmpty())
				{
					GeneralTreeNode insertLocation = locateNode(root, target);
					//int nodeData = insertLocation.getData();
					if(insertLocation.getLeftmostChild() == null)
					{
						insertLocation.setLeftmostChild(newNode);
						//insertLocation.setSibling(newNode);
					}
					//else
					//{
						//insertLocation.setSibling(newNode);
					//}
					insertLocation.addChild(newNode);
					newNode.setParent(insertLocation);
					count++;
					return true;
				
				}
				}
			}
		}
		return false;
	}
	
	@Override
	public int insert(int value, int target) {
		GeneralTreeNode newNode  = new GeneralTreeNode(value);
		if(this.isEmpty() && target == -1)
		{
			root = newNode;
			count++;
			return newNode.getData();
		}
		else
		{
			GeneralTreeNode nodeExists = locateNode(getRoot(), target);
			if(nodeExists != null)
			{
				if(nodeExists.getData() != value)
				{
				if(!this.isEmpty())
				{
					GeneralTreeNode insertLocation = locateNode(root, target);
					//int nodeData = insertLocation.getData();
					if(insertLocation.getLeftmostChild() == null)
					{
						insertLocation.setLeftmostChild(newNode);
						//insertLocation.setSibling(newNode);
					}
					//else
					//{
						//insertLocation.setSibling(newNode);
					//}
					insertLocation.addChild(newNode);
					newNode.setParent(insertLocation);
					count++;
					return newNode.getData();
				
				}
				}
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public int remove(int value) {
		GeneralTreeNode deleteNode;
		int tempData = -1;
		deleteNode = locateNode(root, value);
		if(deleteNode.isEmpty() || root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		//case for one node tree
		if(deleteNode.equals(root) && deleteNode.getChildren().size() == 0)
		{
			tempData = deleteNode.getData();
			root = EMPTY;
			count = 0;
		}
		else
		{
			//value is in the tree
			if(deleteNode.getData() == value)
			{
				GeneralTreeNode parent = deleteNode.getParent();
				//case one: node we are deleting is a leaf
				if(deleteNode.getChildren().size() == 0)
				{
					//case for one node tree
					if(count == 1)
					{
						deleteNode.clearNode();
						count--;
					}
					else
					{
						tempData = deleteNode.getData();
						deleteNode.getParent().deleteChild(deleteNode);
						count--;
						
						//reinitialize leftmost child if node deleted was the leftmost child
						parent.setLeftmostChild(parent.getLeftmostChild());
					}
					
				}
				//case two: node we are deleting has one or more children
				else if(deleteNode.getChildren().size() >= 1)
				{
					//Take the value of the last leaf in the subtree as
					//the replacement node for our replacement node
					Vector<GeneralTreeNode> children = new Vector<GeneralTreeNode>();
					children = deleteNode.getChildren();
					for(int i = 0; i< children.size(); i++)
					{
						if(deleteNode.getData() != value)
						{
							break;
						}
						if(children.get(i).getLeftmostChild() == null)
						{
							tempData =children.get(i).getData();
							deleteNode.setData(tempData);
							deleteNode.deleteChild(children.get(i));
							count--;
							
							deleteNode.setLeftmostChild(deleteNode.getLeftmostChild());
						}
					}
				
				}
			}
		}
		return tempData;
	}

	@Override
	public GeneralTreeNode search(int value) {
		GeneralTreeNode nodeLoc;
		nodeLoc = locateNode(this.root, value);
		
		//we have found the node to search for
		if(nodeLoc != null)
		{
			if(nodeLoc.getData() == value)
			{
				return nodeLoc;
			}
		}
		return null;
		
	}

	@Override
	public GeneralTreeNode locateNode(GeneralTreeNode root, int data) {
		int rootValue;
		Vector<GeneralTreeNode> children = new Vector<GeneralTreeNode>();
		rootValue = root.getData();
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		if(rootValue == data)
		{
			return root;
		}
		//traverse in level order until we find the value
		if(rootValue != data)
		{
			treeQueue.enQueue(root);
			GeneralTreeNode tmpNode;
			
			while(!treeQueue.isEmpty())
			{
				tmpNode = treeQueue.deQueue();
				if(!tmpNode.getChildren().isEmpty())
				{
					children = tmpNode.getChildren();
					for(int i = 0; i<children.size(); i++)
					{
						treeQueue.enQueue(children.get(i));
						if(children.get(i).getData() == data)
						{
							treeQueue.clear();
							return children.get(i);
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public void inOrder(GeneralTreeNode treeNode) {
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		
		//Hitting the root node means we have
		//reached the end of the traversal
		if(root == treeNode)
		{
			treeStack.clear();
		}
		treeStack.push(treeNode.getData());
		
		//single-line output using print
		if(treeNode.getLeftmostChild() != null)
		{
			inOrder(treeNode.getLeftmostChild());
		}
		System.out.print(treeStack.pop() + " ");
		
		//condition for when there is no
		//left-most node (we go right)
		if(treeNode.getChildren().size() > 1)
		{
			for(int i = 1; i< treeNode.getChildren().size(); i++)
			{
				inOrder(treeNode.getChildren().get(i));
			}
		}
		//treeStack.clear();
	}

	@Override
	public void preOrder(GeneralTreeNode treeNode) {
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		
		//Hitting the root node means we have
		//reached the end of the traversal
		if(root == treeNode)
		{
			treeStack.clear();
		}
		treeStack.push(treeNode.getData());
		System.out.print(treeStack.pop() + " ");
		
		//single-line output using print
		if(treeNode.getLeftmostChild() != null)
		{
			preOrder(treeNode.getLeftmostChild());
		}
		
		//condition for when there is no
		//left-most node (we go right)
		if(treeNode.getChildren().size() > 1)
		{
			for(int i = 1; i< treeNode.getChildren().size(); i++)
			{
				preOrder(treeNode.getChildren().get(i));
			}
		}
		treeStack.clear();
	}

	@Override
	public void postOrder(GeneralTreeNode treeNode) {
		//treeStack.clear();
		if(treeNode.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		
		//Hitting the root node means we have
		//reached the end of the traversal
		if(root == treeNode)
		{
			treeStack.clear();
		}
		treeStack.push(treeNode.getData());
		//visit the leftmost node until traversing right
		if(treeNode.getLeftmostChild() != null)
		{
			postOrder(treeNode.getLeftmostChild());
		}
		//traverse right after visiting leftmost node
		if(treeNode.getChildren().size() > 1)
		{
				for(int i = 1; i<treeNode.getChildren().size(); i++)
				{
					if(treeNode.getChildren().get(i) != null)
					{	
						postOrder(treeNode.getChildren().get(i));
					}
				}
		}
	System.out.print(treeStack.pop() + " ");
	//treeStack.clear();
	}

	@Override
	public void levelOrder(GeneralTreeNode treeNode) {
		if(treeNode.isEmpty())
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		GeneralTreeNode tmpNode;
		
		while(!treeQueue.isEmpty())
		{
			tmpNode = treeQueue.deQueue();
			System.out.print(tmpNode.getData() + " ");
			//if(tmpNode.getLeftmostChild() != null)
			//{
			//	treeQueue.enQueue(treeNode.getLeftmostChild());
			//}
			if(!tmpNode.getChildren().isEmpty())
			{
				Vector<GeneralTreeNode> children = new Vector<GeneralTreeNode>();
				children = tmpNode.getChildren();
				for(int i = 0; i<children.size(); i++)
				{
					treeQueue.enQueue(children.get(i));
				}
			}
			//System.out.print(treeNode.getData());
		}
		treeQueue.clear();
	}
	
	/**
	 * Main method
	 * @param args The command line arguments.
	 */  	
	public static void main(String[] args)
	{
		GeneralTree genTree = new GeneralTree();
		genTree.insert(10,-1);
		GeneralTreeNode node = genTree.locateNode(genTree.getRoot(), 10);
		System.out.println(node.getData());
		genTree.insert(100,10);
		genTree.insert(200,10);
		genTree.insert(300,10);
		node = genTree.locateNode(genTree.getRoot(), 200);
		System.out.println(node.getData());
		genTree.insert(400, 200);
		genTree.insert(500, 200);
		genTree.insert(700, 500);
		genTree.insert(800, 500);
		genTree.insert(900, 700);
		genTree.insert(600, 200);
		//genTree.add(10, -1);
		
		System.out.println(genTree.height(genTree.getRoot()));
		System.out.println(genTree.degree(genTree.getRoot()));
		System.out.println(genTree.degree(node));
	
	
		node = genTree.locateNode(genTree.getRoot(), 300);
		System.out.println(node.getData());
		genTree.remove(500);
		System.out.println(genTree.degree(node));
		genTree.levelOrder(genTree.getRoot());
		System.out.println();
		//System.out.println(genTree.isChild(genTree.search(900)));
		genTree.inOrder(genTree.getRoot());
		System.out.println();
		
		genTree.preOrder(genTree.getRoot());
		System.out.println();
		
		genTree.postOrder(genTree.getRoot());
		System.out.println();
		//genTree.clear();
		//GeneralTree test = new GeneralTree();
		//test.add(100,-1);
		//node = test.getLargest(test.getRoot());
		//System.out.println(node.getData());
		
		//node = genTree.getLargest(genTree.getRoot());
		//System.out.println(node.getData());
		node = genTree.getSecondLargest(genTree.getRoot());
		System.out.println(node.getData());
		//node = genTree.getSmallest(genTree.getRoot());
		//System.out.println(node.getData());
		//node = genTree.getSecondSmallest(genTree.getRoot());
		//System.out.println(node.getData());
		
		
	}

}
