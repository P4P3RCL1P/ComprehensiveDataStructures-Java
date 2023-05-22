package edu.sru.thangiah.arrays;

import java.lang.Math;

/*
 * The ending half of the array is reversed, resulting in
 * an array that has one half flipped and the beginning half
 * unchanged.
 */

/**
 * <p>Title: ArrayHalfFlip</p>
 *
 * <p>Description: </p>
 * The ending half of the array is reversed, resulting in
 * an array that has one half flipped and the beginning half
 * unchanged.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class ArrayHalfFlip {
	/**
	 * Main method 
	 * @param args The command line arguments.
	 */
	public static void main(String args[])
	{
		final int  MAXSIZE = 10;
		final int MAXRNDNO=20;
		int arrayVal[];
		int count;
		int temp;
		int start;
		int end;
		
		arrayVal = new int[MAXSIZE];
		
		//load the array
		System.out.println("Array before flipping");
		for (int i=0; i < MAXSIZE; i++)
		{
			arrayVal[i] = (int)(Math.random()*MAXRNDNO);
		}
			
		//print the array
		for (int i=0; i < MAXSIZE; i++)
		{		
			System.out.println(arrayVal[i]);
		}
		
		//flip half the array
		count = MAXSIZE-1;
		start = MAXSIZE/2;
		end = MAXSIZE/4;
		for (int i=MAXSIZE/2; i < (MAXSIZE/2)+end; i++)
		{		
			temp = arrayVal[i];
			arrayVal[i] = arrayVal[count];
			arrayVal[count] = temp;
			count--;
		}
		
		//print the array
		System.out.println("Array after flipping");
		for (int i=0; i < MAXSIZE; i++)
		{		
			System.out.println(arrayVal[i]);
		}
		
	}

}
