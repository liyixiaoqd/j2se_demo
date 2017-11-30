package hutubill.startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import hutubill.frame.MainFrame;
import hutubill.panel.MainPanel;

/***
 * 主启动类
 * @author Liyixiao
 *
 */
public class BootStrap {
	public static void main(String args[]) throws Exception{
		//使用后台长进程进行开启
		SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.initShowPanel();
            }
        });
	}
}
