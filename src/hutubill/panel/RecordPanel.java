package hutubill.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import hutubill.model.CategoryModel;
import hutubill.util.GUIUtil;

public class RecordPanel extends JPanel {
	public static RecordPanel instance = new RecordPanel();
	
    public JLabel lSpend = new JLabel("花费(￥)");
    public JLabel lCategory = new JLabel("分类");
    public JLabel lComment = new JLabel("备注");
    public JLabel lDate = new JLabel("日期");
    
    public JTextField vSpend = new JTextField(0);
    public JComboBox<String> vCategory;
    public JTextField vComment = new JTextField();
    public JXDatePicker vDate = new JXDatePicker(new Date());
    public JButton addButton = new JButton("记一笔");
			
	private RecordPanel(){
		this.setLayout(new BorderLayout());
		//主体分为2部分 中 和 下
		JPanel center_panel = new JPanel();
		center_panel.setLayout(new GridLayout(4,2,40,40));
		center_panel.add(lSpend);
		center_panel.add(vSpend);
		center_panel.add(lCategory);
		vCategory = new JComboBox<String>(CategoryModel.categorys);
		center_panel.add(vCategory);
		center_panel.add(lComment);
		center_panel.add(vComment);
		center_panel.add(lDate);
		center_panel.add(vDate);
		
		this.add(center_panel, BorderLayout.CENTER);
		this.add(addButton, BorderLayout.SOUTH);
	}
	
	public static void main(String args[]){
		GUIUtil.showPanel(RecordPanel.instance, 0.8);
	}
}
