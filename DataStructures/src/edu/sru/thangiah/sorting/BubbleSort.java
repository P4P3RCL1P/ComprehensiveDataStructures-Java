package edu.sru.thangiah.sorting;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Bubble sort algorithm
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

public class BubbleSort {
    private int maxArray = 1500;
    private int randArray[];

    /**
     * Constructor for the Bubble sort
     */
    public BubbleSort() {
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
     * After a single pass the largest value will end up “bubbling” up to the highindexed
     * side of the array. The next pass will, at least, bubble up the next largest
     * value, and so forth. The sort—called bubble sort—must be finished after n \u2212 1
     * passes.
     *
     * Worst case: O(n^2)
     * @param data int[]
     * @param n int
     */
    public void bubbleSort(int data[], int n)
    // pre: 0 <= n <= data.length
    // post: values in data[0..n-1] in ascending order
    {
        int numSorted = 0; // number of values in order
        int index; // general index
        while (numSorted < n) {
            // bubble a large element to higher array index
            for (index = 1; index < n - numSorted; index++) {
                if (data[index - 1] > data[index]) {
                    swap(data, index - 1, index);
                }
            }
            // at least one more value in place
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
        System.out.println("Executing Bubble Sort");
        BubbleSort bubInst = new BubbleSort();
        //print the array before sorting
        System.out.println("Array before sorting: ");
        bubInst.printArray();
        //sort the array
        before = System.currentTimeMillis();
        bubInst.bubbleSort(bubInst.randArray, bubInst.maxArray);
        after = System.currentTimeMillis();
        total = after - before;
        System.out.println("Array after sorting: ");
        bubInst.printArray();
        System.out.println("Array has been sorted: " + bubInst.isSorted());
        System.out.println();
        System.out.println("Before time: " + before + " milliSeconds");
        System.out.println("After timee: " + after + " milliSeconds");
        System.out.println("Total time to execute: " + total + " milliSeconds");
    }
}
