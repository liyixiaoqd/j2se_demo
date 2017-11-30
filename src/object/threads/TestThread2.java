package object.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestThread2 {
	public static void main(String args[]) {
		final String sRange = getRange();
		final char[] cs = sRange.toCharArray();
		final String key = getRandomByRange(3, sRange);
		System.out.println("密码:" + key);
		
		final List<String> tryList = Collections.synchronizedList(new ArrayList<String>());
		
		Thread d = new Thread(){
			@Override
			public void run(){
				while(true){
					if(tryList.isEmpty()){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
						System.out.println("已匹配:"+ tryList.remove(0));
				}
			}
		};
		d.setDaemon(true);
		d.start();
		
		Thread t = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < cs.length; i++) {
					for (int j = 0; j < cs.length; j++) {
						for (int h = 0; h < cs.length; h++) {
							if (cs[i] == key.charAt(0) && cs[j] == key.charAt(1)
									&& cs[h] == key.charAt(2)) {
								System.out.format("match key [%c][%c][%c]\n", cs[i], cs[j],
										cs[h]);
								return;
							}
							else{
								tryList.add(String.valueOf(new char[]{cs[i],cs[j],cs[h]}));
							}
						}
					}
				}
			}
		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end===================================== and sleep");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end===================================== and sleep");
	}

	public static String getRange() {
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
		return sRange;
	}

	public static String getRandomByRange(int length, String sRange) {
		String str = "0";
		// System.out.println(sRange);
		for (int i = 1; i < length; i++) {
			str += sRange.charAt((int) (Math.random() * 100 % sRange.length()));
		}
		return str;
	}
}
