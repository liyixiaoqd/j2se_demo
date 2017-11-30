package object.threads;

public class TestSyncThread2 {
	public static void main(String args[]){
		final NewHero nh = new NewHero();
		nh.name="garen";
		nh.hp=1000;
		
		int num=100;
		Thread[] hurtThreads = new Thread[num];
		Thread[] recoverThreads = new Thread[num];

		for(int i=0;i<num;i++){
			Thread t = new Thread(){
				@Override
				public void run(){
					nh.recover();
					NewHero.reduce();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			recoverThreads[i] = t;
		}
		
		
		for(int i=0;i<num;i++){
			Thread t = new Thread(){
				@Override
				public void run(){
					nh.hurt();
					NewHero.add();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			hurtThreads[i] = t;
		}
		

		for(Thread t:hurtThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(Thread t:recoverThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		System.out.println("end, garen.hp="+nh.hp);
		System.out.println("end, NewHero.a="+NewHero.a);
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		System.out.println(sb==sb1);
	}
}
