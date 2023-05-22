package edu.sru.thangiah.sorting;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Selection sort algorithm
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

public class SelectionSort {
    private int maxArray = 2500;
    private int randArray[];


    /**
     * Constructor for the selection sort
     */
    public SelectionSort() {
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
     * The goal is to identify the index of the largest element of the array.
     * Assume the first element is the largest, and then form a competition among all the
     * remaining values. As we come across larger values, we update the index of the
     * current maximum value. In the end, the index must point to the largest value.
     * 
     * Worst case: O(n^2)
     * @param data int[]
     * @param n int
     */
    public void selectionSort(int data[], int n)
    // pre: 0 <= n <= data.length
    // post: values in data[0..n-1] are in ascending order
    {
        int numUnsorted = n;
        int index; // general index
        int max; // index of largest value
        while (numUnsorted > 0) {
            // determine maximum value in array
            max = 0;
            for (index = 1; index < numUnsorted; index++) {
                //if higher, get index
                if (data[max] < data[index]) {
                    max = index;
                }
            }
            swap(data, max, numUnsorted - 1);
            numUnsorted--;
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
        System.out.println("Executing Selection Sort");
        SelectionSort selectInst = new SelectionSort();
        //print the array before sorting
        System.out.println("Array before sorting: ");
        selectInst.printArray();
        //sort the array
        before = System.currentTimeMillis();
        selectInst.selectionSort(selectInst.randArray, selectInst.maxArray);
        after = System.currentTimeMillis();
        total = after - before;
        System.out.println("Array after sorting: ");
        selectInst.printArray();
        System.out.println("Array has been sorted: " + selectInst.isSorted());
        System.out.println();
        System.out.println("Before time: " + before + " milliSeconds");
        System.out.println("After timee: " + after + " milliSeconds");
        System.out.println("Total time to execute: " + total + " milliSeconds");

    }
}
