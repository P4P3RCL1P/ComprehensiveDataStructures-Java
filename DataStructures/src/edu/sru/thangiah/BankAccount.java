package edu.sru.thangiah;

/**
 * <p>Title: BankAccount.java </p>
 *
 * <p>Description: </p>
 * BankAccount showcases a beginning example of OOP in java.
 * Users can create an instance of the BankAccount class and
 * utilize methods within this class to deposit money into 
 * their class instance or get the current amount within their
 * instance.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class BankAccount {
	/**
	 * Bank account amount variable to be manipulated in get/setAmt and deposit methods
	 */
	private float amt;  //data-hidin
	
	
	/**
	 * Constructor where our amount private variable is initialized to 100
	 */
	//default constructor. Bank amount is default set to 100
	BankAccount()
	{
		//setAmt(100);
		amt = 100;
	}
	
	/**
	 * Getter method to return amount in bank account
	 * @return The current amount in BankAccount instance
	 */
	//getAmt returns the private amount variable
	float getAmt()
	{
		return amt;
	}
	
	/*setAmt sets the private amount variable to whatever float value
	 *is passed as a parameter in the function call. Note that this
	 *does not add onto the existing amount, but resets the variable 
	 *to the new value.
	*/
	/**
	 * Setter method to set the amount in a bank account
	 * @param pAmt The amount which we want to set the bank account to
	 * @return True upon successful method call
	 */
	boolean setAmt(float pAmt)
	{
		amt = pAmt;
		
		return true;
	}
	/**
	 * Method to add an amount towards our current bank account amount
	 * @param pAmt The amount which we want to set the bank account to
	 * @return True upon successful method call
	 */
	/*
	 * Adds on whatever float value is passed to the private amount 
	 * variable. 
	 */
	boolean deposit(float pAmt)
	{
		amt = amt + pAmt;
		
		return true;
	}
	/**
	 * Main method which allows the user to create an instance of the BankAccount class to add/set an amount to their account or get their current amount.
	 * @param args The command line arguments.
	 */
	public static void main(String args[])
	{
		BankAccount bankAccount = new BankAccount();
		System.out.println(bankAccount.deposit(10));
		System.out.println(bankAccount.getAmt());
		
	}

}
