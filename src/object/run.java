package object;

import java.io.File;

import object.hero.ADHero;
import object.hero.APHero;
import object.hero.Hero;
import object.item.Item;
import object.item.LifePotion;
import object.item.MagicPotion;

public class run {
	public static void main(String[] args) {
        ADHero ad = new ADHero("盖伦");
        ADHero ad2 = new ADHero("盖伦");
        APHero ap = new APHero("提莫");
        ad.setHp(300);
        ap.setHp(300);
        ad2.setHp(300);
        
        System.out.println(ad.equals(ap));
        System.out.println(ad==ad2);
        Hero h1= ad;
        Hero h2= ap;
        
        ad.kill(ap);
        //判断引用h1指向的对象，是否是ADHero类型
        System.out.println(h1 instanceof ADHero);
         
        //判断引用h1指向的对象，是否是APHero类型
        System.out.println(h2 instanceof APHero);
         
        //判断引用h1指向的对象，是否是Hero的子类型
        System.out.println(h1 instanceof Hero);
        System.out.println(h1 instanceof APHero);
		
        LifePotion lp = new LifePotion();
        lp.effect();
        lp.buy();
        Item i = lp;
        i.effect();
        MagicPotion mp = new MagicPotion();
        mp.effect();
        
        Hero.battleWin();
        ADHero.battleWin();
        ad.battleWin();
        ap.battleWin();
        
        System.out.println(ad.getMoveSpeed());
        System.out.println(ad.getMoveSpeed2());
		System.out.println("run end");
		
        File f1 = new File("d:/LOLFolder");
        System.out.println("f1的绝对路径：" + f1.getAbsolutePath());
        // 相对路径,相对于工作目录，如果在eclipse中，就是项目目录
        File f2 = new File("LOL.exe");
        System.out.println("f2的绝对路径：" + f2.getAbsolutePath());
        
        System.out.println("--------------");
        File f = new File("D:\\work_download\\出差");
        eachFile(f);
	}
	
	public static void eachFile(File dir){
		for(File f:dir.listFiles()){
			if(f.isDirectory())
				eachFile(f);
			else if(f.length()>0)
				System.out.println(f.getAbsoluteFile() + " --- " + f.length());
		}
	}
}
