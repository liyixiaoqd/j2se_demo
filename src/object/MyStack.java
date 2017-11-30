package object;

import java.util.LinkedList;

public class MyStack<T> {
	LinkedList<T> values=new LinkedList<T>();
	public void push(T t){
		values.addLast(t);
	}
	
	public T pull(){
		if(values.isEmpty())
			return null;
		return values.removeLast();
	}
	
	public T peek(){
		if(values.isEmpty())
			return null;
		return values.getLast();
	}
	
	public static void main(String args[]){
		MyStack<String> ms = new MyStack<String>();
		System.out.println(ms.peek());
	}
}
