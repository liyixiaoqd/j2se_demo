package object.practice;

public class Fish extends Animal implements Pet {
	private String name;
	
	protected Fish(String name) {
		super(0);
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " playing with you");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Fish eating");
	}

	@Override
	public void walk(){
		System.out.println("Fish can't walk but swim");
	}
}
