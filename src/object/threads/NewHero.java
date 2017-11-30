package object.threads;

public class NewHero {
	public String name;
	public float hp;

	public int damage;
	
	public static int a=0;
	public synchronized static void add(){
		a++;
	}	
	public synchronized static void reduce(){
		a--;
	}
	
	public synchronized void recover() {
		if(hp>=1000){
			System.out.println("max hp and waiting...");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("waited and hp="+hp);
		}
		hp += 1;
		System.out.println("recover hp="+hp);
	}

	public void hurt() {
		synchronized (this) {
			hp -= 1;
			System.out.println("hurt hp="+hp);
			this.notify();
		}
	}

	public void bdSkill() {
		Thread bd = new Thread() {
			@Override
			public void run() {
				int totaltime = 3;
				while (!isDead()) {
					for (int i = 1; i <= totaltime; i++) {
						System.out.format("波动拳第%d次\n", i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("波动拳充能5秒");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		bd.start();
	}

	public void attackHero(NewHero h) {
		try {
			// 为了表示攻击需要时间，每次攻击暂停1000毫秒
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.hp -= damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);

		if (h.isDead())
			System.out.println(h.name + "死了！");
	}

	public boolean isDead() {
		return 0 >= hp ? true : false;
	}

	public static void main(String args[]) {
		NewHero nh = new NewHero();
		nh.hp = 1000;
		nh.bdSkill();

		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nh.hp = 0;
		System.out.println("dead");
	}
}
