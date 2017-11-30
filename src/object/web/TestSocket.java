package object.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSocket {
	public static void main(String args[]) {
		InetAddress host;
		try {
			host = InetAddress.getLocalHost();
			String ip = host.getHostAddress();
			System.out.println("本机ip地址：" + ip + " ; " + host.getHostName());
			
			Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
			String line;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
