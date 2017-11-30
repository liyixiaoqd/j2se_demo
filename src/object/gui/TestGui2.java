package object.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TestGui2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);
 
        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态
        //d.setModal(true);
 
        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
        d.add(b);
        
        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 10; }
            public int getRowCount() { return 10;}
            public Object getValueAt(int row, int col) { return new Integer(row*col); }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);
        SwingWorker<?, ?> work = new SwingWorker(){

			@Override
			protected Object doInBackground() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
        	
        };
        f.add(scrollpane);
        f.setResizable(false);
        f.setVisible(true);
        d.setVisible(true);
 
    }
}
