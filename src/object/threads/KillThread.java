package object.threads;

public class KillThread extends Thread {
	private NewHero h1;
	private NewHero h2;
	
	public KillThread(NewHero h1,NewHero h2){
		this.h1 = h1;
		this.h2 = h2;
	}
	
	@Override
	public void run(){
		while(!h2.isDead()){
			h1.attackHero(h2);
		}
	}
}
