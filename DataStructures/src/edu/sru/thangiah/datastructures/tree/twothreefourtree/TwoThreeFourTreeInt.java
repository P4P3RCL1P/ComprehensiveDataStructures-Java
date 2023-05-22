package edu.sru.thangiah.datastructures.tree.twothreefourtree;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.stack.StackArray;
import edu.sru.thangiah.datastructures.tree.avltree.AvlTreeInt;
import edu.sru.thangiah.datastructures.tree.twothreefourtree.TwoThreeFourTreeNode;

/**
 * 
 * <p>Title: TwoThreeFourTree</p>
 *
 * <p>Description: </p>
 * Int implementation for a 234 tree which allows the user to create instances of trees with integer values.
 * The 234 tree has three different types of nodes, which the tree is named after, which can hold that number + 1 connections as children nodes.
 * It uses splitting in order to keep is access time minimal.
 * Note that a 234 tree is a self-balancing tree which checks the colors of the nodes in the subtrees to ensure equal distancing of nodes and minimal search time
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 *
 */
public class TwoThreeFourTreeInt extends AbstractTwoThreeFourTreeInt {

	/**
	 * root of the tree
	 */
	private TwoThreeFourTreeNode root;
	/**
	 * no. of nodes in the tree
	 */
	private int count;
	/**
	 * no. of values in the tree
	 */
	private int valueCount;
	/**
	 * count for depth first to determine end of search
	 */
	private int searchCount;
	/**
	 * empty node which is used for testing if a tree is completely empty
	 */
	final private static TwoThreeFourTreeNode EMPTY = new TwoThreeFourTreeNode();
	/**
	 * Stack used for in/pre/post order traversal
	 */
	private StackArray treeStack;
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<TwoThreeFourTreeNode> treeQueue;

	public TwoThreeFourTreeInt() {
		
		root=EMPTY;
		count = 0;
		treeStack = new StackArray();
		treeQueue = new QueueArrayGeneric<TwoThreeFourTreeNode>();
		
	}
	
	/**
	 * Method used to check if the tree is empty through checking if the root has no values
	 * @return true if there is nothing in the tree
	 */
	@Override
	public boolean isEmpty() {
		
		if(root.getValue(0) == -1) //if the first data value of three possible is -1 then the root is empty, and the tree is empty
		{
			
			return true;
			
		}
		
		return false;
		
	}

	/**
	 * Method used to clear the tree
	 * @return true upon successful completion
	 */
	@Override
	public boolean clear() {
		
		root.clearNode();
		count = 0;
		return true;
		
	}

	/**
	 * Method used to check TF if the tree contains value in the tree
	 * it does this by locating the node, and then using the node
	 * contains value and check if the index returned is not -1
	 * @param root- node for the root of the tree
	 * @param value- int value being looked for in the tree
	 * @return true if it comes out with the value in the tree
	 */
	@Override
	public boolean contains(TwoThreeFourTreeNode root, int value) {
		
		if(this.locateNode(root, value).contains(value)>=0) {
			
			return true;
			
		}
		
		return false;
	
	}
	
	/**
	 * Method used to check TF if the tree contains value in the tree
	 * it does this by locating the node, and then using the node
	 * contains value and check if the index returned is not -1
	 * @param value- int value being looked for in the tree
	 * @return true if it comes out with the value in the tree
	 */
	@Override
	public boolean contains(int value) {
		
		if(isEmpty()) {
			return false;
		}
		
		if(locateNode(getRoot(),value).contains(value)>=0) {
			
			return true;
			
		}else {
			
			return false;
			
		}
	}

	/**
	 * Method used to add a value to the tree, and maintain the balance with helper functions
	 * locateNode, findAddLocation, and basic node functions
	 * @param int value - the value being added to the tree
	 * @return true upon successful introduction of value to the tree
	 */
	@Override
	public boolean add(int value) {
		
		//New elements are inserted only in leaf nodes.
		
		TwoThreeFourTreeNode root = getRoot();
		
		if(isEmpty()) {
			
			TwoThreeFourTreeNode treeNode = new TwoThreeFourTreeNode(value);
			this.setRoot(treeNode);
			valueCount ++;
			
			return true;
			
		}else if(root.getType()!=3 && isLeaf(root)) {
			
			root.insertValue(value);
			valueCount ++;
			
			return true;
			
		} else {
			
			if(this.locateNode(this.getRoot(), value).contains(value)>=0) {
				
				return false;
				
			} else {
				
				root=findAddLocation(this.getRoot(),value);
				
				root.insertValue(value);
				
				valueCount ++;

				return true;
				
			}
			
		}
	
	}
	
