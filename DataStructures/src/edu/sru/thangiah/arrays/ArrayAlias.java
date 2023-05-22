package edu.sru.thangiah.arrays;
/*
 * Since we statically initialize a2 to a1 any changes
 * made to a2 are also made to a1. Printing out the contents
 * of a1 gives us 2, 3, 4, 5, 6 since we incremented a2.
 */

/**
 * <p>Title: ArrayAlias </p>
 *
 * <p>Description: </p>
 * Arrays can be aliased in Java during assignment. A1 and a2 are array reference variables so any changes made to a2 are also made to a1.
 * Printint out the contents of a1 gives us 2, 3, 4, 5, 6 since we incremented a2.
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class ArrayAlias {
  /**
  * Main method
  * @param args The command line arguments.
  */  	
  public static void main(String[] args) {
	/**
	 * Static initialization of array
	 */
    int[] a1 = { 1, 2, 3, 4, 5 };
	/**
	 * a2 points to a1 so any changes made to a2 are also made to a1
	 */
    int[] a2;
    a2 = a1;
    for(int i = 0; i < a2.length; i++)
      a2[i]++;
    for(int i = 0; i < a1.length; i++)
      System.out.println(
        "a1[" + i + "] = " + a1[i]);
  }
} 
