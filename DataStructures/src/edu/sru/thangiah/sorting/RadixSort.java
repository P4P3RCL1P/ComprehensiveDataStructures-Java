package edu.sru.thangiah.sorting;

import java.util.Arrays;
import java.util.Random; //for random number generation

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Radix sort algorithm
 * Sort code modeled from implementation in Duane Bailey book
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class RadixSort {
	private int maxArray = 1500;
	private int randArray[];
	/**
	 * Constructor to initialize random array with 1500 random values
	 */
	public RadixSort()
	{
		//create a random number object
		Random rn  = new Random();
		
		//populate the array
		randArray = new int[maxArray];
		for(int i = 0; i < randArray.length; i++)
		{
			randArray[i] = Math.abs(rn.nextInt());
		}
		//System.out.println(randArray.length);
	}
	/**
	 * Gets the number with the largest number of digits so radix knows
	 * how many places to sort.
	 * @return
	 */
	public int findMax(int randArray[]) 
	{
		int max  = randArray[0];
		for(int i = 1; i< randArray.length; i++)
		{
			if(randArray[i] > max)
			{
				max = randArray[i];
			}
		}
		return max;
	}
	/**
	 * Stores the occurrences of each digit (0-9) and sorts
	 * the occurrences based on these digits.
	 * 
	 * First store the count of occcurences (0-9)
	 * Next, store the cummulative sum of all the occurences (0-9)
	 * Finally, take the value in the original array and map it to
	 * the corresponding index in the count array. After subtracting
	 * one from the cumulative sum we have our output index which is sorted.
	 * 
	 * src: Bailey, D., 2007. Java Structures: Data Structures in Java for the Principled Programmer. New York: McGraw-Hill.
	 * @param randArray - The array to be sorted
	 * @param place - The current place (ones, tens, hundreds, etc.) we are sorting
	 */
	public void countSort(int randArray[], int place)
	{
		int sortedByPlaceAr[] = new int[randArray.length];
		int count[] = new int[10];

		for(int i = 0; i < randArray.length; i++)
		{
			count[randArray[i]/place % 10]++;
		}
		//find occurrence of digits for all numbers sorted by place
		for(int i = 1; i< 10; i++)
		{
			count[i] += count[i-1];
		}
		
		//sort the numbers by the given place (ones, tens, hundreds, thousands, etc...)
		for(int i = randArray.length-1; i>=0; i--)
		{
			sortedByPlaceAr[count[randArray[i]/place %10]-1] = randArray[i];
			count[randArray[i]/place % 10]--;
		}
		
		//Set the passed ar to the new sorted by place ar
		//in order to sort for the next place.
		for(int i = 0; i<randArray.length; i++)
		{
			randArray[i] = sortedByPlaceAr[i];
		}
	}
	/**
	 * Sort strategy which performs count sort
	 * for each digit column in the array elements (ones, tens, hundreds, etc.).
	 * Increases in complexity given the number of digits we have to sort by
	 * and the size of the array. 
	 * 
	 * Worst case: O(nk)
	 */
    public void radixSort() {
    	int max = findMax(randArray);
    	//int numDigits = (int)(Math.log10(max) + 1);
    	
    	for (int place = 1; max/ place > 0; place*=10)
    	{
    		countSort(randArray, place);
    	}
    	
    	//System.out.println(Arrays.toString(randArray));
    }
    /**
     * Check if the array has been sorted
     * @return Boolean value for if the array is sorted or not
     */
    public boolean isSorted()
    {
    	boolean sorted = true;
    	for(int i = 0; i < maxArray - 1; i++)
    	{
    		if(randArray[i] > randArray[i + 1])
    		{
    			sorted = false;
    			break;
    		}
    	}
    	return sorted;
    }
    /**
     * Method for printing out the array
     */
    public String toString()
    {
    	System.out.println(Arrays.toString(randArray));
		return "";
    
    }
    
    public static void main(String[] args)
    {
    	long before, after, total;
    	System.out.println("Executing Radix Sort");
    	RadixSort example = new RadixSort();
    	System.out.println("Array before sorting: ");
    	example.toString();
    	before = System.currentTimeMillis();
    	example.radixSort();
    	after = System.currentTimeMillis();
    	total = after - before;
    	System.out.println("Array after sorting: ");
    	example.toString();
        System.out.println("Array has been sorted: " + example.isSorted());
        System.out.println();
        System.out.println("Before time: " + before + " milliSeconds");
        System.out.println("After timee: " + after + " milliSeconds");
        System.out.println("Total time to execute: " + total + " milliSeconds");
    }
}
