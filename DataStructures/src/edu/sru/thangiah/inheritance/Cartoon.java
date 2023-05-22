package edu.sru.thangiah.inheritance;

/**
 * <p>Title: Cartoon.java </p>
 *
 * <p>Description: </p>
 * 
 * 
 * Example of is-a or ako - association
 * - Basic inheritance is based on an is-a association.
 * - Drawing is a form of art, and a cartoon is a form of drawing.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

class Art{
	
	Art() {
		System.out.println("Art Class");
	}
}


class Drawing extends Art {
	
	Drawing() {
		System.out.println("Drawing Class");
	}
}


public class Cartoon extends Drawing{
	
	Cartoon() {
		System.out.println("Cartoon Class");
	}
	
	
	public static void main(String args[])
	{
		Cartoon cartoon = new Cartoon();
	}

}
