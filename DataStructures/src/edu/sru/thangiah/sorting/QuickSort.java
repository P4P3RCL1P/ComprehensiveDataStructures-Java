package edu.sru.thangiah.sorting;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Quick sort algorithm
 *
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

public class QuickSort {
    private int maxArray = 60;
    private int randArray[];
    boolean isDebug= false;

    /**
     * Constructor for the Bubble sort
     */
    public QuickSort() {
    	
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


    
    private int partition(int data[], int left, int right)
    // pre: left <= right
    // post: data[left] placed in the correct (returned) location
    {
        while (true) {
            // move right "pointer" toward left
            while (left < right && data[left] < data[right]) {
                right--;
            }
            if (left < right) {
                swap(data, left++, right);
            } else {
                return left;
            }
            // move left pointer toward right
            while (left < right && data[left] < data[right]) {
                left++;
            }
            if (left < right) {
                swap(data, left, right--);
            } else {
                return right;
            }
        }
    }


    public void quickSort(int data[], int n)
    // post: the values in data[0..n-1] are in ascending order
    {
        quickSortRecursive(data, 0, n - 1);
    }

    private void quickSortRecursive(int data[], int left, int right)
    // pre: left <= right
    // post: data[left..right] in ascending order
    {
        int pivot; // the final location of the leftmost value
        if (left >= right) {
            return;
        }
        pivot = partition(data, left, right); /* 1 - place pivot */
        quickSortRecursive(data, left, pivot - 1); /* 2 - sort small */
        quickSortRecursive(data, pivot + 1, right); /* 3 - sort large */
        /* done! */
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
        System.out.println("Executing Quick Sort");
        QuickSort quickInst = new QuickSort();
        //print the array before sorting
        System.out.println("Array before sorting: ");
        quickInst.printArray();
        //sort the array
        before = System.currentTimeMillis();
        //high is one less than maximum
        quickInst.quickSortRecursive(quickInst.randArray, 0,
                                     quickInst.maxArray - 1);
        after = System.currentTimeMillis();
        total = after - before;
        System.out.println("Array after sorting: ");
        quickInst.printArray();
        System.out.println("Array has been sorted: " + quickInst.isSorted());
        System.out.println();
        System.out.println("Before time: " + before + " milliSeconds");
        System.out.println("After timee: " + after + " milliSeconds");
        System.out.println("Total time to execute: " + total +
                           " milliSeconds");

    }

}
