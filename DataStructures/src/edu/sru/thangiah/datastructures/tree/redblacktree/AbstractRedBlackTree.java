package edu.sru.thangiah.datastructures.tree.redblacktree;

import edu.sru.thangiah.datastructures.TreeOpsInt;
import edu.sru.thangiah.datastructures.TreeTraversalOps;
import edu.sru.thangiah.datastructures.tree.redblacktree.RedBlackTreeNode;

/**
 * <p>Title: AbstractAvlTreeGeneric</p>
 *
 * <p>Description: </p>
 * 
 * Template for the structure of a generic RB tree implementation
 * 
 * root and leaves are black
 * if red, its leaves are black
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public abstract class AbstractRedBlackTree implements TreeOpsInt, TreeTraversalOps {

	//Returns the height (total levels) in the tree
		public abstract int height(RedBlackTreeNode treeNode);
		
		//Returns the count of nodes in the tree
		public abstract int nodeCount();
		
		//similar to add which inserts a node following the tree structure
		public abstract boolean insert(int value);

		//similar to locateNode except does not take a RedBlackTreeNode parameter
		public abstract RedBlackTreeNode search(int value);
		
		//returns the node to be searched for
		public abstract RedBlackTreeNode locateNode(RedBlackTreeNode root, int data);
		
		//returns the node which is the predecessor given the parameters passed
		public abstract RedBlackTreeNode predecessor(RedBlackTreeNode root, int data);
		
		//returns the node which is the successor given the parameters passed
		public abstract RedBlackTreeNode successor(RedBlackTreeNode root);
		
		//returns the node which contains the largest value
		public abstract RedBlackTreeNode getLargest(RedBlackTreeNode root);
		
		//returns the node which contains the smallest value
		public abstract RedBlackTreeNode getSmallest(RedBlackTreeNode root);
		
		//returns the node which contains the second largest value
		public abstract RedBlackTreeNode getSecondLargest(RedBlackTreeNode root);
		
		//returns the node which contains the second smallest value
		public abstract RedBlackTreeNode getSecondSmallest(RedBlackTreeNode root);
		
		//locates a node to be removed given the value parmater and removes it
		//returns the value of the node removed
		public abstract int remove(int value);
		
		/**
		 * rotates a tree left based on a pivot
		 * @param node - The pivot by which we perform the rotation
		 * @return True based on successful completion of the rotation
		 */
		public abstract boolean rotateLeft(RedBlackTreeNode node);
		
		/**
		 * rotates a tree right based on a pivot
		 * @param node - The pivot by which we perform the rotation
		 * @return True based on successful completion of the roation
		 */
		public abstract boolean rotateRight(RedBlackTreeNode node);
		
		//performs inOrder traversal of a tree
		public abstract void inOrder(RedBlackTreeNode treeNode);
		
		//performs preOrder traversal of a tree
		public abstract void preOrder(RedBlackTreeNode treeNode);
		
		//performs postOrder traversal of a tree
		public abstract void postOrder(RedBlackTreeNode treeNode);
		
		//performs levelOrder traversal of a tree
		public abstract void levelOrder(RedBlackTreeNode treeNode);
		
		//finds the maximum value in the tree
		public abstract int findMax(RedBlackTreeNode root);

		//finds the minimum value in the tree
		public abstract int findMin(RedBlackTreeNode root);
		
		
		
		/*
		 * TreeOpsInt methods which are inherited but not used
		 */
		@Override
		public Object remove() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int search() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int insert() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int findMax() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int findMin() {
			// TODO Auto-generated method stub
			return 0;
		}

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
		public void inOrder() {

		}

		@Override
		public void preOrder() {
		}

		@Override
		public void postOrder() {

		}

		@Override
		public void levelOrder() {

		}

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

		@Override
		public boolean contains(int value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean add(int value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int degree() {
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
			// TODO Auto-generated method stub
			return false;
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
