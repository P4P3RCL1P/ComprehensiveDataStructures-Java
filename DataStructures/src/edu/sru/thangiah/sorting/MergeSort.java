package edu.sru.thangiah.sorting;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Merge sort algorithm
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

public class MergeSort {
    private int maxArray = 60;
    private int randArray[];
    private int tempArray[]; //used by the merge sort

    /**
     * Constructor for the Bubble sort
     */
    public MergeSort() {
        //create a random number object
        Random rn = new Random();

        //populate the array
        randArray = new int[maxArray];
        for (int i = 0; i < maxArray; i++) {
            randArray[i] = rn.nextInt();
        }
        //create the data array
        tempArray = new int[maxArray];
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
     * Assume that the data from the two lists are located in the two arrays—in the
     * lower half of the range in temp and in the upper half of the range in data (see
     * Figure 6.5a). The first loop compares the first remaining element of each list to
     * determine which should be copied over to the result list first (Figure 6.5b). That
     * loop continues until one list is emptied (Figure 6.5c). If data is the emptied list,
     * the remainder of the temp list is transferred (Figure 6.5d). If the temp list was
     * emptied, the remainder of the data list is already located in the correct place!
     * Returning to our two friends, we note that before the two lists are merged
     * each of the two friends is faced with sorting half the cards. How should this be
     * done? If a deck contains fewer than two cards, it’s already sorted. Otherwise,
     * each person could recursively hand off half of his or her respective deck (now
     * one-fourth of the entire deck) to a new individual. Once these small sorts are
     * finished, the quarter decks are merged, finishing the sort of the half decks, and
     * the two half decks are merged to construct a completely sorted deck. Thus,
     * we might consider a new sort, called mergesort, that recursively splits, sorts,
     * and reconstructs, through merging, a deck of cards.
     *
     * @param data int[]
     * @param n int
     */
    private static void merge(int data[], int temp[],
                              int low, int middle, int high) {
        // pre: data[middle..high] are ascending
        // temp[low..middle-1] are ascending
        // post: data[low..high] contains all values in ascending order
        int ri = low; // result index
        int ti = low; // temp index
        int di = middle; // destination index
        // while two lists are not empty merge smaller value
        while (ti < middle && di <= high) {
            if (data[di] < temp[ti]) {
                data[ri++] = data[di++]; // smaller is in high data
            } else {
                data[ri++] = temp[ti++]; // smaller is in temp
            }
        }
        // possibly some values left in temp array
        while (ti < middle) {
            data[ri++] = temp[ti++];
        }
        // ...or some values left (in correct place) in data array
    }

    /**
     * Worst case: O(n log(n))
     * @param data
     * @param temp
     * @param low
     * @param high
     */
    private static void mergeSortRecursive(int data[],
                                           int temp[],
                                           int low, int high)
    // pre: 0 <= low <= high < data.length
    // post: values in data[low..high] are in ascending order
    {
        int n = high - low + 1;
        int middle = low + n / 2;
        int i;
        if (n < 2) {
            return;
        }
        // move lower half of data into temporary storage
        for (i = low; i < middle; i++) {
            temp[i] = data[i];
        }
        // sort lower half of array
        mergeSortRecursive(temp, data, low, middle - 1);
        // sort upper half of array
        mergeSortRecursive(data, temp, middle, high);
        // merge halves together
        merge(data, temp, low, middle, high);
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
        System.out.println("Executing Merge Sort");
        MergeSort mergeInst = new MergeSort();
        //print the array before sorting
        System.out.println("Array before sorting: ");
        mergeInst.printArray();
        //sort the array
        before = System.currentTimeMillis();
        //high is one less than maximum
        mergeInst.mergeSortRecursive(mergeInst.randArray, mergeInst.tempArray,
                                     0, mergeInst.maxArray - 1);
        after = System.currentTimeMillis();
        total = after - before;
        System.out.println("Array after sorting: ");
        mergeInst.printArray();
        System.out.println("Array has been sorted: " + mergeInst.isSorted());
        System.out.println();
        System.out.println("Before time: " + before + " milliSeconds");
        System.out.println("After timee: " + after + " milliSeconds");
        System.out.println("Total time to execute: " + total +
                           " milliSeconds");

    }

}
