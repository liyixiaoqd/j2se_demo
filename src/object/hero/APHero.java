package object.hero;

import object.item.Mortal;

public class APHero extends Hero implements AP,Mortal {

	public APHero(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void magicAttack() {
		// TODO Auto-generated method stub
		System.out.println("进行魔法攻击");
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " die");
	}

}
