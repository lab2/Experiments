package ch.codespin.java.plasma;

import java.applet.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PlasmaThread extends Applet implements Runnable {

	Plasma plasma;
	double time = 0;
	Image backbuffer;

	public void init() {

		this.setBackground(Color.BLACK);
	}

	public void start() {

		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(backbuffer, 0, 0, this);
		time++;

		for (int h = 0; h <= 127; h++) {
			for (int v = 0; v <= 127; v++) {
				plasma = new Plasma(h, v);
				g2d.setColor(new Color(32,32,new Double(plasma.getColor(time))
						.intValue()));
				g2d.fill(new Rectangle2D.Double(h, v, 1, 1));
			}
		}

	}
}
