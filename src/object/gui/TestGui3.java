package object.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileFilter;

public class TestGui3 {
	public static void main(String args[]){
		final JFrame f = new JFrame("LOL");
		f.setSize(200, 200);
		f.setLayout(new FlowLayout());
		
		JButton jb1 = new JButton("hero1");
		JButton jb2 = new JButton("hero2");
		f.add(jb1);
		f.add(jb2);
		f.add(new JButton("hero1"));
		
		String[] heros = new String[] { "卡特琳娜", "库奇" };
        JComboBox<String> cb = new JComboBox<String>(heros);
        cb.setSelectedItem(heros[1]);
        f.add(cb);


        JProgressBar pb = new JProgressBar();
        
        //进度条最大100
        pb.setMaximum(100);
        //当前进度是50
        pb.setValue(30);
        //显示当前进度
        pb.setStringPainted(true);
 
        f.add(pb);

        final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
             
            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return ".txt";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }
        });
        jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fc.showSaveDialog(f);
				File file = fc.getSelectedFile();
				JOptionPane.showMessageDialog(f, "选择文件为:"+file.getAbsolutePath());
			}
        	
        });
        
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
        int option = JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
        if (JOptionPane.OK_OPTION == option) {
            String answer = JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
            if ("yes".equals(answer))
                JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
            else{
            	//cb.setVisible(false);
            	cb.setSelectedIndex(0);
            	cb.grabFocus();
            }
        }		
	}
}
