package ch.codespin.java.applets;

import java.applet.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
 
class SnowFlake extends Ellipse2D.Float {
	private double dimension = 0.0f;
	private double y = 0, x = 0;
	private double velocity = 0;
 
	public SnowFlake(int imgx, int imgy) {
		super(0.0f, 0.0f, 0.0f, 0.0f);
		this.x = setInitialCoord(imgx);
		this.y = -setInitialCoord(imgy);
		this.velocity = setVelocity();
		this.dimension = setSize();
	}

	public double setVelocity() {
		Random r = new Random();
		int i = r.nextInt(15) + 1;
		return (float) i;
	}

	public double getVelocity() {
		return this.velocity;
	}

	public double setSize() {
		if (getVelocity() >= 10)
			this.dimension = 4.5f;
		else if (getVelocity() >= 6)
			this.dimension = 3.0f;
		else
			this.dimension = 2.0f;
		return this.dimension;
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
		this.setFrame(this.x, this.y += velocity, this.getSize(), this
				.getSize());
	}
}

	public class Snow extends Applet implements Runnable {
	Graphics dbg;
	Image img, dbImage;
	SnowFlake[] flake;

	public void init() {
		img = getImage(getCodeBase(), "200x200.jpg");
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
		}
		flake = new SnowFlake[300];
		for (int i = 0; i < flake.length; i++)
			flake[i] = new SnowFlake(img.getWidth(null), img.getHeight(null));
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {

		while (true) {
			for (int i = 0; i < flake.length; i++) {
				flake[i].move();
				if (flake[i].getPosY() >= this.getHeight()) {
					flake[i] = new SnowFlake(img.getWidth(null), img
							.getHeight(null));
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
		this.setSize(img.getWidth(null), img.getHeight(null));
		g2d.drawImage(img, 0, 0, this);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		for (int i = 0; i < flake.length; i++)
			g2d.fill(flake[i]);
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