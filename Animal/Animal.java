package Animal;
/*class tutorial
A class is a template with which an object can be created
they have properties and values

modelling of classes requres you to:
1. identify the class to model, in this case an Animal
2. identify the properties of the animal, like the number of legs, habitat and color and even name
3. identify the behaviour of this class, what it does, in this case whether it eats, moves or sleeps
*/


//this class will be of an animal i.e. identify the class
public class Animal{

	//declare the properties name, number of legs and habitat i.e. declare the properties of the class
	private String name;
	private int noOfLegs;
	private String habitat;

	//constructor
	public Animal(String n,int num,String h){
		name =n;
		noOfLegs=num;
		habitat=h;
		}

		//default constructor
		public Animal(){
			this("DefaultName",0,"DefaultHabitat");
			}

	//define the getter and setters
	public void setName(String s){
		this.name =s;
		}

		public String getName(){
			return name;
			}

			public void setNoOfLegs(int noOfLegs){
				if(noOfLegs <=20)
					this.noOfLegs = noOfLegs;
				}

						public int getNoOfLegs(){
							return noOfLegs;
							}

							public void setHabitat(String h){
								this.habitat = h;
								}

										public String getHabitat(){
											return habitat;

											}

	//define the behaviour of the class, in this case whether the animal eats, sleeps or moves
	public void eat(){
		System.out.println("I live to eat or do I eat to live?");
		}

		public void sleep(){
			System.out.println("I love sleep");
			}

			public void move(){
				System.out.println("I move around a lot");
				}

				public void display(){
					System.out.println("Name: " + name);
					System.out.println("Number of Legs: " + noOfLegs);
					System.out.println("Habitat: " + habitat);
					}

	public static void main(String[] args){
/*
		//create an instance of class known as an object (or fill in the details of the class into the class created)
		Animal a= new Animal();
		a.name = "Tiger";
		a.noOfLegs = 4;
		a.habitat = "The Wild";

		//call the methods (or the behaviour of the class) within class Animal
		a.display();
		a.move();
		a.eat();
		a.sleep();
*/






		}
	}