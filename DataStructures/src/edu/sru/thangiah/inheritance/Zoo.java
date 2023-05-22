package edu.sru.thangiah.inheritance;

/**
 * <p>Title: Zoo.java </p>
 *
 * <p>Description: </p>
 * 
 * Implement a Java program for  an Animal class that has Cat and Dog as the 
 * subclasses of the Animal class. The Animal class maintains the name, animalType and sound made
 * by the animals. Create an instance of a Dog and Cat and set its name, animalType and sound, Then for each dog and cat, print out the name, animalType and sound. 
 *
 * * Another example of is-a or ako - association
 * - Basic inheritance is based on an is-a association.
 * - We have a core animal class, in which other specific animals (cat, dog, etc) inherit from.
 * 
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */


class Animal
{
	private String name;
	private String animalType;
	private String animalSound;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public String getAnimalSound() {
		return animalSound;
	}
	public void setAnimalSound(String animalSound) {
		this.animalSound = animalSound;
	}
}


//A cat is a type of animal, so it should inherit the base Animal class
class Cat extends Animal
{
	Cat (String name, String animalType, String animalSound)
	{
		setName(name);
		setAnimalType(animalType);
		setAnimalSound(animalSound);
	}
}

//A dog is also a type of animal, so it should also inherit the base Animal class
class Dog extends Animal
{
	Dog (String name, String animalType, String animalSound)
	{
		setName(name);
		setAnimalType(animalType);
		setAnimalSound(animalSound);
	}
	
}


public class Zoo {

}
