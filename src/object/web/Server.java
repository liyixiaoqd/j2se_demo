package object.web;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
	public static void main(String args[]){
	       try {
	    	   
	            ServerSocket ss = new ServerSocket(8888);
	 
	            System.out.println("监听在端口号:8888");
	            Socket s = ss.accept();
	 
	            InputStream is = s.getInputStream();
	            DataInputStream dis = new DataInputStream(is);
	            OutputStream os = s.getOutputStream();
	            DataOutputStream dos = new DataOutputStream(os);
	 
	            while(true){
	            	System.out.println("wait reciver");
	            	System.out.println("收到客户端信息"+dis.readUTF());
	            }
//	            String str;
//	            while ((str=dis.readUTF())!=null) {
//	                System.out.println("收到客户端信息"+str);
////	                Scanner sc = new Scanner(System.in);
////	                String str = sc.next();
////	                dos.writeUTF(str);
//	            }
	 
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    }
}
