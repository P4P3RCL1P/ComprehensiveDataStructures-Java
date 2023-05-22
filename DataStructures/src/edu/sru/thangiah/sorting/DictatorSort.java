package edu.sru.thangiah.sorting;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * A classic sorting algorithm that only has one drawback, minor data loss
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class DictatorSort {
	
//construc
 public int[] dictatorSort(int[] sortArray) //classic sorting algorithm, staple of all sorting
 {
	 int iterations = 1; //only 1, impressive right?
	 int count = 0;
	 for (int i = 0; i < sortArray.length-1; i++) 
     {
    	 if (sortArray[i] > sortArray[i + 1])
    	 {
    		 sortArray = removeElement(sortArray, i+1); //will remove elements that are not sorted in ascending order
    		 count++;
    	 }
     }
     System.out.println("Dictator sort courageously sorted this array in " + iterations + " iterations."
    		 + "\nOnly " + count + " elements were lost in the sort");
     
     return sortArray;
 }
 
 public int[] removeElement(int[] arr, int index)
 {
	 int[] tempArray = new int[arr.length - 1]; //creates a new array with a smaller length
	 
	 for (int i = 0, k = 0; i < arr.length; i++)  //cycles through each array and adds, except for the indicated index
	 {
         if (i == index) 
         {
             continue; //skip the index
         }
         tempArray[k++] = arr[i];
     }
	 return tempArray;
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
     DictatorSort dictatorArray = new DictatorSort();
     before = System.currentTimeMillis();
     System.out.print("Unsorted array: ");
     dictatorArray.printArray(sortArray);
     sortArray = dictatorArray.dictatorSort(sortArray);
     System.out.print("Sorted array: ");
     dictatorArray.printArray(sortArray);
     after = System.currentTimeMillis();
     total = after - before;
     System.out.println("Total time to execute: " + total + " milliSeconds");
 }
}