package edu.sru.thangiah.datastructures.generic.tree.redblacktree;

public class RedBlackTreeNodeGeneric<T> {
	private T data;

	private RedBlackTreeNodeGeneric<T> parent;
	private RedBlackTreeNodeGeneric<T> left;
	private RedBlackTreeNodeGeneric<T> right;
	private boolean color; //false = red true = black
	
	private static final RedBlackTreeNodeGeneric  EMPTY = new RedBlackTreeNodeGeneric(null);


	RedBlackTreeNodeGeneric() {

		data = null;
		parent = EMPTY;
		left= EMPTY;
		right= EMPTY;
		color= false;

	}

	RedBlackTreeNodeGeneric(T data) {
		this.data = data;
		parent = EMPTY;
		left = EMPTY;
		right = EMPTY;
		color = false;
	}

	public boolean clearNode()
	{
		this.data = null;
		setParent(null);
		setLeft(this);
		setRight(this);
		color=false;
		
		return true;
	}
	
	public T getData() {
		return data;
	}

	public boolean setData(T data) {
		this.data = data;
		return true;
	}
	
	public boolean getColor() {

		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public RedBlackTreeNodeGeneric getParent() {

		return parent;
	}

	public void setParent(RedBlackTreeNodeGeneric parent) {
		this.parent = parent;
	}

	public RedBlackTreeNodeGeneric getLeft() {

		return left;
	}

	public void setLeft(RedBlackTreeNodeGeneric left) {
		this.left = left;
	}

	public RedBlackTreeNodeGeneric getRight() {

		return right;
	}

	public void setRight(RedBlackTreeNodeGeneric right) {
		this.right = right;
	}

	public boolean isLeaf() {

		if (left != null) {
			return false;
		}
		return true;
	}

	public boolean isFull() {

		if (data != null) {
			return true;
		}
		return false;
	}

	public boolean isEmpty()
	{
		if(this.getData() == null)
		{
			return true;
		}
		return false;
	}
	public boolean isEMPTY()
	{
		if(this == EMPTY)
		{
			return true;
		}
		return false;
	}
}