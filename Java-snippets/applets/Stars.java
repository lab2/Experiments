package ch.codespin.java.applets;

import java.applet.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
 
class Star extends Ellipse2D.Float {
	private double dimension = 0.0f;
	private double y = 0, x = 0;
	private double velocity = 0;
	private Color color;

	public Star(int imgx, int imgy) {
		super(0.0f, 0.0f, 0.0f, 0.0f);
		this.x = -setInitialCoord(imgx);
		this.y = setInitialCoord(imgy);
		this.velocity = setVelocity();
		this.dimension = setSize();
	}

	public double setVelocity() {
		Random r = new Random();
		int i = r.nextInt(15);
		return (float) i;
	}

	public double getVelocity() {
		return this.velocity;
	}

	public double setSize() {
		if (getVelocity() >= 10)
			this.dimension = 1.7f;
		else if (getVelocity() >= 8 && getVelocity() < 10)
			this.dimension = 1.6f;
		else if (getVelocity() >= 3 && getVelocity() < 8) {
			this.dimension = 1.5f;
			this.color = new Color(173, 216, 230);
		} else {
			this.dimension = 1.4f;
			this.color = Color.gray;
		}
		return this.dimension;
	}

	public Color getColor() {
		return color;
	}

	public double getSize() {
		return this.dimension;
	}

	public double setInitialCoord(int limit) {
		int i = 0;
		Random r = null;
		try {
			r = new Random();
			i = r.nextInt(limit);
		} catch (Exception e) {
		}
		return (float) i;
	}

	public double getPosX() {
		return this.x;
	}

	public double getPosY() {
		return this.y;
	}

	public void move() {
		this.setFrame(this.x += velocity, this.y, this.getSize(), this
				.getSize());
	}
}

public class Stars extends Applet implements Runnable {
	Graphics dbg;
	Image img, dbImage;
	Star[] flake;
 
	public void init() {
		flake = new Star[140];
		this.setSize(350, 70);
		for (int i = 0; i < flake.length; i++)
			flake[i] = new Star(this.getWidth(), this.getHeight());
		setBackground(Color.BLACK);
	} 

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {

		while (true) {
			for (int i = 0; i < flake.length; i++) {
				flake[i].move();
				if (flake[i].getPosX() >= this.getWidth()) {
					flake[i] = new Star(this.getWidth(), this.getHeight());
				}
			}
			repaint();
			try {
				Thread.sleep(90);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		for (int i = 0; i < flake.length; i++) {
			if (flake[i].getColor() == null)
				g2d.setColor(Color.WHITE);
			else
				g2d.setColor(flake[i].getColor());
			g2d.fill(flake[i]);
		}

	}

	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
}