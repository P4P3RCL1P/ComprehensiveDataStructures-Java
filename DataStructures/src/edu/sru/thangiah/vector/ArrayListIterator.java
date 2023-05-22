package edu.sru.thangiah.vector;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIterator {
	


    /**
     *  printVector() prints its parameter. Note the use of
     *   v.size to determine the number of elements in the vector.
     *  @param v -- a Vector
     */
    public static void printArrayList(ArrayList v) {
    	//Get the iterator
    	Iterator it = v.iterator();
    	
    	while (it.hasNext())    
    	{
    		System.out.println(it.next());
    	}
        //for (int k=0; k < v.size(); k++)
        //    System.out.println(v.indexOf(k));
    } // printVector()

    /**
     *  main() creates a Vector object and adds elements to it.
     */
    public static void main(String args[]) {
        ArrayList arrayList = new ArrayList();            // An empty vector

        int bound = (int)(Math.random() * 20);
        for (int k = 0; k < bound; k++ )         // Insert a random 
        	arrayList.add(k);			 //  number of Integers
        printArrayList(arrayList);                     // Print the elements
    } // main()


}