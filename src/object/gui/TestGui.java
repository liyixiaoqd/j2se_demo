package object.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGui {
	public static void main(String[] args) {
		// 主窗体
		final JFrame f = new JFrame("LoL");

		// 主窗体设置大小
		f.setSize(800, 600);

		// 主窗体设置位置
		f.setLocation(200, 200);

		// 主窗体中的组件设置为绝对定位
		f.setLayout(null);


		final JLabel l = new JLabel();

		ImageIcon i = new ImageIcon("source/pic/shana.png");
		l.setIcon(i);
		l.setBounds(80, 100, i.getIconWidth(), i.getIconHeight());
		
		l.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l.setLocation(l.getX()+10, l.getY());
			}
		});
		f.add(l);

		// 按钮组件
		final JButton b = new JButton("一键秒对方基地挂");

		// 同时设置组件的大小和位置
		b.setBounds(50, 50, 280, 30);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (l.isVisible()) {
					b.setText("change!!");
					l.setVisible(false);
				} else {
					b.setText("一键秒对方基地挂");
					l.setVisible(true);
				}
				//重新获得焦点
				f.requestFocus();	
			}
		});

		// 把按钮加入到主窗体中
		f.add(b);


		f.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == 39){
					l.setLocation(l.getX()+10, l.getY());
				}
				else if(e.getKeyCode() == 37){
					l.setLocation(l.getX()-10, l.getY());
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("release");
			}
		});
		f.setFocusable(true);
		
		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);

		Thread locationT = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.format("窗口位置(%d,%d)\n", f.getX(), f.getY());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		// locationT.setDaemon(true);
		//locationT.start();
	}
}
