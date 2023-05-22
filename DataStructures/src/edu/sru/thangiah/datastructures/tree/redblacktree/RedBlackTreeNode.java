package edu.sru.thangiah.datastructures.tree.redblacktree;
/**
 * <p>Title: RedBlackTreeNode </p>
 * 
 * <p>Description</p>
 * 
 * Class for creating individual nodes in the RB tree.
 * Note that there are parent, left, and right attributes which are used to set the structure of the tree.
 * 
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 *
 */
public class RedBlackTreeNode {
		/**
		 * data of the node
		 */
		private int data;
		/**
		 * parent of the node
		 */
		private RedBlackTreeNode parent;
		/**
		 * left child of the node
		 */
		private RedBlackTreeNode left;
		/**
		 * right child of the node
		 */
		private RedBlackTreeNode right;
		/**
		 * the color of the node, true is red, false is black
		 */
		private boolean color;
		
		private static final RedBlackTreeNode EMPTY = new RedBlackTreeNode(-1);

		RedBlackTreeNode(){
			this.data = -1;
			parent = null;
			left = this;
			right = this;
			color = false;
		}
		
		RedBlackTreeNode(int data){
			this.data = data;
			parent = EMPTY;
			left = EMPTY;
			right = EMPTY;
			color = false;
		}
		
		/**
		 * Removes the data and parent/left/right pointers for a given node
		 * @return True upon successful completion of method
		 */
		public boolean clearNode(){
			this.data = -1;
			parent = null;
			left = this;
			right = this;
			
			return true;
		}

		/**
		 * Method for determining if the given node has been initialized with data
		 * @return True if the data for a node is missing
		 */
		public boolean isEmpty() {
			if (this.getData() == -1)
			{
				return true;
			}
			return false;
		}
		
		/**
		 * Method for determining if a node has been completely uninitialized
		 * @return True if a node is completely empty
		 */
		public boolean isEMPTY() {
			if (this == EMPTY)
			{
				return true;
			}
			return false;
		}
		/**
		 * Getter method for data variable
		 * @return The data for a given node
		 */
		public int getData() {
			return data;
		}

		/**
		 * Setter method for data variable
		 * @param data - The value to set the private data variable to
		 * @return True upon successful completion of method
		 */
		public void setData(int data) {
			this.data = data;
		}
		/**
		 * Get method for the color of the node True false (black, red respectively)
		 * @return boolean true false (black, red respectively)
		 */
		public boolean getColor() {
			return color;
		}
		/**
		 * Setter method for data variable
		 * @param color - The True false (black, red respectively) value of the node to set the color too
		 */
		public void setColor(boolean color) {
			this.color = color;
		}

		/**
		 * Getter method for parent pointer
		 * @return The parent for a given node
		 */
		public RedBlackTreeNode getParent() {
			return parent;
		}

		/**
		 * Setter method for the parent pointer variable
		 * @param parent - The new value for the parent variable
		 */
		public void setParent(RedBlackTreeNode parent) {
			this.parent = parent;
		}

		/**
		 * Getter method for the left pointer variable
		 * @return The left child for a given node
		 */
		public RedBlackTreeNode getLeft() {
			return left;
		}
		
		/**
		 * Setter method for the left pointer variable
		 * @param left - The new value for the left variable
		 */
		public void setLeft(RedBlackTreeNode left) {
			this.left = left;
		}

		/**
		 * Getter method for the right pointer variable
		 * @return The right child for a given node
		 */
		public RedBlackTreeNode getRight() {
			return right;
		}

		/**
		 * Setter method for the right pointer variable
		 * @param right - The new value for the left variable
		 */
		public void setRight(RedBlackTreeNode right) {
			this.right = right;
		}

}