package hutubill.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import hutubill.panel.*;

public class ToolButtonListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		//使用source判断优与使用文字!
		//System.out.println((JButton)e.getSource()==MainPanel.instance.bReport);
		if(e.getActionCommand() == "记一笔"){
			MainPanel.instance.workingPanel.show(RecordPanel.instance);
		}
		else if(e.getActionCommand() == "消费一览"){
			MainPanel.instance.workingPanel.show(SpendPanel.instance);
		}
		else if(e.getActionCommand() == "消费分类"){
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
		}
		else if(e.getActionCommand() == "月消费报表"){
			MainPanel.instance.workingPanel.show(ReportPanel.instance);
		}
		else if(e.getActionCommand() == "设置"){
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.refreshData();
		}
		else if(e.getActionCommand() == "备份"){
			MainPanel.instance.workingPanel.show(BackUpPanel.instance);
		}
		else if(e.getActionCommand() == "恢复"){
			MainPanel.instance.workingPanel.show(RecoverPanel.instance);
		}
	}
}
