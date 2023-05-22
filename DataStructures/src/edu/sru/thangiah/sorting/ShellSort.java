package edu.sru.thangiah.sorting;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 * Shell sort sort algorithm
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */


import java.math.*;
import java.util.Random;

public class ShellSort {

    private static int maxArray = 6000;
    private int randArray[];

    /**
     * Constructor for the Bubble sort
     */
    public ShellSort() {
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
     * Shell sort
     * 
     * Worst case: O(n^2)
     * @param list int[]
     * @param n int
     */

    public void ShellSort(int list[], int n) {
        int h = 1;
        int save;

        while (h <= n / 9) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                save = list[i];
                int j = i;

                while (j >= h && save < list[j - h]) {
                    list[j] = list[j - h];
                    j -= h;
                }
                list[j] = save;
            }
            h /= 3;
        }

    } //shellsort constructor

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
         System.out.println("Executing Shell Sort");
         ShellSort shellInst = new ShellSort();
         //print the array before sorting
         System.out.println("Array before sorting: ");
         shellInst.printArray();
         //sort the array
         before = System.currentTimeMillis();
         shellInst.ShellSort(shellInst.randArray, shellInst.maxArray);;
         after = System.currentTimeMillis();
         total = after - before;
         System.out.println("Array after sorting: ");
         shellInst.printArray();
         System.out.println("Array has been sorted: " + shellInst.isSorted());
         System.out.println();
         System.out.println("Before time: " + before + " milliSeconds");
         System.out.println("After timee: " + after + " milliSeconds");
         System.out.println("Total time to execute: " + total + " milliSeconds");
    }


} // shellsort class
