package object.hero;

import object.EnemyHeroIsDeadException;
import object.item.Mortal;

/***
 * 英雄类
 * 
 * @author Liyixiao
 *
 */
public class Hero {
	public String name; // 姓名
	float hp; // 血量
	float armor; // 护甲
	int moveSpeed; // 移速
	byte death;
	int kill;
	int assists;
	int lastNum;
	float money;
	int attackSpeed;
	String killSay;
	String deathSay;

	static{
		System.out.println("hero static");
	}
    public static void battleWin(){
        System.out.println("hero battle win");
    }
    
    public Hero(String name){
        System.out.println("Hero的有一个参数的构造方法 ");
        this.name = name;
    }    

    public void finalize(){
        System.out.println("这个英雄正在被回收");
    }
    
    public void setHp(float hp){
    	this.hp = hp;
    }
    
    
    public boolean equals(Object o){
        if(o instanceof Hero){
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }
    
	float getArmor() {
		return armor;
	}

	void addMoveSpeed(int speed) {
		moveSpeed += speed;
	}
	
	public void attackHero(Hero h) throws EnemyHeroIsDeadException{
		if(h.hp == 0){
			throw new EnemyHeroIsDeadException(h.name + " has died");
		}
	}
	
	public void kill(Mortal m){
		System.out.println(this.name + "kill");
		m.die();
	}

	void keng() {
		System.out.println("坑队友");
	}

	void legenderay() {
		System.out.println("超神!");
	}

	public float getHp() {
		return hp;
	}

	public String ref_test(int a,String b){
		System.out.println(b+","+a);
		return b+","+a;
	}
	
	void recovery(float blood) {
		hp += blood;
	}

	void params_test(int hp) {
		System.out.println(hp);
	}

	public void params_test2(final int j) {
		// j = 5; //这个能否执行？
		System.out.println(j);
	}

	public void params_test3(int j) {
		j = 5; // 这个能否执行？
		System.out.println(j);
	}

	public void oper_test1() {
		int i = 2;
		System.out.println(i++ == 2);
		System.out.println(++i == 3);
		System.out.println(i == 1 & i++ == 2); // 无论如何i++都会被执行，所以i的值变成了3
		System.out.println(i);

		// 短路与 只要第一个表达式的值是false的，第二个表达式的值，就不需要进行运算了
		int j = 2;
		System.out.println(j == 1 && j++ == 2); // 因为j==1返回false,所以右边的j++就没有执行了，所以j的值，还是2
		System.out.println(j);
	}

	public void oper_test2() {
		// 长路或 无论第一个表达式的值是true或者false,第二个的值，都会被运算
		int i = 2;
		System.out.println(i == 1 | i++ == 2); // 无论如何i++都会被执行，所以i的值变成了3
		System.out.println(i);

		// 短路或 只要第一个表达式的值是true的，第二个表达式的值，就不需要进行运算了
		int j = 2;
		System.out.println(j == 2 || j++ == 2); // 因为j==2返回true,所以右边的j++就没有执行了，所以j的值，还是2
		System.out.println(j);
	}

	public void oper_test3() {
		boolean a = true;
		boolean b = false;

		System.out.println(a ^ b); // 不同返回真
		System.out.println(a ^ !b); // 相同返回假
		System.out.println(3 ^ 4); // 比如二进制：0010^0001=0011 0000^0011=0011
	}

	public void oper_test4() {
		int i = 1;
		boolean b = !(i++ == 3) ^ (i++ == 2) && (i++ == 3);
		System.out.println(b);
		System.out.println(i);

		i = 1;
		i += ++i;
		System.out.println(i);
	}

	public void con_test1(int year) {
		if (year % 4 == 0 && year % 100 != 0) {
			System.out.println("闰年");
		} else if (year % 400 == 0) {
			System.out.println("闰年");
		}
		else{
			System.out.println("非闰年");
		}
	}

	public void con_test2(int num) {
		int result= num*num;
		int i=num;
		while(i>0){
			i--;
			result -= num*i;
		}
		System.out.println("result:"+result);
	}
	
	public void con_test3(int money) {
		/**
		 * F = p* ( (1+r)^n ); F 最终收入 p 本金 r 年利率 n 存了多少年
		 */
		float result = 0F;
		int year=1;
		while(true){
			result += money*(Math.pow(1.2, year));
			if(result>1000000)
				break;
			year++;
		}
		System.out.println("year:"+year+",result="+result);
	}
	
	public static void main(String[] args) {
		Hero hero = new Hero("Abc");
		hero.hp = 1000.5f; // 默认为double64位,需要增加f强制转换为float
		hero.death = 0; // byte位整数类型 长度8位 -128~127
		hero.params_test(300);
		hero.params_test2(3);
		hero.params_test2(4);
		hero.params_test3(4);
		System.out.println("============OPER===========");
		hero.oper_test1();
		System.out.println("===========");
		hero.oper_test2();
		System.out.println("===========");
		hero.oper_test3();
		System.out.println("===========");
		hero.oper_test4();
		System.out.println("===========================");
		hero.con_test1(2001);
		System.out.println("===========");
		hero.con_test2(11);
		System.out.println("===========");
		hero.con_test3(12000);
		System.out.println("===========================");
		double a = 3.14;
		float b = 2.769343f;
		int c = 365;
		byte d = 12;
		char e = '吃';
		boolean f = false;
		String g = "不可描述";
		System.out.println(d);

		long val = 26L; // 以L结尾的字面值表示long型
		int decVal = 26; // 默认就是int型
		int hexVal = 0x1a; // 16进制
		int oxVal = 032; // 8进制
		int binVal = 0b11010; // 2进制
		System.out.println(oxVal);

		float f1 = 123.4F;// 以F结尾的字面值表示float类型
		double d1 = 123.4;// 默认就是double类型
		double d2 = 1.234e2;// 科学技术法表示double
		System.out.println(d2);

		byte bb = 120;
		short ss = 1200;
		int ii = 153;
		long ll = 1200000;
		float ff = 3.3F;
		double dd = 1.23e4;
		char cc = '\n';
		String sss = "abc";
		
		String ii_s = ""+ii;
		for(int i=0;i<ii_s.length();i++){
			System.out.print(Math.pow(Character.getNumericValue(ii_s.charAt(i)),3)+"\t");
		}
		
	}
}
