package object.threads;

public class Battle implements Runnable {

	private NewHero h1;
	private NewHero h2;
	
	public Battle(NewHero h1,NewHero h2){
		this.h1 = h1;
		this.h2 = h2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!h2.isDead()){
			h1.attackHero(h2);
		}
	}

}
