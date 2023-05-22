package edu.sru.thangiah;
/**
 * <p>Title: HelloWorld.java </p>
 *
 * <p>Description: </p>
 * HelloWorld demonstrates how overloaded constructors can be used
 * 
 * Users can create an instance of the HelloWorld class and
 * utilize the default constructor to print "Hello World!" or
 * the overloaded constructor to print their own message.
 * 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class HelloWorld {
	//constructor
	/**
	 * Default constructor which prints "Hello World!" after instantiation
	 */
	public HelloWorld() {
		System.out.println("Hello World!");
	}
	/**
	 * Overloaded constructor which takes in a message parameter and prints it after instantiation
	 * @param message String parameter which is then printed out in the body of the constructor
	 */
	public HelloWorld(String message) {
		System.out.println(message);
	}
	
	
	/**
	 * Main method for instantiating HelloWorld class. Users can either call the default or overloaded constructor
	 * @param args The command line arguments.
	 */
	/*we can use constructor overloading to have a seperate constructor that takes a string
	* parameter which is used to be output after instantiating a variable with the HelloWorld class.
	* Note: passing no parameter results in the default: "Hello World!" output 
	*/
	public static void main(String args[]) {
	
		HelloWorld hi = new HelloWorld("Hello!");
	}
}
