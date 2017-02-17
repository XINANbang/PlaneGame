package cn.edu.swu.chb.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import cn.edu.swu.chb.tool.Constant;
import cn.edu.swu.chb.tool.GameUtil;
/**
 * 子弹类
 * @author chb2013xinan
 *
 */
public class Bullet {
	private double x,y;
	private boolean isPlayer=false;
	private double width=Constant.BUULETWIDTH;
	private double height=Constant.BUULETHEIGHT;
	private double speed=Constant.BULLETSPEED;
	public static Image img=GameUtil.getImage("image/bullet.png");
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	
	public Bullet() {
	}
	
	public Bullet(double x,double y,boolean isPlayer) {
		this.x=x;
		this.y=y;
		this.isPlayer=isPlayer;
	}
	/**
	 * 获取矩形
	 * @return
	 */
	public Rectangle getRect(){
		Rectangle r=new Rectangle((int)x,(int)y,(int)width,(int)height);
		return r;
	}

	/**
	 * 绘制子弹
	 * @param g
	 */
	public void draw(Graphics g){
		Color c=g.getColor();
		if(isPlayer)
			g.setColor(Color.ORANGE);
		else
			g.setColor(Color.RED);
		g.fillOval((int)x, (int)y, (int)width, (int)height);
		//g.drawImage(img,(int)x, (int)y, null);
		if (isPlayer) 
			y-=speed;
		else
			y+=speed;
		g.setColor(c);
		
	}
}
