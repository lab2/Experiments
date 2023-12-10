package ch.codespin.java.map;

import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Node extends Ellipse2D.Double{
	public int x=0, y=0, size=0, u=0, v=0, z=0;
	public String stringPos;

	public int tileSizeH = 18; 
	public int tileSizeV = 9;
	public int tileSizeM = 7;

	
	
	public Node(int u, int v, String stringPos) {
		Random r = new Random();
		this.x = 325 + (u-v)*tileSizeH;
		this.y = 40 + (u+v)*tileSizeV;
		this.z = r.nextInt(2)*tileSizeM;
		this.stringPos = stringPos;
		this.size = 2;
	}
	
	String getStringPos(){
		return stringPos;
	}
	
	
	public int getXpos(){
		return x;
	}
	
	public int getYpos(){
		return y;
	}
	
	public int getZpos(){
		return z;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setVisible() {
		this.setFrame(getXpos(), getYpos()-getZpos(), this.getSize(), this.getSize());
	}

}
