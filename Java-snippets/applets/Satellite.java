package ch.codespin.java.applets;

import java.awt.geom.*;
import java.util.*;

public class Satellite extends Ellipse2D.Double {
	private float dim = 2f;
	private double x = 0, y = 0;
	private double dist = 20;
	double posx = 0, posy = 0;
	double start;
	double i = 0;
	double a = 0;

	public Satellite(int x, int y) {
		super(0.0f, 0.0f, 0.0f, 0.0f);
		this.x = x;
		this.y = y;
		this.posx = setStart();
		this.posy = setStart();
		this.dist = setStart();
		this.dim = setSize();
	}

	public int go() {
		Random r = new Random();
		int i = r.nextInt(4) + 1;
		return i;
	}

	public double setStart() {
		Random r = new Random();
		int i = r.nextInt(200) + 1;
		start = i;
		return i;
	}

	public double getStart() {
		return start;
	}

	public double getYPos() {
		double yp = Math.toRadians(posy);
		if (posy >= 360)
			posy = 0;
		else
			posy += 1;
		return this.y + (Math.cos(yp) * 90);
	}

	public double getXPos() {
		double xp = Math.toRadians(posx);
		if (posx >= 360)
			posx = 0;
		else
			posx += 1;
		return this.x + (Math.sin(xp) * 90);
	}

	public float setSize() {
		return dim;
	}

	public float getSize() {
		return dim;
	}

	public float getDim() {
		return dim;
	}

	public double getDist() {
		return dist;
	}

	public void moveRight() {
		this.setFrame(getXPos() + 100, getYPos(), this.getSize(), this
				.getSize());
		i++;
	}

	public void moveLeft() {
		this.setFrame(getXPos(), getYPos() + 100, this.getSize(), this
				.getSize());
		a++;
	}

	public void move() {
		this.setFrame(getXPos(), getYPos(), this.getSize(), this.getSize());
	}

}