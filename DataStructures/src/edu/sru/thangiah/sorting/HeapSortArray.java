package edu.sru.thangiah.sorting;

import java.util.NoSuchElementException;

import edu.sru.thangiah.datastructures.generic.queue.QueueArrayGeneric;
import edu.sru.thangiah.datastructures.stack.StackArray;
import edu.sru.thangiah.datastructures.tree.heaptree.HeapTreeNode;

public class HeapSortArray {

	

	/**
	 * Initial size variable for default constructor
	 */
    private final int MAXSIZE = 20;
    /**
     * master heap tree node variable. All changes made to heapAr are reflected in the root variable
     */
	private HeapTreeNode root;
	/**
	 * for easy navigation through sorting values and swapping if necessary. heapAr[1] acts similarly to the root variable, while each consecutive index maintains the tree structure
	 */
	private HeapTreeNode[] heapAr;
	/**
	 * node count initialized to 1 to reduce arithmetic complexity in getting parent/child
	 */
	private int count;
	/**
	 * search count for depth search end
	 */
	private int searchCount;
	/**
	 * set equal to MAXSIZE or custom size parameter passed in overloaded constructor
	 */
	private int size;
	/**
	 * Initialized to 0 during constructor initialization, and then called/set during the height method
	 */
	private int height;
	/**
	 * variable set when getParentNode is called
	 */
	private int parentNode;
	/**
	 * variable set when getLeftChildNode is called
	 */
	private int leftChildNode;
	/**
	 * variable set when getRightChildNode is called
	 */
	private int rightChildNode;
	/**
	 * buffer node set during constructor
	 */
	private static final HeapTreeNode EMPTY = new HeapTreeNode(-1);

	/**
	 * variable name set instead of calling heapAr[1] (reduces magic numbers within code)
	 */
	private static final int ROOT = 1;
	
	/**
	 * Stack used for in/pre/post order traversal
	 */
	private StackArray treeStack;
	
	/**
	 * Queue used for level order traversal
	 */
	private QueueArrayGeneric<HeapTreeNode> treeQueue;
	
	/**
	 * default constructor
	 */
	public HeapSortArray()
	{	
		root = EMPTY;
		//keep heapAr[0] for necessary swaps but also using index 1 allows for parent and child arithmetic operations to require one less operation
		count = 1;
		height = 0;
		size = MAXSIZE;
		//initialize generic array with size of 20 (we could resize array or use an arraylist/linkedlist, but for now sticking with arrays will demonstrate our point)
		heapAr = (HeapTreeNode[]) new HeapTreeNode[MAXSIZE];
		treeStack = new StackArray();
		treeQueue = new QueueArrayGeneric<HeapTreeNode>();
		
	}
		
	/**
	 * overloaded constructor
	 * @param maxSize
	 */
	public HeapSortArray (int maxSize)
	{	
		root = EMPTY;
		//keep heapAr[0] for necessary swaps
		count = 1;
		height = 0;
		size = maxSize;
		//Initialize generic array with size passed in by the maxSize variable
		heapAr = (HeapTreeNode[]) new HeapTreeNode[size];
	}
		
