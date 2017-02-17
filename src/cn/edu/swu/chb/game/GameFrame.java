package cn.edu.swu.chb.game;

//import java.awt.Button;
//import java.awt.Dialog;
//import java.awt.Label;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.edu.swu.chb.tool.Constant;
import cn.edu.swu.chb.tool.GameUtil;
import cn.edu.swu.chb.tool.MyFrame;

public class GameFrame extends MyFrame {
	
	Image img=GameUtil.getImage("image/bg.jpg");
	Plane p=new Plane("image/plane.png",300,500);
	EnemyPlane ep=new EnemyPlane("image/enemyplane.png",50,50);
	Explo bong=new Explo();
	
	@Override
	public void launchFrame() {
        super.launchFrame();
		addKeyListener(new KeyMoniter());
		
	}

	
	@Override
	public void paint(Graphics g) {
		//g.drawImage(img, 50, 50, null);
		g.drawImage(img, 0, 0, null);
		if(p.isLive)
			p.draw(g);
		if(ep.isLive)
			ep.draw(g);
		for(int i=0;i<ep.bulletNum;i++)
		{
			Bullet bullet=(Bullet)ep.bulletList.get(i);
     		bullet.draw(g);	
     		if( bullet.getRect().intersects(p.getRect()) )
     		{
     			System.out.println("!!!!!!!!!!bong!!!!!!!!!!");
     			p.isLive=false;
     			bong.draw(g, p.x, p.y);
     			
//   			Label lab = new Label("GAME OVER");     		
//     			Button okBut = new Button("确定");
//     			Dialog d = new Dialog(this, "提示信息-self", true);
//     			d.setBounds(400, 200, 350, 150);
//     			d.setLayout(new FlowLayout());
//     			d.add(lab);
//     			d.add(okBut); 			
//     			d.setVisible(true);
   			
     		}	
		}
		for(int i=1;i<p.bulletNum;i++)
		{
			Bullet bullet=(Bullet)p.bulletList.get(i);
			bullet.draw(g);
			if( bullet.getRect().intersects(ep.getRect()) )
     		{
     			System.out.println("!!!!!!!!!!bong!!!!!!!!!!");
     			ep.isLive=false;
     			bong.draw(g, ep.x, ep.y);
     			
//     			Button okBut = new Button("确定");
//     			Label lab = new Label("GAME OVER");
//     			Dialog d = new Dialog(this, "提示信息-self", true);
//     			d.setBounds(400, 200, 350, 150);
//     			d.setLayout(new FlowLayout());
//     			d.add(lab);
//     			d.add(okBut);
//     			d.setVisible(true);

     		}	
		}
		
	}
	

	private Image offScreenImage=null;
	public void update(Graphics g){
		if (offScreenImage==null)
			offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0,null);
	}
	
	
	/**
	 * 内部类，监听键盘
	 * @author chb2013xinan
	 *
	 */
	class KeyMoniter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			p.doKeyDown(e);
			System.out.println("in"+e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
            p.doKeyUp(e);
			System.out.println("out"+e.getKeyCode());

		}
		
	}

	public static void main(String args[]){
		GameFrame f=new GameFrame();
		f.launchFrame();
	}

}
