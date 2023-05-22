package edu.sru.thangiah;
/**
 * <p>Title: GoodbyeWorld.java </p>
 *
 * <p>Description: </p>
 * GoodbyeWorld showcases how constructors can be used.
 * 
 * Users can create an instance of the GoodbyeWorld class which then
 * outputs "Goodbye world".
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class GoodbyeWorld {
	/**
	 * Constructor which fires the println statement "Goodbye World" to console
	 */
	//constructor
	GoodbyeWorld()
	{
		System.out.println("Goodbye World");
	}
	
	
	/*since our constructor in the GoodByeWorld class contains a println statement
	* when we instantiate an instance of our class the constructor fires the println statement
	* resulting in the "Goodbye World" output
	*/
	/**
	 * Main method. Users can instantiate the GoodbyeWorld class which will fire the GoodbyeWorld constructor
	 * @param args The command line arguments
	 */
	public static void main(String args[])
	{
		
		GoodbyeWorld goodbyeWorld = new GoodbyeWorld();
	}

	
}
