package object;

import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		System.out.println("please input number:");
//		int a = s.nextInt();
//		System.out.println("please input number:");
//		int b = s.nextInt();
//		System.out.println(a * b);
//		System.out.println("please input :");
//		String ss = s.nextLine();
//		ss = s.nextLine();
//		System.out.println(ss);

		int i = 5;
		// i++; 先取值，再运算
		// ++i; 先运算，再取值
		System.out.println(i++); // 输出5
		System.out.println(i); // 输出6

		int j = 5;
		System.out.println(++j); // 输出6
		System.out.println(j); // 输出6
		
		i = 1;
		j = ++i + i++ + ++i + ++i + i++;
		System.out.println(j);
	}
}
