package edu.sru.thangiah.polymorphism;

/**
 * <p>Title: Shapes.java </p>
 *
 * <p>Description: </p>
 * 
 * Used to demonstrate polymorphism in the example of shapes, circles and squares
 * the different shapes can build off of the original shape class and change 
 * what the methods in it do depending on what they need to use it for 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

class Shape {
	void draw() {
	}

	void erase() {
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("Circle.draw()");
	}

	void erase() {
		System.out.println("Circle.erase()");
	}
}

class Square extends Shape {
	void draw() {
		System.out.println("Square.draw()");
	}

	void erase() {
		System.out.println("Square.erase()");
	}
}

class Triangle extends Shape {
	void draw() {
		System.out.println("Triangle.draw()");
	}

	void erase() {
		System.out.println("Triangle.erase()");
	}
}

//public class Shapes extends Shape{
public class Shapes {
	public static Shape randShape() {
		switch ((int) (Math.random() * 3)) {
		default:
		case 0:
			return new Circle();
		case 1:
			return new Square();
		case 2:
			return new Triangle();
		}
	}

	public static void main(String[] args) {
		/*Shape[] s = new Shape[9];
		// Fill up the array with shapes:
		for (int i = 0; i < s.length; i++)
			s[i] = randShape();
		// Make polymorphic method calls:
		for (int i = 0; i < s.length; i++)
			s[i].draw();
		*/
		
		Shape s;
		
		s = new Circle();
		s.draw();
		
		s = new Triangle();
		s.draw();
	}
}