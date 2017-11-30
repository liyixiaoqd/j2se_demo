package object.practice;

public abstract class Animal {
	protected int legs;
	protected Animal(int legs){
		this.legs = legs;
	}
	
	public void walk(){
		System.out.println("animal walk and use " + legs + " legns");
	}
	
	public abstract void eat();
}
