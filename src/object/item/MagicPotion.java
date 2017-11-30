package object.item;

public class MagicPotion extends Item {
	@Override
	public void effect(){
		System.out.println("MagicPotion.effect");
	}

	@Override
	public boolean disposable() {
		// TODO Auto-generated method stub
		return false;
	}
}
