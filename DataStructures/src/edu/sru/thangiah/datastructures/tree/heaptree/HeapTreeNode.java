package edu.sru.thangiah.datastructures.tree.heaptree;

/**
 * <p>Title: HeapTreeNode</p>
 *
 * <p>Description: </p>
 * Class for instantiating a single heap tree node. Note the left, parent, and right attributes
 * which are used to link the individual nodes to the larger tree structure.
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class HeapTreeNode {
	//set up nodes within heap tree
    //parent/left/right
    //clearing nodes
    //isEmpty
    //Get parent/set parent/set left/set right
	
	/**
	 * Variable to hold the data for a binary tree node
	 */
    private int data;
	/**
	 * Pointer variable which points to the parent of a given node
	 */
    private HeapTreeNode parent;
	/**
	 * Pointer variable which points to the left child of a given node
	 */
    private HeapTreeNode leftChild;
	/**
	 * Pointer variable which points to the right child of a given node
	 */
    private HeapTreeNode rightChild;

    
	/**
	 * Uninitialized node which is used to test for empty conditions
	 */
  private static final HeapTreeNode EMPTY = new HeapTreeNode(-1);
 
  public HeapTreeNode (int data)
  {
      this.data = data;
      parent = EMPTY;
      leftChild = EMPTY;
      rightChild = EMPTY;
  }

  public HeapTreeNode (int data, HeapTreeNode parent)
  {
      this.data = data;
      this.parent = parent;
      leftChild = EMPTY;
      rightChild = EMPTY;
  }  
  
  HeapTreeNode()
  {
  	this.data = -1;
  	parent = EMPTY;
  	leftChild = this;
  	rightChild = this;
  }
	/**
	 * Determines if the data parameter is uninitialized
	 * @return True if there is no data value for a given node
	 */
  public boolean isEmpty()
  {
	   if(this.getData() == -1)
	   {
		   return true;
	   }
	   return false;
  }
  
	/**
	 * Determines if a given node is completely uninitialized
	 * @return True if there are no attributes for a given node
	 */
  public boolean isEMPTY()
  {
	   if(this == EMPTY)
	   {
		   return true;
	   }
	   return false;
  }

	/**
	 * Completely clears all the parameters for a given node
	 * @return True upon successful completion of the method
	 */
  public boolean clearNode()
  {
	   this.data = -1;
	   parent = EMPTY;
	   leftChild = this;
	   rightChild = this;
	   return true;
  }
  
	/**
	 * Getter method for data variable
	 * @return The data for a given node
	 */
  public int getData()
  {
      return data;
  }

  
	/**
	 * Setter method for data variable
	 * @param data - The value to set the private data variable to
	 * @return True upon successful completion of method
	 */
  public void setData(int data)
  {
      this.data = data;
  }

	/**
	 * Getter method for parent pointer
	 * @return The parent for a given node
	 */
  public HeapTreeNode getParent()
  {
      return parent;
  }

	/**
	 * Setter method for the parent pointer variable
	 * @param parent - The new value for the parent variable
	 */
  public void setParent(HeapTreeNode parent)
  {
      this.parent = parent;
  }

	/**
	 * Getter method for the left pointer variable
	 * @return The left child for a given node
	 */
  public HeapTreeNode getLeft()
  {
      return leftChild;
  }

	/**
	 * Setter method for the left pointer variable
	 * @param left - The new value for the left variable
	 */
  public void setLeft(HeapTreeNode left)
  {
      this.leftChild = left;
  }
	/**
	 * Getter method for the right pointer variable
	 * @return The right child for a given node
	 */
  public HeapTreeNode getRight()
  {
      return rightChild;
  }
	/**
	 * Setter method for the right pointer variable
	 * @param right - The new value for the right variable
	 */
  public void setRight(HeapTreeNode right)
  {
      this.rightChild = right;
  }

}
