package hutubill.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import hutubill.listener.ToolButtonListener;
import hutubill.util.CenterPanel;
import hutubill.util.GUIUtil;

public class MainPanel extends JPanel {
	public static MainPanel instance = new MainPanel();

	public JToolBar jtb = new JToolBar();
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();
	
	public CenterPanel workingPanel = new CenterPanel(0.8,true);
	
	private MainPanel(){
		JToolBar jtb = new JToolBar();
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category1.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
        
		jtb.add(bSpend);
		jtb.add(bRecord);
		jtb.add(bCategory);
		jtb.add(bReport);
		jtb.add(bConfig);
		jtb.add(bBackup);
		jtb.add(bRecover);
		//不可拖动工具栏
		jtb.setFloatable(false);

		
		setLayout(new BorderLayout());
        
        add(jtb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
//        workingPanel = new CenterPanel(1.0);
//        add(workingPanel, BorderLayout.CENTER);
//        workingPanel.show(SpendPanel.instance);
        
        AddListener();
	}
	
	public void AddListener(){
		ToolButtonListener listener = new ToolButtonListener();
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}
	
	public void initShowPanel(){
		workingPanel.show(SpendPanel.instance);
	}
	
	public static void main(String args[]){
		GUIUtil.showPanel(MainPanel.instance, 1);
	}
}
