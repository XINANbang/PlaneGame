package cn.edu.swu.chb.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import cn.edu.swu.chb.tool.Constant;
import cn.edu.swu.chb.tool.GameUtil;

public class Plane {
	public double x,y;
	public double speed=Constant.PLAYSPEED;
	public int bulletNum=0;
	public boolean isLive=true;
	Image img;
	public boolean left,right,up,down,beat;
	ArrayList bulletList=new ArrayList();
	
	
	public Plane() {
	}
	public Plane(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public Plane(String path,int x,int y){
		this(x,y);
		this.img=GameUtil.getImage(path);
	}
	
	public Plane(Image img,int x,int y){
		this(x,y);
		this.img=img;
	}
	
	/**
	 * 绘制飞机
	 * @param g
	 */
	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y,null);	
//		for(int i=1;i<bulletNum;i++)
//		{
//			Bullet bullet=(Bullet)bulletList.get(i);
//			bullet.draw(g);
//			
//		}
		move();
	}
	/**
	 * 飞机移动
	 */
	public void move(){
		if (left)
			x-=speed;
		if (right)
			x+=speed;
		if (up)
			y-=speed;
		if (down)
			y+=speed;
		if(beat){
				//Bullet bullet=new Bullet(x+img.getWidth(null)/2-Bullet.img.getWidth(null)/2,y);
				Bullet bullet=new Bullet(x+img.getWidth(null)/2-5,y,true);
				bulletList.add(bullet);
				bulletNum++;
		}
	}
	
	/**
	 * 获取矩形
	 * @return
	 */
	public Rectangle getRect(){
		Rectangle r=new Rectangle((int)x,(int)y,img.getWidth(null),img.getHeight(null));
		return r;
	}
	

	/**
	 * 按下键盘按键
	 * @param e
	 */
	public void doKeyDown(KeyEvent e){
//		if(e.getKeyCode()==32)
//		{
//			//Bullet bullet=new Bullet(x+img.getWidth(null)/2-Bullet.img.getWidth(null)/2,y);
//			Bullet bullet=new Bullet(x+img.getWidth(null)/2-5,y,true);
//			bulletList.add(bullet);
//			bulletNum++;
//		}
		switch (e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		case 32:
			beat=true;
			break;
		default:
			break;
		
		}
	}
	
	/**
	 * 松开键盘按键
	 * @param e
	 */
	public void doKeyUp(KeyEvent e){
		switch (e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		case 32:
			beat=false;
			break;
		default:
			break;
		
		}		
	}
}
