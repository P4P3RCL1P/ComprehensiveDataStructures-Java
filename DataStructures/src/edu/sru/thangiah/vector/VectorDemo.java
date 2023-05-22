package edu.sru.thangiah.vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
	


    /**
     *  printVector() prints its parameter. Note the use of
     *   v.size to determine the number of elements in the vector.
     *  @param v -- a Vector
     */
    public static void printVector( Vector v) {
        for (int k=0; k < v.size(); k++)
            System.out.println(v.elementAt(k));
    } // printVector()
    
    public static void printVectorIterator(Vector v) {
    	//Get the iterator
    	Iterator it = v.iterator();
    	
    	while (it.hasNext())    
    	{
    		System.out.println(it.next());
    		
    	}
        //for (int k=0; k < v.size(); k++)
        //    System.out.println(v.indexOf(k));
    } // p

    /**
     *  main() creates a Vector object and adds elements to it.
     */
    public static void main(String args[]) {
        Vector vector = new Vector();            // An empty vector

        int bound = (int)(Math.random() * 20);
        for (int k = 0; k < bound; k++ )         // Insert a random 
            vector.addElement(k);  				 //  number of Integers
        //printVector(vector);                     // Print the elements
        printVectorIterator(vector);
    } // main()


}