	/**
	 * method  used by add to find the location node that the value being added is going to go
	 * precondition that the tree doesn't contain the value
	 * @param rootNode (root or the recursed node)
	 * @param value (value for which we want to add)
	 * @return the node we want to add, unless
	 */
	public TwoThreeFourTreeNode findAddLocation(TwoThreeFourTreeNode rootNode, int value) {
		
		if(rootNode.getType()==3) {
			
			split(rootNode);
			this.getRoot().printValues();
			rootNode = findAddLocation(this.getRoot(), value);

		}
		
		while(!isLeaf(rootNode)) {
			
			if(rootNode.getType()==3) {
				
				split(rootNode);
				rootNode = findAddLocation(this.getRoot(), value);
				
			} else { //if it is not a 3 type node
				
				if(rootNode.getValue(0) > value) { // if the value is less than the first value
					if(rootNode.getChild(0).isEmpty()) {
						
						TwoThreeFourTreeNode nodeLoc = new TwoThreeFourTreeNode();
						nodeLoc.setParent(rootNode);
						rootNode.setChild(nodeLoc, 0);
						return nodeLoc;
						
					}else{
						
						rootNode = findAddLocation(rootNode.getChild(0), value);
						
					}
					
				} else if(rootNode.getValue(1) > value||rootNode.getType()==1) { //or if the value is less than the second value and the type is 1 
					
					if(rootNode.getChild(1).isEmpty()) {
						
						TwoThreeFourTreeNode nodeLoc = new TwoThreeFourTreeNode();
						nodeLoc.setParent(rootNode);
						rootNode.setChild(nodeLoc, 1);
						return nodeLoc;
						
					}else {
						
						rootNode = findAddLocation(rootNode.getChild(1), value);
						
					}
					
				} else if(rootNode.getValue(2)> value||rootNode.getType()==2) { //value will go down to the right of the second value
					
					if(rootNode.getChild(2).isEmpty()) {
						
						TwoThreeFourTreeNode nodeLoc = new TwoThreeFourTreeNode();
						nodeLoc.setParent(rootNode);
						rootNode.setChild(nodeLoc, 2);
						return nodeLoc;
						
					}else {
						
						rootNode = findAddLocation(rootNode.getChild(2), value);
						
					}
					
				}else {
					
					if(rootNode.getChild(3).isEmpty()) {
						
						TwoThreeFourTreeNode nodeLoc = new TwoThreeFourTreeNode();
						nodeLoc.setParent(rootNode);
						rootNode.setChild(nodeLoc, 3);
						return nodeLoc;
						
					}else {
						
						rootNode = findAddLocation(rootNode.getChild(3),value);
						
					}
					
				}
				
			}
			
		}
		
		return rootNode;
	}

	public int height(TwoThreeFourTreeNode node) {
		
		//finding out a recurring max of the list of children which loops through all the options is the best way to go out of this probably
		
		return -1;
	}

	@Override
	public int nodeCount() { 
		//this will probably increase as the nodes split, and decrease as they are removed 
		return count;
	}
	
	public int valueCount() {
		return valueCount;
	}

	
	/**
	 * Method used to split up a node when called in other methods, an essential
	 * function for utilizing 2-3-4 trees and balancing. this will take in
	 * 
	 */
	public boolean split(TwoThreeFourTreeNode node) {
		
		if(node.isEmpty()) { //you can't split an empty node
			
			throw new NoSuchElementException();
			
		}
		
		if(node.getType()==3) {
			
			TwoThreeFourTreeNode newParent = new TwoThreeFourTreeNode(node.getValue(1));
			TwoThreeFourTreeNode newLeft = new TwoThreeFourTreeNode(node.getValue(0));
			TwoThreeFourTreeNode newRight = new TwoThreeFourTreeNode(node.getValue(2));
			
			if(isRoot(node)) { //if the node is the root, then right now it has no parent node. 
				
				this.root = newParent;
				
				newParent.connectChild(newLeft);
				newParent.connectChild(newRight);
				
				newLeft.setType(1);
				newLeft.setParent(newParent);
				newRight.setParent(newParent);
				
				newRight.setType(1);
				
				count += 2;
				
				return true;

			} else {
				
				if(node.getParent().getType()==3) {
				
					throw new NoSuchElementException();
				
				} else { //parent is type 1 or 2 
					
					newParent=node.getParent(); //new parent is now the parent node

					newParent.insertValue(node.getValue(1)); //insert the value into the parent node
					newParent.printValues();
					
					TwoThreeFourTreeNode nodeChildren[] = {node.getChild(0),node.getChild(1),EMPTY,EMPTY};
					newLeft.setType(1);
					newLeft.setChildren(nodeChildren);
					TwoThreeFourTreeNode nodeChildren2[] = {node.getChild(2),node.getChild(3),EMPTY, EMPTY};
					newRight.setType(1);
					newLeft.setChildren(nodeChildren2);
					
					newParent.connectChild(newLeft);
					newParent.connectChild(newRight);
					
					count++;
					
					return true;
					
				}
				
			}
						
		}else {
			
			//you do not split nodes that aren't leaves.
			throw new NoSuchElementException();
			
		}

	}

