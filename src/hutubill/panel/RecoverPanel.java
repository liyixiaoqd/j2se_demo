package hutubill.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RecoverPanel extends JPanel {
	public static RecoverPanel instance = new RecoverPanel();
	
	public JButton recoverButton = new JButton("恢复");
	
	private RecoverPanel(){
		this.add(recoverButton);
	}
}
