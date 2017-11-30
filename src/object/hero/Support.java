package object.hero;

public class Support extends Hero implements Healer {

	public Support(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		System.out.println("治疗");
	}

}