	/**
	 * getter method for root node
	 * @return The root node of a tree
	 */
	public HeapTreeNode getRoot()
	{
		return root;
	}
	/**
	 * removing nodes within a heap tree always involves finding the last leaf and swapping that node with the node to be deleted
	 * @return The node of the last leaf in a heap tree
	 */
	public HeapTreeNode findLastLeaf()
	{
			//begin at heapAr[i] and increment i until node count is reached
			for(int i = 1; i < count; ++i)
			{
				//check to see if the node is initialized to a value
				if(heapAr[i].getData() == -1)
				{
					//check to see if the node passed is not the root
					if(i > 0)
					{
						System.out.println("Good");
						return heapAr[i-1];
					}
					else
					{
						//root node was uninitialized, and should not return the last leaf (heap tree is empty)
						System.out.println("Bad");
						return null;
					}
				}
				//leaf node will always be 1-count. Since we initialize count to 1, we must always subtract 1 from the count value to get the real last node (otherwise the value will be null)
				else 
				{
					return heapAr[count-1];
				}
			}
			return null;
		}
	/**
	 * the parent node can be calculated by taking the index passed divided by 2. Since we start at index 1 we don't need to worry about the extra subtraction from the index if we started at 0
	 * @param element - the node in the heap tree which we are trying to get the parent of
	 * @return The parent node
	 */
	public int getParentNode(int element)
	{
		//we floor the value since we divide odd numbers by 2 in some instances
		parentNode = (int) Math.floor(element / 2);
		return parentNode;
			
	}
	/**
	 * the left child node can be calculated by taking the index passed and multiplying it by 2. If we started at index 0 the formula would be (2 * element) +1
	 * @param element - The node in the heap tree which we are trying to get the left child of
	 * @return The left child
	 */
	public int getLeftChildNode(int element)
	{
		leftChildNode = 2 * element ;
		return leftChildNode;
	}
	/**
	 * the right child node can be calculated by taking the index passed multiplied by two and then added by 1. If we started at index 0 the formula would be (2 * element) + 2
	 * @param element - The node in the heap tree which we are trying to get the right child of
	 * @return The right child
	 */
	public int getRightChildNode(int element)
	{
		rightChildNode = (2 * element) + 1;
		return rightChildNode;
	}
	/**
	 * links with level order traversal and also useful when simply needing to get the height of the tree
	 * @return The height of a given tree
	 */
	public int height()
	{
		//uninitialized heap tree
		if(root.isEmpty())
		{
			height = 0;
			return height;
		}
		//base case where root is only node initialized
		if(root.getRight().isEmpty() && root.getLeft().isEmpty())
		{
			height = 1;
			return height;
		}
		//if the heap as 2 to 3 nodes then the height is 2. Since we start at index 1 in the heapAr we would need to either use count-1 or compare to 3 & 4 noticing that the actual count is count-1
		else if (count == 3 || count == 4)
		{
			height = 2;
			return height;
		}
		//if the heap has 4 to 8 nodes then the height is 3. Since we start at index 1 in the heapAr we would need to either use count-1 or compare from 5 & 8 noticing that the actual count is count-1
		else if (count >= 5 || count <= 8)
		{
			height = 3;
			return height;
		}
		else {
			
		//formula for computing height of any tree given node count. We use math.ceil to round log 
		//computation up to nearest whole number since any decimal larger than the closes int is on a new level.
		height = (int) Math.ceil(Math.log((count-1) + 1) / Math.log(2))-1;
		}
		return height;
	}
	/**
	 * getter method for count. Again we are aware that heapAr begins at index 1 so count-1 returns the actual node count.
	 * @return The number of nodes in the heap tree
	 */
	public int nodeCount()
	{
		return count-1;
	}