	/**
	 * Method that uses locateNode to find a value in the tree
	 * @param int value - the value being searched
	 * @return node that contains the value, or EMPTY if not in the tree
	 */
	@Override
	public TwoThreeFourTreeNode search(int value) {
		
		TwoThreeFourTreeNode nodeLoc;
		nodeLoc = locateNode(this.root, value);
		
		//we have found the node to search for
		if(nodeLoc.contains(value)!=-1){
			
			return nodeLoc;
			
		}
		
		return EMPTY;
	}

	/**
	 * Method that uses a while loop to traverse down the right side
	 * of the tree to find the max value or -1 when invalid
	 * @return the value collected that is the highest in the tree
	 */
	@Override
	public int findMax() {
		// traverse down right tree, get last value/last child
		if(this.isEmpty()) {
			return -1;
		}
		
		TwoThreeFourTreeNode max = this.getRoot();
		
		while(!max.getChild(max.getType()).isEmpty()) {
			max = max.getChild(max.getType());
		}
		
		return max.getValue(max.getType()-1);
	}

	/**
	 * Method that uses a while loop to traverse down the left side
	 * of the tree to find the min value, or -1 when invalid
	 * @return the value collected that is the lowest in the tree
	 */
	@Override
	public int findMin() {
		// traverse down right tree, get first value/first child
		if(this.isEmpty()) {
			return -1;
		}
		
		TwoThreeFourTreeNode min = this.getRoot();
		
		while(!min.getChild(0).isEmpty()) {
			min = min.getChild(0);
		}
		
		return min.getValue(0);
	}

	
	/*
	 * There is no reason to rotate 2-3-4 tree nodes
	 */
	
