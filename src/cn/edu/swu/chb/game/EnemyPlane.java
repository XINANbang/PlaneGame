package cn.edu.swu.chb.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import cn.edu.swu.chb.tool.Constant;
import cn.edu.swu.chb.tool.GameUtil;

public class EnemyPlane extends Plane{
 
	public double speed=Constant.ENEMYSPEED;
	public EnemyPlane() {
		super();
	}
	public EnemyPlane(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public EnemyPlane(String path,int x,int y){
		this(x,y);
		this.img=GameUtil.getImage(path);
	}
	
	public EnemyPlane(Image img,int x,int y){
		this(x,y);
		this.img=img;
	}

	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y,null);	
//		for(int i=1;i<bulletNum;i++)
//		{
//			Bullet bullet=(Bullet)bulletList.get(i);
//			bullet.draw(g);
//		}
		if(Math.random()*1000>=900){
			Bullet bullet=new Bullet(x+img.getWidth(null)/2-5,y+img.getHeight(null),false);
			bulletList.add(bullet);
			bulletNum++;
			//if(Math.random()*10>=7)
			{
				x=Math.random()*Constant.GAME_WIDTH;
				y=Math.random()*Constant.GAME_HEIGHT/2;
				/*if(Math.random()*10>=5)
				{
					x+=speed;
					if(x<0) x=0;
					if(x>Constant.GAME_WIDTH) x=Constant.GAME_WIDTH;
				}else{
					x-=speed;
					if(x<0) x=0;
					if(x>Constant.GAME_WIDTH) x=Constant.GAME_WIDTH;					
				}
				if(Math.random()*10>=5)
				{
					y+=speed;
					if(y<0) y=0;
					if(y>Constant.GAME_HEIGHT) y=Constant.GAME_HEIGHT;
				}else{
					y-=speed;
					if(y<0) y=0;
					if(y>Constant.GAME_HEIGHT) y=Constant.GAME_HEIGHT;
				}*/
				//System.out.println("***************");
			}
		}
		move();
	}
	public void move(){
		super.move();
	}
	
}
