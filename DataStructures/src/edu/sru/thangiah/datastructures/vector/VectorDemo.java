package edu.sru.thangiah.datastructures.vector;
import java.util.*;

/*
 * Very simple demonstration of using vector
 */

/**
 * <p>Title: VectorDemo</p>
 *
 * <p>Description: </p>
 * Demonstrates the usage of vector (integers) 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class VectorDemo {
	public static void main (String args[]) {
		
		int maxSize;
		maxSize = (int)((Math.random() * 20)+1);
		Vector vect = new Vector();
		
		
		for (int i = 0; i<maxSize; i++)
		{
			vect.addElement(i); //adds i to vect
		}
		for (int j = 0; j<vect.size(); j++)
		{
			System.out.println(vect.get(j)); //elementAt, get methods
		}
		//metadata 
		//information about self (Query vector to gain information about size, element, etc.)
		System.out.println(vect.lastElement());
		System.out.println(vect.indexOf(1));
	}
	
	
}
