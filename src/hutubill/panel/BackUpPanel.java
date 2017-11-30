package hutubill.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BackUpPanel extends JPanel {
	public static BackUpPanel instance = new BackUpPanel();
	
	public JButton backButton = new JButton("备份");
	
	private BackUpPanel(){
		this.add(backButton);
	}
}
