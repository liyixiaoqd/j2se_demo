package hutubill.util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {
	private final static String imageFolder = "./source/pic";

	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (text.length() == 0) {
			JOptionPane.showMessageDialog(null, input + " 不能为空");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	public static boolean checkNumber(JTextField tf, String input) {
		if (!checkEmpty(tf, input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, input + " 请输入整数");
			tf.grabFocus();
			return false;
		}

		return true;
	}

	public static void setImageIcon(JButton jbutton, String fileName, String tips) {
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		jbutton.setIcon(i);
		jbutton.setPreferredSize(new Dimension(61, 81));
		jbutton.setToolTipText(tips);
		jbutton.setVerticalTextPosition(JButton.BOTTOM);
		jbutton.setHorizontalTextPosition(JButton.CENTER);
		jbutton.setText(tips);
	}

	public static void setColor(Color c, JComponent... jcs) {
		for (JComponent jc : jcs) {
			jc.setForeground(c);
		}
	}

	public static void showPanel(JPanel jpanel, double strechRate) {
		JFrame jf = new JFrame();
		jf.setSize(500, 400);
		jf.setTitle("糊涂账");
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CenterPanel cp = new CenterPanel(strechRate, true);
		// 如不适用show方法,需要指定布局方式
		// cp.setLayout(new FlowLayout());
		// cp.add(jpanel);
		jf.setContentPane(cp);
		jf.setVisible(true);
		cp.show(jpanel);
	}
}
