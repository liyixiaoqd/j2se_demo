package hutubill.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import hutubill.listener.ConfigListener;
import hutubill.service.ConfigService;

public class ConfigPanel extends JPanel{
	public static ConfigPanel instance = new ConfigPanel();
	
    public JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField("0");
     
    public JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");
 
	public JButton updateButton = new JButton("更新");
	
	private ConfigPanel(){
		this.setLayout(new BorderLayout());
		JPanel center_panel = new JPanel();
		center_panel.setLayout(new GridLayout(4,1,40,40));
		center_panel.add(lBudget);
		center_panel.add(tfBudget);
		center_panel.add(lMysql);
		center_panel.add(tfMysqlPath);
		
		this.add(center_panel, BorderLayout.NORTH);
		
		JPanel center_center = new JPanel();
		center_center.add(updateButton);
		this.add(center_center,BorderLayout.CENTER);
		
		addListener();
	}
	
	public void addListener(){
		ConfigListener l  = new ConfigListener();
		updateButton.addActionListener(l);

	}
	
	public void refreshData(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ConfigService cs= new ConfigService();
				tfBudget.setText(cs.get(ConfigService.budget));
				tfMysqlPath.setText(cs.get(ConfigService.mysqlPath));
			}
		});
	}
}
