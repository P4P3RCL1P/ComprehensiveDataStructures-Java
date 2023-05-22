package edu.sru.thangiah;

/*
 * Write a Java program for a Lawyer<YourLastName> class. 
 * The class provides billing information for a lawyer and client. 
 * The class has data members for the client name's, the lawyer's per hour 
 * billing rate, and the billing time in hours.  
 * A constructor has parameters for the name, rate, and time. 
 * The method postBill() returns a string with billing information that 
 * specifies the client, the rate, the time, and the billing amount. 
 * Create two instances of the class, badLawyer and WorseLawyer and print 
 * out all the information including the billing amount about for the two lawyers.
 */


/**
 * <p>Title: LawyerType.java </p>
 *
 * <p>Description: </p>
 * The Lawyer class provides billing information for a lawyer and client.
 * 
 * 
 * The class has data members for the client's name, the lawyer's per hour
 * billing rate, and the billing time in ours.
 * A constructor has parameters for the name, rate, and time.
 * the method postBill() returns a string with billing information that
 * specifies the client, the rate, the time, and the billing amount.
 * 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

class Lawyer {
	/**
	 * Private variable for the client's name
	 */
	private String clientName;
	/**
	 * Private variable for the lawyer's billing time
	 */
	private int hours;
	/**
	 * Private variable for the lawyer's rate
	 */
	private float rate;
	/**
	 * Default constructor for instantiating the private variables to default values
	 */
	Lawyer()
	{
		clientName="";
		rate=0.0F;
		hours = 0;
	}
	
	
	/**
	 * Overloaded constructor which instantiates the private variables using parameters passed
	 * @param clientName The client's name
	 * @param rate The lawyer's rate
	 * @param hours The lawyer's billing time
	 */
	Lawyer(String clientName, float rate, int hours)
	{
		this.clientName=clientName;
		this.rate=rate;
		this.hours=hours;
	}
	
	//getter and setter methods for rate, hours, clientName, and billingAmount
	/**
	 * Getter method for private rate variable
	 * @return The lawyer's rate
	 */
	public float getRate() {
		return rate;
	}
	/**
	 * Setter method for private rate variable.
	 * @param rate The Lawyer's rate
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
	/**
	 * Getter method for private hours variable
	 * @return The lawyer's billing time
	 */
	public float getHours() {
		return hours;
	}
	/**
	 * Setter method for private hours variable
	 * @param hours The lawyer's billing time
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	/**
	 * Getter method for private clientName variable
	 * @return The client's name
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * Setter method for private clientName variable
	 * @param clientName The client's name
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * Method for calculating the total billing amount.
	 * @return Billing amount returned as a float
	 */
	public float getBillingAmount() {
		float billingAmount;
		billingAmount=0;
		
		billingAmount= hours * rate;
		return billingAmount;
	}
	
}
/**
 * The LawyerType class stores the main method 
 *
 */
public class LawyerType {
	/**
	 * Main method for instantiating the Lawyer class and calling the available methods
	 * @param args The command line arguments.
	 */
	public static void main(String args[])
	{
		Lawyer badLawyer = new Lawyer(" Sub-Supreme Leader", 3000.0F, 10);
		badLawyer.setRate(5000);
		badLawyer.getBillingAmount();
		Lawyer worseLawyer = new Lawyer(" Ex-Supreme Leader", 10000.0F, 100000);
	}
}
