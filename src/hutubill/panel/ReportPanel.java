package hutubill.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hutubill.util.GUIUtil;

public class ReportPanel extends JPanel {
	public static ReportPanel instance = new ReportPanel();
	
	private ReportPanel(){
		this.add(new JLabel("此处需要使用char第三方包生成柱状图"));
	}
	
	public static void main(String args[]){
		GUIUtil.showPanel(ReportPanel.instance, 0.8);
	}
}
