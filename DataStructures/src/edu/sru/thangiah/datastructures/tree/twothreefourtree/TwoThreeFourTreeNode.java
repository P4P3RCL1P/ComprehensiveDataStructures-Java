package edu.sru.thangiah.datastructures.tree.twothreefourtree;

/**
 * 
 * @author briso
 *
 */
public class TwoThreeFourTreeNode {
	
	final int TWOTHREEFOURCONSTANT = 4;
	
	private int type; //type refers to 
	
	private int[] values = new int[TWOTHREEFOURCONSTANT-1];
	
	private TwoThreeFourTreeNode parent;
	
	private TwoThreeFourTreeNode children[] = new TwoThreeFourTreeNode[TWOTHREEFOURCONSTANT];
	
	private static final TwoThreeFourTreeNode EMPTY = new TwoThreeFourTreeNode();

	TwoThreeFourTreeNode(){
		
		type = 0;
		values[0]=-1;
		values[1]=-1;
		values[2]=-1;
		parent = EMPTY;
		children[0]=EMPTY;
		children[1]=EMPTY;
		children[2]=EMPTY;
		children[3]=EMPTY;
		
	}

	TwoThreeFourTreeNode(int value){
		
		type = 1;
		values[0]=value;
		values[1]=-1;
		values[2]=-1;
		parent = EMPTY;
		children[0]=EMPTY;
		children[1]=EMPTY;
		children[2]=EMPTY;
		children[3]=EMPTY;
		
	}
	
	/**
	 * Method used to clear the node of any values and children
	 * @return true upon successful completion
	 */
	public boolean clearNode(){
		
		type = 0;
		values[0]=-1;
		values[1]=-1;
		values[2]=-1;
		parent = null;
		children[0]=this;
		children[1]=this;
		children[2]=this;
		children[3]=this;
		return true;
				
	}
	
	/**
	 * Method used to return the parent of the node
	 * @return node - parent 
	 */
	public TwoThreeFourTreeNode getParent() {
		
		return parent;
		
	}

	/**
	 * Method used to set the parent node of the current node
	 * @param parent- node to be set as the node's parent
	 */
	public void setParent(TwoThreeFourTreeNode parent) {
		
		this.parent = parent;
		
	}

	/**
	 * Method used to retrieve an array of children nodes that the child node possesses
	 * @return children - node array
	 */
	public TwoThreeFourTreeNode[] getChildren() {
		
		return children;
		
	}
	
	/**
	 * Method used to get a specified child in the children array at a given index
	 * @param index - int value 0-3
	 * @return
	 */
	public TwoThreeFourTreeNode getChild(int index) {
		
		if(index<0||index>3) {
			return null;
		}
		return children[index];
		
	}

	/**
	 * Method used to set the children array of the current node
	 * @param nodes - an array of children nodes
	 * @return true upon successful completion
	 */
	public boolean setChildren(TwoThreeFourTreeNode[] nodes) {
		
		this.children = nodes;
		return true;
		
	}

	/**
	 * Method used to set a specific node in the children array of 
	 * the current node.
	 * @param node - the node being added
	 * @param index - int value where we wish to add the node
	 * @return true upon successful completion
	 */
	public boolean setChild(TwoThreeFourTreeNode node, int index) {
		
		if(index<0||index>3)
			return false;
			
		this.children[index]=node;
		return true;
		
	}

	/**
	 * Method used to set the values array of the current node
	 * @param values - an int array of values
	 */
	public void setValues(int[] values) {
		
		this.values=values;
		
	}
	
	/**
	 * Method used to set a specific value at an index
	 * in the array values
	 * @param value - the int value being added to the current node
	 * @param index - the int index we wish to add that node at
	 */
	public void setValue(int value, int index) {
		
		this.values[index]=value;
		
	}
	
	/**
	 * Method used to get the values int array of the current node
	 * @return values- int array of values the node possesses
	 */
	public int[] getValues() {
		
		return values;
		
	}
	
	/**
	 * Method used to return the value in the values array at a 
	 * given index
	 * @param index - the int value index we wish to get the value from in values
	 * @return the int value at given index
	 */
	public int getValue(int index) {
		
		if(index<0||index>2)
			return -1;
		
		return values[index];
		
	}
	
	/**
	 * Method used to get the int type of node the node is, this
	 * is an int of the amount of values in the node
	 * @return type -int value the node possesses
	 */
	public int getType() {
		
		return type;
		
	}

