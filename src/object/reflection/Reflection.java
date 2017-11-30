package object.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import object.hero.Hero;

public class Reflection {
	public static void main(String args[]) {
		String class_name = "object.hero.Hero";
		try {
			Class c1 = Class.forName(class_name);
			System.out.println("=====forName end=====");
			Class c2 = Hero.class;
			System.out.println("=====.class end=====");
			Class c3 = new Hero("t").getClass();
			System.out.println("=====getClass end=====");

			Hero h = (Hero) c2.getConstructor(String.class).newInstance("abc");
			System.out.println(h.name);
			Field f1 = c2.getDeclaredField("name");
			f1.set(h, "ddd");
			System.out.println(h.name);
			Method m = c2.getMethod("setHp", float.class);
			m.invoke(h, 33f);
			System.out.println(h.getHp());
			m = c2.getMethod("ref_test", int.class, String.class);
			String ret_ref = (String)m.invoke(h, 3, "testRef");
			System.out.println("get return: "+ret_ref);
			// Constructor cons = c1.getConstructor();
			// Hero h = (Hero) cons.newInstance("abc");
			// System.out.println(h.name);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