	public int degree(HeapTreeNode treeNode) {
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



	public boolean isRoot(HeapTreeNode treeNode) {
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


	public boolean isParent(HeapTreeNode treeNode) {
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


	public boolean isChild(HeapTreeNode treeNode) {
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


	public boolean isLeaf(HeapTreeNode treeNode) {
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
	 * method for percolating up the tree when a node is inserted
	 * @param root The root node of the heap tree
	 */
	public void heapify (HeapTreeNode root)
	{
		//so basically we gonna for loop from count backwards
		//if it has a child or children, check to see which is larger and proceed to swap
		//if it doesn't no swap needed
		
		HeapTreeNode swapNode; //swapNode to point to the node to swap
		int tempP; //temporary node set to the data value of the parent
		int i = count; //necessary for starting at count, and then changing the value of i to the parent node during each iteration
		swapNode = heapAr[i];
			//check for children on node, big nested ifs for comparison sorry dr sam
			//no necessary loops needed when count of nodes inserted is at most 3
			if(count <=3)
			{
				
				if(heapAr[ROOT].getLeft().getData() != -1 || heapAr[ROOT].getRight().getData() != -1) //if either children exist
				{
					if(heapAr[ROOT].getLeft().getData() != -1 && heapAr[ROOT].getRight().getData() != -1) //if both children exist
					{
						if(heapAr[ROOT].getLeft().getData() > heapAr[ROOT].getRight().getData()) //if left child is larger
						{
							swapNode = heapAr[ROOT].getLeft();
							if(swapNode.getData() > swapNode.getParent().getData() ) //if left child is larger than parent, do the swap
							{
								//note count has not been incremented at this point, and is only incremented after the insert method. Thus we don't have to worry about count-1
								tempP = heapAr[count].getParent().getData(); //placeholder variable to store the value of heapAr[count]s parent
								heapAr[count].getParent().setData(swapNode.getData()); //set the data of the parent to the data value of the node that we are swapping
								heapAr[count].getParent().getLeft().setData(tempP); // now set the left child's data value (the node that we swapped) to the placeholder variable
								tempP = -1; //reset tempP
							}
						}
						else //right child is larger
						{
							swapNode = heapAr[ROOT].getRight(); //get the right node since the right is larger
							tempP = heapAr[ROOT].getLeft().getData(); //set placeholder to store the left node's data value
							if(swapNode.getData() > swapNode.getParent().getData() ) //if right child is larger than parent, do swap
							{
								tempP = heapAr[count].getParent().getData(); //placeholder should now be the parent node's data value
								heapAr[count].getParent().setData(swapNode.getData()); //set the parent node's data to the node that is to be swaped's data value
								heapAr[count].getParent().getRight().setData(tempP); // now set the right node's data to the placeholder variable
								tempP = -1;//reset tempP
							}
						}
					}
					else //only other option when children exist is if there is only a left, cannot be only a right child
					{
						swapNode = heapAr[count].getParent().getLeft(); //swap left if it is larger than parent
						if(swapNode.getData() > swapNode.getParent().getData()) // left child is larger than parent
						{
							tempP = heapAr[count].getParent().getData(); //placeholder set to the parent node's data value
							heapAr[count].getParent().setData(swapNode.getData());// set the parent node's data to the node that is to be swaped's data value
							heapAr[count].getParent().getLeft().setData(tempP);//now set the left nopde's data to the placeholder variable
							tempP = -1;//reset tempP
						}
					}
				}
			}
			else // height of tree is greater than 2 (or node count is greater than 3)
			{
	
				while(i>0) // make sure we aren't going out of bounds of heapAr[i]
				{
					if(swapNode.getParent().getData() == -1) //we hit the root node 
					{
						if(swapNode.getRight().getData() > swapNode.getData())
						{
							swapNode = heapAr[ROOT].getRight();
							
							tempP = heapAr[ROOT].getData(); //placeholder should now be the parent node's data value
							heapAr[ROOT].setData(swapNode.getData());
							heapAr[ROOT].getRight().setData(tempP);
							tempP = -1;//reset tempP[
						}
						else if(swapNode.getLeft().getData() > swapNode.getData())
						{
							swapNode = heapAr[ROOT].getLeft();
							tempP = heapAr[ROOT].getData();
							heapAr[ROOT].setData(swapNode.getData());
							heapAr[ROOT].getLeft().setData(tempP);
							tempP = -1;
						}
						return;//no further iteration needed
					}
					else if(swapNode.getData() > swapNode.getParent().getData()) //the node we are swapping's data value is greater than the parent's value (we need to heapify)
					{
						tempP = heapAr[i].getParent().getData(); //placeholder get's set to the parent node's data value
						heapAr[getParentNode(i)].setData(swapNode.getData()); //swap the parent node's data with the swapNode's data
						heapAr[i].setData(tempP); //now set the data of the swapNode to the placeholder variable
					}
					else
					//(swapNode.getData().compareTo(swapNode.getParent().getData()) < 0)
					{
						/*tempP = heapAr[i].getParent().getData(); //placeholder gets set to the parent node's data value
						heapAr[getParentNode(i)].setData(swapNode.getData()); // swap the parent node's data with the swapNode's data
						heapAr[i].setData(tempP); //now set the data of the swapNode to the placeholder variable*/
						return;
					}
					i = getParentNode(i); //i is set to the next parent node to have comparison done
					swapNode = heapAr[getParentNode(i)]; //swapNode is also set to the next parent node to have comparison done
				}
					
				//conditions for if heapAr[1] is getting compared
				if(heapAr[ROOT].getLeft().getData() > swapNode.getData())
				{
					//lies on the left
					tempP = heapAr[ROOT].getData();//placeholder gets set to the parent node's data value
					heapAr[ROOT].setData(heapAr[ROOT].getLeft().getData()); //swap the root's data value with the value of the left node.
					heapAr[ROOT].getLeft().setData(tempP);//set the left node's data to the placeholder value
					tempP = -1; //reset tempP
				}
				else
				{
					//lies on the right
					tempP = heapAr[ROOT].getData();//placeholder gets set to the parent node's data value
					heapAr[ROOT].setData(heapAr[ROOT].getRight().getData()); //swap the root's data value with the value of the right node
					heapAr[ROOT].getRight().setData(tempP); //set the right nbode's data to the placeholder value
					tempP = -1; //reset tempP
				}
			}
	}
	
	/**
	 * method for percolating down the tree 
	 * @param deleteNode - The node which has been deleted and needs to be re-heapified
	 */
	public void heapifyDown(HeapTreeNode deleteNode)
	{
		int temp = deleteNode.getData(); //placeholder variable
		int i = ROOT; //beginning at i=1
		HeapTreeNode leftNode = deleteNode.getLeft(); //for readability we set leftNode and rightNode to the left and right attributes of deleteNode
		HeapTreeNode rightNode = deleteNode.getRight();
		
		//base case for root
		if(deleteNode.getLeft().getData() == -1 && deleteNode.getRight() == null)
		{
			return;
		}
		
		//left && right larger, but right is larger than left
		if(leftNode.getData() != -1 && rightNode.getData() != -1 && leftNode.getData() >deleteNode.getData() && rightNode.getData() > deleteNode.getData() && rightNode.getData() > leftNode.getData())
		{
			//verify that there are nodes to be swapped
			while(heapAr[i].getRight() != null || heapAr[i].getLeft() != null) {
				if(heapAr[i].getRight().getData() != -1 && heapAr[i].getRight().getData() > heapAr[i].getData()) //right node is larger
				{
					temp = heapAr[i].getData(); //temp is set to the data value of heapAr
					heapAr[i].setData(heapAr[i].getRight().getData()); // we set the heapAr value to the right node
					heapAr[i].getRight().setData(temp); //now set the right node to the value stored in temp
				}
				//we have reached a point where there is no comparison needed
				else
				{
					break;
				}
			i++;
			}
		}
		else if(leftNode.getData() != -1 && leftNode.getData() > deleteNode.getData()) //leftNode is larger
		{
			while(i > 0 && (heapAr[i].getLeft().getData() != -1 || heapAr[i].getRight().getData() != -1)) //again make sure we are performing our heapify actions on nodes and not uninitialized array indexes
			{	
				if(heapAr[i].getLeft().getData() > heapAr[i].getData()) //left is still larger than parent
				{
					temp = heapAr[i].getData();//temp is set to the data value of heapAr
					heapAr[i].setData(heapAr[i].getLeft().getData());//we set the heapAr value to the left node
					heapAr[i].getLeft().setData(temp);//now set the left node to the value stored in temp
				}
				else //we have reached a point where there is no comparison needed
				{
					break;
				}
				i++;
			}
		}
		else if(rightNode.getData() != -1 && rightNode.getData() > deleteNode.getData()) //rightnode is larger
		{
			while(heapAr[i].getRight().getData() != -1 || heapAr[i].getLeft().getData() != -1 && heapAr[i].getData() != -1) {//make sure we are performing our heapify actions on nodes and not uninitialized array indexes
				if(heapAr[i].getRight().getData() != -1 && heapAr[i].getRight().getData() > heapAr[i].getData())//right is still larger that parent
				{
					temp = heapAr[i].getData();//temp is set to the data value of heapAr
					heapAr[i].setData(heapAr[i].getRight().getData());//we set the heapAr value to the right node
					heapAr[i].getRight().setData(temp);//now set the right node 
				}
				else//we have reached a point where there is no comparison needed
				{
					break;
				}
			i++;
			}
		}
		else //last leaf satisfies the heap rules
		{
			return;
		}
		
	}
	public boolean add(int value)
	{
		if(!getRoot().isEmpty())
		{
			HeapTreeNode nodeExists = search(getRoot(), value);
			if(nodeExists != null)
			{
				throw new IllegalStateException();
			}
		}
		if(isFull()) //isFull comparison
		{
			System.out.println("Maxsize of heap has been reached!");
			return false; //no need to continue evaluating the insert method
		}
		else 
		{
			HeapTreeNode newNode = new HeapTreeNode(value); // create new node with data value that is to be inserted
			if(root.isEmpty())//base case
			{
				if(count == 0)
				{
					count = 1;
				}
				root = newNode; //root now is set to the node that we are to be inserting
				heapAr[count] = newNode; //make sure heapAr[ROOT] reflects the new changes
				count++;
				//don't need to percolate up since root is our only node
				return true;
			}
			else//node is not the root
			{
				heapAr[count] = newNode;
				heapAr[count].setParent(heapAr[getParentNode(count)]); //set the parent node to the evaluation of calling the getParentNode method
				if(heapAr[getParentNode(count)].getLeft().getData() == -1) //if the left node is null (hasn't been initialized yet)
				{
					heapAr[getParentNode(count)].setLeft(newNode); // set the left attribute for the parent node to the newNode that we are inserting
					heapify(root); //percolate up until the rules of the heap tree are satisfied
				}
				else
				{
					heapAr[getParentNode(count)].setRight(newNode); //set the right attribute for the parent node to the newNode that we are inserting
					heapify(root);//Percolate up until the rules of the heap tree are satisfied
				}
				count++;
				return true;
			}
		}
	}
	
	public void insert(int value)
	{
		if(!getRoot().isEmpty())
		{
			HeapTreeNode nodeExists = search(getRoot(), value);
			if(nodeExists != null)
			{
				throw new IllegalStateException();
			}
		}
		if(isFull()) //isFull comparison
		{
			System.out.println("Maxsize of heap has been reached!");
			return; //no need to continue evaluating the insert method
		}
		else 
		{
			HeapTreeNode newNode = new HeapTreeNode(value); // create new node with data value that is to be inserted
			if(root.isEmpty())//base case
			{
				if(count == 0)
				{
					count = 1;
				}
				root = newNode; //root now is set to the node that we are to be inserting
				heapAr[count] = newNode; //make sure heapAr[ROOT] reflects the new changes
				count++;
				//don't need to percolate up since root is our only node
				return;
			}
			else//node is not the root
			{
				heapAr[count] = newNode;
				heapAr[count].setParent(heapAr[getParentNode(count)]); //set the parent node to the evaluation of calling the getParentNode method
				if(heapAr[getParentNode(count)].getLeft().getData() == -1) //if the left node is null (hasn't been initialized yet)
				{
					heapAr[getParentNode(count)].setLeft(newNode); // set the left attribute for the parent node to the newNode that we are inserting
					heapify(root); //percolate up until the rules of the heap tree are satisfied
				}
				else
				{
					heapAr[getParentNode(count)].setRight(newNode); //set the right attribute for the parent node to the newNode that we are inserting
					heapify(root);//Percolate up until the rules of the heap tree are satisfied
				}
				count++;
			}
		}
	
	}
	
	public int remove(int value)
	{
		if(heapAr[ROOT] == null)
		{
			throw new NoSuchElementException();
		}
		if(!getRoot().isEmpty())
		{
			HeapTreeNode nodeExists = search(getRoot(), value);
			if(nodeExists == null)
			{
				throw new IllegalStateException();
			}
		}
		//find the root to use with search method
		HeapTreeNode deleteNode = search(getRoot(), value);
		//find the last leaf within the heap tree
		HeapTreeNode tempNode = findLastLeaf();
		//set the data for the node that we are deleting to the last leaf (saves us an extra step in the heapifyDown method)
		deleteNode.setData(tempNode.getData());
		//decrement count to reflect actual node count (keeps us from having to do count-1)
		count--;
		//set the last leaf's node to null (we do not need to utilize this node anymore)
		heapAr[count]=null;
		//clear the tempNode as well so that there truly is no data attributes linked to the last leaf node.
		tempNode.clearNode();
		//percolate down until the rules of a heap tree are satisfied
		heapifyDown(deleteNode);
		return -1;
	}
	public HeapTreeNode search(HeapTreeNode root, int value)
	{
		//base case for if heap is empty
		if(heapAr[ROOT] == null)
		{
			return null;
		}
		else
		{
			//loop only through all nodes that have been initialized in the heap tree (saves search time)
			for(int i = 1; i < count; ++i)
			{
				//System.out.println("XXXXXX");
				//System.out.println(heapAr[i].getData());
				
				//case for if we have found the node with the given value parameter that was passed
				if(heapAr[i].getData() == value)
				{
					//return the index
					return heapAr[i];
				}
			}
			return null;
		}
	}
	/**
	 * similar search method that also prints the index in which the location has been found. More useful for the user, but only works for string values
	 * @param value - The node to be searched for
	 * @return The node which contains the given value
	 */
	public Object searchArray(int value)
	{
		HeapTreeNode location;//variable for wherever we find the heapAr index with matching data values
		int i = 1; //beginning at root
		location = heapAr[ROOT];
		if (contains(value)) //only works for string values
		{
			while(heapAr[i] != null) //make sure that we aren't indexing out of bounds or into uninitialized values
			{
				if(heapAr[i].getData() == value) // we have found the value
				{
					System.out.println("Location found at index " + i); //print out index
					location = heapAr[i]; //set location to the node in which the value was found
				}
			 i++;
			}
		}
		else 
		{
			location = null; //we did not find the value
			System.out.println("Value not in heap tree");
			return location;
		}
		
		return location.getData(); //return the value of the location's data for easy visualization. does not return the node
	}
	//find maximum value within the heap tree
	public int getLargest()
	{
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		HeapTreeNode max = heapAr[ROOT]; //assume that heapify rules have been satisfied and that all that is needed is simply fetching the root node
		int i = 2;
		
		while(heapAr[i] != null) // make sure we are iterating through only initialized nodes within the heap tree
		{
			if(heapAr[i].getData() > max.getData())
				//return value of 1 means heapAr[i] is the larger value
				{ 
					max = heapAr[i]; //max is now the next value that is not the root node
				}
				i++;
			}
		return max.getData();
	}	
	//similar concept to findMax. Find minimum value within heap tree
	public int getSmallest()
	{
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		HeapTreeNode min = heapAr[ROOT]; //min set to root node
		int i = 2;
		while(heapAr[i] != null) //make sure we are iterating through only initialized nodes within the heap tree
		{
			if(heapAr[i].getData() < min.getData())
			//return value of 1 means heapAr[i] is a lower value
				{
					min = heapAr[i]; //min is now the next value that is not the root node
				}
				i++;
		}
		return min.getData();
	}
	public HeapTreeNode getSecondSmallest(HeapTreeNode root) {
        //we are only dealing with a binary tree w/ 1 node
		//do we call getSmallest instead?
		if(root.getRight().isEmpty() && root.getLeft().isEmpty())
        {
			throw new NoSuchElementException();
        }
	
		
		return heapAr[ROOT + 3];
	}
	public HeapTreeNode getSecondLargest(HeapTreeNode root) {
        //we are only dealing with a binary tree w/ 1 node
		//do we call getLargest instead?
        if(root.getRight().isEmpty() && root.getLeft().isEmpty())
        {
        	throw new NoSuchElementException();
        }
        //second largest is next node on right
        if(root.getRight().isEmpty())
        {
        	return heapAr[ROOT+1];
        }
        
        return heapAr[ROOT+2];
		}

	//returns true if value within heapAr[] is found. 
	public boolean contains(int value)
	{
		if(root.isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		int i = 1;//starting condition set to root, and then evaluates through each node until value is found
		while(heapAr[i] != null) //verifying that we aren't performing comparison on an uninitialized value within heapAr[]
		{
			if(heapAr[i].getData() == value)
			//0 denotes that both values are equal
			{
				return true;
			}
			i++;
		}
		return false;
	}
	
	//an empty heap tree is one in which there are no nodes inserted. To search for an empty condition we simply check to see if the root node has been initialized to a value, if not then it hasn't been inserted yet and thus is empty
	public boolean isEmpty(){
		if(root.getData() == -1)
		{
			return true;
		}
		return false;
	}
	
	//a full heap tree is one in which the number of nodes added has reached the size count originally set in the MaxHeapTree
	public boolean isFull() {
		if(count-1 == size) //count-1 since we start at i=1 in our heap tree
		{
			return true;
		}
		return false;
	}


	/**
	 * sort strategy that removes the root one at a time until no values are left within the heap tree
	 * @return An array of sorted nodes from a heap tree
	 */
	public Object heapSort()
	{
		if(heapAr[ROOT] == null)
		{
			throw new NoSuchElementException();
		}
		
		Object[] sortedArr = new Object[count-1]; //resorted to array of objects since an array of generics is not supported by java. Sorted Arr is the final array returned once all root nodes have been removed
		HeapTreeNode tempTree[]; //used as a copy of heapAr in order to maintain the structure of heapAr after the heapSort method has been called
		tempTree = (HeapTreeNode[]) new HeapTreeNode[size];
		int j = 0;
		
		//copy nodes initialized from heapAr[i] to tempTree[i]
		for(int i = 1; i < count; i++)
		{
			tempTree[i] = heapAr[i];
		}
		
		//beginning at count and working our way down, we remove each root, making sure to push the root value into the sortedArr
		while(count > 1)
		{
			sortedArr[j] = getRoot().getData();
			remove(getRoot().getData());
			j++;
		}
	
		//revert the heapAr structure back to how it was before the heapSort method was called
		for(int i = 1; i < count; i++)
		{
			heapAr[i] = tempTree[i];
		}
		
		return sortedArr;
	}

	
	/**
	 * prints the array received from heapSort()
	 */
	public void printSortedArray() //prints the array received from heapSort()
	{
		Object[] sortedArr = new Object[count];
		sortedArr = (Object[]) heapSort(); //creates new array and sets it to the sorted array
		
		System.out.printf("Sorted Array: "); //prints out the array
		for(int i = 0; i < sortedArr.length; i++)
		{
			System.out.print(sortedArr[i]+ " ");
		}
		//System.out.println("\n");
	}


	/**
	 * print the structure of the tree for visualization purposes
	 */
	public void printTree()
	{
		//print elements 2^n to elements 2^(n+1)
		double n = 0;
		int rows = height();
		for(int j = 1; j <= height; j++)
		{
			for(int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n+1); i++) //takes every element from 2^n to 2^(n+1)
			{
				if(heapAr[i] != null) //many ifs just for simplicity sake, made quick print statement for the tree display as tree
				{
					if(j == 1 && !heapAr[i].isEmpty())
					{
						System.out.printf("                  "+heapAr[i].getData()+"     "); //print first line
					}
					else if(j == 2 && !heapAr[i].isEmpty())
					{
						System.out.printf("         "+heapAr[i].getData()+"          "); //print second line
					}
					else if(j == 3 && !heapAr[i].isEmpty())
					{
						System.out.printf("    "+heapAr[i].getData()+"     "); //print third line
					} 
					else if(j == 4 && !heapAr[i].isEmpty())
					{
						System.out.printf("  "+heapAr[i].getData()+"   "); //print fourth line
					}
					else
					{
						break;
					}
				}
			}
			n++;
			System.out.printf("\n\n");
		}
		System.out.println("=====================================");
	}

	/**
	 * given the height of the heap tree, we call printGivenLevel for each height index until height is reached
	 */
	public void levelOrder()
	{
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		int i = 1;
	
		while(i<=height())
		{
			printGivenLevel(root, i);
			i++;
		}
		//System.out.println("================================");
	}

	/**
	 * starting at the level parameter set by method call in levelOrder, we go through recursively printing out each node within the level, passing in left or right as well as the level-1 in order to ensure we are actually fetching the next node in the level
	 * @param root - The root node of the tree
	 * @param level - The current level we are at in the tree
	 */
	public void printGivenLevel(HeapTreeNode root, int level)
	{
		//base case for if the root is empty
		if(root.isEmpty())
		{
			return;
		}
		//case for if the height is only 1 and there are no other children
		if(level == 1)
		{
			System.out.print(root.getData() + " ");
		}
		else if(level > 1)
		{
			printGivenLevel(root.getLeft(), level-1);
			printGivenLevel(root.getRight(), level-1);
		}
	}
	//similar to searchArray method, so return type is simply a call to the searchArray method.
	public int indexOf(int value) {
		return (int) searchArray(value);
	}



	public void inOrder(HeapTreeNode root) {
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
		//single-line output using print
		System.out.print(treeStack.pop() + " ");
		
		//condition for when there is no left-most node (we go right)
		if(!root.getRight().isEmpty())
		{
			inOrder(root.getRight());
		}
		treeStack.clear();
	}


	public void preOrder(HeapTreeNode root) {
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeStack.push(root);
		//beginning node to traverse through
		HeapTreeNode treeNode = root;
		
		while(!treeStack.isEmpty())
		{
			treeNode = (HeapTreeNode) treeStack.pop();
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


	public void postOrder(HeapTreeNode root) {
		//uninitaizlied bst
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
		
		//visit the leftmostNode until traversing right
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

	public boolean breadthFirst(HeapTreeNode root, int val)
	{
		//level order traversal to find a max value
		int nodeCount = 0;
		boolean valueFound = false;
		if(root.equals(EMPTY))
		{
			throw new NoSuchElementException();
		}
		treeQueue.enQueue(root);
		HeapTreeNode treeNode;
		
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
	

	public boolean depthFirst(HeapTreeNode root, int value, boolean valueFound)
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
	
	
	/**
	 * returns the size of the heap tree. Since we already have the nodeCount method that operates in a similar fashion we just return a call to the nodeCount method.
	 */
	public int size() {
		return nodeCount();
	}


	public boolean clear() {
		if(heapAr[ROOT] == null)
		{
			throw new NoSuchElementException();
		}
		if(!heapAr[ROOT].isEmpty())//base case to ensure that there are nodes to be cleared
		{
			int i =ROOT;//start at the root
			while(heapAr[i] != null)//until there are no more nodes left (until last leaf has been reached)
			{
				heapAr[i].clearNode();//make sure the clearNode method also removes the node
				heapAr[i]=null; //set the index of the node cleared to null	
				count--; //decrement count since we are removing such nodes
				i++;
			}
			heapAr[ROOT] = root; //apply the changes made to heapAr over to root.
			return true;
		}
		return false;
	}
	
	public static void main (String[] args)
	{
		//compute time to execute
		long before, after, total;
		System.out.println("Executing Bubble Sort");
		HeapSortArray example = new HeapSortArray();
		
		example.insert(80);
		example.insert(120);
		example.insert(90);
		example.insert(75);
		example.insert(110);
		example.insert(130);
		System.out.println("Array before sorting: ");
		example.printTree();
		System.out.println();
		before = System.currentTimeMillis();
		System.out.println("Array after sorting: ");
		example.printSortedArray();
		System.out.println();
		after = System.currentTimeMillis();
		total = after - before;
        System.out.println("Before time: " + before + " milliseconds");
        System.out.println("After time: " + after + " milliseconds");
        System.out.println("Total time to execute: " + total + " milliseconds");
		
	}
}
