package object.threads;

public class TestThread {
	public static void main(String args[]){
        final NewHero gareen = new NewHero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;
 
        final NewHero teemo = new NewHero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;
         
        final NewHero bh = new NewHero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
         
        final NewHero leesin = new NewHero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
        //Thread
//        KillThread kt1 = new KillThread(gareen, teemo);
//        KillThread kt2 = new KillThread(bh, leesin);
//        kt1.start();
//        kt2.start();
        //Runnable
//        Battle b1 = new Battle(gareen, teemo);
//        Battle b2 = new Battle(bh, leesin);
//        new Thread(b1).start();
//        new Thread(b2).start();
        Thread t3 = new Thread(){
        	public void run(){
        		while(!teemo.isDead()){
        			gareen.attackHero(teemo);
        		}
        	}
        };
        Thread t4 = new Thread(){
        	public void run(){
        		while(!leesin.isDead()){
        			bh.attackHero(leesin);
        		}
        	}
        };
        
        t3.start();
        t4.start();
	}
}
