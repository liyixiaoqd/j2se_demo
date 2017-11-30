package object.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import object.hero.Hero;

public class AList {
	public static void main(String[] args) {
//		List<Integer> l;
//		l = new ArrayList<>();
//		modify(l, "ArrayList");
//
//		l = new LinkedList<>();
//		modify(l, "LinkedList");

		Comparator<Integer> c = new Comparator<Integer> (){
			@Override
			public int compare(Integer i1, Integer i2) {
				// TODO Auto-generated method stub
				if(i1>i2)
					return -1;
				else
					return 1;
			}
		};
		
		TreeSet<Integer> ts = new TreeSet<Integer>(c);
		ts.add(9);
		ts.add(1);
		ts.add(5);
		System.out.println(ts);
		
		List<Number> n = new ArrayList<Number>();
		n.add(3.3);
		n.add(4);
		//n.add("String");
	}

	private static void modify(List<Integer> l, String type) {
		int total = 100 * 1000;
		int index = total / 2;
		final int number = 5;
		// 初始化
		for (int i = 0; i < total; i++) {
			l.add(number);
		}

		long start = System.currentTimeMillis();

		for (int i = 0; i < total; i++) {
			/* 定位中间数据数据  
			int n = l.get(index);
			n++;
			l.set(index, n);
			*/
			l.add(index, number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type, total, index, total,
				end - start);
		System.out.println();
		
		List<String>[] ls = new ArrayList[10];  
	}
}
