package edu.sru.thangiah.datastructures.matrix;

//import edu.sru.thangiah.datastructures.BaseOpsInt;
/**
 * <p>Title: AbstractMatrix</p>
 *
 * <p>Description: </p>
 * Abstract template used for the creation of a matrix datastructure. 
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public abstract class AbstractMatrix{
	
	/**
	 * Sets the value for a given row and column
	 * @param m - Specifies the row
	 * @param n - Specifies the column
	 * @param value - Specifies the value to insert
	 * @return True based on successful method call
	 */
	public boolean setData(int m, int n, int value) {
		return false;
	}
	
	/**
	 * Gets the value for an element at a given row and column
	 * @param m - Specifies the row
	 * @param n - Specifies the column
	 * @return The data of the element in the matrix
	 */
	public int getData(int m, int n) {
		return -1;
	}

}
