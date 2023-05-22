package edu.sru.thangiah.sorting;
/**
 * <p>Title: IntelligentDesignSort</p>
 *
 * <p>Description: </p>
 *Intelligent design sort is a sorting algorithm based on the theory of intelligent design.
 *
 *
 * <p>Algorithm Description: </p>
 *
 *The probability of the original input list being in the exact order it's in is 1/(n!). There is such a small
 *likelihood of this that it's clearly absurd to say that this happened by chance, so it must have been
 *consciously put in that order by an intelligent Sorter. Therefore it's safe to assume that it's already
 *optimally Sorted in some way that transcends our naïve mortal understanding of "ascending order".
 *Any attempt to change that order to conform to our own preconceptions would actually make it less sorted
 *
 *<p>Analysis: </p>
 *
 *This algorithm is constant in time, and sorts the list in-place, requiring no additional memory at all. In
 *fact, it doesn't even require any of that suspicious technological computer stuff. Praise the Sorter!
 *
 *<p>Feedback: </p>
 *
 *Gary Rogers writes: Making the sort constant in time denies the power of The Sorter. The Sorter exists
 *outside of time, thus the sort is timeless. To require time to validate the sort dimishes the role of the
 *Sorter. Thus... this particular sort is flawed, and can not be attributed to 'The Sorter'. Heresy!
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class IntelligentDesignSort {

	public int[] intelligentDesignSort(int[] sortArray)
	{
		//The probability of the original input list being in the exact order it's in is 1/(n!). There is such a small
		//likelihood of this that it's clearly absurd to say that this happened by chance, so it must have been
		//consciously put in that order by an intelligent Sorter. Therefore it's safe to assume that it's already
		//optimally Sorted in some way that transcends our naïve mortal understanding of "ascending order".
		//Any attempt to change that order to conform to our own preconceptions would actually make it less sorted
		return sortArray;
	}
	public void printArray(int[] arr)
	{
	    for (int i = 0; i < arr.length; i++)
	    {
	        System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	}
	 public static void main(String[] args)
	 {
		 long before, after, total;
	     //int[] sortArray = {3, 2, 5, 1, 0, 4};
	     int[] sortArray = {3,6,7,5,9,2,10};
	     IntelligentDesignSort intelligentDesignArray = new IntelligentDesignSort();
	     before = System.currentTimeMillis();
	     System.out.print("Unsorted array: ");
	     intelligentDesignArray.printArray(sortArray);
	     sortArray = intelligentDesignArray.intelligentDesignSort(sortArray);
	     System.out.print("Sorted array: ");
	     intelligentDesignArray.printArray(sortArray);
	     after = System.currentTimeMillis();
	     total = after - before;
	     System.out.println("Total time to execute: " + total + " milliSeconds");
	 }
}
