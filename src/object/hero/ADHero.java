package object.hero;

import object.item.Mortal;

public class ADHero extends Hero implements AD,Mortal {
	
    public ADHero(String name){
    	super(name);
    	moveSpeed=400;
        System.out.println("AD Hero的有一个参数的构造方法");
    }
    
    public int getMoveSpeed(){
        return this.moveSpeed;
    }
     
    public int getMoveSpeed2(){
        return super.moveSpeed;
    }
    
	@Override
	public void physicAttack() {
		// TODO Auto-generated method stub
		System.out.println("进行物理攻击");
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " die");
	}

    //隐藏父类的battleWin方法
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }   
    
}
