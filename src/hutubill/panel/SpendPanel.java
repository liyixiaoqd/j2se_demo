package hutubill.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import hutubill.util.GUIUtil;

public class SpendPanel extends JPanel{
	public static SpendPanel instance = new SpendPanel();

    public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthLeft = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMonthLeftDay = new JLabel("距离月末");
 
    public JLabel vMonthSpend = new JLabel("￥2300");
    public JLabel vTodaySpend = new JLabel("￥25");
    public JLabel vAvgSpendPerDay = new JLabel("￥120");
    public JLabel vMonthAvailable = new JLabel("￥2084");
    public JLabel vDayAvgAvailable = new JLabel("￥389");
    public JLabel vMonthLeftDay = new JLabel("15天");
 
	
	//私有构造函数 -- 为了单例
	private SpendPanel(){
		GUIUtil.setColor(Color.BLUE, vMonthSpend,vTodaySpend);
		this.setLayout(new BorderLayout());
		//主体分为2部分 中 和 下
		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}
	
	private JPanel center(){
		JPanel center = new JPanel();
		
		center.setLayout(new BorderLayout());
        JPanel center_left = new JPanel();
        center_left.setLayout(new GridLayout(4, 1));
        center_left.add(lMonthSpend);
        center_left.add(vMonthSpend);
        center_left.add(lTodaySpend);
        center_left.add(vTodaySpend);
        center.add(center_left, BorderLayout.WEST);
        
        JPanel center_center = new JPanel();
        JProgressBar jpb = new JProgressBar();
        jpb.setMaximum(100);
        jpb.setValue(20);
        jpb.setStringPainted(true);
        jpb.setForeground(Color.RED);
        center_center.add(jpb,BorderLayout.CENTER);
        center.add(center_center, BorderLayout.CENTER);
        
		
		return center;
	}
	
	private JPanel south(){
		JPanel south = new JPanel();
		
		south.setLayout(new GridLayout(2, 4));
		south.add(lAvgSpendPerDay);
		south.add(lMonthLeft);
		south.add(lDayAvgAvailable);
		south.add(lMonthLeftDay);
		south.add(vAvgSpendPerDay);
		south.add(vMonthAvailable);
		south.add(vDayAvgAvailable);
		south.add(vMonthLeftDay);
		
		return south;
	}
	
	public static void main(String args[]){
		GUIUtil.showPanel(SpendPanel.instance, 0.8);
	}
}
