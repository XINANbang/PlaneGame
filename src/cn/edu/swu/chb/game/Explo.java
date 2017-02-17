package cn.edu.swu.chb.game;

import java.awt.Graphics;
import java.awt.Image;

import cn.edu.swu.chb.tool.GameUtil;
/**
 * ±¨’®¿‡
 * @author chb2013xinan
 *
 */
public class Explo {
	private double x,y;
	private int count=0;
	static Image[] imgs=new Image[100];
	static{
		for(int i=0;i<6;i++){
			imgs[i]=GameUtil.getImage("image/"+"blast"+(i+1)+".png");
		    imgs[i].getWidth(null);
		}
	}

	public Explo() {
	}
	public Explo(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * ªÊ÷∆±¨’®
	 * @param g
	 */
	public void draw(Graphics g,double x,double y){
		if(count<6)
			g.drawImage(imgs[count], (int)x, (int)y, null);
		count++;
	}

}
