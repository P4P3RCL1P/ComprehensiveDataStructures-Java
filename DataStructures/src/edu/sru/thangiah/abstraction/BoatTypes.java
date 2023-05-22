package edu.sru.thangiah.abstraction;
/* The abstract keyword denotes the framework.
 * Notice we declare setBoatType, SetPassengers,
 * and setPower, but only define what the methods
 * do when we extend the Boat class. This allows us
 * to define the essence of a class while allowing each
 * extended class to define their own values for the
 * boat methods.
 * 
 * In short, each boat shares some similar characteristics,
 * but the values/properties for these characteristics are
 * different.
 */

/**
 * <p>Title: Boat </p>
 *
 * <p>Description: </p>
 * The Boat class demonstrates an example of abstraction in Java
 * The abstract keyword denotes the framework.
 * Notice we declare setBoatType, SetPassengers,
 * and setPower, but only define what the methods
 * do when we extend the Boat class. This allows us
 * to define the essence of a class while allowing each
 * extended class to define their own values for the
 * boat methods.
 * 
 * In short, each boat shares some similar characteristics,
 * but the values/properties for these characteristics are
 * different.
 * 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

abstract class Boat
{
	/**
	 * String variable for storing the type of boat
	 */
	String boatType;
	/**
	 * Int variable for storing the capacity of the boat
	 */
	int passengers;
	/**
	 * Int variable for storing the power of the boat
	 */
	int power;
	/**
	 *Boolean variable for evaluating whether the boat floats or not
	 */
	boolean floats;
	/**
	 * Setter method which is defined later as a result of abstract keyword
	 */
	public abstract boolean setBoatType();
	/**
	 * Setter method which is defined later as a result of abstract keyword
	 */
	public abstract boolean setPassengers();
	/**
	 * Setter method which is defined later as a result of abstract keyword
	 */
	public abstract boolean setPower();
	
	/**
	 * Setter method to set the floats variable to true
	 * @return Returns true after successful completion of method
	 */
	public boolean setFloats()
	{
		floats = true;
		return true;
	}
}
/**
 * <p>Title: RowBoat </p>
 *
 * <p>Description: </p>
 * The RowBoat class demonstrates an example of abstraction in Java
 * The abstract keyword denotes the framework.
 * Notice we declare setBoatType, SetPassengers,
 * and setPower, but only define what the methods
 * do when we extend the Boat class. This allows us
 * to define the essence of a class while allowing each
 * extended class to define their own values for the
 * boat methods.
 * 
 * In short, each boat shares some similar characteristics,
 * but the values/properties for these characteristics are
 * different.
 * 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
class Rowboat extends Boat
{
	public Rowboat(){
    }
	
	public boolean setBoatType() {
		   boatType="row";
		   return true;
	}

	public boolean setPassengers() {
	   passengers=2;
	   return true;
	}

      public boolean setPower(){
          power = 2; //2 hp
          return true;
      }
}
/**
 * <p>Title: OceanLiner </p>
 *
 * <p>Description: </p>
 * The OceanLiner class demonstrates an example of abstraction in Java
 * The abstract keyword denotes the framework.
 * Notice we declare setBoatType, SetPassengers,
 * and setPower, but only define what the methods
 * do when we extend the Boat class. This allows us
 * to define the essence of a class while allowing each
 * extended class to define their own values for the
 * boat methods.
 * 
 * In short, each boat shares some similar characteristics,
 * but the values/properties for these characteristics are
 * different.
 * 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
class OceanLiner extends Boat
{
	public OceanLiner (){
    }
	
	public boolean setBoatType() {
		   boatType="ocean liner";
		   return true;
	}

	public boolean setPassengers() {
	   passengers=2400;
	   return true;
	}

      public boolean setPower(){
          power = 24000; //24000 hp
          return true;
      }
}




/**
 * <p>Title: BoatTypes </p>
 *
 * <p>Description: </p>
 * The Boat class demonstrates an example of abstraction in Java
 * The abstract keyword denotes the framework.
 * Notice we declare setBoatType, SetPassengers,
 * and setPower, but only define what the methods
 * do when we extend the Boat class. This allows us
 * to define the essence of a class while allowing each
 * extended class to define their own values for the
 * boat methods.
 * 
 * In short, each boat shares some similar characteristics,
 * but the values/properties for these characteristics are
 * different.
 * 
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */
public class BoatTypes {
	/**
	 * Main method for instantiating the Lawyer class and calling the available methods
	 * @param args The command line arguments.
	 */
	public static void main(String[] args)
	{

	  /*Rowboat PrinceCharles = new Rowboat();
	  System.out.println("The boat type is: "+PrinceCharles.boatType);
	  System.out.println("    Passengers: "+PrinceCharles.passengers);
	  System.out.println("    Power:"+PrinceCharles.power); */

	  /* Rowboat PrinceCharles = new Rowboat();
	  PrinceCharles.setPassengers();
	  PrinceCharles.setPower();
	  System.out.println("The boat type is: "+PrinceCharles.boatType);
	  System.out.println("    Passengers: "+PrinceCharles.passengers);
	  System.out.println("    Power:      "+PrinceCharles.power);
	  */

	  OceanLiner QueenElizabeth = new OceanLiner();
	  //QueenElizabeth.setPassengers();
	  //QueenElizabeth.setPower();
	  System.out.println("The boat type is: "+QueenElizabeth.boatType);
	  System.out.println("    Passengers: "+QueenElizabeth.passengers);
	  System.out.println("    Power:      "+QueenElizabeth.power);
	  


        /*
        // Two boats should be equal
	  // if they hold the same number of passengers
	  // and have the same power source
	  Rowboat redBoat = new Rowboat(); 
	  Rowboat blueBoat = new Rowboat();
	  System.out.print("The two boats are ");
          if(redBoat == blueBoat)
		System.out.println(" equal");
          else
	  System.out.println("not equal");
	  */
    
	}


}
