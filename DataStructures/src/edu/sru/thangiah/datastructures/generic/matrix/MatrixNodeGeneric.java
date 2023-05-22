package edu.sru.thangiah.datastructures.generic.matrix;

/*
 * Helper class which creates the individual nodes in the matrix.
 * Note that we have up, down, left, and right attributes which denotes
 * the elements near the given node. This is helpful for quick traversals/deletions.
 */
/**
 * <p>Title: MatrixNodeGeneric</p>
 *
 * <p>Description: </p>
 * Helper class which creates the individual nodes in the matrix.
 * Note that we have up, down, left, and right attributes which denotes
 * the elements near the given node. This is helpful for quick traversals/deletions.
 *
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class MatrixNodeGeneric<T> {
	   /**
	    * Pointer which is set to the node above the target node
	    */
	   private MatrixNodeGeneric up;
	   /**
	    * Pointer which is set to the node above the target node
	    */
	   private MatrixNodeGeneric down;
	   /**
	    * Pointer which is set to the node to the left of the target node
	    */
	   private MatrixNodeGeneric left;
	   /**
	    * Pointer which is set to the node to the right of the target node
	    */
	   private MatrixNodeGeneric right;
	   /**
	    * Variable to store the data for a given node
	    */
	   private T data;

	   /**
	    * initial data of value, connections null
	    * @param initialValue - sets the data to the parameter value
	    */
	   public MatrixNodeGeneric(T initialValue) {
	       data = initialValue;
	       up = null;
	       down = null;
	       left = null;
	       right = null;
	   }

	   /**
	    *  sets an initial value of -1 connections null
	    */
	   public MatrixNodeGeneric() {
	       data = null;
	       up = null;
	       down = null;
	       left = null;
	       right = null;
	   }
	   
	   /**
	    * Getter method for up pointer
	    * @return The up pointer
	    */
	   public MatrixNodeGeneric getUp() {
	       return up;
	   }
	   
	   /**
	    * Setter method for the up pointer
	    * @param newNode - Node to be set as new value for up pointer
	    */
	   public void setUp(MatrixNodeGeneric newNode) {
	       up = newNode;
	   }

	   /**
	    * Getter method for the down pointer
	    * @return The down pointer
	    */
	   public MatrixNodeGeneric getDown() {
	       return down;
	   }

	   /**
	    * Setter method for the down pointer
	    * @param newNode - Node to be set as new value for down pointer
	    */
	   public void setDown(MatrixNodeGeneric newNode) {
	       down = newNode;
	   }
	 
	   /**
	    * Getter method for the left pointer
	    * @return The left pointer
	    */
	   public MatrixNodeGeneric getLeft() {
	       return left;
	   }
	   /**
	    * Setter method for the Left pointer
	    * @param newNode - Node to be set as new value for left pointer
	    */
	   public void setLeft(MatrixNodeGeneric newNode) {
	       left = newNode;
	   }
	 
	   /**
	    * Getter method for the right pointer
	    * @return The right pointer
	    */
	   public MatrixNodeGeneric getRight() {
	       return right;
	   }
	 
	   /**
	    * Setter method for the right pointer
	    * @param newNode - Node to be set as new value for right pointer
	    */
	   public void setRight(MatrixNodeGeneric newNode) {
	       right = newNode;
	   }
	 
	   /**
	    * Getter method for data variable
	    * @return The value of the data variable
	    */
	   public T getData() {
	       return data;
	   }
	 
	   /**
	    * Setter method for the data variable
	    * @param value - The new value which will be set to the data variable
	    */
	   public void setData(T value) {
	       data = value;
	   }
	}