package object.practice;

public class StringTest {
	public static void main(String args[]) {
		System.out.println(getRandomStr(5));
		System.out.format("%s", "===================\n");
		String s_array[] = new String[8];
		for (int i = 0; i < s_array.length; i++) {
			s_array[i] = getRandomStr(5);
			System.out.println(s_array[i]);
		}

		System.out.format("%s", "========sort=======\n");
		for (int i = 0; i < s_array.length; i++) {
			for (int j = i; j < s_array.length; j++) {
				if (s_array[i].compareToIgnoreCase(s_array[j]) > 1) {
					String tmp = s_array[i];
					s_array[i] = s_array[j];
					s_array[j] = tmp;
				}
			}
		}
		for (String s : s_array) {
			System.out.println(s);
		}

		System.out.format("%s", "===================\n");
		String key = getRandomStr(3);
		System.out.format("key is %s\n", key);

		String sRange = "";
		for (short i = '0'; i <= '9'; i++) {
			sRange += (char) i;
		}
		for (short i = 'a'; i <= 'z'; i++) {
			sRange += (char) i;
		}
		for (short i = 'A'; i <= 'Z'; i++) {
			sRange += (char) i;
		}
		int run_time = 0;
		for (int i = 0; i < sRange.length(); i++) {
			for (int j = 0; j < sRange.length(); j++) {
				for (int h = 0; h < sRange.length(); h++) {
					run_time++;
					if (sRange.charAt(i) == key.charAt(0) && sRange.charAt(j) == key.charAt(1)
							&& sRange.charAt(h) == key.charAt(2)) {
						System.out.format("match key [%c][%c][%c] and run time [%d]\n", sRange.charAt(i),
								sRange.charAt(j), sRange.charAt(h), run_time);
						break;
					}
				}
			}
		}
		
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";
        
        //截取从第3个开始的字符串 （基0）
        String subString1 = sentence.substring(3); 
         
        System.out.println(subString1);
         
        //截取从第3个开始的字符串 （基0）
        //到5-1的位置的字符串 
        //左闭右开
        String subString2 = sentence.substring(3,5); 
         
        System.out.println(subString2);
        
        System.out.println("let there be light".toUpperCase());
        String s1="peter piper picked a peck of pickled peppers";
        int s1_tj=0;
        for(String s:s1.split(" ")){
        	if(s.charAt(0)=='p'){
        		s1_tj++;
        	}
        }
        System.out.println(s1_tj);
        
        String s2="lengendary";
        for(int i=0;i<s2.length();i++){
        	if(i%2==0)
        		System.out.print(s2.charAt(i));
        	else
        		System.out.print(Character.toUpperCase(s2.charAt(i)));
        }
        System.out.println("");

        String str1 = "the light";
        
        String str2 = new String(str1);
         
        //==用于判断是否是同一个字符串对象
        System.out.println( str1  ==  str2);
        
        String str4 = "the light";
        String str3 = "the light";
        System.out.println( str4  ==  str3);
        
        String s_array1[]=new String[100];
        for(int i=0;i<s_array1.length;i++){
        	s_array1[i] = getRandomStr(2);
        	System.out.print(s_array1[i]+" ");
        	if((i+1)%20==0){
                System.out.println("");
        	}
        }
        System.out.println("======= compare =======");
        for(int i=0;i<s_array1.length;i++){
        	for(int j=i+1;j<s_array1.length;j++){
        		if(s_array1[i].equals(s_array1[j])){
        			System.out.print(s_array1[i]+" ");
        			break;
        		}
        	}
        }
        System.out.println("");
        
        String str11 = "the";
        
        StringBuffer sb = new StringBuffer(str11);
         
        System.out.println(sb.length()); //内容长度
         
        System.out.println(sb.capacity());//总空间
	}

	public static String getRandomStr(int length) {
		String str = "";
		String sRange = "";
		for (short i = '0'; i <= '9'; i++) {
			sRange += (char) i;
		}
		for (short i = 'a'; i <= 'z'; i++) {
			sRange += (char) i;
		}
		for (short i = 'A'; i <= 'Z'; i++) {
			sRange += (char) i;
		}
		// System.out.println(sRange);
		for (int i = 0; i < length; i++) {
			str += sRange.charAt((int) (Math.random() * 100 % sRange.length()));
		}
		return str;
	}
}
