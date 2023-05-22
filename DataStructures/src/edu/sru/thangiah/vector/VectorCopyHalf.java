package edu.sru.thangiah.vector;

import java.util.Vector;
import java.lang.Math;

public class VectorCopyHalf {
	
	
	public static void main(String args[])
	{
		final int MAXRNDNO = 10; //up to 10
		int maxVectSize;
		int rndNo;
		
		Vector vect1;
		Vector vect2;
		
		vect1= new Vector();
		vect2= new Vector();
		maxVectSize = (int)(Math.random()*MAXRNDNO)+1;
		
		for (int i=0; i < maxVectSize; i++)
		{
			rndNo = (int)(Math.random()*MAXRNDNO)+1;
			vect1.addElement(rndNo);	
		}
		
		//print the vector 1 information
		System.out.println("Vector 1 size is: "+vect1.size());
		for (int i=0; i < vect1.size(); i++)
		{
			System.out.println(vect1.get(i));	
		}
		
		//copy half of first array into second array
		for (int i=0; i < vect1.size()/2; i++)
		{
			vect2.addElement(vect1.get(i));	
		}
		
		//print the vector 1 information
		System.out.println("Vector 2 size is: "+vect2.size());
		for (int i=0; i < vect2.size(); i++)
		{
			System.out.println(vect2.get(i));	
		}
		
	}
}
