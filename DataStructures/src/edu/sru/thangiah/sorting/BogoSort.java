package edu.sru.thangiah.sorting;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * BogoSort, one of the most powerful and widely used search algorithms to conquer efficiency in big data
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class BogoSort {
	
 public void bogoSort(int[] sortArray) //classic sorting algorithm, staple of all sorting
 {
	 int iterations = 0;
     while (isSorted(sortArray) == false) {
         shuffle(sortArray);
         iterations++;
     }
     System.out.println("BogoSort impressively sorted this array in " + iterations + " iterations. ");
 }

 public void shuffle(int[] sortArray) //randomly shuffles the array by swapping a random value with i
 {
     for (int i = 0; i < sortArray.length; i++)
         swap(sortArray, i, (int)(Math.random() * i));
 }
 
 public void swap(int[] sortArray, int i, int j) //swaps 2 values in the array
 {
     int temp = sortArray[i];
     sortArray[i] = sortArray[j];
     sortArray[j] = temp;
 }

 public boolean isSorted(int[] sortArray) //checks if the array is sorted
 {
     for (int i = 1; i < sortArray.length; i++) 
     {
    	 if (sortArray[i] < sortArray[i - 1])
    	 {
             return false;
    	 }
     }
     return true;
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
     int[] sortArray = {9, 2, 5, 1, 0, 4};
     BogoSort bogoArray = new BogoSort();
     before = System.currentTimeMillis();
     bogoArray.printArray(sortArray);
     bogoArray.bogoSort(sortArray);
     System.out.print("Sorted array: ");
     bogoArray.printArray(sortArray);
     after = System.currentTimeMillis();
     total = after - before;
     System.out.println("Total time to execute: " + total + " milliSeconds");
 }
}