package object.practice;

public class Cat extends Animal implements Pet {
	private String name;
	
	protected Cat() {
		super(4);
		// TODO Auto-generated constructor stub
	}
	
	protected Cat(String name){
		this();
		this.name = name;
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
		if(name == null || name.isEmpty())
			System.out.println("please set name first");
		else
			System.out.println(name + " playing with you");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cat eating");
	}

}