	@Override
	public int rotateLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rotateRight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degree(TwoThreeFourTreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIncomplete() {
		return false;
	}
	
	/**
	 * Method that checks if the treeNode is the same as the root
	 * @param treeNode - the node being tested
	 * @return true if the node is the root
	 */
	@Override
	public boolean isRoot(TwoThreeFourTreeNode treeNode) {
		
		return(this.getRoot()==treeNode);
		
	}

	/**
	 * method that returns the root of the tree
	 * @return node (root of the tree)
	 */
	public TwoThreeFourTreeNode getRoot() {
		
		return root;
		
	}

	/**
	 * method that sets the root node of the tree
	 * @param root (node)
	 */
	public void setRoot(TwoThreeFourTreeNode root) {
		
		this.root = root;
		
	}
	
	/**
	 * method recursively goes through the tree and searches for a node containing a specified value
	 * @param root root node of the tree, or recursively the root from which it stems and looks for values
	 * @param value the value that we are looking for
	 * @return the node that has the value we're looking for, or where it would have been
	 */
	@Override
	public TwoThreeFourTreeNode locateNode(TwoThreeFourTreeNode root, int value) {
		
		int[] rootValue;
		rootValue = root.getValues();
		
		if(root.isEmpty()) //you can't locate a node if the root/tree is empty
		{
			throw new NoSuchElementException();
		}
		
		int rootType = root.getType();
		
		if(root.contains(value)>=0) {
			
			return root;
			
		}
		
		//granted rootType is 2,3,4
		
		while(rootType > 0) { 
			
			if(rootType==1) {
								
				if(root.getValue(0)>value) {
					
					if(root.getChild(0).isEmpty()) {
						
						return root;
						
					} else {
						
						root = locateNode(root.getChild(0), value);
						
					}
					
				}
				
			}
			
			if(root.getValue(rootType-1)<value && root.getValue(rootType-1)!=-1) { //iterates down, starts with value -1 of root type because a 3-type starts with index [2]
				
				if(root.getChild(rootType).isEmpty()) { //if the child is empty we're done
					
					return root;
					
				} else {
					
					root=locateNode(root.getChild(rootType),value); //if the child is not empty
					
				}
				
			}
			
			rootType--;
			
		}
		
		return root;
		
	}

	/**
	 * Method that tests if the node is a parent
	 * @param treeNode- the node being tested
	 * @return true, unless there are no children (leaf)
	 */
	@Override
	public boolean isParent(TwoThreeFourTreeNode treeNode) {
		
		if(!treeNode.getChild(0).isEmpty()) {
			
			return true;
			
		}else if(!treeNode.getChild(1).isEmpty()) {
			
			return true;
			
		}else if(!treeNode.getChild(2).isEmpty()) {
			
			return true;
			
		}else if(!treeNode.getChild(3).isEmpty()) {
			
			return true;
			
		}else{
			
			return false;
			
		}

	}

	/**
	 * Method that tests if the node is a child node
	 * @param treeNode - the node being tested
	 * @return true, unless it is a root or the node is empty
	 */
	@Override
	public boolean isChild(TwoThreeFourTreeNode treeNode) {
		
		if(this.isRoot(treeNode)||treeNode.isEmpty()) {
			
			return false;
			
		}
		
		return true;
		
	}

	/**
	 * Method that tests if the node is a leaf node
	 * @param treeNode - the node being tested
	 * @return true if no children
	 */
	@Override
	public boolean isLeaf(TwoThreeFourTreeNode treeNode) {
		
		if(treeNode.getChild(0).isEmpty() && treeNode.getChild(1).isEmpty() && treeNode.getChild(2).isEmpty() && treeNode.getChild(3).isEmpty()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	
	
	public static void main(String args[]) {
		
		TwoThreeFourTreeInt tree = new TwoThreeFourTreeInt();
		
		if(tree.isEmpty())
			System.out.println("tree is empty");
		
		TwoThreeFourTreeNode testNode = new TwoThreeFourTreeNode(4);
		
		tree.setRoot(testNode);
		
		if(!tree.isEmpty()) 
			System.out.println("tree is not empty");
		
		
		tree.clear();
		
		if(tree.isEmpty())
			System.out.println("tree is empty");
		
		System.out.println("root node type " + tree.getRoot().getType());
		tree.add(3);
		System.out.println("root node type " + tree.getRoot().getType());
		tree.add(2);
		System.out.println("root node type " + tree.getRoot().getType());
		tree.add(1);
		System.out.println("root node type " + tree.getRoot().getType());
		
		tree.add(1);
		tree.add(1);
		tree.add(2);
		tree.add(4);
		tree.add(7);
		
		tree.add(8);
		
		System.out.println("is the root a leaf?" + tree.isLeaf(tree.getRoot()));
		
		tree.getRoot().printValues();
		
		tree.getRoot().getChild(0).printValues();
		
		tree.getRoot().getChild(1).printValues();
		
		System.out.println(tree.contains(2));
		System.out.println(tree.locateNode(tree.getRoot(), 2).contains(2));
		
		System.out.println(tree.contains(3));
		System.out.println(tree.locateNode(tree.getRoot(), 3).contains(3));

		System.out.println(tree.contains(1));
		System.out.println(tree.locateNode(tree.getRoot(), 1).contains(1));

		System.out.println(tree.contains(6));
		System.out.println(tree.locateNode(tree.getRoot(), 6).contains(6));
		
		System.out.println(tree.contains(7));
		System.out.println(tree.locateNode(tree.getRoot(), 7).contains(7));
		tree.locateNode(tree.getRoot(),7).printValues();
		
		System.out.println(tree.contains(8));
		System.out.println(tree.locateNode(tree.getRoot(), 8).contains(8));
		
		System.out.println("value count " + tree.valueCount());
		System.out.println("node count " + tree.nodeCount());
		
		System.out.println("min " + tree.findMin());
		System.out.println("max " + tree.findMax());
	}
	
	/*
	 * Methods unimplemented
	 */
	
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

	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int search() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