	/**
	 * Method used to set the type of the node
	 * @param type - the int value we wish to set the node as
	 */
	public void setType(int type) {
		
		this.type = type;
		
	}
	
	/**
	 * Method used to check if the node is empty through verifying
	 * the first value, where values will be stored in first, is 
	 * equal to -1, making the tree null
	 * @return true if the node is empty.
	 */
	public boolean isEmpty() {
		
		if(values[0]==-1) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Method used to check if the given node equates to the constant
	 * empty node, EMPTY
	 * @return true if successful
	 */
	public boolean isEMPTY() {
		
		if( this == EMPTY) {
		
			return true;
		
		}else {
			
			return false;
		
		}
		
	}
	
	/**
	 * method used to insert a specified value into the node, shift the values and increment
	 * the count if this is done correctly.
	 * @param int value
	 * @return true upon successful completion
	 */
	public boolean insertValue(int value) {
		
		//this method is going to swap around values
		
		if(this.type==3) { //if the node has three values then you cannot insert a value...
			
			return false;
		
		} else if(this.contains(value)>=0) {
			
			return false;
			
		} else if (this.getType()==0) {
			
			values[0]=value;
			type++;
			return true;
		
		} else if (type==2){
			
			if(value>values[1]) { //value is largest
				
				values[2]=value;
				type++;
				return true;
				
			}else if(value>values[0]) { //value is bigger than value 1 
				
				values[2]=values[1];
				values[1]=value;
				children[3]=children[2];
				children[2]=children[1];
				children[1]=EMPTY;
				values[1]=value;
				type++;
				return true;
				
			}else { //value is smaller than other values
				
				values[2]=values[1];
				values[1]=values[0];
				values[0]=value;
				children[3]=children[2];
				children[2]=children[1];
				children[1]=children[0];
				children[0]=EMPTY;
				type++;
				return true;
				
			}
			
		} else {
			
			//type is 1 
			
			if(value>values[0]) { //value is bigger than value 1 
				
				values[2]=values[1];
				values[1]=value;
				children[3]=children[2];
				children[2]=children[1];
				children[1]=EMPTY;
				values[1]=value;
				type++;
				return true;
				
			}else { //value is smaller than other values
				
				values[2]=values[1];
				values[1]=values[0];
				values[0]=value;
				children[3]=children[2];
				children[2]=children[1];
				children[1]=children[0];
				children[0]=EMPTY;
				type++;
				return true;
				
			}
			
			
		}
		
	}
	
	/**
	 * Method used to connect a child node to the node. Works if the node is
	 * type 0,1,2 but not if 3, or if a child node is in the location that 
	 * it is supposed to go in. For precondition, we will need to check
	 * that the location that the child node is going to go into
	 * is empty
	 * 
	 * @param childNode being added
	 * @return true upon successful implementation
	 */
	public boolean connectChild(TwoThreeFourTreeNode childNode) {

		if(this.isEmpty()) {
		
			this.setChild(childNode, 0);
		
		}else {
			
			int value = childNode.getValue(0);
			
			for(int i = 0; i < type; i++) {
				
				if(value<this.getValue(i)) {
					
					if(this.getChild(i).isEmpty()) {
						
						this.setChild(childNode, i);
						childNode.setParent(this);
						return true;
						
					} else {
						
						System.out.println("not overwriting a child");
						return false;
						
					}
					
				}
				
			}
			
			if(this.getValue(this.getType())< value) {
				
				if(this.getChild(this.getType()+1)==EMPTY) {
					
					this.setChild( childNode, this.getType());
					return true;
					
				}else {
					
					System.out.println("not overwriting a child");
					return false;
					
				}
				
			}
		
		}
		
		return false;
		
	}
	
	/**
	 * Method used to check if the node has a specified value, 
	 * return -1 if not, or the index that it is in if it does
	 * @param int value being checked for
	 * @return -1 or int index
	 */
	public int contains(int value) {
		
		if(this.isEmpty()) {
			
			return -1;
			
		} else if(values[0]==value) {
			
			return 0;
			
		} else if(values[1]==value) {
			
			return 1;
			
		} else if(values[2]==value) {
			
			return 2;
			
		} else {
			
			return -1;
			
		}
		
	}
	
	/**
	 * Method used to print to console the values in the 
	 * current node, mainly for testing purposes
	 */
	public void printValues() {
		
		System.out.println("Values: " + values[0] + ", "  + values[1] + ", " + values[2]);
		
	}
	
}
