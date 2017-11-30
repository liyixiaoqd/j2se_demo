package object;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class StreamTest {
	public static void main(String args[]) {
		try {
			File f = new File("test.txt");
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeBoolean(true);
			dos.writeInt(3);
			
			dos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readBoolean() +","+ dis.readBoolean());
			dis.close();
			fis.close();
			
			FileWriter fw = new FileWriter(f);
			PrintWriter bw = new PrintWriter(fw);
			bw.write("31&51");
			bw.write("61\n");
			bw.write("99999\n");
			
			bw.close();
			fw.close();
			
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			char c[] = new char[(int) f.length()];
			br.read(c);
			System.out.println(c);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 控制台输入
		try (InputStream is = System.in;) {
			while (true) {
				// 敲入a,然后敲回车可以看到
				// 97 13 10
				// 97是a的ASCII码
				// 13 10分别对应回车换行
				int i = is.read();
				System.out.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
