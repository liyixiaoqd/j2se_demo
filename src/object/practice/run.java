package object.practice;

public class run {
	public static void main(String args[]){
		Spider s = new Spider();
		s.eat();
		s.walk();
		System.out.println("======");
		Cat c = new Cat();
		c.eat();
		c.play();
		c.setName("Casey");
		c.play();
		Cat c2 = new Cat("Tom");
		c2.play();
		c2.walk();
		System.out.println("======");
		Fish f = new Fish("nico");
		f.play();
		f.eat();
		f.walk();
	}
}
