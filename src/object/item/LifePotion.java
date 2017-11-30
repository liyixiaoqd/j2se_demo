package object.item;

public class LifePotion extends Item {
	@Override
	public void effect(){
		System.out.println("lifepotion.effect");
	}

	@Override
	public boolean disposable() {
		// TODO Auto-generated method stub
		return true;
	}
}
