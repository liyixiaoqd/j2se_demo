package object;

import java.util.ArrayList;
import java.util.List;

import object.hero.ADHero;
import object.hero.APHero;
import object.hero.Hero;
import object.item.Item;

public class Node<T extends Comparable> {
	public Node<T> leftNode;
	public Node<T> rightNode;
	public T value;
	
	public Node(){
		
	}
	public Node(T value){
		this.value = value;
	}
	
	public void add(T v){
		if(value == null)
			value = v;
		else{
			if(value.compareTo(v)>0){
				if(leftNode == null)
					leftNode = new Node<T>(v);
				else
					leftNode.add(v);	
			}
			else{
				if(rightNode == null)
					rightNode = new Node<T>(v);
				else
					rightNode.add(v);			
			}
		}
	}
	
	public void outValues(){
		if(leftNode != null)
			leftNode.outValues();
		System.out.print(value+" ");
		if(rightNode != null)
			rightNode.outValues();
	}
//	public List<T> values(){
//		List<T> values = new ArrayList<T>();
//		
//	}
	
	public static void main(String args[]){
		int i[] = new int[]{50,30,40,60,3,99,4};
		Node<Integer> root = new Node<Integer>();
		for(int j:i){
			root.add(j);
		}
		root.outValues();
		
		
        ArrayList<APHero> apHeroList = new ArrayList<APHero>();
        apHeroList.add(new APHero("ap1"));
        //表示这是一个Hero泛型或者其子类泛型
		ArrayList<? extends Hero> heroList = apHeroList;
		//不可调用add方法,
		//heroList.add(new Hero("ap2"));
		
		//表示这是一个Hero泛型或者其父类泛型
		ArrayList<? super Hero> heroList2 = new ArrayList<Object>();
        //所以就可以插入Hero
        heroList2.add(new Hero("h1"));
        //也可以插入Hero的子类
        heroList2.add(new APHero("ap1"));
        heroList2.add(new ADHero("ad1"));
        //可能失败
        Hero h = (Hero) heroList2.get(0);
        
        
        //?泛型通配符，表示任意泛型
        ArrayList<?> generalList = apHeroList;
 
        //?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
        //所以只能以Object的形式取出来
        Object o = generalList.get(0);
 
        //?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
        //所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
//        generalList.add(new Item("i1")); //编译错误 因为?代表任意泛型，很有可能不是Item
//        generalList.add(new Hero("h1")); //编译错误 因为?代表任意泛型，很有可能不是Hero
//        generalList.add(new APHero("ap1")); //编译错误  因为?代表任意泛型，很有可能不是APHero
        
        
        ArrayList<Hero> hs =new ArrayList<>();
        ArrayList<ADHero> adhs =new ArrayList<>();
 
        //子类泛型转父类泛型  不可互转
        //hs = adhs;
        //adhs = hs;
	}
}
