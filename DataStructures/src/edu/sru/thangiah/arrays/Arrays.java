package edu.sru.thangiah.arrays;

/*
 * Basic array example
 */
/**
 * <p>Title: Arrays</p>
 *
 * <p>Description: </p>
 * Basic array example	
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class Arrays {
	/**
	 * Main method 
	 * @param args The command line arguments.
	 */
	public static void main(String args[]) {
		
		final int MAXSIZE=12;
		int someVal; //primitive data type 
		
		
		Integer someVal1; //class datatype
		Double someVal2; //class object of Double type
		Float someVal3;
		
		int monthDays[];
		int altMonthDays[];
		monthDays= new int[MAXSIZE];
		monthDays[0] = 31;
		
		altMonthDays = monthDays; //altMonthDays points to the memory location of monthDays
		//altMonthDays & monthDays points to the same memory location
		//alias
		altMonthDays[0] =31;
		
		for(int x=0; x<MAXSIZE; x++)
		{
			System.out.println(altMonthDays[x]); //prints out same information as monthDays
		}
				
		
	}
}
