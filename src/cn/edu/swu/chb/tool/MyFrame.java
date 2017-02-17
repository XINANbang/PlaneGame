package cn.edu.swu.chb.tool;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window;

/**
 * 游戏窗口父类
 * @author chb2013xinan
 *
 */
public class MyFrame extends Frame{

	public MyFrame() {
		// TODO Auto-generated constructor stub
	}
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(Constant.LOCATION_X,Constant.LOCATION_Y);
		setVisible(true);
		new paintThread().start();
		/**
		 * 增加exit
		 */
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
	}
	
//	public static void main(String[] args) {
//		MyFrame f=new MyFrame();
//		f.launchFrame();
//	}
	
	/**
	 * 重绘线程
	 * @author chb2013xinan
	 *
	 */
	class paintThread extends Thread{

		@Override
		public void run() {
			while(true){
				repaint();
				try {
					sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
				
		}
		
	}


}
