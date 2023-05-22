package edu.sru.thangiah.sorting;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Insertion sort algorithm
 * Sort code from Duane Bailey book
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

import java.util.Random; //for random number generation

public class InsertionSort {
    private int maxArray = 3000;
    private int randArray[];

    /**
     * Constructor for the Bubble sort
     */
    public InsertionSort() {
        //create a random number object
        Random rn = new Random();

        //populate the array
        randArray = new int[maxArray];
        for (int i = 0; i < maxArray; i++) {
            randArray[i] = rn.nextInt();
        }
    }

    /**
     * print the array
     */
    public void printArray() {
        for (int i = 0; i < maxArray; i++) {
            System.out.println(randArray[i]);
        }
        System.out.println();
    }

    /**
     * Swap the i,j index in the data array
     * @param data int[]
     * @param i int
     * @param j int
     */
    public void swap(int data[], int i, int j) {
        // pre: 0 <= i,j < data.length
        // post: data[i] and data[j] are exchanged
        int temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * The sorted values are kept in the low end of the array, and the unsorted
     * values are found at the high end. The algorithm consists of several “passes”
     * of inserting the lowest-indexed unsorted value into the list of sorted values.
     * Once this is done,of course, the list of sorted values increases by one.
     * This process continues until each of the unsorted values has been incorporated
     * into the sorted portion of the array.
     * 
     * Worst Case: O(n^2)
     * @param data int[]
     * @param n int
     */
    public static void insertionSort(int data[], int n)
    // pre: 0 <= n <= data.length
    // post: values in data[0..n-1] are in ascending order
    {
        int numSorted = 1; // number of values in place
        int index; // general index
        while (numSorted < n) {
            // take the first unsorted value
            int temp = data[numSorted];
            // ...and insert it among the sorted:
            for (index = numSorted; index > 0; index--) {
                if (temp < data[index - 1]) {
                    data[index] = data[index - 1];
                } else {
                    break;
                }
            }
            // reinsert value
            data[index] = temp;
            numSorted++;
        }
    }

    /**
     * Check if the array has been sorted
     * @return boolean
     */
    public boolean isSorted() {
        boolean status = true;
        for (int i = 0; i < maxArray - 1; i++) {
            if (randArray[i] > randArray[i + 1]) {
                status = false;
                break; //discontinue loop
            }
        }
        return status;
    }


    public static void main(String[] args) {
        //compute time to execute
        long before, after, total;
        System.out.println("Executing Insertion Sort");
        InsertionSort insertInst = new InsertionSort();
        //print the array before sorting
        System.out.println("Array before sorting: ");
        insertInst.printArray();
        //sort the array
        before = System.currentTimeMillis();
        insertInst.insertionSort(insertInst.randArray, insertInst.maxArray);
        after = System.currentTimeMillis();
        total = after - before;
        System.out.println("Array after sorting: ");
        insertInst.printArray();
        System.out.println("Array has been sortet: " + insertInst.isSorted());
        System.out.println();
        System.out.println("Before time: " + before + " milliSeconds");
        System.out.println("After timee: " + after + " milliSeconds");
        System.out.println("Total time to execute: " + total + " milliSeconds");

    }
}
