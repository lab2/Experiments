package ch.codespin.java.applets;

import java.applet.*;
import java.awt.*;

public class Kepler extends Applet implements Runnable {
	Graphics dbg;
	Image img, dbImage;
	Satellite asteroid[];

	public void init() {
		asteroid = new Satellite[300];
		for (int i = 0; i < asteroid.length; i++)
			asteroid[i] = new Satellite(300, 200);
		setBackground(Color.BLACK);
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		while (true) {

			for (int i = 0; i < asteroid.length; i++)
				asteroid[i].move();

			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		this.setSize(600, 410);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLUE);
		GradientPaint gp = new GradientPaint(28.0f, 30.0f, Color.DARK_GRAY,
				75.0f, 30.0f, Color.WHITE, true);
		g2d.setPaint(gp);

		g2d.setColor(Color.WHITE);

		for (int i = 0; i < asteroid.length; i++)
			g2d.fill(asteroid[i]);

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
