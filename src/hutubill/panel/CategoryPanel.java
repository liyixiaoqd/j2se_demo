package hutubill.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import hutubill.model.CategoryModel;
import hutubill.util.GUIUtil;

public class CategoryPanel extends JPanel  {
	public static CategoryPanel instance = new CategoryPanel();
	
	public JButton addButton = new JButton("新增");
	public JButton updateButton = new JButton("修改");
	public JButton delButton = new JButton("删除");
	
	private CategoryPanel(){
		this.setLayout(new BorderLayout());
		
		JTable t = new JTable(CategoryModel.getTableCount(), CategoryModel.TableColumnNames);
		JScrollPane center_panel = new JScrollPane(t);
		this.add(center_panel, BorderLayout.CENTER);
		
		JPanel south_panel = new JPanel();
		south_panel.add(addButton);
		south_panel.add(updateButton);
		south_panel.add(delButton);
		this.add(south_panel,BorderLayout.SOUTH);
	}
	
	public static void main(String args[]){
		GUIUtil.showPanel(CategoryPanel.instance, 0.8);
	}
}
