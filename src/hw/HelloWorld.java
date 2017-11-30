package hw;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		byte b = 5;
		int i1 = 10;
		int i2 = 300;
		b = (byte) i1;
		System.out.println(b);
		b=(byte) i2;
		System.out.println(b);
		System.out.println(Integer.toBinaryString(i2));
		
		short s1 = 3;
		short s2 = 4;
		short s3 = (short) (s1+s2);	//精度小于int的数值运算的时候都回被自动转换为int后进行计算
		System.out.println(s3);
		
		int _$_;
		int $_$;
		int $123b_;
		
        {            //子块
            int j = 6;
            System.out.println(j); //可以访问j
        }
	}
}
