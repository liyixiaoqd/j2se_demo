package hutubill.frame;

import javax.swing.JFrame;

import hutubill.panel.MainPanel;

public class MainFrame extends JFrame{
	public static MainFrame instance = new MainFrame();
			
	public MainFrame(){
		setSize(500,400);
		setTitle("糊涂账");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(MainPanel.instance);
	}
	
	
	public static void main(String args[]){
		MainFrame.instance.setVisible(true);
	}
}
