package object;

public class BaseType {
	public static void main(String args[]){
		Byte b = 5;
		byte bb = b;
		System.out.println(bb);
		byte bbb = b.byteValue();
		System.out.println(bbb + "," + Byte.MAX_VALUE);
		
		Integer i =3;
		byte ib = i.byteValue();
		long l = i;
		System.out.println(ib);
		int d =5;
		Integer ii = d;
		
		System.out.println(String.valueOf(3.14));
		double dd = Double.valueOf("3.14");
		
		System.out.println(dd);
		System.out.println(Math.E);
		String a = Character.toString('a');
		System.out.println(Math.pow(1+(double)(1.0/Integer.MAX_VALUE), Integer.MAX_VALUE));
	}
}
