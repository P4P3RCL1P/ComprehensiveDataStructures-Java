package edu.sru.thangiah.recursion;

/*
 * Factorial demonstrates recursion calling itself and decreasing the count until 0
 */

/**
 * <p>Title: Factorial.java </p>
 *
 * <p>Description: </p>
 * 
 * Factorial demonstrates recursion calling itself and decreasing the count until 0
 * Used as a very basic example of how to implement recursion through recalling a method until an end
 * condition is met
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class Factorial {

	static int factorial(int n) {
		if (n != 0) // termination condition
			return n * factorial(n - 1); // recursive call
		else
			return 1;
	}

	public static void main(String[] args) {
		int number = 4;
		int result;
		result = factorial(number);
		System.out.println(number + " factorial = " + result);
	}

}
