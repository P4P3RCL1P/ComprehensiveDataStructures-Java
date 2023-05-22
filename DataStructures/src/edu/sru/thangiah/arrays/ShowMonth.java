package edu.sru.thangiah.arrays;
/**
 * <p>Title: ShowMonth</p>
 *
 * <p>Description: </p>
 * Program which utilizes arrays to store the number of days in each month.
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class ShowMonth {

	/**
	 * Main method 
	 * @param args The command line arguments.
	 */
    //the main program
    public static void main(String args[]) {
    	final int maxSize = 12;
        int month_days[];    //pointer to an array
        month_days = new int[maxSize];  //an array of 12 locations
        month_days[0] = 31;
        month_days[1] = 28;
        month_days[2] = 31;
        month_days[3] = 30;
        month_days[4] = 31;
        month_days[5] = 30;
        month_days[6] = 31;
        month_days[7] = 31;
        month_days[8] = 30;
        month_days[9] = 31;
        month_days[10] = 30;
        month_days[11] = 31;



       //print out the days in a month
       System.out.println("April has " + month_days[3] + " days.");
       System.out.println("Length of array is " +month_days.length);


    }
}
