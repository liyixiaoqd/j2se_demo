package hutubill.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import hutubill.panel.ConfigPanel;
import hutubill.service.ConfigService;
import hutubill.util.GUIUtil;

public class ConfigListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		ConfigPanel p = ConfigPanel.instance;
		GUIUtil.checkNumber(p.tfBudget, p.lBudget.getText());
		
		
		ConfigService cs= new ConfigService();
		cs.update(ConfigService.budget, p.tfBudget.getText());
		
		JOptionPane.showMessageDialog(p, "设置修改成功");
	}

}
